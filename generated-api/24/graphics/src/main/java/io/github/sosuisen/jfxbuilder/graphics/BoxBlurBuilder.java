
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code BoxBlurBuilder} class constructs instances of the {@link javafx.scene.effect.BoxBlur BoxBlur} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.effect.BoxBlur BoxBlur} constructor
 * and returns an instance of the {@code BoxBlurBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.effect.BoxBlur BoxBlur}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.effect.BoxBlur BoxBlur} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class BoxBlurBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.BoxBlur>> operations = new java.util.ArrayList<>();
    private BoxBlurBuilder() {}
    

    /**
     * Returns an instance of the {@code BoxBlurBuilder}.
     *
     * @return an instance of the {@code BoxBlurBuilder}.
     */
    public static BoxBlurBuilder create() { return new BoxBlurBuilder(); }


    /**
     * Accepts the constructor arguments of {@link javafx.scene.effect.BoxBlur#BoxBlur(double, double, int) BoxBlur(double, double, int)}
     * and returns an instance of {@code BoxBlurBuilder}.
     *
     * @return an instance of the {@code BoxBlurBuilder}.
     */
    
    public static BoxBlurBuilder create(double width, double height, int iterations) {
        BoxBlurBuilder builder = new BoxBlurBuilder();
        builder.constructorArgs = new Object[]{width, height, iterations};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.effect.BoxBlur} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.effect.BoxBlur BoxBlur} class
     */
    public javafx.scene.effect.BoxBlur build() {
        javafx.scene.effect.BoxBlur newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.BoxBlur();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.BoxBlur> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.BoxBlur callParameterizedConstructor() {
        javafx.scene.effect.BoxBlur newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.BoxBlur.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.BoxBlur) constructor.newInstance(constructorArgs);
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
     * Applies a function to the BoxBlur instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public BoxBlurBuilder apply(java.util.function.Consumer<javafx.scene.effect.BoxBlur> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.BoxBlur#setHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  BoxBlurBuilder height(double value) {
        operations.add(obj -> obj.setHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.BoxBlur#setInput(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  BoxBlurBuilder input(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setInput(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.BoxBlur#setIterations(int)}
     * 
     * @return builder instance
     */    
    
    public  BoxBlurBuilder iterations(int value) {
        operations.add(obj -> obj.setIterations(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.BoxBlur#setWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  BoxBlurBuilder width(double value) {
        operations.add(obj -> obj.setWidth(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.BoxBlur#heightProperty() heightProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.BoxBlur> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.heightProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .heightPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public BoxBlurBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.BoxBlur#inputProperty() inputProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.BoxBlur> func) apply} method.
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
    
    public BoxBlurBuilder inputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.inputProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.BoxBlur#iterationsProperty() iterationsProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.BoxBlur> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.iterationsProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .iterationsPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public BoxBlurBuilder iterationsPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.iterationsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.BoxBlur#widthProperty() widthProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.BoxBlur> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.widthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .widthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public BoxBlurBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
