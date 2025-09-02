
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code TreeTablePositionBuilder} class constructs instances of the {@link javafx.scene.control.TreeTablePosition TreeTablePosition} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.TreeTablePosition TreeTablePosition} constructor
 * and returns an instance of the {@code TreeTablePositionBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.TreeTablePosition TreeTablePosition}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.TreeTablePosition TreeTablePosition} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class TreeTablePositionBuilder<S, T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.TreeTablePosition<S, T>>> operations = new java.util.ArrayList<>();
    private TreeTablePositionBuilder() {}
    

    /**
     * Accepts the same arguments as {@link javafx.scene.control.TreeTablePosition#TreeTablePosition(javafx.scene.control.TreeTableView<S> treeTableView, int row, javafx.scene.control.TreeTableColumn<S, T> tableColumn) TreeTablePosition(TreeTableView, int, TreeTableColumn)}
     * and returns an instance of the {@code <S, T> TreeTablePositionBuilder<S, T>}.
     *
     * @return an instance of the {@code <S, T> TreeTablePositionBuilder<S, T>}.
     */
    
    public static <S, T> TreeTablePositionBuilder<S, T> create(javafx.scene.control.TreeTableView<S> treeTableView, int row, javafx.scene.control.TreeTableColumn<S, T> tableColumn) {
        TreeTablePositionBuilder<S, T> builder = new TreeTablePositionBuilder<S, T>();
        builder.constructorArgs = new Object[]{treeTableView, row, tableColumn};
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
     * @return new instance of the {@link javafx.scene.control.TreeTablePosition TreeTablePosition} class
     */
    public javafx.scene.control.TreeTablePosition<S, T> build() {
        javafx.scene.control.TreeTablePosition<S, T> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.TreeTablePosition<S, T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.TreeTablePosition<S, T> callParameterizedConstructor() {
        javafx.scene.control.TreeTablePosition<S, T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TreeTablePosition.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TreeTablePosition<S, T>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the TreeTablePosition instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TreeTablePositionBuilder<S, T> apply(java.util.function.Consumer<javafx.scene.control.TreeTablePosition<S, T>> func) {
        operations.add(func);
        return this;
    }
}
