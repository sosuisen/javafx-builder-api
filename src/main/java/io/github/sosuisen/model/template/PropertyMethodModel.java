package io.github.sosuisen.model.template;

import java.lang.reflect.Method;

import io.github.sosuisen.model.data.ClassMetadata;
import io.github.sosuisen.model.mapper.MethodAnnotationManager;
import io.github.sosuisen.model.mapper.TypeMappingManager;

/**
 * Data model for property method JTE template
 */
public record PropertyMethodModel(
        String builderClassNameWithTypeParameter,
        String methodName,
        String propertyName,
        String propertyType,
        String originalClassName,
        String methodAnnotation) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ClassMetadata classMetadata;
        private Method propertyMethod;

        public Builder classMetadata(ClassMetadata classMetadata) {
            this.classMetadata = classMetadata;
            return this;
        }

        public Builder propertyMethod(Method propertyMethod) {
            this.propertyMethod = propertyMethod;
            return this;
        }

        public PropertyMethodModel build() {
            if (classMetadata == null || propertyMethod == null) {
                throw new IllegalStateException("classMetadata and propertyMethod are required");
            }

            // Validate that this is actually a property method
            if (!propertyMethod.getName().endsWith("Property") ||
                    java.lang.reflect.Modifier.isStatic(propertyMethod.getModifiers()) ||
                    propertyMethod.getParameterCount() != 0) {
                throw new IllegalArgumentException(
                        "Method " + propertyMethod.getName() + " is not a valid property method");
            }

            String propertyName = propertyMethod.getName(); // e.g., "textProperty"
            String methodBaseName = propertyName.substring(0, propertyName.length() - 8); // Remove "Property", e.g.,
                                                                                          // "text"
            String methodName = methodBaseName + "PropertyApply"; // e.g., "textPropertyApply"

            // Get the return type of the property method with generics (e.g.,
            // StringProperty, ObservableList<Node>)
            String propertyType = propertyMethod.getGenericReturnType().getTypeName().replace("$", ".");
            // Check for type replacement
            propertyType = TypeMappingManager.getReplacement(classMetadata.getCanonicalClassName(), propertyType);

            String methodAnnotation = MethodAnnotationManager.getMethodAnnotation(
                    classMetadata.getCanonicalClassName(), propertyName);

            return new PropertyMethodModel(
                    classMetadata.builderClassNameWithTypeParameter(),
                    methodName,
                    propertyName,
                    propertyType,
                    classMetadata.getCanonicalClassName(),
                    methodAnnotation != null ? methodAnnotation : "");
        }
    }
}