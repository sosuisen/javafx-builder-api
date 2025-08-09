package io.github.sosuisen.template;

/**
 * Data model for class header JTE template
 */
public record ClassHeaderModel(
        String packageName,
        String builderClassName,
        String typeParameters,
        String typeParametersExtends,
        String classNameWithTypeParameter,
        String classAnnotation) {

    public static ClassHeaderModel create(
            String packageName,
            String builderClassName,
            String typeParameters,
            String typeParametersExtends,
            String classNameWithTypeParameter,
            String classAnnotation) {
        return new ClassHeaderModel(
                packageName,
                builderClassName,
                typeParameters,
                typeParametersExtends,
                classNameWithTypeParameter,
                classAnnotation);
    }
}