
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code AreaChartBuilder} class constructs instances of the {@link javafx.scene.chart.AreaChart AreaChart} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.chart.AreaChart AreaChart} constructor
 * and returns an instance of the {@code AreaChartBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.chart.AreaChart AreaChart}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.chart.AreaChart AreaChart} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class AreaChartBuilder<X, Y> {
    private java.util.List<java.util.function.Consumer<javafx.scene.chart.AreaChart<X, Y>>> operations = new java.util.ArrayList<>();
    private AreaChartBuilder() {}
    

    
    public static <X, Y> AreaChartBuilder<X, Y> create(javafx.scene.chart.Axis<X> xAxis, javafx.scene.chart.Axis<Y> yAxis) {
        AreaChartBuilder<X, Y> builder = new AreaChartBuilder<X, Y>();
        builder.constructorArgs = new Object[]{xAxis, yAxis};
        return builder;
    }


    
    public static <X, Y> AreaChartBuilder<X, Y> create(javafx.scene.chart.Axis<X> xAxis, javafx.scene.chart.Axis<Y> yAxis, javafx.collections.ObservableList<javafx.scene.chart.XYChart.Series<X, Y>> data) {
        AreaChartBuilder<X, Y> builder = new AreaChartBuilder<X, Y>();
        builder.constructorArgs = new Object[]{xAxis, yAxis, data};
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
     * @return new instance of the {@link javafx.scene.chart.AreaChart AreaChart} class
     */
    public javafx.scene.chart.AreaChart<X, Y> build() {
        javafx.scene.chart.AreaChart<X, Y> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.chart.AreaChart<X, Y>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.chart.AreaChart<X, Y> callParameterizedConstructor() {
        javafx.scene.chart.AreaChart<X, Y> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.chart.AreaChart.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.chart.AreaChart<X, Y>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the AreaChart instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(areaChart -> areaChart.setId("Main" + areaChart.getTypeSelector()))
     * }</pre>
     *
     * @return builder instance
     *
     */
    public AreaChartBuilder<X, Y> apply(java.util.function.Consumer<javafx.scene.chart.AreaChart<X, Y>> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setAlternativeColumnFillVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> alternativeColumnFillVisible(boolean value) {
        operations.add(obj -> obj.setAlternativeColumnFillVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setAlternativeRowFillVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> alternativeRowFillVisible(boolean value) {
        operations.add(obj -> obj.setAlternativeRowFillVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setAnimated(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> animated(boolean value) {
        operations.add(obj -> obj.setAnimated(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setBackground(javafx.scene.layout.Background)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setBorder(javafx.scene.layout.Border)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setCacheShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setCenterShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setCreateSymbols(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> createSymbols(boolean value) {
        operations.add(obj -> obj.setCreateSymbols(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setData(javafx.collections.ObservableList)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> data(javafx.collections.ObservableList<javafx.scene.chart.XYChart.Series<X, Y>> value) {
        operations.add(obj -> obj.setData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setHorizontalGridLinesVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> horizontalGridLinesVisible(boolean value) {
        operations.add(obj -> obj.setHorizontalGridLinesVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setHorizontalZeroLineVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> horizontalZeroLineVisible(boolean value) {
        operations.add(obj -> obj.setHorizontalZeroLineVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setLegendSide(javafx.geometry.Side)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> legendSide(javafx.geometry.Side value) {
        operations.add(obj -> obj.setLegendSide(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setLegendVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> legendVisible(boolean value) {
        operations.add(obj -> obj.setLegendVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setOpaqueInsets(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setPadding(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setScaleShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setShape(javafx.scene.shape.Shape)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setSnapToPixel(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setTitle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> title(java.lang.String value) {
        operations.add(obj -> obj.setTitle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setTitleSide(javafx.geometry.Side)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> titleSide(javafx.geometry.Side value) {
        operations.add(obj -> obj.setTitleSide(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setVerticalGridLinesVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> verticalGridLinesVisible(boolean value) {
        operations.add(obj -> obj.setVerticalGridLinesVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setVerticalZeroLineVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> verticalZeroLineVisible(boolean value) {
        operations.add(obj -> obj.setVerticalZeroLineVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.AreaChart#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AreaChartBuilder<X, Y> visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.AreaChart#getData()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final AreaChartBuilder<X, Y> addData(javafx.scene.chart.XYChart.Series<X, Y>... elements) {
        operations.add(obj -> {
            obj.getData().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.AreaChart#getData()} method.
     * 
     * @return builder instance
     */
    public final AreaChartBuilder<X, Y> addData(java.util.Collection<? extends javafx.scene.chart.XYChart.Series<X, Y>> col) {
        operations.add(obj -> {
            obj.getData().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.AreaChart#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final AreaChartBuilder<X, Y> addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.AreaChart#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final AreaChartBuilder<X, Y> addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.AreaChart#getStylesheets()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final AreaChartBuilder<X, Y> addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.AreaChart#getStylesheets()} method.
     * 
     * @return builder instance
     */
    public final AreaChartBuilder<X, Y> addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.AreaChart#getTransforms()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final AreaChartBuilder<X, Y> addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.AreaChart#getTransforms()} method.
     * 
     * @return builder instance
     */
    public final AreaChartBuilder<X, Y> addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }


    
    /**
     * Utility setter to add CSS string for this AreaChart's contents.
     * For example:
     * <pre>
     * AreaChartBuilder builder = AreaChartBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();
     * </pre>
     *
     * @param css CSS string
     */
    public AreaChartBuilder<X, Y> addStylesheetsText(String css) {
        operations.add(obj -> obj.getStylesheets().addAll("data:text/css;base64," +
                java.util.Base64.getEncoder().encodeToString(css.getBytes())));
        return this;
    }

    public AreaChartBuilder<X, Y> bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }


    public AreaChartBuilder<X, Y> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }


    public AreaChartBuilder<X, Y> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }


    public AreaChartBuilder<X, Y> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }


    public AreaChartBuilder<X, Y> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }


    public AreaChartBuilder<X, Y> fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }


    public AreaChartBuilder<X, Y> vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }
    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#alternativeColumnFillVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> alternativeColumnFillVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.alternativeColumnFillVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#alternativeRowFillVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> alternativeRowFillVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.alternativeRowFillVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#animatedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> animatedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.animatedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#backgroundProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#borderProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#cacheShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#centerShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#createSymbolsProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> createSymbolsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.createSymbolsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#dataProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> dataPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.collections.ObservableList<javafx.scene.chart.XYChart.Series<X, Y>>>> op) {
        operations.add(obj -> op.accept(obj.dataProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#horizontalGridLinesVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> horizontalGridLinesVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.horizontalGridLinesVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#horizontalZeroLineVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> horizontalZeroLineVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.horizontalZeroLineVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#insetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#legendSideProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> legendSidePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Side>> op) {
        operations.add(obj -> op.accept(obj.legendSideProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#legendVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> legendVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.legendVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#needsLayoutProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#opaqueInsetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#paddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#scaleShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#shapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#snapToPixelProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#titleProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> titlePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.titleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#titleSideProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> titleSidePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Side>> op) {
        operations.add(obj -> op.accept(obj.titleSideProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#verticalGridLinesVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> verticalGridLinesVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.verticalGridLinesVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#verticalZeroLineVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> verticalZeroLineVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.verticalZeroLineVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.AreaChart#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public AreaChartBuilder<X, Y> widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
