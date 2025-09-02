
package io.github.sosuisen.jfxbuilder.graphics;


public class BoxBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.shape.Box>> operations = new java.util.ArrayList<>();
    private BoxBuilder() {}
    

    public static BoxBuilder create() { return new BoxBuilder(); }


    
    public static BoxBuilder create(double width, double height, double depth) {
        BoxBuilder builder = new BoxBuilder();
        builder.constructorArgs = new Object[]{width, height, depth};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.shape.Box build() {
        javafx.scene.shape.Box newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.shape.Box();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.shape.Box> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.shape.Box callParameterizedConstructor() {
        javafx.scene.shape.Box newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.shape.Box.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.shape.Box) constructor.newInstance(constructorArgs);
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
    
    public BoxBuilder apply(java.util.function.Consumer<javafx.scene.shape.Box> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setCullFace(javafx.scene.shape.CullFace)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder cullFace(javafx.scene.shape.CullFace value) {
        operations.add(obj -> obj.setCullFace(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setDepth(double)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder depth(double value) {
        operations.add(obj -> obj.setDepth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setDrawMode(javafx.scene.shape.DrawMode)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder drawMode(javafx.scene.shape.DrawMode value) {
        operations.add(obj -> obj.setDrawMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder height(double value) {
        operations.add(obj -> obj.setHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setMaterial(javafx.scene.paint.Material)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder material(javafx.scene.paint.Material value) {
        operations.add(obj -> obj.setMaterial(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.Box#setWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  BoxBuilder width(double value) {
        operations.add(obj -> obj.setWidth(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.shape.Box#getStyleClass()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public final BoxBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.shape.Box#getStyleClass()} method.
     * 
     * @return builder instance
     */     
    public final BoxBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.shape.Box#getTransforms()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public final BoxBuilder addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.shape.Box#getTransforms()} method.
     * 
     * @return builder instance
     */     
    public final BoxBuilder addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }




    public BoxBuilder bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }


    public BoxBuilder leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }


    public BoxBuilder rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }


    public BoxBuilder topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }


    public BoxBuilder alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }


    public BoxBuilder marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }


    public BoxBuilder marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }


    public BoxBuilder columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }


    public BoxBuilder columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }


    public BoxBuilder constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }


    public BoxBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }


    public BoxBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }


    public BoxBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }


    public BoxBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }


    public BoxBuilder fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }


    public BoxBuilder fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }


    public BoxBuilder hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }


    public BoxBuilder hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }


    public BoxBuilder marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }


    public BoxBuilder rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }


    public BoxBuilder rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }


    public BoxBuilder vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }


    public BoxBuilder vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }


    public BoxBuilder hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }


    public BoxBuilder marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }


    public BoxBuilder alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }


    public BoxBuilder marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }


    public BoxBuilder alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }


    public BoxBuilder marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }


    public BoxBuilder marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }


    public BoxBuilder vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }
    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#cullFaceProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder cullFacePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.CullFace>> op) {
        operations.add(obj -> op.accept(obj.cullFaceProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#depthProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder depthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.depthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#drawModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder drawModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.DrawMode>> op) {
        operations.add(obj -> op.accept(obj.drawModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#materialProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder materialPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Material>> op) {
        operations.add(obj -> op.accept(obj.materialProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.Box#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public BoxBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
