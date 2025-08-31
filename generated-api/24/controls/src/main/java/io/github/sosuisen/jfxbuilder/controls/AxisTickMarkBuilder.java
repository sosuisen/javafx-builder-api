
package io.github.sosuisen.jfxbuilder.controls;


public class AxisTickMarkBuilder<T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.chart.Axis.TickMark<T>>> operations = new java.util.ArrayList<>();
    private AxisTickMarkBuilder() {}
    

    public static <T> AxisTickMarkBuilder<T> create() { return new AxisTickMarkBuilder<T>(); }

    private Object[] constructorArgs;

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
    
    public AxisTickMarkBuilder<T> apply(java.util.function.Consumer<javafx.scene.chart.Axis.TickMark<T>> func) {
        operations.add(func);
        return this;
    }    
    
    public  AxisTickMarkBuilder<T> value(T v) {
        operations.add(obj -> obj.setValue(v));
        return this;
    }    
    
    public  AxisTickMarkBuilder<T> position(double value) {
        operations.add(obj -> obj.setPosition(value));
        return this;
    }    
    
    public  AxisTickMarkBuilder<T> label(java.lang.String value) {
        operations.add(obj -> obj.setLabel(value));
        return this;
    }    
    
    public  AxisTickMarkBuilder<T> textVisible(boolean value) {
        operations.add(obj -> obj.setTextVisible(value));
        return this;
    }    
    
    public AxisTickMarkBuilder<T> labelPropertyApply(java.util.function.Consumer<javafx.beans.binding.StringExpression> op) {
        operations.add(obj -> op.accept(obj.labelProperty()));
        return this;
    }    
    
    public AxisTickMarkBuilder<T> valuePropertyApply(java.util.function.Consumer<javafx.beans.binding.ObjectExpression<T>> op) {
        operations.add(obj -> op.accept(obj.valueProperty()));
        return this;
    }    
    
    public AxisTickMarkBuilder<T> positionPropertyApply(java.util.function.Consumer<javafx.beans.binding.DoubleExpression> op) {
        operations.add(obj -> op.accept(obj.positionProperty()));
        return this;
    }
}
