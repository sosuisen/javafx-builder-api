
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code TreeItemBuilder} class constructs instances of the {@link javafx.scene.control.TreeItem TreeItem} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.TreeItem TreeItem} constructor
 * and returns an instance of the {@code TreeItemBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.TreeItem TreeItem}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.TreeItem TreeItem} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class TreeItemBuilder<T> {
    private final java.util.List<java.util.function.Consumer<javafx.scene.control.TreeItem<T>>> operations = new java.util.ArrayList<>();
    private TreeItemBuilder() {}
    
    /**
     * Returns an instance of the {@code TreeItemBuilder<T>}.
     *
     * @return an instance of the {@code TreeItemBuilder<T>}.
     */
    public static <T> TreeItemBuilder<T> create() { return new TreeItemBuilder<T>(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.TreeItem#TreeItem(java.lang.Object) TreeItem(T)}
     * and returns an instance of {@code TreeItemBuilder<T>}.
     *
     * @return an instance of the {@code TreeItemBuilder<T>}.
     */
    public static <T> TreeItemBuilder<T> create(T value) {
        TreeItemBuilder<T> builder = new TreeItemBuilder<T>();
        builder.constructorArgs = new Object[]{value};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.TreeItem#TreeItem(java.lang.Object, javafx.scene.Node) TreeItem(T, Node)}
     * and returns an instance of {@code TreeItemBuilder<T>}.
     *
     * @return an instance of the {@code TreeItemBuilder<T>}.
     */
    public static <T> TreeItemBuilder<T> create(T value, javafx.scene.Node graphic) {
        TreeItemBuilder<T> builder = new TreeItemBuilder<T>();
        builder.constructorArgs = new Object[]{value, graphic};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.TreeItem TreeItem} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.TreeItem TreeItem} class
     */
    public javafx.scene.control.TreeItem<T> build() {
        javafx.scene.control.TreeItem<T> newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.TreeItem<>();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.TreeItem<T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.TreeItem<T> callParameterizedConstructor() {
        javafx.scene.control.TreeItem<T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TreeItem.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TreeItem<T>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the TreeItem instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TreeItemBuilder<T> apply(java.util.function.Consumer<javafx.scene.control.TreeItem<T>> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeItem#setExpanded(boolean) setExpanded} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeItemBuilder<T> expanded(boolean value) {
        operations.add(obj -> obj.setExpanded(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeItem#setGraphic(javafx.scene.Node) setGraphic} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeItemBuilder<T> graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeItem#setValue(java.lang.Object) setValue} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeItemBuilder<T> value(T value) {
        operations.add(obj -> obj.setValue(value));
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(java.lang.Object[]) addAll} method on the ObservableList
     * returned by the {@link javafx.scene.control.TreeItem#getChildren() TreeItem#getChildren()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TreeItemBuilder<T> addChildren(javafx.scene.control.TreeItem<T>... elements) {
        operations.add(obj -> obj.getChildren().addAll(elements));
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(java.util.Collection) addAll} method on the ObservableList
     * returned by the {@link javafx.scene.control.TreeItem#getChildren() TreeItem#getChildren()} method.
     * 
     * @return builder instance
     */
    public final TreeItemBuilder<T> addChildren(java.util.Collection<? extends javafx.scene.control.TreeItem<T>> col) {
        operations.add(obj -> obj.getChildren().addAll(col));
        return this;
    }

    /**
     * Creates an instance of the builder, then calls the {@link javafx.collections.ObservableList#addAll(java.lang.Object[]) addAll} method on the ObservableList
     * returned by the {@link javafx.scene.control.TreeItem#getChildren() TreeItem#getChildren()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public static <T> TreeItemBuilder<T> withChildren(javafx.scene.control.TreeItem<T>... elements) {
        TreeItemBuilder<T> builder = new TreeItemBuilder<T>();
        return builder.addChildren(elements);
    }

    /**
     * Creates an instance of the builder, then calls the {@link java.util.List#addAll(java.util.Collection) addAll} method on the ObservableList
     * returned by the {@link javafx.scene.control.TreeItem#getChildren() TreeItem#getChildren()} method.
     * 
     * @return builder instance
     */
    public static <T> TreeItemBuilder<T> withChildren(java.util.Collection<? extends javafx.scene.control.TreeItem<T>> col) {
        TreeItemBuilder<T> builder = new TreeItemBuilder<T>();
        return builder.addChildren(col);
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeItem#expandedProperty() expandedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeItemBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.expandedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .expandedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeItemBuilder<T> expandedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.expandedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeItem#graphicProperty() graphicProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeItemBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.graphicProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .graphicPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeItemBuilder<T> graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeItem#leafProperty() leafProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeItemBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.leafProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .leafPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeItemBuilder<T> leafPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.leafProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeItem#parentProperty() parentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeItemBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.parentProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .parentPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeItemBuilder<T> parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TreeItem<T>>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeItem#valueProperty() valueProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeItemBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.valueProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .valuePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeItemBuilder<T> valuePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<T>> op) {
        operations.add(obj -> op.accept(obj.valueProperty()));
        return this;
    }
}
