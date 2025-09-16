
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code TabStopPolicyBuilder} class constructs instances of the {@link javafx.scene.text.TabStopPolicy TabStopPolicy} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.text.TabStopPolicy TabStopPolicy} constructor
 * and returns an instance of the {@code TabStopPolicyBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.text.TabStopPolicy TabStopPolicy}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.text.TabStopPolicy TabStopPolicy} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class TabStopPolicyBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.text.TabStopPolicy>> operations = new java.util.ArrayList<>();
    private TabStopPolicyBuilder() {}
    
    /**
     * Returns an instance of the {@code TabStopPolicyBuilder}.
     *
     * @return an instance of the {@code TabStopPolicyBuilder}.
     */
    public static TabStopPolicyBuilder create() { return new TabStopPolicyBuilder(); }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.text.TabStopPolicy TabStopPolicy} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.text.TabStopPolicy TabStopPolicy} class
     */
    public javafx.scene.text.TabStopPolicy build() {
        javafx.scene.text.TabStopPolicy newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.text.TabStopPolicy();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.text.TabStopPolicy> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.text.TabStopPolicy callParameterizedConstructor() {
        javafx.scene.text.TabStopPolicy newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.text.TabStopPolicy.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.text.TabStopPolicy) constructor.newInstance(constructorArgs);
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
     * Applies a function to the TabStopPolicy instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TabStopPolicyBuilder apply(java.util.function.Consumer<javafx.scene.text.TabStopPolicy> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.text.TabStopPolicy#setDefaultInterval(double) setDefaultInterval} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TabStopPolicyBuilder defaultInterval(double value) {
        operations.add(obj -> obj.setDefaultInterval(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.text.TabStopPolicy#defaultIntervalProperty() defaultIntervalProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TabStopPolicyBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * {@snippet :
     * // Use apply
     * .apply(obj -> obj.defaultIntervalProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .defaultIntervalPropertyApply(prop -> prop.bind(anotherProperty))
     * }
     *
     * @return builder instance
     */
    public TabStopPolicyBuilder defaultIntervalPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.defaultIntervalProperty()));
        return this;
    }
}
