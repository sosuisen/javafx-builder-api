package io.github.sosuisen.template;

/**
 * Data model for property method JTE template
 */
public record PropertyMethodModel(
        String builderClassNameWithTypeParameter,
        String methodName,
        String propertyName,
        String propertyType,
        String methodAnnotation) {

    public static PropertyMethodModel create(
            String builderClassNameWithTypeParameter,
            String methodName,
            String propertyName,
            String propertyType,
            String methodAnnotation) {
        return new PropertyMethodModel(
                builderClassNameWithTypeParameter,
                methodName,
                propertyName,
                propertyType,
                methodAnnotation);
    }
}