
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code CheckMenuItemBuilder} class constructs instances of the {@link javafx.scene.control.CheckMenuItem CheckMenuItem} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.CheckMenuItem CheckMenuItem} constructor
 * and returns an instance of the {@code CheckMenuItemBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.CheckMenuItem CheckMenuItem}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.CheckMenuItem CheckMenuItem} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class CheckMenuItemBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.CheckMenuItem>> operations = new java.util.ArrayList<>();
    private CheckMenuItemBuilder() {}
    

    public static CheckMenuItemBuilder create() { return new CheckMenuItemBuilder(); }


    
    public static CheckMenuItemBuilder create(java.lang.String text) {
        CheckMenuItemBuilder builder = new CheckMenuItemBuilder();
        builder.constructorArgs = new Object[]{text};
        return builder;
    }


    
    public static CheckMenuItemBuilder create(java.lang.String text, javafx.scene.Node graphic) {
        CheckMenuItemBuilder builder = new CheckMenuItemBuilder();
        builder.constructorArgs = new Object[]{text, graphic};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * This method builds and returns an instance of the original class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the build() method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.CheckMenuItem CheckMenuItem} class
     */
    public javafx.scene.control.CheckMenuItem build() {
        javafx.scene.control.CheckMenuItem newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.CheckMenuItem();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.CheckMenuItem> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.CheckMenuItem callParameterizedConstructor() {
        javafx.scene.control.CheckMenuItem newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.CheckMenuItem.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.CheckMenuItem) constructor.newInstance(constructorArgs);
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
     * Applies a function to the CheckMenuItem instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public CheckMenuItemBuilder apply(java.util.function.Consumer<javafx.scene.control.CheckMenuItem> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CheckMenuItem#setAccelerator(javafx.scene.input.KeyCombination)}
     * 
     * @return builder instance
     */    
    
    public  CheckMenuItemBuilder accelerator(javafx.scene.input.KeyCombination value) {
        operations.add(obj -> obj.setAccelerator(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CheckMenuItem#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckMenuItemBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CheckMenuItem#setGraphic(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  CheckMenuItemBuilder graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CheckMenuItem#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CheckMenuItemBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CheckMenuItem#setMnemonicParsing(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckMenuItemBuilder mnemonicParsing(boolean value) {
        operations.add(obj -> obj.setMnemonicParsing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CheckMenuItem#setOnAction(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckMenuItemBuilder onAction(javafx.event.EventHandler<javafx.event.ActionEvent> value) {
        operations.add(obj -> obj.setOnAction(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CheckMenuItem#setOnMenuValidation(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckMenuItemBuilder onMenuValidation(javafx.event.EventHandler<javafx.event.Event> value) {
        operations.add(obj -> obj.setOnMenuValidation(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CheckMenuItem#setSelected(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckMenuItemBuilder selected(boolean value) {
        operations.add(obj -> obj.setSelected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CheckMenuItem#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CheckMenuItemBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CheckMenuItem#setText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CheckMenuItemBuilder text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CheckMenuItem#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  CheckMenuItemBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CheckMenuItem#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckMenuItemBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.CheckMenuItem#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final CheckMenuItemBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.CheckMenuItem#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final CheckMenuItemBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }


    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckMenuItem#acceleratorProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckMenuItemBuilder acceleratorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.KeyCombination>> op) {
        operations.add(obj -> op.accept(obj.acceleratorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckMenuItem#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckMenuItemBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckMenuItem#graphicProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckMenuItemBuilder graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckMenuItem#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckMenuItemBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckMenuItem#mnemonicParsingProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckMenuItemBuilder mnemonicParsingPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mnemonicParsingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckMenuItem#onActionProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckMenuItemBuilder onActionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.ActionEvent>>> op) {
        operations.add(obj -> op.accept(obj.onActionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckMenuItem#onMenuValidationProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckMenuItemBuilder onMenuValidationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.Event>>> op) {
        operations.add(obj -> op.accept(obj.onMenuValidationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckMenuItem#parentMenuProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckMenuItemBuilder parentMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.Menu>> op) {
        operations.add(obj -> op.accept(obj.parentMenuProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckMenuItem#parentPopupProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckMenuItemBuilder parentPopupPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.parentPopupProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckMenuItem#selectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckMenuItemBuilder selectedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.selectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckMenuItem#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckMenuItemBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckMenuItem#textProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckMenuItemBuilder textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckMenuItem#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckMenuItemBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }
}
