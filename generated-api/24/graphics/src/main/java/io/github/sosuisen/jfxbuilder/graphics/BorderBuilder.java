
package io.github.sosuisen.jfxbuilder.graphics;


public class BorderBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.layout.Border>> operations = new java.util.ArrayList<>();
    private BorderBuilder() {}
    

    @SafeVarargs
    public static BorderBuilder create(javafx.scene.layout.BorderImage... images) {
        BorderBuilder builder = new BorderBuilder();
        builder.constructorArgs = new Object[]{images};
        return builder;
    }


    @SafeVarargs
    public static BorderBuilder create(javafx.scene.layout.BorderStroke... strokes) {
        BorderBuilder builder = new BorderBuilder();
        builder.constructorArgs = new Object[]{strokes};
        return builder;
    }


    
    public static BorderBuilder create(javafx.scene.layout.BorderStroke[] strokes, javafx.scene.layout.BorderImage[] images) {
        BorderBuilder builder = new BorderBuilder();
        builder.constructorArgs = new Object[]{strokes, images};
        return builder;
    }


    
    public static BorderBuilder create(java.util.List<javafx.scene.layout.BorderStroke> strokes, java.util.List<javafx.scene.layout.BorderImage> images) {
        BorderBuilder builder = new BorderBuilder();
        builder.constructorArgs = new Object[]{strokes, images};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.layout.Border build() {
        javafx.scene.layout.Border newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.layout.Border> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.layout.Border callParameterizedConstructor() {
        javafx.scene.layout.Border newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.layout.Border.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.layout.Border) constructor.newInstance(constructorArgs);
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
    
    public BorderBuilder apply(java.util.function.Consumer<javafx.scene.layout.Border> func) {
        operations.add(func);
        return this;
    }
}
