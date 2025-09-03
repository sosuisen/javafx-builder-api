
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code ContextMenuBuilder} class constructs instances of the {@link javafx.scene.control.ContextMenu ContextMenu} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.ContextMenu ContextMenu} constructor
 * and returns an instance of the {@code ContextMenuBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.ContextMenu ContextMenu}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.ContextMenu ContextMenu} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class ContextMenuBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.ContextMenu>> operations = new java.util.ArrayList<>();
    private ContextMenuBuilder() {}
    
    /**
     * Returns an instance of the {@code ContextMenuBuilder}.
     *
     * @return an instance of the {@code ContextMenuBuilder}.
     */
    public static ContextMenuBuilder create() { return new ContextMenuBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.ContextMenu#ContextMenu(MenuItem...) ContextMenu(MenuItem...)}
     * and returns an instance of {@code ContextMenuBuilder}.
     *
     * @return an instance of the {@code ContextMenuBuilder}.
     */
    @SafeVarargs
    public static ContextMenuBuilder create(javafx.scene.control.MenuItem... items) {
        ContextMenuBuilder builder = new ContextMenuBuilder();
        builder.constructorArgs = new Object[]{items};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.ContextMenu} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.ContextMenu ContextMenu} class
     */
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

    /**
     * Applies a function to the ContextMenu instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public ContextMenuBuilder apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setAnchorLocation(javafx.stage.PopupWindow$AnchorLocation) setAnchorLocation} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder anchorLocation(javafx.stage.PopupWindow.AnchorLocation value) {
        operations.add(obj -> obj.setAnchorLocation(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setAnchorX(double) setAnchorX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder anchorX(double value) {
        operations.add(obj -> obj.setAnchorX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setAnchorY(double) setAnchorY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder anchorY(double value) {
        operations.add(obj -> obj.setAnchorY(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setAutoFix(boolean) setAutoFix} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder autoFix(boolean value) {
        operations.add(obj -> obj.setAutoFix(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setAutoHide(boolean) setAutoHide} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder autoHide(boolean value) {
        operations.add(obj -> obj.setAutoHide(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setConsumeAutoHidingEvents(boolean) setConsumeAutoHidingEvents} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder consumeAutoHidingEvents(boolean value) {
        operations.add(obj -> obj.setConsumeAutoHidingEvents(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setEventDispatcher(javafx.event.EventDispatcher) setEventDispatcher} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setForceIntegerRenderScale(boolean) setForceIntegerRenderScale} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder forceIntegerRenderScale(boolean forced) {
        operations.add(obj -> obj.setForceIntegerRenderScale(forced));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setHeight(double) setHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder height(double value) {
        operations.add(obj -> obj.setHeight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setHideOnEscape(boolean) setHideOnEscape} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder hideOnEscape(boolean value) {
        operations.add(obj -> obj.setHideOnEscape(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setId(java.lang.String) setId} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setMaxHeight(double) setMaxHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setMaxSize(double, double) setMaxSize} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setMaxWidth(double) setMaxWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setMinHeight(double) setMinHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setMinSize(double, double) setMinSize} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setMinWidth(double) setMinWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setOnAction(javafx.event.EventHandler) setOnAction} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder onAction(javafx.event.EventHandler<javafx.event.ActionEvent> value) {
        operations.add(obj -> obj.setOnAction(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setOnAutoHide(javafx.event.EventHandler) setOnAutoHide} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder onAutoHide(javafx.event.EventHandler<javafx.event.Event> value) {
        operations.add(obj -> obj.setOnAutoHide(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setOnCloseRequest(javafx.event.EventHandler) setOnCloseRequest} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder onCloseRequest(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnCloseRequest(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setOnHidden(javafx.event.EventHandler) setOnHidden} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder onHidden(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnHidden(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setOnHiding(javafx.event.EventHandler) setOnHiding} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder onHiding(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnHiding(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setOnShowing(javafx.event.EventHandler) setOnShowing} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder onShowing(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnShowing(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setOnShown(javafx.event.EventHandler) setOnShown} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder onShown(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnShown(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setOpacity(double) setOpacity} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setPrefHeight(double) setPrefHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setPrefSize(double, double) setPrefSize} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setPrefWidth(double) setPrefWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setRenderScaleX(double) setRenderScaleX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder renderScaleX(double scale) {
        operations.add(obj -> obj.setRenderScaleX(scale));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setRenderScaleY(double) setRenderScaleY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder renderScaleY(double scale) {
        operations.add(obj -> obj.setRenderScaleY(scale));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setSkin(javafx.scene.control.Skin) setSkin} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder skin(javafx.scene.control.Skin<?> value) {
        operations.add(obj -> obj.setSkin(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setStyle(java.lang.String) setStyle} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setUserData(java.lang.Object) setUserData} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setWidth(double) setWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder width(double value) {
        operations.add(obj -> obj.setWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setX(double) setX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ContextMenu#setY(double) setY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ContextMenuBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ContextMenu#getItems()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final ContextMenuBuilder addItems(javafx.scene.control.MenuItem... elements) {
        operations.add(obj -> {
            obj.getItems().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ContextMenu#getItems()} method.
     * 
     * @return builder instance
     */
    public final ContextMenuBuilder addItems(java.util.Collection<? extends javafx.scene.control.MenuItem> col) {
        operations.add(obj -> {
            obj.getItems().addAll(col);
        });
        return this;
    }

    /**
     * Creates an instance of the builder, then call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ContextMenu#getItems()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public static ContextMenuBuilder withItems(javafx.scene.control.MenuItem... elements) {
        ContextMenuBuilder builder = new ContextMenuBuilder();
        return builder.addItems(elements);
    }

    /**
     * Creates an instance of the builder, then call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ContextMenu#getItems()} method.
     * 
     * @return builder instance
     */
    public static ContextMenuBuilder withItems(java.util.Collection<? extends javafx.scene.control.MenuItem> col) {
        ContextMenuBuilder builder = new ContextMenuBuilder();
        return builder.addItems(col);
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ContextMenu#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final ContextMenuBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ContextMenu#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final ContextMenuBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#anchorLocationProperty() anchorLocationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder anchorLocationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.stage.PopupWindow.AnchorLocation>> op) {
        operations.add(obj -> op.accept(obj.anchorLocationProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#anchorXProperty() anchorXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder anchorXPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.anchorXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#anchorYProperty() anchorYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder anchorYPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.anchorYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#autoFixProperty() autoFixProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder autoFixPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.autoFixProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#autoHideProperty() autoHideProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder autoHidePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.autoHideProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#consumeAutoHidingEventsProperty() consumeAutoHidingEventsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder consumeAutoHidingEventsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.consumeAutoHidingEventsProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#eventDispatcherProperty() eventDispatcherProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#focusedProperty() focusedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#forceIntegerRenderScaleProperty() forceIntegerRenderScaleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder forceIntegerRenderScalePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.forceIntegerRenderScaleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#heightProperty() heightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#hideOnEscapeProperty() hideOnEscapeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder hideOnEscapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hideOnEscapeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#idProperty() idProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#maxHeightProperty() maxHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#maxWidthProperty() maxWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#minHeightProperty() minHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#minWidthProperty() minWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#onActionProperty() onActionProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onActionProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onActionPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ContextMenuBuilder onActionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.ActionEvent>>> op) {
        operations.add(obj -> op.accept(obj.onActionProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#onAutoHideProperty() onAutoHideProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder onAutoHidePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.Event>>> op) {
        operations.add(obj -> op.accept(obj.onAutoHideProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#onCloseRequestProperty() onCloseRequestProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder onCloseRequestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onCloseRequestProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#onHiddenProperty() onHiddenProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder onHiddenPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHiddenProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#onHidingProperty() onHidingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder onHidingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHidingProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#onShowingProperty() onShowingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder onShowingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShowingProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#onShownProperty() onShownProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder onShownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShownProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#opacityProperty() opacityProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#outputScaleXProperty() outputScaleXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder outputScaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.outputScaleXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#outputScaleYProperty() outputScaleYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder outputScaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.outputScaleYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#ownerNodeProperty() ownerNodeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder ownerNodePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.ownerNodeProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#ownerWindowProperty() ownerWindowProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder ownerWindowPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.stage.Window>> op) {
        operations.add(obj -> op.accept(obj.ownerWindowProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#prefHeightProperty() prefHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#prefWidthProperty() prefWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#renderScaleXProperty() renderScaleXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder renderScaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.renderScaleXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#renderScaleYProperty() renderScaleYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder renderScaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.renderScaleYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#sceneProperty() sceneProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#showingProperty() showingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder showingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.showingProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#skinProperty() skinProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder skinPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Skin<?>>> op) {
        operations.add(obj -> op.accept(obj.skinProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#styleProperty() styleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#widthProperty() widthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#xProperty() xProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ContextMenu#yProperty() yProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ContextMenu> func) apply} method.
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
    public ContextMenuBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
