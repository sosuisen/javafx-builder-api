package io.github.sosuisen.template;

/**
 * Data model for add/with method JTE template (supports both Items and Menus)
 */
public record AddWithMethodModel(
        String builderClassNameWithTypeParameter,
        String observableListTypeParameter,
        String typeParametersExtends,
        String addMethodName,
        String withMethodName,
        String getterMethodName) {

    public static AddWithMethodModel create(String builderClassNameWithTypeParameter,
            String observableListTypeParameter, String typeParametersExtends, String addMethodName,
            String withMethodName, String getterMethodName) {
        return new AddWithMethodModel(
                builderClassNameWithTypeParameter,
                observableListTypeParameter,
                typeParametersExtends,
                addMethodName,
                withMethodName,
                getterMethodName);
    }
}