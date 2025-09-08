
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code TreeTableViewTreeTableViewFocusModelBuilder} class constructs instances of the {@link javafx.scene.control.TreeTableView.TreeTableViewFocusModel TreeTableViewFocusModel} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.TreeTableView.TreeTableViewFocusModel TreeTableViewFocusModel} constructor
 * and returns an instance of the {@code TreeTableViewTreeTableViewFocusModelBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.TreeTableView.TreeTableViewFocusModel TreeTableViewFocusModel}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.TreeTableView.TreeTableViewFocusModel TreeTableViewFocusModel} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class TreeTableViewTreeTableViewFocusModelBuilder<S> {
    private final java.util.List<java.util.function.Consumer<javafx.scene.control.TreeTableView.TreeTableViewFocusModel<S>>> operations = new java.util.ArrayList<>();
    private TreeTableViewTreeTableViewFocusModelBuilder() {}
    
    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.TreeTableView.TreeTableViewFocusModel#TreeTableViewFocusModel(javafx.scene.control.TreeTableView) TreeTableViewFocusModel(TreeTableView)}
     * and returns an instance of {@code TreeTableViewTreeTableViewFocusModelBuilder<S>}.
     *
     * @return an instance of the {@code TreeTableViewTreeTableViewFocusModelBuilder<S>}.
     */
    public static <S> TreeTableViewTreeTableViewFocusModelBuilder<S> create(javafx.scene.control.TreeTableView<S> treeTableView) {
        TreeTableViewTreeTableViewFocusModelBuilder<S> builder = new TreeTableViewTreeTableViewFocusModelBuilder<S>();
        builder.constructorArgs = new Object[]{treeTableView};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.TreeTableView.TreeTableViewFocusModel} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.TreeTableView.TreeTableViewFocusModel TreeTableViewFocusModel} class
     */
    public javafx.scene.control.TreeTableView.TreeTableViewFocusModel<S> build() {
        javafx.scene.control.TreeTableView.TreeTableViewFocusModel<S> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.TreeTableView.TreeTableViewFocusModel<S>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.TreeTableView.TreeTableViewFocusModel<S> callParameterizedConstructor() {
        javafx.scene.control.TreeTableView.TreeTableViewFocusModel<S> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TreeTableView.TreeTableViewFocusModel.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TreeTableView.TreeTableViewFocusModel<S>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the TreeTableViewFocusModel instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TreeTableViewTreeTableViewFocusModelBuilder<S> apply(java.util.function.Consumer<javafx.scene.control.TreeTableView.TreeTableViewFocusModel<S>> func) {
        operations.add(func);
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView.TreeTableViewFocusModel#focusedCellProperty() focusedCellProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableViewTreeTableViewFocusModelBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.focusedCellProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .focusedCellPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableViewTreeTableViewFocusModelBuilder<S> focusedCellPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TreeTablePosition<S, ?>>> op) {
        operations.add(obj -> op.accept(obj.focusedCellProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView.TreeTableViewFocusModel#focusedIndexProperty() focusedIndexProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableViewTreeTableViewFocusModelBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.focusedIndexProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .focusedIndexPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableViewTreeTableViewFocusModelBuilder<S> focusedIndexPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyIntegerProperty> op) {
        operations.add(obj -> op.accept(obj.focusedIndexProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView.TreeTableViewFocusModel#focusedItemProperty() focusedItemProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableViewTreeTableViewFocusModelBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.focusedItemProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .focusedItemPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableViewTreeTableViewFocusModelBuilder<S> focusedItemPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TreeItem<S>>> op) {
        operations.add(obj -> op.accept(obj.focusedItemProperty()));
        return this;
    }
}
