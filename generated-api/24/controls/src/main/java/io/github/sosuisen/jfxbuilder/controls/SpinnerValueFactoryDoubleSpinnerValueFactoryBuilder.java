
package io.github.sosuisen.jfxbuilder.controls;


public class SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory>> operations = new java.util.ArrayList<>();
    private SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder() {}
    

    
    public static SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder create(double min, double max) {
        SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder builder = new SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder();
        builder.constructorArgs = new Object[]{min, max};
        return builder;
    }


    
    public static SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder create(double min, double max, double initialValue) {
        SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder builder = new SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder();
        builder.constructorArgs = new Object[]{min, max, initialValue};
        return builder;
    }


    
    public static SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder create(double min, double max, double initialValue, double amountToStepBy) {
        SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder builder = new SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder();
        builder.constructorArgs = new Object[]{min, max, initialValue, amountToStepBy};
        return builder;
    }

    private Object[] constructorArgs;

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
    
    public SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder apply(java.util.function.Consumer<javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory> func) {
        operations.add(func);
        return this;
    }    
    
    public  SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder amountToStepBy(double value) {
        operations.add(obj -> obj.setAmountToStepBy(value));
        return this;
    }    
    
    public  SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder converter(javafx.util.StringConverter<Double> newValue) {
        operations.add(obj -> obj.setConverter(newValue));
        return this;
    }    
    
    public  SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder max(double value) {
        operations.add(obj -> obj.setMax(value));
        return this;
    }    
    
    public  SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder min(double value) {
        operations.add(obj -> obj.setMin(value));
        return this;
    }    
    
    public  SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder value(Double newValue) {
        operations.add(obj -> obj.setValue(newValue));
        return this;
    }    
    
    public  SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder wrapAround(boolean value) {
        operations.add(obj -> obj.setWrapAround(value));
        return this;
    }    
    
    public SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder amountToStepByPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.amountToStepByProperty()));
        return this;
    }    
    
    public SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder converterPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.StringConverter<Double>>> op) {
        operations.add(obj -> op.accept(obj.converterProperty()));
        return this;
    }    
    
    public SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder maxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxProperty()));
        return this;
    }    
    
    public SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder minPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minProperty()));
        return this;
    }    
    
    public SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder valuePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<Double>> op) {
        operations.add(obj -> op.accept(obj.valueProperty()));
        return this;
    }    
    
    public SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder wrapAroundPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.wrapAroundProperty()));
        return this;
    }
}
