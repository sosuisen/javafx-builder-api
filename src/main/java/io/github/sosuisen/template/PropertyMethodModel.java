package io.github.sosuisen.template;

/**
 * Data model for property method JTE template
 */
public record PropertyMethodModel(
        String builderClassNameWithTypeParameter,
        String methodName,
        String propertyName,
        String propertyType,
        String originalClassName,
        String methodAnnotation) {

    public static PropertyMethodModel create(
            String builderClassNameWithTypeParameter,
            String methodName,
            String propertyName,
            String propertyType,
            String originalClassName,
            String methodAnnotation) {
        return new PropertyMethodModel(
                builderClassNameWithTypeParameter,
                methodName,
                propertyName,
                propertyType,
                originalClassName,
                methodAnnotation);
    }
}