
package io.github.sosuisen.jfxbuilder.graphics;


public class TextBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.text.Text>> operations = new java.util.ArrayList<>();
    private TextBuilder() {}
    

    public static TextBuilder create() { return new TextBuilder(); }


    
    public static TextBuilder create(double x, double y, java.lang.String text) {
        TextBuilder builder = new TextBuilder();
        builder.constructorArgs = new Object[]{x, y, text};
        return builder;
    }


    
    public static TextBuilder create(java.lang.String text) {
        TextBuilder builder = new TextBuilder();
        builder.constructorArgs = new Object[]{text};
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
     * @return new instance of the {@link javafx.scene.text.Text Text} class
     */
    public javafx.scene.text.Text build() {
        javafx.scene.text.Text newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.text.Text();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.text.Text> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.text.Text callParameterizedConstructor() {
        javafx.scene.text.Text newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.text.Text.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.text.Text) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Text instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(text -> text.setId("Main" + text.getTypeSelector()))
     * }</pre>
     *
     * @return builder instance
     *
     */
    public TextBuilder apply(java.util.function.Consumer<javafx.scene.text.Text> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setBoundsType(javafx.scene.text.TextBoundsType)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder boundsType(javafx.scene.text.TextBoundsType value) {
        operations.add(obj -> obj.setBoundsType(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setCaretBias(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder caretBias(boolean value) {
        operations.add(obj -> obj.setCaretBias(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setCaretPosition(int)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder caretPosition(int value) {
        operations.add(obj -> obj.setCaretPosition(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setFill(javafx.scene.paint.Paint)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder fill(javafx.scene.paint.Paint value) {
        operations.add(obj -> obj.setFill(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setFont(javafx.scene.text.Font)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder font(javafx.scene.text.Font value) {
        operations.add(obj -> obj.setFont(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setFontSmoothingType(javafx.scene.text.FontSmoothingType)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder fontSmoothingType(javafx.scene.text.FontSmoothingType value) {
        operations.add(obj -> obj.setFontSmoothingType(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setLineSpacing(double)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder lineSpacing(double spacing) {
        operations.add(obj -> obj.setLineSpacing(spacing));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setSelectionEnd(int)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder selectionEnd(int value) {
        operations.add(obj -> obj.setSelectionEnd(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setSelectionFill(javafx.scene.paint.Paint)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder selectionFill(javafx.scene.paint.Paint paint) {
        operations.add(obj -> obj.setSelectionFill(paint));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setSelectionStart(int)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder selectionStart(int value) {
        operations.add(obj -> obj.setSelectionStart(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setSmooth(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder smooth(boolean value) {
        operations.add(obj -> obj.setSmooth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setStrikethrough(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder strikethrough(boolean value) {
        operations.add(obj -> obj.setStrikethrough(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setStroke(javafx.scene.paint.Paint)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder stroke(javafx.scene.paint.Paint value) {
        operations.add(obj -> obj.setStroke(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setStrokeDashOffset(double)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder strokeDashOffset(double value) {
        operations.add(obj -> obj.setStrokeDashOffset(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setStrokeLineCap(javafx.scene.shape.StrokeLineCap)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder strokeLineCap(javafx.scene.shape.StrokeLineCap value) {
        operations.add(obj -> obj.setStrokeLineCap(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setStrokeLineJoin(javafx.scene.shape.StrokeLineJoin)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder strokeLineJoin(javafx.scene.shape.StrokeLineJoin value) {
        operations.add(obj -> obj.setStrokeLineJoin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setStrokeMiterLimit(double)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder strokeMiterLimit(double value) {
        operations.add(obj -> obj.setStrokeMiterLimit(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setStrokeType(javafx.scene.shape.StrokeType)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder strokeType(javafx.scene.shape.StrokeType value) {
        operations.add(obj -> obj.setStrokeType(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setStrokeWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder strokeWidth(double value) {
        operations.add(obj -> obj.setStrokeWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setTabSize(int)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder tabSize(int spaces) {
        operations.add(obj -> obj.setTabSize(spaces));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setTextAlignment(javafx.scene.text.TextAlignment)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder textAlignment(javafx.scene.text.TextAlignment value) {
        operations.add(obj -> obj.setTextAlignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setTextOrigin(javafx.geometry.VPos)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder textOrigin(javafx.geometry.VPos value) {
        operations.add(obj -> obj.setTextOrigin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setUnderline(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder underline(boolean value) {
        operations.add(obj -> obj.setUnderline(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setWrappingWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder wrappingWidth(double value) {
        operations.add(obj -> obj.setWrappingWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setX(double)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.text.Text#setY(double)}
     * 
     * @return builder instance
     */    
    
    public  TextBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.text.Text#getStrokeDashArray()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TextBuilder addStrokeDashArray(java.lang.Double... elements) {
        operations.add(obj -> {
            obj.getStrokeDashArray().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.text.Text#getStrokeDashArray()} method.
     * 
     * @return builder instance
     */
    public final TextBuilder addStrokeDashArray(java.util.Collection<? extends java.lang.Double> col) {
        operations.add(obj -> {
            obj.getStrokeDashArray().addAll(col);
        });
        return this;
    }


    /**
     * Create an instance of the builder, then call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.text.Text#getStrokeDashArray()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public static TextBuilder withStrokeDashArray(java.lang.Double... elements) {
        TextBuilder builder = new TextBuilder();
        return builder.addStrokeDashArray(elements);
    }

    /**
     * Create an instance of the builder, then call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.text.Text#getStrokeDashArray()} method.
     * 
     * @return builder instance
     */
    public static TextBuilder withStrokeDashArray(java.util.Collection<? extends java.lang.Double> col) {
        TextBuilder builder = new TextBuilder();
        return builder.addStrokeDashArray(col);
    }


    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.text.Text#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TextBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.text.Text#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final TextBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.text.Text#getTransforms()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TextBuilder addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.text.Text#getTransforms()} method.
     * 
     * @return builder instance
     */
    public final TextBuilder addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }




    public TextBuilder bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }


    public TextBuilder leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }


    public TextBuilder rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }


    public TextBuilder topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }


    public TextBuilder alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }


    public TextBuilder marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }


    public TextBuilder marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }


    public TextBuilder columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }


    public TextBuilder columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }


    public TextBuilder constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }


    public TextBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }


    public TextBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }


    public TextBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }


    public TextBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }


    public TextBuilder fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }


    public TextBuilder fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }


    public TextBuilder hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }


    public TextBuilder hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }


    public TextBuilder marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }


    public TextBuilder rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }


    public TextBuilder rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }


    public TextBuilder vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }


    public TextBuilder vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }


    public TextBuilder hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }


    public TextBuilder marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }


    public TextBuilder alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }


    public TextBuilder marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }


    public TextBuilder alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }


    public TextBuilder marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }


    public TextBuilder marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }


    public TextBuilder vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }
    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#baselineOffsetProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder baselineOffsetPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.baselineOffsetProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#boundsTypeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder boundsTypePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.TextBoundsType>> op) {
        operations.add(obj -> op.accept(obj.boundsTypeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#caretBiasProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder caretBiasPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.caretBiasProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#caretPositionProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder caretPositionPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.caretPositionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#caretShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder caretShapePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.shape.PathElement[]>> op) {
        operations.add(obj -> op.accept(obj.caretShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#fillProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder fillPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Paint>> op) {
        operations.add(obj -> op.accept(obj.fillProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#fontProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder fontPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.Font>> op) {
        operations.add(obj -> op.accept(obj.fontProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#fontSmoothingTypeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder fontSmoothingTypePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.FontSmoothingType>> op) {
        operations.add(obj -> op.accept(obj.fontSmoothingTypeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#lineSpacingProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder lineSpacingPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.lineSpacingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#selectionEndProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder selectionEndPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.selectionEndProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#selectionFillProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder selectionFillPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Paint>> op) {
        operations.add(obj -> op.accept(obj.selectionFillProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#selectionShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder selectionShapePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.shape.PathElement[]>> op) {
        operations.add(obj -> op.accept(obj.selectionShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#selectionStartProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder selectionStartPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.selectionStartProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#smoothProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder smoothPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.smoothProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#strikethroughProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder strikethroughPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.strikethroughProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#strokeDashOffsetProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder strokeDashOffsetPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.strokeDashOffsetProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#strokeLineCapProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder strokeLineCapPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.StrokeLineCap>> op) {
        operations.add(obj -> op.accept(obj.strokeLineCapProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#strokeLineJoinProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder strokeLineJoinPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.StrokeLineJoin>> op) {
        operations.add(obj -> op.accept(obj.strokeLineJoinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#strokeMiterLimitProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder strokeMiterLimitPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.strokeMiterLimitProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#strokeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder strokePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Paint>> op) {
        operations.add(obj -> op.accept(obj.strokeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#strokeTypeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder strokeTypePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.StrokeType>> op) {
        operations.add(obj -> op.accept(obj.strokeTypeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#strokeWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder strokeWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.strokeWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#tabSizeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder tabSizePropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.tabSizeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#textAlignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder textAlignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.TextAlignment>> op) {
        operations.add(obj -> op.accept(obj.textAlignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#textOriginProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder textOriginPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.VPos>> op) {
        operations.add(obj -> op.accept(obj.textOriginProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#textProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#underlineProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder underlinePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.underlineProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#wrappingWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder wrappingWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.wrappingWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#xProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.text.Text#yProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
