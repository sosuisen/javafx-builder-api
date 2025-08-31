
package io.github.sosuisen.jfxbuilder.graphics;


public class DirectionalLightBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.DirectionalLight>> operations = new java.util.ArrayList<>();
    private DirectionalLightBuilder() {}
    

    public static DirectionalLightBuilder create() { return new DirectionalLightBuilder(); }


    
    public static DirectionalLightBuilder create(javafx.scene.paint.Color color) {
        DirectionalLightBuilder builder = new DirectionalLightBuilder();
        builder.constructorArgs = new Object[]{color};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.DirectionalLight build() {
        javafx.scene.DirectionalLight newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.DirectionalLight();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.DirectionalLight> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.DirectionalLight callParameterizedConstructor() {
        javafx.scene.DirectionalLight newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.DirectionalLight.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.DirectionalLight) constructor.newInstance(constructorArgs);
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
    
    public DirectionalLightBuilder apply(java.util.function.Consumer<javafx.scene.DirectionalLight> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setColor(javafx.scene.paint.Color)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder color(javafx.scene.paint.Color value) {
        operations.add(obj -> obj.setColor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setDirection(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder direction(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setDirection(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setLightOn(boolean)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder lightOn(boolean value) {
        operations.add(obj -> obj.setLightOn(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.DirectionalLight#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  DirectionalLightBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    @SafeVarargs
    public final DirectionalLightBuilder addExclusionScope(javafx.scene.Node... elements) {
        operations.add(obj -> {
            obj.getExclusionScope().addAll(elements);
        });
        return this;
    }

    public final DirectionalLightBuilder addExclusionScope(java.util.Collection<? extends javafx.scene.Node> col) {
        operations.add(obj -> {
            obj.getExclusionScope().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public static DirectionalLightBuilder withExclusionScope(javafx.scene.Node... elements) {
        DirectionalLightBuilder builder = new DirectionalLightBuilder();
        return builder.addExclusionScope(elements);
    }

    public static DirectionalLightBuilder withExclusionScope(java.util.Collection<? extends javafx.scene.Node> col) {
        DirectionalLightBuilder builder = new DirectionalLightBuilder();
        return builder.addExclusionScope(col);
    }

    @SafeVarargs
    public final DirectionalLightBuilder addScope(javafx.scene.Node... elements) {
        operations.add(obj -> {
            obj.getScope().addAll(elements);
        });
        return this;
    }

    public final DirectionalLightBuilder addScope(java.util.Collection<? extends javafx.scene.Node> col) {
        operations.add(obj -> {
            obj.getScope().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public static DirectionalLightBuilder withScope(javafx.scene.Node... elements) {
        DirectionalLightBuilder builder = new DirectionalLightBuilder();
        return builder.addScope(elements);
    }

    public static DirectionalLightBuilder withScope(java.util.Collection<? extends javafx.scene.Node> col) {
        DirectionalLightBuilder builder = new DirectionalLightBuilder();
        return builder.addScope(col);
    }

    @SafeVarargs
    public final DirectionalLightBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    public final DirectionalLightBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public final DirectionalLightBuilder addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    public final DirectionalLightBuilder addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }



    public DirectionalLightBuilder bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }


    public DirectionalLightBuilder leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }


    public DirectionalLightBuilder rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }


    public DirectionalLightBuilder topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }


    public DirectionalLightBuilder alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }


    public DirectionalLightBuilder marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }


    public DirectionalLightBuilder marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }


    public DirectionalLightBuilder columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }


    public DirectionalLightBuilder columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }


    public DirectionalLightBuilder constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }


    public DirectionalLightBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }


    public DirectionalLightBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }


    public DirectionalLightBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }


    public DirectionalLightBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }


    public DirectionalLightBuilder fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }


    public DirectionalLightBuilder fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }


    public DirectionalLightBuilder hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }


    public DirectionalLightBuilder hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }


    public DirectionalLightBuilder marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }


    public DirectionalLightBuilder rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }


    public DirectionalLightBuilder rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }


    public DirectionalLightBuilder vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }


    public DirectionalLightBuilder vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }


    public DirectionalLightBuilder hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }


    public DirectionalLightBuilder marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }


    public DirectionalLightBuilder alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }


    public DirectionalLightBuilder marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }


    public DirectionalLightBuilder alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }


    public DirectionalLightBuilder marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }


    public DirectionalLightBuilder marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }


    public DirectionalLightBuilder vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }

    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#colorProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder colorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Color>> op) {
        operations.add(obj -> op.accept(obj.colorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#directionProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder directionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.directionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#lightOnProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder lightOnPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.lightOnProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.DirectionalLight#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public DirectionalLightBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }
}
