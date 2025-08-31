
package io.github.sosuisen.jfxbuilder.controls;


public class TreeTableViewBuilder<S> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.TreeTableView<S>>> operations = new java.util.ArrayList<>();
    private TreeTableViewBuilder() {}
    

    public static <S> TreeTableViewBuilder<S> create() { return new TreeTableViewBuilder<S>(); }


    
    public static <S> TreeTableViewBuilder<S> create(javafx.scene.control.TreeItem<S> root) {
        TreeTableViewBuilder<S> builder = new TreeTableViewBuilder<S>();
        builder.constructorArgs = new Object[]{root};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.control.TreeTableView<S> build() {
        javafx.scene.control.TreeTableView<S> newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.TreeTableView<>();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.TreeTableView<S>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.TreeTableView<S> callParameterizedConstructor() {
        javafx.scene.control.TreeTableView<S> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TreeTableView.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TreeTableView<S>) constructor.newInstance(constructorArgs);
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
    
    public TreeTableViewBuilder<S> apply(java.util.function.Consumer<javafx.scene.control.TreeTableView<S>> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setBackground(javafx.scene.layout.Background)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setBorder(javafx.scene.layout.Border)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setCacheShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setCenterShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setColumnResizePolicy(javafx.util.Callback)}
     * 
     * @return builder instance
     */    
    @SuppressWarnings("rawtypes")
    public  TreeTableViewBuilder<S> columnResizePolicy(javafx.util.Callback<javafx.scene.control.TreeTableView.ResizeFeatures, java.lang.Boolean> callback) {
        operations.add(obj -> obj.setColumnResizePolicy(callback));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setContextMenu(javafx.scene.control.ContextMenu)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> contextMenu(javafx.scene.control.ContextMenu value) {
        operations.add(obj -> obj.setContextMenu(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setEditable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> editable(boolean value) {
        operations.add(obj -> obj.setEditable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setFixedCellSize(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> fixedCellSize(double value) {
        operations.add(obj -> obj.setFixedCellSize(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setFocusModel(javafx.scene.control.TreeTableView$TreeTableViewFocusModel)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> focusModel(javafx.scene.control.TreeTableView.TreeTableViewFocusModel<S> value) {
        operations.add(obj -> obj.setFocusModel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnScrollTo(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onScrollTo(javafx.event.EventHandler<javafx.scene.control.ScrollToEvent<java.lang.Integer>> value) {
        operations.add(obj -> obj.setOnScrollTo(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnScrollToColumn(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onScrollToColumn(javafx.event.EventHandler<javafx.scene.control.ScrollToEvent<javafx.scene.control.TreeTableColumn<S, ?>>> value) {
        operations.add(obj -> obj.setOnScrollToColumn(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnSort(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onSort(javafx.event.EventHandler<javafx.scene.control.SortEvent<javafx.scene.control.TreeTableView<S>>> value) {
        operations.add(obj -> obj.setOnSort(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setOpaqueInsets(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setPadding(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setPlaceholder(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> placeholder(javafx.scene.Node value) {
        operations.add(obj -> obj.setPlaceholder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setRoot(javafx.scene.control.TreeItem)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> root(javafx.scene.control.TreeItem<S> value) {
        operations.add(obj -> obj.setRoot(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setRowFactory(javafx.util.Callback)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> rowFactory(javafx.util.Callback<javafx.scene.control.TreeTableView<S>, javafx.scene.control.TreeTableRow<S>> value) {
        operations.add(obj -> obj.setRowFactory(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setScaleShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setSelectionModel(javafx.scene.control.TreeTableView$TreeTableViewSelectionModel)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> selectionModel(javafx.scene.control.TreeTableView.TreeTableViewSelectionModel<S> value) {
        operations.add(obj -> obj.setSelectionModel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setShape(javafx.scene.shape.Shape)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setShowRoot(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> showRoot(boolean value) {
        operations.add(obj -> obj.setShowRoot(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setSkin(javafx.scene.control.Skin)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> skin(javafx.scene.control.Skin<?> value) {
        operations.add(obj -> obj.setSkin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setSnapToPixel(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setSortMode(javafx.scene.control.TreeSortMode)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> sortMode(javafx.scene.control.TreeSortMode value) {
        operations.add(obj -> obj.setSortMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setSortPolicy(javafx.util.Callback)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> sortPolicy(javafx.util.Callback<javafx.scene.control.TreeTableView<S>, java.lang.Boolean> callback) {
        operations.add(obj -> obj.setSortPolicy(callback));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setTableMenuButtonVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> tableMenuButtonVisible(boolean value) {
        operations.add(obj -> obj.setTableMenuButtonVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setTooltip(javafx.scene.control.Tooltip)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> tooltip(javafx.scene.control.Tooltip value) {
        operations.add(obj -> obj.setTooltip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setTreeColumn(javafx.scene.control.TreeTableColumn)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> treeColumn(javafx.scene.control.TreeTableColumn<S, ?> value) {
        operations.add(obj -> obj.setTreeColumn(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewBuilder<S> visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    @SafeVarargs
    public final TreeTableViewBuilder<S> addColumns(javafx.scene.control.TreeTableColumn<S, ?>... elements) {
        operations.add(obj -> {
            obj.getColumns().addAll(elements);
        });
        return this;
    }

    public final TreeTableViewBuilder<S> addColumns(java.util.Collection<? extends javafx.scene.control.TreeTableColumn<S, ?>> col) {
        operations.add(obj -> {
            obj.getColumns().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public static <S> TreeTableViewBuilder<S> withColumns(javafx.scene.control.TreeTableColumn<S, ?>... elements) {
        TreeTableViewBuilder<S> builder = new TreeTableViewBuilder<S>();
        return builder.addColumns(elements);
    }

    public static <S> TreeTableViewBuilder<S> withColumns(java.util.Collection<? extends javafx.scene.control.TreeTableColumn<S, ?>> col) {
        TreeTableViewBuilder<S> builder = new TreeTableViewBuilder<S>();
        return builder.addColumns(col);
    }

    @SafeVarargs
    public final TreeTableViewBuilder<S> addSortOrder(javafx.scene.control.TreeTableColumn<S, ?>... elements) {
        operations.add(obj -> {
            obj.getSortOrder().addAll(elements);
        });
        return this;
    }

    public final TreeTableViewBuilder<S> addSortOrder(java.util.Collection<? extends javafx.scene.control.TreeTableColumn<S, ?>> col) {
        operations.add(obj -> {
            obj.getSortOrder().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public static <S> TreeTableViewBuilder<S> withSortOrder(javafx.scene.control.TreeTableColumn<S, ?>... elements) {
        TreeTableViewBuilder<S> builder = new TreeTableViewBuilder<S>();
        return builder.addSortOrder(elements);
    }

    public static <S> TreeTableViewBuilder<S> withSortOrder(java.util.Collection<? extends javafx.scene.control.TreeTableColumn<S, ?>> col) {
        TreeTableViewBuilder<S> builder = new TreeTableViewBuilder<S>();
        return builder.addSortOrder(col);
    }

    @SafeVarargs
    public final TreeTableViewBuilder<S> addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    public final TreeTableViewBuilder<S> addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public final TreeTableViewBuilder<S> addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    public final TreeTableViewBuilder<S> addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public final TreeTableViewBuilder<S> addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    public final TreeTableViewBuilder<S> addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public final TreeTableViewBuilder<S> addVisibleLeafColumns(javafx.scene.control.TreeTableColumn<S, ?>... elements) {
        operations.add(obj -> {
            obj.getVisibleLeafColumns().addAll(elements);
        });
        return this;
    }

    public final TreeTableViewBuilder<S> addVisibleLeafColumns(java.util.Collection<? extends javafx.scene.control.TreeTableColumn<S, ?>> col) {
        operations.add(obj -> {
            obj.getVisibleLeafColumns().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public static <S> TreeTableViewBuilder<S> withVisibleLeafColumns(javafx.scene.control.TreeTableColumn<S, ?>... elements) {
        TreeTableViewBuilder<S> builder = new TreeTableViewBuilder<S>();
        return builder.addVisibleLeafColumns(elements);
    }

    public static <S> TreeTableViewBuilder<S> withVisibleLeafColumns(java.util.Collection<? extends javafx.scene.control.TreeTableColumn<S, ?>> col) {
        TreeTableViewBuilder<S> builder = new TreeTableViewBuilder<S>();
        return builder.addVisibleLeafColumns(col);
    }
    
    /**
     * Utility setter to add CSS string for this TreeTableView's contents.
     * For example:
     * <pre>
     * TreeTableViewBuilder builder = TreeTableViewBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();
     * </pre>
     *
     * @param css CSS string
     */
    public TreeTableViewBuilder<S> addStylesheetsText(String css) {
        operations.add(obj -> obj.getStylesheets().addAll("data:text/css;base64," +
                java.util.Base64.getEncoder().encodeToString(css.getBytes())));
        return this;
    }

    public TreeTableViewBuilder<S> bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }


    public TreeTableViewBuilder<S> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }


    public TreeTableViewBuilder<S> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }


    public TreeTableViewBuilder<S> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }


    public TreeTableViewBuilder<S> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }


    public TreeTableViewBuilder<S> fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }


    public TreeTableViewBuilder<S> vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }

    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#backgroundProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#borderProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#cacheShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#centerShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#columnResizePolicyProperty()}.
     * 
     * @return builder instance
     */    
    @SuppressWarnings("rawtypes")
    public TreeTableViewBuilder<S> columnResizePolicyPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.TreeTableView.ResizeFeatures, java.lang.Boolean>>> op) {
        operations.add(obj -> op.accept(obj.columnResizePolicyProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#comparatorProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> comparatorPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<java.util.Comparator<javafx.scene.control.TreeItem<S>>>> op) {
        operations.add(obj -> op.accept(obj.comparatorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#contextMenuProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> contextMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.contextMenuProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#editableProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> editablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.editableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#editingCellProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> editingCellPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TreeTablePosition<S, ?>>> op) {
        operations.add(obj -> op.accept(obj.editingCellProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#expandedItemCountProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> expandedItemCountPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyIntegerProperty> op) {
        operations.add(obj -> op.accept(obj.expandedItemCountProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#fixedCellSizeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> fixedCellSizePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.fixedCellSizeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#focusModelProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> focusModelPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.TreeTableView.TreeTableViewFocusModel<S>>> op) {
        operations.add(obj -> op.accept(obj.focusModelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#insetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#needsLayoutProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onScrollToColumnProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onScrollToColumnPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.ScrollToEvent<javafx.scene.control.TreeTableColumn<S, ?>>>>> op) {
        operations.add(obj -> op.accept(obj.onScrollToColumnProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onScrollToProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onScrollToPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.ScrollToEvent<java.lang.Integer>>>> op) {
        operations.add(obj -> op.accept(obj.onScrollToProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onSortProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onSortPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.SortEvent<javafx.scene.control.TreeTableView<S>>>>> op) {
        operations.add(obj -> op.accept(obj.onSortProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#opaqueInsetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#paddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#placeholderProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> placeholderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.placeholderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#rootProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> rootPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.TreeItem<S>>> op) {
        operations.add(obj -> op.accept(obj.rootProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#rowFactoryProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> rowFactoryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.TreeTableView<S>, javafx.scene.control.TreeTableRow<S>>>> op) {
        operations.add(obj -> op.accept(obj.rowFactoryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#scaleShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#selectionModelProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> selectionModelPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.TreeTableView.TreeTableViewSelectionModel<S>>> op) {
        operations.add(obj -> op.accept(obj.selectionModelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#shapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#showRootProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> showRootPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.showRootProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#skinProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> skinPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Skin<?>>> op) {
        operations.add(obj -> op.accept(obj.skinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#snapToPixelProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#sortModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> sortModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.TreeSortMode>> op) {
        operations.add(obj -> op.accept(obj.sortModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#sortPolicyProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> sortPolicyPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.TreeTableView<S>, java.lang.Boolean>>> op) {
        operations.add(obj -> op.accept(obj.sortPolicyProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#tableMenuButtonVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> tableMenuButtonVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.tableMenuButtonVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#tooltipProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> tooltipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Tooltip>> op) {
        operations.add(obj -> op.accept(obj.tooltipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#treeColumnProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> treeColumnPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.TreeTableColumn<S, ?>>> op) {
        operations.add(obj -> op.accept(obj.treeColumnProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableView#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableViewBuilder<S> widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
