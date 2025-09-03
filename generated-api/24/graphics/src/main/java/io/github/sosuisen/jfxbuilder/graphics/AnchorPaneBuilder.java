
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code AnchorPaneBuilder} class constructs instances of the {@link javafx.scene.layout.AnchorPane AnchorPane} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.layout.AnchorPane AnchorPane} constructor
 * and returns an instance of the {@code AnchorPaneBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.layout.AnchorPane AnchorPane}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.layout.AnchorPane AnchorPane} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class AnchorPaneBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.layout.AnchorPane>> operations = new java.util.ArrayList<>();
    private AnchorPaneBuilder() {}
    
    /**
     * Returns an instance of the {@code AnchorPaneBuilder}.
     *
     * @return an instance of the {@code AnchorPaneBuilder}.
     */
    public static AnchorPaneBuilder create() { return new AnchorPaneBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.layout.AnchorPane#AnchorPane(Node...) AnchorPane(Node...)}
     * and returns an instance of {@code AnchorPaneBuilder}.
     *
     * @return an instance of the {@code AnchorPaneBuilder}.
     */
    @SafeVarargs
    public static AnchorPaneBuilder create(javafx.scene.Node... children) {
        AnchorPaneBuilder builder = new AnchorPaneBuilder();
        builder.constructorArgs = new Object[]{children};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.layout.AnchorPane} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.layout.AnchorPane AnchorPane} class
     */
    public javafx.scene.layout.AnchorPane build() {
        javafx.scene.layout.AnchorPane newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.layout.AnchorPane();

        } else {
            newInstance = callParameterizedConstructor();
        }


        newInstance.getStyleClass().add(".anchor-pane");

        for (java.util.function.Consumer<javafx.scene.layout.AnchorPane> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.layout.AnchorPane callParameterizedConstructor() {
        javafx.scene.layout.AnchorPane newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.layout.AnchorPane.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.layout.AnchorPane) constructor.newInstance(constructorArgs);
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
     * Applies a function to the AnchorPane instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(anchorPane -> anchorPane.setId("Main" + anchorPane.getTypeSelector()))
     * }</pre>
     *
     * @return builder instance
     *
     */
    public AnchorPaneBuilder apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setAccessibleHelp(java.lang.String) setAccessibleHelp} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setAccessibleRole(javafx.scene.AccessibleRole) setAccessibleRole} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setAccessibleRoleDescription(java.lang.String) setAccessibleRoleDescription} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setAccessibleText(java.lang.String) setAccessibleText} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setBackground(javafx.scene.layout.Background) setBackground} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setBlendMode(javafx.scene.effect.BlendMode) setBlendMode} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setBorder(javafx.scene.layout.Border) setBorder} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setCache(boolean) setCache} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setCacheHint(javafx.scene.CacheHint) setCacheHint} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setCacheShape(boolean) setCacheShape} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setCenterShape(boolean) setCenterShape} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setClip(javafx.scene.Node) setClip} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setCursor(javafx.scene.Cursor) setCursor} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setDepthTest(javafx.scene.DepthTest) setDepthTest} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setDisable(boolean) setDisable} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setEffect(javafx.scene.effect.Effect) setEffect} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setEventDispatcher(javafx.event.EventDispatcher) setEventDispatcher} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setFocusTraversable(boolean) setFocusTraversable} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setId(java.lang.String) setId} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setInputMethodRequests(javafx.scene.input.InputMethodRequests) setInputMethodRequests} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setLayoutX(double) setLayoutX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setLayoutY(double) setLayoutY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setManaged(boolean) setManaged} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setMaxHeight(double) setMaxHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setMaxSize(double, double) setMaxSize} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setMaxWidth(double) setMaxWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setMinHeight(double) setMinHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setMinSize(double, double) setMinSize} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setMinWidth(double) setMinWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setMouseTransparent(boolean) setMouseTransparent} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setNodeOrientation(javafx.geometry.NodeOrientation) setNodeOrientation} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnContextMenuRequested(javafx.event.EventHandler) setOnContextMenuRequested} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnDragDetected(javafx.event.EventHandler) setOnDragDetected} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnDragDone(javafx.event.EventHandler) setOnDragDone} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnDragDropped(javafx.event.EventHandler) setOnDragDropped} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnDragEntered(javafx.event.EventHandler) setOnDragEntered} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnDragExited(javafx.event.EventHandler) setOnDragExited} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnDragOver(javafx.event.EventHandler) setOnDragOver} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnInputMethodTextChanged(javafx.event.EventHandler) setOnInputMethodTextChanged} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnKeyPressed(javafx.event.EventHandler) setOnKeyPressed} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnKeyReleased(javafx.event.EventHandler) setOnKeyReleased} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnKeyTyped(javafx.event.EventHandler) setOnKeyTyped} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnMouseClicked(javafx.event.EventHandler) setOnMouseClicked} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnMouseDragEntered(javafx.event.EventHandler) setOnMouseDragEntered} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnMouseDragExited(javafx.event.EventHandler) setOnMouseDragExited} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnMouseDragOver(javafx.event.EventHandler) setOnMouseDragOver} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnMouseDragReleased(javafx.event.EventHandler) setOnMouseDragReleased} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnMouseDragged(javafx.event.EventHandler) setOnMouseDragged} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnMouseEntered(javafx.event.EventHandler) setOnMouseEntered} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnMouseExited(javafx.event.EventHandler) setOnMouseExited} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnMouseMoved(javafx.event.EventHandler) setOnMouseMoved} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnMousePressed(javafx.event.EventHandler) setOnMousePressed} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnMouseReleased(javafx.event.EventHandler) setOnMouseReleased} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnRotate(javafx.event.EventHandler) setOnRotate} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnRotationFinished(javafx.event.EventHandler) setOnRotationFinished} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnRotationStarted(javafx.event.EventHandler) setOnRotationStarted} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnScroll(javafx.event.EventHandler) setOnScroll} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnScrollFinished(javafx.event.EventHandler) setOnScrollFinished} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnScrollStarted(javafx.event.EventHandler) setOnScrollStarted} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnSwipeDown(javafx.event.EventHandler) setOnSwipeDown} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnSwipeLeft(javafx.event.EventHandler) setOnSwipeLeft} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnSwipeRight(javafx.event.EventHandler) setOnSwipeRight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnSwipeUp(javafx.event.EventHandler) setOnSwipeUp} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnTouchMoved(javafx.event.EventHandler) setOnTouchMoved} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnTouchPressed(javafx.event.EventHandler) setOnTouchPressed} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnTouchReleased(javafx.event.EventHandler) setOnTouchReleased} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnTouchStationary(javafx.event.EventHandler) setOnTouchStationary} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnZoom(javafx.event.EventHandler) setOnZoom} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnZoomFinished(javafx.event.EventHandler) setOnZoomFinished} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOnZoomStarted(javafx.event.EventHandler) setOnZoomStarted} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOpacity(double) setOpacity} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setOpaqueInsets(javafx.geometry.Insets) setOpaqueInsets} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setPadding(javafx.geometry.Insets) setPadding} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setPickOnBounds(boolean) setPickOnBounds} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setPrefHeight(double) setPrefHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setPrefSize(double, double) setPrefSize} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setPrefWidth(double) setPrefWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setRotate(double) setRotate} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setRotationAxis(javafx.geometry.Point3D) setRotationAxis} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setScaleShape(boolean) setScaleShape} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setScaleX(double) setScaleX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setScaleY(double) setScaleY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setScaleZ(double) setScaleZ} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setShape(javafx.scene.shape.Shape) setShape} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setSnapToPixel(boolean) setSnapToPixel} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setStyle(java.lang.String) setStyle} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setTranslateX(double) setTranslateX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setTranslateY(double) setTranslateY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setTranslateZ(double) setTranslateZ} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setUserData(java.lang.Object) setUserData} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setViewOrder(double) setViewOrder} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.AnchorPane#setVisible(boolean) setVisible} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  AnchorPaneBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.layout.AnchorPane#getChildren()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final AnchorPaneBuilder addChildren(javafx.scene.Node... elements) {
        operations.add(obj -> {
            obj.getChildren().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.layout.AnchorPane#getChildren()} method.
     * 
     * @return builder instance
     */
    public final AnchorPaneBuilder addChildren(java.util.Collection<? extends javafx.scene.Node> col) {
        operations.add(obj -> {
            obj.getChildren().addAll(col);
        });
        return this;
    }

    /**
     * Creates an instance of the builder, then call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.layout.AnchorPane#getChildren()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public static AnchorPaneBuilder withChildren(javafx.scene.Node... elements) {
        AnchorPaneBuilder builder = new AnchorPaneBuilder();
        return builder.addChildren(elements);
    }

    /**
     * Creates an instance of the builder, then call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.layout.AnchorPane#getChildren()} method.
     * 
     * @return builder instance
     */
    public static AnchorPaneBuilder withChildren(java.util.Collection<? extends javafx.scene.Node> col) {
        AnchorPaneBuilder builder = new AnchorPaneBuilder();
        return builder.addChildren(col);
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.layout.AnchorPane#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final AnchorPaneBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.layout.AnchorPane#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final AnchorPaneBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.layout.AnchorPane#getStylesheets()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final AnchorPaneBuilder addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.layout.AnchorPane#getStylesheets()} method.
     * 
     * @return builder instance
     */
    public final AnchorPaneBuilder addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.layout.AnchorPane#getTransforms()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final AnchorPaneBuilder addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.layout.AnchorPane#getTransforms()} method.
     * 
     * @return builder instance
     */
    public final AnchorPaneBuilder addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }    
    /**
     * Utility setter to add CSS string for this AnchorPane's contents.
     * For example:
     * <pre>{@code
     * AnchorPaneBuilder builder = AnchorPaneBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();}
     * </pre>
     *
     * @param css CSS string
     */
    public AnchorPaneBuilder addStylesheetsText(String css) {
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
     *                  ButtonBuilder.create()
     *                      .bottomAnchorInAnchorPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder bottomAnchorInAnchorPane(java.lang.Double value) {
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
     *                  ButtonBuilder.create()
     *                      .leftAnchorInAnchorPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder leftAnchorInAnchorPane(java.lang.Double value) {
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
     *                  ButtonBuilder.create()
     *                      .rightAnchorInAnchorPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder rightAnchorInAnchorPane(java.lang.Double value) {
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
     *                  ButtonBuilder.create()
     *                      .topAnchorInAnchorPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder topAnchorInAnchorPane(java.lang.Double value) {
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
     *                  ButtonBuilder.create()
     *                      .alignmentInBorderPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder alignmentInBorderPane(javafx.geometry.Pos value) {
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
     *                  ButtonBuilder.create()
     *                      .marginInBorderPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder marginInBorderPane(javafx.geometry.Insets value) {
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
     *                  ButtonBuilder.create()
     *                      .marginInFlowPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder marginInFlowPane(javafx.geometry.Insets value) {
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
     *                  ButtonBuilder.create()
     *                      .columnIndexInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder columnIndexInGridPane(java.lang.Integer value) {
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
     *                  ButtonBuilder.create()
     *                      .columnSpanInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder columnSpanInGridPane(java.lang.Integer value) {
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
     *                  ButtonBuilder.create()
     *                      .constraintsInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder constraintsInGridPane(int columnIndex, int rowIndex) {
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
     *                  ButtonBuilder.create()
     *                      .constraintsInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
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
     *                  ButtonBuilder.create()
     *                      .constraintsInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
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
     *                  ButtonBuilder.create()
     *                      .constraintsInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
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
     *                  ButtonBuilder.create()
     *                      .constraintsInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
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
     *                  ButtonBuilder.create()
     *                      .fillHeightInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder fillHeightInGridPane(java.lang.Boolean value) {
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
     *                  ButtonBuilder.create()
     *                      .fillWidthInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder fillWidthInGridPane(java.lang.Boolean value) {
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
     *                  ButtonBuilder.create()
     *                      .hAlignmentInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder hAlignmentInGridPane(javafx.geometry.HPos value) {
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
     *                  ButtonBuilder.create()
     *                      .hGrowInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder hGrowInGridPane(javafx.scene.layout.Priority value) {
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
     *                  ButtonBuilder.create()
     *                      .marginInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder marginInGridPane(javafx.geometry.Insets value) {
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
     *                  ButtonBuilder.create()
     *                      .rowIndexInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder rowIndexInGridPane(java.lang.Integer value) {
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
     *                  ButtonBuilder.create()
     *                      .rowSpanInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder rowSpanInGridPane(java.lang.Integer value) {
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
     *                  ButtonBuilder.create()
     *                      .vAlignmentInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder vAlignmentInGridPane(javafx.geometry.VPos value) {
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
     *                  ButtonBuilder.create()
     *                      .vGrowInGridPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder vGrowInGridPane(javafx.scene.layout.Priority value) {
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
     *                  ButtonBuilder.create()
     *                      .hGrowInHBox(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder hGrowInHBox(javafx.scene.layout.Priority value) {
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
     *                  ButtonBuilder.create()
     *                      .marginInHBox(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder marginInHBox(javafx.geometry.Insets value) {
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
     *                  ButtonBuilder.create()
     *                      .alignmentInStackPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder alignmentInStackPane(javafx.geometry.Pos value) {
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
     *                  ButtonBuilder.create()
     *                      .marginInStackPane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder marginInStackPane(javafx.geometry.Insets value) {
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
     *                  ButtonBuilder.create()
     *                      .alignmentInTilePane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder alignmentInTilePane(javafx.geometry.Pos value) {
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
     *                  ButtonBuilder.create()
     *                      .marginInTilePane(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder marginInTilePane(javafx.geometry.Insets value) {
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
     *                  ButtonBuilder.create()
     *                      .marginInVBox(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder marginInVBox(javafx.geometry.Insets value) {
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
     *                  ButtonBuilder.create()
     *                      .vGrowInVBox(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public AnchorPaneBuilder vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }


    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#accessibleHelpProperty() accessibleHelpProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#accessibleRoleDescriptionProperty() accessibleRoleDescriptionProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#accessibleRoleProperty() accessibleRoleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#accessibleTextProperty() accessibleTextProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#backgroundProperty() backgroundProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#blendModeProperty() blendModeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#borderProperty() borderProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#boundsInLocalProperty() boundsInLocalProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#boundsInParentProperty() boundsInParentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#cacheHintProperty() cacheHintProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#cacheProperty() cacheProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#cacheShapeProperty() cacheShapeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#centerShapeProperty() centerShapeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#clipProperty() clipProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#cursorProperty() cursorProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#depthTestProperty() depthTestProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#disableProperty() disableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#disabledProperty() disabledProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#effectProperty() effectProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#effectiveNodeOrientationProperty() effectiveNodeOrientationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#eventDispatcherProperty() eventDispatcherProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#focusTraversableProperty() focusTraversableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#focusVisibleProperty() focusVisibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#focusWithinProperty() focusWithinProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#focusedProperty() focusedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#heightProperty() heightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#hoverProperty() hoverProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#idProperty() idProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#inputMethodRequestsProperty() inputMethodRequestsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#insetsProperty() insetsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#layoutBoundsProperty() layoutBoundsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#layoutXProperty() layoutXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#layoutYProperty() layoutYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#localToParentTransformProperty() localToParentTransformProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#localToSceneTransformProperty() localToSceneTransformProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#managedProperty() managedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#maxHeightProperty() maxHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#maxWidthProperty() maxWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#minHeightProperty() minHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#minWidthProperty() minWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#mouseTransparentProperty() mouseTransparentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#needsLayoutProperty() needsLayoutProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#nodeOrientationProperty() nodeOrientationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onContextMenuRequestedProperty() onContextMenuRequestedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onDragDetectedProperty() onDragDetectedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onDragDoneProperty() onDragDoneProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onDragDroppedProperty() onDragDroppedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onDragEnteredProperty() onDragEnteredProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onDragExitedProperty() onDragExitedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onDragOverProperty() onDragOverProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onInputMethodTextChangedProperty() onInputMethodTextChangedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onKeyPressedProperty() onKeyPressedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onKeyReleasedProperty() onKeyReleasedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onKeyTypedProperty() onKeyTypedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onMouseClickedProperty() onMouseClickedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onMouseDragEnteredProperty() onMouseDragEnteredProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onMouseDragExitedProperty() onMouseDragExitedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onMouseDragOverProperty() onMouseDragOverProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onMouseDragReleasedProperty() onMouseDragReleasedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onMouseDraggedProperty() onMouseDraggedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onMouseEnteredProperty() onMouseEnteredProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onMouseExitedProperty() onMouseExitedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onMouseMovedProperty() onMouseMovedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onMousePressedProperty() onMousePressedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onMouseReleasedProperty() onMouseReleasedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onRotateProperty() onRotateProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onRotationFinishedProperty() onRotationFinishedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onRotationStartedProperty() onRotationStartedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onScrollFinishedProperty() onScrollFinishedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onScrollProperty() onScrollProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onScrollStartedProperty() onScrollStartedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onSwipeDownProperty() onSwipeDownProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onSwipeLeftProperty() onSwipeLeftProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onSwipeRightProperty() onSwipeRightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onSwipeUpProperty() onSwipeUpProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onTouchMovedProperty() onTouchMovedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onTouchPressedProperty() onTouchPressedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onTouchReleasedProperty() onTouchReleasedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onTouchStationaryProperty() onTouchStationaryProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onZoomFinishedProperty() onZoomFinishedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onZoomProperty() onZoomProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#onZoomStartedProperty() onZoomStartedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#opacityProperty() opacityProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#opaqueInsetsProperty() opaqueInsetsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#paddingProperty() paddingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#parentProperty() parentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#pickOnBoundsProperty() pickOnBoundsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#prefHeightProperty() prefHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#prefWidthProperty() prefWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#pressedProperty() pressedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#rotateProperty() rotateProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#rotationAxisProperty() rotationAxisProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#scaleShapeProperty() scaleShapeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#scaleXProperty() scaleXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#scaleYProperty() scaleYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#scaleZProperty() scaleZProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#sceneProperty() sceneProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#shapeProperty() shapeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#snapToPixelProperty() snapToPixelProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#styleProperty() styleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#translateXProperty() translateXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#translateYProperty() translateYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#translateZProperty() translateZProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#viewOrderProperty() viewOrderProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#visibleProperty() visibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.AnchorPane#widthProperty() widthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.layout.AnchorPane> func) apply} method.
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
    public AnchorPaneBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
