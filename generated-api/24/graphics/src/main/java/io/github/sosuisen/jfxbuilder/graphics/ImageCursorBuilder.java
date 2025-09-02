
package io.github.sosuisen.jfxbuilder.graphics;


public class ImageCursorBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.ImageCursor>> operations = new java.util.ArrayList<>();
    private ImageCursorBuilder() {}
    

    public static ImageCursorBuilder create() { return new ImageCursorBuilder(); }


    
    public static ImageCursorBuilder create(javafx.scene.image.Image image) {
        ImageCursorBuilder builder = new ImageCursorBuilder();
        builder.constructorArgs = new Object[]{image};
        return builder;
    }


    
    public static ImageCursorBuilder create(javafx.scene.image.Image image, double hotspotX, double hotspotY) {
        ImageCursorBuilder builder = new ImageCursorBuilder();
        builder.constructorArgs = new Object[]{image, hotspotX, hotspotY};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.ImageCursor build() {
        javafx.scene.ImageCursor newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.ImageCursor();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.ImageCursor> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.ImageCursor callParameterizedConstructor() {
        javafx.scene.ImageCursor newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.ImageCursor.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.ImageCursor) constructor.newInstance(constructorArgs);
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
     * Applies a function to the ImageCursor instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(imageCursor -> imageCursor.setId("Main" + imageCursor.getTypeSelector()))
     * }</pre>
     * 
     * @return builder instance
     *
     */
    public ImageCursorBuilder apply(java.util.function.Consumer<javafx.scene.ImageCursor> func) {
        operations.add(func);
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.ImageCursor#hotspotXProperty()}.
     * 
     * @return builder instance
     */    
    
    public ImageCursorBuilder hotspotXPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.hotspotXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.ImageCursor#hotspotYProperty()}.
     * 
     * @return builder instance
     */    
    
    public ImageCursorBuilder hotspotYPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.hotspotYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.ImageCursor#imageProperty()}.
     * 
     * @return builder instance
     */    
    
    public ImageCursorBuilder imagePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.image.Image>> op) {
        operations.add(obj -> op.accept(obj.imageProperty()));
        return this;
    }
}
