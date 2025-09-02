
package io.github.sosuisen.jfxbuilder.controls;


public class NumberAxisBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.chart.NumberAxis>> operations = new java.util.ArrayList<>();
    private NumberAxisBuilder() {}
    

    public static NumberAxisBuilder create() { return new NumberAxisBuilder(); }


    
    public static NumberAxisBuilder create(double lowerBound, double upperBound, double tickUnit) {
        NumberAxisBuilder builder = new NumberAxisBuilder();
        builder.constructorArgs = new Object[]{lowerBound, upperBound, tickUnit};
        return builder;
    }


    
    public static NumberAxisBuilder create(java.lang.String axisLabel, double lowerBound, double upperBound, double tickUnit) {
        NumberAxisBuilder builder = new NumberAxisBuilder();
        builder.constructorArgs = new Object[]{axisLabel, lowerBound, upperBound, tickUnit};
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
     * @return new instance of the {@link javafx.scene.chart.NumberAxis NumberAxis} class
     */
    public javafx.scene.chart.NumberAxis build() {
        javafx.scene.chart.NumberAxis newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.chart.NumberAxis();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.chart.NumberAxis> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.chart.NumberAxis callParameterizedConstructor() {
        javafx.scene.chart.NumberAxis newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.chart.NumberAxis.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.chart.NumberAxis) constructor.newInstance(constructorArgs);
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
     * Applies a function to the NumberAxis instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(numberAxis -> numberAxis.setId("Main" + numberAxis.getTypeSelector()))
     * }</pre>
     *
     * @return builder instance
     *
     */
    public NumberAxisBuilder apply(java.util.function.Consumer<javafx.scene.chart.NumberAxis> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setAnimated(boolean)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder animated(boolean value) {
        operations.add(obj -> obj.setAnimated(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setAutoRanging(boolean)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder autoRanging(boolean value) {
        operations.add(obj -> obj.setAutoRanging(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setBackground(javafx.scene.layout.Background)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setBorder(javafx.scene.layout.Border)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setCacheShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setCenterShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setForceZeroInRange(boolean)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder forceZeroInRange(boolean value) {
        operations.add(obj -> obj.setForceZeroInRange(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setLabel(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder label(java.lang.String value) {
        operations.add(obj -> obj.setLabel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setLowerBound(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder lowerBound(double value) {
        operations.add(obj -> obj.setLowerBound(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setMinorTickCount(int)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder minorTickCount(int value) {
        operations.add(obj -> obj.setMinorTickCount(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setMinorTickLength(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder minorTickLength(double value) {
        operations.add(obj -> obj.setMinorTickLength(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setMinorTickVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder minorTickVisible(boolean value) {
        operations.add(obj -> obj.setMinorTickVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setOpaqueInsets(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setPadding(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setScaleShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setShape(javafx.scene.shape.Shape)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setSide(javafx.geometry.Side)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder side(javafx.geometry.Side value) {
        operations.add(obj -> obj.setSide(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setSnapToPixel(boolean)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setTickLabelFill(javafx.scene.paint.Paint)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder tickLabelFill(javafx.scene.paint.Paint value) {
        operations.add(obj -> obj.setTickLabelFill(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setTickLabelFont(javafx.scene.text.Font)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder tickLabelFont(javafx.scene.text.Font value) {
        operations.add(obj -> obj.setTickLabelFont(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setTickLabelFormatter(javafx.util.StringConverter)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder tickLabelFormatter(javafx.util.StringConverter<Number> value) {
        operations.add(obj -> obj.setTickLabelFormatter(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setTickLabelGap(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder tickLabelGap(double value) {
        operations.add(obj -> obj.setTickLabelGap(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setTickLabelRotation(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder tickLabelRotation(double value) {
        operations.add(obj -> obj.setTickLabelRotation(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setTickLabelsVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder tickLabelsVisible(boolean value) {
        operations.add(obj -> obj.setTickLabelsVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setTickLength(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder tickLength(double value) {
        operations.add(obj -> obj.setTickLength(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setTickMarkVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder tickMarkVisible(boolean value) {
        operations.add(obj -> obj.setTickMarkVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setTickUnit(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder tickUnit(double value) {
        operations.add(obj -> obj.setTickUnit(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setUpperBound(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder upperBound(double value) {
        operations.add(obj -> obj.setUpperBound(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.NumberAxis#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  NumberAxisBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.NumberAxis#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final NumberAxisBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.NumberAxis#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final NumberAxisBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.NumberAxis#getStylesheets()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final NumberAxisBuilder addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.NumberAxis#getStylesheets()} method.
     * 
     * @return builder instance
     */
    public final NumberAxisBuilder addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.NumberAxis#getTickMarks()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final NumberAxisBuilder addTickMarks(javafx.scene.chart.Axis.TickMark<Number>... elements) {
        operations.add(obj -> {
            obj.getTickMarks().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.NumberAxis#getTickMarks()} method.
     * 
     * @return builder instance
     */
    public final NumberAxisBuilder addTickMarks(java.util.Collection<? extends javafx.scene.chart.Axis.TickMark<Number>> col) {
        operations.add(obj -> {
            obj.getTickMarks().addAll(col);
        });
        return this;
    }


    /**
     * Create an instance of the builder, then call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.NumberAxis#getTickMarks()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public static NumberAxisBuilder withTickMarks(javafx.scene.chart.Axis.TickMark<Number>... elements) {
        NumberAxisBuilder builder = new NumberAxisBuilder();
        return builder.addTickMarks(elements);
    }

    /**
     * Create an instance of the builder, then call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.NumberAxis#getTickMarks()} method.
     * 
     * @return builder instance
     */
    public static NumberAxisBuilder withTickMarks(java.util.Collection<? extends javafx.scene.chart.Axis.TickMark<Number>> col) {
        NumberAxisBuilder builder = new NumberAxisBuilder();
        return builder.addTickMarks(col);
    }


    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.NumberAxis#getTransforms()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final NumberAxisBuilder addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.NumberAxis#getTransforms()} method.
     * 
     * @return builder instance
     */
    public final NumberAxisBuilder addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }


    
    /**
     * Utility setter to add CSS string for this NumberAxis's contents.
     * For example:
     * <pre>
     * NumberAxisBuilder builder = NumberAxisBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();
     * </pre>
     *
     * @param css CSS string
     */
    public NumberAxisBuilder addStylesheetsText(String css) {
        operations.add(obj -> obj.getStylesheets().addAll("data:text/css;base64," +
                java.util.Base64.getEncoder().encodeToString(css.getBytes())));
        return this;
    }

    public NumberAxisBuilder bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }


    public NumberAxisBuilder leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }


    public NumberAxisBuilder rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }


    public NumberAxisBuilder topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }


    public NumberAxisBuilder alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }


    public NumberAxisBuilder marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }


    public NumberAxisBuilder marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }


    public NumberAxisBuilder columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }


    public NumberAxisBuilder columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }


    public NumberAxisBuilder constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }


    public NumberAxisBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }


    public NumberAxisBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }


    public NumberAxisBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }


    public NumberAxisBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }


    public NumberAxisBuilder fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }


    public NumberAxisBuilder fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }


    public NumberAxisBuilder hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }


    public NumberAxisBuilder hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }


    public NumberAxisBuilder marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }


    public NumberAxisBuilder rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }


    public NumberAxisBuilder rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }


    public NumberAxisBuilder vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }


    public NumberAxisBuilder vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }


    public NumberAxisBuilder hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }


    public NumberAxisBuilder marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }


    public NumberAxisBuilder alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }


    public NumberAxisBuilder marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }


    public NumberAxisBuilder alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }


    public NumberAxisBuilder marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }


    public NumberAxisBuilder marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }


    public NumberAxisBuilder vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }
    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#animatedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder animatedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.animatedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#autoRangingProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder autoRangingPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.autoRangingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#backgroundProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#borderProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#cacheShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#centerShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#forceZeroInRangeProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder forceZeroInRangePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.forceZeroInRangeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#insetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#labelProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder labelPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.labelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#lowerBoundProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder lowerBoundPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.lowerBoundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#minorTickCountProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder minorTickCountPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.minorTickCountProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#minorTickLengthProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder minorTickLengthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minorTickLengthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#minorTickVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder minorTickVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.minorTickVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#needsLayoutProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#opaqueInsetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#paddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#scaleProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder scalePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#scaleShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#shapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#sideProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder sidePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Side>> op) {
        operations.add(obj -> op.accept(obj.sideProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#snapToPixelProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#tickLabelFillProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder tickLabelFillPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Paint>> op) {
        operations.add(obj -> op.accept(obj.tickLabelFillProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#tickLabelFontProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder tickLabelFontPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.Font>> op) {
        operations.add(obj -> op.accept(obj.tickLabelFontProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#tickLabelFormatterProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder tickLabelFormatterPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.StringConverter<Number>>> op) {
        operations.add(obj -> op.accept(obj.tickLabelFormatterProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#tickLabelGapProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder tickLabelGapPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.tickLabelGapProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#tickLabelRotationProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder tickLabelRotationPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.tickLabelRotationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#tickLabelsVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder tickLabelsVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.tickLabelsVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#tickLengthProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder tickLengthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.tickLengthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#tickMarkVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder tickMarkVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.tickMarkVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#tickUnitProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder tickUnitPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.tickUnitProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#upperBoundProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder upperBoundPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.upperBoundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.NumberAxis#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public NumberAxisBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
