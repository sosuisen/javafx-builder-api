package io.github.sosuisen.model.template;

/**
 * Data model for apply method JTE template
 */
public record ApplyMethodModel(
        String builderClassNameWithTypeParameter,
        String classNameWithTypeParameter) {

    public static ApplyMethodModel create(String builderClassNameWithTypeParameter, String classNameWithTypeParameter) {
        return new ApplyMethodModel(builderClassNameWithTypeParameter, classNameWithTypeParameter);
    }
}