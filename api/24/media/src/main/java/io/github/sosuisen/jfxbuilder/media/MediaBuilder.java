
package io.github.sosuisen.jfxbuilder.media;

/**
 * The {@code MediaBuilder} class constructs instances of the {@link javafx.scene.media.Media Media} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.media.Media Media} constructor
 * and returns an instance of the {@code MediaBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.media.Media Media}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.media.Media Media} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class MediaBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.media.Media>> operations = new java.util.ArrayList<>();
    private MediaBuilder() {}
    
    /**
     * Accepts the constructor arguments of {@link javafx.scene.media.Media#Media(java.lang.String) Media(String)}
     * and returns an instance of {@code MediaBuilder}.
     *
     * @return an instance of the {@code MediaBuilder}.
     */
    public static MediaBuilder create(java.lang.String source) {
        MediaBuilder builder = new MediaBuilder();
        builder.constructorArgs = new Object[]{source};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.media.Media Media} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.media.Media Media} class
     */
    public javafx.scene.media.Media build() {
        javafx.scene.media.Media newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.media.Media> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.media.Media callParameterizedConstructor() {
        javafx.scene.media.Media newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.media.Media.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.media.Media) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Media instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public MediaBuilder apply(java.util.function.Consumer<javafx.scene.media.Media> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.media.Media#setOnError(java.lang.Runnable) setOnError} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MediaBuilder onError(java.lang.Runnable value) {
        operations.add(obj -> obj.setOnError(value));
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(java.lang.Object[]) addAll} method on the ObservableList
     * returned by the {@link javafx.scene.media.Media#getTracks() Media#getTracks()} method.
     * 
     * @return builder instance
     */
    public final MediaBuilder addTracks(javafx.scene.media.Track... elements) {
        operations.add(obj -> obj.getTracks().addAll(elements));
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(java.util.Collection) addAll} method on the ObservableList
     * returned by the {@link javafx.scene.media.Media#getTracks() Media#getTracks()} method.
     * 
     * @return builder instance
     */
    public final MediaBuilder addTracks(java.util.Collection<? extends javafx.scene.media.Track> col) {
        operations.add(obj -> obj.getTracks().addAll(col));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.media.Media#durationProperty() durationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link MediaBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.durationProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .durationPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public MediaBuilder durationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.durationProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.media.Media#errorProperty() errorProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link MediaBuilder#apply(java.util.function.Consumer) apply} method.
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
    public MediaBuilder errorPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.media.MediaException>> op) {
        operations.add(obj -> op.accept(obj.errorProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.media.Media#heightProperty() heightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link MediaBuilder#apply(java.util.function.Consumer) apply} method.
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
    public MediaBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyIntegerProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.media.Media#onErrorProperty() onErrorProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link MediaBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onErrorProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onErrorPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public MediaBuilder onErrorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Runnable>> op) {
        operations.add(obj -> op.accept(obj.onErrorProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.media.Media#widthProperty() widthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link MediaBuilder#apply(java.util.function.Consumer) apply} method.
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
    public MediaBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyIntegerProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
