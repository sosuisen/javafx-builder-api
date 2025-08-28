
package io.github.sosuisen.jfxbuilder.graphics;


public class BackgroundBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.layout.Background>> operations = new java.util.ArrayList<>();
    private BackgroundBuilder() {}
    

    @SafeVarargs
    public static BackgroundBuilder create(javafx.scene.layout.BackgroundFill... fills) {
        BackgroundBuilder builder = new BackgroundBuilder();
        builder.constructorArgs = new Object[]{fills};
        return builder;
    }


    @SafeVarargs
    public static BackgroundBuilder create(javafx.scene.layout.BackgroundImage... images) {
        BackgroundBuilder builder = new BackgroundBuilder();
        builder.constructorArgs = new Object[]{images};
        return builder;
    }


    
    public static BackgroundBuilder create(java.util.List<javafx.scene.layout.BackgroundFill> fills, java.util.List<javafx.scene.layout.BackgroundImage> images) {
        BackgroundBuilder builder = new BackgroundBuilder();
        builder.constructorArgs = new Object[]{fills, images};
        return builder;
    }


    
    public static BackgroundBuilder create(javafx.scene.layout.BackgroundFill[] fills, javafx.scene.layout.BackgroundImage[] images) {
        BackgroundBuilder builder = new BackgroundBuilder();
        builder.constructorArgs = new Object[]{fills, images};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.layout.Background build() {
        javafx.scene.layout.Background newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.layout.Background> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.layout.Background callParameterizedConstructor() {
        javafx.scene.layout.Background newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.layout.Background.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.layout.Background) constructor.newInstance(constructorArgs);
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
    
    public BackgroundBuilder apply(java.util.function.Consumer<javafx.scene.layout.Background> func) {
        operations.add(func);
        return this;
    }
}
