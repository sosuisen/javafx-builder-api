
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code TableViewTableViewFocusModelBuilder} class constructs instances of the {@link javafx.scene.control.TableView.TableViewFocusModel TableViewFocusModel} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.TableView.TableViewFocusModel TableViewFocusModel} constructor
 * and returns an instance of the {@code TableViewTableViewFocusModelBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.TableView.TableViewFocusModel TableViewFocusModel}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.TableView.TableViewFocusModel TableViewFocusModel} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class TableViewTableViewFocusModelBuilder<S> {
    private final java.util.List<java.util.function.Consumer<javafx.scene.control.TableView.TableViewFocusModel<S>>> operations = new java.util.ArrayList<>();
    private TableViewTableViewFocusModelBuilder() {}
    
    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.TableView.TableViewFocusModel#TableViewFocusModel(javafx.scene.control.TableView) TableViewFocusModel(TableView)}
     * and returns an instance of {@code TableViewTableViewFocusModelBuilder<S>}.
     *
     * @return an instance of the {@code TableViewTableViewFocusModelBuilder<S>}.
     */
    public static <S> TableViewTableViewFocusModelBuilder<S> create(javafx.scene.control.TableView<S> tableView) {
        TableViewTableViewFocusModelBuilder<S> builder = new TableViewTableViewFocusModelBuilder<S>();
        builder.constructorArgs = new Object[]{tableView};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.TableView.TableViewFocusModel TableViewFocusModel} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.TableView.TableViewFocusModel TableViewFocusModel} class
     */
    public javafx.scene.control.TableView.TableViewFocusModel<S> build() {
        javafx.scene.control.TableView.TableViewFocusModel<S> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.TableView.TableViewFocusModel<S>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.TableView.TableViewFocusModel<S> callParameterizedConstructor() {
        javafx.scene.control.TableView.TableViewFocusModel<S> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TableView.TableViewFocusModel.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TableView.TableViewFocusModel<S>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the TableViewFocusModel instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TableViewTableViewFocusModelBuilder<S> apply(java.util.function.Consumer<javafx.scene.control.TableView.TableViewFocusModel<S>> func) {
        operations.add(func);
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableView.TableViewFocusModel#focusedCellProperty() focusedCellProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TableViewTableViewFocusModelBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * {@snippet :
     * // Use apply
     * .apply(obj -> obj.focusedCellProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .focusedCellPropertyApply(prop -> prop.bind(anotherProperty))
     * }
     *
     * @return builder instance
     */
    @SuppressWarnings("rawtypes")
    public TableViewTableViewFocusModelBuilder<S> focusedCellPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TablePosition>> op) {
        operations.add(obj -> op.accept(obj.focusedCellProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.FocusModel#focusedIndexProperty() focusedIndexProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TableViewTableViewFocusModelBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * {@snippet :
     * // Use apply
     * .apply(obj -> obj.focusedIndexProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .focusedIndexPropertyApply(prop -> prop.bind(anotherProperty))
     * }
     *
     * @return builder instance
     */
    public TableViewTableViewFocusModelBuilder<S> focusedIndexPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyIntegerProperty> op) {
        operations.add(obj -> op.accept(obj.focusedIndexProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.FocusModel#focusedItemProperty() focusedItemProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TableViewTableViewFocusModelBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * {@snippet :
     * // Use apply
     * .apply(obj -> obj.focusedItemProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .focusedItemPropertyApply(prop -> prop.bind(anotherProperty))
     * }
     *
     * @return builder instance
     */
    public TableViewTableViewFocusModelBuilder<S> focusedItemPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<S>> op) {
        operations.add(obj -> op.accept(obj.focusedItemProperty()));
        return this;
    }
}
