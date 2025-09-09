
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code SplitPaneDividerBuilder} class constructs instances of the {@link javafx.scene.control.SplitPane.Divider Divider} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.SplitPane.Divider Divider} constructor
 * and returns an instance of the {@code SplitPaneDividerBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.SplitPane.Divider Divider}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.SplitPane.Divider Divider} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class SplitPaneDividerBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.control.SplitPane.Divider>> operations = new java.util.ArrayList<>();
    private SplitPaneDividerBuilder() {}
    
    /**
     * Returns an instance of the {@code SplitPaneDividerBuilder}.
     *
     * @return an instance of the {@code SplitPaneDividerBuilder}.
     */
    public static SplitPaneDividerBuilder create() { return new SplitPaneDividerBuilder(); }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.SplitPane.Divider Divider} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.SplitPane.Divider Divider} class
     */
    public javafx.scene.control.SplitPane.Divider build() {
        javafx.scene.control.SplitPane.Divider newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.SplitPane.Divider();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.SplitPane.Divider> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.SplitPane.Divider callParameterizedConstructor() {
        javafx.scene.control.SplitPane.Divider newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.SplitPane.Divider.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.SplitPane.Divider) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Divider instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public SplitPaneDividerBuilder apply(java.util.function.Consumer<javafx.scene.control.SplitPane.Divider> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.SplitPane.Divider#setPosition(double) setPosition} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  SplitPaneDividerBuilder position(double value) {
        operations.add(obj -> obj.setPosition(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.SplitPane.Divider#positionProperty() positionProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link SplitPaneDividerBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.positionProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .positionPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public SplitPaneDividerBuilder positionPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.positionProperty()));
        return this;
    }
}
