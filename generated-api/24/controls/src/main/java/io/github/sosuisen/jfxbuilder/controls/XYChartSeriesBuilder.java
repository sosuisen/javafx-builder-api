
package io.github.sosuisen.jfxbuilder.controls;


public class XYChartSeriesBuilder<X, Y> {
    private java.util.List<java.util.function.Consumer<javafx.scene.chart.XYChart.Series<X, Y>>> operations = new java.util.ArrayList<>();
    private XYChartSeriesBuilder() {}
    

    public static <X, Y> XYChartSeriesBuilder<X, Y> create() { return new XYChartSeriesBuilder<X, Y>(); }


    
    public static <X, Y> XYChartSeriesBuilder<X, Y> create(java.lang.String name, javafx.collections.ObservableList<javafx.scene.chart.XYChart.Data<X, Y>> data) {
        XYChartSeriesBuilder<X, Y> builder = new XYChartSeriesBuilder<X, Y>();
        builder.constructorArgs = new Object[]{name, data};
        return builder;
    }


    
    public static <X, Y> XYChartSeriesBuilder<X, Y> create(javafx.collections.ObservableList<javafx.scene.chart.XYChart.Data<X, Y>> data) {
        XYChartSeriesBuilder<X, Y> builder = new XYChartSeriesBuilder<X, Y>();
        builder.constructorArgs = new Object[]{data};
        return builder;
    }

    private Object[] constructorArgs;

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
    
    public XYChartSeriesBuilder<X, Y> apply(java.util.function.Consumer<javafx.scene.chart.XYChart.Series<X, Y>> func) {
        operations.add(func);
        return this;
    }    
    
    public  XYChartSeriesBuilder<X, Y> data(javafx.collections.ObservableList<javafx.scene.chart.XYChart.Data<X, Y>> value) {
        operations.add(obj -> obj.setData(value));
        return this;
    }    
    
    public  XYChartSeriesBuilder<X, Y> name(java.lang.String value) {
        operations.add(obj -> obj.setName(value));
        return this;
    }    
    
    public  XYChartSeriesBuilder<X, Y> node(javafx.scene.Node value) {
        operations.add(obj -> obj.setNode(value));
        return this;
    }
    @SafeVarargs
    public final XYChartSeriesBuilder<X, Y> addData(javafx.scene.chart.XYChart.Data<X, Y>... elements) {
        operations.add(obj -> {
            obj.getData().addAll(elements);
        });
        return this;
    }

    public final XYChartSeriesBuilder<X, Y> addData(java.util.Collection<? extends javafx.scene.chart.XYChart.Data<X, Y>> col) {
        operations.add(obj -> {
            obj.getData().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public static <X, Y> XYChartSeriesBuilder<X, Y> withData(javafx.scene.chart.XYChart.Data<X, Y>... elements) {
        XYChartSeriesBuilder<X, Y> builder = new XYChartSeriesBuilder<X, Y>();
        return builder.addData(elements);
    }

    public static <X, Y> XYChartSeriesBuilder<X, Y> withData(java.util.Collection<? extends javafx.scene.chart.XYChart.Data<X, Y>> col) {
        XYChartSeriesBuilder<X, Y> builder = new XYChartSeriesBuilder<X, Y>();
        return builder.addData(col);
    }
    
    
    public XYChartSeriesBuilder<X, Y> chartPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.chart.XYChart<X, Y>>> op) {
        operations.add(obj -> op.accept(obj.chartProperty()));
        return this;
    }    
    
    public XYChartSeriesBuilder<X, Y> dataPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.collections.ObservableList<javafx.scene.chart.XYChart.Data<X, Y>>>> op) {
        operations.add(obj -> op.accept(obj.dataProperty()));
        return this;
    }    
    
    public XYChartSeriesBuilder<X, Y> namePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.nameProperty()));
        return this;
    }    
    
    public XYChartSeriesBuilder<X, Y> nodePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.nodeProperty()));
        return this;
    }
}
