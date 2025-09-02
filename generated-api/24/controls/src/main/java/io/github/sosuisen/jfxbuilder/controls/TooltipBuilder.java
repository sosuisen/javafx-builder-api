
package io.github.sosuisen.jfxbuilder.controls;


public class TooltipBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.Tooltip>> operations = new java.util.ArrayList<>();
    private TooltipBuilder() {}
    

    public static TooltipBuilder create() { return new TooltipBuilder(); }


    
    public static TooltipBuilder create(java.lang.String text) {
        TooltipBuilder builder = new TooltipBuilder();
        builder.constructorArgs = new Object[]{text};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.control.Tooltip build() {
        javafx.scene.control.Tooltip newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.Tooltip();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.Tooltip> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.Tooltip callParameterizedConstructor() {
        javafx.scene.control.Tooltip newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.Tooltip.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.Tooltip) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Tooltip instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TooltipBuilder apply(java.util.function.Consumer<javafx.scene.control.Tooltip> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setAnchorLocation(javafx.stage.PopupWindow$AnchorLocation)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder anchorLocation(javafx.stage.PopupWindow.AnchorLocation value) {
        operations.add(obj -> obj.setAnchorLocation(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setAnchorX(double)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder anchorX(double value) {
        operations.add(obj -> obj.setAnchorX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setAnchorY(double)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder anchorY(double value) {
        operations.add(obj -> obj.setAnchorY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setAutoFix(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder autoFix(boolean value) {
        operations.add(obj -> obj.setAutoFix(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setAutoHide(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder autoHide(boolean value) {
        operations.add(obj -> obj.setAutoHide(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setConsumeAutoHidingEvents(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder consumeAutoHidingEvents(boolean value) {
        operations.add(obj -> obj.setConsumeAutoHidingEvents(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setContentDisplay(javafx.scene.control.ContentDisplay)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder contentDisplay(javafx.scene.control.ContentDisplay value) {
        operations.add(obj -> obj.setContentDisplay(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setFont(javafx.scene.text.Font)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder font(javafx.scene.text.Font value) {
        operations.add(obj -> obj.setFont(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setForceIntegerRenderScale(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder forceIntegerRenderScale(boolean forced) {
        operations.add(obj -> obj.setForceIntegerRenderScale(forced));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setGraphic(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setGraphicTextGap(double)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder graphicTextGap(double value) {
        operations.add(obj -> obj.setGraphicTextGap(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder height(double value) {
        operations.add(obj -> obj.setHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setHideDelay(javafx.util.Duration)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder hideDelay(javafx.util.Duration hideDelay) {
        operations.add(obj -> obj.setHideDelay(hideDelay));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setHideOnEscape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder hideOnEscape(boolean value) {
        operations.add(obj -> obj.setHideOnEscape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setOnAutoHide(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder onAutoHide(javafx.event.EventHandler<javafx.event.Event> value) {
        operations.add(obj -> obj.setOnAutoHide(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setOnCloseRequest(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder onCloseRequest(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnCloseRequest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setOnHidden(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder onHidden(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnHidden(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setOnHiding(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder onHiding(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnHiding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setOnShowing(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder onShowing(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnShowing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setOnShown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder onShown(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnShown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setRenderScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder renderScaleX(double scale) {
        operations.add(obj -> obj.setRenderScaleX(scale));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setRenderScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder renderScaleY(double scale) {
        operations.add(obj -> obj.setRenderScaleY(scale));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setShowDelay(javafx.util.Duration)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder showDelay(javafx.util.Duration showDelay) {
        operations.add(obj -> obj.setShowDelay(showDelay));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setShowDuration(javafx.util.Duration)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder showDuration(javafx.util.Duration showDuration) {
        operations.add(obj -> obj.setShowDuration(showDuration));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setSkin(javafx.scene.control.Skin)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder skin(javafx.scene.control.Skin<?> value) {
        operations.add(obj -> obj.setSkin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setTextAlignment(javafx.scene.text.TextAlignment)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder textAlignment(javafx.scene.text.TextAlignment value) {
        operations.add(obj -> obj.setTextAlignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setTextOverrun(javafx.scene.control.OverrunStyle)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder textOverrun(javafx.scene.control.OverrunStyle value) {
        operations.add(obj -> obj.setTextOverrun(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder width(double value) {
        operations.add(obj -> obj.setWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setWrapText(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder wrapText(boolean value) {
        operations.add(obj -> obj.setWrapText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setX(double)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Tooltip#setY(double)}
     * 
     * @return builder instance
     */    
    
    public  TooltipBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.Tooltip#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final TooltipBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.Tooltip#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final TooltipBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }


    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#activatedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder activatedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.activatedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#anchorLocationProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder anchorLocationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.stage.PopupWindow.AnchorLocation>> op) {
        operations.add(obj -> op.accept(obj.anchorLocationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#anchorXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder anchorXPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.anchorXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#anchorYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder anchorYPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.anchorYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#autoFixProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder autoFixPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.autoFixProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#autoHideProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder autoHidePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.autoHideProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#consumeAutoHidingEventsProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder consumeAutoHidingEventsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.consumeAutoHidingEventsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#contentDisplayProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder contentDisplayPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContentDisplay>> op) {
        operations.add(obj -> op.accept(obj.contentDisplayProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#fontProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder fontPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.Font>> op) {
        operations.add(obj -> op.accept(obj.fontProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#forceIntegerRenderScaleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder forceIntegerRenderScalePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.forceIntegerRenderScaleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#graphicProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#graphicTextGapProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder graphicTextGapPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.graphicTextGapProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#hideDelayProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder hideDelayPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.hideDelayProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#hideOnEscapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder hideOnEscapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hideOnEscapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#onAutoHideProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder onAutoHidePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.Event>>> op) {
        operations.add(obj -> op.accept(obj.onAutoHideProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#onCloseRequestProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder onCloseRequestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onCloseRequestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#onHiddenProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder onHiddenPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHiddenProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#onHidingProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder onHidingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHidingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#onShowingProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder onShowingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShowingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#onShownProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder onShownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#outputScaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder outputScaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.outputScaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#outputScaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder outputScaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.outputScaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#ownerNodeProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder ownerNodePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.ownerNodeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#ownerWindowProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder ownerWindowPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.stage.Window>> op) {
        operations.add(obj -> op.accept(obj.ownerWindowProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#renderScaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder renderScaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.renderScaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#renderScaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder renderScaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.renderScaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#showDelayProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder showDelayPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.showDelayProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#showDurationProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder showDurationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.showDurationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#showingProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder showingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.showingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#skinProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder skinPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Skin<?>>> op) {
        operations.add(obj -> op.accept(obj.skinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#textAlignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder textAlignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.TextAlignment>> op) {
        operations.add(obj -> op.accept(obj.textAlignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#textOverrunProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder textOverrunPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.OverrunStyle>> op) {
        operations.add(obj -> op.accept(obj.textOverrunProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#textProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#wrapTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder wrapTextPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.wrapTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#xProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#yProperty()}.
     * 
     * @return builder instance
     */    
    
    public TooltipBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
