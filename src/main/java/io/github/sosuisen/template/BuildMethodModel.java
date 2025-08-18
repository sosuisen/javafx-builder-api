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
    boolean suppressWarnings,
    boolean isPaneSubclass,
    String styleClass
) {
    
    public static BuildMethodModel create(Class<?> clazz, String className, String classNameWithTypeParameter, String typeParameters) {
        boolean hasDefaultConstructor = hasDefaultConstructor(clazz);
        boolean hasGenerics = !typeParameters.isEmpty();
        boolean suppressWarnings = hasGenerics;
        boolean isPaneSubclass = isPaneSubclass(clazz);
        String styleClass = isPaneSubclass ? toKebabCase(className) : null;
        
        return new BuildMethodModel(
            className,
            classNameWithTypeParameter,
            hasDefaultConstructor,
            hasGenerics,
            suppressWarnings,
            isPaneSubclass,
            styleClass
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
    
    private static boolean isPaneSubclass(Class<?> clazz) {
        try {
            Class<?> paneClass = Class.forName("javafx.scene.layout.Pane");
            return paneClass.isAssignableFrom(clazz);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
    
    private static String toKebabCase(String className) {
        // Extract simple class name from fully qualified class name
        String simpleName = className;
        int lastDotIndex = className.lastIndexOf('.');
        if (lastDotIndex >= 0) {
            simpleName = className.substring(lastDotIndex + 1);
        }
        
        StringBuilder result = new StringBuilder();
        result.append('.');
        for (int i = 0; i < simpleName.length(); i++) {
            char c = simpleName.charAt(i);
            if (Character.isUpperCase(c)) {
                if (i > 0) {
                    result.append('-');
                }
                result.append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}