package io.github.sosuisen.template;

/**
 * Data model for setter method JTE template
 */
public record SetterMethodModel(
    String builderClassNameWithTypeParameter,
    String methodName,
    String parameterList,
    String argumentList,
    String originalMethodName
) {
    
    public static SetterMethodModel create(
        String builderClassNameWithTypeParameter,
        String methodName,
        String parameterList,
        String argumentList,
        String originalMethodName
    ) {
        return new SetterMethodModel(
            builderClassNameWithTypeParameter,
            methodName,
            parameterList,
            argumentList,
            originalMethodName
        );
    }
}