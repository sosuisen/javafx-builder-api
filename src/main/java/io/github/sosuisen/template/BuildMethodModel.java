package io.github.sosuisen.template;

import java.lang.reflect.Constructor;

/**
 * Data model for build method JTE template
 */
public record BuildMethodModel(
    String className,
    String returnType,
    boolean hasDefaultConstructor,
    boolean hasGenerics,
    boolean suppressWarnings
) {
    
    public static BuildMethodModel create(Class<?> clazz, String className, String classNameWithTypeParameter, String typeParameters) {
        boolean hasDefaultConstructor = hasDefaultConstructor(clazz);
        boolean hasGenerics = !typeParameters.isEmpty();
        boolean suppressWarnings = hasGenerics;
        
        return new BuildMethodModel(
            className,
            classNameWithTypeParameter,
            hasDefaultConstructor,
            hasGenerics,
            suppressWarnings
        );
    }
    
    private static boolean hasDefaultConstructor(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterCount() == 0) {
                return true;
            }
        }
        return false;
    }
}