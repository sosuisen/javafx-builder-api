package io.github.sosuisen.template;

import io.github.sosuisen.model.ClassMetadata;

/**
 * Data model for constructor method JTE template
 */
public record CreateMethodModel(
        String typeParameters,
        String typeParametersWithExtends,
        String builderClassNameWithTypeParameter,
        String builderClassName,
        boolean isDefaultConstructor,
        String parameterList,
        String argumentList,
        boolean isVarArgs) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ClassMetadata classMetadata;
        private String parameterList;
        private String argumentList;
        private boolean isVarArgs;

        public Builder classMetadata(ClassMetadata classMetadata) {
            this.classMetadata = classMetadata;
            return this;
        }

        public Builder parameterList(String parameterList) {
            this.parameterList = parameterList;
            return this;
        }

        public Builder argumentList(String argumentList) {
            this.argumentList = argumentList;
            return this;
        }

        public Builder isVarArgs(boolean isVarArgs) {
            this.isVarArgs = isVarArgs;
            return this;
        }

        public CreateMethodModel buildDefault() {
            if (classMetadata == null) {
                throw new IllegalStateException("classMetadata is required");
            }

            return new CreateMethodModel(
                    classMetadata.getTypeParameters(),
                    classMetadata.gettypeParametersWithExtends(),
                    classMetadata.builderClassNameWithTypeParameter(),
                    classMetadata.getBuilderClassName(),
                    true,
                    "",
                    "",
                    false);
        }

        public CreateMethodModel buildParameterized() {
            if (classMetadata == null || parameterList == null || argumentList == null) {
                throw new IllegalStateException("classMetadata, parameterList, and argumentList are required for parameterized constructor");
            }

            return new CreateMethodModel(
                    classMetadata.getTypeParameters(),
                    classMetadata.gettypeParametersWithExtends(),
                    classMetadata.builderClassNameWithTypeParameter(),
                    classMetadata.getBuilderClassName(),
                    false,
                    parameterList,
                    argumentList,
                    isVarArgs);
        }
    }

    // Keep the old create methods for backward compatibility (deprecated)
    @Deprecated
    public static CreateMethodModel createDefault(
            String typeParameters,
            String typeParametersWithExtends,
            String builderClassNameWithTypeParameter,
            String builderClassName) {
        return new CreateMethodModel(
                typeParameters,
                typeParametersWithExtends,
                builderClassNameWithTypeParameter,
                builderClassName,
                true,
                "",
                "",
                false);
    }

    @Deprecated
    public static CreateMethodModel createParameterized(
            String typeParameters,
            String typeParametersWithExtends,
            String builderClassNameWithTypeParameter,
            String builderClassName,
            String parameterList,
            String argumentList,
            boolean isVarArgs) {
        return new CreateMethodModel(
                typeParameters,
                typeParametersWithExtends,
                builderClassNameWithTypeParameter,
                builderClassName,
                false,
                parameterList,
                argumentList,
                isVarArgs);
    }
}