package io.github.sosuisen.template;

/**
 * Data model for add method JTE template (supports both Items and Menus)
 */
public record ItemsMethodModel(
        String builderClassName,
        String builderClassNameWithTypeParameter,
        String observableListTypeParameter,
        String typeParametersExtends,
        String methodName,
        String getterMethodName) {

    public static ItemsMethodModel create(String builderClassName, String builderClassNameWithTypeParameter,
            String observableListTypeParameter, String typeParametersExtends, String methodName, String getterMethodName) {
        return new ItemsMethodModel(
                builderClassName,
                builderClassNameWithTypeParameter,
                observableListTypeParameter,
                typeParametersExtends,
                methodName,
                getterMethodName);
    }
}