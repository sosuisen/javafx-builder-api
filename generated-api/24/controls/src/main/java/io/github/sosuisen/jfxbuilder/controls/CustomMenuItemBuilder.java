
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code CustomMenuItemBuilder} class constructs instances of the {@link javafx.scene.control.CustomMenuItem CustomMenuItem} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.CustomMenuItem CustomMenuItem} constructor
 * and returns an instance of the {@code CustomMenuItemBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.CustomMenuItem CustomMenuItem}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.CustomMenuItem CustomMenuItem} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class CustomMenuItemBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.CustomMenuItem>> operations = new java.util.ArrayList<>();
    private CustomMenuItemBuilder() {}
    

    public static CustomMenuItemBuilder create() { return new CustomMenuItemBuilder(); }


    
    public static CustomMenuItemBuilder create(javafx.scene.Node node) {
        CustomMenuItemBuilder builder = new CustomMenuItemBuilder();
        builder.constructorArgs = new Object[]{node};
        return builder;
    }


    
    public static CustomMenuItemBuilder create(javafx.scene.Node node, boolean hideOnClick) {
        CustomMenuItemBuilder builder = new CustomMenuItemBuilder();
        builder.constructorArgs = new Object[]{node, hideOnClick};
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
     * @return new instance of the {@link javafx.scene.control.CustomMenuItem CustomMenuItem} class
     */
    public javafx.scene.control.CustomMenuItem build() {
        javafx.scene.control.CustomMenuItem newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.CustomMenuItem();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.CustomMenuItem> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.CustomMenuItem callParameterizedConstructor() {
        javafx.scene.control.CustomMenuItem newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.CustomMenuItem.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.CustomMenuItem) constructor.newInstance(constructorArgs);
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
     * Applies a function to the CustomMenuItem instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public CustomMenuItemBuilder apply(java.util.function.Consumer<javafx.scene.control.CustomMenuItem> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CustomMenuItem#setAccelerator(javafx.scene.input.KeyCombination)}
     * 
     * @return builder instance
     */    
    
    public  CustomMenuItemBuilder accelerator(javafx.scene.input.KeyCombination value) {
        operations.add(obj -> obj.setAccelerator(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CustomMenuItem#setContent(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  CustomMenuItemBuilder content(javafx.scene.Node value) {
        operations.add(obj -> obj.setContent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CustomMenuItem#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CustomMenuItemBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CustomMenuItem#setGraphic(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  CustomMenuItemBuilder graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CustomMenuItem#setHideOnClick(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CustomMenuItemBuilder hideOnClick(boolean value) {
        operations.add(obj -> obj.setHideOnClick(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CustomMenuItem#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CustomMenuItemBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CustomMenuItem#setMnemonicParsing(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CustomMenuItemBuilder mnemonicParsing(boolean value) {
        operations.add(obj -> obj.setMnemonicParsing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CustomMenuItem#setOnAction(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CustomMenuItemBuilder onAction(javafx.event.EventHandler<javafx.event.ActionEvent> value) {
        operations.add(obj -> obj.setOnAction(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CustomMenuItem#setOnMenuValidation(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CustomMenuItemBuilder onMenuValidation(javafx.event.EventHandler<javafx.event.Event> value) {
        operations.add(obj -> obj.setOnMenuValidation(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CustomMenuItem#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CustomMenuItemBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CustomMenuItem#setText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CustomMenuItemBuilder text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CustomMenuItem#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  CustomMenuItemBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CustomMenuItem#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CustomMenuItemBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.CustomMenuItem#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final CustomMenuItemBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.CustomMenuItem#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final CustomMenuItemBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }


    
    /**
     * Applies a function to the {@link javafx.scene.control.CustomMenuItem#acceleratorProperty()}.
     * 
     * @return builder instance
     */    
    
    public CustomMenuItemBuilder acceleratorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.KeyCombination>> op) {
        operations.add(obj -> op.accept(obj.acceleratorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CustomMenuItem#contentProperty()}.
     * 
     * @return builder instance
     */    
    
    public CustomMenuItemBuilder contentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.contentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CustomMenuItem#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public CustomMenuItemBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CustomMenuItem#graphicProperty()}.
     * 
     * @return builder instance
     */    
    
    public CustomMenuItemBuilder graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CustomMenuItem#hideOnClickProperty()}.
     * 
     * @return builder instance
     */    
    
    public CustomMenuItemBuilder hideOnClickPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hideOnClickProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CustomMenuItem#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public CustomMenuItemBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CustomMenuItem#mnemonicParsingProperty()}.
     * 
     * @return builder instance
     */    
    
    public CustomMenuItemBuilder mnemonicParsingPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mnemonicParsingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CustomMenuItem#onActionProperty()}.
     * 
     * @return builder instance
     */    
    
    public CustomMenuItemBuilder onActionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.ActionEvent>>> op) {
        operations.add(obj -> op.accept(obj.onActionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CustomMenuItem#onMenuValidationProperty()}.
     * 
     * @return builder instance
     */    
    
    public CustomMenuItemBuilder onMenuValidationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.Event>>> op) {
        operations.add(obj -> op.accept(obj.onMenuValidationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CustomMenuItem#parentMenuProperty()}.
     * 
     * @return builder instance
     */    
    
    public CustomMenuItemBuilder parentMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.Menu>> op) {
        operations.add(obj -> op.accept(obj.parentMenuProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CustomMenuItem#parentPopupProperty()}.
     * 
     * @return builder instance
     */    
    
    public CustomMenuItemBuilder parentPopupPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.parentPopupProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CustomMenuItem#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public CustomMenuItemBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CustomMenuItem#textProperty()}.
     * 
     * @return builder instance
     */    
    
    public CustomMenuItemBuilder textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CustomMenuItem#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public CustomMenuItemBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }
}
