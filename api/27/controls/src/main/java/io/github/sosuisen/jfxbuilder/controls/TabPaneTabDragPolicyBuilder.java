
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code TabPaneTabDragPolicyBuilder} class constructs instances of the {@link javafx.scene.control.TabPane.TabDragPolicy TabDragPolicy} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.TabPane.TabDragPolicy TabDragPolicy} constructor
 * and returns an instance of the {@code TabPaneTabDragPolicyBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.TabPane.TabDragPolicy TabDragPolicy}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.TabPane.TabDragPolicy TabDragPolicy} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class TabPaneTabDragPolicyBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.control.TabPane.TabDragPolicy>> operations = new java.util.ArrayList<>();
    private TabPaneTabDragPolicyBuilder() {}
    
    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.TabPane.TabDragPolicy TabDragPolicy} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.TabPane.TabDragPolicy TabDragPolicy} class
     */
    public javafx.scene.control.TabPane.TabDragPolicy build() {
        javafx.scene.control.TabPane.TabDragPolicy newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.TabPane.TabDragPolicy> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.TabPane.TabDragPolicy callParameterizedConstructor() {
        javafx.scene.control.TabPane.TabDragPolicy newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TabPane.TabDragPolicy.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TabPane.TabDragPolicy) constructor.newInstance(constructorArgs);
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
     * Applies a function to the TabDragPolicy instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TabPaneTabDragPolicyBuilder apply(java.util.function.Consumer<javafx.scene.control.TabPane.TabDragPolicy> func) {
        operations.add(func);
        return this;
    }
}
