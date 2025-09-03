
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code AffineBuilder} class constructs instances of the {@link javafx.scene.transform.Affine Affine} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.transform.Affine Affine} constructor
 * and returns an instance of the {@code AffineBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.transform.Affine Affine}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.transform.Affine Affine} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class AffineBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.transform.Affine>> operations = new java.util.ArrayList<>();
    private AffineBuilder() {}
    
    /**
     * Returns an instance of the {@code AffineBuilder}.
     *
     * @return an instance of the {@code AffineBuilder}.
     */
    public static AffineBuilder create() { return new AffineBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.transform.Affine#Affine(double, double, double, double, double, double) Affine(double, double, double, double, double, double)}
     * and returns an instance of {@code AffineBuilder}.
     *
     * @return an instance of the {@code AffineBuilder}.
     */
    
    public static AffineBuilder create(double mxx, double mxy, double tx, double myx, double myy, double ty) {
        AffineBuilder builder = new AffineBuilder();
        builder.constructorArgs = new Object[]{mxx, mxy, tx, myx, myy, ty};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.transform.Affine#Affine(double, double, double, double, double, double, double, double, double, double, double, double) Affine(double, double, double, double, double, double, double, double, double, double, double, double)}
     * and returns an instance of {@code AffineBuilder}.
     *
     * @return an instance of the {@code AffineBuilder}.
     */
    
    public static AffineBuilder create(double mxx, double mxy, double mxz, double tx, double myx, double myy, double myz, double ty, double mzx, double mzy, double mzz, double tz) {
        AffineBuilder builder = new AffineBuilder();
        builder.constructorArgs = new Object[]{mxx, mxy, mxz, tx, myx, myy, myz, ty, mzx, mzy, mzz, tz};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.transform.Affine#Affine(double..., MatrixType, int) Affine(double..., MatrixType, int)}
     * and returns an instance of {@code AffineBuilder}.
     *
     * @return an instance of the {@code AffineBuilder}.
     */
    
    public static AffineBuilder create(double[] matrix, javafx.scene.transform.MatrixType type, int offset) {
        AffineBuilder builder = new AffineBuilder();
        builder.constructorArgs = new Object[]{matrix, type, offset};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.transform.Affine#Affine(Transform) Affine(Transform)}
     * and returns an instance of {@code AffineBuilder}.
     *
     * @return an instance of the {@code AffineBuilder}.
     */
    
    public static AffineBuilder create(javafx.scene.transform.Transform transform) {
        AffineBuilder builder = new AffineBuilder();
        builder.constructorArgs = new Object[]{transform};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.transform.Affine} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.transform.Affine Affine} class
     */
    public javafx.scene.transform.Affine build() {
        javafx.scene.transform.Affine newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.transform.Affine();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.transform.Affine> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.transform.Affine callParameterizedConstructor() {
        javafx.scene.transform.Affine newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.transform.Affine.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.transform.Affine) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Affine instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public AffineBuilder apply(java.util.function.Consumer<javafx.scene.transform.Affine> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Affine#setElement(javafx.scene.transform.MatrixType, int, int, double) setElement} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AffineBuilder element(javafx.scene.transform.MatrixType type, int row, int column, double value) {
        operations.add(obj -> obj.setElement(type, row, column, value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Affine#setMxx(double) setMxx} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AffineBuilder mxx(double value) {
        operations.add(obj -> obj.setMxx(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Affine#setMxy(double) setMxy} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AffineBuilder mxy(double value) {
        operations.add(obj -> obj.setMxy(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Affine#setMxz(double) setMxz} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AffineBuilder mxz(double value) {
        operations.add(obj -> obj.setMxz(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Affine#setMyx(double) setMyx} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AffineBuilder myx(double value) {
        operations.add(obj -> obj.setMyx(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Affine#setMyy(double) setMyy} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AffineBuilder myy(double value) {
        operations.add(obj -> obj.setMyy(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Affine#setMyz(double) setMyz} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AffineBuilder myz(double value) {
        operations.add(obj -> obj.setMyz(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Affine#setMzx(double) setMzx} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AffineBuilder mzx(double value) {
        operations.add(obj -> obj.setMzx(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Affine#setMzy(double) setMzy} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AffineBuilder mzy(double value) {
        operations.add(obj -> obj.setMzy(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Affine#setMzz(double) setMzz} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AffineBuilder mzz(double value) {
        operations.add(obj -> obj.setMzz(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Affine#setOnTransformChanged(javafx.event.EventHandler) setOnTransformChanged} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AffineBuilder onTransformChanged(javafx.event.EventHandler<? super javafx.scene.transform.TransformChangedEvent> value) {
        operations.add(obj -> obj.setOnTransformChanged(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Affine#setToIdentity() setToIdentity} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AffineBuilder toIdentity() {
        operations.add(obj -> obj.setToIdentity());
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Affine#setToTransform(double, double, double, double, double, double) setToTransform} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AffineBuilder toTransform(double mxx, double mxy, double tx, double myx, double myy, double ty) {
        operations.add(obj -> obj.setToTransform(mxx, mxy, tx, myx, myy, ty));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Affine#setToTransform(double, double, double, double, double, double, double, double, double, double, double, double) setToTransform} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AffineBuilder toTransform(double mxx, double mxy, double mxz, double tx, double myx, double myy, double myz, double ty, double mzx, double mzy, double mzz, double tz) {
        operations.add(obj -> obj.setToTransform(mxx, mxy, mxz, tx, myx, myy, myz, ty, mzx, mzy, mzz, tz));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Affine#setToTransform(double..., javafx.scene.transform.MatrixType, int) setToTransform} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AffineBuilder toTransform(double[] matrix, javafx.scene.transform.MatrixType type, int offset) {
        operations.add(obj -> obj.setToTransform(matrix, type, offset));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Affine#setToTransform(javafx.scene.transform.Transform) setToTransform} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AffineBuilder toTransform(javafx.scene.transform.Transform transform) {
        operations.add(obj -> obj.setToTransform(transform));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Affine#setTx(double) setTx} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AffineBuilder tx(double value) {
        operations.add(obj -> obj.setTx(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Affine#setTy(double) setTy} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AffineBuilder ty(double value) {
        operations.add(obj -> obj.setTy(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.transform.Affine#setTz(double) setTz} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AffineBuilder tz(double value) {
        operations.add(obj -> obj.setTz(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#identityProperty() identityProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Affine> func) apply} method.
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
    public AffineBuilder identityPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.identityProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#mxxProperty() mxxProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Affine> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.mxxProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .mxxPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public AffineBuilder mxxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.mxxProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#mxyProperty() mxyProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Affine> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.mxyProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .mxyPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public AffineBuilder mxyPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.mxyProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#mxzProperty() mxzProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Affine> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.mxzProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .mxzPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public AffineBuilder mxzPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.mxzProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#myxProperty() myxProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Affine> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.myxProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .myxPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public AffineBuilder myxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.myxProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#myyProperty() myyProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Affine> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.myyProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .myyPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public AffineBuilder myyPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.myyProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#myzProperty() myzProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Affine> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.myzProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .myzPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public AffineBuilder myzPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.myzProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#mzxProperty() mzxProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Affine> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.mzxProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .mzxPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public AffineBuilder mzxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.mzxProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#mzyProperty() mzyProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Affine> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.mzyProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .mzyPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public AffineBuilder mzyPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.mzyProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#mzzProperty() mzzProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Affine> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.mzzProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .mzzPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public AffineBuilder mzzPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.mzzProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#onTransformChangedProperty() onTransformChangedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Affine> func) apply} method.
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
    public AffineBuilder onTransformChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.transform.TransformChangedEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTransformChangedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#txProperty() txProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Affine> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.txProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .txPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public AffineBuilder txPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.txProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#tyProperty() tyProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Affine> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.tyProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .tyPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public AffineBuilder tyPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.tyProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#type2DProperty() type2DProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Affine> func) apply} method.
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
    public AffineBuilder type2DPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.type2DProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#tzProperty() tzProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Affine> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.tzProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .tzPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public AffineBuilder tzPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.tzProperty()));
        return this;
    }
}
