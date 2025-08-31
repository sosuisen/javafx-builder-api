
package io.github.sosuisen.jfxbuilder.graphics;


public class KeyCharacterCombinationBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.input.KeyCharacterCombination>> operations = new java.util.ArrayList<>();
    private KeyCharacterCombinationBuilder() {}
    

    
    public static KeyCharacterCombinationBuilder create(java.lang.String character, javafx.scene.input.KeyCombination.ModifierValue shift, javafx.scene.input.KeyCombination.ModifierValue control, javafx.scene.input.KeyCombination.ModifierValue alt, javafx.scene.input.KeyCombination.ModifierValue meta, javafx.scene.input.KeyCombination.ModifierValue shortcut) {
        KeyCharacterCombinationBuilder builder = new KeyCharacterCombinationBuilder();
        builder.constructorArgs = new Object[]{character, shift, control, alt, meta, shortcut};
        return builder;
    }


    @SafeVarargs
    public static KeyCharacterCombinationBuilder create(java.lang.String character, javafx.scene.input.KeyCombination.Modifier... modifiers) {
        KeyCharacterCombinationBuilder builder = new KeyCharacterCombinationBuilder();
        builder.constructorArgs = new Object[]{character, modifiers};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.input.KeyCharacterCombination build() {
        javafx.scene.input.KeyCharacterCombination newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.input.KeyCharacterCombination> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.input.KeyCharacterCombination callParameterizedConstructor() {
        javafx.scene.input.KeyCharacterCombination newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.input.KeyCharacterCombination.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.input.KeyCharacterCombination) constructor.newInstance(constructorArgs);
                    break;
                }
            }
            if (newInstance == null) {
                throw new RuntimeException("No suitable constructor found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance", e);
        }

        return newInstance;
    }

    
    private static boolean isConstructorCompatible(java.lang.reflect.Constructor<?> constructor, Object[] args) {
        Class<?>[] paramTypes = constructor.getParameterTypes();
        if (paramTypes.length != args.length) return false;
        
        for (int i = 0; i < paramTypes.length; i++) {
            if (args[i] != null) {
                Class<?> paramType = paramTypes[i];
                Class<?> argType = args[i].getClass();
                
                // Check if argument type is assignable to parameter type
                if (!paramType.isAssignableFrom(argType)) {
                    // Handle primitive types
                    if (paramType.isPrimitive()) {
                        if (!isPrimitiveCompatible(paramType, argType)) {
                            return false;
                        }
                    } else if (argType.isPrimitive()) {
                        if (!isPrimitiveCompatible(argType, paramType)) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private static boolean isPrimitiveCompatible(Class<?> primitiveType, Class<?> wrapperType) {
        if (primitiveType == boolean.class) return wrapperType == Boolean.class;
        if (primitiveType == byte.class) return wrapperType == Byte.class;
        if (primitiveType == char.class) return wrapperType == Character.class;
        if (primitiveType == short.class) return wrapperType == Short.class;
        if (primitiveType == int.class) return wrapperType == Integer.class;
        if (primitiveType == long.class) return wrapperType == Long.class;
        if (primitiveType == float.class) return wrapperType == Float.class;
        if (primitiveType == double.class) return wrapperType == Double.class;
        return false;
    }
    
    public KeyCharacterCombinationBuilder apply(java.util.function.Consumer<javafx.scene.input.KeyCharacterCombination> func) {
        operations.add(func);
        return this;
    }
}
