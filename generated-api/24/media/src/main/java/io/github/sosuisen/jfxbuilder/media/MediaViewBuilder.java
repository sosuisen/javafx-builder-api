
package io.github.sosuisen.jfxbuilder.media;

/**
 * The {@code MediaViewBuilder} class constructs instances of the {@link javafx.scene.media.MediaView MediaView} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.media.MediaView MediaView} constructor
 * and returns an instance of the {@code MediaViewBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.media.MediaView MediaView}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.media.MediaView MediaView} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class MediaViewBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.media.MediaView>> operations = new java.util.ArrayList<>();
    private MediaViewBuilder() {}
    

    /**
     * Returns an instance of the {@code MediaViewBuilder}.
     *
     * @return an instance of the {@code MediaViewBuilder}.
     */
    public static MediaViewBuilder create() { return new MediaViewBuilder(); }


    /**
     * Accepts the same arguments as {@link javafx.scene.media.MediaView#MediaView(MediaPlayer) MediaView(MediaPlayer)}
     * and returns an instance of the {@code MediaViewBuilder}.
     *
     * @return an instance of the {@code MediaViewBuilder}.
     */
    
    public static MediaViewBuilder create(javafx.scene.media.MediaPlayer mediaPlayer) {
        MediaViewBuilder builder = new MediaViewBuilder();
        builder.constructorArgs = new Object[]{mediaPlayer};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.media.MediaView} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.media.MediaView MediaView} class
     */
    public javafx.scene.media.MediaView build() {
        javafx.scene.media.MediaView newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.media.MediaView();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.media.MediaView> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.media.MediaView callParameterizedConstructor() {
        javafx.scene.media.MediaView newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.media.MediaView.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.media.MediaView) constructor.newInstance(constructorArgs);
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
     * Applies a function to the MediaView instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(mediaView -> mediaView.setId("Main" + mediaView.getTypeSelector()))
     * }</pre>
     *
     * @return builder instance
     *
     */
    public MediaViewBuilder apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setFitHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder fitHeight(double value) {
        operations.add(obj -> obj.setFitHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setFitWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder fitWidth(double value) {
        operations.add(obj -> obj.setFitWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setMediaPlayer(javafx.scene.media.MediaPlayer)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder mediaPlayer(javafx.scene.media.MediaPlayer value) {
        operations.add(obj -> obj.setMediaPlayer(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnError(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onError(javafx.event.EventHandler<javafx.scene.media.MediaErrorEvent> value) {
        operations.add(obj -> obj.setOnError(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setPreserveRatio(boolean)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder preserveRatio(boolean value) {
        operations.add(obj -> obj.setPreserveRatio(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setSmooth(boolean)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder smooth(boolean value) {
        operations.add(obj -> obj.setSmooth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setViewport(javafx.geometry.Rectangle2D)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder viewport(javafx.geometry.Rectangle2D value) {
        operations.add(obj -> obj.setViewport(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setX(double)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaView#setY(double)}
     * 
     * @return builder instance
     */    
    
    public  MediaViewBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.media.MediaView#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final MediaViewBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.media.MediaView#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final MediaViewBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.media.MediaView#getTransforms()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final MediaViewBuilder addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.media.MediaView#getTransforms()} method.
     * 
     * @return builder instance
     */
    public final MediaViewBuilder addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
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
     *                                  ButtonBuilder.create()
     *                                               .bottomAnchorInAnchorPane(new Insets(10))
     *                                               .build())
     *                             .build();
     * }</pre>
     *
     * @return builder instance
     */
    public MediaViewBuilder bottomAnchorInAnchorPane(java.lang.Double value) {
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
    public MediaViewBuilder leftAnchorInAnchorPane(java.lang.Double value) {
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
    public MediaViewBuilder rightAnchorInAnchorPane(java.lang.Double value) {
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
    public MediaViewBuilder topAnchorInAnchorPane(java.lang.Double value) {
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
    public MediaViewBuilder alignmentInBorderPane(javafx.geometry.Pos value) {
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
    public MediaViewBuilder marginInBorderPane(javafx.geometry.Insets value) {
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
    public MediaViewBuilder marginInFlowPane(javafx.geometry.Insets value) {
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
    public MediaViewBuilder columnIndexInGridPane(java.lang.Integer value) {
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
    public MediaViewBuilder columnSpanInGridPane(java.lang.Integer value) {
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
    public MediaViewBuilder constraintsInGridPane(int columnIndex, int rowIndex) {
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
    public MediaViewBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
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
    public MediaViewBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
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
    public MediaViewBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
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
    public MediaViewBuilder constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
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
    public MediaViewBuilder fillHeightInGridPane(java.lang.Boolean value) {
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
    public MediaViewBuilder fillWidthInGridPane(java.lang.Boolean value) {
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
    public MediaViewBuilder hAlignmentInGridPane(javafx.geometry.HPos value) {
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
    public MediaViewBuilder hGrowInGridPane(javafx.scene.layout.Priority value) {
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
    public MediaViewBuilder marginInGridPane(javafx.geometry.Insets value) {
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
    public MediaViewBuilder rowIndexInGridPane(java.lang.Integer value) {
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
    public MediaViewBuilder rowSpanInGridPane(java.lang.Integer value) {
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
    public MediaViewBuilder vAlignmentInGridPane(javafx.geometry.VPos value) {
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
    public MediaViewBuilder vGrowInGridPane(javafx.scene.layout.Priority value) {
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
    public MediaViewBuilder hGrowInHBox(javafx.scene.layout.Priority value) {
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
    public MediaViewBuilder marginInHBox(javafx.geometry.Insets value) {
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
    public MediaViewBuilder alignmentInStackPane(javafx.geometry.Pos value) {
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
    public MediaViewBuilder marginInStackPane(javafx.geometry.Insets value) {
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
    public MediaViewBuilder alignmentInTilePane(javafx.geometry.Pos value) {
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
    public MediaViewBuilder marginInTilePane(javafx.geometry.Insets value) {
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
    public MediaViewBuilder marginInVBox(javafx.geometry.Insets value) {
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
    public MediaViewBuilder vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }
    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#accessibleHelpProperty() accessibleHelpProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#accessibleRoleDescriptionProperty() accessibleRoleDescriptionProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#accessibleRoleProperty() accessibleRoleProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#accessibleTextProperty() accessibleTextProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#blendModeProperty() blendModeProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#boundsInLocalProperty() boundsInLocalProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#boundsInParentProperty() boundsInParentProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#cacheHintProperty() cacheHintProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#cacheProperty() cacheProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#clipProperty() clipProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#cursorProperty() cursorProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#depthTestProperty() depthTestProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#disableProperty() disableProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#disabledProperty() disabledProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#effectProperty() effectProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#effectiveNodeOrientationProperty() effectiveNodeOrientationProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#eventDispatcherProperty() eventDispatcherProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#fitHeightProperty() fitHeightProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.fitHeightProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .fitHeightPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaViewBuilder fitHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.fitHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#fitWidthProperty() fitWidthProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.fitWidthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .fitWidthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaViewBuilder fitWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.fitWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#focusTraversableProperty() focusTraversableProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#focusVisibleProperty() focusVisibleProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#focusWithinProperty() focusWithinProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#focusedProperty() focusedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#hoverProperty() hoverProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#idProperty() idProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#inputMethodRequestsProperty() inputMethodRequestsProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#layoutBoundsProperty() layoutBoundsProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#layoutXProperty() layoutXProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#layoutYProperty() layoutYProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#localToParentTransformProperty() localToParentTransformProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#localToSceneTransformProperty() localToSceneTransformProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#managedProperty() managedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#mediaPlayerProperty() mediaPlayerProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.mediaPlayerProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .mediaPlayerPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaViewBuilder mediaPlayerPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.media.MediaPlayer>> op) {
        operations.add(obj -> op.accept(obj.mediaPlayerProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#mouseTransparentProperty() mouseTransparentProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#nodeOrientationProperty() nodeOrientationProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onContextMenuRequestedProperty() onContextMenuRequestedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onDragDetectedProperty() onDragDetectedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onDragDoneProperty() onDragDoneProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onDragDroppedProperty() onDragDroppedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onDragEnteredProperty() onDragEnteredProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onDragExitedProperty() onDragExitedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onDragOverProperty() onDragOverProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onErrorProperty() onErrorProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onErrorProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onErrorPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaViewBuilder onErrorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.media.MediaErrorEvent>>> op) {
        operations.add(obj -> op.accept(obj.onErrorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onInputMethodTextChangedProperty() onInputMethodTextChangedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onKeyPressedProperty() onKeyPressedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onKeyReleasedProperty() onKeyReleasedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onKeyTypedProperty() onKeyTypedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onMouseClickedProperty() onMouseClickedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onMouseDragEnteredProperty() onMouseDragEnteredProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onMouseDragExitedProperty() onMouseDragExitedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onMouseDragOverProperty() onMouseDragOverProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onMouseDragReleasedProperty() onMouseDragReleasedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onMouseDraggedProperty() onMouseDraggedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onMouseEnteredProperty() onMouseEnteredProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onMouseExitedProperty() onMouseExitedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onMouseMovedProperty() onMouseMovedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onMousePressedProperty() onMousePressedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onMouseReleasedProperty() onMouseReleasedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onRotateProperty() onRotateProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onRotationFinishedProperty() onRotationFinishedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onRotationStartedProperty() onRotationStartedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onScrollFinishedProperty() onScrollFinishedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onScrollProperty() onScrollProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onScrollStartedProperty() onScrollStartedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onSwipeDownProperty() onSwipeDownProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onSwipeLeftProperty() onSwipeLeftProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onSwipeRightProperty() onSwipeRightProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onSwipeUpProperty() onSwipeUpProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onTouchMovedProperty() onTouchMovedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onTouchPressedProperty() onTouchPressedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onTouchReleasedProperty() onTouchReleasedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onTouchStationaryProperty() onTouchStationaryProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onZoomFinishedProperty() onZoomFinishedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onZoomProperty() onZoomProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#onZoomStartedProperty() onZoomStartedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#opacityProperty() opacityProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#parentProperty() parentProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#pickOnBoundsProperty() pickOnBoundsProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#preserveRatioProperty() preserveRatioProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.preserveRatioProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .preserveRatioPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaViewBuilder preserveRatioPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.preserveRatioProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#pressedProperty() pressedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#rotateProperty() rotateProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#rotationAxisProperty() rotationAxisProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#scaleXProperty() scaleXProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#scaleYProperty() scaleYProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#scaleZProperty() scaleZProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#sceneProperty() sceneProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#smoothProperty() smoothProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.smoothProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .smoothPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaViewBuilder smoothPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.smoothProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#styleProperty() styleProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#translateXProperty() translateXProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#translateYProperty() translateYProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#translateZProperty() translateZProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#viewOrderProperty() viewOrderProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#viewportProperty() viewportProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.viewportProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .viewportPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaViewBuilder viewportPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Rectangle2D>> op) {
        operations.add(obj -> op.accept(obj.viewportProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#visibleProperty() visibleProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
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
    
    public MediaViewBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#xProperty() xProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.xProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .xPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaViewBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaView#yProperty() yProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaView> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.yProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .yPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaViewBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
