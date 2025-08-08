package io.github.sosuisen.template;

/**
 * Data model for constructor method JTE template
 */
public record ConstructorMethodModel(
    String typeParameters,
    String builderClassNameWithTypeParameter,
    String builderClassName,
    boolean isDefaultConstructor,
    String parameterList,
    String argumentList
) {
    
    public static ConstructorMethodModel createDefault(
        String typeParameters,
        String builderClassNameWithTypeParameter,
        String builderClassName
    ) {
        return new ConstructorMethodModel(
            typeParameters,
            builderClassNameWithTypeParameter,
            builderClassName,
            true,
            "",
            ""
        );
    }
    
    public static ConstructorMethodModel createParameterized(
        String typeParameters,
        String builderClassNameWithTypeParameter,
        String builderClassName,
        String parameterList,
        String argumentList
    ) {
        return new ConstructorMethodModel(
            typeParameters,
            builderClassNameWithTypeParameter,
            builderClassName,
            false,
            parameterList,
            argumentList
        );
    }
}