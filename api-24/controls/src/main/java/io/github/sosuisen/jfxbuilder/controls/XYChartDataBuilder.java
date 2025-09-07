
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code XYChartDataBuilder} class constructs instances of the {@link javafx.scene.chart.XYChart.Data Data} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.chart.XYChart.Data Data} constructor
 * and returns an instance of the {@code XYChartDataBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.chart.XYChart.Data Data}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.chart.XYChart.Data Data} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class XYChartDataBuilder<X, Y> {
    private java.util.List<java.util.function.Consumer<javafx.scene.chart.XYChart.Data<X, Y>>> operations = new java.util.ArrayList<>();
    private XYChartDataBuilder() {}
    
    /**
     * Returns an instance of the {@code XYChartDataBuilder<X, Y>}.
     *
     * @return an instance of the {@code XYChartDataBuilder<X, Y>}.
     */
    public static <X, Y> XYChartDataBuilder<X, Y> create() { return new XYChartDataBuilder<X, Y>(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.chart.XYChart.Data#Data(Object, Object) Data(Object, Object)}
     * and returns an instance of {@code XYChartDataBuilder<X, Y>}.
     *
     * @return an instance of the {@code XYChartDataBuilder<X, Y>}.
     */
    
    public static <X, Y> XYChartDataBuilder<X, Y> create(X xValue, Y yValue) {
        XYChartDataBuilder<X, Y> builder = new XYChartDataBuilder<X, Y>();
        builder.constructorArgs = new Object[]{xValue, yValue};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.chart.XYChart.Data#Data(Object, Object, Object) Data(Object, Object, Object)}
     * and returns an instance of {@code XYChartDataBuilder<X, Y>}.
     *
     * @return an instance of the {@code XYChartDataBuilder<X, Y>}.
     */
    
    public static <X, Y> XYChartDataBuilder<X, Y> create(X xValue, Y yValue, java.lang.Object extraValue) {
        XYChartDataBuilder<X, Y> builder = new XYChartDataBuilder<X, Y>();
        builder.constructorArgs = new Object[]{xValue, yValue, extraValue};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.chart.XYChart.Data<X, Y>} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.chart.XYChart.Data Data} class
     */
    public javafx.scene.chart.XYChart.Data<X, Y> build() {
        javafx.scene.chart.XYChart.Data<X, Y> newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.chart.XYChart.Data<>();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.chart.XYChart.Data<X, Y>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.chart.XYChart.Data<X, Y> callParameterizedConstructor() {
        javafx.scene.chart.XYChart.Data<X, Y> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.chart.XYChart.Data.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.chart.XYChart.Data<X, Y>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Data instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public XYChartDataBuilder<X, Y> apply(java.util.function.Consumer<javafx.scene.chart.XYChart.Data<X, Y>> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.XYChart.Data#setExtraValue(java.lang.Object) setExtraValue} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  XYChartDataBuilder<X, Y> extraValue(java.lang.Object value) {
        operations.add(obj -> obj.setExtraValue(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.XYChart.Data#setNode(javafx.scene.Node) setNode} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  XYChartDataBuilder<X, Y> node(javafx.scene.Node value) {
        operations.add(obj -> obj.setNode(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.XYChart.Data#setXValue(java.lang.Object) setXValue} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  XYChartDataBuilder<X, Y> xValue(X value) {
        operations.add(obj -> obj.setXValue(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.XYChart.Data#setYValue(java.lang.Object) setYValue} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  XYChartDataBuilder<X, Y> yValue(Y value) {
        operations.add(obj -> obj.setYValue(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.XYChart.Data#XValueProperty() XValueProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.XYChart.Data<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.XValueProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .XValuePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public XYChartDataBuilder<X, Y> XValuePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<X>> op) {
        operations.add(obj -> op.accept(obj.XValueProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.XYChart.Data#YValueProperty() YValueProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.XYChart.Data<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.YValueProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .YValuePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public XYChartDataBuilder<X, Y> YValuePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<Y>> op) {
        operations.add(obj -> op.accept(obj.YValueProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.XYChart.Data#extraValueProperty() extraValueProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.XYChart.Data<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.extraValueProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .extraValuePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public XYChartDataBuilder<X, Y> extraValuePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Object>> op) {
        operations.add(obj -> op.accept(obj.extraValueProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.XYChart.Data#nodeProperty() nodeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.XYChart.Data<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.nodeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .nodePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public XYChartDataBuilder<X, Y> nodePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.nodeProperty()));
        return this;
    }
}
