
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder} class constructs instances of the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory IntegerSpinnerValueFactory} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory IntegerSpinnerValueFactory} constructor
 * and returns an instance of the {@code SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory IntegerSpinnerValueFactory}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory IntegerSpinnerValueFactory} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory>> operations = new java.util.ArrayList<>();
    private SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder() {}
    
    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#IntegerSpinnerValueFactory(int, int) IntegerSpinnerValueFactory(int, int)}
     * and returns an instance of {@code SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder}.
     *
     * @return an instance of the {@code SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder}.
     */
    public static SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder create(int min, int max) {
        SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder builder = new SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder();
        builder.constructorArgs = new Object[]{min, max};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#IntegerSpinnerValueFactory(int, int, int) IntegerSpinnerValueFactory(int, int, int)}
     * and returns an instance of {@code SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder}.
     *
     * @return an instance of the {@code SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder}.
     */
    public static SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder create(int min, int max, int initialValue) {
        SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder builder = new SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder();
        builder.constructorArgs = new Object[]{min, max, initialValue};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#IntegerSpinnerValueFactory(int, int, int, int) IntegerSpinnerValueFactory(int, int, int, int)}
     * and returns an instance of {@code SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder}.
     *
     * @return an instance of the {@code SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder}.
     */
    public static SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder create(int min, int max, int initialValue, int amountToStepBy) {
        SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder builder = new SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder();
        builder.constructorArgs = new Object[]{min, max, initialValue, amountToStepBy};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory IntegerSpinnerValueFactory} class
     */
    public javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory build() {
        javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory callParameterizedConstructor() {
        javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory) constructor.newInstance(constructorArgs);
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
     * Applies a function to the IntegerSpinnerValueFactory instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder apply(java.util.function.Consumer<javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#setAmountToStepBy(int) setAmountToStepBy} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder amountToStepBy(int value) {
        operations.add(obj -> obj.setAmountToStepBy(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#setConverter(javafx.util.StringConverter) setConverter} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder converter(javafx.util.StringConverter<java.lang.Integer> newValue) {
        operations.add(obj -> obj.setConverter(newValue));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#setMax(int) setMax} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder max(int value) {
        operations.add(obj -> obj.setMax(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#setMin(int) setMin} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder min(int value) {
        operations.add(obj -> obj.setMin(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#setValue(T) setValue} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder value(java.lang.Integer newValue) {
        operations.add(obj -> obj.setValue(newValue));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#setWrapAround(boolean) setWrapAround} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder wrapAround(boolean value) {
        operations.add(obj -> obj.setWrapAround(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#amountToStepByProperty() amountToStepByProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.amountToStepByProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .amountToStepByPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder amountToStepByPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.amountToStepByProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#converterProperty() converterProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder#apply(java.util.function.Consumer) apply} method.
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
    public SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder converterPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.StringConverter<java.lang.Integer>>> op) {
        operations.add(obj -> op.accept(obj.converterProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#maxProperty() maxProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.maxProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .maxPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder maxPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.maxProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#minProperty() minProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.minProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .minPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder minPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.minProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#valueProperty() valueProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder#apply(java.util.function.Consumer) apply} method.
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
    public SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder valuePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Integer>> op) {
        operations.add(obj -> op.accept(obj.valueProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#wrapAroundProperty() wrapAroundProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder#apply(java.util.function.Consumer) apply} method.
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
    public SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder wrapAroundPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.wrapAroundProperty()));
        return this;
    }
}
