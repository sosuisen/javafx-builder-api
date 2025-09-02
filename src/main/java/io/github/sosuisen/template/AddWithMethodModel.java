package io.github.sosuisen.template;

import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.sosuisen.mapper.TypeMappingManager;
import io.github.sosuisen.parser.ConstructorParser;

/**
 * Data model for add/with method JTE template (supports both Items and Menus)
 */
public record AddWithMethodModel(
        String builderClassNameWithTypeParameter,
        String observableListTypeParameter,
        String typeParametersExtends,
        String addMethodName,
        String withMethodName,
        String getterMethodName,
        String originalClassName) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String getterMethodName;
        private Class<?> targetClass;
        private String builderClassName;
        private String typeParameters;
        private String typeParametersExtends;

        public Builder getterMethodName(String getterMethodName) {
            this.getterMethodName = getterMethodName;
            return this;
        }

        public Builder targetClass(Class<?> targetClass) {
            this.targetClass = targetClass;
            return this;
        }

        public Builder builderClassName(String builderClassName) {
            this.builderClassName = builderClassName;
            return this;
        }

        public Builder typeParameters(String typeParameters) {
            this.typeParameters = typeParameters;
            return this;
        }

        public Builder typeParametersExtends(String typeParametersExtends) {
            this.typeParametersExtends = typeParametersExtends;
            return this;
        }

        public AddWithMethodModel build() {
            if (getterMethodName == null || targetClass == null || builderClassName == null) {
                throw new IllegalStateException("getterMethodName, targetClass, and builderClassName are required");
            }

            // Calculate derived values
            String propertyName = getterMethodName.substring(3); // Remove "get"
            String addMethodName = "add" + propertyName;

            // Calculate with method name based on ignore list and constructor availability
            String withMethodName = null;
            List<String> ignoreList = List.of(
                    "getStylesheets",
                    "getTransforms",
                    "getStyleClass");
            if (!ignoreList.contains(getterMethodName) && ConstructorParser.hasDefaultConstructor(targetClass)) {
                withMethodName = "with" + propertyName;
            }

            // Extract observable list type parameter from getter method return type
            String observableListTypeParameter = null;
            try {
                Method getterMethod = targetClass.getMethod(getterMethodName);
                String returnType = getterMethod.getGenericReturnType().getTypeName();
                if (returnType.startsWith("javafx.collections.ObservableList<")) {
                    Pattern pattern = Pattern.compile("<(.+)>$");
                    Matcher matcher = pattern.matcher(returnType);
                    if (matcher.find()) {
                        observableListTypeParameter = matcher.group(1).replace("$", ".");
                        String className = targetClass.getCanonicalName();
                        observableListTypeParameter = TypeMappingManager.getReplacement(className,
                                observableListTypeParameter);
                    }
                }
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException(
                        "Method " + getterMethodName + " not found in class " + targetClass.getName(), e);
            }

            if (observableListTypeParameter == null) {
                throw new IllegalArgumentException("Method " + getterMethodName + " does not return an ObservableList");
            }

            // Calculate builder class name with type parameter
            String builderClassNameWithTypeParameter = builderClassName
                    + (typeParameters != null ? typeParameters : "");

            // Get original class name
            String originalClassName = targetClass.getCanonicalName();

            return new AddWithMethodModel(
                    builderClassNameWithTypeParameter,
                    observableListTypeParameter,
                    typeParametersExtends,
                    addMethodName,
                    withMethodName,
                    getterMethodName,
                    originalClassName);
        }
    }
}