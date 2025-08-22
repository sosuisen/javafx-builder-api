package io.github.sosuisen.template;

/**
 * Data model for stylesheet method JTE template
 */
public record StylesheetMethodModel(
        String className,
        String builderClassName,
        String builderClassNameWithTypeParameter) {

    public static StylesheetMethodModel create(String className,
            String builderClassName, String builderClassNameWithTypeParameter) {
        return new StylesheetMethodModel(
                className,
                builderClassName,
                builderClassNameWithTypeParameter);
    }
}