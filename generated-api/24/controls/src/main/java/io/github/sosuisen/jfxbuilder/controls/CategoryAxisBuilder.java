
package io.github.sosuisen.jfxbuilder.controls;


public class CategoryAxisBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.chart.CategoryAxis>> operations = new java.util.ArrayList<>();
    private CategoryAxisBuilder() {}
    

    public static CategoryAxisBuilder create() { return new CategoryAxisBuilder(); }


    
    public static CategoryAxisBuilder create(javafx.collections.ObservableList<java.lang.String> categories) {
        CategoryAxisBuilder builder = new CategoryAxisBuilder();
        builder.constructorArgs = new Object[]{categories};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.chart.CategoryAxis build() {
        javafx.scene.chart.CategoryAxis newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.chart.CategoryAxis();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.chart.CategoryAxis> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.chart.CategoryAxis callParameterizedConstructor() {
        javafx.scene.chart.CategoryAxis newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.chart.CategoryAxis.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.chart.CategoryAxis) constructor.newInstance(constructorArgs);
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
     * Applies a function to the CategoryAxis instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(categoryAxis -> categoryAxis.setId("Main" + categoryAxis.getTypeSelector()))
     * }</pre>
     * 
     * @return builder instance
     *
     */
    public CategoryAxisBuilder apply(java.util.function.Consumer<javafx.scene.chart.CategoryAxis> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setAnimated(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder animated(boolean value) {
        operations.add(obj -> obj.setAnimated(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setAutoRanging(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder autoRanging(boolean value) {
        operations.add(obj -> obj.setAutoRanging(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setBackground(javafx.scene.layout.Background)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setBorder(javafx.scene.layout.Border)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setCacheShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setCategories(javafx.collections.ObservableList)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder categories(javafx.collections.ObservableList<java.lang.String> value) {
        operations.add(obj -> obj.setCategories(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setCenterShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setEndMargin(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder endMargin(double value) {
        operations.add(obj -> obj.setEndMargin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setGapStartAndEnd(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder gapStartAndEnd(boolean value) {
        operations.add(obj -> obj.setGapStartAndEnd(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setLabel(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder label(java.lang.String value) {
        operations.add(obj -> obj.setLabel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setOpaqueInsets(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setPadding(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setScaleShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setShape(javafx.scene.shape.Shape)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setSide(javafx.geometry.Side)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder side(javafx.geometry.Side value) {
        operations.add(obj -> obj.setSide(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setSnapToPixel(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setStartMargin(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder startMargin(double value) {
        operations.add(obj -> obj.setStartMargin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setTickLabelFill(javafx.scene.paint.Paint)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder tickLabelFill(javafx.scene.paint.Paint value) {
        operations.add(obj -> obj.setTickLabelFill(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setTickLabelFont(javafx.scene.text.Font)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder tickLabelFont(javafx.scene.text.Font value) {
        operations.add(obj -> obj.setTickLabelFont(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setTickLabelGap(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder tickLabelGap(double value) {
        operations.add(obj -> obj.setTickLabelGap(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setTickLabelRotation(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder tickLabelRotation(double value) {
        operations.add(obj -> obj.setTickLabelRotation(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setTickLabelsVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder tickLabelsVisible(boolean value) {
        operations.add(obj -> obj.setTickLabelsVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setTickLength(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder tickLength(double value) {
        operations.add(obj -> obj.setTickLength(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setTickMarkVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder tickMarkVisible(boolean value) {
        operations.add(obj -> obj.setTickMarkVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.CategoryAxis#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CategoryAxisBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.CategoryAxis#getCategories()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public final CategoryAxisBuilder addCategories(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getCategories().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.CategoryAxis#getCategories()} method.
     * 
     * @return builder instance
     */     
    public final CategoryAxisBuilder addCategories(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getCategories().addAll(col);
        });
        return this;
    }


    /**
     * Create an instance of the builder, then call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.CategoryAxis#getCategories()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public static CategoryAxisBuilder withCategories(java.lang.String... elements) {
        CategoryAxisBuilder builder = new CategoryAxisBuilder();
        return builder.addCategories(elements);
    }

    /**
     * Create an instance of the builder, then call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.CategoryAxis#getCategories()} method.
     * 
     * @return builder instance
     */     
    public static CategoryAxisBuilder withCategories(java.util.Collection<? extends java.lang.String> col) {
        CategoryAxisBuilder builder = new CategoryAxisBuilder();
        return builder.addCategories(col);
    }


    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.CategoryAxis#getStyleClass()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public final CategoryAxisBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.CategoryAxis#getStyleClass()} method.
     * 
     * @return builder instance
     */     
    public final CategoryAxisBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.CategoryAxis#getStylesheets()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public final CategoryAxisBuilder addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.CategoryAxis#getStylesheets()} method.
     * 
     * @return builder instance
     */     
    public final CategoryAxisBuilder addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.CategoryAxis#getTickMarks()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public final CategoryAxisBuilder addTickMarks(javafx.scene.chart.Axis.TickMark<String>... elements) {
        operations.add(obj -> {
            obj.getTickMarks().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.CategoryAxis#getTickMarks()} method.
     * 
     * @return builder instance
     */     
    public final CategoryAxisBuilder addTickMarks(java.util.Collection<? extends javafx.scene.chart.Axis.TickMark<String>> col) {
        operations.add(obj -> {
            obj.getTickMarks().addAll(col);
        });
        return this;
    }


    /**
     * Create an instance of the builder, then call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.CategoryAxis#getTickMarks()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public static CategoryAxisBuilder withTickMarks(javafx.scene.chart.Axis.TickMark<String>... elements) {
        CategoryAxisBuilder builder = new CategoryAxisBuilder();
        return builder.addTickMarks(elements);
    }

    /**
     * Create an instance of the builder, then call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.CategoryAxis#getTickMarks()} method.
     * 
     * @return builder instance
     */     
    public static CategoryAxisBuilder withTickMarks(java.util.Collection<? extends javafx.scene.chart.Axis.TickMark<String>> col) {
        CategoryAxisBuilder builder = new CategoryAxisBuilder();
        return builder.addTickMarks(col);
    }


    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.CategoryAxis#getTransforms()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public final CategoryAxisBuilder addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.CategoryAxis#getTransforms()} method.
     * 
     * @return builder instance
     */     
    public final CategoryAxisBuilder addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }


    
    /**
     * Utility setter to add CSS string for this CategoryAxis's contents.
     * For example:
     * <pre>
     * CategoryAxisBuilder builder = CategoryAxisBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();
     * </pre>
     *
     * @param css CSS string
     */
    public CategoryAxisBuilder addStylesheetsText(String css) {
        operations.add(obj -> obj.getStylesheets().addAll("data:text/css;base64," +
                java.util.Base64.getEncoder().encodeToString(css.getBytes())));
        return this;
    }

    public CategoryAxisBuilder bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }


    public CategoryAxisBuilder leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }


    public CategoryAxisBuilder rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }


    public CategoryAxisBuilder topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }


    public CategoryAxisBuilder alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }


    public CategoryAxisBuilder marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }


    public CategoryAxisBuilder marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }


    public CategoryAxisBuilder columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }


    public CategoryAxisBuilder columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }


    public CategoryAxisBuilder constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }


    public CategoryAxisBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }


    public CategoryAxisBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }


    public CategoryAxisBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }


    public CategoryAxisBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }


    public CategoryAxisBuilder fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }


    public CategoryAxisBuilder fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }


    public CategoryAxisBuilder hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }


    public CategoryAxisBuilder hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }


    public CategoryAxisBuilder marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }


    public CategoryAxisBuilder rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }


    public CategoryAxisBuilder rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }


    public CategoryAxisBuilder vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }


    public CategoryAxisBuilder vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }


    public CategoryAxisBuilder hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }


    public CategoryAxisBuilder marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }


    public CategoryAxisBuilder alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }


    public CategoryAxisBuilder marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }


    public CategoryAxisBuilder alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }


    public CategoryAxisBuilder marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }


    public CategoryAxisBuilder marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }


    public CategoryAxisBuilder vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }
    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#animatedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder animatedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.animatedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#autoRangingProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder autoRangingPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.autoRangingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#backgroundProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#borderProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#cacheShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#categorySpacingProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder categorySpacingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.categorySpacingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#centerShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#endMarginProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder endMarginPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.endMarginProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#gapStartAndEndProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder gapStartAndEndPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.gapStartAndEndProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#insetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#labelProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder labelPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.labelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#needsLayoutProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#opaqueInsetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#paddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#scaleShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#shapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#sideProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder sidePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Side>> op) {
        operations.add(obj -> op.accept(obj.sideProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#snapToPixelProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#startMarginProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder startMarginPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.startMarginProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#tickLabelFillProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder tickLabelFillPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Paint>> op) {
        operations.add(obj -> op.accept(obj.tickLabelFillProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#tickLabelFontProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder tickLabelFontPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.Font>> op) {
        operations.add(obj -> op.accept(obj.tickLabelFontProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#tickLabelGapProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder tickLabelGapPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.tickLabelGapProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#tickLabelRotationProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder tickLabelRotationPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.tickLabelRotationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#tickLabelsVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder tickLabelsVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.tickLabelsVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#tickLengthProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder tickLengthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.tickLengthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#tickMarkVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder tickMarkVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.tickMarkVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.CategoryAxis#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public CategoryAxisBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
