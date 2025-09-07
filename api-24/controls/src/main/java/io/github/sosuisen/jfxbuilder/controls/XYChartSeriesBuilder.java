
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code XYChartSeriesBuilder} class constructs instances of the {@link javafx.scene.chart.XYChart.Series Series} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.chart.XYChart.Series Series} constructor
 * and returns an instance of the {@code XYChartSeriesBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.chart.XYChart.Series Series}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.chart.XYChart.Series Series} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class XYChartSeriesBuilder<X, Y> {
    private java.util.List<java.util.function.Consumer<javafx.scene.chart.XYChart.Series<X, Y>>> operations = new java.util.ArrayList<>();
    private XYChartSeriesBuilder() {}
    
    /**
     * Returns an instance of the {@code XYChartSeriesBuilder<X, Y>}.
     *
     * @return an instance of the {@code XYChartSeriesBuilder<X, Y>}.
     */
    public static <X, Y> XYChartSeriesBuilder<X, Y> create() { return new XYChartSeriesBuilder<X, Y>(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.chart.XYChart.Series#Series(String, ObservableList) Series(String, ObservableList)}
     * and returns an instance of {@code XYChartSeriesBuilder<X, Y>}.
     *
     * @return an instance of the {@code XYChartSeriesBuilder<X, Y>}.
     */
    
    public static <X, Y> XYChartSeriesBuilder<X, Y> create(java.lang.String name, javafx.collections.ObservableList<javafx.scene.chart.XYChart.Data<X, Y>> data) {
        XYChartSeriesBuilder<X, Y> builder = new XYChartSeriesBuilder<X, Y>();
        builder.constructorArgs = new Object[]{name, data};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.chart.XYChart.Series#Series(ObservableList) Series(ObservableList)}
     * and returns an instance of {@code XYChartSeriesBuilder<X, Y>}.
     *
     * @return an instance of the {@code XYChartSeriesBuilder<X, Y>}.
     */
    
    public static <X, Y> XYChartSeriesBuilder<X, Y> create(javafx.collections.ObservableList<javafx.scene.chart.XYChart.Data<X, Y>> data) {
        XYChartSeriesBuilder<X, Y> builder = new XYChartSeriesBuilder<X, Y>();
        builder.constructorArgs = new Object[]{data};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.chart.XYChart.Series<X, Y>} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.chart.XYChart.Series Series} class
     */
    public javafx.scene.chart.XYChart.Series<X, Y> build() {
        javafx.scene.chart.XYChart.Series<X, Y> newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.chart.XYChart.Series<>();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.chart.XYChart.Series<X, Y>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.chart.XYChart.Series<X, Y> callParameterizedConstructor() {
        javafx.scene.chart.XYChart.Series<X, Y> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.chart.XYChart.Series.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.chart.XYChart.Series<X, Y>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Series instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public XYChartSeriesBuilder<X, Y> apply(java.util.function.Consumer<javafx.scene.chart.XYChart.Series<X, Y>> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.XYChart.Series#setData(javafx.collections.ObservableList) setData} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  XYChartSeriesBuilder<X, Y> data(javafx.collections.ObservableList<javafx.scene.chart.XYChart.Data<X, Y>> value) {
        operations.add(obj -> obj.setData(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.XYChart.Series#setName(java.lang.String) setName} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  XYChartSeriesBuilder<X, Y> name(java.lang.String value) {
        operations.add(obj -> obj.setName(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.XYChart.Series#setNode(javafx.scene.Node) setNode} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  XYChartSeriesBuilder<X, Y> node(javafx.scene.Node value) {
        operations.add(obj -> obj.setNode(value));
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.XYChart.Series#getData()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final XYChartSeriesBuilder<X, Y> addData(javafx.scene.chart.XYChart.Data<X, Y>... elements) {
        operations.add(obj -> {
            obj.getData().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.XYChart.Series#getData()} method.
     * 
     * @return builder instance
     */
    public final XYChartSeriesBuilder<X, Y> addData(java.util.Collection<? extends javafx.scene.chart.XYChart.Data<X, Y>> col) {
        operations.add(obj -> {
            obj.getData().addAll(col);
        });
        return this;
    }

    /**
     * Creates an instance of the builder, then calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.XYChart.Series#getData()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public static <X, Y> XYChartSeriesBuilder<X, Y> withData(javafx.scene.chart.XYChart.Data<X, Y>... elements) {
        XYChartSeriesBuilder<X, Y> builder = new XYChartSeriesBuilder<X, Y>();
        return builder.addData(elements);
    }

    /**
     * Creates an instance of the builder, then calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.XYChart.Series#getData()} method.
     * 
     * @return builder instance
     */
    public static <X, Y> XYChartSeriesBuilder<X, Y> withData(java.util.Collection<? extends javafx.scene.chart.XYChart.Data<X, Y>> col) {
        XYChartSeriesBuilder<X, Y> builder = new XYChartSeriesBuilder<X, Y>();
        return builder.addData(col);
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.XYChart.Series#chartProperty() chartProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.XYChart.Series<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.chartProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .chartPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public XYChartSeriesBuilder<X, Y> chartPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.chart.XYChart<X, Y>>> op) {
        operations.add(obj -> op.accept(obj.chartProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.XYChart.Series#dataProperty() dataProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.XYChart.Series<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.dataProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .dataPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public XYChartSeriesBuilder<X, Y> dataPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.collections.ObservableList<javafx.scene.chart.XYChart.Data<X, Y>>>> op) {
        operations.add(obj -> op.accept(obj.dataProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.XYChart.Series#nameProperty() nameProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.XYChart.Series<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.nameProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .namePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public XYChartSeriesBuilder<X, Y> namePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.nameProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.XYChart.Series#nodeProperty() nodeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.XYChart.Series<X, Y>> func) apply} method.
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
    public XYChartSeriesBuilder<X, Y> nodePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.nodeProperty()));
        return this;
    }
}
