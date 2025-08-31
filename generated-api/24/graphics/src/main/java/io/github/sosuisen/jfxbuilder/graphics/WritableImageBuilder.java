
package io.github.sosuisen.jfxbuilder.graphics;


public class WritableImageBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.image.WritableImage>> operations = new java.util.ArrayList<>();
    private WritableImageBuilder() {}
    

    
    public static WritableImageBuilder create(int width, int height) {
        WritableImageBuilder builder = new WritableImageBuilder();
        builder.constructorArgs = new Object[]{width, height};
        return builder;
    }


    
    public static WritableImageBuilder create(javafx.scene.image.PixelBuffer<? extends java.nio.Buffer> pixelBuffer) {
        WritableImageBuilder builder = new WritableImageBuilder();
        builder.constructorArgs = new Object[]{pixelBuffer};
        return builder;
    }


    
    public static WritableImageBuilder create(javafx.scene.image.PixelReader reader, int width, int height) {
        WritableImageBuilder builder = new WritableImageBuilder();
        builder.constructorArgs = new Object[]{reader, width, height};
        return builder;
    }


    
    public static WritableImageBuilder create(javafx.scene.image.PixelReader reader, int x, int y, int width, int height) {
        WritableImageBuilder builder = new WritableImageBuilder();
        builder.constructorArgs = new Object[]{reader, x, y, width, height};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.image.WritableImage build() {
        javafx.scene.image.WritableImage newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.image.WritableImage> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.image.WritableImage callParameterizedConstructor() {
        javafx.scene.image.WritableImage newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.image.WritableImage.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.image.WritableImage) constructor.newInstance(constructorArgs);
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
    
    public WritableImageBuilder apply(java.util.function.Consumer<javafx.scene.image.WritableImage> func) {
        operations.add(func);
        return this;
    }    
    
    public WritableImageBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    
    public WritableImageBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    
    public WritableImageBuilder exceptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<java.lang.Exception>> op) {
        operations.add(obj -> op.accept(obj.exceptionProperty()));
        return this;
    }    
    
    public WritableImageBuilder progressPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.progressProperty()));
        return this;
    }    
    
    public WritableImageBuilder errorPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.errorProperty()));
        return this;
    }
}
