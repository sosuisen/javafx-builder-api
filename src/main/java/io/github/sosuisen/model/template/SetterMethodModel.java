package io.github.sosuisen.model.template;

import io.github.sosuisen.model.data.ClassMetadata;

/**
 * Data model for setter method JTE template
 */
public record SetterMethodModel(
        String builderClassNameWithTypeParameter,
        String methodName,
        String parameterList,
        String parameterTypeList,
        String argumentList,
        String originalClassName,
        String originalMethodName,
        String methodAnnotation) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ClassMetadata classMetadata;
        private String methodName;
        private String parameterList;
        private String parameterTypeList;
        private String argumentList;
        private String originalMethodName;
        private String methodAnnotation;

        public Builder classMetadata(ClassMetadata classMetadata) {
            this.classMetadata = classMetadata;
            return this;
        }

        public Builder methodName(String methodName) {
            this.methodName = methodName;
            return this;
        }

        public Builder parameterList(String parameterList) {
            this.parameterList = parameterList;
            return this;
        }

        public Builder parameterTypeList(String parameterTypeList) {
            this.parameterTypeList = parameterTypeList;
            return this;
        }

        public Builder argumentList(String argumentList) {
            this.argumentList = argumentList;
            return this;
        }

        public Builder originalMethodName(String originalMethodName) {
            this.originalMethodName = originalMethodName;
            return this;
        }

        public Builder methodAnnotation(String methodAnnotation) {
            this.methodAnnotation = methodAnnotation;
            return this;
        }

        public SetterMethodModel build() {
            if (classMetadata == null || methodName == null || parameterList == null ||
                    parameterTypeList == null || argumentList == null || originalMethodName == null) {
                throw new IllegalStateException(
                        "classMetadata, methodName, parameterList, parameterTypeList, argumentList, and originalMethodName are required");
            }

            return new SetterMethodModel(
                    classMetadata.builderClassNameWithTypeParameter(),
                    methodName,
                    parameterList,
                    parameterTypeList,
                    argumentList,
                    classMetadata.getClassName(),
                    originalMethodName,
                    methodAnnotation != null ? methodAnnotation : "");
        }
    }
}