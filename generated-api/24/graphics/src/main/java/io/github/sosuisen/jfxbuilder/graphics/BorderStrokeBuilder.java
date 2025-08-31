
package io.github.sosuisen.jfxbuilder.graphics;


public class BorderStrokeBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.layout.BorderStroke>> operations = new java.util.ArrayList<>();
    private BorderStrokeBuilder() {}
    

    
    public static BorderStrokeBuilder create(javafx.scene.paint.Paint stroke, javafx.scene.layout.BorderStrokeStyle style, javafx.scene.layout.CornerRadii radii, javafx.scene.layout.BorderWidths widths, javafx.geometry.Insets insets) {
        BorderStrokeBuilder builder = new BorderStrokeBuilder();
        builder.constructorArgs = new Object[]{stroke, style, radii, widths, insets};
        return builder;
    }


    
    public static BorderStrokeBuilder create(javafx.scene.paint.Paint topStroke, javafx.scene.paint.Paint rightStroke, javafx.scene.paint.Paint bottomStroke, javafx.scene.paint.Paint leftStroke, javafx.scene.layout.BorderStrokeStyle topStyle, javafx.scene.layout.BorderStrokeStyle rightStyle, javafx.scene.layout.BorderStrokeStyle bottomStyle, javafx.scene.layout.BorderStrokeStyle leftStyle, javafx.scene.layout.CornerRadii radii, javafx.scene.layout.BorderWidths widths, javafx.geometry.Insets insets) {
        BorderStrokeBuilder builder = new BorderStrokeBuilder();
        builder.constructorArgs = new Object[]{topStroke, rightStroke, bottomStroke, leftStroke, topStyle, rightStyle, bottomStyle, leftStyle, radii, widths, insets};
        return builder;
    }


    
    public static BorderStrokeBuilder create(javafx.scene.paint.Paint stroke, javafx.scene.layout.BorderStrokeStyle style, javafx.scene.layout.CornerRadii radii, javafx.scene.layout.BorderWidths widths) {
        BorderStrokeBuilder builder = new BorderStrokeBuilder();
        builder.constructorArgs = new Object[]{stroke, style, radii, widths};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.layout.BorderStroke build() {
        javafx.scene.layout.BorderStroke newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.layout.BorderStroke> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.layout.BorderStroke callParameterizedConstructor() {
        javafx.scene.layout.BorderStroke newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.layout.BorderStroke.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.layout.BorderStroke) constructor.newInstance(constructorArgs);
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
    
    public BorderStrokeBuilder apply(java.util.function.Consumer<javafx.scene.layout.BorderStroke> func) {
        operations.add(func);
        return this;
    }
}
