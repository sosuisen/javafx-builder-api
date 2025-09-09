
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code ArcToBuilder} class constructs instances of the {@link javafx.scene.shape.ArcTo ArcTo} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.shape.ArcTo ArcTo} constructor
 * and returns an instance of the {@code ArcToBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.shape.ArcTo ArcTo}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.shape.ArcTo ArcTo} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class ArcToBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.shape.ArcTo>> operations = new java.util.ArrayList<>();
    private ArcToBuilder() {}
    
    /**
     * Returns an instance of the {@code ArcToBuilder}.
     *
     * @return an instance of the {@code ArcToBuilder}.
     */
    public static ArcToBuilder create() { return new ArcToBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.shape.ArcTo#ArcTo(double, double, double, double, double, boolean, boolean) ArcTo(double, double, double, double, double, boolean, boolean)}
     * and returns an instance of {@code ArcToBuilder}.
     *
     * @return an instance of the {@code ArcToBuilder}.
     */
    public static ArcToBuilder create(double radiusX, double radiusY, double xAxisRotation, double x, double y, boolean largeArcFlag, boolean sweepFlag) {
        ArcToBuilder builder = new ArcToBuilder();
        builder.constructorArgs = new Object[]{radiusX, radiusY, xAxisRotation, x, y, largeArcFlag, sweepFlag};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.shape.ArcTo} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.shape.ArcTo ArcTo} class
     */
    public javafx.scene.shape.ArcTo build() {
        javafx.scene.shape.ArcTo newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.shape.ArcTo();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.shape.ArcTo> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.shape.ArcTo callParameterizedConstructor() {
        javafx.scene.shape.ArcTo newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.shape.ArcTo.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.shape.ArcTo) constructor.newInstance(constructorArgs);
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
     * Applies a function to the ArcTo instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public ArcToBuilder apply(java.util.function.Consumer<javafx.scene.shape.ArcTo> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.PathElement#setAbsolute(boolean) setAbsolute} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ArcToBuilder absolute(boolean value) {
        operations.add(obj -> obj.setAbsolute(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.ArcTo#setLargeArcFlag(boolean) setLargeArcFlag} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ArcToBuilder largeArcFlag(boolean value) {
        operations.add(obj -> obj.setLargeArcFlag(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.ArcTo#setRadiusX(double) setRadiusX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ArcToBuilder radiusX(double value) {
        operations.add(obj -> obj.setRadiusX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.ArcTo#setRadiusY(double) setRadiusY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ArcToBuilder radiusY(double value) {
        operations.add(obj -> obj.setRadiusY(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.ArcTo#setSweepFlag(boolean) setSweepFlag} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ArcToBuilder sweepFlag(boolean value) {
        operations.add(obj -> obj.setSweepFlag(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.ArcTo#setX(double) setX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ArcToBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.ArcTo#setXAxisRotation(double) setXAxisRotation} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ArcToBuilder xAxisRotation(double value) {
        operations.add(obj -> obj.setXAxisRotation(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.ArcTo#setY(double) setY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ArcToBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.ArcTo#XAxisRotationProperty() XAxisRotationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ArcToBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.XAxisRotationProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .XAxisRotationPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ArcToBuilder XAxisRotationPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.XAxisRotationProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.ArcTo#absoluteProperty() absoluteProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ArcToBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.absoluteProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .absolutePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ArcToBuilder absolutePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.absoluteProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.ArcTo#largeArcFlagProperty() largeArcFlagProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ArcToBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.largeArcFlagProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .largeArcFlagPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ArcToBuilder largeArcFlagPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.largeArcFlagProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.ArcTo#radiusXProperty() radiusXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ArcToBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.radiusXProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .radiusXPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ArcToBuilder radiusXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.radiusXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.ArcTo#radiusYProperty() radiusYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ArcToBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.radiusYProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .radiusYPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ArcToBuilder radiusYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.radiusYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.ArcTo#sweepFlagProperty() sweepFlagProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ArcToBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.sweepFlagProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .sweepFlagPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ArcToBuilder sweepFlagPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.sweepFlagProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.ArcTo#xProperty() xProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ArcToBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ArcToBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.ArcTo#yProperty() yProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ArcToBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ArcToBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
