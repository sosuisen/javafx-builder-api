
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code WritableImageBuilder} class constructs instances of the {@link javafx.scene.image.WritableImage WritableImage} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.image.WritableImage WritableImage} constructor
 * and returns an instance of the {@code WritableImageBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.image.WritableImage WritableImage}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.image.WritableImage WritableImage} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class WritableImageBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.image.WritableImage>> operations = new java.util.ArrayList<>();
    private WritableImageBuilder() {}
    

    /**
     * Accepts the constructor arguments of {@link javafx.scene.image.WritableImage#WritableImage(int, int) WritableImage(int, int)}
     * and returns an instance of {@code WritableImageBuilder}.
     *
     * @return an instance of the {@code WritableImageBuilder}.
     */
    
    public static WritableImageBuilder create(int width, int height) {
        WritableImageBuilder builder = new WritableImageBuilder();
        builder.constructorArgs = new Object[]{width, height};
        return builder;
    }


    /**
     * Accepts the constructor arguments of {@link javafx.scene.image.WritableImage#WritableImage(PixelBuffer) WritableImage(PixelBuffer)}
     * and returns an instance of {@code WritableImageBuilder}.
     *
     * @return an instance of the {@code WritableImageBuilder}.
     */
    
    public static WritableImageBuilder create(javafx.scene.image.PixelBuffer<? extends java.nio.Buffer> pixelBuffer) {
        WritableImageBuilder builder = new WritableImageBuilder();
        builder.constructorArgs = new Object[]{pixelBuffer};
        return builder;
    }


    /**
     * Accepts the constructor arguments of {@link javafx.scene.image.WritableImage#WritableImage(PixelReader, int, int) WritableImage(PixelReader, int, int)}
     * and returns an instance of {@code WritableImageBuilder}.
     *
     * @return an instance of the {@code WritableImageBuilder}.
     */
    
    public static WritableImageBuilder create(javafx.scene.image.PixelReader reader, int width, int height) {
        WritableImageBuilder builder = new WritableImageBuilder();
        builder.constructorArgs = new Object[]{reader, width, height};
        return builder;
    }


    /**
     * Accepts the constructor arguments of {@link javafx.scene.image.WritableImage#WritableImage(PixelReader, int, int, int, int) WritableImage(PixelReader, int, int, int, int)}
     * and returns an instance of {@code WritableImageBuilder}.
     *
     * @return an instance of the {@code WritableImageBuilder}.
     */
    
    public static WritableImageBuilder create(javafx.scene.image.PixelReader reader, int x, int y, int width, int height) {
        WritableImageBuilder builder = new WritableImageBuilder();
        builder.constructorArgs = new Object[]{reader, x, y, width, height};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.image.WritableImage} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.image.WritableImage WritableImage} class
     */
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
    /**
     * Applies a function to the WritableImage instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public WritableImageBuilder apply(java.util.function.Consumer<javafx.scene.image.WritableImage> func) {
        operations.add(func);
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.image.WritableImage#errorProperty() errorProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.image.WritableImage> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.errorProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .errorPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public WritableImageBuilder errorPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.errorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.image.WritableImage#exceptionProperty() exceptionProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.image.WritableImage> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.exceptionProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .exceptionPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public WritableImageBuilder exceptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<java.lang.Exception>> op) {
        operations.add(obj -> op.accept(obj.exceptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.image.WritableImage#heightProperty() heightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.image.WritableImage> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.heightProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .heightPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public WritableImageBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.image.WritableImage#progressProperty() progressProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.image.WritableImage> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.progressProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .progressPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public WritableImageBuilder progressPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.progressProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.image.WritableImage#widthProperty() widthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.image.WritableImage> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.widthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .widthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public WritableImageBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
