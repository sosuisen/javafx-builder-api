package io.github.sosuisen.jfxbuilder;
import javafx.event.EventDispatcher;
import javafx.event.EventHandler;
import javafx.geometry.NodeOrientation;
import javafx.scene.Camera;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.RotateEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.paint.Paint;

public class SceneBuilder {
    private Scene instance;
    private Object[] constructorArgs;
    private Object[] mandatoryParams;
    private java.util.List<java.util.function.Consumer<Scene>> operations = new java.util.ArrayList<>();
    public static  SceneBuilder withRoot(Parent root) {
        SceneBuilder builder = new SceneBuilder();
        builder.mandatoryParams = new Object[]{root};
        return builder;
    }
    private SceneBuilder() {}
    public Scene build() {
        if (instance == null) {
            // Use reflection for parameterized constructor
            try {
                Object[] args = (constructorArgs != null) ? constructorArgs : mandatoryParams;
                java.lang.reflect.Constructor<?>[] constructors = Scene.class.getConstructors();
                for (java.lang.reflect.Constructor<?> constructor : constructors) {
                    if (constructor.getParameterCount() == args.length) {
                        instance = (Scene) constructor.newInstance(args);
                        break;
                    }
                }
                if (instance == null) {
                    throw new RuntimeException("No suitable constructor found");
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed to create instance", e);
            }
            for (java.util.function.Consumer<Scene> op : operations) {
                op.accept(instance);
            }
        }
        return instance;
    }
    public SceneBuilder apply(java.util.function.Consumer<Scene> func) {
        operations.add(func);
        return this;
    }
    public  SceneBuilder root(Parent value) {
        operations.add(obj -> obj.setRoot(value));
        return this;
    }
    public  SceneBuilder userAgentStylesheet(String url) {
        operations.add(obj -> obj.setUserAgentStylesheet(url));
        return this;
    }
    public  SceneBuilder fill(Paint value) {
        operations.add(obj -> obj.setFill(value));
        return this;
    }
    public  SceneBuilder camera(Camera value) {
        operations.add(obj -> obj.setCamera(value));
        return this;
    }
    public  SceneBuilder onInputMethodTextChanged(EventHandler<? super InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    public  SceneBuilder onRotationStarted(EventHandler<? super RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    public  SceneBuilder onTouchStationary(EventHandler<? super TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    public  SceneBuilder onContextMenuRequested(EventHandler<? super ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    public  SceneBuilder onMouseDragEntered(EventHandler<? super MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    public  SceneBuilder onMouseDragExited(EventHandler<? super MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    public  SceneBuilder onScrollFinished(EventHandler<? super ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    public  SceneBuilder onRotationFinished(EventHandler<? super RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    public  SceneBuilder onMouseDragReleased(EventHandler<? super MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    public  SceneBuilder cursor(Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    public  SceneBuilder onZoom(EventHandler<? super ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    public  SceneBuilder onDragDone(EventHandler<? super DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    public  SceneBuilder onDragDropped(EventHandler<? super DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    public  SceneBuilder onDragEntered(EventHandler<? super DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    public  SceneBuilder onDragOver(EventHandler<? super DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    public  SceneBuilder userData(Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    public  SceneBuilder onDragExited(EventHandler<? super DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    public  SceneBuilder onDragDetected(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    public  SceneBuilder onScrollStarted(EventHandler<? super ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    public  SceneBuilder onSwipeRight(EventHandler<? super SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    public  SceneBuilder onTouchMoved(EventHandler<? super TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    public  SceneBuilder onTouchPressed(EventHandler<? super TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    public  SceneBuilder onMouseClicked(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    public  SceneBuilder onMouseDragOver(EventHandler<? super MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    public  SceneBuilder onMouseEntered(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    public  SceneBuilder onKeyTyped(EventHandler<? super KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    public  SceneBuilder onMouseMoved(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    public  SceneBuilder onMouseDragged(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    public  SceneBuilder onTouchReleased(EventHandler<? super TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    public  SceneBuilder onSwipeDown(EventHandler<? super SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    public  SceneBuilder onScroll(EventHandler<? super ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    public  SceneBuilder onKeyReleased(EventHandler<? super KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    public  SceneBuilder onSwipeLeft(EventHandler<? super SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    public  SceneBuilder onMousePressed(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    public  SceneBuilder onKeyPressed(EventHandler<? super KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    public  SceneBuilder eventDispatcher(EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    public  SceneBuilder onZoomStarted(EventHandler<? super ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    public  SceneBuilder onZoomFinished(EventHandler<? super ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    public  SceneBuilder onMouseExited(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    public  SceneBuilder onRotate(EventHandler<? super RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    public  SceneBuilder onMouseReleased(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    public  SceneBuilder onSwipeUp(EventHandler<? super SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    public  SceneBuilder nodeOrientation(NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
}
