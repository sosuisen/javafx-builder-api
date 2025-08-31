
package io.github.sosuisen.jfxbuilder.graphics;


public class BorderPaneBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.layout.BorderPane>> operations = new java.util.ArrayList<>();
    private BorderPaneBuilder() {}
    

    public static BorderPaneBuilder create() { return new BorderPaneBuilder(); }


    
    public static BorderPaneBuilder create(javafx.scene.Node center) {
        BorderPaneBuilder builder = new BorderPaneBuilder();
        builder.constructorArgs = new Object[]{center};
        return builder;
    }


    
    public static BorderPaneBuilder create(javafx.scene.Node center, javafx.scene.Node top, javafx.scene.Node right, javafx.scene.Node bottom, javafx.scene.Node left) {
        BorderPaneBuilder builder = new BorderPaneBuilder();
        builder.constructorArgs = new Object[]{center, top, right, bottom, left};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.layout.BorderPane build() {
        javafx.scene.layout.BorderPane newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.layout.BorderPane();

        } else {
            newInstance = callParameterizedConstructor();
        }


        newInstance.getStyleClass().add(".border-pane");

        for (java.util.function.Consumer<javafx.scene.layout.BorderPane> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.layout.BorderPane callParameterizedConstructor() {
        javafx.scene.layout.BorderPane newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.layout.BorderPane.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.layout.BorderPane) constructor.newInstance(constructorArgs);
                    break;
                }
            }
            if (newInstance == null) {
                throw new RuntimeException("No suitable constructor found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance", e);
        }

        newInstance.getStyleClass().add(".border-pane");

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
    
    public BorderPaneBuilder apply(java.util.function.Consumer<javafx.scene.layout.BorderPane> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setBackground(javafx.scene.layout.Background)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setBorder(javafx.scene.layout.Border)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setBottom(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder bottom(javafx.scene.Node value) {
        operations.add(obj -> obj.setBottom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setCacheShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setCenter(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder center(javafx.scene.Node value) {
        operations.add(obj -> obj.setCenter(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setCenterShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setLeft(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder left(javafx.scene.Node value) {
        operations.add(obj -> obj.setLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setOpaqueInsets(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setPadding(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setRight(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder right(javafx.scene.Node value) {
        operations.add(obj -> obj.setRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setScaleShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setShape(javafx.scene.shape.Shape)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setSnapToPixel(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setTop(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder top(javafx.scene.Node value) {
        operations.add(obj -> obj.setTop(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.BorderPane#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BorderPaneBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    @SafeVarargs
    public final BorderPaneBuilder addChildren(javafx.scene.Node... elements) {
        operations.add(obj -> {
            obj.getChildren().addAll(elements);
        });
        return this;
    }

    public final BorderPaneBuilder addChildren(java.util.Collection<? extends javafx.scene.Node> col) {
        operations.add(obj -> {
            obj.getChildren().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public static BorderPaneBuilder withChildren(javafx.scene.Node... elements) {
        BorderPaneBuilder builder = new BorderPaneBuilder();
        return builder.addChildren(elements);
    }

    public static BorderPaneBuilder withChildren(java.util.Collection<? extends javafx.scene.Node> col) {
        BorderPaneBuilder builder = new BorderPaneBuilder();
        return builder.addChildren(col);
    }

    @SafeVarargs
    public final BorderPaneBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    public final BorderPaneBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public final BorderPaneBuilder addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    public final BorderPaneBuilder addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public final BorderPaneBuilder addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    public final BorderPaneBuilder addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }

    
    /**
     * Utility setter to add CSS string for this BorderPane's contents.
     * For example:
     * <pre>
     * BorderPaneBuilder builder = BorderPaneBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();
     * </pre>
     *
     * @param css CSS string
     */
    public BorderPaneBuilder addStylesheetsText(String css) {
        operations.add(obj -> obj.getStylesheets().addAll("data:text/css;base64," +
                java.util.Base64.getEncoder().encodeToString(css.getBytes())));
        return this;
    }

    public BorderPaneBuilder bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }


    public BorderPaneBuilder leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }


    public BorderPaneBuilder rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }


    public BorderPaneBuilder topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }


    public BorderPaneBuilder alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }


    public BorderPaneBuilder marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }


    public BorderPaneBuilder marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }


    public BorderPaneBuilder columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }


    public BorderPaneBuilder columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }


    public BorderPaneBuilder constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }


    public BorderPaneBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }


    public BorderPaneBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }


    public BorderPaneBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }


    public BorderPaneBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }


    public BorderPaneBuilder fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }


    public BorderPaneBuilder fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }


    public BorderPaneBuilder hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }


    public BorderPaneBuilder hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }


    public BorderPaneBuilder marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }


    public BorderPaneBuilder rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }


    public BorderPaneBuilder rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }


    public BorderPaneBuilder vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }


    public BorderPaneBuilder vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }


    public BorderPaneBuilder hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }


    public BorderPaneBuilder marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }


    public BorderPaneBuilder alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }


    public BorderPaneBuilder marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }


    public BorderPaneBuilder alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }


    public BorderPaneBuilder marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }


    public BorderPaneBuilder marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }


    public BorderPaneBuilder vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }

    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#backgroundProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#borderProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#bottomProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder bottomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.bottomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#cacheShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#centerProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder centerPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.centerProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#centerShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#insetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#leftProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder leftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.leftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#needsLayoutProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#opaqueInsetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#paddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#rightProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder rightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.rightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#scaleShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#shapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#snapToPixelProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#topProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder topPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.topProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.BorderPane#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public BorderPaneBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }

    public static BorderPaneBuilder withCenter(javafx.scene.Node node) {
        BorderPaneBuilder builder = new BorderPaneBuilder();
        builder.operations.add(obj -> obj.setCenter(node));
        return builder;
    }

    public static BorderPaneBuilder withTop(javafx.scene.Node node) {
        BorderPaneBuilder builder = new BorderPaneBuilder();
        builder.operations.add(obj -> obj.setTop(node));
        return builder;
    }

    public static BorderPaneBuilder withLeft(javafx.scene.Node node) {
        BorderPaneBuilder builder = new BorderPaneBuilder();
        builder.operations.add(obj -> obj.setLeft(node));
        return builder;
    }

    public static BorderPaneBuilder withBottom(javafx.scene.Node node) {
        BorderPaneBuilder builder = new BorderPaneBuilder();
        builder.operations.add(obj -> obj.setBottom(node));
        return builder;
    }

    public static BorderPaneBuilder withRight(javafx.scene.Node node) {
        BorderPaneBuilder builder = new BorderPaneBuilder();
        builder.operations.add(obj -> obj.setRight(node));
        return builder;
    }


}
