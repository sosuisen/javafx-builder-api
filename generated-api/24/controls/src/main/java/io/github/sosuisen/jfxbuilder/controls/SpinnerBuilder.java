
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code SpinnerBuilder} class constructs instances of the {@link javafx.scene.control.Spinner Spinner} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.Spinner Spinner} constructor
 * and returns an instance of the {@code SpinnerBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.Spinner Spinner}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.Spinner Spinner} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class SpinnerBuilder<T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.Spinner<T>>> operations = new java.util.ArrayList<>();
    private SpinnerBuilder() {}
    

    public static <T> SpinnerBuilder<T> create() { return new SpinnerBuilder<T>(); }


    
    public static <T> SpinnerBuilder<T> create(double min, double max, double initialValue) {
        SpinnerBuilder<T> builder = new SpinnerBuilder<T>();
        builder.constructorArgs = new Object[]{min, max, initialValue};
        return builder;
    }


    
    public static <T> SpinnerBuilder<T> create(double min, double max, double initialValue, double amountToStepBy) {
        SpinnerBuilder<T> builder = new SpinnerBuilder<T>();
        builder.constructorArgs = new Object[]{min, max, initialValue, amountToStepBy};
        return builder;
    }


    
    public static <T> SpinnerBuilder<T> create(int min, int max, int initialValue) {
        SpinnerBuilder<T> builder = new SpinnerBuilder<T>();
        builder.constructorArgs = new Object[]{min, max, initialValue};
        return builder;
    }


    
    public static <T> SpinnerBuilder<T> create(int min, int max, int initialValue, int amountToStepBy) {
        SpinnerBuilder<T> builder = new SpinnerBuilder<T>();
        builder.constructorArgs = new Object[]{min, max, initialValue, amountToStepBy};
        return builder;
    }


    
    public static <T> SpinnerBuilder<T> create(javafx.collections.ObservableList<T> items) {
        SpinnerBuilder<T> builder = new SpinnerBuilder<T>();
        builder.constructorArgs = new Object[]{items};
        return builder;
    }


    
    public static <T> SpinnerBuilder<T> create(javafx.scene.control.SpinnerValueFactory<T> valueFactory) {
        SpinnerBuilder<T> builder = new SpinnerBuilder<T>();
        builder.constructorArgs = new Object[]{valueFactory};
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
     * @return new instance of the {@link javafx.scene.control.Spinner Spinner} class
     */
    public javafx.scene.control.Spinner<T> build() {
        javafx.scene.control.Spinner<T> newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.Spinner<>();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.Spinner<T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.Spinner<T> callParameterizedConstructor() {
        javafx.scene.control.Spinner<T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.Spinner.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.Spinner<T>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Spinner instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(spinner -> spinner.setId("Main" + spinner.getTypeSelector()))
     * }</pre>
     *
     * @return builder instance
     *
     */
    public SpinnerBuilder<T> apply(java.util.function.Consumer<javafx.scene.control.Spinner<T>> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setBackground(javafx.scene.layout.Background)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setBorder(javafx.scene.layout.Border)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setCacheShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setCenterShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setContextMenu(javafx.scene.control.ContextMenu)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> contextMenu(javafx.scene.control.ContextMenu value) {
        operations.add(obj -> obj.setContextMenu(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setEditable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> editable(boolean value) {
        operations.add(obj -> obj.setEditable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setInitialDelay(javafx.util.Duration)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> initialDelay(javafx.util.Duration value) {
        operations.add(obj -> obj.setInitialDelay(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setOpaqueInsets(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setPadding(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setPromptText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> promptText(java.lang.String value) {
        operations.add(obj -> obj.setPromptText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setRepeatDelay(javafx.util.Duration)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> repeatDelay(javafx.util.Duration value) {
        operations.add(obj -> obj.setRepeatDelay(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setScaleShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setShape(javafx.scene.shape.Shape)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setSkin(javafx.scene.control.Skin)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> skin(javafx.scene.control.Skin<?> value) {
        operations.add(obj -> obj.setSkin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setSnapToPixel(boolean)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setTooltip(javafx.scene.control.Tooltip)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> tooltip(javafx.scene.control.Tooltip value) {
        operations.add(obj -> obj.setTooltip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setValueFactory(javafx.scene.control.SpinnerValueFactory)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> valueFactory(javafx.scene.control.SpinnerValueFactory<T> value) {
        operations.add(obj -> obj.setValueFactory(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Spinner#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  SpinnerBuilder<T> visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.Spinner#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final SpinnerBuilder<T> addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.Spinner#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final SpinnerBuilder<T> addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.Spinner#getStylesheets()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final SpinnerBuilder<T> addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.Spinner#getStylesheets()} method.
     * 
     * @return builder instance
     */
    public final SpinnerBuilder<T> addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.Spinner#getTransforms()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final SpinnerBuilder<T> addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.Spinner#getTransforms()} method.
     * 
     * @return builder instance
     */
    public final SpinnerBuilder<T> addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }


    
    /**
     * Utility setter to add CSS string for this Spinner's contents.
     * For example:
     * <pre>
     * SpinnerBuilder builder = SpinnerBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();
     * </pre>
     *
     * @param css CSS string
     */
    public SpinnerBuilder<T> addStylesheetsText(String css) {
        operations.add(obj -> obj.getStylesheets().addAll("data:text/css;base64," +
                java.util.Base64.getEncoder().encodeToString(css.getBytes())));
        return this;
    }

    public SpinnerBuilder<T> bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }


    public SpinnerBuilder<T> leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }


    public SpinnerBuilder<T> rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }


    public SpinnerBuilder<T> topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }


    public SpinnerBuilder<T> alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }


    public SpinnerBuilder<T> marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }


    public SpinnerBuilder<T> marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }


    public SpinnerBuilder<T> columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }


    public SpinnerBuilder<T> columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }


    public SpinnerBuilder<T> constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }


    public SpinnerBuilder<T> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }


    public SpinnerBuilder<T> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }


    public SpinnerBuilder<T> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }


    public SpinnerBuilder<T> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }


    public SpinnerBuilder<T> fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }


    public SpinnerBuilder<T> fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }


    public SpinnerBuilder<T> hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }


    public SpinnerBuilder<T> hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }


    public SpinnerBuilder<T> marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }


    public SpinnerBuilder<T> rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }


    public SpinnerBuilder<T> rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }


    public SpinnerBuilder<T> vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }


    public SpinnerBuilder<T> vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }


    public SpinnerBuilder<T> hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }


    public SpinnerBuilder<T> marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }


    public SpinnerBuilder<T> alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }


    public SpinnerBuilder<T> marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }


    public SpinnerBuilder<T> alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }


    public SpinnerBuilder<T> marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }


    public SpinnerBuilder<T> marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }


    public SpinnerBuilder<T> vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }
    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#backgroundProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#borderProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#cacheShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#centerShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#contextMenuProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> contextMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.contextMenuProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#editableProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> editablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.editableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#editorProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> editorPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TextField>> op) {
        operations.add(obj -> op.accept(obj.editorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#initialDelayProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> initialDelayPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.initialDelayProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#insetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#needsLayoutProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#opaqueInsetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#paddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#promptTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> promptTextPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.promptTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#repeatDelayProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> repeatDelayPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.repeatDelayProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#scaleShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#shapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#skinProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> skinPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Skin<?>>> op) {
        operations.add(obj -> op.accept(obj.skinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#snapToPixelProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#tooltipProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> tooltipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Tooltip>> op) {
        operations.add(obj -> op.accept(obj.tooltipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#valueFactoryProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> valueFactoryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.SpinnerValueFactory<T>>> op) {
        operations.add(obj -> op.accept(obj.valueFactoryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#valueProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> valuePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<T>> op) {
        operations.add(obj -> op.accept(obj.valueProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Spinner#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public SpinnerBuilder<T> widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
