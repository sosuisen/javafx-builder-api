
package io.github.sosuisen.jfxbuilder.controls;


public class RadioButtonBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.RadioButton>> operations = new java.util.ArrayList<>();
    private RadioButtonBuilder() {}
    

    public static RadioButtonBuilder create() { return new RadioButtonBuilder(); }


    
    public static RadioButtonBuilder create(java.lang.String text) {
        RadioButtonBuilder builder = new RadioButtonBuilder();
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
     * @return new instance of the {@link javafx.scene.control.RadioButton RadioButton} class
     */
    public javafx.scene.control.RadioButton build() {
        javafx.scene.control.RadioButton newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.RadioButton();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.RadioButton> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.RadioButton callParameterizedConstructor() {
        javafx.scene.control.RadioButton newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.RadioButton.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.RadioButton) constructor.newInstance(constructorArgs);
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
     * Applies a function to the RadioButton instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(radioButton -> radioButton.setId("Main" + radioButton.getTypeSelector()))
     * }</pre>
     *
     * @return builder instance
     *
     */
    public RadioButtonBuilder apply(java.util.function.Consumer<javafx.scene.control.RadioButton> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setAlignment(javafx.geometry.Pos)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder alignment(javafx.geometry.Pos value) {
        operations.add(obj -> obj.setAlignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setBackground(javafx.scene.layout.Background)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setBorder(javafx.scene.layout.Border)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setCacheShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setCenterShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setContentDisplay(javafx.scene.control.ContentDisplay)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder contentDisplay(javafx.scene.control.ContentDisplay value) {
        operations.add(obj -> obj.setContentDisplay(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setContextMenu(javafx.scene.control.ContextMenu)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder contextMenu(javafx.scene.control.ContextMenu value) {
        operations.add(obj -> obj.setContextMenu(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setEllipsisString(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder ellipsisString(java.lang.String value) {
        operations.add(obj -> obj.setEllipsisString(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setFont(javafx.scene.text.Font)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder font(javafx.scene.text.Font value) {
        operations.add(obj -> obj.setFont(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setGraphic(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setGraphicTextGap(double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder graphicTextGap(double value) {
        operations.add(obj -> obj.setGraphicTextGap(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setLineSpacing(double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder lineSpacing(double value) {
        operations.add(obj -> obj.setLineSpacing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setMnemonicParsing(boolean)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder mnemonicParsing(boolean value) {
        operations.add(obj -> obj.setMnemonicParsing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnAction(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onAction(javafx.event.EventHandler<javafx.event.ActionEvent> value) {
        operations.add(obj -> obj.setOnAction(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setOpaqueInsets(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setPadding(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setScaleShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setSelected(boolean)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder selected(boolean value) {
        operations.add(obj -> obj.setSelected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setShape(javafx.scene.shape.Shape)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setSkin(javafx.scene.control.Skin)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder skin(javafx.scene.control.Skin<?> value) {
        operations.add(obj -> obj.setSkin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setSnapToPixel(boolean)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setTextAlignment(javafx.scene.text.TextAlignment)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder textAlignment(javafx.scene.text.TextAlignment value) {
        operations.add(obj -> obj.setTextAlignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setTextFill(javafx.scene.paint.Paint)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder textFill(javafx.scene.paint.Paint value) {
        operations.add(obj -> obj.setTextFill(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setTextOverrun(javafx.scene.control.OverrunStyle)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder textOverrun(javafx.scene.control.OverrunStyle value) {
        operations.add(obj -> obj.setTextOverrun(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setToggleGroup(javafx.scene.control.ToggleGroup)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder toggleGroup(javafx.scene.control.ToggleGroup value) {
        operations.add(obj -> obj.setToggleGroup(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setTooltip(javafx.scene.control.Tooltip)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder tooltip(javafx.scene.control.Tooltip value) {
        operations.add(obj -> obj.setTooltip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setUnderline(boolean)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder underline(boolean value) {
        operations.add(obj -> obj.setUnderline(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.RadioButton#setWrapText(boolean)}
     * 
     * @return builder instance
     */    
    
    public  RadioButtonBuilder wrapText(boolean value) {
        operations.add(obj -> obj.setWrapText(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.RadioButton#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final RadioButtonBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.RadioButton#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final RadioButtonBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.RadioButton#getStylesheets()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final RadioButtonBuilder addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.RadioButton#getStylesheets()} method.
     * 
     * @return builder instance
     */
    public final RadioButtonBuilder addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.RadioButton#getTransforms()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final RadioButtonBuilder addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.RadioButton#getTransforms()} method.
     * 
     * @return builder instance
     */
    public final RadioButtonBuilder addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }


    
    /**
     * Utility setter to add CSS string for this RadioButton's contents.
     * For example:
     * <pre>
     * RadioButtonBuilder builder = RadioButtonBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();
     * </pre>
     *
     * @param css CSS string
     */
    public RadioButtonBuilder addStylesheetsText(String css) {
        operations.add(obj -> obj.getStylesheets().addAll("data:text/css;base64," +
                java.util.Base64.getEncoder().encodeToString(css.getBytes())));
        return this;
    }

    public RadioButtonBuilder bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }


    public RadioButtonBuilder leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }


    public RadioButtonBuilder rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }


    public RadioButtonBuilder topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }


    public RadioButtonBuilder alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }


    public RadioButtonBuilder marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }


    public RadioButtonBuilder marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }


    public RadioButtonBuilder columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }


    public RadioButtonBuilder columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }


    public RadioButtonBuilder constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }


    public RadioButtonBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }


    public RadioButtonBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }


    public RadioButtonBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }


    public RadioButtonBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }


    public RadioButtonBuilder fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }


    public RadioButtonBuilder fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }


    public RadioButtonBuilder hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }


    public RadioButtonBuilder hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }


    public RadioButtonBuilder marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }


    public RadioButtonBuilder rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }


    public RadioButtonBuilder rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }


    public RadioButtonBuilder vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }


    public RadioButtonBuilder vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }


    public RadioButtonBuilder hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }


    public RadioButtonBuilder marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }


    public RadioButtonBuilder alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }


    public RadioButtonBuilder marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }


    public RadioButtonBuilder alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }


    public RadioButtonBuilder marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }


    public RadioButtonBuilder marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }


    public RadioButtonBuilder vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }
    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#alignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder alignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Pos>> op) {
        operations.add(obj -> op.accept(obj.alignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#armedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder armedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.armedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#backgroundProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#borderProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#cacheShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#centerShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#contentDisplayProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder contentDisplayPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContentDisplay>> op) {
        operations.add(obj -> op.accept(obj.contentDisplayProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#contextMenuProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder contextMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.contextMenuProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#ellipsisStringProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder ellipsisStringPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.ellipsisStringProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#fontProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder fontPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.Font>> op) {
        operations.add(obj -> op.accept(obj.fontProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#graphicProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#graphicTextGapProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder graphicTextGapPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.graphicTextGapProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#insetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#labelPaddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder labelPaddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.labelPaddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#lineSpacingProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder lineSpacingPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.lineSpacingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#mnemonicParsingProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder mnemonicParsingPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mnemonicParsingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#needsLayoutProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onActionProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onActionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.ActionEvent>>> op) {
        operations.add(obj -> op.accept(obj.onActionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#opaqueInsetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#paddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#scaleShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#selectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder selectedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.selectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#shapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#skinProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder skinPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Skin<?>>> op) {
        operations.add(obj -> op.accept(obj.skinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#snapToPixelProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#textAlignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder textAlignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.TextAlignment>> op) {
        operations.add(obj -> op.accept(obj.textAlignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#textFillProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder textFillPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Paint>> op) {
        operations.add(obj -> op.accept(obj.textFillProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#textOverrunProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder textOverrunPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.OverrunStyle>> op) {
        operations.add(obj -> op.accept(obj.textOverrunProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#textProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#textTruncatedProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder textTruncatedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.textTruncatedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#toggleGroupProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder toggleGroupPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ToggleGroup>> op) {
        operations.add(obj -> op.accept(obj.toggleGroupProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#tooltipProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder tooltipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Tooltip>> op) {
        operations.add(obj -> op.accept(obj.tooltipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#underlineProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder underlinePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.underlineProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.RadioButton#wrapTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public RadioButtonBuilder wrapTextPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.wrapTextProperty()));
        return this;
    }
}
