
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code HLineToBuilder} class constructs instances of the {@link javafx.scene.shape.HLineTo HLineTo} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.shape.HLineTo HLineTo} constructor
 * and returns an instance of the {@code HLineToBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.shape.HLineTo HLineTo}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.shape.HLineTo HLineTo} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class HLineToBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.shape.HLineTo>> operations = new java.util.ArrayList<>();
    private HLineToBuilder() {}
    

    /**
     * Returns an instance of the {@code HLineToBuilder}.
     *
     * @return an instance of the {@code HLineToBuilder}.
     */
    public static HLineToBuilder create() { return new HLineToBuilder(); }


    /**
     * Accepts the same arguments as {@link javafx.scene.shape.HLineTo#HLineTo(double) HLineTo(double)}
     * and returns an instance of the {@code HLineToBuilder}.
     *
     * @return an instance of the {@code HLineToBuilder}.
     */
    
    public static HLineToBuilder create(double x) {
        HLineToBuilder builder = new HLineToBuilder();
        builder.constructorArgs = new Object[]{x};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.shape.HLineTo} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.shape.HLineTo HLineTo} class
     */
    public javafx.scene.shape.HLineTo build() {
        javafx.scene.shape.HLineTo newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.shape.HLineTo();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.shape.HLineTo> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.shape.HLineTo callParameterizedConstructor() {
        javafx.scene.shape.HLineTo newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.shape.HLineTo.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.shape.HLineTo) constructor.newInstance(constructorArgs);
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
     * Applies a function to the HLineTo instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public HLineToBuilder apply(java.util.function.Consumer<javafx.scene.shape.HLineTo> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.HLineTo#setAbsolute(boolean)}
     * 
     * @return builder instance
     */    
    
    public  HLineToBuilder absolute(boolean value) {
        operations.add(obj -> obj.setAbsolute(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.HLineTo#setX(double)}
     * 
     * @return builder instance
     */    
    
    public  HLineToBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.HLineTo#absoluteProperty() absoluteProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.HLineTo> func) apply} method.
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
    
    public HLineToBuilder absolutePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.absoluteProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.HLineTo#xProperty() xProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.HLineTo> func) apply} method.
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
    
    public HLineToBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }
}
