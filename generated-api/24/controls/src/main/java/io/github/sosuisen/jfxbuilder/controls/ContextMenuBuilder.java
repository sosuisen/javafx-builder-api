
package io.github.sosuisen.jfxbuilder.controls;


public class ContextMenuBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.ContextMenu>> operations = new java.util.ArrayList<>();
    private ContextMenuBuilder() {}
    

    public static ContextMenuBuilder create() { return new ContextMenuBuilder(); }


    @SafeVarargs
    public static ContextMenuBuilder create(javafx.scene.control.MenuItem... items) {
        ContextMenuBuilder builder = new ContextMenuBuilder();
        builder.constructorArgs = new Object[]{items};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.control.ContextMenu build() {
        javafx.scene.control.ContextMenu newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.ContextMenu();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.ContextMenu> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.ContextMenu callParameterizedConstructor() {
        javafx.scene.control.ContextMenu newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.ContextMenu.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.ContextMenu) constructor.newInstance(constructorArgs);
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
    
    public ContextMenuBuilder apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setAnchorLocation(javafx.stage.PopupWindow$AnchorLocation)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder anchorLocation(javafx.stage.PopupWindow.AnchorLocation value) {
        operations.add(obj -> obj.setAnchorLocation(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setAnchorX(double)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder anchorX(double value) {
        operations.add(obj -> obj.setAnchorX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setAnchorY(double)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder anchorY(double value) {
        operations.add(obj -> obj.setAnchorY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setAutoFix(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder autoFix(boolean value) {
        operations.add(obj -> obj.setAutoFix(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setAutoHide(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder autoHide(boolean value) {
        operations.add(obj -> obj.setAutoHide(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setConsumeAutoHidingEvents(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder consumeAutoHidingEvents(boolean value) {
        operations.add(obj -> obj.setConsumeAutoHidingEvents(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setForceIntegerRenderScale(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder forceIntegerRenderScale(boolean forced) {
        operations.add(obj -> obj.setForceIntegerRenderScale(forced));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder height(double value) {
        operations.add(obj -> obj.setHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setHideOnEscape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder hideOnEscape(boolean value) {
        operations.add(obj -> obj.setHideOnEscape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setOnAction(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder onAction(javafx.event.EventHandler<javafx.event.ActionEvent> value) {
        operations.add(obj -> obj.setOnAction(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setOnAutoHide(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder onAutoHide(javafx.event.EventHandler<javafx.event.Event> value) {
        operations.add(obj -> obj.setOnAutoHide(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setOnCloseRequest(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder onCloseRequest(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnCloseRequest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setOnHidden(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder onHidden(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnHidden(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setOnHiding(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder onHiding(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnHiding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setOnShowing(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder onShowing(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnShowing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setOnShown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder onShown(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnShown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setRenderScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder renderScaleX(double scale) {
        operations.add(obj -> obj.setRenderScaleX(scale));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setRenderScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder renderScaleY(double scale) {
        operations.add(obj -> obj.setRenderScaleY(scale));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setSkin(javafx.scene.control.Skin)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder skin(javafx.scene.control.Skin<?> value) {
        operations.add(obj -> obj.setSkin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder width(double value) {
        operations.add(obj -> obj.setWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setX(double)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ContextMenu#setY(double)}
     * 
     * @return builder instance
     */    
    
    public  ContextMenuBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }
    @SafeVarargs
    public final ContextMenuBuilder addItems(javafx.scene.control.MenuItem... elements) {
        operations.add(obj -> {
            obj.getItems().addAll(elements);
        });
        return this;
    }

    public final ContextMenuBuilder addItems(java.util.Collection<? extends javafx.scene.control.MenuItem> col) {
        operations.add(obj -> {
            obj.getItems().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public static ContextMenuBuilder withItems(javafx.scene.control.MenuItem... elements) {
        ContextMenuBuilder builder = new ContextMenuBuilder();
        return builder.addItems(elements);
    }

    public static ContextMenuBuilder withItems(java.util.Collection<? extends javafx.scene.control.MenuItem> col) {
        ContextMenuBuilder builder = new ContextMenuBuilder();
        return builder.addItems(col);
    }

    @SafeVarargs
    public final ContextMenuBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    public final ContextMenuBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }

    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#anchorLocationProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder anchorLocationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.stage.PopupWindow.AnchorLocation>> op) {
        operations.add(obj -> op.accept(obj.anchorLocationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#anchorXProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder anchorXPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.anchorXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#anchorYProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder anchorYPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.anchorYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#autoFixProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder autoFixPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.autoFixProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#autoHideProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder autoHidePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.autoHideProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#consumeAutoHidingEventsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder consumeAutoHidingEventsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.consumeAutoHidingEventsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#forceIntegerRenderScaleProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder forceIntegerRenderScalePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.forceIntegerRenderScaleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#hideOnEscapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder hideOnEscapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hideOnEscapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#onActionProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder onActionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.ActionEvent>>> op) {
        operations.add(obj -> op.accept(obj.onActionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#onAutoHideProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder onAutoHidePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.Event>>> op) {
        operations.add(obj -> op.accept(obj.onAutoHideProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#onCloseRequestProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder onCloseRequestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onCloseRequestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#onHiddenProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder onHiddenPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHiddenProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#onHidingProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder onHidingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHidingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#onShowingProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder onShowingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShowingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#onShownProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder onShownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#outputScaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder outputScaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.outputScaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#outputScaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder outputScaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.outputScaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#ownerNodeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder ownerNodePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.ownerNodeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#ownerWindowProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder ownerWindowPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.stage.Window>> op) {
        operations.add(obj -> op.accept(obj.ownerWindowProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#renderScaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder renderScaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.renderScaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#renderScaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder renderScaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.renderScaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#showingProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder showingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.showingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#skinProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder skinPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Skin<?>>> op) {
        operations.add(obj -> op.accept(obj.skinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#xProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#yProperty()}.
     * 
     * @return builder instance
     */    
    
    public ContextMenuBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
