
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code MotionBlurBuilder} class constructs instances of the {@link javafx.scene.effect.MotionBlur MotionBlur} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.effect.MotionBlur MotionBlur} constructor
 * and returns an instance of the {@code MotionBlurBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.effect.MotionBlur MotionBlur}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.effect.MotionBlur MotionBlur} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class MotionBlurBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.MotionBlur>> operations = new java.util.ArrayList<>();
    private MotionBlurBuilder() {}
    
    /**
     * Returns an instance of the {@code MotionBlurBuilder}.
     *
     * @return an instance of the {@code MotionBlurBuilder}.
     */
    public static MotionBlurBuilder create() { return new MotionBlurBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.effect.MotionBlur#MotionBlur(double, double) MotionBlur(double, double)}
     * and returns an instance of {@code MotionBlurBuilder}.
     *
     * @return an instance of the {@code MotionBlurBuilder}.
     */
    
    public static MotionBlurBuilder create(double angle, double radius) {
        MotionBlurBuilder builder = new MotionBlurBuilder();
        builder.constructorArgs = new Object[]{angle, radius};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.effect.MotionBlur} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.effect.MotionBlur MotionBlur} class
     */
    public javafx.scene.effect.MotionBlur build() {
        javafx.scene.effect.MotionBlur newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.MotionBlur();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.MotionBlur> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.MotionBlur callParameterizedConstructor() {
        javafx.scene.effect.MotionBlur newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.MotionBlur.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.MotionBlur) constructor.newInstance(constructorArgs);
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
     * Applies a function to the MotionBlur instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public MotionBlurBuilder apply(java.util.function.Consumer<javafx.scene.effect.MotionBlur> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.MotionBlur#setAngle(double) setAngle} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MotionBlurBuilder angle(double value) {
        operations.add(obj -> obj.setAngle(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.MotionBlur#setInput(javafx.scene.effect.Effect) setInput} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MotionBlurBuilder input(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setInput(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.MotionBlur#setRadius(double) setRadius} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MotionBlurBuilder radius(double value) {
        operations.add(obj -> obj.setRadius(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.MotionBlur#angleProperty() angleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link MotionBlurBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.angleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .anglePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public MotionBlurBuilder anglePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.angleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.MotionBlur#inputProperty() inputProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link MotionBlurBuilder#apply(java.util.function.Consumer) apply} method.
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
    public MotionBlurBuilder inputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.inputProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.MotionBlur#radiusProperty() radiusProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link MotionBlurBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.radiusProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .radiusPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public MotionBlurBuilder radiusPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.radiusProperty()));
        return this;
    }
}
