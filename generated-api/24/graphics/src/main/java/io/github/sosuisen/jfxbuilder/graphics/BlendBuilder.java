
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code BlendBuilder} class constructs instances of the {@link javafx.scene.effect.Blend Blend} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.effect.Blend Blend} constructor
 * and returns an instance of the {@code BlendBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.effect.Blend Blend}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.effect.Blend Blend} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class BlendBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.Blend>> operations = new java.util.ArrayList<>();
    private BlendBuilder() {}
    

    /**
     * Returns an instance of the {@code BlendBuilder}.
     *
     * @return an instance of the {@code BlendBuilder}.
     */
    public static BlendBuilder create() { return new BlendBuilder(); }


    /**
     * Accepts the same arguments as {@link javafx.scene.effect.Blend#Blend(javafx.scene.effect.BlendMode mode) Blend(BlendMode)}
     * and returns an instance of the {@code BlendBuilder}.
     *
     * @return an instance of the {@code BlendBuilder}.
     */
    
    public static BlendBuilder create(javafx.scene.effect.BlendMode mode) {
        BlendBuilder builder = new BlendBuilder();
        builder.constructorArgs = new Object[]{mode};
        return builder;
    }


    /**
     * Accepts the same arguments as {@link javafx.scene.effect.Blend#Blend(javafx.scene.effect.BlendMode mode, javafx.scene.effect.Effect bottomInput, javafx.scene.effect.Effect topInput) Blend(BlendMode, Effect, Effect)}
     * and returns an instance of the {@code BlendBuilder}.
     *
     * @return an instance of the {@code BlendBuilder}.
     */
    
    public static BlendBuilder create(javafx.scene.effect.BlendMode mode, javafx.scene.effect.Effect bottomInput, javafx.scene.effect.Effect topInput) {
        BlendBuilder builder = new BlendBuilder();
        builder.constructorArgs = new Object[]{mode, bottomInput, topInput};
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
     * @return new instance of the {@link javafx.scene.effect.Blend Blend} class
     */
    public javafx.scene.effect.Blend build() {
        javafx.scene.effect.Blend newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.Blend();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.Blend> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.Blend callParameterizedConstructor() {
        javafx.scene.effect.Blend newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.Blend.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.Blend) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Blend instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public BlendBuilder apply(java.util.function.Consumer<javafx.scene.effect.Blend> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Blend#setBottomInput(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  BlendBuilder bottomInput(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setBottomInput(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Blend#setMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  BlendBuilder mode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Blend#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  BlendBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Blend#setTopInput(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  BlendBuilder topInput(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setTopInput(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Blend#bottomInputProperty() bottomInputProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.Blend> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.bottomInputProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .bottomInputPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public BlendBuilder bottomInputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.bottomInputProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Blend#modeProperty() modeProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.Blend> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.modeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .modePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public BlendBuilder modePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.modeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Blend#opacityProperty() opacityProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.Blend> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.opacityProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .opacityPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public BlendBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Blend#topInputProperty() topInputProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.Blend> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.topInputProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .topInputPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public BlendBuilder topInputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.topInputProperty()));
        return this;
    }
}
