package io.github.sosuisen.template;

/**
 * Data model for StyleClass method JTE template
 */
public record StyleClassMethodModel(
        String builderClassNameWithTypeParameter) {

    public static StyleClassMethodModel create(String builderClassNameWithTypeParameter) {
        return new StyleClassMethodModel(builderClassNameWithTypeParameter);
    }
}