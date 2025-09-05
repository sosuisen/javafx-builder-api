
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code TableColumnBuilder} class constructs instances of the {@link javafx.scene.control.TableColumn TableColumn} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.TableColumn TableColumn} constructor
 * and returns an instance of the {@code TableColumnBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.TableColumn TableColumn}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.TableColumn TableColumn} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class TableColumnBuilder<S, T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>>> operations = new java.util.ArrayList<>();
    private TableColumnBuilder() {}
    
    /**
     * Returns an instance of the {@code TableColumnBuilder<S, T>}.
     *
     * @return an instance of the {@code TableColumnBuilder<S, T>}.
     */
    public static <S, T> TableColumnBuilder<S, T> create() { return new TableColumnBuilder<S, T>(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.TableColumn#TableColumn(String) TableColumn(String)}
     * and returns an instance of {@code TableColumnBuilder<S, T>}.
     *
     * @return an instance of the {@code TableColumnBuilder<S, T>}.
     */
    
    public static <S, T> TableColumnBuilder<S, T> create(java.lang.String text) {
        TableColumnBuilder<S, T> builder = new TableColumnBuilder<S, T>();
        builder.constructorArgs = new Object[]{text};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.TableColumn<S, T>} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.TableColumn TableColumn} class
     */
    public javafx.scene.control.TableColumn<S, T> build() {
        javafx.scene.control.TableColumn<S, T> newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.TableColumn<>();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.TableColumn<S, T> callParameterizedConstructor() {
        javafx.scene.control.TableColumn<S, T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TableColumn.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TableColumn<S, T>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the TableColumn instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TableColumnBuilder<S, T> apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setCellFactory(javafx.util.Callback) setCellFactory} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> cellFactory(javafx.util.Callback<javafx.scene.control.TableColumn<S, T>, javafx.scene.control.TableCell<S, T>> value) {
        operations.add(obj -> obj.setCellFactory(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setCellValueFactory(javafx.util.Callback) setCellValueFactory} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> cellValueFactory(javafx.util.Callback<javafx.scene.control.TableColumn.CellDataFeatures<S, T>, javafx.beans.value.ObservableValue<T>> value) {
        operations.add(obj -> obj.setCellValueFactory(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setComparator(java.util.Comparator) setComparator} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> comparator(java.util.Comparator<T> value) {
        operations.add(obj -> obj.setComparator(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setContextMenu(javafx.scene.control.ContextMenu) setContextMenu} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> contextMenu(javafx.scene.control.ContextMenu value) {
        operations.add(obj -> obj.setContextMenu(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setEditable(boolean) setEditable} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> editable(boolean value) {
        operations.add(obj -> obj.setEditable(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setGraphic(javafx.scene.Node) setGraphic} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setId(java.lang.String) setId} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setMaxWidth(double) setMaxWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setMinWidth(double) setMinWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setOnEditCancel(javafx.event.EventHandler) setOnEditCancel} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> onEditCancel(javafx.event.EventHandler<javafx.scene.control.TableColumn.CellEditEvent<S, T>> value) {
        operations.add(obj -> obj.setOnEditCancel(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setOnEditCommit(javafx.event.EventHandler) setOnEditCommit} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> onEditCommit(javafx.event.EventHandler<javafx.scene.control.TableColumn.CellEditEvent<S, T>> value) {
        operations.add(obj -> obj.setOnEditCommit(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setOnEditStart(javafx.event.EventHandler) setOnEditStart} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> onEditStart(javafx.event.EventHandler<javafx.scene.control.TableColumn.CellEditEvent<S, T>> value) {
        operations.add(obj -> obj.setOnEditStart(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setPrefWidth(double) setPrefWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setReorderable(boolean) setReorderable} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> reorderable(boolean value) {
        operations.add(obj -> obj.setReorderable(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setResizable(boolean) setResizable} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> resizable(boolean value) {
        operations.add(obj -> obj.setResizable(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setSortNode(javafx.scene.Node) setSortNode} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> sortNode(javafx.scene.Node value) {
        operations.add(obj -> obj.setSortNode(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setSortType(javafx.scene.control.TableColumn$SortType) setSortType} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> sortType(javafx.scene.control.TableColumn.SortType value) {
        operations.add(obj -> obj.setSortType(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setSortable(boolean) setSortable} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> sortable(boolean value) {
        operations.add(obj -> obj.setSortable(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setStyle(java.lang.String) setStyle} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setText(java.lang.String) setText} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setUserData(java.lang.Object) setUserData} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.TableColumn#setVisible(boolean) setVisible} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TableColumnBuilder<S, T> visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableColumn#getColumns()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TableColumnBuilder<S, T> addColumns(javafx.scene.control.TableColumn<S, ?>... elements) {
        operations.add(obj -> {
            obj.getColumns().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableColumn#getColumns()} method.
     * 
     * @return builder instance
     */
    public final TableColumnBuilder<S, T> addColumns(java.util.Collection<? extends javafx.scene.control.TableColumn<S, ?>> col) {
        operations.add(obj -> {
            obj.getColumns().addAll(col);
        });
        return this;
    }

    /**
     * Creates an instance of the builder, then calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableColumn#getColumns()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public static <S, T> TableColumnBuilder<S, T> withColumns(javafx.scene.control.TableColumn<S, ?>... elements) {
        TableColumnBuilder<S, T> builder = new TableColumnBuilder<S, T>();
        return builder.addColumns(elements);
    }

    /**
     * Creates an instance of the builder, then calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableColumn#getColumns()} method.
     * 
     * @return builder instance
     */
    public static <S, T> TableColumnBuilder<S, T> withColumns(java.util.Collection<? extends javafx.scene.control.TableColumn<S, ?>> col) {
        TableColumnBuilder<S, T> builder = new TableColumnBuilder<S, T>();
        return builder.addColumns(col);
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableColumn#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TableColumnBuilder<S, T> addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableColumn#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final TableColumnBuilder<S, T> addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#cellFactoryProperty() cellFactoryProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> cellFactoryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.TableColumn<S, T>, javafx.scene.control.TableCell<S, T>>>> op) {
        operations.add(obj -> op.accept(obj.cellFactoryProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#cellValueFactoryProperty() cellValueFactoryProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> cellValueFactoryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.TableColumn.CellDataFeatures<S, T>, javafx.beans.value.ObservableValue<T>>>> op) {
        operations.add(obj -> op.accept(obj.cellValueFactoryProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#comparatorProperty() comparatorProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> comparatorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.util.Comparator<T>>> op) {
        operations.add(obj -> op.accept(obj.comparatorProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#contextMenuProperty() contextMenuProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> contextMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.contextMenuProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#editableProperty() editableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> editablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.editableProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#graphicProperty() graphicProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#idProperty() idProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#maxWidthProperty() maxWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#minWidthProperty() minWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#onEditCancelProperty() onEditCancelProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> onEditCancelPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.TableColumn.CellEditEvent<S, T>>>> op) {
        operations.add(obj -> op.accept(obj.onEditCancelProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#onEditCommitProperty() onEditCommitProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> onEditCommitPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.TableColumn.CellEditEvent<S, T>>>> op) {
        operations.add(obj -> op.accept(obj.onEditCommitProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#onEditStartProperty() onEditStartProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> onEditStartPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.TableColumn.CellEditEvent<S, T>>>> op) {
        operations.add(obj -> op.accept(obj.onEditStartProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#parentColumnProperty() parentColumnProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> parentColumnPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TableColumnBase<S, ?>>> op) {
        operations.add(obj -> op.accept(obj.parentColumnProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#prefWidthProperty() prefWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#reorderableProperty() reorderableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> reorderablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.reorderableProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#resizableProperty() resizableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> resizablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.resizableProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#sortNodeProperty() sortNodeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> sortNodePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.sortNodeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#sortTypeProperty() sortTypeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> sortTypePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.TableColumn.SortType>> op) {
        operations.add(obj -> op.accept(obj.sortTypeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#sortableProperty() sortableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> sortablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.sortableProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#styleProperty() styleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#tableViewProperty() tableViewProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.tableViewProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .tableViewPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TableColumnBuilder<S, T> tableViewPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TableView<S>>> op) {
        operations.add(obj -> op.accept(obj.tableViewProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#textProperty() textProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#visibleProperty() visibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.TableColumn#widthProperty() widthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) apply} method.
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
    public TableColumnBuilder<S, T> widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
