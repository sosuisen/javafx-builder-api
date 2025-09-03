
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code TreeCellSkinBuilder} class constructs instances of the {@link javafx.scene.control.skin.TreeCellSkin TreeCellSkin} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.skin.TreeCellSkin TreeCellSkin} constructor
 * and returns an instance of the {@code TreeCellSkinBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.skin.TreeCellSkin TreeCellSkin}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.skin.TreeCellSkin TreeCellSkin} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class TreeCellSkinBuilder<T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.skin.TreeCellSkin<T>>> operations = new java.util.ArrayList<>();
    private TreeCellSkinBuilder() {}
    

    /**
     * Accepts the same arguments as {@link javafx.scene.control.skin.TreeCellSkin#TreeCellSkin(TreeCell) TreeCellSkin(TreeCell)}
     * and returns an instance of the {@code TreeCellSkinBuilder<T>}.
     *
     * @return an instance of the {@code TreeCellSkinBuilder<T>}.
     */
    
    public static <T> TreeCellSkinBuilder<T> create(javafx.scene.control.TreeCell<T> control) {
        TreeCellSkinBuilder<T> builder = new TreeCellSkinBuilder<T>();
        builder.constructorArgs = new Object[]{control};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.skin.TreeCellSkin<T>} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.skin.TreeCellSkin TreeCellSkin} class
     */
    public javafx.scene.control.skin.TreeCellSkin<T> build() {
        javafx.scene.control.skin.TreeCellSkin<T> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.skin.TreeCellSkin<T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.skin.TreeCellSkin<T> callParameterizedConstructor() {
        javafx.scene.control.skin.TreeCellSkin<T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.skin.TreeCellSkin.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.skin.TreeCellSkin<T>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the TreeCellSkin instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TreeCellSkinBuilder<T> apply(java.util.function.Consumer<javafx.scene.control.skin.TreeCellSkin<T>> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TreeCellSkin#setIndent(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeCellSkinBuilder<T> indent(double value) {
        operations.add(obj -> obj.setIndent(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.skin.TreeCellSkin#getChildren()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TreeCellSkinBuilder<T> addChildren(javafx.scene.Node... elements) {
        operations.add(obj -> {
            obj.getChildren().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.skin.TreeCellSkin#getChildren()} method.
     * 
     * @return builder instance
     */
    public final TreeCellSkinBuilder<T> addChildren(java.util.Collection<? extends javafx.scene.Node> col) {
        operations.add(obj -> {
            obj.getChildren().addAll(col);
        });
        return this;
    }


    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TreeCellSkin#cellSizeProperty() cellSizeProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.skin.TreeCellSkin<T>> func) apply} method.
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
    
    public TreeCellSkinBuilder<T> cellSizePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.cellSizeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TreeCellSkin#indentProperty() indentProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.skin.TreeCellSkin<T>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.indentProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .indentPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public TreeCellSkinBuilder<T> indentPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.indentProperty()));
        return this;
    }
}
