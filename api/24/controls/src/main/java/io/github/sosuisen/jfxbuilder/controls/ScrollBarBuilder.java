
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code ScrollBarBuilder} class constructs instances of the {@link javafx.scene.control.ScrollBar ScrollBar} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.ScrollBar ScrollBar} constructor
 * and returns an instance of the {@code ScrollBarBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.ScrollBar ScrollBar}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.ScrollBar ScrollBar} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class ScrollBarBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.ScrollBar>> operations = new java.util.ArrayList<>();
    private ScrollBarBuilder() {}
    
    /**
     * Returns an instance of the {@code ScrollBarBuilder}.
     *
     * @return an instance of the {@code ScrollBarBuilder}.
     */
    public static ScrollBarBuilder create() { return new ScrollBarBuilder(); }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.ScrollBar} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.ScrollBar ScrollBar} class
     */
    public javafx.scene.control.ScrollBar build() {
        javafx.scene.control.ScrollBar newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.ScrollBar();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.ScrollBar> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.ScrollBar callParameterizedConstructor() {
        javafx.scene.control.ScrollBar newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.ScrollBar.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.ScrollBar) constructor.newInstance(constructorArgs);
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
     * Applies a function to the ScrollBar instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(scrollBar -> scrollBar.setId("Main" + scrollBar.getTypeSelector()))
     * }</pre>
     *
     * @return builder instance
     *
     */
    public ScrollBarBuilder apply(java.util.function.Consumer<javafx.scene.control.ScrollBar> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setAccessibleHelp(java.lang.String) setAccessibleHelp} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setAccessibleRole(javafx.scene.AccessibleRole) setAccessibleRole} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setAccessibleRoleDescription(java.lang.String) setAccessibleRoleDescription} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setAccessibleText(java.lang.String) setAccessibleText} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setBackground(javafx.scene.layout.Background) setBackground} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setBlendMode(javafx.scene.effect.BlendMode) setBlendMode} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setBlockIncrement(double) setBlockIncrement} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder blockIncrement(double value) {
        operations.add(obj -> obj.setBlockIncrement(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setBorder(javafx.scene.layout.Border) setBorder} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setCache(boolean) setCache} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setCacheHint(javafx.scene.CacheHint) setCacheHint} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setCacheShape(boolean) setCacheShape} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setCenterShape(boolean) setCenterShape} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setClip(javafx.scene.Node) setClip} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setContextMenu(javafx.scene.control.ContextMenu) setContextMenu} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder contextMenu(javafx.scene.control.ContextMenu value) {
        operations.add(obj -> obj.setContextMenu(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setCursor(javafx.scene.Cursor) setCursor} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setDepthTest(javafx.scene.DepthTest) setDepthTest} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setDisable(boolean) setDisable} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setEffect(javafx.scene.effect.Effect) setEffect} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setEventDispatcher(javafx.event.EventDispatcher) setEventDispatcher} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setFocusTraversable(boolean) setFocusTraversable} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setId(java.lang.String) setId} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setInputMethodRequests(javafx.scene.input.InputMethodRequests) setInputMethodRequests} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setLayoutX(double) setLayoutX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setLayoutY(double) setLayoutY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setManaged(boolean) setManaged} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setMax(double) setMax} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder max(double value) {
        operations.add(obj -> obj.setMax(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setMaxHeight(double) setMaxHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setMaxSize(double, double) setMaxSize} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setMaxWidth(double) setMaxWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setMin(double) setMin} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder min(double value) {
        operations.add(obj -> obj.setMin(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setMinHeight(double) setMinHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setMinSize(double, double) setMinSize} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setMinWidth(double) setMinWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setMouseTransparent(boolean) setMouseTransparent} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setNodeOrientation(javafx.geometry.NodeOrientation) setNodeOrientation} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnContextMenuRequested(javafx.event.EventHandler) setOnContextMenuRequested} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnDragDetected(javafx.event.EventHandler) setOnDragDetected} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnDragDone(javafx.event.EventHandler) setOnDragDone} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnDragDropped(javafx.event.EventHandler) setOnDragDropped} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnDragEntered(javafx.event.EventHandler) setOnDragEntered} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnDragExited(javafx.event.EventHandler) setOnDragExited} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnDragOver(javafx.event.EventHandler) setOnDragOver} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnInputMethodTextChanged(javafx.event.EventHandler) setOnInputMethodTextChanged} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnKeyPressed(javafx.event.EventHandler) setOnKeyPressed} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnKeyReleased(javafx.event.EventHandler) setOnKeyReleased} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnKeyTyped(javafx.event.EventHandler) setOnKeyTyped} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnMouseClicked(javafx.event.EventHandler) setOnMouseClicked} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnMouseDragEntered(javafx.event.EventHandler) setOnMouseDragEntered} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnMouseDragExited(javafx.event.EventHandler) setOnMouseDragExited} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnMouseDragOver(javafx.event.EventHandler) setOnMouseDragOver} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnMouseDragReleased(javafx.event.EventHandler) setOnMouseDragReleased} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnMouseDragged(javafx.event.EventHandler) setOnMouseDragged} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnMouseEntered(javafx.event.EventHandler) setOnMouseEntered} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnMouseExited(javafx.event.EventHandler) setOnMouseExited} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnMouseMoved(javafx.event.EventHandler) setOnMouseMoved} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnMousePressed(javafx.event.EventHandler) setOnMousePressed} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnMouseReleased(javafx.event.EventHandler) setOnMouseReleased} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnRotate(javafx.event.EventHandler) setOnRotate} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnRotationFinished(javafx.event.EventHandler) setOnRotationFinished} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnRotationStarted(javafx.event.EventHandler) setOnRotationStarted} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnScroll(javafx.event.EventHandler) setOnScroll} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnScrollFinished(javafx.event.EventHandler) setOnScrollFinished} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnScrollStarted(javafx.event.EventHandler) setOnScrollStarted} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnSwipeDown(javafx.event.EventHandler) setOnSwipeDown} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnSwipeLeft(javafx.event.EventHandler) setOnSwipeLeft} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnSwipeRight(javafx.event.EventHandler) setOnSwipeRight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnSwipeUp(javafx.event.EventHandler) setOnSwipeUp} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnTouchMoved(javafx.event.EventHandler) setOnTouchMoved} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnTouchPressed(javafx.event.EventHandler) setOnTouchPressed} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnTouchReleased(javafx.event.EventHandler) setOnTouchReleased} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnTouchStationary(javafx.event.EventHandler) setOnTouchStationary} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnZoom(javafx.event.EventHandler) setOnZoom} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnZoomFinished(javafx.event.EventHandler) setOnZoomFinished} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOnZoomStarted(javafx.event.EventHandler) setOnZoomStarted} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOpacity(double) setOpacity} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOpaqueInsets(javafx.geometry.Insets) setOpaqueInsets} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setOrientation(javafx.geometry.Orientation) setOrientation} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder orientation(javafx.geometry.Orientation value) {
        operations.add(obj -> obj.setOrientation(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setPadding(javafx.geometry.Insets) setPadding} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setPickOnBounds(boolean) setPickOnBounds} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setPrefHeight(double) setPrefHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setPrefSize(double, double) setPrefSize} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setPrefWidth(double) setPrefWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setRotate(double) setRotate} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setRotationAxis(javafx.geometry.Point3D) setRotationAxis} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setScaleShape(boolean) setScaleShape} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setScaleX(double) setScaleX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setScaleY(double) setScaleY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setScaleZ(double) setScaleZ} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setShape(javafx.scene.shape.Shape) setShape} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setSkin(javafx.scene.control.Skin) setSkin} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder skin(javafx.scene.control.Skin<?> value) {
        operations.add(obj -> obj.setSkin(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setSnapToPixel(boolean) setSnapToPixel} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setStyle(java.lang.String) setStyle} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setTooltip(javafx.scene.control.Tooltip) setTooltip} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder tooltip(javafx.scene.control.Tooltip value) {
        operations.add(obj -> obj.setTooltip(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setTranslateX(double) setTranslateX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setTranslateY(double) setTranslateY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setTranslateZ(double) setTranslateZ} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setUnitIncrement(double) setUnitIncrement} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder unitIncrement(double value) {
        operations.add(obj -> obj.setUnitIncrement(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setUserData(java.lang.Object) setUserData} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setValue(double) setValue} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder value(double value) {
        operations.add(obj -> obj.setValue(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setViewOrder(double) setViewOrder} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setVisible(boolean) setVisible} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ScrollBar#setVisibleAmount(double) setVisibleAmount} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ScrollBarBuilder visibleAmount(double value) {
        operations.add(obj -> obj.setVisibleAmount(value));
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ScrollBar#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final ScrollBarBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ScrollBar#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final ScrollBarBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ScrollBar#getStylesheets()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final ScrollBarBuilder addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ScrollBar#getStylesheets()} method.
     * 
     * @return builder instance
     */
    public final ScrollBarBuilder addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ScrollBar#getTransforms()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final ScrollBarBuilder addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ScrollBar#getTransforms()} method.
     * 
     * @return builder instance
     */
    public final ScrollBarBuilder addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }    
    /**
     * Utility setter to add CSS string for this ScrollBar's contents.
     * For example:
     * <pre>{@code
     * ScrollBarBuilder builder = ScrollBarBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();}
     * </pre>
     *
     * @param css CSS string
     */
    public ScrollBarBuilder addStylesheetsText(String css) {
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
    public ScrollBarBuilder bottomAnchorInAnchorPane(java.lang.Double value) {
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
    public ScrollBarBuilder leftAnchorInAnchorPane(java.lang.Double value) {
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
    public ScrollBarBuilder rightAnchorInAnchorPane(java.lang.Double value) {
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
    public ScrollBarBuilder topAnchorInAnchorPane(java.lang.Double value) {
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
    public ScrollBarBuilder alignmentInBorderPane(javafx.geometry.Pos value) {
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
    public ScrollBarBuilder marginInBorderPane(javafx.geometry.Insets value) {
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
    public ScrollBarBuilder marginInFlowPane(javafx.geometry.Insets value) {
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
    public ScrollBarBuilder columnIndexInGridPane(java.lang.Integer value) {
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
    public ScrollBarBuilder columnSpanInGridPane(java.lang.Integer value) {
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
    public ScrollBarBuilder constraintsInGridPane(int columnIndex, int rowIndex) {
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
    public ScrollBarBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
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
    public ScrollBarBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
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
    public ScrollBarBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
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
    public ScrollBarBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
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
    public ScrollBarBuilder fillHeightInGridPane(java.lang.Boolean value) {
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
    public ScrollBarBuilder fillWidthInGridPane(java.lang.Boolean value) {
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
    public ScrollBarBuilder hAlignmentInGridPane(javafx.geometry.HPos value) {
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
    public ScrollBarBuilder hGrowInGridPane(javafx.scene.layout.Priority value) {
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
    public ScrollBarBuilder marginInGridPane(javafx.geometry.Insets value) {
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
    public ScrollBarBuilder rowIndexInGridPane(java.lang.Integer value) {
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
    public ScrollBarBuilder rowSpanInGridPane(java.lang.Integer value) {
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
    public ScrollBarBuilder vAlignmentInGridPane(javafx.geometry.VPos value) {
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
    public ScrollBarBuilder vGrowInGridPane(javafx.scene.layout.Priority value) {
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
    public ScrollBarBuilder hGrowInHBox(javafx.scene.layout.Priority value) {
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
    public ScrollBarBuilder marginInHBox(javafx.geometry.Insets value) {
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
    public ScrollBarBuilder alignmentInStackPane(javafx.geometry.Pos value) {
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
    public ScrollBarBuilder marginInStackPane(javafx.geometry.Insets value) {
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
    public ScrollBarBuilder alignmentInTilePane(javafx.geometry.Pos value) {
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
    public ScrollBarBuilder marginInTilePane(javafx.geometry.Insets value) {
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
    public ScrollBarBuilder marginInVBox(javafx.geometry.Insets value) {
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
    public ScrollBarBuilder vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }


    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#accessibleHelpProperty() accessibleHelpProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#accessibleRoleDescriptionProperty() accessibleRoleDescriptionProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#accessibleRoleProperty() accessibleRoleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#accessibleTextProperty() accessibleTextProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#backgroundProperty() backgroundProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#blendModeProperty() blendModeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#blockIncrementProperty() blockIncrementProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.blockIncrementProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .blockIncrementPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ScrollBarBuilder blockIncrementPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.blockIncrementProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#borderProperty() borderProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#boundsInLocalProperty() boundsInLocalProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#boundsInParentProperty() boundsInParentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#cacheHintProperty() cacheHintProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#cacheProperty() cacheProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#cacheShapeProperty() cacheShapeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#centerShapeProperty() centerShapeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#clipProperty() clipProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#contextMenuProperty() contextMenuProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.contextMenuProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .contextMenuPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ScrollBarBuilder contextMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.contextMenuProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#cursorProperty() cursorProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#depthTestProperty() depthTestProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#disableProperty() disableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#disabledProperty() disabledProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#effectProperty() effectProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#effectiveNodeOrientationProperty() effectiveNodeOrientationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#eventDispatcherProperty() eventDispatcherProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#focusTraversableProperty() focusTraversableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#focusVisibleProperty() focusVisibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#focusWithinProperty() focusWithinProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#focusedProperty() focusedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#heightProperty() heightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#hoverProperty() hoverProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#idProperty() idProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#inputMethodRequestsProperty() inputMethodRequestsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#insetsProperty() insetsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#layoutBoundsProperty() layoutBoundsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#layoutXProperty() layoutXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#layoutYProperty() layoutYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#localToParentTransformProperty() localToParentTransformProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#localToSceneTransformProperty() localToSceneTransformProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#managedProperty() managedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#maxHeightProperty() maxHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#maxProperty() maxProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.maxProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .maxPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ScrollBarBuilder maxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#maxWidthProperty() maxWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#minHeightProperty() minHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#minProperty() minProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.minProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .minPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ScrollBarBuilder minPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#minWidthProperty() minWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#mouseTransparentProperty() mouseTransparentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#needsLayoutProperty() needsLayoutProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#nodeOrientationProperty() nodeOrientationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onContextMenuRequestedProperty() onContextMenuRequestedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onDragDetectedProperty() onDragDetectedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onDragDoneProperty() onDragDoneProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onDragDroppedProperty() onDragDroppedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onDragEnteredProperty() onDragEnteredProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onDragExitedProperty() onDragExitedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onDragOverProperty() onDragOverProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onInputMethodTextChangedProperty() onInputMethodTextChangedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onKeyPressedProperty() onKeyPressedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onKeyReleasedProperty() onKeyReleasedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onKeyTypedProperty() onKeyTypedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onMouseClickedProperty() onMouseClickedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onMouseDragEnteredProperty() onMouseDragEnteredProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onMouseDragExitedProperty() onMouseDragExitedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onMouseDragOverProperty() onMouseDragOverProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onMouseDragReleasedProperty() onMouseDragReleasedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onMouseDraggedProperty() onMouseDraggedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onMouseEnteredProperty() onMouseEnteredProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onMouseExitedProperty() onMouseExitedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onMouseMovedProperty() onMouseMovedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onMousePressedProperty() onMousePressedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onMouseReleasedProperty() onMouseReleasedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onRotateProperty() onRotateProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onRotationFinishedProperty() onRotationFinishedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onRotationStartedProperty() onRotationStartedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onScrollFinishedProperty() onScrollFinishedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onScrollProperty() onScrollProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onScrollStartedProperty() onScrollStartedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onSwipeDownProperty() onSwipeDownProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onSwipeLeftProperty() onSwipeLeftProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onSwipeRightProperty() onSwipeRightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onSwipeUpProperty() onSwipeUpProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onTouchMovedProperty() onTouchMovedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onTouchPressedProperty() onTouchPressedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onTouchReleasedProperty() onTouchReleasedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onTouchStationaryProperty() onTouchStationaryProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onZoomFinishedProperty() onZoomFinishedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onZoomProperty() onZoomProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#onZoomStartedProperty() onZoomStartedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#opacityProperty() opacityProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#opaqueInsetsProperty() opaqueInsetsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#orientationProperty() orientationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.orientationProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .orientationPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ScrollBarBuilder orientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Orientation>> op) {
        operations.add(obj -> op.accept(obj.orientationProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#paddingProperty() paddingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#parentProperty() parentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#pickOnBoundsProperty() pickOnBoundsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#prefHeightProperty() prefHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#prefWidthProperty() prefWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#pressedProperty() pressedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#rotateProperty() rotateProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#rotationAxisProperty() rotationAxisProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#scaleShapeProperty() scaleShapeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#scaleXProperty() scaleXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#scaleYProperty() scaleYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#scaleZProperty() scaleZProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#sceneProperty() sceneProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#shapeProperty() shapeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#skinProperty() skinProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.skinProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .skinPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ScrollBarBuilder skinPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Skin<?>>> op) {
        operations.add(obj -> op.accept(obj.skinProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#snapToPixelProperty() snapToPixelProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#styleProperty() styleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#tooltipProperty() tooltipProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.tooltipProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .tooltipPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ScrollBarBuilder tooltipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Tooltip>> op) {
        operations.add(obj -> op.accept(obj.tooltipProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#translateXProperty() translateXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#translateYProperty() translateYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#translateZProperty() translateZProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#unitIncrementProperty() unitIncrementProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.unitIncrementProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .unitIncrementPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ScrollBarBuilder unitIncrementPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.unitIncrementProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#valueProperty() valueProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.valueProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .valuePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ScrollBarBuilder valuePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.valueProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#viewOrderProperty() viewOrderProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#visibleAmountProperty() visibleAmountProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.visibleAmountProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .visibleAmountPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ScrollBarBuilder visibleAmountPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.visibleAmountProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#visibleProperty() visibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ScrollBar#widthProperty() widthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ScrollBarBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ScrollBarBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
