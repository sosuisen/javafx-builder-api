
package io.github.sosuisen.jfxbuilder.controls;


public class TitledPaneBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.TitledPane>> operations = new java.util.ArrayList<>();
    private TitledPaneBuilder() {}
    

    public static TitledPaneBuilder create() { return new TitledPaneBuilder(); }


    
    public static TitledPaneBuilder create(java.lang.String title, javafx.scene.Node content) {
        TitledPaneBuilder builder = new TitledPaneBuilder();
        builder.constructorArgs = new Object[]{title, content};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.control.TitledPane build() {
        javafx.scene.control.TitledPane newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.TitledPane();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.TitledPane> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.TitledPane callParameterizedConstructor() {
        javafx.scene.control.TitledPane newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TitledPane.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TitledPane) constructor.newInstance(constructorArgs);
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
    
    public TitledPaneBuilder apply(java.util.function.Consumer<javafx.scene.control.TitledPane> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setAlignment(javafx.geometry.Pos)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder alignment(javafx.geometry.Pos value) {
        operations.add(obj -> obj.setAlignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setAnimated(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder animated(boolean value) {
        operations.add(obj -> obj.setAnimated(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setBackground(javafx.scene.layout.Background)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setBorder(javafx.scene.layout.Border)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setCacheShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setCenterShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setCollapsible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder collapsible(boolean value) {
        operations.add(obj -> obj.setCollapsible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setContent(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder content(javafx.scene.Node value) {
        operations.add(obj -> obj.setContent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setContentDisplay(javafx.scene.control.ContentDisplay)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder contentDisplay(javafx.scene.control.ContentDisplay value) {
        operations.add(obj -> obj.setContentDisplay(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setContextMenu(javafx.scene.control.ContextMenu)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder contextMenu(javafx.scene.control.ContextMenu value) {
        operations.add(obj -> obj.setContextMenu(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setEllipsisString(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder ellipsisString(java.lang.String value) {
        operations.add(obj -> obj.setEllipsisString(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setExpanded(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder expanded(boolean value) {
        operations.add(obj -> obj.setExpanded(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setFont(javafx.scene.text.Font)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder font(javafx.scene.text.Font value) {
        operations.add(obj -> obj.setFont(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setGraphic(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setGraphicTextGap(double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder graphicTextGap(double value) {
        operations.add(obj -> obj.setGraphicTextGap(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setLineSpacing(double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder lineSpacing(double value) {
        operations.add(obj -> obj.setLineSpacing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setMnemonicParsing(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder mnemonicParsing(boolean value) {
        operations.add(obj -> obj.setMnemonicParsing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setOpaqueInsets(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setPadding(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setScaleShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setShape(javafx.scene.shape.Shape)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setSkin(javafx.scene.control.Skin)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder skin(javafx.scene.control.Skin<?> value) {
        operations.add(obj -> obj.setSkin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setSnapToPixel(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setTextAlignment(javafx.scene.text.TextAlignment)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder textAlignment(javafx.scene.text.TextAlignment value) {
        operations.add(obj -> obj.setTextAlignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setTextFill(javafx.scene.paint.Paint)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder textFill(javafx.scene.paint.Paint value) {
        operations.add(obj -> obj.setTextFill(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setTextOverrun(javafx.scene.control.OverrunStyle)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder textOverrun(javafx.scene.control.OverrunStyle value) {
        operations.add(obj -> obj.setTextOverrun(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setTooltip(javafx.scene.control.Tooltip)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder tooltip(javafx.scene.control.Tooltip value) {
        operations.add(obj -> obj.setTooltip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setUnderline(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder underline(boolean value) {
        operations.add(obj -> obj.setUnderline(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TitledPane#setWrapText(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TitledPaneBuilder wrapText(boolean value) {
        operations.add(obj -> obj.setWrapText(value));
        return this;
    }
    @SafeVarargs
    public final TitledPaneBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    public final TitledPaneBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public final TitledPaneBuilder addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    public final TitledPaneBuilder addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public final TitledPaneBuilder addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    public final TitledPaneBuilder addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }

    
    /**
     * Utility setter to add CSS string for this TitledPane's contents.
     * For example:
     * <pre>
     * TitledPaneBuilder builder = TitledPaneBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();
     * </pre>
     *
     * @param css CSS string
     */
    public TitledPaneBuilder addStylesheetsText(String css) {
        operations.add(obj -> obj.getStylesheets().addAll("data:text/css;base64," +
                java.util.Base64.getEncoder().encodeToString(css.getBytes())));
        return this;
    }

    public TitledPaneBuilder bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }


    public TitledPaneBuilder leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }


    public TitledPaneBuilder rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }


    public TitledPaneBuilder topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }


    public TitledPaneBuilder alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }


    public TitledPaneBuilder marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }


    public TitledPaneBuilder marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }


    public TitledPaneBuilder columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }


    public TitledPaneBuilder columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }


    public TitledPaneBuilder constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }


    public TitledPaneBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }


    public TitledPaneBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }


    public TitledPaneBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }


    public TitledPaneBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }


    public TitledPaneBuilder fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }


    public TitledPaneBuilder fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }


    public TitledPaneBuilder hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }


    public TitledPaneBuilder hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }


    public TitledPaneBuilder marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }


    public TitledPaneBuilder rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }


    public TitledPaneBuilder rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }


    public TitledPaneBuilder vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }


    public TitledPaneBuilder vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }


    public TitledPaneBuilder hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }


    public TitledPaneBuilder marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }


    public TitledPaneBuilder alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }


    public TitledPaneBuilder marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }


    public TitledPaneBuilder alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }


    public TitledPaneBuilder marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }


    public TitledPaneBuilder marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }


    public TitledPaneBuilder vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }

    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#alignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder alignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Pos>> op) {
        operations.add(obj -> op.accept(obj.alignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#animatedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder animatedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.animatedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#backgroundProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#borderProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#cacheShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#centerShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#collapsibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder collapsiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.collapsibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#contentDisplayProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder contentDisplayPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContentDisplay>> op) {
        operations.add(obj -> op.accept(obj.contentDisplayProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#contentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder contentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.contentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#contextMenuProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder contextMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.contextMenuProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#ellipsisStringProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder ellipsisStringPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.ellipsisStringProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#expandedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder expandedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.expandedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#fontProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder fontPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.Font>> op) {
        operations.add(obj -> op.accept(obj.fontProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#graphicProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#graphicTextGapProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder graphicTextGapPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.graphicTextGapProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#insetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#labelPaddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder labelPaddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.labelPaddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#lineSpacingProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder lineSpacingPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.lineSpacingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#mnemonicParsingProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder mnemonicParsingPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mnemonicParsingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#needsLayoutProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#opaqueInsetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#paddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#scaleShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#shapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#skinProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder skinPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Skin<?>>> op) {
        operations.add(obj -> op.accept(obj.skinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#snapToPixelProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#textAlignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder textAlignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.TextAlignment>> op) {
        operations.add(obj -> op.accept(obj.textAlignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#textFillProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder textFillPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Paint>> op) {
        operations.add(obj -> op.accept(obj.textFillProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#textOverrunProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder textOverrunPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.OverrunStyle>> op) {
        operations.add(obj -> op.accept(obj.textOverrunProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#textProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#textTruncatedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder textTruncatedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.textTruncatedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#tooltipProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder tooltipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Tooltip>> op) {
        operations.add(obj -> op.accept(obj.tooltipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#underlineProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder underlinePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.underlineProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TitledPane#wrapTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public TitledPaneBuilder wrapTextPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.wrapTextProperty()));
        return this;
    }
}
