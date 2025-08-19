package io.github.sosuisen.template;

/**
 * Data model for children method JTE template
 */
public record ChildrenMethodModel(
        String builderClassNameWithTypeParameter,
        String observableListTypeParameter,
        String typeParametersExtends) {

    public static ChildrenMethodModel create(String builderClassNameWithTypeParameter,
            String observableListTypeParameter, String typeParametersExtends) {
        return new ChildrenMethodModel(
                builderClassNameWithTypeParameter,
                observableListTypeParameter,
                typeParametersExtends);
    }
}