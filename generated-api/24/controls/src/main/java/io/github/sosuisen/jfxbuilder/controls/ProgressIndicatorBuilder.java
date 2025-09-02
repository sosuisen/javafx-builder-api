
package io.github.sosuisen.jfxbuilder.controls;


public class ProgressIndicatorBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.ProgressIndicator>> operations = new java.util.ArrayList<>();
    private ProgressIndicatorBuilder() {}
    

    public static ProgressIndicatorBuilder create() { return new ProgressIndicatorBuilder(); }


    
    public static ProgressIndicatorBuilder create(double progress) {
        ProgressIndicatorBuilder builder = new ProgressIndicatorBuilder();
        builder.constructorArgs = new Object[]{progress};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * This method builds and returns an instance of the original class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the build() method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.ProgressIndicator ProgressIndicator} class
     */
    public javafx.scene.control.ProgressIndicator build() {
        javafx.scene.control.ProgressIndicator newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.ProgressIndicator();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.ProgressIndicator> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.ProgressIndicator callParameterizedConstructor() {
        javafx.scene.control.ProgressIndicator newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.ProgressIndicator.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.ProgressIndicator) constructor.newInstance(constructorArgs);
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
     * Applies a function to the ProgressIndicator instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(progressIndicator -> progressIndicator.setId("Main" + progressIndicator.getTypeSelector()))
     * }</pre>
     *
     * @return builder instance
     *
     */
    public ProgressIndicatorBuilder apply(java.util.function.Consumer<javafx.scene.control.ProgressIndicator> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setBackground(javafx.scene.layout.Background)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setBorder(javafx.scene.layout.Border)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setCacheShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setCenterShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setContextMenu(javafx.scene.control.ContextMenu)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder contextMenu(javafx.scene.control.ContextMenu value) {
        operations.add(obj -> obj.setContextMenu(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setOpaqueInsets(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setPadding(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setProgress(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder progress(double value) {
        operations.add(obj -> obj.setProgress(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setScaleShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setShape(javafx.scene.shape.Shape)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setSkin(javafx.scene.control.Skin)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder skin(javafx.scene.control.Skin<?> value) {
        operations.add(obj -> obj.setSkin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setSnapToPixel(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setTooltip(javafx.scene.control.Tooltip)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder tooltip(javafx.scene.control.Tooltip value) {
        operations.add(obj -> obj.setTooltip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ProgressIndicator#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ProgressIndicatorBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ProgressIndicator#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final ProgressIndicatorBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ProgressIndicator#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final ProgressIndicatorBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ProgressIndicator#getStylesheets()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final ProgressIndicatorBuilder addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ProgressIndicator#getStylesheets()} method.
     * 
     * @return builder instance
     */
    public final ProgressIndicatorBuilder addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ProgressIndicator#getTransforms()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final ProgressIndicatorBuilder addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ProgressIndicator#getTransforms()} method.
     * 
     * @return builder instance
     */
    public final ProgressIndicatorBuilder addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }


    
    /**
     * Utility setter to add CSS string for this ProgressIndicator's contents.
     * For example:
     * <pre>
     * ProgressIndicatorBuilder builder = ProgressIndicatorBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();
     * </pre>
     *
     * @param css CSS string
     */
    public ProgressIndicatorBuilder addStylesheetsText(String css) {
        operations.add(obj -> obj.getStylesheets().addAll("data:text/css;base64," +
                java.util.Base64.getEncoder().encodeToString(css.getBytes())));
        return this;
    }

    public ProgressIndicatorBuilder bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }


    public ProgressIndicatorBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }


    public ProgressIndicatorBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }


    public ProgressIndicatorBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }


    public ProgressIndicatorBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }


    public ProgressIndicatorBuilder fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }


    public ProgressIndicatorBuilder vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }
    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#backgroundProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#borderProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#cacheShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#centerShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#contextMenuProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder contextMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.contextMenuProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#indeterminateProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder indeterminatePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.indeterminateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#insetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#needsLayoutProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#opaqueInsetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#paddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#progressProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder progressPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.progressProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#scaleShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#shapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#skinProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder skinPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Skin<?>>> op) {
        operations.add(obj -> op.accept(obj.skinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#snapToPixelProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#tooltipProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder tooltipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Tooltip>> op) {
        operations.add(obj -> op.accept(obj.tooltipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ProgressIndicator#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ProgressIndicatorBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
