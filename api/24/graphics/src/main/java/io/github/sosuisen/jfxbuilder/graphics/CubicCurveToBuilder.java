
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code CubicCurveToBuilder} class constructs instances of the {@link javafx.scene.shape.CubicCurveTo CubicCurveTo} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.shape.CubicCurveTo CubicCurveTo} constructor
 * and returns an instance of the {@code CubicCurveToBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.shape.CubicCurveTo CubicCurveTo}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.shape.CubicCurveTo CubicCurveTo} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class CubicCurveToBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.shape.CubicCurveTo>> operations = new java.util.ArrayList<>();
    private CubicCurveToBuilder() {}
    
    /**
     * Returns an instance of the {@code CubicCurveToBuilder}.
     *
     * @return an instance of the {@code CubicCurveToBuilder}.
     */
    public static CubicCurveToBuilder create() { return new CubicCurveToBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.shape.CubicCurveTo#CubicCurveTo(double, double, double, double, double, double) CubicCurveTo(double, double, double, double, double, double)}
     * and returns an instance of {@code CubicCurveToBuilder}.
     *
     * @return an instance of the {@code CubicCurveToBuilder}.
     */
    public static CubicCurveToBuilder create(double controlX1, double controlY1, double controlX2, double controlY2, double x, double y) {
        CubicCurveToBuilder builder = new CubicCurveToBuilder();
        builder.constructorArgs = new Object[]{controlX1, controlY1, controlX2, controlY2, x, y};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.shape.CubicCurveTo} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.shape.CubicCurveTo CubicCurveTo} class
     */
    public javafx.scene.shape.CubicCurveTo build() {
        javafx.scene.shape.CubicCurveTo newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.shape.CubicCurveTo();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.shape.CubicCurveTo> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.shape.CubicCurveTo callParameterizedConstructor() {
        javafx.scene.shape.CubicCurveTo newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.shape.CubicCurveTo.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.shape.CubicCurveTo) constructor.newInstance(constructorArgs);
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
     * Applies a function to the CubicCurveTo instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public CubicCurveToBuilder apply(java.util.function.Consumer<javafx.scene.shape.CubicCurveTo> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.PathElement#setAbsolute(boolean) setAbsolute} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  CubicCurveToBuilder absolute(boolean value) {
        operations.add(obj -> obj.setAbsolute(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.CubicCurveTo#setControlX1(double) setControlX1} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  CubicCurveToBuilder controlX1(double value) {
        operations.add(obj -> obj.setControlX1(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.CubicCurveTo#setControlX2(double) setControlX2} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  CubicCurveToBuilder controlX2(double value) {
        operations.add(obj -> obj.setControlX2(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.CubicCurveTo#setControlY1(double) setControlY1} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  CubicCurveToBuilder controlY1(double value) {
        operations.add(obj -> obj.setControlY1(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.CubicCurveTo#setControlY2(double) setControlY2} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  CubicCurveToBuilder controlY2(double value) {
        operations.add(obj -> obj.setControlY2(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.CubicCurveTo#setX(double) setX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  CubicCurveToBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.CubicCurveTo#setY(double) setY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  CubicCurveToBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurveTo#absoluteProperty() absoluteProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link CubicCurveToBuilder#apply(java.util.function.Consumer) apply} method.
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
    public CubicCurveToBuilder absolutePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.absoluteProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurveTo#controlX1Property() controlX1Property} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link CubicCurveToBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.controlX1Property().bind(anotherProperty))
     *
     * // Use shorthand form
     * .controlX1PropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public CubicCurveToBuilder controlX1PropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.controlX1Property()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurveTo#controlX2Property() controlX2Property} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link CubicCurveToBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.controlX2Property().bind(anotherProperty))
     *
     * // Use shorthand form
     * .controlX2PropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public CubicCurveToBuilder controlX2PropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.controlX2Property()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurveTo#controlY1Property() controlY1Property} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link CubicCurveToBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.controlY1Property().bind(anotherProperty))
     *
     * // Use shorthand form
     * .controlY1PropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public CubicCurveToBuilder controlY1PropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.controlY1Property()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurveTo#controlY2Property() controlY2Property} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link CubicCurveToBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.controlY2Property().bind(anotherProperty))
     *
     * // Use shorthand form
     * .controlY2PropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public CubicCurveToBuilder controlY2PropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.controlY2Property()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurveTo#xProperty() xProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link CubicCurveToBuilder#apply(java.util.function.Consumer) apply} method.
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
    public CubicCurveToBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurveTo#yProperty() yProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link CubicCurveToBuilder#apply(java.util.function.Consumer) apply} method.
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
    public CubicCurveToBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
