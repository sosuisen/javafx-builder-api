package io.github.sosuisen.template;

/**
 * Data model for constructor method JTE template
 */
public record CreateMethodModel(
        String typeParameters,
        String typeParametersExtends,
        String builderClassNameWithTypeParameter,
        String builderClassName,
        boolean isDefaultConstructor,
        String parameterList,
        String argumentList,
        boolean isVarArgs) {

    public static CreateMethodModel createDefault(
            String typeParameters,
            String typeParametersExtends,
            String builderClassNameWithTypeParameter,
            String builderClassName) {
        return new CreateMethodModel(
                typeParameters,
                typeParametersExtends,
                builderClassNameWithTypeParameter,
                builderClassName,
                true,
                "",
                "",
                false);
    }

    public static CreateMethodModel createParameterized(
            String typeParameters,
            String typeParametersExtends,
            String builderClassNameWithTypeParameter,
            String builderClassName,
            String parameterList,
            String argumentList,
            boolean isVarArgs) {
        return new CreateMethodModel(
                typeParameters,
                typeParametersExtends,
                builderClassNameWithTypeParameter,
                builderClassName,
                false,
                parameterList,
                argumentList,
                isVarArgs);
    }
}