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
    private Button instance;
    private Object[] constructorArgs;
    private Object[] mandatoryParams;
    private java.util.List<java.util.function.Consumer<Button>> operations = new java.util.ArrayList<>();
    public static  ButtonBuilder create() { return new ButtonBuilder(); }
    private ButtonBuilder() {}
    public Button build() {
        if (instance == null) {
            if (constructorArgs == null && mandatoryParams == null) {
                instance = new Button();
            } else {
                // Use reflection for parameterized constructor
                try {
                    Object[] args = (constructorArgs != null) ? constructorArgs : mandatoryParams;
                    java.lang.reflect.Constructor<?>[] constructors = Button.class.getConstructors();
                    for (java.lang.reflect.Constructor<?> constructor : constructors) {
                        if (constructor.getParameterCount() == args.length) {
                            instance = (Button) constructor.newInstance(args);
                            break;
                        }
                    }
                    if (instance == null) {
                        throw new RuntimeException("No suitable constructor found");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Failed to create instance", e);
                }
            }
            for (java.util.function.Consumer<Button> op : operations) {
                op.accept(instance);
            }
        }
        return instance;
    }
    public ButtonBuilder apply(java.util.function.Consumer<Button> func) {
        operations.add(func);
        return this;
    }
    public  ButtonBuilder defaultButton(boolean value) {
        operations.add(obj -> obj.setDefaultButton(value));
        return this;
    }
    public  ButtonBuilder cancelButton(boolean value) {
        operations.add(obj -> obj.setCancelButton(value));
        return this;
    }
    public  ButtonBuilder onAction(EventHandler<ActionEvent> value) {
        operations.add(obj -> obj.setOnAction(value));
        return this;
    }
    public  ButtonBuilder ellipsisString(String value) {
        operations.add(obj -> obj.setEllipsisString(value));
        return this;
    }
    public  ButtonBuilder contentDisplay(ContentDisplay value) {
        operations.add(obj -> obj.setContentDisplay(value));
        return this;
    }
    public  ButtonBuilder textAlignment(TextAlignment value) {
        operations.add(obj -> obj.setTextAlignment(value));
        return this;
    }
    public  ButtonBuilder wrapText(boolean value) {
        operations.add(obj -> obj.setWrapText(value));
        return this;
    }
    public  ButtonBuilder textFill(Paint value) {
        operations.add(obj -> obj.setTextFill(value));
        return this;
    }
    public  ButtonBuilder lineSpacing(double value) {
        operations.add(obj -> obj.setLineSpacing(value));
        return this;
    }
    public  ButtonBuilder graphicTextGap(double value) {
        operations.add(obj -> obj.setGraphicTextGap(value));
        return this;
    }
    public  ButtonBuilder mnemonicParsing(boolean value) {
        operations.add(obj -> obj.setMnemonicParsing(value));
        return this;
    }
    public  ButtonBuilder alignment(Pos value) {
        operations.add(obj -> obj.setAlignment(value));
        return this;
    }
    public  ButtonBuilder textOverrun(OverrunStyle value) {
        operations.add(obj -> obj.setTextOverrun(value));
        return this;
    }
    public  ButtonBuilder underline(boolean value) {
        operations.add(obj -> obj.setUnderline(value));
        return this;
    }
    public  ButtonBuilder text(String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }
    public  ButtonBuilder font(Font value) {
        operations.add(obj -> obj.setFont(value));
        return this;
    }
    public  ButtonBuilder graphic(Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }
    public  ButtonBuilder skin(Skin<?> value) {
        operations.add(obj -> obj.setSkin(value));
        return this;
    }
    public  ButtonBuilder tooltip(Tooltip value) {
        operations.add(obj -> obj.setTooltip(value));
        return this;
    }
    public  ButtonBuilder contextMenu(ContextMenu value) {
        operations.add(obj -> obj.setContextMenu(value));
        return this;
    }
    public  ButtonBuilder minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    public  ButtonBuilder padding(Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    public  ButtonBuilder maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    public  ButtonBuilder shape(Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    public  ButtonBuilder border(Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    public  ButtonBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    public  ButtonBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    public  ButtonBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    public  ButtonBuilder prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    public  ButtonBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    public  ButtonBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    public  ButtonBuilder opaqueInsets(Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    public  ButtonBuilder scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    public  ButtonBuilder snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    public  ButtonBuilder centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    public  ButtonBuilder background(Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    public  ButtonBuilder prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    public  ButtonBuilder cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    public  ButtonBuilder cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    public  ButtonBuilder accessibleRole(AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    public  ButtonBuilder pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    public  ButtonBuilder layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    public  ButtonBuilder effect(Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    public  ButtonBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    public  ButtonBuilder layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    public  ButtonBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    public  ButtonBuilder accessibleRoleDescription(String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    public  ButtonBuilder onInputMethodTextChanged(EventHandler<? super InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    public  ButtonBuilder depthTest(DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    public  ButtonBuilder viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    public  ButtonBuilder onRotationStarted(EventHandler<? super RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    public  ButtonBuilder onTouchStationary(EventHandler<? super TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    public  ButtonBuilder focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    public  ButtonBuilder mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    public  ButtonBuilder inputMethodRequests(InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    public  ButtonBuilder onContextMenuRequested(EventHandler<? super ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    public  ButtonBuilder onMouseDragEntered(EventHandler<? super MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    public  ButtonBuilder onMouseDragExited(EventHandler<? super MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    public  ButtonBuilder onScrollFinished(EventHandler<? super ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    public  ButtonBuilder onRotationFinished(EventHandler<? super RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    public  ButtonBuilder onMouseDragReleased(EventHandler<? super MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    public  ButtonBuilder cursor(Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    public  ButtonBuilder managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    public  ButtonBuilder id(String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    public  ButtonBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    public  ButtonBuilder style(String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    public  ButtonBuilder clip(Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    public  ButtonBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    public  ButtonBuilder onZoom(EventHandler<? super ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    public  ButtonBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    public  ButtonBuilder rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    public  ButtonBuilder scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    public  ButtonBuilder onDragDone(EventHandler<? super DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    public  ButtonBuilder onDragDropped(EventHandler<? super DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    public  ButtonBuilder blendMode(BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    public  ButtonBuilder onDragEntered(EventHandler<? super DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    public  ButtonBuilder onDragOver(EventHandler<? super DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    public  ButtonBuilder cacheHint(CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    public  ButtonBuilder userData(Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    public  ButtonBuilder translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    public  ButtonBuilder onDragExited(EventHandler<? super DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    public  ButtonBuilder onDragDetected(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    public  ButtonBuilder onScrollStarted(EventHandler<? super ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    public  ButtonBuilder onSwipeRight(EventHandler<? super SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    public  ButtonBuilder onTouchMoved(EventHandler<? super TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    public  ButtonBuilder onTouchPressed(EventHandler<? super TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    public  ButtonBuilder onMouseClicked(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    public  ButtonBuilder translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    public  ButtonBuilder onMouseDragOver(EventHandler<? super MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    public  ButtonBuilder onMouseEntered(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    public  ButtonBuilder onKeyTyped(EventHandler<? super KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    public  ButtonBuilder onMouseMoved(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    public  ButtonBuilder translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    public  ButtonBuilder onMouseDragged(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    public  ButtonBuilder onTouchReleased(EventHandler<? super TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    public  ButtonBuilder onSwipeDown(EventHandler<? super SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    public  ButtonBuilder onScroll(EventHandler<? super ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    public  ButtonBuilder onKeyReleased(EventHandler<? super KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    public  ButtonBuilder onSwipeLeft(EventHandler<? super SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    public  ButtonBuilder accessibleText(String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    public  ButtonBuilder accessibleHelp(String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    public  ButtonBuilder onMousePressed(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    public  ButtonBuilder onKeyPressed(EventHandler<? super KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    public  ButtonBuilder eventDispatcher(EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    public  ButtonBuilder onZoomStarted(EventHandler<? super ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    public  ButtonBuilder onZoomFinished(EventHandler<? super ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    public  ButtonBuilder onMouseExited(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    public  ButtonBuilder onRotate(EventHandler<? super RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    public  ButtonBuilder rotationAxis(Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    public  ButtonBuilder onMouseReleased(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    public  ButtonBuilder onSwipeUp(EventHandler<? super SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    public  ButtonBuilder nodeOrientation(NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
}
