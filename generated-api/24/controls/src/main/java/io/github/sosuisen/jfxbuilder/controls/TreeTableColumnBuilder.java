
package io.github.sosuisen.jfxbuilder.controls;


public class TreeTableColumnBuilder<S, T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.TreeTableColumn<S, T>>> operations = new java.util.ArrayList<>();
    private TreeTableColumnBuilder() {}
    

    public static <S, T> TreeTableColumnBuilder<S, T> create() { return new TreeTableColumnBuilder<S, T>(); }


    
    public static <S, T> TreeTableColumnBuilder<S, T> create(java.lang.String text) {
        TreeTableColumnBuilder<S, T> builder = new TreeTableColumnBuilder<S, T>();
        builder.constructorArgs = new Object[]{text};
        return builder;
    }

    private Object[] constructorArgs;

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
    
    public TreeTableColumnBuilder<S, T> apply(java.util.function.Consumer<javafx.scene.control.TreeTableColumn<S, T>> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setCellFactory(javafx.util.Callback)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> cellFactory(javafx.util.Callback<javafx.scene.control.TreeTableColumn<S, T>, javafx.scene.control.TreeTableCell<S, T>> value) {
        operations.add(obj -> obj.setCellFactory(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setCellValueFactory(javafx.util.Callback)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> cellValueFactory(javafx.util.Callback<javafx.scene.control.TreeTableColumn.CellDataFeatures<S, T>, javafx.beans.value.ObservableValue<T>> value) {
        operations.add(obj -> obj.setCellValueFactory(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setComparator(java.util.Comparator)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> comparator(java.util.Comparator<T> value) {
        operations.add(obj -> obj.setComparator(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setContextMenu(javafx.scene.control.ContextMenu)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> contextMenu(javafx.scene.control.ContextMenu value) {
        operations.add(obj -> obj.setContextMenu(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setEditable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> editable(boolean value) {
        operations.add(obj -> obj.setEditable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setGraphic(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setOnEditCancel(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> onEditCancel(javafx.event.EventHandler<javafx.scene.control.TreeTableColumn.CellEditEvent<S, T>> value) {
        operations.add(obj -> obj.setOnEditCancel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setOnEditCommit(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> onEditCommit(javafx.event.EventHandler<javafx.scene.control.TreeTableColumn.CellEditEvent<S, T>> value) {
        operations.add(obj -> obj.setOnEditCommit(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setOnEditStart(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> onEditStart(javafx.event.EventHandler<javafx.scene.control.TreeTableColumn.CellEditEvent<S, T>> value) {
        operations.add(obj -> obj.setOnEditStart(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setReorderable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> reorderable(boolean value) {
        operations.add(obj -> obj.setReorderable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setResizable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> resizable(boolean value) {
        operations.add(obj -> obj.setResizable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setSortNode(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> sortNode(javafx.scene.Node value) {
        operations.add(obj -> obj.setSortNode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setSortType(javafx.scene.control.TreeTableColumn$SortType)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> sortType(javafx.scene.control.TreeTableColumn.SortType value) {
        operations.add(obj -> obj.setSortType(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setSortable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> sortable(boolean value) {
        operations.add(obj -> obj.setSortable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableColumn#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableColumnBuilder<S, T> visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TreeTableColumn#getColumns()} method.
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
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TreeTableColumn#getColumns()} method.
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
     * Create an instance of the builder, then call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TreeTableColumn#getColumns()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public static <S, T> TreeTableColumnBuilder<S, T> withColumns(javafx.scene.control.TreeTableColumn<S, ?>... elements) {
        TreeTableColumnBuilder<S, T> builder = new TreeTableColumnBuilder<S, T>();
        return builder.addColumns(elements);
    }

    /**
     * Create an instance of the builder, then call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TreeTableColumn#getColumns()} method.
     * 
     * @return builder instance
     */     
    public static <S, T> TreeTableColumnBuilder<S, T> withColumns(java.util.Collection<? extends javafx.scene.control.TreeTableColumn<S, ?>> col) {
        TreeTableColumnBuilder<S, T> builder = new TreeTableColumnBuilder<S, T>();
        return builder.addColumns(col);
    }


    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TreeTableColumn#getStyleClass()} method.
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
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TreeTableColumn#getStyleClass()} method.
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
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#cellFactoryProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> cellFactoryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.TreeTableColumn<S, T>, javafx.scene.control.TreeTableCell<S, T>>>> op) {
        operations.add(obj -> op.accept(obj.cellFactoryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#cellValueFactoryProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> cellValueFactoryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.TreeTableColumn.CellDataFeatures<S, T>, javafx.beans.value.ObservableValue<T>>>> op) {
        operations.add(obj -> op.accept(obj.cellValueFactoryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#comparatorProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> comparatorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.util.Comparator<T>>> op) {
        operations.add(obj -> op.accept(obj.comparatorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#contextMenuProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> contextMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.contextMenuProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#editableProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> editablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.editableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#graphicProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#onEditCancelProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> onEditCancelPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.TreeTableColumn.CellEditEvent<S, T>>>> op) {
        operations.add(obj -> op.accept(obj.onEditCancelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#onEditCommitProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> onEditCommitPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.TreeTableColumn.CellEditEvent<S, T>>>> op) {
        operations.add(obj -> op.accept(obj.onEditCommitProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#onEditStartProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> onEditStartPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.TreeTableColumn.CellEditEvent<S, T>>>> op) {
        operations.add(obj -> op.accept(obj.onEditStartProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#parentColumnProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> parentColumnPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TableColumnBase<javafx.scene.control.TreeItem<S>, ?>>> op) {
        operations.add(obj -> op.accept(obj.parentColumnProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#reorderableProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> reorderablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.reorderableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#resizableProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> resizablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.resizableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#sortNodeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> sortNodePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.sortNodeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#sortTypeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> sortTypePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.TreeTableColumn.SortType>> op) {
        operations.add(obj -> op.accept(obj.sortTypeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#sortableProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> sortablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.sortableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#textProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#treeTableViewProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> treeTableViewPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TreeTableView<S>>> op) {
        operations.add(obj -> op.accept(obj.treeTableViewProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableColumn#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableColumnBuilder<S, T> widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
