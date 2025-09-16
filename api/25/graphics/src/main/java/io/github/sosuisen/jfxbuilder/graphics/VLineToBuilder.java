
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code VLineToBuilder} class constructs instances of the {@link javafx.scene.shape.VLineTo VLineTo} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.shape.VLineTo VLineTo} constructor
 * and returns an instance of the {@code VLineToBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.shape.VLineTo VLineTo}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.shape.VLineTo VLineTo} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class VLineToBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.shape.VLineTo>> operations = new java.util.ArrayList<>();
    private VLineToBuilder() {}
    
    /**
     * Returns an instance of the {@code VLineToBuilder}.
     *
     * @return an instance of the {@code VLineToBuilder}.
     */
    public static VLineToBuilder create() { return new VLineToBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.shape.VLineTo#VLineTo(double) VLineTo(double)}
     * and returns an instance of {@code VLineToBuilder}.
     *
     * @return an instance of the {@code VLineToBuilder}.
     */
    public static VLineToBuilder create(double y) {
        VLineToBuilder builder = new VLineToBuilder();
        builder.constructorArgs = new Object[]{y};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.shape.VLineTo VLineTo} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.shape.VLineTo VLineTo} class
     */
    public javafx.scene.shape.VLineTo build() {
        javafx.scene.shape.VLineTo newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.shape.VLineTo();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.shape.VLineTo> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.shape.VLineTo callParameterizedConstructor() {
        javafx.scene.shape.VLineTo newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.shape.VLineTo.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.shape.VLineTo) constructor.newInstance(constructorArgs);
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
     * Applies a function to the VLineTo instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public VLineToBuilder apply(java.util.function.Consumer<javafx.scene.shape.VLineTo> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.PathElement#setAbsolute(boolean) setAbsolute} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  VLineToBuilder absolute(boolean value) {
        operations.add(obj -> obj.setAbsolute(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.VLineTo#setY(double) setY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  VLineToBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.PathElement#absoluteProperty() absoluteProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link VLineToBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * {@snippet :
     * // Use apply
     * .apply(obj -> obj.absoluteProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .absolutePropertyApply(prop -> prop.bind(anotherProperty))
     * }
     *
     * @return builder instance
     */
    public VLineToBuilder absolutePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.absoluteProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.VLineTo#yProperty() yProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link VLineToBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * {@snippet :
     * // Use apply
     * .apply(obj -> obj.yProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .yPropertyApply(prop -> prop.bind(anotherProperty))
     * }
     *
     * @return builder instance
     */
    public VLineToBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
