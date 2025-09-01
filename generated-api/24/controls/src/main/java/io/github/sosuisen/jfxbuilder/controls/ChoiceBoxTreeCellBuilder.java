
package io.github.sosuisen.jfxbuilder.controls;


public class ChoiceBoxTreeCellBuilder<T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.cell.ChoiceBoxTreeCell<T>>> operations = new java.util.ArrayList<>();
    private ChoiceBoxTreeCellBuilder() {}
    

    public static <T> ChoiceBoxTreeCellBuilder<T> create() { return new ChoiceBoxTreeCellBuilder<T>(); }


    @SafeVarargs
    public static <T> ChoiceBoxTreeCellBuilder<T> create(T... items) {
        ChoiceBoxTreeCellBuilder<T> builder = new ChoiceBoxTreeCellBuilder<T>();
        builder.constructorArgs = new Object[]{items};
        return builder;
    }


    
    public static <T> ChoiceBoxTreeCellBuilder<T> create(javafx.collections.ObservableList<T> items) {
        ChoiceBoxTreeCellBuilder<T> builder = new ChoiceBoxTreeCellBuilder<T>();
        builder.constructorArgs = new Object[]{items};
        return builder;
    }


    @SafeVarargs
    public static <T> ChoiceBoxTreeCellBuilder<T> create(javafx.util.StringConverter<T> converter, T... items) {
        ChoiceBoxTreeCellBuilder<T> builder = new ChoiceBoxTreeCellBuilder<T>();
        builder.constructorArgs = new Object[]{converter, items};
        return builder;
    }


    
    public static <T> ChoiceBoxTreeCellBuilder<T> create(javafx.util.StringConverter<T> converter, javafx.collections.ObservableList<T> items) {
        ChoiceBoxTreeCellBuilder<T> builder = new ChoiceBoxTreeCellBuilder<T>();
        builder.constructorArgs = new Object[]{converter, items};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.control.cell.ChoiceBoxTreeCell<T> build() {
        javafx.scene.control.cell.ChoiceBoxTreeCell<T> newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.cell.ChoiceBoxTreeCell<>();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.cell.ChoiceBoxTreeCell<T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.cell.ChoiceBoxTreeCell<T> callParameterizedConstructor() {
        javafx.scene.control.cell.ChoiceBoxTreeCell<T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.cell.ChoiceBoxTreeCell.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.cell.ChoiceBoxTreeCell<T>) constructor.newInstance(constructorArgs);
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
    
    public ChoiceBoxTreeCellBuilder<T> apply(java.util.function.Consumer<javafx.scene.control.cell.ChoiceBoxTreeCell<T>> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setAlignment(javafx.geometry.Pos)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> alignment(javafx.geometry.Pos value) {
        operations.add(obj -> obj.setAlignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setBackground(javafx.scene.layout.Background)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setBorder(javafx.scene.layout.Border)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setCacheShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setCenterShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setContentDisplay(javafx.scene.control.ContentDisplay)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> contentDisplay(javafx.scene.control.ContentDisplay value) {
        operations.add(obj -> obj.setContentDisplay(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setContextMenu(javafx.scene.control.ContextMenu)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> contextMenu(javafx.scene.control.ContextMenu value) {
        operations.add(obj -> obj.setContextMenu(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setConverter(javafx.util.StringConverter)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> converter(javafx.util.StringConverter<T> value) {
        operations.add(obj -> obj.setConverter(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setDisclosureNode(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> disclosureNode(javafx.scene.Node value) {
        operations.add(obj -> obj.setDisclosureNode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setEditable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> editable(boolean value) {
        operations.add(obj -> obj.setEditable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setEllipsisString(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> ellipsisString(java.lang.String value) {
        operations.add(obj -> obj.setEllipsisString(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setFont(javafx.scene.text.Font)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> font(javafx.scene.text.Font value) {
        operations.add(obj -> obj.setFont(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setGraphic(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setGraphicTextGap(double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> graphicTextGap(double value) {
        operations.add(obj -> obj.setGraphicTextGap(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setItem(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> item(T value) {
        operations.add(obj -> obj.setItem(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setLineSpacing(double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> lineSpacing(double value) {
        operations.add(obj -> obj.setLineSpacing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setMnemonicParsing(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> mnemonicParsing(boolean value) {
        operations.add(obj -> obj.setMnemonicParsing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setOpaqueInsets(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setPadding(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setScaleShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setShape(javafx.scene.shape.Shape)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setSkin(javafx.scene.control.Skin)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> skin(javafx.scene.control.Skin<?> value) {
        operations.add(obj -> obj.setSkin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setSnapToPixel(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setTextAlignment(javafx.scene.text.TextAlignment)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> textAlignment(javafx.scene.text.TextAlignment value) {
        operations.add(obj -> obj.setTextAlignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setTextFill(javafx.scene.paint.Paint)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> textFill(javafx.scene.paint.Paint value) {
        operations.add(obj -> obj.setTextFill(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setTextOverrun(javafx.scene.control.OverrunStyle)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> textOverrun(javafx.scene.control.OverrunStyle value) {
        operations.add(obj -> obj.setTextOverrun(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setTooltip(javafx.scene.control.Tooltip)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> tooltip(javafx.scene.control.Tooltip value) {
        operations.add(obj -> obj.setTooltip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setUnderline(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> underline(boolean value) {
        operations.add(obj -> obj.setUnderline(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ChoiceBoxTreeCell#setWrapText(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ChoiceBoxTreeCellBuilder<T> wrapText(boolean value) {
        operations.add(obj -> obj.setWrapText(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#getItems()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public final ChoiceBoxTreeCellBuilder<T> addItems(T... elements) {
        operations.add(obj -> {
            obj.getItems().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#getItems()} method.
     * 
     * @return builder instance
     */     
    public final ChoiceBoxTreeCellBuilder<T> addItems(java.util.Collection<? extends T> col) {
        operations.add(obj -> {
            obj.getItems().addAll(col);
        });
        return this;
    }


    /**
     * Create an instance of the builder, then call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#getItems()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public static <T> ChoiceBoxTreeCellBuilder<T> withItems(T... elements) {
        ChoiceBoxTreeCellBuilder<T> builder = new ChoiceBoxTreeCellBuilder<T>();
        return builder.addItems(elements);
    }

    /**
     * Create an instance of the builder, then call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#getItems()} method.
     * 
     * @return builder instance
     */     
    public static <T> ChoiceBoxTreeCellBuilder<T> withItems(java.util.Collection<? extends T> col) {
        ChoiceBoxTreeCellBuilder<T> builder = new ChoiceBoxTreeCellBuilder<T>();
        return builder.addItems(col);
    }


    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#getStyleClass()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public final ChoiceBoxTreeCellBuilder<T> addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#getStyleClass()} method.
     * 
     * @return builder instance
     */     
    public final ChoiceBoxTreeCellBuilder<T> addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#getStylesheets()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public final ChoiceBoxTreeCellBuilder<T> addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#getStylesheets()} method.
     * 
     * @return builder instance
     */     
    public final ChoiceBoxTreeCellBuilder<T> addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#getTransforms()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public final ChoiceBoxTreeCellBuilder<T> addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#getTransforms()} method.
     * 
     * @return builder instance
     */     
    public final ChoiceBoxTreeCellBuilder<T> addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }


    
    /**
     * Utility setter to add CSS string for this ChoiceBoxTreeCell's contents.
     * For example:
     * <pre>
     * ChoiceBoxTreeCellBuilder builder = ChoiceBoxTreeCellBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();
     * </pre>
     *
     * @param css CSS string
     */
    public ChoiceBoxTreeCellBuilder<T> addStylesheetsText(String css) {
        operations.add(obj -> obj.getStylesheets().addAll("data:text/css;base64," +
                java.util.Base64.getEncoder().encodeToString(css.getBytes())));
        return this;
    }

    public ChoiceBoxTreeCellBuilder<T> bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }


    public ChoiceBoxTreeCellBuilder<T> vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }

    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#alignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> alignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Pos>> op) {
        operations.add(obj -> op.accept(obj.alignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#backgroundProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#borderProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#cacheShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#centerShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#contentDisplayProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> contentDisplayPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContentDisplay>> op) {
        operations.add(obj -> op.accept(obj.contentDisplayProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#contextMenuProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> contextMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.contextMenuProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#converterProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> converterPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.StringConverter<T>>> op) {
        operations.add(obj -> op.accept(obj.converterProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#disclosureNodeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> disclosureNodePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.disclosureNodeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#editableProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> editablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.editableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#editingProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> editingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.editingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#ellipsisStringProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> ellipsisStringPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.ellipsisStringProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#emptyProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> emptyPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.emptyProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#fontProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> fontPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.Font>> op) {
        operations.add(obj -> op.accept(obj.fontProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#graphicProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#graphicTextGapProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> graphicTextGapPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.graphicTextGapProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#indexProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> indexPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyIntegerProperty> op) {
        operations.add(obj -> op.accept(obj.indexProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#insetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#itemProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> itemPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<T>> op) {
        operations.add(obj -> op.accept(obj.itemProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#labelPaddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> labelPaddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.labelPaddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#lineSpacingProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> lineSpacingPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.lineSpacingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#mnemonicParsingProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> mnemonicParsingPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mnemonicParsingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#needsLayoutProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#opaqueInsetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#paddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#scaleShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#selectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> selectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.selectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#shapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#skinProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> skinPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Skin<?>>> op) {
        operations.add(obj -> op.accept(obj.skinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#snapToPixelProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#textAlignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> textAlignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.TextAlignment>> op) {
        operations.add(obj -> op.accept(obj.textAlignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#textFillProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> textFillPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Paint>> op) {
        operations.add(obj -> op.accept(obj.textFillProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#textOverrunProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> textOverrunPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.OverrunStyle>> op) {
        operations.add(obj -> op.accept(obj.textOverrunProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#textProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#textTruncatedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> textTruncatedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.textTruncatedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#tooltipProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> tooltipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Tooltip>> op) {
        operations.add(obj -> op.accept(obj.tooltipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#treeItemProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> treeItemPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TreeItem<T>>> op) {
        operations.add(obj -> op.accept(obj.treeItemProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#treeViewProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> treeViewPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TreeView<T>>> op) {
        operations.add(obj -> op.accept(obj.treeViewProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#underlineProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> underlinePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.underlineProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ChoiceBoxTreeCell#wrapTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public ChoiceBoxTreeCellBuilder<T> wrapTextPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.wrapTextProperty()));
        return this;
    }
}
