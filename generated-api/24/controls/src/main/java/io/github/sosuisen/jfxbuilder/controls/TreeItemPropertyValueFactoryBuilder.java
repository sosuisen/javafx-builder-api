
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code TreeItemPropertyValueFactoryBuilder} class constructs instances of the {@link javafx.scene.control.cell.TreeItemPropertyValueFactory TreeItemPropertyValueFactory} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.cell.TreeItemPropertyValueFactory TreeItemPropertyValueFactory} constructor
 * and returns an instance of the {@code TreeItemPropertyValueFactoryBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.cell.TreeItemPropertyValueFactory TreeItemPropertyValueFactory}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.cell.TreeItemPropertyValueFactory TreeItemPropertyValueFactory} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class TreeItemPropertyValueFactoryBuilder<S, T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.cell.TreeItemPropertyValueFactory<S, T>>> operations = new java.util.ArrayList<>();
    private TreeItemPropertyValueFactoryBuilder() {}
    

    /**
     * Accepts the same arguments as {@link javafx.scene.control.cell.TreeItemPropertyValueFactory#TreeItemPropertyValueFactory(java.lang.String property) TreeItemPropertyValueFactory(String)}
     * and returns an instance of the {@code <S, T> TreeItemPropertyValueFactoryBuilder<S, T>}.
     *
     * @return an instance of the {@code <S, T> TreeItemPropertyValueFactoryBuilder<S, T>}.
     */
    
    public static <S, T> TreeItemPropertyValueFactoryBuilder<S, T> create(java.lang.String property) {
        TreeItemPropertyValueFactoryBuilder<S, T> builder = new TreeItemPropertyValueFactoryBuilder<S, T>();
        builder.constructorArgs = new Object[]{property};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * This method builds and returns an instance of the original class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the build() method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.cell.TreeItemPropertyValueFactory TreeItemPropertyValueFactory} class
     */
    public javafx.scene.control.cell.TreeItemPropertyValueFactory<S, T> build() {
        javafx.scene.control.cell.TreeItemPropertyValueFactory<S, T> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.cell.TreeItemPropertyValueFactory<S, T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.cell.TreeItemPropertyValueFactory<S, T> callParameterizedConstructor() {
        javafx.scene.control.cell.TreeItemPropertyValueFactory<S, T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.cell.TreeItemPropertyValueFactory.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.cell.TreeItemPropertyValueFactory<S, T>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the TreeItemPropertyValueFactory instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TreeItemPropertyValueFactoryBuilder<S, T> apply(java.util.function.Consumer<javafx.scene.control.cell.TreeItemPropertyValueFactory<S, T>> func) {
        operations.add(func);
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.TreeItemPropertyValueFactory#getProperty() getProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.cell.TreeItemPropertyValueFactory<S, T>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.getProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .getPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public TreeItemPropertyValueFactoryBuilder<S, T> getPropertyApply(java.util.function.Consumer<java.lang.String> op) {
        operations.add(obj -> op.accept(obj.getProperty()));
        return this;
    }
}
