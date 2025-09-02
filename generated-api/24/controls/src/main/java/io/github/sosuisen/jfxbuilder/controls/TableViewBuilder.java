
package io.github.sosuisen.jfxbuilder.controls;


public class TableViewBuilder<S> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.TableView<S>>> operations = new java.util.ArrayList<>();
    private TableViewBuilder() {}
    

    public static <S> TableViewBuilder<S> create() { return new TableViewBuilder<S>(); }


    
    public static <S> TableViewBuilder<S> create(javafx.collections.ObservableList<S> items) {
        TableViewBuilder<S> builder = new TableViewBuilder<S>();
        builder.constructorArgs = new Object[]{items};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.control.TableView<S> build() {
        javafx.scene.control.TableView<S> newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.TableView<>();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.TableView<S>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.TableView<S> callParameterizedConstructor() {
        javafx.scene.control.TableView<S> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TableView.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TableView<S>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the TableView instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(tableView -> tableView.setId("Main" + tableView.getTypeSelector()))
     * }</pre>
     * 
     * @return builder instance
     *
     */
    public TableViewBuilder<S> apply(java.util.function.Consumer<javafx.scene.control.TableView<S>> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setBackground(javafx.scene.layout.Background)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setBorder(javafx.scene.layout.Border)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setCacheShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setCenterShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setColumnResizePolicy(javafx.util.Callback)}
     * 
     * @return builder instance
     */    
    @SuppressWarnings("rawtypes")
    public  TableViewBuilder<S> columnResizePolicy(javafx.util.Callback<javafx.scene.control.TableView.ResizeFeatures, java.lang.Boolean> callback) {
        operations.add(obj -> obj.setColumnResizePolicy(callback));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setContextMenu(javafx.scene.control.ContextMenu)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> contextMenu(javafx.scene.control.ContextMenu value) {
        operations.add(obj -> obj.setContextMenu(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setEditable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> editable(boolean value) {
        operations.add(obj -> obj.setEditable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setFixedCellSize(double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> fixedCellSize(double value) {
        operations.add(obj -> obj.setFixedCellSize(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setFocusModel(javafx.scene.control.TableView$TableViewFocusModel)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> focusModel(javafx.scene.control.TableView.TableViewFocusModel<S> value) {
        operations.add(obj -> obj.setFocusModel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setItems(javafx.collections.ObservableList)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> items(javafx.collections.ObservableList<S> value) {
        operations.add(obj -> obj.setItems(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnScrollTo(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onScrollTo(javafx.event.EventHandler<javafx.scene.control.ScrollToEvent<java.lang.Integer>> value) {
        operations.add(obj -> obj.setOnScrollTo(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnScrollToColumn(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onScrollToColumn(javafx.event.EventHandler<javafx.scene.control.ScrollToEvent<javafx.scene.control.TableColumn<S, ?>>> value) {
        operations.add(obj -> obj.setOnScrollToColumn(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnSort(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onSort(javafx.event.EventHandler<javafx.scene.control.SortEvent<javafx.scene.control.TableView<S>>> value) {
        operations.add(obj -> obj.setOnSort(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setOpaqueInsets(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setPadding(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setPlaceholder(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> placeholder(javafx.scene.Node value) {
        operations.add(obj -> obj.setPlaceholder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setRowFactory(javafx.util.Callback)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> rowFactory(javafx.util.Callback<javafx.scene.control.TableView<S>, javafx.scene.control.TableRow<S>> value) {
        operations.add(obj -> obj.setRowFactory(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setScaleShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setSelectionModel(javafx.scene.control.TableView$TableViewSelectionModel)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> selectionModel(javafx.scene.control.TableView.TableViewSelectionModel<S> value) {
        operations.add(obj -> obj.setSelectionModel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setShape(javafx.scene.shape.Shape)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setSkin(javafx.scene.control.Skin)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> skin(javafx.scene.control.Skin<?> value) {
        operations.add(obj -> obj.setSkin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setSnapToPixel(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setSortPolicy(javafx.util.Callback)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> sortPolicy(javafx.util.Callback<javafx.scene.control.TableView<S>, java.lang.Boolean> callback) {
        operations.add(obj -> obj.setSortPolicy(callback));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setTableMenuButtonVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> tableMenuButtonVisible(boolean value) {
        operations.add(obj -> obj.setTableMenuButtonVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setTooltip(javafx.scene.control.Tooltip)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> tooltip(javafx.scene.control.Tooltip value) {
        operations.add(obj -> obj.setTooltip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TableView#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableViewBuilder<S> visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getColumns()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TableViewBuilder<S> addColumns(javafx.scene.control.TableColumn<S, ?>... elements) {
        operations.add(obj -> {
            obj.getColumns().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getColumns()} method.
     * 
     * @return builder instance
     */
    public final TableViewBuilder<S> addColumns(java.util.Collection<? extends javafx.scene.control.TableColumn<S, ?>> col) {
        operations.add(obj -> {
            obj.getColumns().addAll(col);
        });
        return this;
    }


    /**
     * Create an instance of the builder, then call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getColumns()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public static <S> TableViewBuilder<S> withColumns(javafx.scene.control.TableColumn<S, ?>... elements) {
        TableViewBuilder<S> builder = new TableViewBuilder<S>();
        return builder.addColumns(elements);
    }

    /**
     * Create an instance of the builder, then call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getColumns()} method.
     * 
     * @return builder instance
     */
    public static <S> TableViewBuilder<S> withColumns(java.util.Collection<? extends javafx.scene.control.TableColumn<S, ?>> col) {
        TableViewBuilder<S> builder = new TableViewBuilder<S>();
        return builder.addColumns(col);
    }


    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getItems()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TableViewBuilder<S> addItems(S... elements) {
        operations.add(obj -> {
            obj.getItems().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getItems()} method.
     * 
     * @return builder instance
     */
    public final TableViewBuilder<S> addItems(java.util.Collection<? extends S> col) {
        operations.add(obj -> {
            obj.getItems().addAll(col);
        });
        return this;
    }


    /**
     * Create an instance of the builder, then call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getItems()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public static <S> TableViewBuilder<S> withItems(S... elements) {
        TableViewBuilder<S> builder = new TableViewBuilder<S>();
        return builder.addItems(elements);
    }

    /**
     * Create an instance of the builder, then call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getItems()} method.
     * 
     * @return builder instance
     */
    public static <S> TableViewBuilder<S> withItems(java.util.Collection<? extends S> col) {
        TableViewBuilder<S> builder = new TableViewBuilder<S>();
        return builder.addItems(col);
    }


    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getSortOrder()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TableViewBuilder<S> addSortOrder(javafx.scene.control.TableColumn<S, ?>... elements) {
        operations.add(obj -> {
            obj.getSortOrder().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getSortOrder()} method.
     * 
     * @return builder instance
     */
    public final TableViewBuilder<S> addSortOrder(java.util.Collection<? extends javafx.scene.control.TableColumn<S, ?>> col) {
        operations.add(obj -> {
            obj.getSortOrder().addAll(col);
        });
        return this;
    }


    /**
     * Create an instance of the builder, then call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getSortOrder()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public static <S> TableViewBuilder<S> withSortOrder(javafx.scene.control.TableColumn<S, ?>... elements) {
        TableViewBuilder<S> builder = new TableViewBuilder<S>();
        return builder.addSortOrder(elements);
    }

    /**
     * Create an instance of the builder, then call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getSortOrder()} method.
     * 
     * @return builder instance
     */
    public static <S> TableViewBuilder<S> withSortOrder(java.util.Collection<? extends javafx.scene.control.TableColumn<S, ?>> col) {
        TableViewBuilder<S> builder = new TableViewBuilder<S>();
        return builder.addSortOrder(col);
    }


    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TableViewBuilder<S> addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final TableViewBuilder<S> addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getStylesheets()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TableViewBuilder<S> addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getStylesheets()} method.
     * 
     * @return builder instance
     */
    public final TableViewBuilder<S> addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getTransforms()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TableViewBuilder<S> addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getTransforms()} method.
     * 
     * @return builder instance
     */
    public final TableViewBuilder<S> addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getVisibleLeafColumns()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TableViewBuilder<S> addVisibleLeafColumns(javafx.scene.control.TableColumn<S, ?>... elements) {
        operations.add(obj -> {
            obj.getVisibleLeafColumns().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getVisibleLeafColumns()} method.
     * 
     * @return builder instance
     */
    public final TableViewBuilder<S> addVisibleLeafColumns(java.util.Collection<? extends javafx.scene.control.TableColumn<S, ?>> col) {
        operations.add(obj -> {
            obj.getVisibleLeafColumns().addAll(col);
        });
        return this;
    }


    /**
     * Create an instance of the builder, then call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getVisibleLeafColumns()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public static <S> TableViewBuilder<S> withVisibleLeafColumns(javafx.scene.control.TableColumn<S, ?>... elements) {
        TableViewBuilder<S> builder = new TableViewBuilder<S>();
        return builder.addVisibleLeafColumns(elements);
    }

    /**
     * Create an instance of the builder, then call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TableView#getVisibleLeafColumns()} method.
     * 
     * @return builder instance
     */
    public static <S> TableViewBuilder<S> withVisibleLeafColumns(java.util.Collection<? extends javafx.scene.control.TableColumn<S, ?>> col) {
        TableViewBuilder<S> builder = new TableViewBuilder<S>();
        return builder.addVisibleLeafColumns(col);
    }

    
    /**
     * Utility setter to add CSS string for this TableView's contents.
     * For example:
     * <pre>
     * TableViewBuilder builder = TableViewBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();
     * </pre>
     *
     * @param css CSS string
     */
    public TableViewBuilder<S> addStylesheetsText(String css) {
        operations.add(obj -> obj.getStylesheets().addAll("data:text/css;base64," +
                java.util.Base64.getEncoder().encodeToString(css.getBytes())));
        return this;
    }

    public TableViewBuilder<S> bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }


    public TableViewBuilder<S> leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }


    public TableViewBuilder<S> rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }


    public TableViewBuilder<S> topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }


    public TableViewBuilder<S> alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }


    public TableViewBuilder<S> marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }


    public TableViewBuilder<S> marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }


    public TableViewBuilder<S> columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }


    public TableViewBuilder<S> columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }


    public TableViewBuilder<S> constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }


    public TableViewBuilder<S> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }


    public TableViewBuilder<S> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }


    public TableViewBuilder<S> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }


    public TableViewBuilder<S> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }


    public TableViewBuilder<S> fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }


    public TableViewBuilder<S> fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }


    public TableViewBuilder<S> hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }


    public TableViewBuilder<S> hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }


    public TableViewBuilder<S> marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }


    public TableViewBuilder<S> rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }


    public TableViewBuilder<S> rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }


    public TableViewBuilder<S> vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }


    public TableViewBuilder<S> vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }


    public TableViewBuilder<S> hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }


    public TableViewBuilder<S> marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }


    public TableViewBuilder<S> alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }


    public TableViewBuilder<S> marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }


    public TableViewBuilder<S> alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }


    public TableViewBuilder<S> marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }


    public TableViewBuilder<S> marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }


    public TableViewBuilder<S> vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }
    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#backgroundProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#borderProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#cacheShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#centerShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#columnResizePolicyProperty()}.
     * 
     * @return builder instance
     */    
    @SuppressWarnings("rawtypes")
    public TableViewBuilder<S> columnResizePolicyPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.TableView.ResizeFeatures, java.lang.Boolean>>> op) {
        operations.add(obj -> op.accept(obj.columnResizePolicyProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#comparatorProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> comparatorPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<java.util.Comparator<S>>> op) {
        operations.add(obj -> op.accept(obj.comparatorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#contextMenuProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> contextMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.contextMenuProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#editableProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> editablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.editableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#editingCellProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> editingCellPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TablePosition<S, ?>>> op) {
        operations.add(obj -> op.accept(obj.editingCellProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#fixedCellSizeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> fixedCellSizePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.fixedCellSizeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#focusModelProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> focusModelPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.TableView.TableViewFocusModel<S>>> op) {
        operations.add(obj -> op.accept(obj.focusModelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#insetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#itemsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> itemsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.collections.ObservableList<S>>> op) {
        operations.add(obj -> op.accept(obj.itemsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#needsLayoutProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onScrollToColumnProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onScrollToColumnPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.ScrollToEvent<javafx.scene.control.TableColumn<S, ?>>>>> op) {
        operations.add(obj -> op.accept(obj.onScrollToColumnProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onScrollToProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onScrollToPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.ScrollToEvent<java.lang.Integer>>>> op) {
        operations.add(obj -> op.accept(obj.onScrollToProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onSortProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onSortPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.SortEvent<javafx.scene.control.TableView<S>>>>> op) {
        operations.add(obj -> op.accept(obj.onSortProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#opaqueInsetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#paddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#placeholderProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> placeholderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.placeholderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#rowFactoryProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> rowFactoryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.TableView<S>, javafx.scene.control.TableRow<S>>>> op) {
        operations.add(obj -> op.accept(obj.rowFactoryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#scaleShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#selectionModelProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> selectionModelPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.TableView.TableViewSelectionModel<S>>> op) {
        operations.add(obj -> op.accept(obj.selectionModelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#shapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#skinProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> skinPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Skin<?>>> op) {
        operations.add(obj -> op.accept(obj.skinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#snapToPixelProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#sortPolicyProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> sortPolicyPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.TableView<S>, java.lang.Boolean>>> op) {
        operations.add(obj -> op.accept(obj.sortPolicyProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#tableMenuButtonVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> tableMenuButtonVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.tableMenuButtonVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#tooltipProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> tooltipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Tooltip>> op) {
        operations.add(obj -> op.accept(obj.tooltipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewBuilder<S> widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
