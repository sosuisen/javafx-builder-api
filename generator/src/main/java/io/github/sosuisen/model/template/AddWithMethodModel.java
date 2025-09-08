package io.github.sosuisen.model.template;

import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.sosuisen.model.data.ClassMetadata;
import io.github.sosuisen.model.data.TypeParameter;
import io.github.sosuisen.model.mapper.TypeMappingManager;

/**
 * Data model for add/with method JTE template
 */
public record AddWithMethodModel(
    String builderClassNameWithTypeParameter,
    String observableListTypeParameter,
    String typeParametersWithExtends,
    String addMethodName,
    String withMethodName,
    String getterMethodName,
    String originalClassName,
    boolean hasWithMethod,
    boolean isSafeVarargs) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String getterMethodName;
        private ClassMetadata classMetadata;

        public Builder getterMethodName(String getterMethodName) {
            this.getterMethodName = getterMethodName;
            return this;
        }

        public Builder classMetadata(ClassMetadata classMetadata) {
            this.classMetadata = classMetadata;
            return this;
        }

        public AddWithMethodModel build() {
            if (getterMethodName == null || classMetadata == null) {
                throw new IllegalStateException("getterMethodName and classMetadata are required");
            }

            // Calculate derived values
            String propertyName = getterMethodName.substring(3); // Remove "get"
            String addMethodName = "add" + propertyName;

            // Calculate with method name based on ignore list and constructor availability
            String withMethodName = null;
            List<String> ignoreList = List.of(
                "getStylesheets",
                "getTransforms",
                "getStyleClass"
            );
            if (!ignoreList.contains(getterMethodName) && classMetadata.hasDefaultConstructor()) {
                withMethodName = "with" + propertyName;
            }

            boolean isSafeVarargs = false;

            // Extract observable list type parameter from getter method return type
            String observableListTypeParameter = null;
            try {
                Method getterMethod = classMetadata.getTargetClass().getMethod(getterMethodName);
                String returnType = getterMethod.getGenericReturnType().getTypeName();
                if (returnType.startsWith("javafx.collections.ObservableList<")) {
                    Pattern pattern = Pattern.compile("<(.+)>$");
                    Matcher matcher = pattern.matcher(returnType);
                    if (matcher.find()) {
                        observableListTypeParameter = matcher.group(1).replace("$", ".");
                        observableListTypeParameter = TypeMappingManager.getReplacement(
                            classMetadata.getCanonicalClassName(),
                            observableListTypeParameter
                        );

                        if (TypeParameter.hasTypeParameter(observableListTypeParameter)) {
                            isSafeVarargs = true;
                        }
                    }
                }
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException(
                    "Method " + getterMethodName + " not found in class "
                        + classMetadata.getCanonicalClassName(),
                    e
                );
            }

            if (observableListTypeParameter == null) {
                throw new IllegalArgumentException(
                    "Method " + getterMethodName + " does not return an ObservableList"
                );
            }

            return new AddWithMethodModel(
                classMetadata.builderClassNameWithTypeParameter(),
                observableListTypeParameter,
                classMetadata.getTypeParametersWithExtends(),
                addMethodName,
                withMethodName,
                getterMethodName,
                classMetadata.getCanonicalClassName(),
                withMethodName != null,
                isSafeVarargs
            );
        }
    }
}
