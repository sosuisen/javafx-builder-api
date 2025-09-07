
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code ColorAdjustBuilder} class constructs instances of the {@link javafx.scene.effect.ColorAdjust ColorAdjust} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.effect.ColorAdjust ColorAdjust} constructor
 * and returns an instance of the {@code ColorAdjustBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.effect.ColorAdjust ColorAdjust}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.effect.ColorAdjust ColorAdjust} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class ColorAdjustBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.ColorAdjust>> operations = new java.util.ArrayList<>();
    private ColorAdjustBuilder() {}
    
    /**
     * Returns an instance of the {@code ColorAdjustBuilder}.
     *
     * @return an instance of the {@code ColorAdjustBuilder}.
     */
    public static ColorAdjustBuilder create() { return new ColorAdjustBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.effect.ColorAdjust#ColorAdjust(double, double, double, double) ColorAdjust(double, double, double, double)}
     * and returns an instance of {@code ColorAdjustBuilder}.
     *
     * @return an instance of the {@code ColorAdjustBuilder}.
     */
    
    public static ColorAdjustBuilder create(double hue, double saturation, double brightness, double contrast) {
        ColorAdjustBuilder builder = new ColorAdjustBuilder();
        builder.constructorArgs = new Object[]{hue, saturation, brightness, contrast};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.effect.ColorAdjust} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.effect.ColorAdjust ColorAdjust} class
     */
    public javafx.scene.effect.ColorAdjust build() {
        javafx.scene.effect.ColorAdjust newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.ColorAdjust();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.ColorAdjust> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.ColorAdjust callParameterizedConstructor() {
        javafx.scene.effect.ColorAdjust newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.ColorAdjust.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.ColorAdjust) constructor.newInstance(constructorArgs);
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
     * Applies a function to the ColorAdjust instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public ColorAdjustBuilder apply(java.util.function.Consumer<javafx.scene.effect.ColorAdjust> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.ColorAdjust#setBrightness(double) setBrightness} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ColorAdjustBuilder brightness(double value) {
        operations.add(obj -> obj.setBrightness(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.ColorAdjust#setContrast(double) setContrast} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ColorAdjustBuilder contrast(double value) {
        operations.add(obj -> obj.setContrast(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.ColorAdjust#setHue(double) setHue} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ColorAdjustBuilder hue(double value) {
        operations.add(obj -> obj.setHue(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.ColorAdjust#setInput(javafx.scene.effect.Effect) setInput} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ColorAdjustBuilder input(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setInput(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.ColorAdjust#setSaturation(double) setSaturation} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ColorAdjustBuilder saturation(double value) {
        operations.add(obj -> obj.setSaturation(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.ColorAdjust#brightnessProperty() brightnessProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.ColorAdjust> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.brightnessProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .brightnessPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ColorAdjustBuilder brightnessPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.brightnessProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.ColorAdjust#contrastProperty() contrastProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.ColorAdjust> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.contrastProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .contrastPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ColorAdjustBuilder contrastPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.contrastProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.ColorAdjust#hueProperty() hueProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.ColorAdjust> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.hueProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .huePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ColorAdjustBuilder huePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.hueProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.ColorAdjust#inputProperty() inputProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.ColorAdjust> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.inputProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .inputPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ColorAdjustBuilder inputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.inputProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.ColorAdjust#saturationProperty() saturationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.ColorAdjust> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.saturationProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .saturationPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ColorAdjustBuilder saturationPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.saturationProperty()));
        return this;
    }
}
