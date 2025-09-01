
package io.github.sosuisen.jfxbuilder.controls;


public class MenuBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.Menu>> operations = new java.util.ArrayList<>();
    private MenuBuilder() {}
    

    public static MenuBuilder create() { return new MenuBuilder(); }


    
    public static MenuBuilder create(java.lang.String text) {
        MenuBuilder builder = new MenuBuilder();
        builder.constructorArgs = new Object[]{text};
        return builder;
    }


    
    public static MenuBuilder create(java.lang.String text, javafx.scene.Node graphic) {
        MenuBuilder builder = new MenuBuilder();
        builder.constructorArgs = new Object[]{text, graphic};
        return builder;
    }


    @SafeVarargs
    public static MenuBuilder create(java.lang.String text, javafx.scene.Node graphic, javafx.scene.control.MenuItem... items) {
        MenuBuilder builder = new MenuBuilder();
        builder.constructorArgs = new Object[]{text, graphic, items};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.control.Menu build() {
        javafx.scene.control.Menu newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.Menu();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.Menu> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.Menu callParameterizedConstructor() {
        javafx.scene.control.Menu newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.Menu.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.Menu) constructor.newInstance(constructorArgs);
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
    
    public MenuBuilder apply(java.util.function.Consumer<javafx.scene.control.Menu> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Menu#setAccelerator(javafx.scene.input.KeyCombination)}
     * 
     * @return builder instance
     */    
    
    public  MenuBuilder accelerator(javafx.scene.input.KeyCombination value) {
        operations.add(obj -> obj.setAccelerator(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Menu#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  MenuBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Menu#setGraphic(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  MenuBuilder graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Menu#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  MenuBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Menu#setMnemonicParsing(boolean)}
     * 
     * @return builder instance
     */    
    
    public  MenuBuilder mnemonicParsing(boolean value) {
        operations.add(obj -> obj.setMnemonicParsing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Menu#setOnAction(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MenuBuilder onAction(javafx.event.EventHandler<javafx.event.ActionEvent> value) {
        operations.add(obj -> obj.setOnAction(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Menu#setOnHidden(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MenuBuilder onHidden(javafx.event.EventHandler<javafx.event.Event> value) {
        operations.add(obj -> obj.setOnHidden(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Menu#setOnHiding(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MenuBuilder onHiding(javafx.event.EventHandler<javafx.event.Event> value) {
        operations.add(obj -> obj.setOnHiding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Menu#setOnMenuValidation(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MenuBuilder onMenuValidation(javafx.event.EventHandler<javafx.event.Event> value) {
        operations.add(obj -> obj.setOnMenuValidation(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Menu#setOnShowing(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MenuBuilder onShowing(javafx.event.EventHandler<javafx.event.Event> value) {
        operations.add(obj -> obj.setOnShowing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Menu#setOnShown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MenuBuilder onShown(javafx.event.EventHandler<javafx.event.Event> value) {
        operations.add(obj -> obj.setOnShown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Menu#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  MenuBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Menu#setText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  MenuBuilder text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Menu#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  MenuBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Menu#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  MenuBuilder visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.Menu#getItems()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public final MenuBuilder addItems(javafx.scene.control.MenuItem... elements) {
        operations.add(obj -> {
            obj.getItems().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.Menu#getItems()} method.
     * 
     * @return builder instance
     */     
    public final MenuBuilder addItems(java.util.Collection<? extends javafx.scene.control.MenuItem> col) {
        operations.add(obj -> {
            obj.getItems().addAll(col);
        });
        return this;
    }


    /**
     * Create an instance of the builder, then call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.Menu#getItems()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public static MenuBuilder withItems(javafx.scene.control.MenuItem... elements) {
        MenuBuilder builder = new MenuBuilder();
        return builder.addItems(elements);
    }

    /**
     * Create an instance of the builder, then call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.Menu#getItems()} method.
     * 
     * @return builder instance
     */     
    public static MenuBuilder withItems(java.util.Collection<? extends javafx.scene.control.MenuItem> col) {
        MenuBuilder builder = new MenuBuilder();
        return builder.addItems(col);
    }


    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.Menu#getStyleClass()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public final MenuBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.Menu#getStyleClass()} method.
     * 
     * @return builder instance
     */     
    public final MenuBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }


    
    /**
     * Applies a function to the {@link javafx.scene.control.Menu#acceleratorProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuBuilder acceleratorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.KeyCombination>> op) {
        operations.add(obj -> op.accept(obj.acceleratorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Menu#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Menu#graphicProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuBuilder graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Menu#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Menu#mnemonicParsingProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuBuilder mnemonicParsingPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mnemonicParsingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Menu#onActionProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuBuilder onActionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.ActionEvent>>> op) {
        operations.add(obj -> op.accept(obj.onActionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Menu#onHiddenProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuBuilder onHiddenPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.Event>>> op) {
        operations.add(obj -> op.accept(obj.onHiddenProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Menu#onHidingProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuBuilder onHidingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.Event>>> op) {
        operations.add(obj -> op.accept(obj.onHidingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Menu#onMenuValidationProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuBuilder onMenuValidationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.Event>>> op) {
        operations.add(obj -> op.accept(obj.onMenuValidationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Menu#onShowingProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuBuilder onShowingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.Event>>> op) {
        operations.add(obj -> op.accept(obj.onShowingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Menu#onShownProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuBuilder onShownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.Event>>> op) {
        operations.add(obj -> op.accept(obj.onShownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Menu#parentMenuProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuBuilder parentMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.Menu>> op) {
        operations.add(obj -> op.accept(obj.parentMenuProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Menu#parentPopupProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuBuilder parentPopupPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.parentPopupProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Menu#showingProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuBuilder showingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.showingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Menu#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Menu#textProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuBuilder textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Menu#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuBuilder visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }
}
