
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code BarChartBuilder} class constructs instances of the {@link javafx.scene.chart.BarChart BarChart} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.chart.BarChart BarChart} constructor
 * and returns an instance of the {@code BarChartBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.chart.BarChart BarChart}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.chart.BarChart BarChart} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class BarChartBuilder<X, Y> {
    private java.util.List<java.util.function.Consumer<javafx.scene.chart.BarChart<X, Y>>> operations = new java.util.ArrayList<>();
    private BarChartBuilder() {}
    

    /**
     * Accepts the same arguments as {@link javafx.scene.chart.BarChart#BarChart(javafx.scene.chart.Axis<X> xAxis, javafx.scene.chart.Axis<Y> yAxis) BarChart(Axis, Axis)}
     * and returns an instance of the {@code <X, Y> BarChartBuilder<X, Y>}.
     *
     * @return an instance of the {@code <X, Y> BarChartBuilder<X, Y>}.
     */
    
    public static <X, Y> BarChartBuilder<X, Y> create(javafx.scene.chart.Axis<X> xAxis, javafx.scene.chart.Axis<Y> yAxis) {
        BarChartBuilder<X, Y> builder = new BarChartBuilder<X, Y>();
        builder.constructorArgs = new Object[]{xAxis, yAxis};
        return builder;
    }


    /**
     * Accepts the same arguments as {@link javafx.scene.chart.BarChart#BarChart(javafx.scene.chart.Axis<X> xAxis, javafx.scene.chart.Axis<Y> yAxis, javafx.collections.ObservableList<javafx.scene.chart.XYChart.Series<X, Y>> data) BarChart(Axis, Axis, ObservableList)}
     * and returns an instance of the {@code <X, Y> BarChartBuilder<X, Y>}.
     *
     * @return an instance of the {@code <X, Y> BarChartBuilder<X, Y>}.
     */
    
    public static <X, Y> BarChartBuilder<X, Y> create(javafx.scene.chart.Axis<X> xAxis, javafx.scene.chart.Axis<Y> yAxis, javafx.collections.ObservableList<javafx.scene.chart.XYChart.Series<X, Y>> data) {
        BarChartBuilder<X, Y> builder = new BarChartBuilder<X, Y>();
        builder.constructorArgs = new Object[]{xAxis, yAxis, data};
        return builder;
    }


    /**
     * Accepts the same arguments as {@link javafx.scene.chart.BarChart#BarChart(javafx.scene.chart.Axis<X> xAxis, javafx.scene.chart.Axis<Y> yAxis, javafx.collections.ObservableList<javafx.scene.chart.XYChart.Series<X, Y>> data, double categoryGap) BarChart(Axis, Axis, ObservableList, double)}
     * and returns an instance of the {@code <X, Y> BarChartBuilder<X, Y>}.
     *
     * @return an instance of the {@code <X, Y> BarChartBuilder<X, Y>}.
     */
    
    public static <X, Y> BarChartBuilder<X, Y> create(javafx.scene.chart.Axis<X> xAxis, javafx.scene.chart.Axis<Y> yAxis, javafx.collections.ObservableList<javafx.scene.chart.XYChart.Series<X, Y>> data, double categoryGap) {
        BarChartBuilder<X, Y> builder = new BarChartBuilder<X, Y>();
        builder.constructorArgs = new Object[]{xAxis, yAxis, data, categoryGap};
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
     * @return new instance of the {@link javafx.scene.chart.BarChart BarChart} class
     */
    public javafx.scene.chart.BarChart<X, Y> build() {
        javafx.scene.chart.BarChart<X, Y> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.chart.BarChart<X, Y>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.chart.BarChart<X, Y> callParameterizedConstructor() {
        javafx.scene.chart.BarChart<X, Y> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.chart.BarChart.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.chart.BarChart<X, Y>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the BarChart instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(barChart -> barChart.setId("Main" + barChart.getTypeSelector()))
     * }</pre>
     *
     * @return builder instance
     *
     */
    public BarChartBuilder<X, Y> apply(java.util.function.Consumer<javafx.scene.chart.BarChart<X, Y>> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setAlternativeColumnFillVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> alternativeColumnFillVisible(boolean value) {
        operations.add(obj -> obj.setAlternativeColumnFillVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setAlternativeRowFillVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> alternativeRowFillVisible(boolean value) {
        operations.add(obj -> obj.setAlternativeRowFillVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setAnimated(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> animated(boolean value) {
        operations.add(obj -> obj.setAnimated(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setBackground(javafx.scene.layout.Background)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setBarGap(double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> barGap(double value) {
        operations.add(obj -> obj.setBarGap(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setBorder(javafx.scene.layout.Border)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setCacheShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setCategoryGap(double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> categoryGap(double value) {
        operations.add(obj -> obj.setCategoryGap(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setCenterShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setData(javafx.collections.ObservableList)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> data(javafx.collections.ObservableList<javafx.scene.chart.XYChart.Series<X, Y>> value) {
        operations.add(obj -> obj.setData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setHorizontalGridLinesVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> horizontalGridLinesVisible(boolean value) {
        operations.add(obj -> obj.setHorizontalGridLinesVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setHorizontalZeroLineVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> horizontalZeroLineVisible(boolean value) {
        operations.add(obj -> obj.setHorizontalZeroLineVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setLegendSide(javafx.geometry.Side)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> legendSide(javafx.geometry.Side value) {
        operations.add(obj -> obj.setLegendSide(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setLegendVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> legendVisible(boolean value) {
        operations.add(obj -> obj.setLegendVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setOpaqueInsets(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setPadding(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setScaleShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setShape(javafx.scene.shape.Shape)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setSnapToPixel(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setTitle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> title(java.lang.String value) {
        operations.add(obj -> obj.setTitle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setTitleSide(javafx.geometry.Side)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> titleSide(javafx.geometry.Side value) {
        operations.add(obj -> obj.setTitleSide(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setVerticalGridLinesVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> verticalGridLinesVisible(boolean value) {
        operations.add(obj -> obj.setVerticalGridLinesVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setVerticalZeroLineVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> verticalZeroLineVisible(boolean value) {
        operations.add(obj -> obj.setVerticalZeroLineVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.chart.BarChart#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  BarChartBuilder<X, Y> visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.BarChart#getData()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final BarChartBuilder<X, Y> addData(javafx.scene.chart.XYChart.Series<X, Y>... elements) {
        operations.add(obj -> {
            obj.getData().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.BarChart#getData()} method.
     * 
     * @return builder instance
     */
    public final BarChartBuilder<X, Y> addData(java.util.Collection<? extends javafx.scene.chart.XYChart.Series<X, Y>> col) {
        operations.add(obj -> {
            obj.getData().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.BarChart#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final BarChartBuilder<X, Y> addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.BarChart#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final BarChartBuilder<X, Y> addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.BarChart#getStylesheets()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final BarChartBuilder<X, Y> addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.BarChart#getStylesheets()} method.
     * 
     * @return builder instance
     */
    public final BarChartBuilder<X, Y> addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.BarChart#getTransforms()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final BarChartBuilder<X, Y> addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.BarChart#getTransforms()} method.
     * 
     * @return builder instance
     */
    public final BarChartBuilder<X, Y> addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }


    
    /**
     * Utility setter to add CSS string for this BarChart's contents.
     * For example:
     * <pre>
     * BarChartBuilder builder = BarChartBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();
     * </pre>
     *
     * @param css CSS string
     */
    public BarChartBuilder<X, Y> addStylesheetsText(String css) {
        operations.add(obj -> obj.getStylesheets().addAll("data:text/css;base64," +
                java.util.Base64.getEncoder().encodeToString(css.getBytes())));
        return this;
    }
    /**
     * Invokes the {@link javafx.scene.layout.AnchorPane#setBottomAnchor(Node child, java.lang.Double value) AnchorPane.setBottomAnchor(Node, Double)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new AnchorPane(btn);
     * AnchorPane.setBottomAnchor(btn, new Insets(10));
     *
     * // Fluent API
     * var root = AnchorPaneBuilder.create(
     *                                  ButtonBuilder.create()
     *                                               .bottomAnchorInAnchorPane(new Insets(10))
     *                                               .build())
     *                             .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.AnchorPane#setLeftAnchor(Node child, java.lang.Double value) AnchorPane.setLeftAnchor(Node, Double)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new AnchorPane(btn);
     * AnchorPane.setLeftAnchor(btn, new Insets(10));
     *
     * // Fluent API
     * var root = AnchorPaneBuilder.create(
     *                                  ButtonBuilder.create()
     *                                               .leftAnchorInAnchorPane(new Insets(10))
     *                                               .build())
     *                             .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.AnchorPane#setRightAnchor(Node child, java.lang.Double value) AnchorPane.setRightAnchor(Node, Double)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new AnchorPane(btn);
     * AnchorPane.setRightAnchor(btn, new Insets(10));
     *
     * // Fluent API
     * var root = AnchorPaneBuilder.create(
     *                                  ButtonBuilder.create()
     *                                               .rightAnchorInAnchorPane(new Insets(10))
     *                                               .build())
     *                             .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.AnchorPane#setTopAnchor(Node child, java.lang.Double value) AnchorPane.setTopAnchor(Node, Double)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new AnchorPane(btn);
     * AnchorPane.setTopAnchor(btn, new Insets(10));
     *
     * // Fluent API
     * var root = AnchorPaneBuilder.create(
     *                                  ButtonBuilder.create()
     *                                               .topAnchorInAnchorPane(new Insets(10))
     *                                               .build())
     *                             .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.BorderPane#setAlignment(Node child, javafx.geometry.Pos value) BorderPane.setAlignment(Node, Pos)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new BorderPane(btn);
     * BorderPane.setAlignment(btn, new Insets(10));
     *
     * // Fluent API
     * var root = BorderPaneBuilder.create(
     *                                  ButtonBuilder.create()
     *                                               .alignmentInBorderPane(new Insets(10))
     *                                               .build())
     *                             .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.BorderPane#setMargin(Node child, javafx.geometry.Insets value) BorderPane.setMargin(Node, Insets)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new BorderPane(btn);
     * BorderPane.setMargin(btn, new Insets(10));
     *
     * // Fluent API
     * var root = BorderPaneBuilder.create(
     *                                  ButtonBuilder.create()
     *                                               .marginInBorderPane(new Insets(10))
     *                                               .build())
     *                             .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.FlowPane#setMargin(Node child, javafx.geometry.Insets value) FlowPane.setMargin(Node, Insets)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new FlowPane(btn);
     * FlowPane.setMargin(btn, new Insets(10));
     *
     * // Fluent API
     * var root = FlowPaneBuilder.create(
     *                                ButtonBuilder.create()
     *                                             .marginInFlowPane(new Insets(10))
     *                                             .build())
     *                           .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setColumnIndex(Node child, java.lang.Integer value) GridPane.setColumnIndex(Node, Integer)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new GridPane(btn);
     * GridPane.setColumnIndex(btn, new Insets(10));
     *
     * // Fluent API
     * var root = GridPaneBuilder.create(
     *                                ButtonBuilder.create()
     *                                             .columnIndexInGridPane(new Insets(10))
     *                                             .build())
     *                           .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setColumnSpan(Node child, java.lang.Integer value) GridPane.setColumnSpan(Node, Integer)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new GridPane(btn);
     * GridPane.setColumnSpan(btn, new Insets(10));
     *
     * // Fluent API
     * var root = GridPaneBuilder.create(
     *                                ButtonBuilder.create()
     *                                             .columnSpanInGridPane(new Insets(10))
     *                                             .build())
     *                           .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setConstraints(Node child, int columnIndex, int rowIndex) GridPane.setConstraints(Node, int, int)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new GridPane(btn);
     * GridPane.setConstraints(btn, new Insets(10));
     *
     * // Fluent API
     * var root = GridPaneBuilder.create(
     *                                ButtonBuilder.create()
     *                                             .constraintsInGridPane(new Insets(10))
     *                                             .build())
     *                           .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setConstraints(Node child, int columnIndex, int rowIndex, int columnspan, int rowspan) GridPane.setConstraints(Node, int, int, int, int)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new GridPane(btn);
     * GridPane.setConstraints(btn, new Insets(10));
     *
     * // Fluent API
     * var root = GridPaneBuilder.create(
     *                                ButtonBuilder.create()
     *                                             .constraintsInGridPane(new Insets(10))
     *                                             .build())
     *                           .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setConstraints(Node child, int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) GridPane.setConstraints(Node, int, int, int, int, HPos, VPos)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new GridPane(btn);
     * GridPane.setConstraints(btn, new Insets(10));
     *
     * // Fluent API
     * var root = GridPaneBuilder.create(
     *                                ButtonBuilder.create()
     *                                             .constraintsInGridPane(new Insets(10))
     *                                             .build())
     *                           .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setConstraints(Node child, int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) GridPane.setConstraints(Node, int, int, int, int, HPos, VPos, Priority, Priority)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new GridPane(btn);
     * GridPane.setConstraints(btn, new Insets(10));
     *
     * // Fluent API
     * var root = GridPaneBuilder.create(
     *                                ButtonBuilder.create()
     *                                             .constraintsInGridPane(new Insets(10))
     *                                             .build())
     *                           .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setConstraints(Node child, int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) GridPane.setConstraints(Node, int, int, int, int, HPos, VPos, Priority, Priority, Insets)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new GridPane(btn);
     * GridPane.setConstraints(btn, new Insets(10));
     *
     * // Fluent API
     * var root = GridPaneBuilder.create(
     *                                ButtonBuilder.create()
     *                                             .constraintsInGridPane(new Insets(10))
     *                                             .build())
     *                           .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setFillHeight(Node child, java.lang.Boolean value) GridPane.setFillHeight(Node, Boolean)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new GridPane(btn);
     * GridPane.setFillHeight(btn, new Insets(10));
     *
     * // Fluent API
     * var root = GridPaneBuilder.create(
     *                                ButtonBuilder.create()
     *                                             .fillHeightInGridPane(new Insets(10))
     *                                             .build())
     *                           .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setFillWidth(Node child, java.lang.Boolean value) GridPane.setFillWidth(Node, Boolean)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new GridPane(btn);
     * GridPane.setFillWidth(btn, new Insets(10));
     *
     * // Fluent API
     * var root = GridPaneBuilder.create(
     *                                ButtonBuilder.create()
     *                                             .fillWidthInGridPane(new Insets(10))
     *                                             .build())
     *                           .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setHalignment(Node child, javafx.geometry.HPos value) GridPane.setHalignment(Node, HPos)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new GridPane(btn);
     * GridPane.setHalignment(btn, new Insets(10));
     *
     * // Fluent API
     * var root = GridPaneBuilder.create(
     *                                ButtonBuilder.create()
     *                                             .hAlignmentInGridPane(new Insets(10))
     *                                             .build())
     *                           .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setHgrow(Node child, javafx.scene.layout.Priority value) GridPane.setHgrow(Node, Priority)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new GridPane(btn);
     * GridPane.setHgrow(btn, new Insets(10));
     *
     * // Fluent API
     * var root = GridPaneBuilder.create(
     *                                ButtonBuilder.create()
     *                                             .hGrowInGridPane(new Insets(10))
     *                                             .build())
     *                           .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setMargin(Node child, javafx.geometry.Insets value) GridPane.setMargin(Node, Insets)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new GridPane(btn);
     * GridPane.setMargin(btn, new Insets(10));
     *
     * // Fluent API
     * var root = GridPaneBuilder.create(
     *                                ButtonBuilder.create()
     *                                             .marginInGridPane(new Insets(10))
     *                                             .build())
     *                           .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setRowIndex(Node child, java.lang.Integer value) GridPane.setRowIndex(Node, Integer)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new GridPane(btn);
     * GridPane.setRowIndex(btn, new Insets(10));
     *
     * // Fluent API
     * var root = GridPaneBuilder.create(
     *                                ButtonBuilder.create()
     *                                             .rowIndexInGridPane(new Insets(10))
     *                                             .build())
     *                           .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setRowSpan(Node child, java.lang.Integer value) GridPane.setRowSpan(Node, Integer)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new GridPane(btn);
     * GridPane.setRowSpan(btn, new Insets(10));
     *
     * // Fluent API
     * var root = GridPaneBuilder.create(
     *                                ButtonBuilder.create()
     *                                             .rowSpanInGridPane(new Insets(10))
     *                                             .build())
     *                           .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setValignment(Node child, javafx.geometry.VPos value) GridPane.setValignment(Node, VPos)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new GridPane(btn);
     * GridPane.setValignment(btn, new Insets(10));
     *
     * // Fluent API
     * var root = GridPaneBuilder.create(
     *                                ButtonBuilder.create()
     *                                             .vAlignmentInGridPane(new Insets(10))
     *                                             .build())
     *                           .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setVgrow(Node child, javafx.scene.layout.Priority value) GridPane.setVgrow(Node, Priority)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new GridPane(btn);
     * GridPane.setVgrow(btn, new Insets(10));
     *
     * // Fluent API
     * var root = GridPaneBuilder.create(
     *                                ButtonBuilder.create()
     *                                             .vGrowInGridPane(new Insets(10))
     *                                             .build())
     *                           .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.HBox#setHgrow(Node child, javafx.scene.layout.Priority value) HBox.setHgrow(Node, Priority)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new HBox(btn);
     * HBox.setHgrow(btn, new Insets(10));
     *
     * // Fluent API
     * var root = HBoxBuilder.create(
     *                            ButtonBuilder.create()
     *                                         .hGrowInHBox(new Insets(10))
     *                                         .build())
     *                       .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.HBox#setMargin(Node child, javafx.geometry.Insets value) HBox.setMargin(Node, Insets)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new HBox(btn);
     * HBox.setMargin(btn, new Insets(10));
     *
     * // Fluent API
     * var root = HBoxBuilder.create(
     *                            ButtonBuilder.create()
     *                                         .marginInHBox(new Insets(10))
     *                                         .build())
     *                       .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.StackPane#setAlignment(Node child, javafx.geometry.Pos value) StackPane.setAlignment(Node, Pos)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new StackPane(btn);
     * StackPane.setAlignment(btn, new Insets(10));
     *
     * // Fluent API
     * var root = StackPaneBuilder.create(
     *                                 ButtonBuilder.create()
     *                                              .alignmentInStackPane(new Insets(10))
     *                                              .build())
     *                            .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.StackPane#setMargin(Node child, javafx.geometry.Insets value) StackPane.setMargin(Node, Insets)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new StackPane(btn);
     * StackPane.setMargin(btn, new Insets(10));
     *
     * // Fluent API
     * var root = StackPaneBuilder.create(
     *                                 ButtonBuilder.create()
     *                                              .marginInStackPane(new Insets(10))
     *                                              .build())
     *                            .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.TilePane#setAlignment(Node child, javafx.geometry.Pos value) TilePane.setAlignment(Node, Pos)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new TilePane(btn);
     * TilePane.setAlignment(btn, new Insets(10));
     *
     * // Fluent API
     * var root = TilePaneBuilder.create(
     *                                ButtonBuilder.create()
     *                                             .alignmentInTilePane(new Insets(10))
     *                                             .build())
     *                           .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.TilePane#setMargin(Node child, javafx.geometry.Insets value) TilePane.setMargin(Node, Insets)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new TilePane(btn);
     * TilePane.setMargin(btn, new Insets(10));
     *
     * // Fluent API
     * var root = TilePaneBuilder.create(
     *                                ButtonBuilder.create()
     *                                             .marginInTilePane(new Insets(10))
     *                                             .build())
     *                           .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.VBox#setMargin(Node child, javafx.geometry.Insets value) VBox.setMargin(Node, Insets)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new VBox(btn);
     * VBox.setMargin(btn, new Insets(10));
     *
     * // Fluent API
     * var root = VBoxBuilder.create(
     *                            ButtonBuilder.create()
     *                                         .marginInVBox(new Insets(10))
     *                                         .build())
     *                       .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.VBox#setVgrow(Node child, javafx.scene.layout.Priority value) VBox.setVgrow(Node, Priority)} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new VBox(btn);
     * VBox.setVgrow(btn, new Insets(10));
     *
     * // Fluent API
     * var root = VBoxBuilder.create(
     *                            ButtonBuilder.create()
     *                                         .vGrowInVBox(new Insets(10))
     *                                         .build())
     *                       .build();
     * }</pre>
     *
     * @return builder instance
     */
    public BarChartBuilder<X, Y> vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }
    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#alternativeColumnFillVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> alternativeColumnFillVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.alternativeColumnFillVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#alternativeRowFillVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> alternativeRowFillVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.alternativeRowFillVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#animatedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> animatedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.animatedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#backgroundProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#barGapProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> barGapPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.barGapProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#borderProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#cacheShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#categoryGapProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> categoryGapPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.categoryGapProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#centerShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#dataProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> dataPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.collections.ObservableList<javafx.scene.chart.XYChart.Series<X, Y>>>> op) {
        operations.add(obj -> op.accept(obj.dataProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#horizontalGridLinesVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> horizontalGridLinesVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.horizontalGridLinesVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#horizontalZeroLineVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> horizontalZeroLineVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.horizontalZeroLineVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#insetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#legendSideProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> legendSidePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Side>> op) {
        operations.add(obj -> op.accept(obj.legendSideProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#legendVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> legendVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.legendVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#needsLayoutProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#opaqueInsetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#paddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#scaleShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#shapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#snapToPixelProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#titleProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> titlePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.titleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#titleSideProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> titleSidePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Side>> op) {
        operations.add(obj -> op.accept(obj.titleSideProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#verticalGridLinesVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> verticalGridLinesVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.verticalGridLinesVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#verticalZeroLineVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> verticalZeroLineVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.verticalZeroLineVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.BarChart#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public BarChartBuilder<X, Y> widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
