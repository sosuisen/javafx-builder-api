
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code PerspectiveTransformBuilder} class constructs instances of the {@link javafx.scene.effect.PerspectiveTransform PerspectiveTransform} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.effect.PerspectiveTransform PerspectiveTransform} constructor
 * and returns an instance of the {@code PerspectiveTransformBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.effect.PerspectiveTransform PerspectiveTransform}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.effect.PerspectiveTransform PerspectiveTransform} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class PerspectiveTransformBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.PerspectiveTransform>> operations = new java.util.ArrayList<>();
    private PerspectiveTransformBuilder() {}
    
    /**
     * Returns an instance of the {@code PerspectiveTransformBuilder}.
     *
     * @return an instance of the {@code PerspectiveTransformBuilder}.
     */
    public static PerspectiveTransformBuilder create() { return new PerspectiveTransformBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.effect.PerspectiveTransform#PerspectiveTransform(double, double, double, double, double, double, double, double) PerspectiveTransform(double, double, double, double, double, double, double, double)}
     * and returns an instance of {@code PerspectiveTransformBuilder}.
     *
     * @return an instance of the {@code PerspectiveTransformBuilder}.
     */
    
    public static PerspectiveTransformBuilder create(double ulx, double uly, double urx, double ury, double lrx, double lry, double llx, double lly) {
        PerspectiveTransformBuilder builder = new PerspectiveTransformBuilder();
        builder.constructorArgs = new Object[]{ulx, uly, urx, ury, lrx, lry, llx, lly};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.effect.PerspectiveTransform} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.effect.PerspectiveTransform PerspectiveTransform} class
     */
    public javafx.scene.effect.PerspectiveTransform build() {
        javafx.scene.effect.PerspectiveTransform newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.PerspectiveTransform();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.PerspectiveTransform> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.PerspectiveTransform callParameterizedConstructor() {
        javafx.scene.effect.PerspectiveTransform newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.PerspectiveTransform.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.PerspectiveTransform) constructor.newInstance(constructorArgs);
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
     * Applies a function to the PerspectiveTransform instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public PerspectiveTransformBuilder apply(java.util.function.Consumer<javafx.scene.effect.PerspectiveTransform> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.PerspectiveTransform#setInput(javafx.scene.effect.Effect) setInput} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PerspectiveTransformBuilder input(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setInput(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.PerspectiveTransform#setLlx(double) setLlx} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PerspectiveTransformBuilder llx(double value) {
        operations.add(obj -> obj.setLlx(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.PerspectiveTransform#setLly(double) setLly} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PerspectiveTransformBuilder lly(double value) {
        operations.add(obj -> obj.setLly(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.PerspectiveTransform#setLrx(double) setLrx} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PerspectiveTransformBuilder lrx(double value) {
        operations.add(obj -> obj.setLrx(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.PerspectiveTransform#setLry(double) setLry} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PerspectiveTransformBuilder lry(double value) {
        operations.add(obj -> obj.setLry(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.PerspectiveTransform#setUlx(double) setUlx} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PerspectiveTransformBuilder ulx(double value) {
        operations.add(obj -> obj.setUlx(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.PerspectiveTransform#setUly(double) setUly} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PerspectiveTransformBuilder uly(double value) {
        operations.add(obj -> obj.setUly(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.PerspectiveTransform#setUrx(double) setUrx} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PerspectiveTransformBuilder urx(double value) {
        operations.add(obj -> obj.setUrx(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.PerspectiveTransform#setUry(double) setUry} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PerspectiveTransformBuilder ury(double value) {
        operations.add(obj -> obj.setUry(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.PerspectiveTransform#inputProperty() inputProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.PerspectiveTransform> func) apply} method.
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
    public PerspectiveTransformBuilder inputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.inputProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.PerspectiveTransform#llxProperty() llxProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.PerspectiveTransform> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.llxProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .llxPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public PerspectiveTransformBuilder llxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.llxProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.PerspectiveTransform#llyProperty() llyProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.PerspectiveTransform> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.llyProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .llyPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public PerspectiveTransformBuilder llyPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.llyProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.PerspectiveTransform#lrxProperty() lrxProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.PerspectiveTransform> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.lrxProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .lrxPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public PerspectiveTransformBuilder lrxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.lrxProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.PerspectiveTransform#lryProperty() lryProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.PerspectiveTransform> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.lryProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .lryPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public PerspectiveTransformBuilder lryPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.lryProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.PerspectiveTransform#ulxProperty() ulxProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.PerspectiveTransform> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.ulxProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .ulxPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public PerspectiveTransformBuilder ulxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.ulxProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.PerspectiveTransform#ulyProperty() ulyProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.PerspectiveTransform> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.ulyProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .ulyPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public PerspectiveTransformBuilder ulyPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.ulyProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.PerspectiveTransform#urxProperty() urxProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.PerspectiveTransform> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.urxProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .urxPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public PerspectiveTransformBuilder urxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.urxProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.PerspectiveTransform#uryProperty() uryProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.PerspectiveTransform> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.uryProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .uryPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public PerspectiveTransformBuilder uryPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.uryProperty()));
        return this;
    }
}
