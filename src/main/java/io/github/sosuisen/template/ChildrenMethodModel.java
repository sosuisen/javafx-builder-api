package io.github.sosuisen.template;

/**
 * Data model for children method JTE template
 */
public record ChildrenMethodModel(
        String builderClassName,
        String builderClassNameWithTypeParameter,
        String observableListTypeParameter,
        String typeParametersExtends) {

    public static ChildrenMethodModel create(String builderClassName, String builderClassNameWithTypeParameter,
            String observableListTypeParameter, String typeParametersExtends) {
        return new ChildrenMethodModel(
                builderClassName,
                builderClassNameWithTypeParameter,
                observableListTypeParameter,
                typeParametersExtends);
    }
}