
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code FlowPaneBuilder} class constructs instances of the {@link javafx.scene.layout.FlowPane FlowPane} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.layout.FlowPane FlowPane} constructor
 * and returns an instance of the {@code FlowPaneBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.layout.FlowPane FlowPane}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.layout.FlowPane FlowPane} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class FlowPaneBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.layout.FlowPane>> operations = new java.util.ArrayList<>();
    private FlowPaneBuilder() {}
    

    /**
     * Returns an instance of the {@code FlowPaneBuilder}.
     *
     * @return an instance of the {@code FlowPaneBuilder}.
     */
    public static FlowPaneBuilder create() { return new FlowPaneBuilder(); }


    /**
     * Accepts the same arguments as {@link javafx.scene.layout.FlowPane#FlowPane(double hgap, double vgap) FlowPane(double, double)}
     * and returns an instance of the {@code FlowPaneBuilder}.
     *
     * @return an instance of the {@code FlowPaneBuilder}.
     */
    
    public static FlowPaneBuilder create(double hgap, double vgap) {
        FlowPaneBuilder builder = new FlowPaneBuilder();
        builder.constructorArgs = new Object[]{hgap, vgap};
        return builder;
    }


    /**
     * Accepts the same arguments as {@link javafx.scene.layout.FlowPane#FlowPane(double hgap, double vgap, javafx.scene.Node... children) FlowPane(double, double, Node...)}
     * and returns an instance of the {@code FlowPaneBuilder}.
     *
     * @return an instance of the {@code FlowPaneBuilder}.
     */
    @SafeVarargs
    public static FlowPaneBuilder create(double hgap, double vgap, javafx.scene.Node... children) {
        FlowPaneBuilder builder = new FlowPaneBuilder();
        builder.constructorArgs = new Object[]{hgap, vgap, children};
        return builder;
    }


    /**
     * Accepts the same arguments as {@link javafx.scene.layout.FlowPane#FlowPane(javafx.geometry.Orientation orientation) FlowPane(Orientation)}
     * and returns an instance of the {@code FlowPaneBuilder}.
     *
     * @return an instance of the {@code FlowPaneBuilder}.
     */
    
    public static FlowPaneBuilder create(javafx.geometry.Orientation orientation) {
        FlowPaneBuilder builder = new FlowPaneBuilder();
        builder.constructorArgs = new Object[]{orientation};
        return builder;
    }


    /**
     * Accepts the same arguments as {@link javafx.scene.layout.FlowPane#FlowPane(javafx.geometry.Orientation orientation, double hgap, double vgap) FlowPane(Orientation, double, double)}
     * and returns an instance of the {@code FlowPaneBuilder}.
     *
     * @return an instance of the {@code FlowPaneBuilder}.
     */
    
    public static FlowPaneBuilder create(javafx.geometry.Orientation orientation, double hgap, double vgap) {
        FlowPaneBuilder builder = new FlowPaneBuilder();
        builder.constructorArgs = new Object[]{orientation, hgap, vgap};
        return builder;
    }


    /**
     * Accepts the same arguments as {@link javafx.scene.layout.FlowPane#FlowPane(javafx.geometry.Orientation orientation, double hgap, double vgap, javafx.scene.Node... children) FlowPane(Orientation, double, double, Node...)}
     * and returns an instance of the {@code FlowPaneBuilder}.
     *
     * @return an instance of the {@code FlowPaneBuilder}.
     */
    @SafeVarargs
    public static FlowPaneBuilder create(javafx.geometry.Orientation orientation, double hgap, double vgap, javafx.scene.Node... children) {
        FlowPaneBuilder builder = new FlowPaneBuilder();
        builder.constructorArgs = new Object[]{orientation, hgap, vgap, children};
        return builder;
    }


    /**
     * Accepts the same arguments as {@link javafx.scene.layout.FlowPane#FlowPane(javafx.geometry.Orientation orientation, javafx.scene.Node... children) FlowPane(Orientation, Node...)}
     * and returns an instance of the {@code FlowPaneBuilder}.
     *
     * @return an instance of the {@code FlowPaneBuilder}.
     */
    @SafeVarargs
    public static FlowPaneBuilder create(javafx.geometry.Orientation orientation, javafx.scene.Node... children) {
        FlowPaneBuilder builder = new FlowPaneBuilder();
        builder.constructorArgs = new Object[]{orientation, children};
        return builder;
    }


    /**
     * Accepts the same arguments as {@link javafx.scene.layout.FlowPane#FlowPane(javafx.scene.Node... children) FlowPane(Node...)}
     * and returns an instance of the {@code FlowPaneBuilder}.
     *
     * @return an instance of the {@code FlowPaneBuilder}.
     */
    @SafeVarargs
    public static FlowPaneBuilder create(javafx.scene.Node... children) {
        FlowPaneBuilder builder = new FlowPaneBuilder();
        builder.constructorArgs = new Object[]{children};
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
     * @return new instance of the {@link javafx.scene.layout.FlowPane FlowPane} class
     */
    public javafx.scene.layout.FlowPane build() {
        javafx.scene.layout.FlowPane newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.layout.FlowPane();

        } else {
            newInstance = callParameterizedConstructor();
        }


        newInstance.getStyleClass().add(".flow-pane");

        for (java.util.function.Consumer<javafx.scene.layout.FlowPane> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.layout.FlowPane callParameterizedConstructor() {
        javafx.scene.layout.FlowPane newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.layout.FlowPane.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.layout.FlowPane) constructor.newInstance(constructorArgs);
                    break;
                }
            }
            if (newInstance == null) {
                throw new RuntimeException("No suitable constructor found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance", e);
        }

        newInstance.getStyleClass().add(".flow-pane");

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
     * Applies a function to the FlowPane instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(flowPane -> flowPane.setId("Main" + flowPane.getTypeSelector()))
     * }</pre>
     *
     * @return builder instance
     *
     */
    public FlowPaneBuilder apply(java.util.function.Consumer<javafx.scene.layout.FlowPane> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setAlignment(javafx.geometry.Pos)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder alignment(javafx.geometry.Pos value) {
        operations.add(obj -> obj.setAlignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setBackground(javafx.scene.layout.Background)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setBorder(javafx.scene.layout.Border)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setCacheShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setCenterShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setColumnHalignment(javafx.geometry.HPos)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder columnHalignment(javafx.geometry.HPos value) {
        operations.add(obj -> obj.setColumnHalignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setHgap(double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder hgap(double value) {
        operations.add(obj -> obj.setHgap(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOpaqueInsets(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setOrientation(javafx.geometry.Orientation)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder orientation(javafx.geometry.Orientation value) {
        operations.add(obj -> obj.setOrientation(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setPadding(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setPrefWrapLength(double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder prefWrapLength(double value) {
        operations.add(obj -> obj.setPrefWrapLength(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setRowValignment(javafx.geometry.VPos)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder rowValignment(javafx.geometry.VPos value) {
        operations.add(obj -> obj.setRowValignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setScaleShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setShape(javafx.scene.shape.Shape)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setSnapToPixel(boolean)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setVgap(double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder vgap(double value) {
        operations.add(obj -> obj.setVgap(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.FlowPane#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  FlowPaneBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.layout.FlowPane#getChildren()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final FlowPaneBuilder addChildren(javafx.scene.Node... elements) {
        operations.add(obj -> {
            obj.getChildren().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.layout.FlowPane#getChildren()} method.
     * 
     * @return builder instance
     */
    public final FlowPaneBuilder addChildren(java.util.Collection<? extends javafx.scene.Node> col) {
        operations.add(obj -> {
            obj.getChildren().addAll(col);
        });
        return this;
    }


    /**
     * Create an instance of the builder, then call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.layout.FlowPane#getChildren()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public static FlowPaneBuilder withChildren(javafx.scene.Node... elements) {
        FlowPaneBuilder builder = new FlowPaneBuilder();
        return builder.addChildren(elements);
    }

    /**
     * Create an instance of the builder, then call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.layout.FlowPane#getChildren()} method.
     * 
     * @return builder instance
     */
    public static FlowPaneBuilder withChildren(java.util.Collection<? extends javafx.scene.Node> col) {
        FlowPaneBuilder builder = new FlowPaneBuilder();
        return builder.addChildren(col);
    }


    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.layout.FlowPane#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final FlowPaneBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.layout.FlowPane#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final FlowPaneBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.layout.FlowPane#getStylesheets()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final FlowPaneBuilder addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.layout.FlowPane#getStylesheets()} method.
     * 
     * @return builder instance
     */
    public final FlowPaneBuilder addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.layout.FlowPane#getTransforms()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final FlowPaneBuilder addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.layout.FlowPane#getTransforms()} method.
     * 
     * @return builder instance
     */
    public final FlowPaneBuilder addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }


    
    /**
     * Utility setter to add CSS string for this FlowPane's contents.
     * For example:
     * <pre>
     * FlowPaneBuilder builder = FlowPaneBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();
     * </pre>
     *
     * @param css CSS string
     */
    public FlowPaneBuilder addStylesheetsText(String css) {
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
    public FlowPaneBuilder bottomAnchorInAnchorPane(java.lang.Double value) {
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
    public FlowPaneBuilder leftAnchorInAnchorPane(java.lang.Double value) {
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
    public FlowPaneBuilder rightAnchorInAnchorPane(java.lang.Double value) {
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
    public FlowPaneBuilder topAnchorInAnchorPane(java.lang.Double value) {
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
    public FlowPaneBuilder alignmentInBorderPane(javafx.geometry.Pos value) {
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
    public FlowPaneBuilder marginInBorderPane(javafx.geometry.Insets value) {
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
    public FlowPaneBuilder marginInFlowPane(javafx.geometry.Insets value) {
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
    public FlowPaneBuilder columnIndexInGridPane(java.lang.Integer value) {
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
    public FlowPaneBuilder columnSpanInGridPane(java.lang.Integer value) {
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
    public FlowPaneBuilder constraintsInGridPane(int columnIndex, int rowIndex) {
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
    public FlowPaneBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
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
    public FlowPaneBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
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
    public FlowPaneBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
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
    public FlowPaneBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
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
    public FlowPaneBuilder fillHeightInGridPane(java.lang.Boolean value) {
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
    public FlowPaneBuilder fillWidthInGridPane(java.lang.Boolean value) {
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
    public FlowPaneBuilder hAlignmentInGridPane(javafx.geometry.HPos value) {
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
    public FlowPaneBuilder hGrowInGridPane(javafx.scene.layout.Priority value) {
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
    public FlowPaneBuilder marginInGridPane(javafx.geometry.Insets value) {
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
    public FlowPaneBuilder rowIndexInGridPane(java.lang.Integer value) {
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
    public FlowPaneBuilder rowSpanInGridPane(java.lang.Integer value) {
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
    public FlowPaneBuilder vAlignmentInGridPane(javafx.geometry.VPos value) {
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
    public FlowPaneBuilder vGrowInGridPane(javafx.scene.layout.Priority value) {
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
    public FlowPaneBuilder hGrowInHBox(javafx.scene.layout.Priority value) {
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
    public FlowPaneBuilder marginInHBox(javafx.geometry.Insets value) {
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
    public FlowPaneBuilder alignmentInStackPane(javafx.geometry.Pos value) {
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
    public FlowPaneBuilder marginInStackPane(javafx.geometry.Insets value) {
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
    public FlowPaneBuilder alignmentInTilePane(javafx.geometry.Pos value) {
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
    public FlowPaneBuilder marginInTilePane(javafx.geometry.Insets value) {
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
    public FlowPaneBuilder marginInVBox(javafx.geometry.Insets value) {
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
    public FlowPaneBuilder vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }
    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#alignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder alignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Pos>> op) {
        operations.add(obj -> op.accept(obj.alignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#backgroundProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#borderProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#cacheShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#centerShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#columnHalignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder columnHalignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.HPos>> op) {
        operations.add(obj -> op.accept(obj.columnHalignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#hgapProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder hgapPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.hgapProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#insetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#needsLayoutProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#opaqueInsetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#orientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder orientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Orientation>> op) {
        operations.add(obj -> op.accept(obj.orientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#paddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#prefWrapLengthProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder prefWrapLengthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWrapLengthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#rowValignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder rowValignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.VPos>> op) {
        operations.add(obj -> op.accept(obj.rowValignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#scaleShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#shapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#snapToPixelProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#vgapProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder vgapPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.vgapProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.FlowPane#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public FlowPaneBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
