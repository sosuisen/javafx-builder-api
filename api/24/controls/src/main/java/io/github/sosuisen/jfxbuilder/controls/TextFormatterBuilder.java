
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code TextFormatterBuilder} class constructs instances of the {@link javafx.scene.control.TextFormatter TextFormatter} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.TextFormatter TextFormatter} constructor
 * and returns an instance of the {@code TextFormatterBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.TextFormatter TextFormatter}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.TextFormatter TextFormatter} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class TextFormatterBuilder<V> {
    private final java.util.List<java.util.function.Consumer<javafx.scene.control.TextFormatter<V>>> operations = new java.util.ArrayList<>();
    private TextFormatterBuilder() {}
    
    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.TextFormatter#TextFormatter(java.util.function.UnaryOperator) TextFormatter(UnaryOperator)}
     * and returns an instance of {@code TextFormatterBuilder<V>}.
     *
     * @return an instance of the {@code TextFormatterBuilder<V>}.
     */
    public static <V> TextFormatterBuilder<V> create(java.util.function.UnaryOperator<javafx.scene.control.TextFormatter.Change> filter) {
        TextFormatterBuilder<V> builder = new TextFormatterBuilder<V>();
        builder.constructorArgs = new Object[]{filter};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.TextFormatter#TextFormatter(javafx.util.StringConverter) TextFormatter(StringConverter)}
     * and returns an instance of {@code TextFormatterBuilder<V>}.
     *
     * @return an instance of the {@code TextFormatterBuilder<V>}.
     */
    public static <V> TextFormatterBuilder<V> create(javafx.util.StringConverter<V> valueConverter) {
        TextFormatterBuilder<V> builder = new TextFormatterBuilder<V>();
        builder.constructorArgs = new Object[]{valueConverter};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.TextFormatter#TextFormatter(javafx.util.StringConverter, java.lang.Object) TextFormatter(StringConverter, V)}
     * and returns an instance of {@code TextFormatterBuilder<V>}.
     *
     * @return an instance of the {@code TextFormatterBuilder<V>}.
     */
    public static <V> TextFormatterBuilder<V> create(javafx.util.StringConverter<V> valueConverter, V defaultValue) {
        TextFormatterBuilder<V> builder = new TextFormatterBuilder<V>();
        builder.constructorArgs = new Object[]{valueConverter, defaultValue};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.TextFormatter#TextFormatter(javafx.util.StringConverter, java.lang.Object, java.util.function.UnaryOperator) TextFormatter(StringConverter, V, UnaryOperator)}
     * and returns an instance of {@code TextFormatterBuilder<V>}.
     *
     * @return an instance of the {@code TextFormatterBuilder<V>}.
     */
    public static <V> TextFormatterBuilder<V> create(javafx.util.StringConverter<V> valueConverter, V defaultValue, java.util.function.UnaryOperator<javafx.scene.control.TextFormatter.Change> filter) {
        TextFormatterBuilder<V> builder = new TextFormatterBuilder<V>();
        builder.constructorArgs = new Object[]{valueConverter, defaultValue, filter};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.TextFormatter TextFormatter} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.TextFormatter TextFormatter} class
     */
    public javafx.scene.control.TextFormatter<V> build() {
        javafx.scene.control.TextFormatter<V> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.TextFormatter<V>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.TextFormatter<V> callParameterizedConstructor() {
        javafx.scene.control.TextFormatter<V> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TextFormatter.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TextFormatter<V>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the TextFormatter instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TextFormatterBuilder<V> apply(java.util.function.Consumer<javafx.scene.control.TextFormatter<V>> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TextFormatter#setValue(java.lang.Object) setValue} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TextFormatterBuilder<V> value(V value) {
        operations.add(obj -> obj.setValue(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TextFormatter#valueProperty() valueProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TextFormatterBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.valueProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .valuePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TextFormatterBuilder<V> valuePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<V>> op) {
        operations.add(obj -> op.accept(obj.valueProperty()));
        return this;
    }
}
