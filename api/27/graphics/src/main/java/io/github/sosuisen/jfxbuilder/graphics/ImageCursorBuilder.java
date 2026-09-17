
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code ImageCursorBuilder} class constructs instances of the {@link javafx.scene.ImageCursor ImageCursor} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.ImageCursor ImageCursor} constructor
 * and returns an instance of the {@code ImageCursorBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.ImageCursor ImageCursor}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.ImageCursor ImageCursor} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class ImageCursorBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.ImageCursor>> operations = new java.util.ArrayList<>();
    private ImageCursorBuilder() {}
    
    /**
     * Returns an instance of the {@code ImageCursorBuilder}.
     *
     * @return an instance of the {@code ImageCursorBuilder}.
     */
    public static ImageCursorBuilder create() { return new ImageCursorBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.ImageCursor#ImageCursor(javafx.scene.image.Image) ImageCursor(Image)}
     * and returns an instance of {@code ImageCursorBuilder}.
     *
     * @return an instance of the {@code ImageCursorBuilder}.
     */
    public static ImageCursorBuilder create(javafx.scene.image.Image image) {
        ImageCursorBuilder builder = new ImageCursorBuilder();
        builder.constructorArgs = new Object[]{image};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.ImageCursor#ImageCursor(javafx.scene.image.Image, double, double) ImageCursor(Image, double, double)}
     * and returns an instance of {@code ImageCursorBuilder}.
     *
     * @return an instance of the {@code ImageCursorBuilder}.
     */
    public static ImageCursorBuilder create(javafx.scene.image.Image image, double hotspotX, double hotspotY) {
        ImageCursorBuilder builder = new ImageCursorBuilder();
        builder.constructorArgs = new Object[]{image, hotspotX, hotspotY};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.ImageCursor ImageCursor} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.ImageCursor ImageCursor} class
     */
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
     * Applies a function to the ImageCursor instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public ImageCursorBuilder apply(java.util.function.Consumer<javafx.scene.ImageCursor> func) {
        operations.add(func);
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.ImageCursor#hotspotXProperty() hotspotXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ImageCursorBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * {@snippet :
     * // Use apply
     * .apply(obj -> obj.hotspotXProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .hotspotXPropertyApply(prop -> prop.bind(anotherProperty))
     * }
     *
     * @return builder instance
     */
    public ImageCursorBuilder hotspotXPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.hotspotXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.ImageCursor#hotspotYProperty() hotspotYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ImageCursorBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * {@snippet :
     * // Use apply
     * .apply(obj -> obj.hotspotYProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .hotspotYPropertyApply(prop -> prop.bind(anotherProperty))
     * }
     *
     * @return builder instance
     */
    public ImageCursorBuilder hotspotYPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.hotspotYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.ImageCursor#imageProperty() imageProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ImageCursorBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * {@snippet :
     * // Use apply
     * .apply(obj -> obj.imageProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .imagePropertyApply(prop -> prop.bind(anotherProperty))
     * }
     *
     * @return builder instance
     */
    public ImageCursorBuilder imagePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.image.Image>> op) {
        operations.add(obj -> op.accept(obj.imageProperty()));
        return this;
    }
}
