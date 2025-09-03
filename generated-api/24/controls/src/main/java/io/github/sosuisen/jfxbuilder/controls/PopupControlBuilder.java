
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
    

    /**
     * Returns an instance of the {@code PopupControlBuilder}.
     *
     * @return an instance of the {@code PopupControlBuilder}.
     */
    public static PopupControlBuilder create() { return new PopupControlBuilder(); }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.PopupControl} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
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
     * Applies a function to the PopupControl instance being constructed.
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
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setAnchorLocation(javafx.stage.PopupWindow$AnchorLocation) setAnchorLocation} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder anchorLocation(javafx.stage.PopupWindow.AnchorLocation value) {
        operations.add(obj -> obj.setAnchorLocation(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setAnchorX(double) setAnchorX} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder anchorX(double value) {
        operations.add(obj -> obj.setAnchorX(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setAnchorY(double) setAnchorY} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder anchorY(double value) {
        operations.add(obj -> obj.setAnchorY(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setAutoFix(boolean) setAutoFix} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder autoFix(boolean value) {
        operations.add(obj -> obj.setAutoFix(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setAutoHide(boolean) setAutoHide} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder autoHide(boolean value) {
        operations.add(obj -> obj.setAutoHide(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setConsumeAutoHidingEvents(boolean) setConsumeAutoHidingEvents} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder consumeAutoHidingEvents(boolean value) {
        operations.add(obj -> obj.setConsumeAutoHidingEvents(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setEventDispatcher(javafx.event.EventDispatcher) setEventDispatcher} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setForceIntegerRenderScale(boolean) setForceIntegerRenderScale} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder forceIntegerRenderScale(boolean forced) {
        operations.add(obj -> obj.setForceIntegerRenderScale(forced));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setHeight(double) setHeight} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder height(double value) {
        operations.add(obj -> obj.setHeight(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setHideOnEscape(boolean) setHideOnEscape} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder hideOnEscape(boolean value) {
        operations.add(obj -> obj.setHideOnEscape(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setId(java.lang.String) setId} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setMaxHeight(double) setMaxHeight} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setMaxSize(double, double) setMaxSize} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setMaxWidth(double) setMaxWidth} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setMinHeight(double) setMinHeight} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setMinSize(double, double) setMinSize} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setMinWidth(double) setMinWidth} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setOnAutoHide(javafx.event.EventHandler) setOnAutoHide} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder onAutoHide(javafx.event.EventHandler<javafx.event.Event> value) {
        operations.add(obj -> obj.setOnAutoHide(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setOnCloseRequest(javafx.event.EventHandler) setOnCloseRequest} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder onCloseRequest(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnCloseRequest(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setOnHidden(javafx.event.EventHandler) setOnHidden} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder onHidden(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnHidden(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setOnHiding(javafx.event.EventHandler) setOnHiding} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder onHiding(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnHiding(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setOnShowing(javafx.event.EventHandler) setOnShowing} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder onShowing(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnShowing(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setOnShown(javafx.event.EventHandler) setOnShown} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder onShown(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnShown(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setOpacity(double) setOpacity} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setPrefHeight(double) setPrefHeight} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setPrefSize(double, double) setPrefSize} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setPrefWidth(double) setPrefWidth} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setRenderScaleX(double) setRenderScaleX} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder renderScaleX(double scale) {
        operations.add(obj -> obj.setRenderScaleX(scale));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setRenderScaleY(double) setRenderScaleY} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder renderScaleY(double scale) {
        operations.add(obj -> obj.setRenderScaleY(scale));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setSkin(javafx.scene.control.Skin) setSkin} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder skin(javafx.scene.control.Skin<?> value) {
        operations.add(obj -> obj.setSkin(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setStyle(java.lang.String) setStyle} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setUserData(java.lang.Object) setUserData} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setWidth(double) setWidth} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder width(double value) {
        operations.add(obj -> obj.setWidth(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setX(double) setX} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.PopupControl#setY(double) setY} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  PopupControlBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }
    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.PopupControl#getStyleClass()} method.
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
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.PopupControl#getStyleClass()} method.
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
     * Applies a function to the {@link javafx.scene.control.PopupControl#anchorLocationProperty() anchorLocationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder anchorLocationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.stage.PopupWindow.AnchorLocation>> op) {
        operations.add(obj -> op.accept(obj.anchorLocationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#anchorXProperty() anchorXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder anchorXPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.anchorXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#anchorYProperty() anchorYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder anchorYPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.anchorYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#autoFixProperty() autoFixProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder autoFixPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.autoFixProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#autoHideProperty() autoHideProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder autoHidePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.autoHideProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#consumeAutoHidingEventsProperty() consumeAutoHidingEventsProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder consumeAutoHidingEventsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.consumeAutoHidingEventsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#eventDispatcherProperty() eventDispatcherProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#focusedProperty() focusedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#forceIntegerRenderScaleProperty() forceIntegerRenderScaleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder forceIntegerRenderScalePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.forceIntegerRenderScaleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#heightProperty() heightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#hideOnEscapeProperty() hideOnEscapeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder hideOnEscapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hideOnEscapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#idProperty() idProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#maxHeightProperty() maxHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#maxWidthProperty() maxWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#minHeightProperty() minHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#minWidthProperty() minWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#onAutoHideProperty() onAutoHideProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder onAutoHidePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.Event>>> op) {
        operations.add(obj -> op.accept(obj.onAutoHideProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#onCloseRequestProperty() onCloseRequestProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder onCloseRequestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onCloseRequestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#onHiddenProperty() onHiddenProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder onHiddenPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHiddenProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#onHidingProperty() onHidingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder onHidingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHidingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#onShowingProperty() onShowingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder onShowingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShowingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#onShownProperty() onShownProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder onShownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#opacityProperty() opacityProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#outputScaleXProperty() outputScaleXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder outputScaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.outputScaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#outputScaleYProperty() outputScaleYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder outputScaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.outputScaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#ownerNodeProperty() ownerNodeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder ownerNodePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.ownerNodeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#ownerWindowProperty() ownerWindowProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder ownerWindowPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.stage.Window>> op) {
        operations.add(obj -> op.accept(obj.ownerWindowProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#prefHeightProperty() prefHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#prefWidthProperty() prefWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#renderScaleXProperty() renderScaleXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder renderScaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.renderScaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#renderScaleYProperty() renderScaleYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder renderScaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.renderScaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#sceneProperty() sceneProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#showingProperty() showingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder showingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.showingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#skinProperty() skinProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder skinPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Skin<?>>> op) {
        operations.add(obj -> op.accept(obj.skinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#styleProperty() styleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#widthProperty() widthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#xProperty() xProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.PopupControl#yProperty() yProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.PopupControl> func) apply} method.
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
    
    public PopupControlBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
