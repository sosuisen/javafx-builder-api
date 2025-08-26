package io.github.sosuisen.template;

/**
 * Data model for children method JTE template
 */
public record WithMethodModel(
        String builderClassNameWithTypeParameter,
        String observableListTypeParameter,
        String typeParametersExtends,
        String addMethodName,
        String withMethodName) {

    public static WithMethodModel create(String builderClassNameWithTypeParameter,
            String observableListTypeParameter, String typeParametersExtends, String addMethodName,
            String withMethodName) {
        return new WithMethodModel(
                builderClassNameWithTypeParameter,
                observableListTypeParameter,
                typeParametersExtends,
                addMethodName,
                withMethodName);
    }
}