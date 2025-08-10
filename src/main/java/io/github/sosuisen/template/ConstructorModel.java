package io.github.sosuisen.template;

/**
 * Data model for constructor method JTE template
 */
public record ConstructorModel(
        boolean isPrivate,
        String builderClassName,
        String parameterList,
        String argumentList,
        boolean isVarArgs) {

    public static ConstructorModel createPrivate(
            String builderClassName) {
        return new ConstructorModel(
                true,
                builderClassName,
                "",
                "",
                false);
    }

    public static ConstructorModel createDefault(
            String builderClassName) {
        return new ConstructorModel(
                false,
                builderClassName,
                "",
                "",
                false);
    }

    public static ConstructorModel createParameterized(
            String builderClassName,
            String parameterList,
            String argumentList,
            boolean isVarArgs) {
        return new ConstructorModel(
                false,
                builderClassName,
                parameterList,
                argumentList,
                isVarArgs);
    }
}