package io.github.sosuisen.jfxbuilder;
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
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;

public class VBoxBuilder {
    private Object[] constructorArgs;
    private Object[] mandatoryParams;
    private java.util.List<java.util.function.Consumer<VBox>> operations = new java.util.ArrayList<>();
    public static  VBoxBuilder create() { return new VBoxBuilder(); }
    private VBoxBuilder() {}
    public static  VBoxBuilder create(double spacing) {
        VBoxBuilder builder = new VBoxBuilder();
        builder.constructorArgs = new Object[]{spacing};
        return builder;
    }
    public static  VBoxBuilder create(Node[] children) {
        VBoxBuilder builder = new VBoxBuilder();
        builder.constructorArgs = new Object[]{children};
        return builder;
    }
    public static  VBoxBuilder create(double spacing, Node[] children) {
        VBoxBuilder builder = new VBoxBuilder();
        builder.constructorArgs = new Object[]{spacing, children};
        return builder;
    }
    public VBox build() {
        VBox newInstance;
        if (constructorArgs == null && mandatoryParams == null) {
            newInstance = new VBox();
        } else {
            // Use reflection for parameterized constructor
            try {
                Object[] args = (constructorArgs != null) ? constructorArgs : mandatoryParams;
                java.lang.reflect.Constructor<?>[] constructors = VBox.class.getConstructors();
                newInstance = null;
                for (java.lang.reflect.Constructor<?> constructor : constructors) {
                    if (constructor.getParameterCount() == args.length && isConstructorCompatible(constructor, args)) {
                        newInstance = (VBox) constructor.newInstance(args);
                        break;
                    }
                }
                if (newInstance == null) {
                    throw new RuntimeException("No suitable constructor found");
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed to create instance", e);
            }
        }
        for (java.util.function.Consumer<VBox> op : operations) {
            op.accept(newInstance);
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
    
    public VBoxBuilder apply(java.util.function.Consumer<VBox> func) {
        operations.add(func);
        return this;
    }
    public  VBoxBuilder fillWidth(boolean value) {
        operations.add(obj -> obj.setFillWidth(value));
        return this;
    }
    public  VBoxBuilder margin(Node child, Insets value) {
        operations.add(obj -> obj.setMargin(child, value));
        return this;
    }
    public  VBoxBuilder vgrow(Node child, Priority value) {
        operations.add(obj -> obj.setVgrow(child, value));
        return this;
    }
    public  VBoxBuilder spacing(double value) {
        operations.add(obj -> obj.setSpacing(value));
        return this;
    }
    public  VBoxBuilder alignment(Pos value) {
        operations.add(obj -> obj.setAlignment(value));
        return this;
    }
    public  VBoxBuilder border(Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    public  VBoxBuilder minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    public  VBoxBuilder shape(Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    public  VBoxBuilder padding(Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    public  VBoxBuilder maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    public  VBoxBuilder opaqueInsets(Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    public  VBoxBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    public  VBoxBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    public  VBoxBuilder prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    public  VBoxBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    public  VBoxBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    public  VBoxBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    public  VBoxBuilder background(Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    public  VBoxBuilder snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    public  VBoxBuilder prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    public  VBoxBuilder cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    public  VBoxBuilder scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    public  VBoxBuilder centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    public  VBoxBuilder cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    public  VBoxBuilder userData(Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    public  VBoxBuilder id(String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    public  VBoxBuilder depthTest(DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    public  VBoxBuilder viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    public  VBoxBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    public  VBoxBuilder focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    public  VBoxBuilder onMouseDragEntered(EventHandler<? super MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    public  VBoxBuilder onMouseDragExited(EventHandler<? super MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    public  VBoxBuilder onScrollFinished(EventHandler<? super ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    public  VBoxBuilder onRotationStarted(EventHandler<? super RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    public  VBoxBuilder inputMethodRequests(InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    public  VBoxBuilder onMouseDragReleased(EventHandler<? super MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    public  VBoxBuilder mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    public  VBoxBuilder onRotationFinished(EventHandler<? super RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    public  VBoxBuilder onContextMenuRequested(EventHandler<? super ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    public  VBoxBuilder onTouchStationary(EventHandler<? super TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    public  VBoxBuilder effect(Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    public  VBoxBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    public  VBoxBuilder cursor(Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    public  VBoxBuilder layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    public  VBoxBuilder layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    public  VBoxBuilder style(String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    public  VBoxBuilder clip(Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    public  VBoxBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    public  VBoxBuilder managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    public  VBoxBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    public  VBoxBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    public  VBoxBuilder scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    public  VBoxBuilder onZoom(EventHandler<? super ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    public  VBoxBuilder rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    public  VBoxBuilder pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    public  VBoxBuilder onSwipeLeft(EventHandler<? super SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    public  VBoxBuilder onKeyTyped(EventHandler<? super KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    public  VBoxBuilder onMouseDragged(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    public  VBoxBuilder translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    public  VBoxBuilder onRotate(EventHandler<? super RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    public  VBoxBuilder rotationAxis(Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    public  VBoxBuilder onMouseMoved(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    public  VBoxBuilder onMousePressed(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    public  VBoxBuilder onScroll(EventHandler<? super ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    public  VBoxBuilder onSwipeUp(EventHandler<? super SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    public  VBoxBuilder onSwipeRight(EventHandler<? super SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    public  VBoxBuilder onSwipeDown(EventHandler<? super SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    public  VBoxBuilder onKeyReleased(EventHandler<? super KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    public  VBoxBuilder onMouseClicked(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    public  VBoxBuilder onTouchMoved(EventHandler<? super TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    public  VBoxBuilder onZoomFinished(EventHandler<? super ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    public  VBoxBuilder onKeyPressed(EventHandler<? super KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    public  VBoxBuilder onMouseReleased(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    public  VBoxBuilder onScrollStarted(EventHandler<? super ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    public  VBoxBuilder onMouseEntered(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    public  VBoxBuilder onTouchPressed(EventHandler<? super TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    public  VBoxBuilder translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    public  VBoxBuilder accessibleText(String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    public  VBoxBuilder onMouseExited(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    public  VBoxBuilder accessibleHelp(String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    public  VBoxBuilder nodeOrientation(NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    public  VBoxBuilder onDragDetected(EventHandler<? super MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    public  VBoxBuilder translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    public  VBoxBuilder onMouseDragOver(EventHandler<? super MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    public  VBoxBuilder onZoomStarted(EventHandler<? super ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    public  VBoxBuilder onTouchReleased(EventHandler<? super TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    public  VBoxBuilder eventDispatcher(EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    public  VBoxBuilder onInputMethodTextChanged(EventHandler<? super InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    public  VBoxBuilder accessibleRoleDescription(String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    public  VBoxBuilder accessibleRole(AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    public  VBoxBuilder onDragDropped(EventHandler<? super DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    public  VBoxBuilder blendMode(BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    public  VBoxBuilder onDragEntered(EventHandler<? super DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    public  VBoxBuilder onDragOver(EventHandler<? super DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    public  VBoxBuilder onDragExited(EventHandler<? super DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    public  VBoxBuilder onDragDone(EventHandler<? super DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    public  VBoxBuilder cacheHint(CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    public  VBoxBuilder children(javafx.scene.Node... elements) {
        operations.add(obj -> obj.getChildren().setAll(elements));
        return this;
    }

    public static VBox withChildren(javafx.scene.Node... elements) {
        VBoxBuilder builder = new VBoxBuilder();
        return builder.children(elements).build();
    }
}
