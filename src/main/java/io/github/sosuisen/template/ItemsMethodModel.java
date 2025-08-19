package io.github.sosuisen.template;

/**
 * Data model for items method JTE template
 */
public record ItemsMethodModel(
        String builderClassName,
        String builderClassNameWithTypeParameter,
        String observableListTypeParameter,
        String typeParametersExtends) {

    public static ItemsMethodModel create(String builderClassName, String builderClassNameWithTypeParameter,
            String observableListTypeParameter, String typeParametersExtends) {
        return new ItemsMethodModel(
                builderClassName,
                builderClassNameWithTypeParameter,
                observableListTypeParameter,
                typeParametersExtends);
    }
}