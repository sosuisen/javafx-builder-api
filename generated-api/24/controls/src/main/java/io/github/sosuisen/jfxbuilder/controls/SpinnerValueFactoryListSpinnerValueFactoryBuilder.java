
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code SpinnerValueFactoryListSpinnerValueFactoryBuilder} class constructs instances of the {@link javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory ListSpinnerValueFactory} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory ListSpinnerValueFactory} constructor
 * and returns an instance of the {@code SpinnerValueFactoryListSpinnerValueFactoryBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory ListSpinnerValueFactory}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory ListSpinnerValueFactory} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class SpinnerValueFactoryListSpinnerValueFactoryBuilder<T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory<T>>> operations = new java.util.ArrayList<>();
    private SpinnerValueFactoryListSpinnerValueFactoryBuilder() {}
    

    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory#ListSpinnerValueFactory(ObservableList) ListSpinnerValueFactory(ObservableList)}
     * and returns an instance of {@code SpinnerValueFactoryListSpinnerValueFactoryBuilder<T>}.
     *
     * @return an instance of the {@code SpinnerValueFactoryListSpinnerValueFactoryBuilder<T>}.
     */
    
    public static <T> SpinnerValueFactoryListSpinnerValueFactoryBuilder<T> create(javafx.collections.ObservableList<T> items) {
        SpinnerValueFactoryListSpinnerValueFactoryBuilder<T> builder = new SpinnerValueFactoryListSpinnerValueFactoryBuilder<T>();
        builder.constructorArgs = new Object[]{items};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory<T>} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory ListSpinnerValueFactory} class
     */
    public javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory<T> build() {
        javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory<T> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory<T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory<T> callParameterizedConstructor() {
        javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory<T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory<T>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the ListSpinnerValueFactory instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public SpinnerValueFactoryListSpinnerValueFactoryBuilder<T> apply(java.util.function.Consumer<javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory<T>> func) {
        operations.add(func);
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory#setConverter(javafx.util.StringConverter) setConverter} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  SpinnerValueFactoryListSpinnerValueFactoryBuilder<T> converter(javafx.util.StringConverter<T> newValue) {
        operations.add(obj -> obj.setConverter(newValue));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory#setItems(javafx.collections.ObservableList) setItems} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  SpinnerValueFactoryListSpinnerValueFactoryBuilder<T> items(javafx.collections.ObservableList<T> value) {
        operations.add(obj -> obj.setItems(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory#setValue(java.lang.Object) setValue} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  SpinnerValueFactoryListSpinnerValueFactoryBuilder<T> value(T newValue) {
        operations.add(obj -> obj.setValue(newValue));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory#setWrapAround(boolean) setWrapAround} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  SpinnerValueFactoryListSpinnerValueFactoryBuilder<T> wrapAround(boolean value) {
        operations.add(obj -> obj.setWrapAround(value));
        return this;
    }
    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory#getItems()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final SpinnerValueFactoryListSpinnerValueFactoryBuilder<T> addItems(T... elements) {
        operations.add(obj -> {
            obj.getItems().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory#getItems()} method.
     * 
     * @return builder instance
     */
    public final SpinnerValueFactoryListSpinnerValueFactoryBuilder<T> addItems(java.util.Collection<? extends T> col) {
        operations.add(obj -> {
            obj.getItems().addAll(col);
        });
        return this;
    }


    
    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory#converterProperty() converterProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory<T>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.converterProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .converterPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public SpinnerValueFactoryListSpinnerValueFactoryBuilder<T> converterPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.StringConverter<T>>> op) {
        operations.add(obj -> op.accept(obj.converterProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory#itemsProperty() itemsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory<T>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.itemsProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .itemsPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public SpinnerValueFactoryListSpinnerValueFactoryBuilder<T> itemsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.collections.ObservableList<T>>> op) {
        operations.add(obj -> op.accept(obj.itemsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory#valueProperty() valueProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory<T>> func) apply} method.
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
    
    public SpinnerValueFactoryListSpinnerValueFactoryBuilder<T> valuePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<T>> op) {
        operations.add(obj -> op.accept(obj.valueProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory#wrapAroundProperty() wrapAroundProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory<T>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.wrapAroundProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .wrapAroundPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public SpinnerValueFactoryListSpinnerValueFactoryBuilder<T> wrapAroundPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.wrapAroundProperty()));
        return this;
    }
}
