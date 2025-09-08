
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code TooltipBuilder} class constructs instances of the {@link javafx.scene.control.Tooltip Tooltip} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.Tooltip Tooltip} constructor
 * and returns an instance of the {@code TooltipBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.Tooltip Tooltip}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.Tooltip Tooltip} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class TooltipBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.Tooltip>> operations = new java.util.ArrayList<>();
    private TooltipBuilder() {}
    
    /**
     * Returns an instance of the {@code TooltipBuilder}.
     *
     * @return an instance of the {@code TooltipBuilder}.
     */
    public static TooltipBuilder create() { return new TooltipBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.Tooltip#Tooltip(String) Tooltip(String)}
     * and returns an instance of {@code TooltipBuilder}.
     *
     * @return an instance of the {@code TooltipBuilder}.
     */
    
    public static TooltipBuilder create(java.lang.String text) {
        TooltipBuilder builder = new TooltipBuilder();
        builder.constructorArgs = new Object[]{text};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.Tooltip} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.Tooltip Tooltip} class
     */
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
     * Applies a function to the Tooltip instance being constructed.
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
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setAnchorLocation(javafx.stage.PopupWindow$AnchorLocation) setAnchorLocation} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder anchorLocation(javafx.stage.PopupWindow.AnchorLocation value) {
        operations.add(obj -> obj.setAnchorLocation(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setAnchorX(double) setAnchorX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder anchorX(double value) {
        operations.add(obj -> obj.setAnchorX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setAnchorY(double) setAnchorY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder anchorY(double value) {
        operations.add(obj -> obj.setAnchorY(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setAutoFix(boolean) setAutoFix} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder autoFix(boolean value) {
        operations.add(obj -> obj.setAutoFix(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setAutoHide(boolean) setAutoHide} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder autoHide(boolean value) {
        operations.add(obj -> obj.setAutoHide(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setConsumeAutoHidingEvents(boolean) setConsumeAutoHidingEvents} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder consumeAutoHidingEvents(boolean value) {
        operations.add(obj -> obj.setConsumeAutoHidingEvents(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setContentDisplay(javafx.scene.control.ContentDisplay) setContentDisplay} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder contentDisplay(javafx.scene.control.ContentDisplay value) {
        operations.add(obj -> obj.setContentDisplay(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setEventDispatcher(javafx.event.EventDispatcher) setEventDispatcher} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setFont(javafx.scene.text.Font) setFont} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder font(javafx.scene.text.Font value) {
        operations.add(obj -> obj.setFont(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setForceIntegerRenderScale(boolean) setForceIntegerRenderScale} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder forceIntegerRenderScale(boolean forced) {
        operations.add(obj -> obj.setForceIntegerRenderScale(forced));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setGraphic(javafx.scene.Node) setGraphic} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setGraphicTextGap(double) setGraphicTextGap} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder graphicTextGap(double value) {
        operations.add(obj -> obj.setGraphicTextGap(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setHeight(double) setHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder height(double value) {
        operations.add(obj -> obj.setHeight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setHideDelay(javafx.util.Duration) setHideDelay} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder hideDelay(javafx.util.Duration hideDelay) {
        operations.add(obj -> obj.setHideDelay(hideDelay));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setHideOnEscape(boolean) setHideOnEscape} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder hideOnEscape(boolean value) {
        operations.add(obj -> obj.setHideOnEscape(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setId(java.lang.String) setId} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setMaxHeight(double) setMaxHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setMaxSize(double, double) setMaxSize} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setMaxWidth(double) setMaxWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setMinHeight(double) setMinHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setMinSize(double, double) setMinSize} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setMinWidth(double) setMinWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setOnAutoHide(javafx.event.EventHandler) setOnAutoHide} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder onAutoHide(javafx.event.EventHandler<javafx.event.Event> value) {
        operations.add(obj -> obj.setOnAutoHide(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setOnCloseRequest(javafx.event.EventHandler) setOnCloseRequest} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder onCloseRequest(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnCloseRequest(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setOnHidden(javafx.event.EventHandler) setOnHidden} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder onHidden(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnHidden(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setOnHiding(javafx.event.EventHandler) setOnHiding} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder onHiding(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnHiding(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setOnShowing(javafx.event.EventHandler) setOnShowing} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder onShowing(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnShowing(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setOnShown(javafx.event.EventHandler) setOnShown} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder onShown(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnShown(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setOpacity(double) setOpacity} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setPrefHeight(double) setPrefHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setPrefSize(double, double) setPrefSize} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setPrefWidth(double) setPrefWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setRenderScaleX(double) setRenderScaleX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder renderScaleX(double scale) {
        operations.add(obj -> obj.setRenderScaleX(scale));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setRenderScaleY(double) setRenderScaleY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder renderScaleY(double scale) {
        operations.add(obj -> obj.setRenderScaleY(scale));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setShowDelay(javafx.util.Duration) setShowDelay} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder showDelay(javafx.util.Duration showDelay) {
        operations.add(obj -> obj.setShowDelay(showDelay));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setShowDuration(javafx.util.Duration) setShowDuration} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder showDuration(javafx.util.Duration showDuration) {
        operations.add(obj -> obj.setShowDuration(showDuration));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setSkin(javafx.scene.control.Skin) setSkin} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder skin(javafx.scene.control.Skin<?> value) {
        operations.add(obj -> obj.setSkin(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setStyle(java.lang.String) setStyle} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setText(java.lang.String) setText} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setTextAlignment(javafx.scene.text.TextAlignment) setTextAlignment} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder textAlignment(javafx.scene.text.TextAlignment value) {
        operations.add(obj -> obj.setTextAlignment(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setTextOverrun(javafx.scene.control.OverrunStyle) setTextOverrun} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder textOverrun(javafx.scene.control.OverrunStyle value) {
        operations.add(obj -> obj.setTextOverrun(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setUserData(java.lang.Object) setUserData} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setWidth(double) setWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder width(double value) {
        operations.add(obj -> obj.setWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setWrapText(boolean) setWrapText} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder wrapText(boolean value) {
        operations.add(obj -> obj.setWrapText(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setX(double) setX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Tooltip#setY(double) setY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  TooltipBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.Tooltip#getStyleClass()} method.
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
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.Tooltip#getStyleClass()} method.
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
     * Applies a function to the {@link javafx.scene.control.Tooltip#activatedProperty() activatedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.activatedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .activatedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder activatedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.activatedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#anchorLocationProperty() anchorLocationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.anchorLocationProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .anchorLocationPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder anchorLocationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.stage.PopupWindow.AnchorLocation>> op) {
        operations.add(obj -> op.accept(obj.anchorLocationProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#anchorXProperty() anchorXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.anchorXProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .anchorXPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder anchorXPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.anchorXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#anchorYProperty() anchorYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.anchorYProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .anchorYPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder anchorYPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.anchorYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#autoFixProperty() autoFixProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.autoFixProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .autoFixPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder autoFixPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.autoFixProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#autoHideProperty() autoHideProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.autoHideProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .autoHidePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder autoHidePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.autoHideProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#consumeAutoHidingEventsProperty() consumeAutoHidingEventsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.consumeAutoHidingEventsProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .consumeAutoHidingEventsPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder consumeAutoHidingEventsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.consumeAutoHidingEventsProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#contentDisplayProperty() contentDisplayProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.contentDisplayProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .contentDisplayPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder contentDisplayPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContentDisplay>> op) {
        operations.add(obj -> op.accept(obj.contentDisplayProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#eventDispatcherProperty() eventDispatcherProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
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
    public TooltipBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#focusedProperty() focusedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
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
    public TooltipBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#fontProperty() fontProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.fontProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .fontPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder fontPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.Font>> op) {
        operations.add(obj -> op.accept(obj.fontProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#forceIntegerRenderScaleProperty() forceIntegerRenderScaleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.forceIntegerRenderScaleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .forceIntegerRenderScalePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder forceIntegerRenderScalePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.forceIntegerRenderScaleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#graphicProperty() graphicProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.graphicProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .graphicPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#graphicTextGapProperty() graphicTextGapProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.graphicTextGapProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .graphicTextGapPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder graphicTextGapPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.graphicTextGapProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#heightProperty() heightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.heightProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .heightPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#hideDelayProperty() hideDelayProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.hideDelayProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .hideDelayPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder hideDelayPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.hideDelayProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#hideOnEscapeProperty() hideOnEscapeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.hideOnEscapeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .hideOnEscapePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder hideOnEscapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hideOnEscapeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#idProperty() idProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
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
    public TooltipBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#maxHeightProperty() maxHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.maxHeightProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .maxHeightPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#maxWidthProperty() maxWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.maxWidthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .maxWidthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#minHeightProperty() minHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.minHeightProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .minHeightPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#minWidthProperty() minWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.minWidthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .minWidthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#onAutoHideProperty() onAutoHideProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onAutoHideProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onAutoHidePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder onAutoHidePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.Event>>> op) {
        operations.add(obj -> op.accept(obj.onAutoHideProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#onCloseRequestProperty() onCloseRequestProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onCloseRequestProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onCloseRequestPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder onCloseRequestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onCloseRequestProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#onHiddenProperty() onHiddenProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onHiddenProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onHiddenPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder onHiddenPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHiddenProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#onHidingProperty() onHidingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onHidingProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onHidingPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder onHidingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHidingProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#onShowingProperty() onShowingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onShowingProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onShowingPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder onShowingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShowingProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#onShownProperty() onShownProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onShownProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onShownPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder onShownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShownProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#opacityProperty() opacityProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
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
    public TooltipBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#outputScaleXProperty() outputScaleXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.outputScaleXProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .outputScaleXPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder outputScaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.outputScaleXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#outputScaleYProperty() outputScaleYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.outputScaleYProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .outputScaleYPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder outputScaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.outputScaleYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#ownerNodeProperty() ownerNodeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.ownerNodeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .ownerNodePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder ownerNodePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.ownerNodeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#ownerWindowProperty() ownerWindowProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.ownerWindowProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .ownerWindowPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder ownerWindowPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.stage.Window>> op) {
        operations.add(obj -> op.accept(obj.ownerWindowProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#prefHeightProperty() prefHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.prefHeightProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .prefHeightPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#prefWidthProperty() prefWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.prefWidthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .prefWidthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#renderScaleXProperty() renderScaleXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.renderScaleXProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .renderScaleXPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder renderScaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.renderScaleXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#renderScaleYProperty() renderScaleYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.renderScaleYProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .renderScaleYPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder renderScaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.renderScaleYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#sceneProperty() sceneProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
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
    public TooltipBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#showDelayProperty() showDelayProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.showDelayProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .showDelayPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder showDelayPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.showDelayProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#showDurationProperty() showDurationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.showDurationProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .showDurationPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder showDurationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.showDurationProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#showingProperty() showingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.showingProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .showingPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder showingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.showingProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#skinProperty() skinProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.skinProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .skinPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder skinPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Skin<?>>> op) {
        operations.add(obj -> op.accept(obj.skinProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#styleProperty() styleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
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
    public TooltipBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#textAlignmentProperty() textAlignmentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.textAlignmentProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .textAlignmentPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder textAlignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.TextAlignment>> op) {
        operations.add(obj -> op.accept(obj.textAlignmentProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#textOverrunProperty() textOverrunProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.textOverrunProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .textOverrunPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder textOverrunPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.OverrunStyle>> op) {
        operations.add(obj -> op.accept(obj.textOverrunProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#textProperty() textProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.textProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .textPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#widthProperty() widthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.widthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .widthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#wrapTextProperty() wrapTextProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.wrapTextProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .wrapTextPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public TooltipBuilder wrapTextPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.wrapTextProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#xProperty() xProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
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
    public TooltipBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.Tooltip#yProperty() yProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link TooltipBuilder#apply(java.util.function.Consumer) apply} method.
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
    public TooltipBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
