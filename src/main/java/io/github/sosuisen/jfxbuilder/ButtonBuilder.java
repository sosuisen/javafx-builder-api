package io.github.sosuisen.jfxbuilder;
import javafx.event.ActionEvent;
import javafx.event.EventDispatcher;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.AccessibleRole;
import javafx.scene.CacheHint;
import javafx.scene.Cursor;
import javafx.scene.DepthTest;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.Skin;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Effect;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.InputMethodRequests;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.RotateEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class ButtonBuilder {
    private Button in;
    public static  ButtonBuilder create(String text) { return new ButtonBuilder(text); }
    private ButtonBuilder(String text) { in = new Button(text); }
    public static  ButtonBuilder create(String text, Node graphic) { return new ButtonBuilder(text, graphic); }
    private ButtonBuilder(String text, Node graphic) { in = new Button(text, graphic); }
    public static  ButtonBuilder create() { return new ButtonBuilder(); }
    private ButtonBuilder() { in = new Button(); }
    public Button build() { return in; }
    public ButtonBuilder apply(java.util.function.Consumer<Button> func) {
        func.accept((Button) in);
        return this;
    }
    public  ButtonBuilder defaultButton(boolean value) { in.setDefaultButton(value); return this; }
    public  ButtonBuilder cancelButton(boolean value) { in.setCancelButton(value); return this; }
    public  ButtonBuilder onAction(EventHandler<ActionEvent> value) { in.setOnAction(value); return this; }
    public  ButtonBuilder mnemonicParsing(boolean value) { in.setMnemonicParsing(value); return this; }
    public  ButtonBuilder textAlignment(TextAlignment value) { in.setTextAlignment(value); return this; }
    public  ButtonBuilder textFill(Paint value) { in.setTextFill(value); return this; }
    public  ButtonBuilder textOverrun(OverrunStyle value) { in.setTextOverrun(value); return this; }
    public  ButtonBuilder contentDisplay(ContentDisplay value) { in.setContentDisplay(value); return this; }
    public  ButtonBuilder wrapText(boolean value) { in.setWrapText(value); return this; }
    public  ButtonBuilder ellipsisString(String value) { in.setEllipsisString(value); return this; }
    public  ButtonBuilder lineSpacing(double value) { in.setLineSpacing(value); return this; }
    public  ButtonBuilder alignment(Pos value) { in.setAlignment(value); return this; }
    public  ButtonBuilder graphicTextGap(double value) { in.setGraphicTextGap(value); return this; }
    public  ButtonBuilder underline(boolean value) { in.setUnderline(value); return this; }
    public  ButtonBuilder font(Font value) { in.setFont(value); return this; }
    public  ButtonBuilder graphic(Node value) { in.setGraphic(value); return this; }
    public  ButtonBuilder text(String value) { in.setText(value); return this; }
    public  ButtonBuilder tooltip(Tooltip value) { in.setTooltip(value); return this; }
    public  ButtonBuilder skin(Skin<?> value) { in.setSkin(value); return this; }
    public  ButtonBuilder contextMenu(ContextMenu value) { in.setContextMenu(value); return this; }
    public  ButtonBuilder shape(Shape value) { in.setShape(value); return this; }
    public  ButtonBuilder padding(Insets value) { in.setPadding(value); return this; }
    public  ButtonBuilder maxSize(double maxWidth, double maxHeight) { in.setMaxSize(maxWidth, maxHeight); return this; }
    public  ButtonBuilder minSize(double minWidth, double minHeight) { in.setMinSize(minWidth, minHeight); return this; }
    public  ButtonBuilder border(Border value) { in.setBorder(value); return this; }
    public  ButtonBuilder opaqueInsets(Insets value) { in.setOpaqueInsets(value); return this; }
    public  ButtonBuilder snapToPixel(boolean value) { in.setSnapToPixel(value); return this; }
    public  ButtonBuilder background(Background value) { in.setBackground(value); return this; }
    public  ButtonBuilder centerShape(boolean value) { in.setCenterShape(value); return this; }
    public  ButtonBuilder scaleShape(boolean value) { in.setScaleShape(value); return this; }
    public  ButtonBuilder cacheShape(boolean value) { in.setCacheShape(value); return this; }
    public  ButtonBuilder prefSize(double prefWidth, double prefHeight) { in.setPrefSize(prefWidth, prefHeight); return this; }
    public  ButtonBuilder minHeight(double value) { in.setMinHeight(value); return this; }
    public  ButtonBuilder minWidth(double value) { in.setMinWidth(value); return this; }
    public  ButtonBuilder prefHeight(double value) { in.setPrefHeight(value); return this; }
    public  ButtonBuilder prefWidth(double value) { in.setPrefWidth(value); return this; }
    public  ButtonBuilder maxWidth(double value) { in.setMaxWidth(value); return this; }
    public  ButtonBuilder maxHeight(double value) { in.setMaxHeight(value); return this; }
    public  ButtonBuilder accessibleRole(AccessibleRole value) { in.setAccessibleRole(value); return this; }
    public  ButtonBuilder opacity(double value) { in.setOpacity(value); return this; }
    public  ButtonBuilder effect(Effect value) { in.setEffect(value); return this; }
    public  ButtonBuilder visible(boolean value) { in.setVisible(value); return this; }
    public  ButtonBuilder layoutY(double value) { in.setLayoutY(value); return this; }
    public  ButtonBuilder layoutX(double value) { in.setLayoutX(value); return this; }
    public  ButtonBuilder id(String value) { in.setId(value); return this; }
    public  ButtonBuilder managed(boolean value) { in.setManaged(value); return this; }
    public  ButtonBuilder clip(Node value) { in.setClip(value); return this; }
    public  ButtonBuilder disable(boolean value) { in.setDisable(value); return this; }
    public  ButtonBuilder cursor(Cursor value) { in.setCursor(value); return this; }
    public  ButtonBuilder style(String value) { in.setStyle(value); return this; }
    public  ButtonBuilder onZoom(EventHandler<? super ZoomEvent> value) { in.setOnZoom(value); return this; }
    public  ButtonBuilder scaleY(double value) { in.setScaleY(value); return this; }
    public  ButtonBuilder rotate(double value) { in.setRotate(value); return this; }
    public  ButtonBuilder scaleX(double value) { in.setScaleX(value); return this; }
    public  ButtonBuilder scaleZ(double value) { in.setScaleZ(value); return this; }
    public  ButtonBuilder pickOnBounds(boolean value) { in.setPickOnBounds(value); return this; }
    public  ButtonBuilder onInputMethodTextChanged(EventHandler<? super InputMethodEvent> value) { in.setOnInputMethodTextChanged(value); return this; }
    public  ButtonBuilder accessibleRoleDescription(String value) { in.setAccessibleRoleDescription(value); return this; }
    public  ButtonBuilder depthTest(DepthTest value) { in.setDepthTest(value); return this; }
    public  ButtonBuilder viewOrder(double value) { in.setViewOrder(value); return this; }
    public  ButtonBuilder userData(Object value) { in.setUserData(value); return this; }
    public  ButtonBuilder onDragEntered(EventHandler<? super DragEvent> value) { in.setOnDragEntered(value); return this; }
    public  ButtonBuilder onDragDropped(EventHandler<? super DragEvent> value) { in.setOnDragDropped(value); return this; }
    public  ButtonBuilder blendMode(BlendMode value) { in.setBlendMode(value); return this; }
    public  ButtonBuilder onMouseClicked(EventHandler<? super MouseEvent> value) { in.setOnMouseClicked(value); return this; }
    public  ButtonBuilder nodeOrientation(NodeOrientation orientation) { in.setNodeOrientation(orientation); return this; }
    public  ButtonBuilder onDragOver(EventHandler<? super DragEvent> value) { in.setOnDragOver(value); return this; }
    public  ButtonBuilder onMouseDragged(EventHandler<? super MouseEvent> value) { in.setOnMouseDragged(value); return this; }
    public  ButtonBuilder onMouseEntered(EventHandler<? super MouseEvent> value) { in.setOnMouseEntered(value); return this; }
    public  ButtonBuilder rotationAxis(Point3D value) { in.setRotationAxis(value); return this; }
    public  ButtonBuilder translateX(double value) { in.setTranslateX(value); return this; }
    public  ButtonBuilder onMouseMoved(EventHandler<? super MouseEvent> value) { in.setOnMouseMoved(value); return this; }
    public  ButtonBuilder onMousePressed(EventHandler<? super MouseEvent> value) { in.setOnMousePressed(value); return this; }
    public  ButtonBuilder onDragDone(EventHandler<? super DragEvent> value) { in.setOnDragDone(value); return this; }
    public  ButtonBuilder onDragExited(EventHandler<? super DragEvent> value) { in.setOnDragExited(value); return this; }
    public  ButtonBuilder onDragDetected(EventHandler<? super MouseEvent> value) { in.setOnDragDetected(value); return this; }
    public  ButtonBuilder onMouseExited(EventHandler<? super MouseEvent> value) { in.setOnMouseExited(value); return this; }
    public  ButtonBuilder onMouseDragOver(EventHandler<? super MouseDragEvent> value) { in.setOnMouseDragOver(value); return this; }
    public  ButtonBuilder translateY(double value) { in.setTranslateY(value); return this; }
    public  ButtonBuilder cacheHint(CacheHint value) { in.setCacheHint(value); return this; }
    public  ButtonBuilder onRotate(EventHandler<? super RotateEvent> value) { in.setOnRotate(value); return this; }
    public  ButtonBuilder onZoomFinished(EventHandler<? super ZoomEvent> value) { in.setOnZoomFinished(value); return this; }
    public  ButtonBuilder onSwipeUp(EventHandler<? super SwipeEvent> value) { in.setOnSwipeUp(value); return this; }
    public  ButtonBuilder translateZ(double value) { in.setTranslateZ(value); return this; }
    public  ButtonBuilder onZoomStarted(EventHandler<? super ZoomEvent> value) { in.setOnZoomStarted(value); return this; }
    public  ButtonBuilder onMouseReleased(EventHandler<? super MouseEvent> value) { in.setOnMouseReleased(value); return this; }
    public  ButtonBuilder onScroll(EventHandler<? super ScrollEvent> value) { in.setOnScroll(value); return this; }
    public  ButtonBuilder onScrollStarted(EventHandler<? super ScrollEvent> value) { in.setOnScrollStarted(value); return this; }
    public  ButtonBuilder onSwipeDown(EventHandler<? super SwipeEvent> value) { in.setOnSwipeDown(value); return this; }
    public  ButtonBuilder onSwipeLeft(EventHandler<? super SwipeEvent> value) { in.setOnSwipeLeft(value); return this; }
    public  ButtonBuilder onSwipeRight(EventHandler<? super SwipeEvent> value) { in.setOnSwipeRight(value); return this; }
    public  ButtonBuilder onKeyReleased(EventHandler<? super KeyEvent> value) { in.setOnKeyReleased(value); return this; }
    public  ButtonBuilder onTouchReleased(EventHandler<? super TouchEvent> value) { in.setOnTouchReleased(value); return this; }
    public  ButtonBuilder onKeyTyped(EventHandler<? super KeyEvent> value) { in.setOnKeyTyped(value); return this; }
    public  ButtonBuilder eventDispatcher(EventDispatcher value) { in.setEventDispatcher(value); return this; }
    public  ButtonBuilder accessibleText(String value) { in.setAccessibleText(value); return this; }
    public  ButtonBuilder accessibleHelp(String value) { in.setAccessibleHelp(value); return this; }
    public  ButtonBuilder onTouchMoved(EventHandler<? super TouchEvent> value) { in.setOnTouchMoved(value); return this; }
    public  ButtonBuilder onTouchPressed(EventHandler<? super TouchEvent> value) { in.setOnTouchPressed(value); return this; }
    public  ButtonBuilder onKeyPressed(EventHandler<? super KeyEvent> value) { in.setOnKeyPressed(value); return this; }
    public  ButtonBuilder mouseTransparent(boolean value) { in.setMouseTransparent(value); return this; }
    public  ButtonBuilder onContextMenuRequested(EventHandler<? super ContextMenuEvent> value) { in.setOnContextMenuRequested(value); return this; }
    public  ButtonBuilder onMouseDragEntered(EventHandler<? super MouseDragEvent> value) { in.setOnMouseDragEntered(value); return this; }
    public  ButtonBuilder onMouseDragReleased(EventHandler<? super MouseDragEvent> value) { in.setOnMouseDragReleased(value); return this; }
    public  ButtonBuilder onMouseDragExited(EventHandler<? super MouseDragEvent> value) { in.setOnMouseDragExited(value); return this; }
    public  ButtonBuilder onScrollFinished(EventHandler<? super ScrollEvent> value) { in.setOnScrollFinished(value); return this; }
    public  ButtonBuilder onRotationStarted(EventHandler<? super RotateEvent> value) { in.setOnRotationStarted(value); return this; }
    public  ButtonBuilder onRotationFinished(EventHandler<? super RotateEvent> value) { in.setOnRotationFinished(value); return this; }
    public  ButtonBuilder onTouchStationary(EventHandler<? super TouchEvent> value) { in.setOnTouchStationary(value); return this; }
    public  ButtonBuilder inputMethodRequests(InputMethodRequests value) { in.setInputMethodRequests(value); return this; }
    public  ButtonBuilder focusTraversable(boolean value) { in.setFocusTraversable(value); return this; }
    public  ButtonBuilder cache(boolean value) { in.setCache(value); return this; }
}
