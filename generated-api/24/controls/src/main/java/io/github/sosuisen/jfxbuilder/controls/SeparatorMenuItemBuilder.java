
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code SeparatorMenuItemBuilder} class constructs instances of the {@link javafx.scene.control.SeparatorMenuItem SeparatorMenuItem} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.SeparatorMenuItem SeparatorMenuItem} constructor
 * and returns an instance of the {@code SeparatorMenuItemBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.SeparatorMenuItem SeparatorMenuItem}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.SeparatorMenuItem SeparatorMenuItem} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class SeparatorMenuItemBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.SeparatorMenuItem>> operations = new java.util.ArrayList<>();
    private SeparatorMenuItemBuilder() {}
    

    /**
     * Returns an instance of the {@code SeparatorMenuItemBuilder}.
     *
     * @return an instance of the {@code SeparatorMenuItemBuilder}.
     */
    public static SeparatorMenuItemBuilder create() { return new SeparatorMenuItemBuilder(); }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.SeparatorMenuItem} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.SeparatorMenuItem SeparatorMenuItem} class
     */
    public javafx.scene.control.SeparatorMenuItem build() {
        javafx.scene.control.SeparatorMenuItem newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.SeparatorMenuItem();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.SeparatorMenuItem> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.SeparatorMenuItem callParameterizedConstructor() {
        javafx.scene.control.SeparatorMenuItem newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.SeparatorMenuItem.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.SeparatorMenuItem) constructor.newInstance(constructorArgs);
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
     * Applies a function to the SeparatorMenuItem instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public SeparatorMenuItemBuilder apply(java.util.function.Consumer<javafx.scene.control.SeparatorMenuItem> func) {
        operations.add(func);
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.SeparatorMenuItem#setAccelerator(javafx.scene.input.KeyCombination) setAccelerator} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  SeparatorMenuItemBuilder accelerator(javafx.scene.input.KeyCombination value) {
        operations.add(obj -> obj.setAccelerator(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.SeparatorMenuItem#setContent(javafx.scene.Node) setContent} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  SeparatorMenuItemBuilder content(javafx.scene.Node value) {
        operations.add(obj -> obj.setContent(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.SeparatorMenuItem#setDisable(boolean) setDisable} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  SeparatorMenuItemBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.SeparatorMenuItem#setGraphic(javafx.scene.Node) setGraphic} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  SeparatorMenuItemBuilder graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.SeparatorMenuItem#setHideOnClick(boolean) setHideOnClick} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  SeparatorMenuItemBuilder hideOnClick(boolean value) {
        operations.add(obj -> obj.setHideOnClick(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.SeparatorMenuItem#setId(java.lang.String) setId} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  SeparatorMenuItemBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.SeparatorMenuItem#setMnemonicParsing(boolean) setMnemonicParsing} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  SeparatorMenuItemBuilder mnemonicParsing(boolean value) {
        operations.add(obj -> obj.setMnemonicParsing(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.SeparatorMenuItem#setOnAction(javafx.event.EventHandler) setOnAction} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  SeparatorMenuItemBuilder onAction(javafx.event.EventHandler<javafx.event.ActionEvent> value) {
        operations.add(obj -> obj.setOnAction(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.SeparatorMenuItem#setOnMenuValidation(javafx.event.EventHandler) setOnMenuValidation} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  SeparatorMenuItemBuilder onMenuValidation(javafx.event.EventHandler<javafx.event.Event> value) {
        operations.add(obj -> obj.setOnMenuValidation(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.SeparatorMenuItem#setStyle(java.lang.String) setStyle} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  SeparatorMenuItemBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.SeparatorMenuItem#setText(java.lang.String) setText} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  SeparatorMenuItemBuilder text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.SeparatorMenuItem#setUserData(java.lang.Object) setUserData} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  SeparatorMenuItemBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * A builder method that invokes the {@link javafx.scene.control.SeparatorMenuItem#setVisible(boolean) setVisible} method on the instance being constructed.
     *
     * @return builder instance
     */    
    
    public  SeparatorMenuItemBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.SeparatorMenuItem#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final SeparatorMenuItemBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.SeparatorMenuItem#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final SeparatorMenuItemBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }


    
    /**
     * Applies a function to the {@link javafx.scene.control.SeparatorMenuItem#acceleratorProperty() acceleratorProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.SeparatorMenuItem> func) apply} method.
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
    
    public SeparatorMenuItemBuilder acceleratorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.KeyCombination>> op) {
        operations.add(obj -> op.accept(obj.acceleratorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SeparatorMenuItem#contentProperty() contentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.SeparatorMenuItem> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.contentProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .contentPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public SeparatorMenuItemBuilder contentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.contentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SeparatorMenuItem#disableProperty() disableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.SeparatorMenuItem> func) apply} method.
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
    
    public SeparatorMenuItemBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SeparatorMenuItem#graphicProperty() graphicProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.SeparatorMenuItem> func) apply} method.
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
    
    public SeparatorMenuItemBuilder graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SeparatorMenuItem#hideOnClickProperty() hideOnClickProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.SeparatorMenuItem> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.hideOnClickProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .hideOnClickPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public SeparatorMenuItemBuilder hideOnClickPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hideOnClickProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SeparatorMenuItem#idProperty() idProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.SeparatorMenuItem> func) apply} method.
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
    
    public SeparatorMenuItemBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SeparatorMenuItem#mnemonicParsingProperty() mnemonicParsingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.SeparatorMenuItem> func) apply} method.
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
    
    public SeparatorMenuItemBuilder mnemonicParsingPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mnemonicParsingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SeparatorMenuItem#onActionProperty() onActionProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.SeparatorMenuItem> func) apply} method.
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
    
    public SeparatorMenuItemBuilder onActionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.ActionEvent>>> op) {
        operations.add(obj -> op.accept(obj.onActionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SeparatorMenuItem#onMenuValidationProperty() onMenuValidationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.SeparatorMenuItem> func) apply} method.
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
    
    public SeparatorMenuItemBuilder onMenuValidationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.Event>>> op) {
        operations.add(obj -> op.accept(obj.onMenuValidationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SeparatorMenuItem#parentMenuProperty() parentMenuProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.SeparatorMenuItem> func) apply} method.
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
    
    public SeparatorMenuItemBuilder parentMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.Menu>> op) {
        operations.add(obj -> op.accept(obj.parentMenuProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SeparatorMenuItem#parentPopupProperty() parentPopupProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.SeparatorMenuItem> func) apply} method.
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
    
    public SeparatorMenuItemBuilder parentPopupPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.parentPopupProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SeparatorMenuItem#styleProperty() styleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.SeparatorMenuItem> func) apply} method.
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
    
    public SeparatorMenuItemBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SeparatorMenuItem#textProperty() textProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.SeparatorMenuItem> func) apply} method.
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
    
    public SeparatorMenuItemBuilder textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SeparatorMenuItem#visibleProperty() visibleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.SeparatorMenuItem> func) apply} method.
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
    
    public SeparatorMenuItemBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }
}
