
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code RadioMenuItemBuilder} class constructs instances of the {@link javafx.scene.control.RadioMenuItem RadioMenuItem} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.RadioMenuItem RadioMenuItem} constructor
 * and returns an instance of the {@code RadioMenuItemBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.RadioMenuItem RadioMenuItem}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.RadioMenuItem RadioMenuItem} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class RadioMenuItemBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.control.RadioMenuItem>> operations = new java.util.ArrayList<>();
    private RadioMenuItemBuilder() {}
    
    /**
     * Returns an instance of the {@code RadioMenuItemBuilder}.
     *
     * @return an instance of the {@code RadioMenuItemBuilder}.
     */
    public static RadioMenuItemBuilder create() { return new RadioMenuItemBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.RadioMenuItem#RadioMenuItem(java.lang.String) RadioMenuItem(String)}
     * and returns an instance of {@code RadioMenuItemBuilder}.
     *
     * @return an instance of the {@code RadioMenuItemBuilder}.
     */
    public static RadioMenuItemBuilder create(java.lang.String text) {
        RadioMenuItemBuilder builder = new RadioMenuItemBuilder();
        builder.constructorArgs = new Object[]{text};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.RadioMenuItem#RadioMenuItem(java.lang.String, javafx.scene.Node) RadioMenuItem(String, Node)}
     * and returns an instance of {@code RadioMenuItemBuilder}.
     *
     * @return an instance of the {@code RadioMenuItemBuilder}.
     */
    public static RadioMenuItemBuilder create(java.lang.String text, javafx.scene.Node graphic) {
        RadioMenuItemBuilder builder = new RadioMenuItemBuilder();
        builder.constructorArgs = new Object[]{text, graphic};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.RadioMenuItem} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.RadioMenuItem RadioMenuItem} class
     */
    public javafx.scene.control.RadioMenuItem build() {
        javafx.scene.control.RadioMenuItem newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.RadioMenuItem();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.RadioMenuItem> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.RadioMenuItem callParameterizedConstructor() {
        javafx.scene.control.RadioMenuItem newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.RadioMenuItem.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.RadioMenuItem) constructor.newInstance(constructorArgs);
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
     * Applies a function to the RadioMenuItem instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public RadioMenuItemBuilder apply(java.util.function.Consumer<javafx.scene.control.RadioMenuItem> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.MenuItem#setAccelerator(javafx.scene.input.KeyCombination) setAccelerator} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  RadioMenuItemBuilder accelerator(javafx.scene.input.KeyCombination value) {
        operations.add(obj -> obj.setAccelerator(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.MenuItem#setDisable(boolean) setDisable} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  RadioMenuItemBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.MenuItem#setGraphic(javafx.scene.Node) setGraphic} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  RadioMenuItemBuilder graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.MenuItem#setId(java.lang.String) setId} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  RadioMenuItemBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.MenuItem#setMnemonicParsing(boolean) setMnemonicParsing} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  RadioMenuItemBuilder mnemonicParsing(boolean value) {
        operations.add(obj -> obj.setMnemonicParsing(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.MenuItem#setOnAction(javafx.event.EventHandler) setOnAction} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  RadioMenuItemBuilder onAction(javafx.event.EventHandler<javafx.event.ActionEvent> value) {
        operations.add(obj -> obj.setOnAction(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.MenuItem#setOnMenuValidation(javafx.event.EventHandler) setOnMenuValidation} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  RadioMenuItemBuilder onMenuValidation(javafx.event.EventHandler<javafx.event.Event> value) {
        operations.add(obj -> obj.setOnMenuValidation(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.RadioMenuItem#setSelected(boolean) setSelected} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  RadioMenuItemBuilder selected(boolean value) {
        operations.add(obj -> obj.setSelected(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.MenuItem#setStyle(java.lang.String) setStyle} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  RadioMenuItemBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.MenuItem#setText(java.lang.String) setText} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  RadioMenuItemBuilder text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.RadioMenuItem#setToggleGroup(javafx.scene.control.ToggleGroup) setToggleGroup} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  RadioMenuItemBuilder toggleGroup(javafx.scene.control.ToggleGroup value) {
        operations.add(obj -> obj.setToggleGroup(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.MenuItem#setUserData(java.lang.Object) setUserData} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  RadioMenuItemBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.MenuItem#setVisible(boolean) setVisible} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  RadioMenuItemBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(java.lang.Object[]) addAll} method on the ObservableList returned by the {@link javafx.scene.control.RadioMenuItem#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final RadioMenuItemBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> obj.getStyleClass().addAll(elements));
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(java.util.Collection) addAll} method on the ObservableList returned by the {@link javafx.scene.control.RadioMenuItem#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final RadioMenuItemBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> obj.getStyleClass().addAll(col));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.RadioMenuItem#acceleratorProperty() acceleratorProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RadioMenuItemBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.acceleratorProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .acceleratorPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public RadioMenuItemBuilder acceleratorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.KeyCombination>> op) {
        operations.add(obj -> op.accept(obj.acceleratorProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.RadioMenuItem#disableProperty() disableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RadioMenuItemBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.disableProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .disablePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public RadioMenuItemBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.RadioMenuItem#graphicProperty() graphicProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RadioMenuItemBuilder#apply(java.util.function.Consumer) apply} method.
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
    public RadioMenuItemBuilder graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.RadioMenuItem#idProperty() idProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RadioMenuItemBuilder#apply(java.util.function.Consumer) apply} method.
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
    public RadioMenuItemBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.RadioMenuItem#mnemonicParsingProperty() mnemonicParsingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RadioMenuItemBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.mnemonicParsingProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .mnemonicParsingPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public RadioMenuItemBuilder mnemonicParsingPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mnemonicParsingProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.RadioMenuItem#onActionProperty() onActionProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RadioMenuItemBuilder#apply(java.util.function.Consumer) apply} method.
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
    public RadioMenuItemBuilder onActionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.ActionEvent>>> op) {
        operations.add(obj -> op.accept(obj.onActionProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.RadioMenuItem#onMenuValidationProperty() onMenuValidationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RadioMenuItemBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onMenuValidationProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onMenuValidationPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public RadioMenuItemBuilder onMenuValidationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.Event>>> op) {
        operations.add(obj -> op.accept(obj.onMenuValidationProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.RadioMenuItem#parentMenuProperty() parentMenuProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RadioMenuItemBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.parentMenuProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .parentMenuPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public RadioMenuItemBuilder parentMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.Menu>> op) {
        operations.add(obj -> op.accept(obj.parentMenuProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.RadioMenuItem#parentPopupProperty() parentPopupProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RadioMenuItemBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.parentPopupProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .parentPopupPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public RadioMenuItemBuilder parentPopupPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.parentPopupProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.RadioMenuItem#selectedProperty() selectedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RadioMenuItemBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.selectedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .selectedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public RadioMenuItemBuilder selectedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.selectedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.RadioMenuItem#styleProperty() styleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RadioMenuItemBuilder#apply(java.util.function.Consumer) apply} method.
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
    public RadioMenuItemBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.RadioMenuItem#textProperty() textProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RadioMenuItemBuilder#apply(java.util.function.Consumer) apply} method.
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
    public RadioMenuItemBuilder textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.RadioMenuItem#toggleGroupProperty() toggleGroupProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RadioMenuItemBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.toggleGroupProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .toggleGroupPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public RadioMenuItemBuilder toggleGroupPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ToggleGroup>> op) {
        operations.add(obj -> op.accept(obj.toggleGroupProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.RadioMenuItem#visibleProperty() visibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link RadioMenuItemBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.visibleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .visiblePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public RadioMenuItemBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }
}
