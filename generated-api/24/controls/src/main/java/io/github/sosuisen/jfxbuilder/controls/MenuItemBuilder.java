
package io.github.sosuisen.jfxbuilder.controls;


public class MenuItemBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.MenuItem>> operations = new java.util.ArrayList<>();
    private MenuItemBuilder() {}
    

    public static MenuItemBuilder create() { return new MenuItemBuilder(); }


    
    public static MenuItemBuilder create(java.lang.String text) {
        MenuItemBuilder builder = new MenuItemBuilder();
        builder.constructorArgs = new Object[]{text};
        return builder;
    }


    
    public static MenuItemBuilder create(java.lang.String text, javafx.scene.Node graphic) {
        MenuItemBuilder builder = new MenuItemBuilder();
        builder.constructorArgs = new Object[]{text, graphic};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.control.MenuItem build() {
        javafx.scene.control.MenuItem newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.MenuItem();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.MenuItem> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.MenuItem callParameterizedConstructor() {
        javafx.scene.control.MenuItem newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.MenuItem.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.MenuItem) constructor.newInstance(constructorArgs);
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
    
    public MenuItemBuilder apply(java.util.function.Consumer<javafx.scene.control.MenuItem> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.MenuItem#setAccelerator(javafx.scene.input.KeyCombination)}
     * 
     * @return builder instance
     */    
    
    public  MenuItemBuilder accelerator(javafx.scene.input.KeyCombination value) {
        operations.add(obj -> obj.setAccelerator(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.MenuItem#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  MenuItemBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.MenuItem#setGraphic(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  MenuItemBuilder graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.MenuItem#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  MenuItemBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.MenuItem#setMnemonicParsing(boolean)}
     * 
     * @return builder instance
     */    
    
    public  MenuItemBuilder mnemonicParsing(boolean value) {
        operations.add(obj -> obj.setMnemonicParsing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.MenuItem#setOnAction(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MenuItemBuilder onAction(javafx.event.EventHandler<javafx.event.ActionEvent> value) {
        operations.add(obj -> obj.setOnAction(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.MenuItem#setOnMenuValidation(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MenuItemBuilder onMenuValidation(javafx.event.EventHandler<javafx.event.Event> value) {
        operations.add(obj -> obj.setOnMenuValidation(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.MenuItem#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  MenuItemBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.MenuItem#setText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  MenuItemBuilder text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.MenuItem#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  MenuItemBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.MenuItem#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  MenuItemBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    @SafeVarargs
    public final MenuItemBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    public final MenuItemBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }

    
    /**
     * Applies a function to the {@link javafx.scene.control.MenuItem#acceleratorProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuItemBuilder acceleratorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.KeyCombination>> op) {
        operations.add(obj -> op.accept(obj.acceleratorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.MenuItem#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuItemBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.MenuItem#graphicProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuItemBuilder graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.MenuItem#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuItemBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.MenuItem#mnemonicParsingProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuItemBuilder mnemonicParsingPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mnemonicParsingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.MenuItem#onActionProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuItemBuilder onActionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.ActionEvent>>> op) {
        operations.add(obj -> op.accept(obj.onActionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.MenuItem#onMenuValidationProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuItemBuilder onMenuValidationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.Event>>> op) {
        operations.add(obj -> op.accept(obj.onMenuValidationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.MenuItem#parentMenuProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuItemBuilder parentMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.Menu>> op) {
        operations.add(obj -> op.accept(obj.parentMenuProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.MenuItem#parentPopupProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuItemBuilder parentPopupPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.parentPopupProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.MenuItem#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuItemBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.MenuItem#textProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuItemBuilder textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.MenuItem#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuItemBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }
}
