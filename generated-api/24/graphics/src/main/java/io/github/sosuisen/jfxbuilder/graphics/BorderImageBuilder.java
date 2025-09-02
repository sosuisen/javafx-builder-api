
package io.github.sosuisen.jfxbuilder.graphics;


public class BorderImageBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.layout.BorderImage>> operations = new java.util.ArrayList<>();
    private BorderImageBuilder() {}
    

    
    public static BorderImageBuilder create(javafx.scene.image.Image image, javafx.scene.layout.BorderWidths widths, javafx.geometry.Insets insets, javafx.scene.layout.BorderWidths slices, boolean filled, javafx.scene.layout.BorderRepeat repeatX, javafx.scene.layout.BorderRepeat repeatY) {
        BorderImageBuilder builder = new BorderImageBuilder();
        builder.constructorArgs = new Object[]{image, widths, insets, slices, filled, repeatX, repeatY};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.layout.BorderImage build() {
        javafx.scene.layout.BorderImage newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.layout.BorderImage> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.layout.BorderImage callParameterizedConstructor() {
        javafx.scene.layout.BorderImage newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.layout.BorderImage.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.layout.BorderImage) constructor.newInstance(constructorArgs);
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
    /**
     * Applies a function to the BorderImage instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(borderImage -> borderImage.setId("Main" + borderImage.getTypeSelector()))
     * }</pre>
     * 
     * @return builder instance
     *
     */
    public BorderImageBuilder apply(java.util.function.Consumer<javafx.scene.layout.BorderImage> func) {
        operations.add(func);
        return this;
    }
}
