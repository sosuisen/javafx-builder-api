
package io.github.sosuisen.jfxbuilder.controls;


public class TreeTableCellBuilder<S, T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.TreeTableCell<S, T>>> operations = new java.util.ArrayList<>();
    private TreeTableCellBuilder() {}
    

    public static <S, T> TreeTableCellBuilder<S, T> create() { return new TreeTableCellBuilder<S, T>(); }

    private Object[] constructorArgs;

    /**
     * This method builds and returns an instance of the original class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the build() method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.TreeTableCell TreeTableCell} class
     */
    public javafx.scene.control.TreeTableCell<S, T> build() {
        javafx.scene.control.TreeTableCell<S, T> newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.TreeTableCell<>();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.TreeTableCell<S, T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.TreeTableCell<S, T> callParameterizedConstructor() {
        javafx.scene.control.TreeTableCell<S, T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TreeTableCell.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TreeTableCell<S, T>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the TreeTableCell instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(treeTableCell -> treeTableCell.setId("Main" + treeTableCell.getTypeSelector()))
     * }</pre>
     *
     * @return builder instance
     *
     */
    public TreeTableCellBuilder<S, T> apply(java.util.function.Consumer<javafx.scene.control.TreeTableCell<S, T>> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setAlignment(javafx.geometry.Pos)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> alignment(javafx.geometry.Pos value) {
        operations.add(obj -> obj.setAlignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setBackground(javafx.scene.layout.Background)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setBorder(javafx.scene.layout.Border)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setCacheShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setCenterShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setContentDisplay(javafx.scene.control.ContentDisplay)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> contentDisplay(javafx.scene.control.ContentDisplay value) {
        operations.add(obj -> obj.setContentDisplay(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setContextMenu(javafx.scene.control.ContextMenu)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> contextMenu(javafx.scene.control.ContextMenu value) {
        operations.add(obj -> obj.setContextMenu(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setEditable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> editable(boolean value) {
        operations.add(obj -> obj.setEditable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setEllipsisString(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> ellipsisString(java.lang.String value) {
        operations.add(obj -> obj.setEllipsisString(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setFont(javafx.scene.text.Font)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> font(javafx.scene.text.Font value) {
        operations.add(obj -> obj.setFont(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setGraphic(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setGraphicTextGap(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> graphicTextGap(double value) {
        operations.add(obj -> obj.setGraphicTextGap(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setItem(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> item(T value) {
        operations.add(obj -> obj.setItem(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setLineSpacing(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> lineSpacing(double value) {
        operations.add(obj -> obj.setLineSpacing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setMnemonicParsing(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> mnemonicParsing(boolean value) {
        operations.add(obj -> obj.setMnemonicParsing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setOpaqueInsets(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setPadding(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setScaleShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setShape(javafx.scene.shape.Shape)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setSkin(javafx.scene.control.Skin)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> skin(javafx.scene.control.Skin<?> value) {
        operations.add(obj -> obj.setSkin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setSnapToPixel(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setTextAlignment(javafx.scene.text.TextAlignment)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> textAlignment(javafx.scene.text.TextAlignment value) {
        operations.add(obj -> obj.setTextAlignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setTextFill(javafx.scene.paint.Paint)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> textFill(javafx.scene.paint.Paint value) {
        operations.add(obj -> obj.setTextFill(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setTextOverrun(javafx.scene.control.OverrunStyle)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> textOverrun(javafx.scene.control.OverrunStyle value) {
        operations.add(obj -> obj.setTextOverrun(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setTooltip(javafx.scene.control.Tooltip)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> tooltip(javafx.scene.control.Tooltip value) {
        operations.add(obj -> obj.setTooltip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setUnderline(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> underline(boolean value) {
        operations.add(obj -> obj.setUnderline(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableCell#setWrapText(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableCellBuilder<S, T> wrapText(boolean value) {
        operations.add(obj -> obj.setWrapText(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TreeTableCell#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TreeTableCellBuilder<S, T> addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TreeTableCell#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final TreeTableCellBuilder<S, T> addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TreeTableCell#getStylesheets()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TreeTableCellBuilder<S, T> addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TreeTableCell#getStylesheets()} method.
     * 
     * @return builder instance
     */
    public final TreeTableCellBuilder<S, T> addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TreeTableCell#getTransforms()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TreeTableCellBuilder<S, T> addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.TreeTableCell#getTransforms()} method.
     * 
     * @return builder instance
     */
    public final TreeTableCellBuilder<S, T> addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }


    
    /**
     * Utility setter to add CSS string for this TreeTableCell's contents.
     * For example:
     * <pre>
     * TreeTableCellBuilder builder = TreeTableCellBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();
     * </pre>
     *
     * @param css CSS string
     */
    public TreeTableCellBuilder<S, T> addStylesheetsText(String css) {
        operations.add(obj -> obj.getStylesheets().addAll("data:text/css;base64," +
                java.util.Base64.getEncoder().encodeToString(css.getBytes())));
        return this;
    }

    public TreeTableCellBuilder<S, T> bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }


    public TreeTableCellBuilder<S, T> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }


    public TreeTableCellBuilder<S, T> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }


    public TreeTableCellBuilder<S, T> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }


    public TreeTableCellBuilder<S, T> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }


    public TreeTableCellBuilder<S, T> fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }


    public TreeTableCellBuilder<S, T> vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }
    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#alignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> alignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Pos>> op) {
        operations.add(obj -> op.accept(obj.alignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#backgroundProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#borderProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#cacheShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#centerShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#contentDisplayProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> contentDisplayPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContentDisplay>> op) {
        operations.add(obj -> op.accept(obj.contentDisplayProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#contextMenuProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> contextMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.contextMenuProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#editableProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> editablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.editableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#editingProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> editingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.editingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#ellipsisStringProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> ellipsisStringPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.ellipsisStringProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#emptyProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> emptyPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.emptyProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#fontProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> fontPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.Font>> op) {
        operations.add(obj -> op.accept(obj.fontProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#graphicProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#graphicTextGapProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> graphicTextGapPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.graphicTextGapProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#indexProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> indexPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyIntegerProperty> op) {
        operations.add(obj -> op.accept(obj.indexProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#insetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#itemProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> itemPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<T>> op) {
        operations.add(obj -> op.accept(obj.itemProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#labelPaddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> labelPaddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.labelPaddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#lineSpacingProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> lineSpacingPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.lineSpacingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#mnemonicParsingProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> mnemonicParsingPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mnemonicParsingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#needsLayoutProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#opaqueInsetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#paddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#scaleShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#selectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> selectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.selectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#shapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#skinProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> skinPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Skin<?>>> op) {
        operations.add(obj -> op.accept(obj.skinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#snapToPixelProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#tableColumnProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> tableColumnPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TreeTableColumn<S, T>>> op) {
        operations.add(obj -> op.accept(obj.tableColumnProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#tableRowProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> tableRowPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TreeTableRow<S>>> op) {
        operations.add(obj -> op.accept(obj.tableRowProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#textAlignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> textAlignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.TextAlignment>> op) {
        operations.add(obj -> op.accept(obj.textAlignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#textFillProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> textFillPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Paint>> op) {
        operations.add(obj -> op.accept(obj.textFillProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#textOverrunProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> textOverrunPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.OverrunStyle>> op) {
        operations.add(obj -> op.accept(obj.textOverrunProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#textProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#textTruncatedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> textTruncatedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.textTruncatedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#tooltipProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> tooltipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Tooltip>> op) {
        operations.add(obj -> op.accept(obj.tooltipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#treeTableViewProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> treeTableViewPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TreeTableView<S>>> op) {
        operations.add(obj -> op.accept(obj.treeTableViewProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#underlineProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> underlinePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.underlineProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TreeTableCell#wrapTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeTableCellBuilder<S, T> wrapTextPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.wrapTextProperty()));
        return this;
    }
}
