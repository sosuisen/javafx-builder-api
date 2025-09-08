
package io.github.sosuisen.jfxbuilder.media;

/**
 * The {@code EqualizerBandBuilder} class constructs instances of the {@link javafx.scene.media.EqualizerBand EqualizerBand} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.media.EqualizerBand EqualizerBand} constructor
 * and returns an instance of the {@code EqualizerBandBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.media.EqualizerBand EqualizerBand}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.media.EqualizerBand EqualizerBand} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class EqualizerBandBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.media.EqualizerBand>> operations = new java.util.ArrayList<>();
    private EqualizerBandBuilder() {}
    
    /**
     * Returns an instance of the {@code EqualizerBandBuilder}.
     *
     * @return an instance of the {@code EqualizerBandBuilder}.
     */
    public static EqualizerBandBuilder create() { return new EqualizerBandBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.media.EqualizerBand#EqualizerBand(double, double, double) EqualizerBand(double, double, double)}
     * and returns an instance of {@code EqualizerBandBuilder}.
     *
     * @return an instance of the {@code EqualizerBandBuilder}.
     */
    public static EqualizerBandBuilder create(double centerFrequency, double bandwidth, double gain) {
        EqualizerBandBuilder builder = new EqualizerBandBuilder();
        builder.constructorArgs = new Object[]{centerFrequency, bandwidth, gain};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.media.EqualizerBand} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.media.EqualizerBand EqualizerBand} class
     */
    public javafx.scene.media.EqualizerBand build() {
        javafx.scene.media.EqualizerBand newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.media.EqualizerBand();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.media.EqualizerBand> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.media.EqualizerBand callParameterizedConstructor() {
        javafx.scene.media.EqualizerBand newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.media.EqualizerBand.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.media.EqualizerBand) constructor.newInstance(constructorArgs);
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
     * Applies a function to the EqualizerBand instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public EqualizerBandBuilder apply(java.util.function.Consumer<javafx.scene.media.EqualizerBand> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.media.EqualizerBand#setBandwidth(double) setBandwidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  EqualizerBandBuilder bandwidth(double value) {
        operations.add(obj -> obj.setBandwidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.media.EqualizerBand#setCenterFrequency(double) setCenterFrequency} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  EqualizerBandBuilder centerFrequency(double value) {
        operations.add(obj -> obj.setCenterFrequency(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.media.EqualizerBand#setGain(double) setGain} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  EqualizerBandBuilder gain(double value) {
        operations.add(obj -> obj.setGain(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.media.EqualizerBand#bandwidthProperty() bandwidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link EqualizerBandBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.bandwidthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .bandwidthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public EqualizerBandBuilder bandwidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.bandwidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.media.EqualizerBand#centerFrequencyProperty() centerFrequencyProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link EqualizerBandBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.centerFrequencyProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .centerFrequencyPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public EqualizerBandBuilder centerFrequencyPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.centerFrequencyProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.media.EqualizerBand#gainProperty() gainProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link EqualizerBandBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.gainProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .gainPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public EqualizerBandBuilder gainPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.gainProperty()));
        return this;
    }
}
