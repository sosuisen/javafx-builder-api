package io.github.sosuisen.template;

/**
 * Data model for children method JTE template
 */
public record ChildrenMethodModel(
        String builderClassName,
        String builderClassNameWithTypeParameter) {

    public static ChildrenMethodModel create(String builderClassName, String builderClassNameWithTypeParameter) {
        return new ChildrenMethodModel(
                builderClassName,
                builderClassNameWithTypeParameter);
    }
}