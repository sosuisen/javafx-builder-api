package io.github.sosuisen.template;

/**
 * Data model for children method JTE template
 */
public record GridPaneMethodModel(
        String builderClassNameWithTypeParameter) {

    public static GridPaneMethodModel create(String builderClassNameWithTypeParameter) {
        return new GridPaneMethodModel(builderClassNameWithTypeParameter);
    }
}