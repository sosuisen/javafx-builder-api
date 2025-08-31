
package io.github.sosuisen.jfxbuilder.controls;


public class PieChartDataBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.chart.PieChart.Data>> operations = new java.util.ArrayList<>();
    private PieChartDataBuilder() {}
    

    
    public static PieChartDataBuilder create(java.lang.String name, double value) {
        PieChartDataBuilder builder = new PieChartDataBuilder();
        builder.constructorArgs = new Object[]{name, value};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.chart.PieChart.Data build() {
        javafx.scene.chart.PieChart.Data newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.chart.PieChart.Data> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.chart.PieChart.Data callParameterizedConstructor() {
        javafx.scene.chart.PieChart.Data newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.chart.PieChart.Data.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.chart.PieChart.Data) constructor.newInstance(constructorArgs);
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
    
    public PieChartDataBuilder apply(java.util.function.Consumer<javafx.scene.chart.PieChart.Data> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.PieChart.Data#setName(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  PieChartDataBuilder name(java.lang.String value) {
        operations.add(obj -> obj.setName(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.PieChart.Data#setPieValue(double)}
     * 
     * @return builder instance
     */    
    
    public  PieChartDataBuilder pieValue(double value) {
        operations.add(obj -> obj.setPieValue(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.PieChart.Data#chartProperty()}.
     * 
     * @return builder instance
     */    
    
    public PieChartDataBuilder chartPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.chart.PieChart>> op) {
        operations.add(obj -> op.accept(obj.chartProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.PieChart.Data#nameProperty()}.
     * 
     * @return builder instance
     */    
    
    public PieChartDataBuilder namePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.nameProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.PieChart.Data#nodeProperty()}.
     * 
     * @return builder instance
     */    
    
    public PieChartDataBuilder nodePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.nodeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.PieChart.Data#pieValueProperty()}.
     * 
     * @return builder instance
     */    
    
    public PieChartDataBuilder pieValuePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pieValueProperty()));
        return this;
    }
}
