package io.github.sosuisen.template;

/**
 * Data model for with method JTE template
 */
public record WithMethodModel(
    String typeParameters,
    String builderClassNameWithTypeParameter,
    String builderClassName,
    boolean hasCommonParams,
    String methodName,
    String paramList,
    String argList
) {
    
    public static WithMethodModel createEmpty(
        String typeParameters,
        String builderClassNameWithTypeParameter,
        String builderClassName
    ) {
        return new WithMethodModel(
            typeParameters,
            builderClassNameWithTypeParameter,
            builderClassName,
            false,
            "",
            "",
            ""
        );
    }
    
    public static WithMethodModel create(
        String typeParameters,
        String builderClassNameWithTypeParameter,
        String builderClassName,
        String methodName,
        String paramList,
        String argList
    ) {
        return new WithMethodModel(
            typeParameters,
            builderClassNameWithTypeParameter,
            builderClassName,
            true,
            methodName,
            paramList,
            argList
        );
    }
}