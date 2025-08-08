package io.github.sosuisen.template;

/**
 * Data model for class header JTE template
 */
public record ClassHeaderModel(
        String packageName,
        String builderClassName,
        String typeParameters,
        String typeParametersExtends,
        String classNameWithTypeParameter) {

    public static ClassHeaderModel create(
            String packageName,
            String builderClassName,
            String typeParameters,
            String typeParametersExtends,
            String classNameWithTypeParameter) {
        return new ClassHeaderModel(
                packageName,
                builderClassName,
                typeParameters,
                typeParametersExtends,
                classNameWithTypeParameter);
    }
}