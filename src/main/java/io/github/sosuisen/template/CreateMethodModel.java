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
        String argumentList) {

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
                "");
    }

    public static CreateMethodModel createParameterized(
            String typeParameters,
            String typeParametersExtends,
            String builderClassNameWithTypeParameter,
            String builderClassName,
            String parameterList,
            String argumentList) {
        return new CreateMethodModel(
                typeParameters,
                typeParametersExtends,
                builderClassNameWithTypeParameter,
                builderClassName,
                false,
                parameterList,
                argumentList);
    }
}