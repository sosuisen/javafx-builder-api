
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

    /**
     * This method builds and returns an instance of the original class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the build() method
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
     * Applies a function to the DoubleSpinnerValueFactory instance currently being built.
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
     * Builder method for {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#setAmountToStepBy(double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder amountToStepBy(double value) {
        operations.add(obj -> obj.setAmountToStepBy(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#setConverter(javafx.util.StringConverter)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder converter(javafx.util.StringConverter<Double> newValue) {
        operations.add(obj -> obj.setConverter(newValue));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#setMax(double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder max(double value) {
        operations.add(obj -> obj.setMax(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#setMin(double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder min(double value) {
        operations.add(obj -> obj.setMin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#setValue(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder value(Double newValue) {
        operations.add(obj -> obj.setValue(newValue));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#setWrapAround(boolean)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder wrapAround(boolean value) {
        operations.add(obj -> obj.setWrapAround(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#amountToStepByProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder amountToStepByPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.amountToStepByProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#converterProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder converterPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.StringConverter<Double>>> op) {
        operations.add(obj -> op.accept(obj.converterProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#maxProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder maxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#minProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder minPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#valueProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder valuePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<Double>> op) {
        operations.add(obj -> op.accept(obj.valueProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory#wrapAroundProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerValueFactoryDoubleSpinnerValueFactoryBuilder wrapAroundPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.wrapAroundProperty()));
        return this;
    }
}
