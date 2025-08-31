
package io.github.sosuisen.jfxbuilder.graphics;


public class BorderStrokeStyleBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.layout.BorderStrokeStyle>> operations = new java.util.ArrayList<>();
    private BorderStrokeStyleBuilder() {}
    

    
    public static BorderStrokeStyleBuilder create(javafx.scene.shape.StrokeType type, javafx.scene.shape.StrokeLineJoin lineJoin, javafx.scene.shape.StrokeLineCap lineCap, double miterLimit, double dashOffset, java.util.List<java.lang.Double> dashArray) {
        BorderStrokeStyleBuilder builder = new BorderStrokeStyleBuilder();
        builder.constructorArgs = new Object[]{type, lineJoin, lineCap, miterLimit, dashOffset, dashArray};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.layout.BorderStrokeStyle build() {
        javafx.scene.layout.BorderStrokeStyle newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.layout.BorderStrokeStyle> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.layout.BorderStrokeStyle callParameterizedConstructor() {
        javafx.scene.layout.BorderStrokeStyle newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.layout.BorderStrokeStyle.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.layout.BorderStrokeStyle) constructor.newInstance(constructorArgs);
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
    
    public BorderStrokeStyleBuilder apply(java.util.function.Consumer<javafx.scene.layout.BorderStrokeStyle> func) {
        operations.add(func);
        return this;
    }
}
