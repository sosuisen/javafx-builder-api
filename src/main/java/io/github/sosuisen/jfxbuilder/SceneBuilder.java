package io.github.sosuisen.jfxbuilder;
import javafx.event.EventDispatcher;
import javafx.event.EventHandler;
import javafx.geometry.NodeOrientation;
import javafx.scene.Camera;
import javafx.scene.Cursor;
import javafx.scene.Node;
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
    private Scene in;
    public static  SceneBuilder create(Parent root, double width, double height, Paint fill) { return new SceneBuilder(root, width, height, fill); }
    private SceneBuilder(Parent root, double width, double height, Paint fill) { in = new Scene(root, width, height, fill); }
    public static  SceneBuilder create(Parent root, double width, double height, boolean depthBuffer) { return new SceneBuilder(root, width, height, depthBuffer); }
    private SceneBuilder(Parent root, double width, double height, boolean depthBuffer) { in = new Scene(root, width, height, depthBuffer); }
    public static  SceneBuilder create(Parent root, double width, double height, boolean depthBuffer, SceneAntialiasing antiAliasing) { return new SceneBuilder(root, width, height, depthBuffer, antiAliasing); }
    private SceneBuilder(Parent root, double width, double height, boolean depthBuffer, SceneAntialiasing antiAliasing) { in = new Scene(root, width, height, depthBuffer, antiAliasing); }
    public static  SceneBuilder create(Parent root) { return new SceneBuilder(root); }
    private SceneBuilder(Parent root) { in = new Scene(root); }
    public static  SceneBuilder create(Parent root, double width, double height) { return new SceneBuilder(root, width, height); }
    private SceneBuilder(Parent root, double width, double height) { in = new Scene(root, width, height); }
    public static  SceneBuilder create(Parent root, Paint fill) { return new SceneBuilder(root, fill); }
    private SceneBuilder(Parent root, Paint fill) { in = new Scene(root, fill); }
    public Scene build() { return in; }
    public SceneBuilder apply(java.util.function.Consumer<Scene> func) {
        func.accept((Scene) in);
        return this;
    }
    public  SceneBuilder root(Parent value) { in.setRoot(value); return this; }
    public  SceneBuilder onInputMethodTextChanged(EventHandler<? super InputMethodEvent> value) { in.setOnInputMethodTextChanged(value); return this; }
    public  SceneBuilder onMouseExited(EventHandler<? super MouseEvent> value) { in.setOnMouseExited(value); return this; }
    public  SceneBuilder onDragDetected(EventHandler<? super MouseEvent> value) { in.setOnDragDetected(value); return this; }
    public  SceneBuilder onMouseClicked(EventHandler<? super MouseEvent> value) { in.setOnMouseClicked(value); return this; }
    public  SceneBuilder onScroll(EventHandler<? super ScrollEvent> value) { in.setOnScroll(value); return this; }
    public  SceneBuilder onKeyTyped(EventHandler<? super KeyEvent> value) { in.setOnKeyTyped(value); return this; }
    public  SceneBuilder onSwipeLeft(EventHandler<? super SwipeEvent> value) { in.setOnSwipeLeft(value); return this; }
    public  SceneBuilder onTouchReleased(EventHandler<? super TouchEvent> value) { in.setOnTouchReleased(value); return this; }
    public  SceneBuilder onRotate(EventHandler<? super RotateEvent> value) { in.setOnRotate(value); return this; }
    public  SceneBuilder onMouseEntered(EventHandler<? super MouseEvent> value) { in.setOnMouseEntered(value); return this; }
    public  SceneBuilder onSwipeRight(EventHandler<? super SwipeEvent> value) { in.setOnSwipeRight(value); return this; }
    public  SceneBuilder onScrollStarted(EventHandler<? super ScrollEvent> value) { in.setOnScrollStarted(value); return this; }
    public  SceneBuilder onMouseDragged(EventHandler<? super MouseEvent> value) { in.setOnMouseDragged(value); return this; }
    public  SceneBuilder onMouseMoved(EventHandler<? super MouseEvent> value) { in.setOnMouseMoved(value); return this; }
    public  SceneBuilder onMousePressed(EventHandler<? super MouseEvent> value) { in.setOnMousePressed(value); return this; }
    public  SceneBuilder onMouseReleased(EventHandler<? super MouseEvent> value) { in.setOnMouseReleased(value); return this; }
    public  SceneBuilder eventDispatcher(EventDispatcher value) { in.setEventDispatcher(value); return this; }
    public  SceneBuilder onZoomFinished(EventHandler<? super ZoomEvent> value) { in.setOnZoomFinished(value); return this; }
    public  SceneBuilder onKeyPressed(EventHandler<? super KeyEvent> value) { in.setOnKeyPressed(value); return this; }
    public  SceneBuilder onSwipeDown(EventHandler<? super SwipeEvent> value) { in.setOnSwipeDown(value); return this; }
    public  SceneBuilder onTouchPressed(EventHandler<? super TouchEvent> value) { in.setOnTouchPressed(value); return this; }
    public  SceneBuilder onKeyReleased(EventHandler<? super KeyEvent> value) { in.setOnKeyReleased(value); return this; }
    public  SceneBuilder onZoomStarted(EventHandler<? super ZoomEvent> value) { in.setOnZoomStarted(value); return this; }
    public  SceneBuilder onTouchMoved(EventHandler<? super TouchEvent> value) { in.setOnTouchMoved(value); return this; }
    public  SceneBuilder onMouseDragOver(EventHandler<? super MouseDragEvent> value) { in.setOnMouseDragOver(value); return this; }
    public  SceneBuilder onSwipeUp(EventHandler<? super SwipeEvent> value) { in.setOnSwipeUp(value); return this; }
    public  SceneBuilder onDragOver(EventHandler<? super DragEvent> value) { in.setOnDragOver(value); return this; }
    public  SceneBuilder userData(Object value) { in.setUserData(value); return this; }
    public  SceneBuilder onDragDropped(EventHandler<? super DragEvent> value) { in.setOnDragDropped(value); return this; }
    public  SceneBuilder onDragDone(EventHandler<? super DragEvent> value) { in.setOnDragDone(value); return this; }
    public  SceneBuilder nodeOrientation(NodeOrientation orientation) { in.setNodeOrientation(orientation); return this; }
    public  SceneBuilder onDragExited(EventHandler<? super DragEvent> value) { in.setOnDragExited(value); return this; }
    public  SceneBuilder onDragEntered(EventHandler<? super DragEvent> value) { in.setOnDragEntered(value); return this; }
    public  SceneBuilder userAgentStylesheet(String url) { in.setUserAgentStylesheet(url); return this; }
    public  SceneBuilder camera(Camera value) { in.setCamera(value); return this; }
    public  SceneBuilder fill(Paint value) { in.setFill(value); return this; }
    public  SceneBuilder cursor(Cursor value) { in.setCursor(value); return this; }
    public  SceneBuilder onMouseDragReleased(EventHandler<? super MouseDragEvent> value) { in.setOnMouseDragReleased(value); return this; }
    public  SceneBuilder onMouseDragEntered(EventHandler<? super MouseDragEvent> value) { in.setOnMouseDragEntered(value); return this; }
    public  SceneBuilder onMouseDragExited(EventHandler<? super MouseDragEvent> value) { in.setOnMouseDragExited(value); return this; }
    public  SceneBuilder onScrollFinished(EventHandler<? super ScrollEvent> value) { in.setOnScrollFinished(value); return this; }
    public  SceneBuilder onRotationStarted(EventHandler<? super RotateEvent> value) { in.setOnRotationStarted(value); return this; }
    public  SceneBuilder onRotationFinished(EventHandler<? super RotateEvent> value) { in.setOnRotationFinished(value); return this; }
    public  SceneBuilder onContextMenuRequested(EventHandler<? super ContextMenuEvent> value) { in.setOnContextMenuRequested(value); return this; }
    public  SceneBuilder onTouchStationary(EventHandler<? super TouchEvent> value) { in.setOnTouchStationary(value); return this; }
    public  SceneBuilder onZoom(EventHandler<? super ZoomEvent> value) { in.setOnZoom(value); return this; }
}
