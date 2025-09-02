
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code PopupControlBuilder} class constructs instances of the {@link javafx.scene.control.PopupControl PopupControl} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.PopupControl PopupControl} constructor
 * and returns an instance of the {@code PopupControlBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.PopupControl PopupControl}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.PopupControl PopupControl} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class PopupControlBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.PopupControl>> operations = new java.util.ArrayList<>();
    private PopupControlBuilder() {}
    

    public static PopupControlBuilder create() { return new PopupControlBuilder(); }

    private Object[] constructorArgs;

    /**
     * This method builds and returns an instance of the original class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the build() method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.PopupControl PopupControl} class
     */
    public javafx.scene.control.PopupControl build() {
        javafx.scene.control.PopupControl newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.PopupControl();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.PopupControl> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.PopupControl callParameterizedConstructor() {
        javafx.scene.control.PopupControl newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.PopupControl.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.PopupControl) constructor.newInstance(constructorArgs);
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
     * Applies a function to the PopupControl instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public PopupControlBuilder apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setAnchorLocation(javafx.stage.PopupWindow$AnchorLocation)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder anchorLocation(javafx.stage.PopupWindow.AnchorLocation value) {
        operations.add(obj -> obj.setAnchorLocation(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setAnchorX(double)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder anchorX(double value) {
        operations.add(obj -> obj.setAnchorX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setAnchorY(double)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder anchorY(double value) {
        operations.add(obj -> obj.setAnchorY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setAutoFix(boolean)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder autoFix(boolean value) {
        operations.add(obj -> obj.setAutoFix(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setAutoHide(boolean)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder autoHide(boolean value) {
        operations.add(obj -> obj.setAutoHide(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setConsumeAutoHidingEvents(boolean)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder consumeAutoHidingEvents(boolean value) {
        operations.add(obj -> obj.setConsumeAutoHidingEvents(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setForceIntegerRenderScale(boolean)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder forceIntegerRenderScale(boolean forced) {
        operations.add(obj -> obj.setForceIntegerRenderScale(forced));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder height(double value) {
        operations.add(obj -> obj.setHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setHideOnEscape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder hideOnEscape(boolean value) {
        operations.add(obj -> obj.setHideOnEscape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setOnAutoHide(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder onAutoHide(javafx.event.EventHandler<javafx.event.Event> value) {
        operations.add(obj -> obj.setOnAutoHide(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setOnCloseRequest(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder onCloseRequest(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnCloseRequest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setOnHidden(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder onHidden(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnHidden(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setOnHiding(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder onHiding(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnHiding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setOnShowing(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder onShowing(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnShowing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setOnShown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder onShown(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnShown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setRenderScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder renderScaleX(double scale) {
        operations.add(obj -> obj.setRenderScaleX(scale));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setRenderScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder renderScaleY(double scale) {
        operations.add(obj -> obj.setRenderScaleY(scale));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setSkin(javafx.scene.control.Skin)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder skin(javafx.scene.control.Skin<?> value) {
        operations.add(obj -> obj.setSkin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder width(double value) {
        operations.add(obj -> obj.setWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setX(double)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.PopupControl#setY(double)}
     * 
     * @return builder instance
     */    
    
    public  PopupControlBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.PopupControl#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final PopupControlBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.PopupControl#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final PopupControlBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }


    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#anchorLocationProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder anchorLocationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.stage.PopupWindow.AnchorLocation>> op) {
        operations.add(obj -> op.accept(obj.anchorLocationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#anchorXProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder anchorXPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.anchorXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#anchorYProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder anchorYPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.anchorYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#autoFixProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder autoFixPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.autoFixProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#autoHideProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder autoHidePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.autoHideProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#consumeAutoHidingEventsProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder consumeAutoHidingEventsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.consumeAutoHidingEventsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#forceIntegerRenderScaleProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder forceIntegerRenderScalePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.forceIntegerRenderScaleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#hideOnEscapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder hideOnEscapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hideOnEscapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#onAutoHideProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder onAutoHidePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.Event>>> op) {
        operations.add(obj -> op.accept(obj.onAutoHideProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#onCloseRequestProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder onCloseRequestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onCloseRequestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#onHiddenProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder onHiddenPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHiddenProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#onHidingProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder onHidingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHidingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#onShowingProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder onShowingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShowingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#onShownProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder onShownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#outputScaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder outputScaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.outputScaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#outputScaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder outputScaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.outputScaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#ownerNodeProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder ownerNodePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.ownerNodeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#ownerWindowProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder ownerWindowPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.stage.Window>> op) {
        operations.add(obj -> op.accept(obj.ownerWindowProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#renderScaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder renderScaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.renderScaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#renderScaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder renderScaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.renderScaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#showingProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder showingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.showingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#skinProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder skinPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Skin<?>>> op) {
        operations.add(obj -> op.accept(obj.skinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#xProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#yProperty()}.
     * 
     * @return builder instance
     */    
    
    public PopupControlBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
