
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code LightSpotBuilder} class constructs instances of the {@link javafx.scene.effect.Light.Spot Spot} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.effect.Light.Spot Spot} constructor
 * and returns an instance of the {@code LightSpotBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.effect.Light.Spot Spot}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.effect.Light.Spot Spot} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class LightSpotBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.effect.Light.Spot>> operations = new java.util.ArrayList<>();
    private LightSpotBuilder() {}
    
    /**
     * Returns an instance of the {@code LightSpotBuilder}.
     *
     * @return an instance of the {@code LightSpotBuilder}.
     */
    public static LightSpotBuilder create() { return new LightSpotBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.effect.Light.Spot#Spot(double, double, double, double, javafx.scene.paint.Color) Spot(double, double, double, double, Color)}
     * and returns an instance of {@code LightSpotBuilder}.
     *
     * @return an instance of the {@code LightSpotBuilder}.
     */
    public static LightSpotBuilder create(double x, double y, double z, double specularExponent, javafx.scene.paint.Color color) {
        LightSpotBuilder builder = new LightSpotBuilder();
        builder.constructorArgs = new Object[]{x, y, z, specularExponent, color};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.effect.Light.Spot} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.effect.Light.Spot Spot} class
     */
    public javafx.scene.effect.Light.Spot build() {
        javafx.scene.effect.Light.Spot newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.Light.Spot();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.Light.Spot> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.Light.Spot callParameterizedConstructor() {
        javafx.scene.effect.Light.Spot newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.Light.Spot.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.Light.Spot) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Spot instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public LightSpotBuilder apply(java.util.function.Consumer<javafx.scene.effect.Light.Spot> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.Light#setColor(javafx.scene.paint.Color) setColor} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  LightSpotBuilder color(javafx.scene.paint.Color value) {
        operations.add(obj -> obj.setColor(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.Light.Spot#setPointsAtX(double) setPointsAtX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  LightSpotBuilder pointsAtX(double value) {
        operations.add(obj -> obj.setPointsAtX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.Light.Spot#setPointsAtY(double) setPointsAtY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  LightSpotBuilder pointsAtY(double value) {
        operations.add(obj -> obj.setPointsAtY(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.Light.Spot#setPointsAtZ(double) setPointsAtZ} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  LightSpotBuilder pointsAtZ(double value) {
        operations.add(obj -> obj.setPointsAtZ(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.Light.Spot#setSpecularExponent(double) setSpecularExponent} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  LightSpotBuilder specularExponent(double value) {
        operations.add(obj -> obj.setSpecularExponent(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.Light.Point#setX(double) setX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  LightSpotBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.Light.Point#setY(double) setY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  LightSpotBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.Light.Point#setZ(double) setZ} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  LightSpotBuilder z(double value) {
        operations.add(obj -> obj.setZ(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Spot#colorProperty() colorProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link LightSpotBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.colorProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .colorPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public LightSpotBuilder colorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Color>> op) {
        operations.add(obj -> op.accept(obj.colorProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Spot#pointsAtXProperty() pointsAtXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link LightSpotBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.pointsAtXProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .pointsAtXPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public LightSpotBuilder pointsAtXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pointsAtXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Spot#pointsAtYProperty() pointsAtYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link LightSpotBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.pointsAtYProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .pointsAtYPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public LightSpotBuilder pointsAtYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pointsAtYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Spot#pointsAtZProperty() pointsAtZProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link LightSpotBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.pointsAtZProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .pointsAtZPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public LightSpotBuilder pointsAtZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pointsAtZProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Spot#specularExponentProperty() specularExponentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link LightSpotBuilder#apply(java.util.function.Consumer) apply} method.
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
    public LightSpotBuilder specularExponentPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.specularExponentProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Spot#xProperty() xProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link LightSpotBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.xProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .xPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public LightSpotBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Spot#yProperty() yProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link LightSpotBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.yProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .yPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public LightSpotBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Spot#zProperty() zProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link LightSpotBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.zProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .zPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public LightSpotBuilder zPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.zProperty()));
        return this;
    }
}
