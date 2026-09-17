
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code AxisTickMarkBuilder} class constructs instances of the {@link javafx.scene.chart.Axis.TickMark TickMark} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.chart.Axis.TickMark TickMark} constructor
 * and returns an instance of the {@code AxisTickMarkBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.chart.Axis.TickMark TickMark}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.chart.Axis.TickMark TickMark} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class AxisTickMarkBuilder<T> {
    private final java.util.List<java.util.function.Consumer<javafx.scene.chart.Axis.TickMark<T>>> operations = new java.util.ArrayList<>();
    private AxisTickMarkBuilder() {}
    
    /**
     * Returns an instance of the {@code AxisTickMarkBuilder<T>}.
     *
     * @return an instance of the {@code AxisTickMarkBuilder<T>}.
     */
    public static <T> AxisTickMarkBuilder<T> create() { return new AxisTickMarkBuilder<T>(); }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.chart.Axis.TickMark TickMark} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.chart.Axis.TickMark TickMark} class
     */
    public javafx.scene.chart.Axis.TickMark<T> build() {
        javafx.scene.chart.Axis.TickMark<T> newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.chart.Axis.TickMark<>();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.chart.Axis.TickMark<T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.chart.Axis.TickMark<T> callParameterizedConstructor() {
        javafx.scene.chart.Axis.TickMark<T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.chart.Axis.TickMark.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.chart.Axis.TickMark<T>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the TickMark instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public AxisTickMarkBuilder<T> apply(java.util.function.Consumer<javafx.scene.chart.Axis.TickMark<T>> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.Axis.TickMark#setLabel(java.lang.String) setLabel} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AxisTickMarkBuilder<T> label(java.lang.String value) {
        operations.add(obj -> obj.setLabel(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.Axis.TickMark#setPosition(double) setPosition} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AxisTickMarkBuilder<T> position(double value) {
        operations.add(obj -> obj.setPosition(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.Axis.TickMark#setTextVisible(boolean) setTextVisible} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AxisTickMarkBuilder<T> textVisible(boolean value) {
        operations.add(obj -> obj.setTextVisible(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.Axis.TickMark#setValue(java.lang.Object) setValue} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AxisTickMarkBuilder<T> value(T v) {
        operations.add(obj -> obj.setValue(v));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.Axis.TickMark#labelProperty() labelProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link AxisTickMarkBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * {@snippet :
     * // Use apply
     * .apply(obj -> obj.labelProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .labelPropertyApply(prop -> prop.bind(anotherProperty))
     * }
     *
     * @return builder instance
     */
    public AxisTickMarkBuilder<T> labelPropertyApply(java.util.function.Consumer<javafx.beans.binding.StringExpression> op) {
        operations.add(obj -> op.accept(obj.labelProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.Axis.TickMark#positionProperty() positionProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link AxisTickMarkBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * {@snippet :
     * // Use apply
     * .apply(obj -> obj.positionProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .positionPropertyApply(prop -> prop.bind(anotherProperty))
     * }
     *
     * @return builder instance
     */
    public AxisTickMarkBuilder<T> positionPropertyApply(java.util.function.Consumer<javafx.beans.binding.DoubleExpression> op) {
        operations.add(obj -> op.accept(obj.positionProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.Axis.TickMark#valueProperty() valueProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link AxisTickMarkBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * {@snippet :
     * // Use apply
     * .apply(obj -> obj.valueProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .valuePropertyApply(prop -> prop.bind(anotherProperty))
     * }
     *
     * @return builder instance
     */
    public AxisTickMarkBuilder<T> valuePropertyApply(java.util.function.Consumer<javafx.beans.binding.ObjectExpression<T>> op) {
        operations.add(obj -> op.accept(obj.valueProperty()));
        return this;
    }
}
