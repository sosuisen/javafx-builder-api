
package io.github.sosuisen.jfxbuilder.graphics;


public class ImageBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.image.Image>> operations = new java.util.ArrayList<>();
    private ImageBuilder() {}
    

    
    public static ImageBuilder create(java.io.InputStream is) {
        ImageBuilder builder = new ImageBuilder();
        builder.constructorArgs = new Object[]{is};
        return builder;
    }


    
    public static ImageBuilder create(java.io.InputStream is, double requestedWidth, double requestedHeight, boolean preserveRatio, boolean smooth) {
        ImageBuilder builder = new ImageBuilder();
        builder.constructorArgs = new Object[]{is, requestedWidth, requestedHeight, preserveRatio, smooth};
        return builder;
    }


    
    public static ImageBuilder create(java.lang.String url) {
        ImageBuilder builder = new ImageBuilder();
        builder.constructorArgs = new Object[]{url};
        return builder;
    }


    
    public static ImageBuilder create(java.lang.String url, boolean backgroundLoading) {
        ImageBuilder builder = new ImageBuilder();
        builder.constructorArgs = new Object[]{url, backgroundLoading};
        return builder;
    }


    
    public static ImageBuilder create(java.lang.String url, double requestedWidth, double requestedHeight, boolean preserveRatio, boolean smooth) {
        ImageBuilder builder = new ImageBuilder();
        builder.constructorArgs = new Object[]{url, requestedWidth, requestedHeight, preserveRatio, smooth};
        return builder;
    }


    
    public static ImageBuilder create(java.lang.String url, double requestedWidth, double requestedHeight, boolean preserveRatio, boolean smooth, boolean backgroundLoading) {
        ImageBuilder builder = new ImageBuilder();
        builder.constructorArgs = new Object[]{url, requestedWidth, requestedHeight, preserveRatio, smooth, backgroundLoading};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * This method builds and returns an instance of the original class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the build() method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.image.Image Image} class
     */
    public javafx.scene.image.Image build() {
        javafx.scene.image.Image newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.image.Image> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.image.Image callParameterizedConstructor() {
        javafx.scene.image.Image newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.image.Image.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.image.Image) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Image instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public ImageBuilder apply(java.util.function.Consumer<javafx.scene.image.Image> func) {
        operations.add(func);
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.image.Image#errorProperty()}.
     * 
     * @return builder instance
     */    
    
    public ImageBuilder errorPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.errorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.image.Image#exceptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public ImageBuilder exceptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<java.lang.Exception>> op) {
        operations.add(obj -> op.accept(obj.exceptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.image.Image#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ImageBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.image.Image#progressProperty()}.
     * 
     * @return builder instance
     */    
    
    public ImageBuilder progressPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.progressProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.image.Image#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ImageBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
