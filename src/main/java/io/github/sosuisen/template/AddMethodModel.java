package io.github.sosuisen.template;

/**
 * Data model for add method JTE template (supports both Items and Menus)
 */
public record AddMethodModel(
        String builderClassNameWithTypeParameter,
        String observableListTypeParameter,
        String methodName,
        String getterMethodName) {

    public static AddMethodModel create(String builderClassNameWithTypeParameter,
            String observableListTypeParameter, String methodName, String getterMethodName) {
        return new AddMethodModel(
                builderClassNameWithTypeParameter,
                observableListTypeParameter,
                methodName,
                getterMethodName);
    }
}