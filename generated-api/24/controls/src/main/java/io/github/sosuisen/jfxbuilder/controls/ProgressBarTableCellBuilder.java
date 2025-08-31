
package io.github.sosuisen.jfxbuilder.controls;


public class ProgressBarTableCellBuilder<S> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.cell.ProgressBarTableCell<S>>> operations = new java.util.ArrayList<>();
    private ProgressBarTableCellBuilder() {}
    

    public static <S> ProgressBarTableCellBuilder<S> create() { return new ProgressBarTableCellBuilder<S>(); }

    private Object[] constructorArgs;

    public javafx.scene.control.cell.ProgressBarTableCell<S> build() {
        javafx.scene.control.cell.ProgressBarTableCell<S> newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.cell.ProgressBarTableCell<>();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.cell.ProgressBarTableCell<S>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.cell.ProgressBarTableCell<S> callParameterizedConstructor() {
        javafx.scene.control.cell.ProgressBarTableCell<S> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.cell.ProgressBarTableCell.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.cell.ProgressBarTableCell<S>) constructor.newInstance(constructorArgs);
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
    
    public ProgressBarTableCellBuilder<S> apply(java.util.function.Consumer<javafx.scene.control.cell.ProgressBarTableCell<S>> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setAlignment(javafx.geometry.Pos)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> alignment(javafx.geometry.Pos value) {
        operations.add(obj -> obj.setAlignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setBackground(javafx.scene.layout.Background)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setBorder(javafx.scene.layout.Border)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setCacheShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setCenterShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setContentDisplay(javafx.scene.control.ContentDisplay)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> contentDisplay(javafx.scene.control.ContentDisplay value) {
        operations.add(obj -> obj.setContentDisplay(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setContextMenu(javafx.scene.control.ContextMenu)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> contextMenu(javafx.scene.control.ContextMenu value) {
        operations.add(obj -> obj.setContextMenu(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setEditable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> editable(boolean value) {
        operations.add(obj -> obj.setEditable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setEllipsisString(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> ellipsisString(java.lang.String value) {
        operations.add(obj -> obj.setEllipsisString(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setFont(javafx.scene.text.Font)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> font(javafx.scene.text.Font value) {
        operations.add(obj -> obj.setFont(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setGraphic(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setGraphicTextGap(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> graphicTextGap(double value) {
        operations.add(obj -> obj.setGraphicTextGap(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setItem(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> item(Double value) {
        operations.add(obj -> obj.setItem(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setLineSpacing(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> lineSpacing(double value) {
        operations.add(obj -> obj.setLineSpacing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setMnemonicParsing(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> mnemonicParsing(boolean value) {
        operations.add(obj -> obj.setMnemonicParsing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setOpaqueInsets(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setPadding(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setScaleShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setShape(javafx.scene.shape.Shape)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setSkin(javafx.scene.control.Skin)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> skin(javafx.scene.control.Skin<?> value) {
        operations.add(obj -> obj.setSkin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setSnapToPixel(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setTextAlignment(javafx.scene.text.TextAlignment)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> textAlignment(javafx.scene.text.TextAlignment value) {
        operations.add(obj -> obj.setTextAlignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setTextFill(javafx.scene.paint.Paint)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> textFill(javafx.scene.paint.Paint value) {
        operations.add(obj -> obj.setTextFill(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setTextOverrun(javafx.scene.control.OverrunStyle)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> textOverrun(javafx.scene.control.OverrunStyle value) {
        operations.add(obj -> obj.setTextOverrun(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setTooltip(javafx.scene.control.Tooltip)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> tooltip(javafx.scene.control.Tooltip value) {
        operations.add(obj -> obj.setTooltip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setUnderline(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> underline(boolean value) {
        operations.add(obj -> obj.setUnderline(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ProgressBarTableCell#setWrapText(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressBarTableCellBuilder<S> wrapText(boolean value) {
        operations.add(obj -> obj.setWrapText(value));
        return this;
    }
    @SafeVarargs
    public final ProgressBarTableCellBuilder<S> addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    public final ProgressBarTableCellBuilder<S> addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public final ProgressBarTableCellBuilder<S> addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    public final ProgressBarTableCellBuilder<S> addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public final ProgressBarTableCellBuilder<S> addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    public final ProgressBarTableCellBuilder<S> addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }

    
    /**
     * Utility setter to add CSS string for this ProgressBarTableCell's contents.
     * For example:
     * <pre>
     * ProgressBarTableCellBuilder builder = ProgressBarTableCellBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();
     * </pre>
     *
     * @param css CSS string
     */
    public ProgressBarTableCellBuilder<S> addStylesheetsText(String css) {
        operations.add(obj -> obj.getStylesheets().addAll("data:text/css;base64," +
                java.util.Base64.getEncoder().encodeToString(css.getBytes())));
        return this;
    }

    public ProgressBarTableCellBuilder<S> bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }


    public ProgressBarTableCellBuilder<S> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }


    public ProgressBarTableCellBuilder<S> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }


    public ProgressBarTableCellBuilder<S> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }


    public ProgressBarTableCellBuilder<S> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }


    public ProgressBarTableCellBuilder<S> fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }


    public ProgressBarTableCellBuilder<S> vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }

    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#alignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> alignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Pos>> op) {
        operations.add(obj -> op.accept(obj.alignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#backgroundProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#borderProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#cacheShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#centerShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#contentDisplayProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> contentDisplayPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContentDisplay>> op) {
        operations.add(obj -> op.accept(obj.contentDisplayProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#contextMenuProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> contextMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.contextMenuProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#editableProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> editablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.editableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#editingProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> editingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.editingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#ellipsisStringProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> ellipsisStringPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.ellipsisStringProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#emptyProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> emptyPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.emptyProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#fontProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> fontPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.Font>> op) {
        operations.add(obj -> op.accept(obj.fontProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#graphicProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#graphicTextGapProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> graphicTextGapPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.graphicTextGapProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#indexProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> indexPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyIntegerProperty> op) {
        operations.add(obj -> op.accept(obj.indexProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#insetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#itemProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> itemPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<Double>> op) {
        operations.add(obj -> op.accept(obj.itemProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#labelPaddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> labelPaddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.labelPaddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#lineSpacingProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> lineSpacingPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.lineSpacingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#mnemonicParsingProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> mnemonicParsingPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mnemonicParsingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#needsLayoutProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#opaqueInsetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#paddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#scaleShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#selectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> selectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.selectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#shapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#skinProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> skinPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Skin<?>>> op) {
        operations.add(obj -> op.accept(obj.skinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#snapToPixelProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#tableColumnProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> tableColumnPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TableColumn<S, Double>>> op) {
        operations.add(obj -> op.accept(obj.tableColumnProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#tableRowProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> tableRowPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TableRow<S>>> op) {
        operations.add(obj -> op.accept(obj.tableRowProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#tableViewProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> tableViewPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TableView<S>>> op) {
        operations.add(obj -> op.accept(obj.tableViewProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#textAlignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> textAlignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.TextAlignment>> op) {
        operations.add(obj -> op.accept(obj.textAlignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#textFillProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> textFillPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Paint>> op) {
        operations.add(obj -> op.accept(obj.textFillProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#textOverrunProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> textOverrunPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.OverrunStyle>> op) {
        operations.add(obj -> op.accept(obj.textOverrunProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#textProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#textTruncatedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> textTruncatedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.textTruncatedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#tooltipProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> tooltipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Tooltip>> op) {
        operations.add(obj -> op.accept(obj.tooltipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#underlineProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> underlinePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.underlineProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ProgressBarTableCell#wrapTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressBarTableCellBuilder<S> wrapTextPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.wrapTextProperty()));
        return this;
    }
}
