
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code GlowBuilder} class constructs instances of the {@link javafx.scene.effect.Glow Glow} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.effect.Glow Glow} constructor
 * and returns an instance of the {@code GlowBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.effect.Glow Glow}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.effect.Glow Glow} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class GlowBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.effect.Glow>> operations = new java.util.ArrayList<>();
    private GlowBuilder() {}
    
    /**
     * Returns an instance of the {@code GlowBuilder}.
     *
     * @return an instance of the {@code GlowBuilder}.
     */
    public static GlowBuilder create() { return new GlowBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.effect.Glow#Glow(double) Glow(double)}
     * and returns an instance of {@code GlowBuilder}.
     *
     * @return an instance of the {@code GlowBuilder}.
     */
    public static GlowBuilder create(double level) {
        GlowBuilder builder = new GlowBuilder();
        builder.constructorArgs = new Object[]{level};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.effect.Glow} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.effect.Glow Glow} class
     */
    public javafx.scene.effect.Glow build() {
        javafx.scene.effect.Glow newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.Glow();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.Glow> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.Glow callParameterizedConstructor() {
        javafx.scene.effect.Glow newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.Glow.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.Glow) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Glow instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public GlowBuilder apply(java.util.function.Consumer<javafx.scene.effect.Glow> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.Glow#setInput(javafx.scene.effect.Effect) setInput} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  GlowBuilder input(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setInput(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.Glow#setLevel(double) setLevel} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  GlowBuilder level(double value) {
        operations.add(obj -> obj.setLevel(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.Glow#inputProperty() inputProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link GlowBuilder#apply(java.util.function.Consumer) apply} method.
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
    public GlowBuilder inputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.inputProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.Glow#levelProperty() levelProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link GlowBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.levelProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .levelPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public GlowBuilder levelPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.levelProperty()));
        return this;
    }
}
