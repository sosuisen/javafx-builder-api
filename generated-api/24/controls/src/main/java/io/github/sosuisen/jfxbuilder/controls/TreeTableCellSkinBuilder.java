
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code TreeTableCellSkinBuilder} class constructs instances of the {@link javafx.scene.control.skin.TreeTableCellSkin TreeTableCellSkin} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.skin.TreeTableCellSkin TreeTableCellSkin} constructor
 * and returns an instance of the {@code TreeTableCellSkinBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.skin.TreeTableCellSkin TreeTableCellSkin}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.skin.TreeTableCellSkin TreeTableCellSkin} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class TreeTableCellSkinBuilder<S, T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.skin.TreeTableCellSkin<S, T>>> operations = new java.util.ArrayList<>();
    private TreeTableCellSkinBuilder() {}
    

    /**
     * Accepts the same arguments as {@link javafx.scene.control.skin.TreeTableCellSkin#TreeTableCellSkin(TreeTableCell) TreeTableCellSkin(TreeTableCell)}
     * and returns an instance of the {@code TreeTableCellSkinBuilder<S, T>}.
     *
     * @return an instance of the {@code TreeTableCellSkinBuilder<S, T>}.
     */
    
    public static <S, T> TreeTableCellSkinBuilder<S, T> create(javafx.scene.control.TreeTableCell<S, T> control) {
        TreeTableCellSkinBuilder<S, T> builder = new TreeTableCellSkinBuilder<S, T>();
        builder.constructorArgs = new Object[]{control};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.skin.TreeTableCellSkin<S, T>} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.skin.TreeTableCellSkin TreeTableCellSkin} class
     */
    public javafx.scene.control.skin.TreeTableCellSkin<S, T> build() {
        javafx.scene.control.skin.TreeTableCellSkin<S, T> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.skin.TreeTableCellSkin<S, T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.skin.TreeTableCellSkin<S, T> callParameterizedConstructor() {
        javafx.scene.control.skin.TreeTableCellSkin<S, T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.skin.TreeTableCellSkin.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.skin.TreeTableCellSkin<S, T>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the TreeTableCellSkin instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TreeTableCellSkinBuilder<S, T> apply(java.util.function.Consumer<javafx.scene.control.skin.TreeTableCellSkin<S, T>> func) {
        operations.add(func);
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.skin.TreeTableCellSkin#getChildren()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TreeTableCellSkinBuilder<S, T> addChildren(javafx.scene.Node... elements) {
        operations.add(obj -> {
            obj.getChildren().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.skin.TreeTableCellSkin#getChildren()} method.
     * 
     * @return builder instance
     */
    public final TreeTableCellSkinBuilder<S, T> addChildren(java.util.Collection<? extends javafx.scene.Node> col) {
        operations.add(obj -> {
            obj.getChildren().addAll(col);
        });
        return this;
    }


    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TreeTableCellSkin#cellSizeProperty() cellSizeProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.skin.TreeTableCellSkin<S, T>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.cellSizeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .cellSizePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public TreeTableCellSkinBuilder<S, T> cellSizePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.cellSizeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TreeTableCellSkin#tableColumnProperty() tableColumnProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.skin.TreeTableCellSkin<S, T>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.tableColumnProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .tableColumnPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public TreeTableCellSkinBuilder<S, T> tableColumnPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TreeTableColumn<S, T>>> op) {
        operations.add(obj -> op.accept(obj.tableColumnProperty()));
        return this;
    }
}
