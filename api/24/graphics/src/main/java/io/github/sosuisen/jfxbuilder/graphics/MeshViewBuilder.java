
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code MeshViewBuilder} class constructs instances of the {@link javafx.scene.shape.MeshView MeshView} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.shape.MeshView MeshView} constructor
 * and returns an instance of the {@code MeshViewBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.shape.MeshView MeshView}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.shape.MeshView MeshView} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class MeshViewBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.shape.MeshView>> operations = new java.util.ArrayList<>();
    private MeshViewBuilder() {}
    
    /**
     * Returns an instance of the {@code MeshViewBuilder}.
     *
     * @return an instance of the {@code MeshViewBuilder}.
     */
    public static MeshViewBuilder create() { return new MeshViewBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.shape.MeshView#MeshView(Mesh) MeshView(Mesh)}
     * and returns an instance of {@code MeshViewBuilder}.
     *
     * @return an instance of the {@code MeshViewBuilder}.
     */
    
    public static MeshViewBuilder create(javafx.scene.shape.Mesh mesh) {
        MeshViewBuilder builder = new MeshViewBuilder();
        builder.constructorArgs = new Object[]{mesh};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.shape.MeshView} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.shape.MeshView MeshView} class
     */
    public javafx.scene.shape.MeshView build() {
        javafx.scene.shape.MeshView newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.shape.MeshView();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.shape.MeshView> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.shape.MeshView callParameterizedConstructor() {
        javafx.scene.shape.MeshView newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.shape.MeshView.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.shape.MeshView) constructor.newInstance(constructorArgs);
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
     * Applies a function to the MeshView instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(meshView -> meshView.setId("Main" + meshView.getTypeSelector()))
     * }</pre>
     *
     * @return builder instance
     *
     */
    public MeshViewBuilder apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setAccessibleHelp(java.lang.String) setAccessibleHelp} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setAccessibleRole(javafx.scene.AccessibleRole) setAccessibleRole} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setAccessibleRoleDescription(java.lang.String) setAccessibleRoleDescription} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setAccessibleText(java.lang.String) setAccessibleText} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setBlendMode(javafx.scene.effect.BlendMode) setBlendMode} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setCache(boolean) setCache} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setCacheHint(javafx.scene.CacheHint) setCacheHint} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setClip(javafx.scene.Node) setClip} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setCullFace(javafx.scene.shape.CullFace) setCullFace} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder cullFace(javafx.scene.shape.CullFace value) {
        operations.add(obj -> obj.setCullFace(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setCursor(javafx.scene.Cursor) setCursor} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setDepthTest(javafx.scene.DepthTest) setDepthTest} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setDisable(boolean) setDisable} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setDrawMode(javafx.scene.shape.DrawMode) setDrawMode} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder drawMode(javafx.scene.shape.DrawMode value) {
        operations.add(obj -> obj.setDrawMode(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setEffect(javafx.scene.effect.Effect) setEffect} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setEventDispatcher(javafx.event.EventDispatcher) setEventDispatcher} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setFocusTraversable(boolean) setFocusTraversable} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setId(java.lang.String) setId} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setInputMethodRequests(javafx.scene.input.InputMethodRequests) setInputMethodRequests} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setLayoutX(double) setLayoutX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setLayoutY(double) setLayoutY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setManaged(boolean) setManaged} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setMaterial(javafx.scene.paint.Material) setMaterial} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder material(javafx.scene.paint.Material value) {
        operations.add(obj -> obj.setMaterial(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setMesh(javafx.scene.shape.Mesh) setMesh} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder mesh(javafx.scene.shape.Mesh value) {
        operations.add(obj -> obj.setMesh(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setMouseTransparent(boolean) setMouseTransparent} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setNodeOrientation(javafx.geometry.NodeOrientation) setNodeOrientation} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnContextMenuRequested(javafx.event.EventHandler) setOnContextMenuRequested} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnDragDetected(javafx.event.EventHandler) setOnDragDetected} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnDragDone(javafx.event.EventHandler) setOnDragDone} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnDragDropped(javafx.event.EventHandler) setOnDragDropped} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnDragEntered(javafx.event.EventHandler) setOnDragEntered} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnDragExited(javafx.event.EventHandler) setOnDragExited} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnDragOver(javafx.event.EventHandler) setOnDragOver} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnInputMethodTextChanged(javafx.event.EventHandler) setOnInputMethodTextChanged} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnKeyPressed(javafx.event.EventHandler) setOnKeyPressed} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnKeyReleased(javafx.event.EventHandler) setOnKeyReleased} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnKeyTyped(javafx.event.EventHandler) setOnKeyTyped} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnMouseClicked(javafx.event.EventHandler) setOnMouseClicked} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnMouseDragEntered(javafx.event.EventHandler) setOnMouseDragEntered} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnMouseDragExited(javafx.event.EventHandler) setOnMouseDragExited} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnMouseDragOver(javafx.event.EventHandler) setOnMouseDragOver} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnMouseDragReleased(javafx.event.EventHandler) setOnMouseDragReleased} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnMouseDragged(javafx.event.EventHandler) setOnMouseDragged} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnMouseEntered(javafx.event.EventHandler) setOnMouseEntered} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnMouseExited(javafx.event.EventHandler) setOnMouseExited} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnMouseMoved(javafx.event.EventHandler) setOnMouseMoved} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnMousePressed(javafx.event.EventHandler) setOnMousePressed} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnMouseReleased(javafx.event.EventHandler) setOnMouseReleased} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnRotate(javafx.event.EventHandler) setOnRotate} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnRotationFinished(javafx.event.EventHandler) setOnRotationFinished} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnRotationStarted(javafx.event.EventHandler) setOnRotationStarted} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnScroll(javafx.event.EventHandler) setOnScroll} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnScrollFinished(javafx.event.EventHandler) setOnScrollFinished} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnScrollStarted(javafx.event.EventHandler) setOnScrollStarted} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnSwipeDown(javafx.event.EventHandler) setOnSwipeDown} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnSwipeLeft(javafx.event.EventHandler) setOnSwipeLeft} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnSwipeRight(javafx.event.EventHandler) setOnSwipeRight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnSwipeUp(javafx.event.EventHandler) setOnSwipeUp} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnTouchMoved(javafx.event.EventHandler) setOnTouchMoved} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnTouchPressed(javafx.event.EventHandler) setOnTouchPressed} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnTouchReleased(javafx.event.EventHandler) setOnTouchReleased} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnTouchStationary(javafx.event.EventHandler) setOnTouchStationary} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnZoom(javafx.event.EventHandler) setOnZoom} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnZoomFinished(javafx.event.EventHandler) setOnZoomFinished} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOnZoomStarted(javafx.event.EventHandler) setOnZoomStarted} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setOpacity(double) setOpacity} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setPickOnBounds(boolean) setPickOnBounds} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setRotate(double) setRotate} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setRotationAxis(javafx.geometry.Point3D) setRotationAxis} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setScaleX(double) setScaleX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setScaleY(double) setScaleY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setScaleZ(double) setScaleZ} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setStyle(java.lang.String) setStyle} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setTranslateX(double) setTranslateX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setTranslateY(double) setTranslateY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setTranslateZ(double) setTranslateZ} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setUserData(java.lang.Object) setUserData} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setViewOrder(double) setViewOrder} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.shape.MeshView#setVisible(boolean) setVisible} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  MeshViewBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.shape.MeshView#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final MeshViewBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.shape.MeshView#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final MeshViewBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.shape.MeshView#getTransforms()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final MeshViewBuilder addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.shape.MeshView#getTransforms()} method.
     * 
     * @return builder instance
     */
    public final MeshViewBuilder addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
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
    public MeshViewBuilder bottomAnchorInAnchorPane(java.lang.Double value) {
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
    public MeshViewBuilder leftAnchorInAnchorPane(java.lang.Double value) {
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
    public MeshViewBuilder rightAnchorInAnchorPane(java.lang.Double value) {
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
    public MeshViewBuilder topAnchorInAnchorPane(java.lang.Double value) {
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
    public MeshViewBuilder alignmentInBorderPane(javafx.geometry.Pos value) {
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
    public MeshViewBuilder marginInBorderPane(javafx.geometry.Insets value) {
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
    public MeshViewBuilder marginInFlowPane(javafx.geometry.Insets value) {
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
    public MeshViewBuilder columnIndexInGridPane(java.lang.Integer value) {
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
    public MeshViewBuilder columnSpanInGridPane(java.lang.Integer value) {
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
    public MeshViewBuilder constraintsInGridPane(int columnIndex, int rowIndex) {
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
    public MeshViewBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
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
    public MeshViewBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
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
    public MeshViewBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
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
    public MeshViewBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
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
    public MeshViewBuilder fillHeightInGridPane(java.lang.Boolean value) {
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
    public MeshViewBuilder fillWidthInGridPane(java.lang.Boolean value) {
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
    public MeshViewBuilder hAlignmentInGridPane(javafx.geometry.HPos value) {
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
    public MeshViewBuilder hGrowInGridPane(javafx.scene.layout.Priority value) {
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
    public MeshViewBuilder marginInGridPane(javafx.geometry.Insets value) {
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
    public MeshViewBuilder rowIndexInGridPane(java.lang.Integer value) {
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
    public MeshViewBuilder rowSpanInGridPane(java.lang.Integer value) {
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
    public MeshViewBuilder vAlignmentInGridPane(javafx.geometry.VPos value) {
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
    public MeshViewBuilder vGrowInGridPane(javafx.scene.layout.Priority value) {
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
    public MeshViewBuilder hGrowInHBox(javafx.scene.layout.Priority value) {
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
    public MeshViewBuilder marginInHBox(javafx.geometry.Insets value) {
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
    public MeshViewBuilder alignmentInStackPane(javafx.geometry.Pos value) {
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
    public MeshViewBuilder marginInStackPane(javafx.geometry.Insets value) {
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
    public MeshViewBuilder alignmentInTilePane(javafx.geometry.Pos value) {
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
    public MeshViewBuilder marginInTilePane(javafx.geometry.Insets value) {
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
    public MeshViewBuilder marginInVBox(javafx.geometry.Insets value) {
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
    public MeshViewBuilder vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }


    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#accessibleHelpProperty() accessibleHelpProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#accessibleRoleDescriptionProperty() accessibleRoleDescriptionProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#accessibleRoleProperty() accessibleRoleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#accessibleTextProperty() accessibleTextProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#blendModeProperty() blendModeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#boundsInLocalProperty() boundsInLocalProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#boundsInParentProperty() boundsInParentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#cacheHintProperty() cacheHintProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#cacheProperty() cacheProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#clipProperty() clipProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#cullFaceProperty() cullFaceProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.cullFaceProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .cullFacePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public MeshViewBuilder cullFacePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.CullFace>> op) {
        operations.add(obj -> op.accept(obj.cullFaceProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#cursorProperty() cursorProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#depthTestProperty() depthTestProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#disableProperty() disableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#disabledProperty() disabledProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#drawModeProperty() drawModeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.drawModeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .drawModePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public MeshViewBuilder drawModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.DrawMode>> op) {
        operations.add(obj -> op.accept(obj.drawModeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#effectProperty() effectProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#effectiveNodeOrientationProperty() effectiveNodeOrientationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#eventDispatcherProperty() eventDispatcherProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#focusTraversableProperty() focusTraversableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#focusVisibleProperty() focusVisibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#focusWithinProperty() focusWithinProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#focusedProperty() focusedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#hoverProperty() hoverProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#idProperty() idProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#inputMethodRequestsProperty() inputMethodRequestsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#layoutBoundsProperty() layoutBoundsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#layoutXProperty() layoutXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#layoutYProperty() layoutYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#localToParentTransformProperty() localToParentTransformProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#localToSceneTransformProperty() localToSceneTransformProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#managedProperty() managedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#materialProperty() materialProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.materialProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .materialPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public MeshViewBuilder materialPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Material>> op) {
        operations.add(obj -> op.accept(obj.materialProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#meshProperty() meshProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.meshProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .meshPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public MeshViewBuilder meshPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Mesh>> op) {
        operations.add(obj -> op.accept(obj.meshProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#mouseTransparentProperty() mouseTransparentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#nodeOrientationProperty() nodeOrientationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onContextMenuRequestedProperty() onContextMenuRequestedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onDragDetectedProperty() onDragDetectedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onDragDoneProperty() onDragDoneProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onDragDroppedProperty() onDragDroppedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onDragEnteredProperty() onDragEnteredProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onDragExitedProperty() onDragExitedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onDragOverProperty() onDragOverProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onInputMethodTextChangedProperty() onInputMethodTextChangedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onKeyPressedProperty() onKeyPressedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onKeyReleasedProperty() onKeyReleasedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onKeyTypedProperty() onKeyTypedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onMouseClickedProperty() onMouseClickedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onMouseDragEnteredProperty() onMouseDragEnteredProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onMouseDragExitedProperty() onMouseDragExitedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onMouseDragOverProperty() onMouseDragOverProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onMouseDragReleasedProperty() onMouseDragReleasedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onMouseDraggedProperty() onMouseDraggedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onMouseEnteredProperty() onMouseEnteredProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onMouseExitedProperty() onMouseExitedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onMouseMovedProperty() onMouseMovedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onMousePressedProperty() onMousePressedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onMouseReleasedProperty() onMouseReleasedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onRotateProperty() onRotateProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onRotationFinishedProperty() onRotationFinishedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onRotationStartedProperty() onRotationStartedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onScrollFinishedProperty() onScrollFinishedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onScrollProperty() onScrollProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onScrollStartedProperty() onScrollStartedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onSwipeDownProperty() onSwipeDownProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onSwipeLeftProperty() onSwipeLeftProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onSwipeRightProperty() onSwipeRightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onSwipeUpProperty() onSwipeUpProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onTouchMovedProperty() onTouchMovedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onTouchPressedProperty() onTouchPressedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onTouchReleasedProperty() onTouchReleasedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onTouchStationaryProperty() onTouchStationaryProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onZoomFinishedProperty() onZoomFinishedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onZoomProperty() onZoomProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#onZoomStartedProperty() onZoomStartedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#opacityProperty() opacityProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#parentProperty() parentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#pickOnBoundsProperty() pickOnBoundsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#pressedProperty() pressedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#rotateProperty() rotateProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#rotationAxisProperty() rotationAxisProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#scaleXProperty() scaleXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#scaleYProperty() scaleYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#scaleZProperty() scaleZProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#sceneProperty() sceneProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#styleProperty() styleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#translateXProperty() translateXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#translateYProperty() translateYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#translateZProperty() translateZProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#viewOrderProperty() viewOrderProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.shape.MeshView#visibleProperty() visibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.MeshView> func) apply} method.
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
    public MeshViewBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }
}
