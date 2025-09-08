
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code TreeTableColumnBuilder} class constructs instances of the {@link javafx.scene.control.TreeTableColumn TreeTableColumn} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.TreeTableColumn TreeTableColumn} constructor
 * and returns an instance of the {@code TreeTableColumnBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.TreeTableColumn TreeTableColumn}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.TreeTableColumn TreeTableColumn} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class TreeTableColumnBuilder<S, T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.TreeTableColumn<S, T>>> operations = new java.util.ArrayList<>();
    private TreeTableColumnBuilder() {}
    
    /**
     * Returns an instance of the {@code TreeTableColumnBuilder<S, T>}.
     *
     * @return an instance of the {@code TreeTableColumnBuilder<S, T>}.
     */
    public static <S, T> TreeTableColumnBuilder<S, T> create() { return new TreeTableColumnBuilder<S, T>(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.TreeTableColumn#TreeTableColumn(String) TreeTableColumn(String)}
     * and returns an instance of {@code TreeTableColumnBuilder<S, T>}.
     *
     * @return an instance of the {@code TreeTableColumnBuilder<S, T>}.
     */
    
    public static <S, T> TreeTableColumnBuilder<S, T> create(java.lang.String text) {
        TreeTableColumnBuilder<S, T> builder = new TreeTableColumnBuilder<S, T>();
        builder.constructorArgs = new Object[]{text};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.TreeTableColumn<S, T>} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.TreeTableColumn TreeTableColumn} class
     */
    public javafx.scene.control.TreeTableColumn<S, T> build() {
        javafx.scene.control.TreeTableColumn<S, T> newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.TreeTableColumn<>();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.TreeTableColumn<S, T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.TreeTableColumn<S, T> callParameterizedConstructor() {
        javafx.scene.control.TreeTableColumn<S, T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TreeTableColumn.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TreeTableColumn<S, T>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the TreeTableColumn instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TreeTableColumnBuilder<S, T> apply(java.util.function.Consumer<javafx.scene.control.TreeTableColumn<S, T>> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setCellFactory(javafx.util.Callback) setCellFactory} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> cellFactory(javafx.util.Callback<javafx.scene.control.TreeTableColumn<S, T>, javafx.scene.control.TreeTableCell<S, T>> value) {
        operations.add(obj -> obj.setCellFactory(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setCellValueFactory(javafx.util.Callback) setCellValueFactory} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> cellValueFactory(javafx.util.Callback<javafx.scene.control.TreeTableColumn.CellDataFeatures<S, T>, javafx.beans.value.ObservableValue<T>> value) {
        operations.add(obj -> obj.setCellValueFactory(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setComparator(java.util.Comparator) setComparator} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> comparator(java.util.Comparator<T> value) {
        operations.add(obj -> obj.setComparator(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setContextMenu(javafx.scene.control.ContextMenu) setContextMenu} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> contextMenu(javafx.scene.control.ContextMenu value) {
        operations.add(obj -> obj.setContextMenu(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setEditable(boolean) setEditable} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> editable(boolean value) {
        operations.add(obj -> obj.setEditable(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setGraphic(javafx.scene.Node) setGraphic} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setId(java.lang.String) setId} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setMaxWidth(double) setMaxWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setMinWidth(double) setMinWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setOnEditCancel(javafx.event.EventHandler) setOnEditCancel} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> onEditCancel(javafx.event.EventHandler<javafx.scene.control.TreeTableColumn.CellEditEvent<S, T>> value) {
        operations.add(obj -> obj.setOnEditCancel(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setOnEditCommit(javafx.event.EventHandler) setOnEditCommit} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> onEditCommit(javafx.event.EventHandler<javafx.scene.control.TreeTableColumn.CellEditEvent<S, T>> value) {
        operations.add(obj -> obj.setOnEditCommit(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setOnEditStart(javafx.event.EventHandler) setOnEditStart} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> onEditStart(javafx.event.EventHandler<javafx.scene.control.TreeTableColumn.CellEditEvent<S, T>> value) {
        operations.add(obj -> obj.setOnEditStart(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setPrefWidth(double) setPrefWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setReorderable(boolean) setReorderable} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> reorderable(boolean value) {
        operations.add(obj -> obj.setReorderable(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setResizable(boolean) setResizable} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> resizable(boolean value) {
        operations.add(obj -> obj.setResizable(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setSortNode(javafx.scene.Node) setSortNode} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> sortNode(javafx.scene.Node value) {
        operations.add(obj -> obj.setSortNode(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setSortType(javafx.scene.control.TreeTableColumn$SortType) setSortType} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> sortType(javafx.scene.control.TreeTableColumn.SortType value) {
        operations.add(obj -> obj.setSortType(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setSortable(boolean) setSortable} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> sortable(boolean value) {
        operations.add(obj -> obj.setSortable(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setStyle(java.lang.String) setStyle} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setText(java.lang.String) setText} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setUserData(java.lang.Object) setUserData} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TreeTableColumn#setVisible(boolean) setVisible} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TreeTableColumnBuilder<S, T> visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TreeTableColumn#getColumns()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TreeTableColumnBuilder<S, T> addColumns(javafx.scene.control.TreeTableColumn<S, ?>... elements) {
        operations.add(obj -> {
            obj.getColumns().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TreeTableColumn#getColumns()} method.
     * 
     * @return builder instance
     */
    public final TreeTableColumnBuilder<S, T> addColumns(java.util.Collection<? extends javafx.scene.control.TreeTableColumn<S, ?>> col) {
        operations.add(obj -> {
            obj.getColumns().addAll(col);
        });
        return this;
    }

    /**
     * Creates an instance of the builder, then calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TreeTableColumn#getColumns()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public static <S, T> TreeTableColumnBuilder<S, T> withColumns(javafx.scene.control.TreeTableColumn<S, ?>... elements) {
        TreeTableColumnBuilder<S, T> builder = new TreeTableColumnBuilder<S, T>();
        return builder.addColumns(elements);
    }

    /**
     * Creates an instance of the builder, then calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TreeTableColumn#getColumns()} method.
     * 
     * @return builder instance
     */
    public static <S, T> TreeTableColumnBuilder<S, T> withColumns(java.util.Collection<? extends javafx.scene.control.TreeTableColumn<S, ?>> col) {
        TreeTableColumnBuilder<S, T> builder = new TreeTableColumnBuilder<S, T>();
        return builder.addColumns(col);
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TreeTableColumn#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TreeTableColumnBuilder<S, T> addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TreeTableColumn#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final TreeTableColumnBuilder<S, T> addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#cellFactoryProperty() cellFactoryProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.cellFactoryProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .cellFactoryPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> cellFactoryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.TreeTableColumn<S, T>, javafx.scene.control.TreeTableCell<S, T>>>> op) {
        operations.add(obj -> op.accept(obj.cellFactoryProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#cellValueFactoryProperty() cellValueFactoryProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.cellValueFactoryProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .cellValueFactoryPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> cellValueFactoryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.TreeTableColumn.CellDataFeatures<S, T>, javafx.beans.value.ObservableValue<T>>>> op) {
        operations.add(obj -> op.accept(obj.cellValueFactoryProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#comparatorProperty() comparatorProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.comparatorProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .comparatorPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> comparatorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.util.Comparator<T>>> op) {
        operations.add(obj -> op.accept(obj.comparatorProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#contextMenuProperty() contextMenuProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.contextMenuProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .contextMenuPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> contextMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.contextMenuProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#editableProperty() editableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.editableProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .editablePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> editablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.editableProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#graphicProperty() graphicProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
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
    public TreeTableColumnBuilder<S, T> graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#idProperty() idProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.idProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .idPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#maxWidthProperty() maxWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.maxWidthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .maxWidthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#minWidthProperty() minWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.minWidthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .minWidthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#onEditCancelProperty() onEditCancelProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onEditCancelProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onEditCancelPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> onEditCancelPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.TreeTableColumn.CellEditEvent<S, T>>>> op) {
        operations.add(obj -> op.accept(obj.onEditCancelProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#onEditCommitProperty() onEditCommitProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onEditCommitProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onEditCommitPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> onEditCommitPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.TreeTableColumn.CellEditEvent<S, T>>>> op) {
        operations.add(obj -> op.accept(obj.onEditCommitProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#onEditStartProperty() onEditStartProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onEditStartProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onEditStartPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> onEditStartPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.TreeTableColumn.CellEditEvent<S, T>>>> op) {
        operations.add(obj -> op.accept(obj.onEditStartProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#parentColumnProperty() parentColumnProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.parentColumnProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .parentColumnPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> parentColumnPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TableColumnBase<javafx.scene.control.TreeItem<S>, ?>>> op) {
        operations.add(obj -> op.accept(obj.parentColumnProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#prefWidthProperty() prefWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.prefWidthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .prefWidthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#reorderableProperty() reorderableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.reorderableProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .reorderablePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> reorderablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.reorderableProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#resizableProperty() resizableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.resizableProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .resizablePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> resizablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.resizableProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#sortNodeProperty() sortNodeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.sortNodeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .sortNodePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> sortNodePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.sortNodeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#sortTypeProperty() sortTypeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.sortTypeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .sortTypePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> sortTypePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.TreeTableColumn.SortType>> op) {
        operations.add(obj -> op.accept(obj.sortTypeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#sortableProperty() sortableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.sortableProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .sortablePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> sortablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.sortableProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#styleProperty() styleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.styleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .stylePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#textProperty() textProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.textProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .textPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#treeTableViewProperty() treeTableViewProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.treeTableViewProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .treeTableViewPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> treeTableViewPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TreeTableView<S>>> op) {
        operations.add(obj -> op.accept(obj.treeTableViewProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#visibleProperty() visibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.visibleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .visiblePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#widthProperty() widthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TreeTableColumnBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.widthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .widthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TreeTableColumnBuilder<S, T> widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
