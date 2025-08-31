
package io.github.sosuisen.jfxbuilder.controls;


public class TableColumnBuilder<S, T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>>> operations = new java.util.ArrayList<>();
    private TableColumnBuilder() {}
    

    public static <S, T> TableColumnBuilder<S, T> create() { return new TableColumnBuilder<S, T>(); }


    
    public static <S, T> TableColumnBuilder<S, T> create(java.lang.String text) {
        TableColumnBuilder<S, T> builder = new TableColumnBuilder<S, T>();
        builder.constructorArgs = new Object[]{text};
        return builder;
    }

    private Object[] constructorArgs;

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
    
    public TableColumnBuilder<S, T> apply(java.util.function.Consumer<javafx.scene.control.TableColumn<S, T>> func) {
        operations.add(func);
        return this;
    }    
    
    public  TableColumnBuilder<S, T> cellFactory(javafx.util.Callback<javafx.scene.control.TableColumn<S, T>, javafx.scene.control.TableCell<S, T>> value) {
        operations.add(obj -> obj.setCellFactory(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> cellValueFactory(javafx.util.Callback<javafx.scene.control.TableColumn.CellDataFeatures<S, T>, javafx.beans.value.ObservableValue<T>> value) {
        operations.add(obj -> obj.setCellValueFactory(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> comparator(java.util.Comparator<T> value) {
        operations.add(obj -> obj.setComparator(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> contextMenu(javafx.scene.control.ContextMenu value) {
        operations.add(obj -> obj.setContextMenu(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> editable(boolean value) {
        operations.add(obj -> obj.setEditable(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> onEditCancel(javafx.event.EventHandler<javafx.scene.control.TableColumn.CellEditEvent<S, T>> value) {
        operations.add(obj -> obj.setOnEditCancel(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> onEditCommit(javafx.event.EventHandler<javafx.scene.control.TableColumn.CellEditEvent<S, T>> value) {
        operations.add(obj -> obj.setOnEditCommit(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> onEditStart(javafx.event.EventHandler<javafx.scene.control.TableColumn.CellEditEvent<S, T>> value) {
        operations.add(obj -> obj.setOnEditStart(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> reorderable(boolean value) {
        operations.add(obj -> obj.setReorderable(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> resizable(boolean value) {
        operations.add(obj -> obj.setResizable(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> sortNode(javafx.scene.Node value) {
        operations.add(obj -> obj.setSortNode(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> sortType(javafx.scene.control.TableColumn.SortType value) {
        operations.add(obj -> obj.setSortType(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> sortable(boolean value) {
        operations.add(obj -> obj.setSortable(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }    
    
    public  TableColumnBuilder<S, T> visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    @SafeVarargs
    public final TableColumnBuilder<S, T> addColumns(javafx.scene.control.TableColumn<S, ?>... elements) {
        operations.add(obj -> {
            obj.getColumns().addAll(elements);
        });
        return this;
    }

    public final TableColumnBuilder<S, T> addColumns(java.util.Collection<? extends javafx.scene.control.TableColumn<S, ?>> col) {
        operations.add(obj -> {
            obj.getColumns().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public static <S, T> TableColumnBuilder<S, T> withColumns(javafx.scene.control.TableColumn<S, ?>... elements) {
        TableColumnBuilder<S, T> builder = new TableColumnBuilder<S, T>();
        return builder.addColumns(elements);
    }

    public static <S, T> TableColumnBuilder<S, T> withColumns(java.util.Collection<? extends javafx.scene.control.TableColumn<S, ?>> col) {
        TableColumnBuilder<S, T> builder = new TableColumnBuilder<S, T>();
        return builder.addColumns(col);
    }

    @SafeVarargs
    public final TableColumnBuilder<S, T> addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    public final TableColumnBuilder<S, T> addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }

    
    
    public TableColumnBuilder<S, T> cellFactoryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.TableColumn<S, T>, javafx.scene.control.TableCell<S, T>>>> op) {
        operations.add(obj -> op.accept(obj.cellFactoryProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> cellValueFactoryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.TableColumn.CellDataFeatures<S, T>, javafx.beans.value.ObservableValue<T>>>> op) {
        operations.add(obj -> op.accept(obj.cellValueFactoryProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> comparatorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.util.Comparator<T>>> op) {
        operations.add(obj -> op.accept(obj.comparatorProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> contextMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.contextMenuProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> editablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.editableProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> onEditCancelPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.TableColumn.CellEditEvent<S, T>>>> op) {
        operations.add(obj -> op.accept(obj.onEditCancelProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> onEditCommitPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.TableColumn.CellEditEvent<S, T>>>> op) {
        operations.add(obj -> op.accept(obj.onEditCommitProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> onEditStartPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.TableColumn.CellEditEvent<S, T>>>> op) {
        operations.add(obj -> op.accept(obj.onEditStartProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> parentColumnPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TableColumnBase<S, ?>>> op) {
        operations.add(obj -> op.accept(obj.parentColumnProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> reorderablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.reorderableProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> resizablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.resizableProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> sortNodePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.sortNodeProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> sortTypePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.TableColumn.SortType>> op) {
        operations.add(obj -> op.accept(obj.sortTypeProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> sortablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.sortableProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> tableViewPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TableView<S>>> op) {
        operations.add(obj -> op.accept(obj.tableViewProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    
    public TableColumnBuilder<S, T> widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
