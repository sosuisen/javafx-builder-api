
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code PieChartBuilder} class constructs instances of the {@link javafx.scene.chart.PieChart PieChart} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.chart.PieChart PieChart} constructor
 * and returns an instance of the {@code PieChartBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.chart.PieChart PieChart}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.chart.PieChart PieChart} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class PieChartBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.chart.PieChart>> operations = new java.util.ArrayList<>();
    private PieChartBuilder() {}
    
    /**
     * Returns an instance of the {@code PieChartBuilder}.
     *
     * @return an instance of the {@code PieChartBuilder}.
     */
    public static PieChartBuilder create() { return new PieChartBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.chart.PieChart#PieChart(javafx.collections.ObservableList) PieChart(ObservableList)}
     * and returns an instance of {@code PieChartBuilder}.
     *
     * @return an instance of the {@code PieChartBuilder}.
     */
    public static PieChartBuilder create(javafx.collections.ObservableList<javafx.scene.chart.PieChart.Data> data) {
        PieChartBuilder builder = new PieChartBuilder();
        builder.constructorArgs = new Object[]{data};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.chart.PieChart PieChart} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.chart.PieChart PieChart} class
     */
    public javafx.scene.chart.PieChart build() {
        javafx.scene.chart.PieChart newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.chart.PieChart();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.chart.PieChart> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.chart.PieChart callParameterizedConstructor() {
        javafx.scene.chart.PieChart newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.chart.PieChart.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.chart.PieChart) constructor.newInstance(constructorArgs);
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
     * Applies a function to the PieChart instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(pieChart -> pieChart.setId("Main" + pieChart.getTypeSelector()))
     * }</pre>
     *
     * @return builder instance
     *
     */
    public PieChartBuilder apply(java.util.function.Consumer<javafx.scene.chart.PieChart> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setAccessibleHelp(java.lang.String) setAccessibleHelp} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setAccessibleRole(javafx.scene.AccessibleRole) setAccessibleRole} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setAccessibleRoleDescription(java.lang.String) setAccessibleRoleDescription} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setAccessibleText(java.lang.String) setAccessibleText} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.Chart#setAnimated(boolean) setAnimated} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder animated(boolean value) {
        operations.add(obj -> obj.setAnimated(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.Region#setBackground(javafx.scene.layout.Background) setBackground} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setBlendMode(javafx.scene.effect.BlendMode) setBlendMode} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.Region#setBorder(javafx.scene.layout.Border) setBorder} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setCache(boolean) setCache} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setCacheHint(javafx.scene.CacheHint) setCacheHint} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.Region#setCacheShape(boolean) setCacheShape} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.Region#setCenterShape(boolean) setCenterShape} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setClip(javafx.scene.Node) setClip} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.PieChart#setClockwise(boolean) setClockwise} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder clockwise(boolean value) {
        operations.add(obj -> obj.setClockwise(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setCursor(javafx.scene.Cursor) setCursor} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.PieChart#setData(javafx.collections.ObservableList) setData} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder data(javafx.collections.ObservableList<javafx.scene.chart.PieChart.Data> value) {
        operations.add(obj -> obj.setData(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setDepthTest(javafx.scene.DepthTest) setDepthTest} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setDisable(boolean) setDisable} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setEffect(javafx.scene.effect.Effect) setEffect} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setEventDispatcher(javafx.event.EventDispatcher) setEventDispatcher} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setFocusTraversable(boolean) setFocusTraversable} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setId(java.lang.String) setId} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setInputMethodRequests(javafx.scene.input.InputMethodRequests) setInputMethodRequests} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.PieChart#setLabelLineLength(double) setLabelLineLength} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder labelLineLength(double value) {
        operations.add(obj -> obj.setLabelLineLength(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.PieChart#setLabelsVisible(boolean) setLabelsVisible} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder labelsVisible(boolean value) {
        operations.add(obj -> obj.setLabelsVisible(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setLayoutX(double) setLayoutX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setLayoutY(double) setLayoutY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.Chart#setLegendSide(javafx.geometry.Side) setLegendSide} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder legendSide(javafx.geometry.Side value) {
        operations.add(obj -> obj.setLegendSide(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.Chart#setLegendVisible(boolean) setLegendVisible} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder legendVisible(boolean value) {
        operations.add(obj -> obj.setLegendVisible(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setManaged(boolean) setManaged} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.Region#setMaxHeight(double) setMaxHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.Region#setMaxSize(double, double) setMaxSize} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.Region#setMaxWidth(double) setMaxWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.Region#setMinHeight(double) setMinHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.Region#setMinSize(double, double) setMinSize} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.Region#setMinWidth(double) setMinWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setMouseTransparent(boolean) setMouseTransparent} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setNodeOrientation(javafx.geometry.NodeOrientation) setNodeOrientation} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnContextMenuRequested(javafx.event.EventHandler) setOnContextMenuRequested} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnDragDetected(javafx.event.EventHandler) setOnDragDetected} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnDragDone(javafx.event.EventHandler) setOnDragDone} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnDragDropped(javafx.event.EventHandler) setOnDragDropped} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnDragEntered(javafx.event.EventHandler) setOnDragEntered} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnDragExited(javafx.event.EventHandler) setOnDragExited} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnDragOver(javafx.event.EventHandler) setOnDragOver} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnInputMethodTextChanged(javafx.event.EventHandler) setOnInputMethodTextChanged} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnKeyPressed(javafx.event.EventHandler) setOnKeyPressed} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnKeyReleased(javafx.event.EventHandler) setOnKeyReleased} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnKeyTyped(javafx.event.EventHandler) setOnKeyTyped} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnMouseClicked(javafx.event.EventHandler) setOnMouseClicked} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnMouseDragEntered(javafx.event.EventHandler) setOnMouseDragEntered} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnMouseDragExited(javafx.event.EventHandler) setOnMouseDragExited} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnMouseDragOver(javafx.event.EventHandler) setOnMouseDragOver} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnMouseDragReleased(javafx.event.EventHandler) setOnMouseDragReleased} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnMouseDragged(javafx.event.EventHandler) setOnMouseDragged} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnMouseEntered(javafx.event.EventHandler) setOnMouseEntered} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnMouseExited(javafx.event.EventHandler) setOnMouseExited} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnMouseMoved(javafx.event.EventHandler) setOnMouseMoved} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnMousePressed(javafx.event.EventHandler) setOnMousePressed} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnMouseReleased(javafx.event.EventHandler) setOnMouseReleased} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnRotate(javafx.event.EventHandler) setOnRotate} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnRotationFinished(javafx.event.EventHandler) setOnRotationFinished} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnRotationStarted(javafx.event.EventHandler) setOnRotationStarted} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnScroll(javafx.event.EventHandler) setOnScroll} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnScrollFinished(javafx.event.EventHandler) setOnScrollFinished} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnScrollStarted(javafx.event.EventHandler) setOnScrollStarted} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnSwipeDown(javafx.event.EventHandler) setOnSwipeDown} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnSwipeLeft(javafx.event.EventHandler) setOnSwipeLeft} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnSwipeRight(javafx.event.EventHandler) setOnSwipeRight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnSwipeUp(javafx.event.EventHandler) setOnSwipeUp} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnTouchMoved(javafx.event.EventHandler) setOnTouchMoved} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnTouchPressed(javafx.event.EventHandler) setOnTouchPressed} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnTouchReleased(javafx.event.EventHandler) setOnTouchReleased} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnTouchStationary(javafx.event.EventHandler) setOnTouchStationary} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnZoom(javafx.event.EventHandler) setOnZoom} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnZoomFinished(javafx.event.EventHandler) setOnZoomFinished} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOnZoomStarted(javafx.event.EventHandler) setOnZoomStarted} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setOpacity(double) setOpacity} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.Region#setOpaqueInsets(javafx.geometry.Insets) setOpaqueInsets} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.Region#setPadding(javafx.geometry.Insets) setPadding} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setPickOnBounds(boolean) setPickOnBounds} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.Region#setPrefHeight(double) setPrefHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.Region#setPrefSize(double, double) setPrefSize} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.Region#setPrefWidth(double) setPrefWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setRotate(double) setRotate} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setRotationAxis(javafx.geometry.Point3D) setRotationAxis} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.Region#setScaleShape(boolean) setScaleShape} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setScaleX(double) setScaleX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setScaleY(double) setScaleY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setScaleZ(double) setScaleZ} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.Region#setShape(javafx.scene.shape.Shape) setShape} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.Region#setSnapToPixel(boolean) setSnapToPixel} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.PieChart#setStartAngle(double) setStartAngle} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder startAngle(double value) {
        operations.add(obj -> obj.setStartAngle(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setStyle(java.lang.String) setStyle} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.Chart#setTitle(java.lang.String) setTitle} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder title(java.lang.String value) {
        operations.add(obj -> obj.setTitle(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.chart.Chart#setTitleSide(javafx.geometry.Side) setTitleSide} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder titleSide(javafx.geometry.Side value) {
        operations.add(obj -> obj.setTitleSide(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setTranslateX(double) setTranslateX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setTranslateY(double) setTranslateY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setTranslateZ(double) setTranslateZ} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setUserData(java.lang.Object) setUserData} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setViewOrder(double) setViewOrder} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.Node#setVisible(boolean) setVisible} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PieChartBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(java.lang.Object[]) addAll} method on the ObservableList
     * returned by the {@link javafx.scene.chart.PieChart#getData() PieChart#getData()} method.
     * 
     * @return builder instance
     */
    public final PieChartBuilder addData(javafx.scene.chart.PieChart.Data... elements) {
        operations.add(obj -> obj.getData().addAll(elements));
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(java.util.Collection) addAll} method on the ObservableList
     * returned by the {@link javafx.scene.chart.PieChart#getData() PieChart#getData()} method.
     * 
     * @return builder instance
     */
    public final PieChartBuilder addData(java.util.Collection<? extends javafx.scene.chart.PieChart.Data> col) {
        operations.add(obj -> obj.getData().addAll(col));
        return this;
    }

    /**
     * Creates an instance of the builder, then calls the {@link javafx.collections.ObservableList#addAll(java.lang.Object[]) addAll} method on the ObservableList
     * returned by the {@link javafx.scene.chart.PieChart#getData() PieChart#getData()} method.
     * 
     * @return builder instance
     */
    public static PieChartBuilder withData(javafx.scene.chart.PieChart.Data... elements) {
        PieChartBuilder builder = new PieChartBuilder();
        return builder.addData(elements);
    }

    /**
     * Creates an instance of the builder, then calls the {@link java.util.List#addAll(java.util.Collection) addAll} method on the ObservableList
     * returned by the {@link javafx.scene.chart.PieChart#getData() PieChart#getData()} method.
     * 
     * @return builder instance
     */
    public static PieChartBuilder withData(java.util.Collection<? extends javafx.scene.chart.PieChart.Data> col) {
        PieChartBuilder builder = new PieChartBuilder();
        return builder.addData(col);
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(java.lang.Object[]) addAll} method on the ObservableList
     * returned by the {@link javafx.scene.Node#getStyleClass() PieChart#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final PieChartBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> obj.getStyleClass().addAll(elements));
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(java.util.Collection) addAll} method on the ObservableList
     * returned by the {@link javafx.scene.Node#getStyleClass() PieChart#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final PieChartBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> obj.getStyleClass().addAll(col));
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(java.lang.Object[]) addAll} method on the ObservableList
     * returned by the {@link javafx.scene.Parent#getStylesheets() PieChart#getStylesheets()} method.
     * 
     * @return builder instance
     */
    public final PieChartBuilder addStylesheets(java.lang.String... elements) {
        operations.add(obj -> obj.getStylesheets().addAll(elements));
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(java.util.Collection) addAll} method on the ObservableList
     * returned by the {@link javafx.scene.Parent#getStylesheets() PieChart#getStylesheets()} method.
     * 
     * @return builder instance
     */
    public final PieChartBuilder addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> obj.getStylesheets().addAll(col));
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(java.lang.Object[]) addAll} method on the ObservableList
     * returned by the {@link javafx.scene.Node#getTransforms() PieChart#getTransforms()} method.
     * 
     * @return builder instance
     */
    public final PieChartBuilder addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> obj.getTransforms().addAll(elements));
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(java.util.Collection) addAll} method on the ObservableList
     * returned by the {@link javafx.scene.Node#getTransforms() PieChart#getTransforms()} method.
     * 
     * @return builder instance
     */
    public final PieChartBuilder addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> obj.getTransforms().addAll(col));
        return this;
    }    
    /**
     * Utility setter to add CSS string for this PieChart's contents.
     * For example:
     * <pre>{@code
     * PieChartBuilder builder = PieChartBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();}
     * </pre>
     *
     * @param css CSS string
     */
    public PieChartBuilder addStylesheetsText(String css) {
        operations.add(obj -> obj.getStylesheets().addAll("data:text/css;base64," +
                java.util.Base64.getEncoder().encodeToString(css.getBytes())));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.AnchorPane#setBottomAnchor(javafx.scene.Node child, java.lang.Double value) AnchorPane.setBottomAnchor(Node, Double)} 
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
     *                  ButtonBuilder.create()
     *                      .bottomAnchorInAnchorPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.AnchorPane#setLeftAnchor(javafx.scene.Node child, java.lang.Double value) AnchorPane.setLeftAnchor(Node, Double)} 
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
     *                  ButtonBuilder.create()
     *                      .leftAnchorInAnchorPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.AnchorPane#setRightAnchor(javafx.scene.Node child, java.lang.Double value) AnchorPane.setRightAnchor(Node, Double)} 
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
     *                  ButtonBuilder.create()
     *                      .rightAnchorInAnchorPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.AnchorPane#setTopAnchor(javafx.scene.Node child, java.lang.Double value) AnchorPane.setTopAnchor(Node, Double)} 
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
     *                  ButtonBuilder.create()
     *                      .topAnchorInAnchorPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.BorderPane#setAlignment(javafx.scene.Node child, javafx.geometry.Pos value) BorderPane.setAlignment(Node, Pos)} 
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
     *                  ButtonBuilder.create()
     *                      .alignmentInBorderPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.BorderPane#setMargin(javafx.scene.Node child, javafx.geometry.Insets value) BorderPane.setMargin(Node, Insets)} 
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
     *                  ButtonBuilder.create()
     *                      .marginInBorderPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.FlowPane#setMargin(javafx.scene.Node child, javafx.geometry.Insets value) FlowPane.setMargin(Node, Insets)} 
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
     *                  ButtonBuilder.create()
     *                      .marginInFlowPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setColumnIndex(javafx.scene.Node child, java.lang.Integer value) GridPane.setColumnIndex(Node, Integer)} 
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
     *                  ButtonBuilder.create()
     *                      .columnIndexInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setColumnSpan(javafx.scene.Node child, java.lang.Integer value) GridPane.setColumnSpan(Node, Integer)} 
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
     *                  ButtonBuilder.create()
     *                      .columnSpanInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setConstraints(javafx.scene.Node child, int columnIndex, int rowIndex) GridPane.setConstraints(Node, int, int)} 
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
     *                  ButtonBuilder.create()
     *                      .constraintsInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setConstraints(javafx.scene.Node child, int columnIndex, int rowIndex, int columnspan, int rowspan) GridPane.setConstraints(Node, int, int, int, int)} 
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
     *                  ButtonBuilder.create()
     *                      .constraintsInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setConstraints(javafx.scene.Node child, int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) GridPane.setConstraints(Node, int, int, int, int, HPos, VPos)} 
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
     *                  ButtonBuilder.create()
     *                      .constraintsInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setConstraints(javafx.scene.Node child, int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) GridPane.setConstraints(Node, int, int, int, int, HPos, VPos, Priority, Priority)} 
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
     *                  ButtonBuilder.create()
     *                      .constraintsInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setConstraints(javafx.scene.Node child, int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) GridPane.setConstraints(Node, int, int, int, int, HPos, VPos, Priority, Priority, Insets)} 
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
     *                  ButtonBuilder.create()
     *                      .constraintsInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setFillHeight(javafx.scene.Node child, java.lang.Boolean value) GridPane.setFillHeight(Node, Boolean)} 
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
     *                  ButtonBuilder.create()
     *                      .fillHeightInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setFillWidth(javafx.scene.Node child, java.lang.Boolean value) GridPane.setFillWidth(Node, Boolean)} 
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
     *                  ButtonBuilder.create()
     *                      .fillWidthInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setHalignment(javafx.scene.Node child, javafx.geometry.HPos value) GridPane.setHalignment(Node, HPos)} 
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
     *                  ButtonBuilder.create()
     *                      .hAlignmentInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setHgrow(javafx.scene.Node child, javafx.scene.layout.Priority value) GridPane.setHgrow(Node, Priority)} 
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
     *                  ButtonBuilder.create()
     *                      .hGrowInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setMargin(javafx.scene.Node child, javafx.geometry.Insets value) GridPane.setMargin(Node, Insets)} 
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
     *                  ButtonBuilder.create()
     *                      .marginInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setRowIndex(javafx.scene.Node child, java.lang.Integer value) GridPane.setRowIndex(Node, Integer)} 
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
     *                  ButtonBuilder.create()
     *                      .rowIndexInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setRowSpan(javafx.scene.Node child, java.lang.Integer value) GridPane.setRowSpan(Node, Integer)} 
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
     *                  ButtonBuilder.create()
     *                      .rowSpanInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setValignment(javafx.scene.Node child, javafx.geometry.VPos value) GridPane.setValignment(Node, VPos)} 
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
     *                  ButtonBuilder.create()
     *                      .vAlignmentInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.GridPane#setVgrow(javafx.scene.Node child, javafx.scene.layout.Priority value) GridPane.setVgrow(Node, Priority)} 
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
     *                  ButtonBuilder.create()
     *                      .vGrowInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.HBox#setHgrow(javafx.scene.Node child, javafx.scene.layout.Priority value) HBox.setHgrow(Node, Priority)} 
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
     *                  ButtonBuilder.create()
     *                      .hGrowInHBox(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.HBox#setMargin(javafx.scene.Node child, javafx.geometry.Insets value) HBox.setMargin(Node, Insets)} 
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
     *                  ButtonBuilder.create()
     *                      .marginInHBox(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.StackPane#setAlignment(javafx.scene.Node child, javafx.geometry.Pos value) StackPane.setAlignment(Node, Pos)} 
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
     *                  ButtonBuilder.create()
     *                      .alignmentInStackPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.StackPane#setMargin(javafx.scene.Node child, javafx.geometry.Insets value) StackPane.setMargin(Node, Insets)} 
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
     *                  ButtonBuilder.create()
     *                      .marginInStackPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.TilePane#setAlignment(javafx.scene.Node child, javafx.geometry.Pos value) TilePane.setAlignment(Node, Pos)} 
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
     *                  ButtonBuilder.create()
     *                      .alignmentInTilePane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.TilePane#setMargin(javafx.scene.Node child, javafx.geometry.Insets value) TilePane.setMargin(Node, Insets)} 
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
     *                  ButtonBuilder.create()
     *                      .marginInTilePane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.VBox#setMargin(javafx.scene.Node child, javafx.geometry.Insets value) VBox.setMargin(Node, Insets)} 
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
     *                  ButtonBuilder.create()
     *                      .marginInVBox(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }

    /**
     * Invokes the {@link javafx.scene.layout.VBox#setVgrow(javafx.scene.Node child, javafx.scene.layout.Priority value) VBox.setVgrow(Node, Priority)} 
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
     *                  ButtonBuilder.create()
     *                      .vGrowInVBox(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public PieChartBuilder vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }


    /**
     * Applies a function to the {@link javafx.scene.Node#accessibleHelpProperty() accessibleHelpProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#accessibleRoleDescriptionProperty() accessibleRoleDescriptionProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#accessibleRoleProperty() accessibleRoleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#accessibleTextProperty() accessibleTextProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.Chart#animatedProperty() animatedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder animatedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.animatedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.Region#backgroundProperty() backgroundProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#blendModeProperty() blendModeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.Region#borderProperty() borderProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#boundsInLocalProperty() boundsInLocalProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#boundsInParentProperty() boundsInParentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#cacheHintProperty() cacheHintProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#cacheProperty() cacheProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.Region#cacheShapeProperty() cacheShapeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.Region#centerShapeProperty() centerShapeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#clipProperty() clipProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.PieChart#clockwiseProperty() clockwiseProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.clockwiseProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .clockwisePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public PieChartBuilder clockwisePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.clockwiseProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#cursorProperty() cursorProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.PieChart#dataProperty() dataProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder dataPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.collections.ObservableList<javafx.scene.chart.PieChart.Data>>> op) {
        operations.add(obj -> op.accept(obj.dataProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#depthTestProperty() depthTestProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#disableProperty() disableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#disabledProperty() disabledProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#effectProperty() effectProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#effectiveNodeOrientationProperty() effectiveNodeOrientationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#eventDispatcherProperty() eventDispatcherProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#focusTraversableProperty() focusTraversableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#focusVisibleProperty() focusVisibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#focusWithinProperty() focusWithinProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#focusedProperty() focusedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.Region#heightProperty() heightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#hoverProperty() hoverProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#idProperty() idProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#inputMethodRequestsProperty() inputMethodRequestsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.Region#insetsProperty() insetsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.PieChart#labelLineLengthProperty() labelLineLengthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.labelLineLengthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .labelLineLengthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public PieChartBuilder labelLineLengthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.labelLineLengthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.PieChart#labelsVisibleProperty() labelsVisibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.labelsVisibleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .labelsVisiblePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public PieChartBuilder labelsVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.labelsVisibleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#layoutBoundsProperty() layoutBoundsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#layoutXProperty() layoutXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#layoutYProperty() layoutYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.Chart#legendSideProperty() legendSideProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder legendSidePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Side>> op) {
        operations.add(obj -> op.accept(obj.legendSideProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.Chart#legendVisibleProperty() legendVisibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder legendVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.legendVisibleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#localToParentTransformProperty() localToParentTransformProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#localToSceneTransformProperty() localToSceneTransformProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#managedProperty() managedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.Region#maxHeightProperty() maxHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.Region#maxWidthProperty() maxWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.Region#minHeightProperty() minHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.Region#minWidthProperty() minWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#mouseTransparentProperty() mouseTransparentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Parent#needsLayoutProperty() needsLayoutProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#nodeOrientationProperty() nodeOrientationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onContextMenuRequestedProperty() onContextMenuRequestedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onDragDetectedProperty() onDragDetectedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onDragDoneProperty() onDragDoneProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onDragDroppedProperty() onDragDroppedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onDragEnteredProperty() onDragEnteredProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onDragExitedProperty() onDragExitedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onDragOverProperty() onDragOverProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onInputMethodTextChangedProperty() onInputMethodTextChangedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onKeyPressedProperty() onKeyPressedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onKeyReleasedProperty() onKeyReleasedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onKeyTypedProperty() onKeyTypedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onMouseClickedProperty() onMouseClickedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onMouseDragEnteredProperty() onMouseDragEnteredProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onMouseDragExitedProperty() onMouseDragExitedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onMouseDragOverProperty() onMouseDragOverProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onMouseDragReleasedProperty() onMouseDragReleasedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onMouseDraggedProperty() onMouseDraggedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onMouseEnteredProperty() onMouseEnteredProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onMouseExitedProperty() onMouseExitedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onMouseMovedProperty() onMouseMovedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onMousePressedProperty() onMousePressedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onMouseReleasedProperty() onMouseReleasedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onRotateProperty() onRotateProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onRotationFinishedProperty() onRotationFinishedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onRotationStartedProperty() onRotationStartedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onScrollFinishedProperty() onScrollFinishedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onScrollProperty() onScrollProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onScrollStartedProperty() onScrollStartedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onSwipeDownProperty() onSwipeDownProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onSwipeLeftProperty() onSwipeLeftProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onSwipeRightProperty() onSwipeRightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onSwipeUpProperty() onSwipeUpProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onTouchMovedProperty() onTouchMovedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onTouchPressedProperty() onTouchPressedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onTouchReleasedProperty() onTouchReleasedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onTouchStationaryProperty() onTouchStationaryProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onZoomFinishedProperty() onZoomFinishedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onZoomProperty() onZoomProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#onZoomStartedProperty() onZoomStartedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#opacityProperty() opacityProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.Region#opaqueInsetsProperty() opaqueInsetsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.Region#paddingProperty() paddingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#parentProperty() parentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#pickOnBoundsProperty() pickOnBoundsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.Region#prefHeightProperty() prefHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.Region#prefWidthProperty() prefWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#pressedProperty() pressedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#rotateProperty() rotateProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#rotationAxisProperty() rotationAxisProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.Region#scaleShapeProperty() scaleShapeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#scaleXProperty() scaleXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#scaleYProperty() scaleYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#scaleZProperty() scaleZProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#sceneProperty() sceneProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.Region#shapeProperty() shapeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.Region#snapToPixelProperty() snapToPixelProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.PieChart#startAngleProperty() startAngleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.startAngleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .startAnglePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public PieChartBuilder startAnglePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.startAngleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#styleProperty() styleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.Chart#titleProperty() titleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder titlePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.titleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.chart.Chart#titleSideProperty() titleSideProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder titleSidePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Side>> op) {
        operations.add(obj -> op.accept(obj.titleSideProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#translateXProperty() translateXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#translateYProperty() translateYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#translateZProperty() translateZProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#viewOrderProperty() viewOrderProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.Node#visibleProperty() visibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.Region#widthProperty() widthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PieChartBuilder#apply(java.util.function.Consumer) apply} method.
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
    public PieChartBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
