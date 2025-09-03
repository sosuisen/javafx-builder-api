
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code StackedAreaChartBuilder} class constructs instances of the {@link javafx.scene.chart.StackedAreaChart StackedAreaChart} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.chart.StackedAreaChart StackedAreaChart} constructor
 * and returns an instance of the {@code StackedAreaChartBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.chart.StackedAreaChart StackedAreaChart}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.chart.StackedAreaChart StackedAreaChart} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class StackedAreaChartBuilder<X, Y> {
    private java.util.List<java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>>> operations = new java.util.ArrayList<>();
    private StackedAreaChartBuilder() {}
    

    /**
     * Accepts the constructor arguments of {@link javafx.scene.chart.StackedAreaChart#StackedAreaChart(Axis, Axis) StackedAreaChart(Axis, Axis)}
     * and returns an instance of {@code StackedAreaChartBuilder<X, Y>}.
     *
     * @return an instance of the {@code StackedAreaChartBuilder<X, Y>}.
     */
    
    public static <X, Y> StackedAreaChartBuilder<X, Y> create(javafx.scene.chart.Axis<X> xAxis, javafx.scene.chart.Axis<Y> yAxis) {
        StackedAreaChartBuilder<X, Y> builder = new StackedAreaChartBuilder<X, Y>();
        builder.constructorArgs = new Object[]{xAxis, yAxis};
        return builder;
    }


    /**
     * Accepts the constructor arguments of {@link javafx.scene.chart.StackedAreaChart#StackedAreaChart(Axis, Axis, ObservableList) StackedAreaChart(Axis, Axis, ObservableList)}
     * and returns an instance of {@code StackedAreaChartBuilder<X, Y>}.
     *
     * @return an instance of the {@code StackedAreaChartBuilder<X, Y>}.
     */
    
    public static <X, Y> StackedAreaChartBuilder<X, Y> create(javafx.scene.chart.Axis<X> xAxis, javafx.scene.chart.Axis<Y> yAxis, javafx.collections.ObservableList<javafx.scene.chart.XYChart.Series<X, Y>> data) {
        StackedAreaChartBuilder<X, Y> builder = new StackedAreaChartBuilder<X, Y>();
        builder.constructorArgs = new Object[]{xAxis, yAxis, data};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.chart.StackedAreaChart<X, Y>} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.chart.StackedAreaChart StackedAreaChart} class
     */
    public javafx.scene.chart.StackedAreaChart<X, Y> build() {
        javafx.scene.chart.StackedAreaChart<X, Y> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.chart.StackedAreaChart<X, Y> callParameterizedConstructor() {
        javafx.scene.chart.StackedAreaChart<X, Y> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.chart.StackedAreaChart.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.chart.StackedAreaChart<X, Y>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the StackedAreaChart instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(stackedAreaChart -> stackedAreaChart.setId("Main" + stackedAreaChart.getTypeSelector()))
     * }</pre>
     *
     * @return builder instance
     *
     */
    public StackedAreaChartBuilder<X, Y> apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) {
        operations.add(func);
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setAccessibleHelp(java.lang.String) setAccessibleHelp} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setAccessibleRole(javafx.scene.AccessibleRole) setAccessibleRole} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setAccessibleRoleDescription(java.lang.String) setAccessibleRoleDescription} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setAccessibleText(java.lang.String) setAccessibleText} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setAlternativeColumnFillVisible(boolean) setAlternativeColumnFillVisible} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> alternativeColumnFillVisible(boolean value) {
        operations.add(obj -> obj.setAlternativeColumnFillVisible(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setAlternativeRowFillVisible(boolean) setAlternativeRowFillVisible} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> alternativeRowFillVisible(boolean value) {
        operations.add(obj -> obj.setAlternativeRowFillVisible(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setAnimated(boolean) setAnimated} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> animated(boolean value) {
        operations.add(obj -> obj.setAnimated(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setBackground(javafx.scene.layout.Background) setBackground} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setBlendMode(javafx.scene.effect.BlendMode) setBlendMode} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setBorder(javafx.scene.layout.Border) setBorder} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setCache(boolean) setCache} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setCacheHint(javafx.scene.CacheHint) setCacheHint} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setCacheShape(boolean) setCacheShape} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setCenterShape(boolean) setCenterShape} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setClip(javafx.scene.Node) setClip} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setCreateSymbols(boolean) setCreateSymbols} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> createSymbols(boolean value) {
        operations.add(obj -> obj.setCreateSymbols(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setCursor(javafx.scene.Cursor) setCursor} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setData(javafx.collections.ObservableList) setData} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> data(javafx.collections.ObservableList<javafx.scene.chart.XYChart.Series<X, Y>> value) {
        operations.add(obj -> obj.setData(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setDepthTest(javafx.scene.DepthTest) setDepthTest} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setDisable(boolean) setDisable} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setEffect(javafx.scene.effect.Effect) setEffect} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setEventDispatcher(javafx.event.EventDispatcher) setEventDispatcher} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setFocusTraversable(boolean) setFocusTraversable} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setHorizontalGridLinesVisible(boolean) setHorizontalGridLinesVisible} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> horizontalGridLinesVisible(boolean value) {
        operations.add(obj -> obj.setHorizontalGridLinesVisible(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setHorizontalZeroLineVisible(boolean) setHorizontalZeroLineVisible} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> horizontalZeroLineVisible(boolean value) {
        operations.add(obj -> obj.setHorizontalZeroLineVisible(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setId(java.lang.String) setId} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setInputMethodRequests(javafx.scene.input.InputMethodRequests) setInputMethodRequests} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setLayoutX(double) setLayoutX} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setLayoutY(double) setLayoutY} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setLegendSide(javafx.geometry.Side) setLegendSide} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> legendSide(javafx.geometry.Side value) {
        operations.add(obj -> obj.setLegendSide(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setLegendVisible(boolean) setLegendVisible} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> legendVisible(boolean value) {
        operations.add(obj -> obj.setLegendVisible(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setManaged(boolean) setManaged} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setMaxHeight(double) setMaxHeight} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setMaxSize(double, double) setMaxSize} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setMaxWidth(double) setMaxWidth} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setMinHeight(double) setMinHeight} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setMinSize(double, double) setMinSize} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setMinWidth(double) setMinWidth} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setMouseTransparent(boolean) setMouseTransparent} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setNodeOrientation(javafx.geometry.NodeOrientation) setNodeOrientation} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnContextMenuRequested(javafx.event.EventHandler) setOnContextMenuRequested} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnDragDetected(javafx.event.EventHandler) setOnDragDetected} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnDragDone(javafx.event.EventHandler) setOnDragDone} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnDragDropped(javafx.event.EventHandler) setOnDragDropped} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnDragEntered(javafx.event.EventHandler) setOnDragEntered} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnDragExited(javafx.event.EventHandler) setOnDragExited} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnDragOver(javafx.event.EventHandler) setOnDragOver} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnInputMethodTextChanged(javafx.event.EventHandler) setOnInputMethodTextChanged} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnKeyPressed(javafx.event.EventHandler) setOnKeyPressed} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnKeyReleased(javafx.event.EventHandler) setOnKeyReleased} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnKeyTyped(javafx.event.EventHandler) setOnKeyTyped} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnMouseClicked(javafx.event.EventHandler) setOnMouseClicked} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnMouseDragEntered(javafx.event.EventHandler) setOnMouseDragEntered} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnMouseDragExited(javafx.event.EventHandler) setOnMouseDragExited} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnMouseDragOver(javafx.event.EventHandler) setOnMouseDragOver} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnMouseDragReleased(javafx.event.EventHandler) setOnMouseDragReleased} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnMouseDragged(javafx.event.EventHandler) setOnMouseDragged} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnMouseEntered(javafx.event.EventHandler) setOnMouseEntered} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnMouseExited(javafx.event.EventHandler) setOnMouseExited} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnMouseMoved(javafx.event.EventHandler) setOnMouseMoved} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnMousePressed(javafx.event.EventHandler) setOnMousePressed} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnMouseReleased(javafx.event.EventHandler) setOnMouseReleased} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnRotate(javafx.event.EventHandler) setOnRotate} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnRotationFinished(javafx.event.EventHandler) setOnRotationFinished} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnRotationStarted(javafx.event.EventHandler) setOnRotationStarted} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnScroll(javafx.event.EventHandler) setOnScroll} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnScrollFinished(javafx.event.EventHandler) setOnScrollFinished} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnScrollStarted(javafx.event.EventHandler) setOnScrollStarted} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnSwipeDown(javafx.event.EventHandler) setOnSwipeDown} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnSwipeLeft(javafx.event.EventHandler) setOnSwipeLeft} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnSwipeRight(javafx.event.EventHandler) setOnSwipeRight} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnSwipeUp(javafx.event.EventHandler) setOnSwipeUp} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnTouchMoved(javafx.event.EventHandler) setOnTouchMoved} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnTouchPressed(javafx.event.EventHandler) setOnTouchPressed} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnTouchReleased(javafx.event.EventHandler) setOnTouchReleased} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnTouchStationary(javafx.event.EventHandler) setOnTouchStationary} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnZoom(javafx.event.EventHandler) setOnZoom} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnZoomFinished(javafx.event.EventHandler) setOnZoomFinished} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOnZoomStarted(javafx.event.EventHandler) setOnZoomStarted} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOpacity(double) setOpacity} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setOpaqueInsets(javafx.geometry.Insets) setOpaqueInsets} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setPadding(javafx.geometry.Insets) setPadding} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setPickOnBounds(boolean) setPickOnBounds} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setPrefHeight(double) setPrefHeight} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setPrefSize(double, double) setPrefSize} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setPrefWidth(double) setPrefWidth} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setRotate(double) setRotate} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setRotationAxis(javafx.geometry.Point3D) setRotationAxis} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setScaleShape(boolean) setScaleShape} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setScaleX(double) setScaleX} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setScaleY(double) setScaleY} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setScaleZ(double) setScaleZ} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setShape(javafx.scene.shape.Shape) setShape} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setSnapToPixel(boolean) setSnapToPixel} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setStyle(java.lang.String) setStyle} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setTitle(java.lang.String) setTitle} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> title(java.lang.String value) {
        operations.add(obj -> obj.setTitle(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setTitleSide(javafx.geometry.Side) setTitleSide} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> titleSide(javafx.geometry.Side value) {
        operations.add(obj -> obj.setTitleSide(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setTranslateX(double) setTranslateX} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setTranslateY(double) setTranslateY} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setTranslateZ(double) setTranslateZ} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setUserData(java.lang.Object) setUserData} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setVerticalGridLinesVisible(boolean) setVerticalGridLinesVisible} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> verticalGridLinesVisible(boolean value) {
        operations.add(obj -> obj.setVerticalGridLinesVisible(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setVerticalZeroLineVisible(boolean) setVerticalZeroLineVisible} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> verticalZeroLineVisible(boolean value) {
        operations.add(obj -> obj.setVerticalZeroLineVisible(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setViewOrder(double) setViewOrder} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.chart.StackedAreaChart#setVisible(boolean) setVisible} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  StackedAreaChartBuilder<X, Y> visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.StackedAreaChart#getData()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final StackedAreaChartBuilder<X, Y> addData(javafx.scene.chart.XYChart.Series<X, Y>... elements) {
        operations.add(obj -> {
            obj.getData().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.StackedAreaChart#getData()} method.
     * 
     * @return builder instance
     */
    public final StackedAreaChartBuilder<X, Y> addData(java.util.Collection<? extends javafx.scene.chart.XYChart.Series<X, Y>> col) {
        operations.add(obj -> {
            obj.getData().addAll(col);
        });
        return this;
    }



    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.StackedAreaChart#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final StackedAreaChartBuilder<X, Y> addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.StackedAreaChart#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final StackedAreaChartBuilder<X, Y> addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }



    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.StackedAreaChart#getStylesheets()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final StackedAreaChartBuilder<X, Y> addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.StackedAreaChart#getStylesheets()} method.
     * 
     * @return builder instance
     */
    public final StackedAreaChartBuilder<X, Y> addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }



    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.StackedAreaChart#getTransforms()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final StackedAreaChartBuilder<X, Y> addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.chart.StackedAreaChart#getTransforms()} method.
     * 
     * @return builder instance
     */
    public final StackedAreaChartBuilder<X, Y> addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }


    
    /**
     * Utility setter to add CSS string for this StackedAreaChart's contents.
     * For example:
     * <pre>{@code
     * StackedAreaChartBuilder builder = StackedAreaChartBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();}
     * </pre>
     *
     * @param css CSS string
     */
    public StackedAreaChartBuilder<X, Y> addStylesheetsText(String css) {
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
    public StackedAreaChartBuilder<X, Y> bottomAnchorInAnchorPane(java.lang.Double value) {
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
    public StackedAreaChartBuilder<X, Y> leftAnchorInAnchorPane(java.lang.Double value) {
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
    public StackedAreaChartBuilder<X, Y> rightAnchorInAnchorPane(java.lang.Double value) {
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
    public StackedAreaChartBuilder<X, Y> topAnchorInAnchorPane(java.lang.Double value) {
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
    public StackedAreaChartBuilder<X, Y> alignmentInBorderPane(javafx.geometry.Pos value) {
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
    public StackedAreaChartBuilder<X, Y> marginInBorderPane(javafx.geometry.Insets value) {
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
    public StackedAreaChartBuilder<X, Y> marginInFlowPane(javafx.geometry.Insets value) {
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
    public StackedAreaChartBuilder<X, Y> columnIndexInGridPane(java.lang.Integer value) {
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
    public StackedAreaChartBuilder<X, Y> columnSpanInGridPane(java.lang.Integer value) {
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
    public StackedAreaChartBuilder<X, Y> constraintsInGridPane(int columnIndex, int rowIndex) {
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
    public StackedAreaChartBuilder<X, Y> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
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
    public StackedAreaChartBuilder<X, Y> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
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
    public StackedAreaChartBuilder<X, Y> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
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
    public StackedAreaChartBuilder<X, Y> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
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
    public StackedAreaChartBuilder<X, Y> fillHeightInGridPane(java.lang.Boolean value) {
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
    public StackedAreaChartBuilder<X, Y> fillWidthInGridPane(java.lang.Boolean value) {
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
    public StackedAreaChartBuilder<X, Y> hAlignmentInGridPane(javafx.geometry.HPos value) {
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
    public StackedAreaChartBuilder<X, Y> hGrowInGridPane(javafx.scene.layout.Priority value) {
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
    public StackedAreaChartBuilder<X, Y> marginInGridPane(javafx.geometry.Insets value) {
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
    public StackedAreaChartBuilder<X, Y> rowIndexInGridPane(java.lang.Integer value) {
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
    public StackedAreaChartBuilder<X, Y> rowSpanInGridPane(java.lang.Integer value) {
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
    public StackedAreaChartBuilder<X, Y> vAlignmentInGridPane(javafx.geometry.VPos value) {
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
    public StackedAreaChartBuilder<X, Y> vGrowInGridPane(javafx.scene.layout.Priority value) {
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
    public StackedAreaChartBuilder<X, Y> hGrowInHBox(javafx.scene.layout.Priority value) {
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
    public StackedAreaChartBuilder<X, Y> marginInHBox(javafx.geometry.Insets value) {
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
    public StackedAreaChartBuilder<X, Y> alignmentInStackPane(javafx.geometry.Pos value) {
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
    public StackedAreaChartBuilder<X, Y> marginInStackPane(javafx.geometry.Insets value) {
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
    public StackedAreaChartBuilder<X, Y> alignmentInTilePane(javafx.geometry.Pos value) {
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
    public StackedAreaChartBuilder<X, Y> marginInTilePane(javafx.geometry.Insets value) {
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
    public StackedAreaChartBuilder<X, Y> marginInVBox(javafx.geometry.Insets value) {
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
    public StackedAreaChartBuilder<X, Y> vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }
    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#accessibleHelpProperty() accessibleHelpProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.accessibleHelpProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .accessibleHelpPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#accessibleRoleDescriptionProperty() accessibleRoleDescriptionProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.accessibleRoleDescriptionProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .accessibleRoleDescriptionPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#accessibleRoleProperty() accessibleRoleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.accessibleRoleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .accessibleRolePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#accessibleTextProperty() accessibleTextProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.accessibleTextProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .accessibleTextPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#alternativeColumnFillVisibleProperty() alternativeColumnFillVisibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.alternativeColumnFillVisibleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .alternativeColumnFillVisiblePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> alternativeColumnFillVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.alternativeColumnFillVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#alternativeRowFillVisibleProperty() alternativeRowFillVisibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.alternativeRowFillVisibleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .alternativeRowFillVisiblePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> alternativeRowFillVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.alternativeRowFillVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#animatedProperty() animatedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.animatedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .animatedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> animatedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.animatedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#backgroundProperty() backgroundProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.backgroundProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .backgroundPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#blendModeProperty() blendModeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.blendModeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .blendModePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#borderProperty() borderProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.borderProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .borderPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#boundsInLocalProperty() boundsInLocalProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.boundsInLocalProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .boundsInLocalPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#boundsInParentProperty() boundsInParentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.boundsInParentProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .boundsInParentPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#cacheHintProperty() cacheHintProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.cacheHintProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .cacheHintPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#cacheProperty() cacheProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.cacheProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .cachePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#cacheShapeProperty() cacheShapeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.cacheShapeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .cacheShapePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#centerShapeProperty() centerShapeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.centerShapeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .centerShapePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#clipProperty() clipProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.clipProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .clipPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#createSymbolsProperty() createSymbolsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.createSymbolsProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .createSymbolsPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> createSymbolsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.createSymbolsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#cursorProperty() cursorProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.cursorProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .cursorPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#dataProperty() dataProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.dataProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .dataPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> dataPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.collections.ObservableList<javafx.scene.chart.XYChart.Series<X, Y>>>> op) {
        operations.add(obj -> op.accept(obj.dataProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#depthTestProperty() depthTestProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.depthTestProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .depthTestPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#disableProperty() disableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.disableProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .disablePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#disabledProperty() disabledProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.disabledProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .disabledPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#effectProperty() effectProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.effectProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .effectPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#effectiveNodeOrientationProperty() effectiveNodeOrientationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.effectiveNodeOrientationProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .effectiveNodeOrientationPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#eventDispatcherProperty() eventDispatcherProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.eventDispatcherProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .eventDispatcherPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#focusTraversableProperty() focusTraversableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.focusTraversableProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .focusTraversablePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#focusVisibleProperty() focusVisibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.focusVisibleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .focusVisiblePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#focusWithinProperty() focusWithinProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.focusWithinProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .focusWithinPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#focusedProperty() focusedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.focusedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .focusedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#heightProperty() heightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.heightProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .heightPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#horizontalGridLinesVisibleProperty() horizontalGridLinesVisibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.horizontalGridLinesVisibleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .horizontalGridLinesVisiblePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> horizontalGridLinesVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.horizontalGridLinesVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#horizontalZeroLineVisibleProperty() horizontalZeroLineVisibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.horizontalZeroLineVisibleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .horizontalZeroLineVisiblePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> horizontalZeroLineVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.horizontalZeroLineVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#hoverProperty() hoverProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.hoverProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .hoverPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#idProperty() idProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.idProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .idPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#inputMethodRequestsProperty() inputMethodRequestsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.inputMethodRequestsProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .inputMethodRequestsPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#insetsProperty() insetsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.insetsProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .insetsPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#layoutBoundsProperty() layoutBoundsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.layoutBoundsProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .layoutBoundsPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#layoutXProperty() layoutXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.layoutXProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .layoutXPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#layoutYProperty() layoutYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.layoutYProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .layoutYPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#legendSideProperty() legendSideProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.legendSideProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .legendSidePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> legendSidePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Side>> op) {
        operations.add(obj -> op.accept(obj.legendSideProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#legendVisibleProperty() legendVisibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.legendVisibleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .legendVisiblePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> legendVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.legendVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#localToParentTransformProperty() localToParentTransformProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.localToParentTransformProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .localToParentTransformPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#localToSceneTransformProperty() localToSceneTransformProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.localToSceneTransformProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .localToSceneTransformPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#managedProperty() managedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.managedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .managedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#maxHeightProperty() maxHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.maxHeightProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .maxHeightPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#maxWidthProperty() maxWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.maxWidthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .maxWidthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#minHeightProperty() minHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.minHeightProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .minHeightPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#minWidthProperty() minWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.minWidthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .minWidthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#mouseTransparentProperty() mouseTransparentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.mouseTransparentProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .mouseTransparentPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#needsLayoutProperty() needsLayoutProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.needsLayoutProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .needsLayoutPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#nodeOrientationProperty() nodeOrientationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.nodeOrientationProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .nodeOrientationPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onContextMenuRequestedProperty() onContextMenuRequestedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onContextMenuRequestedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onContextMenuRequestedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onDragDetectedProperty() onDragDetectedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onDragDetectedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onDragDetectedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onDragDoneProperty() onDragDoneProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onDragDoneProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onDragDonePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onDragDroppedProperty() onDragDroppedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onDragDroppedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onDragDroppedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onDragEnteredProperty() onDragEnteredProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onDragEnteredProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onDragEnteredPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onDragExitedProperty() onDragExitedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onDragExitedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onDragExitedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onDragOverProperty() onDragOverProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onDragOverProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onDragOverPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onInputMethodTextChangedProperty() onInputMethodTextChangedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onInputMethodTextChangedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onInputMethodTextChangedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onKeyPressedProperty() onKeyPressedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onKeyPressedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onKeyPressedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onKeyReleasedProperty() onKeyReleasedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onKeyReleasedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onKeyReleasedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onKeyTypedProperty() onKeyTypedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onKeyTypedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onKeyTypedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onMouseClickedProperty() onMouseClickedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onMouseClickedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onMouseClickedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onMouseDragEnteredProperty() onMouseDragEnteredProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onMouseDragEnteredProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onMouseDragEnteredPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onMouseDragExitedProperty() onMouseDragExitedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onMouseDragExitedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onMouseDragExitedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onMouseDragOverProperty() onMouseDragOverProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onMouseDragOverProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onMouseDragOverPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onMouseDragReleasedProperty() onMouseDragReleasedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onMouseDragReleasedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onMouseDragReleasedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onMouseDraggedProperty() onMouseDraggedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onMouseDraggedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onMouseDraggedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onMouseEnteredProperty() onMouseEnteredProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onMouseEnteredProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onMouseEnteredPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onMouseExitedProperty() onMouseExitedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onMouseExitedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onMouseExitedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onMouseMovedProperty() onMouseMovedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onMouseMovedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onMouseMovedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onMousePressedProperty() onMousePressedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onMousePressedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onMousePressedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onMouseReleasedProperty() onMouseReleasedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onMouseReleasedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onMouseReleasedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onRotateProperty() onRotateProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onRotateProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onRotatePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onRotationFinishedProperty() onRotationFinishedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onRotationFinishedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onRotationFinishedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onRotationStartedProperty() onRotationStartedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onRotationStartedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onRotationStartedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onScrollFinishedProperty() onScrollFinishedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onScrollFinishedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onScrollFinishedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onScrollProperty() onScrollProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onScrollProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onScrollPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onScrollStartedProperty() onScrollStartedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onScrollStartedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onScrollStartedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onSwipeDownProperty() onSwipeDownProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onSwipeDownProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onSwipeDownPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onSwipeLeftProperty() onSwipeLeftProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onSwipeLeftProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onSwipeLeftPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onSwipeRightProperty() onSwipeRightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onSwipeRightProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onSwipeRightPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onSwipeUpProperty() onSwipeUpProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onSwipeUpProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onSwipeUpPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onTouchMovedProperty() onTouchMovedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onTouchMovedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onTouchMovedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onTouchPressedProperty() onTouchPressedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onTouchPressedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onTouchPressedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onTouchReleasedProperty() onTouchReleasedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onTouchReleasedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onTouchReleasedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onTouchStationaryProperty() onTouchStationaryProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onTouchStationaryProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onTouchStationaryPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onZoomFinishedProperty() onZoomFinishedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onZoomFinishedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onZoomFinishedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onZoomProperty() onZoomProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onZoomProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onZoomPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#onZoomStartedProperty() onZoomStartedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onZoomStartedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onZoomStartedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#opacityProperty() opacityProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.opacityProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .opacityPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#opaqueInsetsProperty() opaqueInsetsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.opaqueInsetsProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .opaqueInsetsPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#paddingProperty() paddingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.paddingProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .paddingPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#parentProperty() parentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.parentProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .parentPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#pickOnBoundsProperty() pickOnBoundsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.pickOnBoundsProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .pickOnBoundsPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#prefHeightProperty() prefHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.prefHeightProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .prefHeightPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#prefWidthProperty() prefWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.prefWidthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .prefWidthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#pressedProperty() pressedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.pressedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .pressedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#rotateProperty() rotateProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.rotateProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .rotatePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#rotationAxisProperty() rotationAxisProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.rotationAxisProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .rotationAxisPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#scaleShapeProperty() scaleShapeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.scaleShapeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .scaleShapePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#scaleXProperty() scaleXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.scaleXProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .scaleXPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#scaleYProperty() scaleYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.scaleYProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .scaleYPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#scaleZProperty() scaleZProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.scaleZProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .scaleZPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#sceneProperty() sceneProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.sceneProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .scenePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#shapeProperty() shapeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.shapeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .shapePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#snapToPixelProperty() snapToPixelProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.snapToPixelProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .snapToPixelPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#styleProperty() styleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.styleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .stylePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#titleProperty() titleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.titleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .titlePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> titlePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.titleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#titleSideProperty() titleSideProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.titleSideProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .titleSidePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> titleSidePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Side>> op) {
        operations.add(obj -> op.accept(obj.titleSideProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#translateXProperty() translateXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.translateXProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .translateXPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#translateYProperty() translateYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.translateYProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .translateYPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#translateZProperty() translateZProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.translateZProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .translateZPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#verticalGridLinesVisibleProperty() verticalGridLinesVisibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.verticalGridLinesVisibleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .verticalGridLinesVisiblePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> verticalGridLinesVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.verticalGridLinesVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#verticalZeroLineVisibleProperty() verticalZeroLineVisibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.verticalZeroLineVisibleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .verticalZeroLineVisiblePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> verticalZeroLineVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.verticalZeroLineVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#viewOrderProperty() viewOrderProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.viewOrderProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .viewOrderPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#visibleProperty() visibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.visibleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .visiblePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.chart.StackedAreaChart#widthProperty() widthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.chart.StackedAreaChart<X, Y>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.widthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .widthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public StackedAreaChartBuilder<X, Y> widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
