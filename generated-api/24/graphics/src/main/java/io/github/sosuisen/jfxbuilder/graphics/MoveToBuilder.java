
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code MoveToBuilder} class constructs instances of the {@link javafx.scene.shape.MoveTo MoveTo} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.shape.MoveTo MoveTo} constructor
 * and returns an instance of the {@code MoveToBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.shape.MoveTo MoveTo}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.shape.MoveTo MoveTo} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class MoveToBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.shape.MoveTo>> operations = new java.util.ArrayList<>();
    private MoveToBuilder() {}
    

    /**
     * Returns an instance of the {@code MoveToBuilder}.
     *
     * @return an instance of the {@code MoveToBuilder}.
     */
    public static MoveToBuilder create() { return new MoveToBuilder(); }


    /**
     * Accepts the constructor arguments of {@link javafx.scene.shape.MoveTo#MoveTo(double, double) MoveTo(double, double)}
     * and returns an instance of {@code MoveToBuilder}.
     *
     * @return an instance of the {@code MoveToBuilder}.
     */
    
    public static MoveToBuilder create(double x, double y) {
        MoveToBuilder builder = new MoveToBuilder();
        builder.constructorArgs = new Object[]{x, y};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.shape.MoveTo} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.shape.MoveTo MoveTo} class
     */
    public javafx.scene.shape.MoveTo build() {
        javafx.scene.shape.MoveTo newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.shape.MoveTo();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.shape.MoveTo> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.shape.MoveTo callParameterizedConstructor() {
        javafx.scene.shape.MoveTo newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.shape.MoveTo.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.shape.MoveTo) constructor.newInstance(constructorArgs);
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
     * Applies a function to the MoveTo instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public MoveToBuilder apply(java.util.function.Consumer<javafx.scene.shape.MoveTo> func) {
        operations.add(func);
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.shape.MoveTo#setAbsolute(boolean) setAbsolute} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  MoveToBuilder absolute(boolean value) {
        operations.add(obj -> obj.setAbsolute(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.shape.MoveTo#setX(double) setX} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  MoveToBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.shape.MoveTo#setY(double) setY} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  MoveToBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.MoveTo#absoluteProperty() absoluteProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MoveTo> func) apply} method.
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
    
    public MoveToBuilder absolutePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.absoluteProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.MoveTo#xProperty() xProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MoveTo> func) apply} method.
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
    
    public MoveToBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.MoveTo#yProperty() yProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MoveTo> func) apply} method.
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
    
    public MoveToBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
