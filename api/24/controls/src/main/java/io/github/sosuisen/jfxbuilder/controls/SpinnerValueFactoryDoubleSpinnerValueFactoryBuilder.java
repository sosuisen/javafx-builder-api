
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder} class constructs instances of the {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory DoubleSpinnerValueFactory} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory DoubleSpinnerValueFactory} constructor
 * and returns an instance of the {@code SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory DoubleSpinnerValueFactory}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory DoubleSpinnerValueFactory} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory>> operations = new java.util.ArrayList<>();
    private SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder() {}
    
    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#DoubleSpinnerValueFactory(double, double) DoubleSpinnerValueFactory(double, double)}
     * and returns an instance of {@code SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder}.
     *
     * @return an instance of the {@code SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder}.
     */
    public static SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder create(double min, double max) {
        SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder builder = new SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder();
        builder.constructorArgs = new Object[]{min, max};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#DoubleSpinnerValueFactory(double, double, double) DoubleSpinnerValueFactory(double, double, double)}
     * and returns an instance of {@code SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder}.
     *
     * @return an instance of the {@code SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder}.
     */
    public static SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder create(double min, double max, double initialValue) {
        SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder builder = new SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder();
        builder.constructorArgs = new Object[]{min, max, initialValue};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#DoubleSpinnerValueFactory(double, double, double, double) DoubleSpinnerValueFactory(double, double, double, double)}
     * and returns an instance of {@code SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder}.
     *
     * @return an instance of the {@code SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder}.
     */
    public static SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder create(double min, double max, double initialValue, double amountToStepBy) {
        SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder builder = new SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder();
        builder.constructorArgs = new Object[]{min, max, initialValue, amountToStepBy};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory DoubleSpinnerValueFactory} class
     */
    public javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory build() {
        javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory callParameterizedConstructor() {
        javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory) constructor.newInstance(constructorArgs);
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
     * Applies a function to the DoubleSpinnerValueFactory instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder apply(java.util.function.Consumer<javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#setAmountToStepBy(double) setAmountToStepBy} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder amountToStepBy(double value) {
        operations.add(obj -> obj.setAmountToStepBy(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.SpinnerValueFactory#setConverter(javafx.util.StringConverter) setConverter} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder converter(javafx.util.StringConverter<java.lang.Double> newValue) {
        operations.add(obj -> obj.setConverter(newValue));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#setMax(double) setMax} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder max(double value) {
        operations.add(obj -> obj.setMax(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#setMin(double) setMin} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder min(double value) {
        operations.add(obj -> obj.setMin(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.SpinnerValueFactory#setValue(java.lang.Object) setValue} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder value(java.lang.Double newValue) {
        operations.add(obj -> obj.setValue(newValue));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.SpinnerValueFactory#setWrapAround(boolean) setWrapAround} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder wrapAround(boolean value) {
        operations.add(obj -> obj.setWrapAround(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#amountToStepByProperty() amountToStepByProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder#apply(java.util.function.Consumer) apply} method.
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
    public SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder amountToStepByPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.amountToStepByProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory#converterProperty() converterProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder#apply(java.util.function.Consumer) apply} method.
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
    public SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder converterPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.StringConverter<java.lang.Double>>> op) {
        operations.add(obj -> op.accept(obj.converterProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#maxProperty() maxProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder#apply(java.util.function.Consumer) apply} method.
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
    public SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder maxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#minProperty() minProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder#apply(java.util.function.Consumer) apply} method.
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
    public SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder minPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory#valueProperty() valueProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder#apply(java.util.function.Consumer) apply} method.
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
    public SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder valuePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Double>> op) {
        operations.add(obj -> op.accept(obj.valueProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory#wrapAroundProperty() wrapAroundProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder#apply(java.util.function.Consumer) apply} method.
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
    public SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder wrapAroundPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.wrapAroundProperty()));
        return this;
    }
}
