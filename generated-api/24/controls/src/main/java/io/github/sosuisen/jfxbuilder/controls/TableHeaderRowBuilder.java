
package io.github.sosuisen.jfxbuilder.controls;

@SuppressWarnings("rawtypes")
public class TableHeaderRowBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.skin.TableHeaderRow>> operations = new java.util.ArrayList<>();
    private TableHeaderRowBuilder() {}
    

    
    public static TableHeaderRowBuilder create(javafx.scene.control.skin.TableViewSkinBase skin) {
        TableHeaderRowBuilder builder = new TableHeaderRowBuilder();
        builder.constructorArgs = new Object[]{skin};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.control.skin.TableHeaderRow build() {
        javafx.scene.control.skin.TableHeaderRow newInstance;

        newInstance = callParameterizedConstructor();


        newInstance.getStyleClass().add(".table-header-row");

        for (java.util.function.Consumer<javafx.scene.control.skin.TableHeaderRow> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.skin.TableHeaderRow callParameterizedConstructor() {
        javafx.scene.control.skin.TableHeaderRow newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.skin.TableHeaderRow.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.skin.TableHeaderRow) constructor.newInstance(constructorArgs);
                    break;
                }
            }
            if (newInstance == null) {
                throw new RuntimeException("No suitable constructor found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance", e);
        }

        newInstance.getStyleClass().add(".table-header-row");

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
    
    public TableHeaderRowBuilder apply(java.util.function.Consumer<javafx.scene.control.skin.TableHeaderRow> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setAlignment(javafx.geometry.Pos)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder alignment(javafx.geometry.Pos value) {
        operations.add(obj -> obj.setAlignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setBackground(javafx.scene.layout.Background)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setBorder(javafx.scene.layout.Border)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setCacheShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setCenterShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setOpaqueInsets(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setPadding(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setReordering(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder reordering(boolean value) {
        operations.add(obj -> obj.setReordering(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setScaleShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setShape(javafx.scene.shape.Shape)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setSnapToPixel(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TableHeaderRow#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TableHeaderRowBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    @SafeVarargs
    public final TableHeaderRowBuilder addChildren(javafx.scene.Node... elements) {
        operations.add(obj -> {
            obj.getChildren().addAll(elements);
        });
        return this;
    }

    public final TableHeaderRowBuilder addChildren(java.util.Collection<? extends javafx.scene.Node> col) {
        operations.add(obj -> {
            obj.getChildren().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public final TableHeaderRowBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    public final TableHeaderRowBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public final TableHeaderRowBuilder addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    public final TableHeaderRowBuilder addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public final TableHeaderRowBuilder addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    public final TableHeaderRowBuilder addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }

    
    /**
     * Utility setter to add CSS string for this TableHeaderRow's contents.
     * For example:
     * <pre>
     * TableHeaderRowBuilder builder = TableHeaderRowBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();
     * </pre>
     *
     * @param css CSS string
     */
    public TableHeaderRowBuilder addStylesheetsText(String css) {
        operations.add(obj -> obj.getStylesheets().addAll("data:text/css;base64," +
                java.util.Base64.getEncoder().encodeToString(css.getBytes())));
        return this;
    }

    public TableHeaderRowBuilder bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }


    public TableHeaderRowBuilder leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }


    public TableHeaderRowBuilder rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }


    public TableHeaderRowBuilder topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }


    public TableHeaderRowBuilder alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }


    public TableHeaderRowBuilder marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }


    public TableHeaderRowBuilder marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }


    public TableHeaderRowBuilder columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }


    public TableHeaderRowBuilder columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }


    public TableHeaderRowBuilder constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }


    public TableHeaderRowBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }


    public TableHeaderRowBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }


    public TableHeaderRowBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }


    public TableHeaderRowBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }


    public TableHeaderRowBuilder fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }


    public TableHeaderRowBuilder fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }


    public TableHeaderRowBuilder hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }


    public TableHeaderRowBuilder hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }


    public TableHeaderRowBuilder marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }


    public TableHeaderRowBuilder rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }


    public TableHeaderRowBuilder rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }


    public TableHeaderRowBuilder vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }


    public TableHeaderRowBuilder vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }


    public TableHeaderRowBuilder hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }


    public TableHeaderRowBuilder marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }


    public TableHeaderRowBuilder alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }


    public TableHeaderRowBuilder marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }


    public TableHeaderRowBuilder alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }


    public TableHeaderRowBuilder marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }


    public TableHeaderRowBuilder marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }


    public TableHeaderRowBuilder vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }

    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#alignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder alignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Pos>> op) {
        operations.add(obj -> op.accept(obj.alignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#backgroundProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#borderProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#cacheShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#centerShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#insetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#needsLayoutProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#opaqueInsetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#paddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#reorderingProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder reorderingPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.reorderingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#scaleShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#shapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#snapToPixelProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.TableHeaderRow#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableHeaderRowBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
