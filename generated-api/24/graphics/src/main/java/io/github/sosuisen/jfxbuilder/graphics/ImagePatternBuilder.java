
package io.github.sosuisen.jfxbuilder.graphics;


public class ImagePatternBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.paint.ImagePattern>> operations = new java.util.ArrayList<>();
    private ImagePatternBuilder() {}
    

    
    public static ImagePatternBuilder create(javafx.scene.image.Image image) {
        ImagePatternBuilder builder = new ImagePatternBuilder();
        builder.constructorArgs = new Object[]{image};
        return builder;
    }


    
    public static ImagePatternBuilder create(javafx.scene.image.Image image, double x, double y, double width, double height, boolean proportional) {
        ImagePatternBuilder builder = new ImagePatternBuilder();
        builder.constructorArgs = new Object[]{image, x, y, width, height, proportional};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.paint.ImagePattern build() {
        javafx.scene.paint.ImagePattern newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.paint.ImagePattern> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.paint.ImagePattern callParameterizedConstructor() {
        javafx.scene.paint.ImagePattern newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.paint.ImagePattern.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.paint.ImagePattern) constructor.newInstance(constructorArgs);
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
     * Applies a function to the ImagePattern instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public ImagePatternBuilder apply(java.util.function.Consumer<javafx.scene.paint.ImagePattern> func) {
        operations.add(func);
        return this;
    }
}
