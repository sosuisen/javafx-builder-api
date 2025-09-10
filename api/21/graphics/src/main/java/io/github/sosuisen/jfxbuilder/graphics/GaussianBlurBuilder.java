
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code GaussianBlurBuilder} class constructs instances of the {@link javafx.scene.effect.GaussianBlur GaussianBlur} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.effect.GaussianBlur GaussianBlur} constructor
 * and returns an instance of the {@code GaussianBlurBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.effect.GaussianBlur GaussianBlur}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.effect.GaussianBlur GaussianBlur} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class GaussianBlurBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.effect.GaussianBlur>> operations = new java.util.ArrayList<>();
    private GaussianBlurBuilder() {}
    
    /**
     * Returns an instance of the {@code GaussianBlurBuilder}.
     *
     * @return an instance of the {@code GaussianBlurBuilder}.
     */
    public static GaussianBlurBuilder create() { return new GaussianBlurBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.effect.GaussianBlur#GaussianBlur(double) GaussianBlur(double)}
     * and returns an instance of {@code GaussianBlurBuilder}.
     *
     * @return an instance of the {@code GaussianBlurBuilder}.
     */
    public static GaussianBlurBuilder create(double radius) {
        GaussianBlurBuilder builder = new GaussianBlurBuilder();
        builder.constructorArgs = new Object[]{radius};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.effect.GaussianBlur GaussianBlur} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.effect.GaussianBlur GaussianBlur} class
     */
    public javafx.scene.effect.GaussianBlur build() {
        javafx.scene.effect.GaussianBlur newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.GaussianBlur();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.GaussianBlur> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.GaussianBlur callParameterizedConstructor() {
        javafx.scene.effect.GaussianBlur newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.GaussianBlur.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.GaussianBlur) constructor.newInstance(constructorArgs);
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
     * Applies a function to the GaussianBlur instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public GaussianBlurBuilder apply(java.util.function.Consumer<javafx.scene.effect.GaussianBlur> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.GaussianBlur#setInput(javafx.scene.effect.Effect) setInput} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  GaussianBlurBuilder input(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setInput(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.GaussianBlur#setRadius(double) setRadius} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  GaussianBlurBuilder radius(double value) {
        operations.add(obj -> obj.setRadius(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.GaussianBlur#inputProperty() inputProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link GaussianBlurBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * {@snippet :
     * // Use apply
     * .apply(obj -> obj.inputProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .inputPropertyApply(prop -> prop.bind(anotherProperty))
     * }
     *
     * @return builder instance
     */
    public GaussianBlurBuilder inputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.inputProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.GaussianBlur#radiusProperty() radiusProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link GaussianBlurBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * {@snippet :
     * // Use apply
     * .apply(obj -> obj.radiusProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .radiusPropertyApply(prop -> prop.bind(anotherProperty))
     * }
     *
     * @return builder instance
     */
    public GaussianBlurBuilder radiusPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.radiusProperty()));
        return this;
    }
}
