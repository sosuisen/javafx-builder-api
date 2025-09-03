
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code ReflectionBuilder} class constructs instances of the {@link javafx.scene.effect.Reflection Reflection} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.effect.Reflection Reflection} constructor
 * and returns an instance of the {@code ReflectionBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.effect.Reflection Reflection}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.effect.Reflection Reflection} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class ReflectionBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.Reflection>> operations = new java.util.ArrayList<>();
    private ReflectionBuilder() {}
    

    /**
     * Returns an instance of the {@code ReflectionBuilder}.
     *
     * @return an instance of the {@code ReflectionBuilder}.
     */
    public static ReflectionBuilder create() { return new ReflectionBuilder(); }


    /**
     * Accepts the constructor arguments of {@link javafx.scene.effect.Reflection#Reflection(double, double, double, double) Reflection(double, double, double, double)}
     * and returns an instance of {@code ReflectionBuilder}.
     *
     * @return an instance of the {@code ReflectionBuilder}.
     */
    
    public static ReflectionBuilder create(double topOffset, double fraction, double topOpacity, double bottomOpacity) {
        ReflectionBuilder builder = new ReflectionBuilder();
        builder.constructorArgs = new Object[]{topOffset, fraction, topOpacity, bottomOpacity};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.effect.Reflection} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.effect.Reflection Reflection} class
     */
    public javafx.scene.effect.Reflection build() {
        javafx.scene.effect.Reflection newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.Reflection();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.Reflection> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.Reflection callParameterizedConstructor() {
        javafx.scene.effect.Reflection newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.Reflection.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.Reflection) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Reflection instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public ReflectionBuilder apply(java.util.function.Consumer<javafx.scene.effect.Reflection> func) {
        operations.add(func);
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.effect.Reflection#setBottomOpacity(double) setBottomOpacity} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  ReflectionBuilder bottomOpacity(double value) {
        operations.add(obj -> obj.setBottomOpacity(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.effect.Reflection#setFraction(double) setFraction} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  ReflectionBuilder fraction(double value) {
        operations.add(obj -> obj.setFraction(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.effect.Reflection#setInput(javafx.scene.effect.Effect) setInput} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  ReflectionBuilder input(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setInput(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.effect.Reflection#setTopOffset(double) setTopOffset} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  ReflectionBuilder topOffset(double value) {
        operations.add(obj -> obj.setTopOffset(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.effect.Reflection#setTopOpacity(double) setTopOpacity} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  ReflectionBuilder topOpacity(double value) {
        operations.add(obj -> obj.setTopOpacity(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Reflection#bottomOpacityProperty() bottomOpacityProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.Reflection> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.bottomOpacityProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .bottomOpacityPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public ReflectionBuilder bottomOpacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.bottomOpacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Reflection#fractionProperty() fractionProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.Reflection> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.fractionProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .fractionPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public ReflectionBuilder fractionPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.fractionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Reflection#inputProperty() inputProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.Reflection> func) apply} method.
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
    
    public ReflectionBuilder inputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.inputProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Reflection#topOffsetProperty() topOffsetProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.Reflection> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.topOffsetProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .topOffsetPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public ReflectionBuilder topOffsetPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.topOffsetProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Reflection#topOpacityProperty() topOpacityProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.Reflection> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.topOpacityProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .topOpacityPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public ReflectionBuilder topOpacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.topOpacityProperty()));
        return this;
    }
}
