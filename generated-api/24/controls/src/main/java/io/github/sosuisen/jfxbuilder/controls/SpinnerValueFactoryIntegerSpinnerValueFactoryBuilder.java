
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
    private java.util.List<java.util.function.Consumer<javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory>> operations = new java.util.ArrayList<>();
    private SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder() {}
    

    
    public static SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder create(int min, int max) {
        SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder builder = new SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder();
        builder.constructorArgs = new Object[]{min, max};
        return builder;
    }


    
    public static SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder create(int min, int max, int initialValue) {
        SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder builder = new SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder();
        builder.constructorArgs = new Object[]{min, max, initialValue};
        return builder;
    }


    
    public static SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder create(int min, int max, int initialValue, int amountToStepBy) {
        SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder builder = new SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder();
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
     * Applies a function to the IntegerSpinnerValueFactory instance currently being built.
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
     * Builder method for {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#setAmountToStepBy(int)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder amountToStepBy(int value) {
        operations.add(obj -> obj.setAmountToStepBy(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#setConverter(javafx.util.StringConverter)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder converter(javafx.util.StringConverter<Integer> newValue) {
        operations.add(obj -> obj.setConverter(newValue));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#setMax(int)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder max(int value) {
        operations.add(obj -> obj.setMax(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#setMin(int)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder min(int value) {
        operations.add(obj -> obj.setMin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#setValue(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder value(Integer newValue) {
        operations.add(obj -> obj.setValue(newValue));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#setWrapAround(boolean)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder wrapAround(boolean value) {
        operations.add(obj -> obj.setWrapAround(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#amountToStepByProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder amountToStepByPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.amountToStepByProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#converterProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder converterPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.StringConverter<Integer>>> op) {
        operations.add(obj -> op.accept(obj.converterProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#maxProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder maxPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.maxProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#minProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder minPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.minProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#valueProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder valuePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<Integer>> op) {
        operations.add(obj -> op.accept(obj.valueProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory#wrapAroundProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerValueFactoryIntegerSpinnerValueFactoryBuilder wrapAroundPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.wrapAroundProperty()));
        return this;
    }
}
