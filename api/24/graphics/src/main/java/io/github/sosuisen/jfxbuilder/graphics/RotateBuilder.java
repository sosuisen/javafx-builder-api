
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code RotateBuilder} class constructs instances of the {@link javafx.scene.transform.Rotate Rotate} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.transform.Rotate Rotate} constructor
 * and returns an instance of the {@code RotateBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.transform.Rotate Rotate}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.transform.Rotate Rotate} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class RotateBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.transform.Rotate>> operations = new java.util.ArrayList<>();
    private RotateBuilder() {}
    
    /**
     * Returns an instance of the {@code RotateBuilder}.
     *
     * @return an instance of the {@code RotateBuilder}.
     */
    public static RotateBuilder create() { return new RotateBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.transform.Rotate#Rotate(double) Rotate(double)}
     * and returns an instance of {@code RotateBuilder}.
     *
     * @return an instance of the {@code RotateBuilder}.
     */
    public static RotateBuilder create(double angle) {
        RotateBuilder builder = new RotateBuilder();
        builder.constructorArgs = new Object[]{angle};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.transform.Rotate#Rotate(double, double, double) Rotate(double, double, double)}
     * and returns an instance of {@code RotateBuilder}.
     *
     * @return an instance of the {@code RotateBuilder}.
     */
    public static RotateBuilder create(double angle, double pivotX, double pivotY) {
        RotateBuilder builder = new RotateBuilder();
        builder.constructorArgs = new Object[]{angle, pivotX, pivotY};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.transform.Rotate#Rotate(double, double, double, double) Rotate(double, double, double, double)}
     * and returns an instance of {@code RotateBuilder}.
     *
     * @return an instance of the {@code RotateBuilder}.
     */
    public static RotateBuilder create(double angle, double pivotX, double pivotY, double pivotZ) {
        RotateBuilder builder = new RotateBuilder();
        builder.constructorArgs = new Object[]{angle, pivotX, pivotY, pivotZ};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.transform.Rotate#Rotate(double, double, double, double, javafx.geometry.Point3D) Rotate(double, double, double, double, Point3D)}
     * and returns an instance of {@code RotateBuilder}.
     *
     * @return an instance of the {@code RotateBuilder}.
     */
    public static RotateBuilder create(double angle, double pivotX, double pivotY, double pivotZ, javafx.geometry.Point3D axis) {
        RotateBuilder builder = new RotateBuilder();
        builder.constructorArgs = new Object[]{angle, pivotX, pivotY, pivotZ, axis};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.transform.Rotate#Rotate(double, javafx.geometry.Point3D) Rotate(double, Point3D)}
     * and returns an instance of {@code RotateBuilder}.
     *
     * @return an instance of the {@code RotateBuilder}.
     */
    public static RotateBuilder create(double angle, javafx.geometry.Point3D axis) {
        RotateBuilder builder = new RotateBuilder();
        builder.constructorArgs = new Object[]{angle, axis};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.transform.Rotate Rotate} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.transform.Rotate Rotate} class
     */
    public javafx.scene.transform.Rotate build() {
        javafx.scene.transform.Rotate newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.transform.Rotate();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.transform.Rotate> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.transform.Rotate callParameterizedConstructor() {
        javafx.scene.transform.Rotate newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.transform.Rotate.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.transform.Rotate) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Rotate instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public RotateBuilder apply(java.util.function.Consumer<javafx.scene.transform.Rotate> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Rotate#setAngle(double) setAngle} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  RotateBuilder angle(double value) {
        operations.add(obj -> obj.setAngle(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Rotate#setAxis(javafx.geometry.Point3D) setAxis} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  RotateBuilder axis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setAxis(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Transform#setOnTransformChanged(javafx.event.EventHandler) setOnTransformChanged} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  RotateBuilder onTransformChanged(javafx.event.EventHandler<? super javafx.scene.transform.TransformChangedEvent> value) {
        operations.add(obj -> obj.setOnTransformChanged(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Rotate#setPivotX(double) setPivotX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  RotateBuilder pivotX(double value) {
        operations.add(obj -> obj.setPivotX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Rotate#setPivotY(double) setPivotY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  RotateBuilder pivotY(double value) {
        operations.add(obj -> obj.setPivotY(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Rotate#setPivotZ(double) setPivotZ} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  RotateBuilder pivotZ(double value) {
        operations.add(obj -> obj.setPivotZ(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Rotate#angleProperty() angleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RotateBuilder#apply(java.util.function.Consumer) apply} method.
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
    public RotateBuilder anglePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.angleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Rotate#axisProperty() axisProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RotateBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.axisProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .axisPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public RotateBuilder axisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.axisProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Transform#identityProperty() identityProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RotateBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.identityProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .identityPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public RotateBuilder identityPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.identityProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Transform#onTransformChangedProperty() onTransformChangedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RotateBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onTransformChangedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onTransformChangedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public RotateBuilder onTransformChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.transform.TransformChangedEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTransformChangedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Rotate#pivotXProperty() pivotXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RotateBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.pivotXProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .pivotXPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public RotateBuilder pivotXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pivotXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Rotate#pivotYProperty() pivotYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RotateBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.pivotYProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .pivotYPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public RotateBuilder pivotYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pivotYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Rotate#pivotZProperty() pivotZProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RotateBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.pivotZProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .pivotZPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public RotateBuilder pivotZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pivotZProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Transform#type2DProperty() type2DProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RotateBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.type2DProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .type2DPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public RotateBuilder type2DPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.type2DProperty()));
        return this;
    }
}
