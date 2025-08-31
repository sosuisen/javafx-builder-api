package io.github.sosuisen.template;

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

    public static SetterMethodModel create(
            String builderClassNameWithTypeParameter,
            String methodName,
            String parameterList,
            String parameterTypeList,
            String argumentList,
            String originalClassName,
            String originalMethodName,
            String methodAnnotation) {
        return new SetterMethodModel(
                builderClassNameWithTypeParameter,
                methodName,
                parameterList,
                parameterTypeList,
                argumentList,
                originalClassName,
                originalMethodName,
                methodAnnotation);
    }
}