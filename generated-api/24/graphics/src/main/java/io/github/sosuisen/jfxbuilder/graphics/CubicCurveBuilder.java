
package io.github.sosuisen.jfxbuilder.graphics;


public class CubicCurveBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.shape.CubicCurve>> operations = new java.util.ArrayList<>();
    private CubicCurveBuilder() {}
    

    public static CubicCurveBuilder create() { return new CubicCurveBuilder(); }


    
    public static CubicCurveBuilder create(double startX, double startY, double controlX1, double controlY1, double controlX2, double controlY2, double endX, double endY) {
        CubicCurveBuilder builder = new CubicCurveBuilder();
        builder.constructorArgs = new Object[]{startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.shape.CubicCurve build() {
        javafx.scene.shape.CubicCurve newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.shape.CubicCurve();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.shape.CubicCurve> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.shape.CubicCurve callParameterizedConstructor() {
        javafx.scene.shape.CubicCurve newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.shape.CubicCurve.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.shape.CubicCurve) constructor.newInstance(constructorArgs);
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
    
    public CubicCurveBuilder apply(java.util.function.Consumer<javafx.scene.shape.CubicCurve> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setControlX1(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder controlX1(double value) {
        operations.add(obj -> obj.setControlX1(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setControlX2(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder controlX2(double value) {
        operations.add(obj -> obj.setControlX2(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setControlY1(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder controlY1(double value) {
        operations.add(obj -> obj.setControlY1(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setControlY2(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder controlY2(double value) {
        operations.add(obj -> obj.setControlY2(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setEndX(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder endX(double value) {
        operations.add(obj -> obj.setEndX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setEndY(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder endY(double value) {
        operations.add(obj -> obj.setEndY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setFill(javafx.scene.paint.Paint)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder fill(javafx.scene.paint.Paint value) {
        operations.add(obj -> obj.setFill(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setSmooth(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder smooth(boolean value) {
        operations.add(obj -> obj.setSmooth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setStartX(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder startX(double value) {
        operations.add(obj -> obj.setStartX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setStartY(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder startY(double value) {
        operations.add(obj -> obj.setStartY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setStroke(javafx.scene.paint.Paint)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder stroke(javafx.scene.paint.Paint value) {
        operations.add(obj -> obj.setStroke(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setStrokeDashOffset(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder strokeDashOffset(double value) {
        operations.add(obj -> obj.setStrokeDashOffset(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setStrokeLineCap(javafx.scene.shape.StrokeLineCap)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder strokeLineCap(javafx.scene.shape.StrokeLineCap value) {
        operations.add(obj -> obj.setStrokeLineCap(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setStrokeLineJoin(javafx.scene.shape.StrokeLineJoin)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder strokeLineJoin(javafx.scene.shape.StrokeLineJoin value) {
        operations.add(obj -> obj.setStrokeLineJoin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setStrokeMiterLimit(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder strokeMiterLimit(double value) {
        operations.add(obj -> obj.setStrokeMiterLimit(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setStrokeType(javafx.scene.shape.StrokeType)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder strokeType(javafx.scene.shape.StrokeType value) {
        operations.add(obj -> obj.setStrokeType(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setStrokeWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder strokeWidth(double value) {
        operations.add(obj -> obj.setStrokeWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.CubicCurve#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CubicCurveBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    @SafeVarargs
    public final CubicCurveBuilder addStrokeDashArray(java.lang.Double... elements) {
        operations.add(obj -> {
            obj.getStrokeDashArray().addAll(elements);
        });
        return this;
    }

    public final CubicCurveBuilder addStrokeDashArray(java.util.Collection<? extends java.lang.Double> col) {
        operations.add(obj -> {
            obj.getStrokeDashArray().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public static CubicCurveBuilder withStrokeDashArray(java.lang.Double... elements) {
        CubicCurveBuilder builder = new CubicCurveBuilder();
        return builder.addStrokeDashArray(elements);
    }

    public static CubicCurveBuilder withStrokeDashArray(java.util.Collection<? extends java.lang.Double> col) {
        CubicCurveBuilder builder = new CubicCurveBuilder();
        return builder.addStrokeDashArray(col);
    }

    @SafeVarargs
    public final CubicCurveBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    public final CubicCurveBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public final CubicCurveBuilder addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    public final CubicCurveBuilder addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }



    public CubicCurveBuilder bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }


    public CubicCurveBuilder leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }


    public CubicCurveBuilder rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }


    public CubicCurveBuilder topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }


    public CubicCurveBuilder alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }


    public CubicCurveBuilder marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }


    public CubicCurveBuilder marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }


    public CubicCurveBuilder columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }


    public CubicCurveBuilder columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }


    public CubicCurveBuilder constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }


    public CubicCurveBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }


    public CubicCurveBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }


    public CubicCurveBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }


    public CubicCurveBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }


    public CubicCurveBuilder fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }


    public CubicCurveBuilder fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }


    public CubicCurveBuilder hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }


    public CubicCurveBuilder hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }


    public CubicCurveBuilder marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }


    public CubicCurveBuilder rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }


    public CubicCurveBuilder rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }


    public CubicCurveBuilder vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }


    public CubicCurveBuilder vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }


    public CubicCurveBuilder hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }


    public CubicCurveBuilder marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }


    public CubicCurveBuilder alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }


    public CubicCurveBuilder marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }


    public CubicCurveBuilder alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }


    public CubicCurveBuilder marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }


    public CubicCurveBuilder marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }


    public CubicCurveBuilder vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }

    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#controlX1Property()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder controlX1PropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.controlX1Property()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#controlX2Property()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder controlX2PropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.controlX2Property()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#controlY1Property()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder controlY1PropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.controlY1Property()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#controlY2Property()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder controlY2PropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.controlY2Property()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#endXProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder endXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.endXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#endYProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder endYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.endYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#fillProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder fillPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Paint>> op) {
        operations.add(obj -> op.accept(obj.fillProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#smoothProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder smoothPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.smoothProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#startXProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder startXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.startXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#startYProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder startYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.startYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#strokeDashOffsetProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder strokeDashOffsetPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.strokeDashOffsetProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#strokeLineCapProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder strokeLineCapPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.StrokeLineCap>> op) {
        operations.add(obj -> op.accept(obj.strokeLineCapProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#strokeLineJoinProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder strokeLineJoinPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.StrokeLineJoin>> op) {
        operations.add(obj -> op.accept(obj.strokeLineJoinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#strokeMiterLimitProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder strokeMiterLimitPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.strokeMiterLimitProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#strokeProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder strokePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Paint>> op) {
        operations.add(obj -> op.accept(obj.strokeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#strokeTypeProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder strokeTypePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.StrokeType>> op) {
        operations.add(obj -> op.accept(obj.strokeTypeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#strokeWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder strokeWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.strokeWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.CubicCurve#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public CubicCurveBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }
}
