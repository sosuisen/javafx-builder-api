package io.github.sosuisen.template;

import io.github.sosuisen.model.ClassMetadata;

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
        private String methodName;
        private String propertyName;
        private String propertyType;
        private String methodAnnotation;

        public Builder classMetadata(ClassMetadata classMetadata) {
            this.classMetadata = classMetadata;
            return this;
        }

        public Builder methodName(String methodName) {
            this.methodName = methodName;
            return this;
        }

        public Builder propertyName(String propertyName) {
            this.propertyName = propertyName;
            return this;
        }

        public Builder propertyType(String propertyType) {
            this.propertyType = propertyType;
            return this;
        }

        public Builder methodAnnotation(String methodAnnotation) {
            this.methodAnnotation = methodAnnotation;
            return this;
        }

        public PropertyMethodModel build() {
            if (classMetadata == null || methodName == null || propertyName == null || propertyType == null) {
                throw new IllegalStateException(
                        "classMetadata, methodName, propertyName, and propertyType are required");
            }

            return new PropertyMethodModel(
                    classMetadata.builderClassNameWithTypeParameter(),
                    methodName,
                    propertyName,
                    propertyType,
                    classMetadata.getClassName(),
                    methodAnnotation != null ? methodAnnotation : "");
        }
    }

}