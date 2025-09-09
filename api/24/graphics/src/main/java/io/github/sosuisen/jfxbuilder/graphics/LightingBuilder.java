
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code LightingBuilder} class constructs instances of the {@link javafx.scene.effect.Lighting Lighting} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.effect.Lighting Lighting} constructor
 * and returns an instance of the {@code LightingBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.effect.Lighting Lighting}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.effect.Lighting Lighting} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class LightingBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.effect.Lighting>> operations = new java.util.ArrayList<>();
    private LightingBuilder() {}
    
    /**
     * Returns an instance of the {@code LightingBuilder}.
     *
     * @return an instance of the {@code LightingBuilder}.
     */
    public static LightingBuilder create() { return new LightingBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.effect.Lighting#Lighting(javafx.scene.effect.Light) Lighting(Light)}
     * and returns an instance of {@code LightingBuilder}.
     *
     * @return an instance of the {@code LightingBuilder}.
     */
    public static LightingBuilder create(javafx.scene.effect.Light light) {
        LightingBuilder builder = new LightingBuilder();
        builder.constructorArgs = new Object[]{light};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.effect.Lighting Lighting} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.effect.Lighting Lighting} class
     */
    public javafx.scene.effect.Lighting build() {
        javafx.scene.effect.Lighting newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.Lighting();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.Lighting> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.Lighting callParameterizedConstructor() {
        javafx.scene.effect.Lighting newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.Lighting.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.Lighting) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Lighting instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public LightingBuilder apply(java.util.function.Consumer<javafx.scene.effect.Lighting> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.Lighting#setBumpInput(javafx.scene.effect.Effect) setBumpInput} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  LightingBuilder bumpInput(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setBumpInput(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.Lighting#setContentInput(javafx.scene.effect.Effect) setContentInput} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  LightingBuilder contentInput(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setContentInput(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.Lighting#setDiffuseConstant(double) setDiffuseConstant} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  LightingBuilder diffuseConstant(double value) {
        operations.add(obj -> obj.setDiffuseConstant(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.Lighting#setLight(javafx.scene.effect.Light) setLight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  LightingBuilder light(javafx.scene.effect.Light value) {
        operations.add(obj -> obj.setLight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.Lighting#setSpecularConstant(double) setSpecularConstant} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  LightingBuilder specularConstant(double value) {
        operations.add(obj -> obj.setSpecularConstant(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.Lighting#setSpecularExponent(double) setSpecularExponent} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  LightingBuilder specularExponent(double value) {
        operations.add(obj -> obj.setSpecularExponent(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.Lighting#setSurfaceScale(double) setSurfaceScale} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  LightingBuilder surfaceScale(double value) {
        operations.add(obj -> obj.setSurfaceScale(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.Lighting#bumpInputProperty() bumpInputProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link LightingBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.bumpInputProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .bumpInputPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public LightingBuilder bumpInputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.bumpInputProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.Lighting#contentInputProperty() contentInputProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link LightingBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.contentInputProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .contentInputPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public LightingBuilder contentInputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.contentInputProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.Lighting#diffuseConstantProperty() diffuseConstantProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link LightingBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.diffuseConstantProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .diffuseConstantPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public LightingBuilder diffuseConstantPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.diffuseConstantProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.Lighting#lightProperty() lightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link LightingBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.lightProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .lightPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public LightingBuilder lightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Light>> op) {
        operations.add(obj -> op.accept(obj.lightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.Lighting#specularConstantProperty() specularConstantProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link LightingBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.specularConstantProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .specularConstantPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public LightingBuilder specularConstantPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.specularConstantProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.Lighting#specularExponentProperty() specularExponentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link LightingBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.specularExponentProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .specularExponentPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public LightingBuilder specularExponentPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.specularExponentProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.Lighting#surfaceScaleProperty() surfaceScaleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link LightingBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.surfaceScaleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .surfaceScalePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public LightingBuilder surfaceScalePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.surfaceScaleProperty()));
        return this;
    }
}
