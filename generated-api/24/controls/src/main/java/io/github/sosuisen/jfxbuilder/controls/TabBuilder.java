
package io.github.sosuisen.jfxbuilder.controls;


public class TabBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.Tab>> operations = new java.util.ArrayList<>();
    private TabBuilder() {}
    

    public static TabBuilder create() { return new TabBuilder(); }


    
    public static TabBuilder create(java.lang.String text) {
        TabBuilder builder = new TabBuilder();
        builder.constructorArgs = new Object[]{text};
        return builder;
    }


    
    public static TabBuilder create(java.lang.String text, javafx.scene.Node content) {
        TabBuilder builder = new TabBuilder();
        builder.constructorArgs = new Object[]{text, content};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.control.Tab build() {
        javafx.scene.control.Tab newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.Tab();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.Tab> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.Tab callParameterizedConstructor() {
        javafx.scene.control.Tab newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.Tab.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.Tab) constructor.newInstance(constructorArgs);
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
    
    public TabBuilder apply(java.util.function.Consumer<javafx.scene.control.Tab> func) {
        operations.add(func);
        return this;
    }    
    
    public  TabBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }    
    
    public  TabBuilder onCloseRequest(javafx.event.EventHandler<javafx.event.Event> value) {
        operations.add(obj -> obj.setOnCloseRequest(value));
        return this;
    }    
    
    public  TabBuilder text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }    
    
    public  TabBuilder graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }    
    
    public  TabBuilder id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }    
    
    public  TabBuilder disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }    
    
    public  TabBuilder style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }    
    
    public  TabBuilder contextMenu(javafx.scene.control.ContextMenu value) {
        operations.add(obj -> obj.setContextMenu(value));
        return this;
    }    
    
    public  TabBuilder content(javafx.scene.Node value) {
        operations.add(obj -> obj.setContent(value));
        return this;
    }    
    
    public  TabBuilder closable(boolean value) {
        operations.add(obj -> obj.setClosable(value));
        return this;
    }    
    
    public  TabBuilder tooltip(javafx.scene.control.Tooltip value) {
        operations.add(obj -> obj.setTooltip(value));
        return this;
    }    
    
    public  TabBuilder onSelectionChanged(javafx.event.EventHandler<javafx.event.Event> value) {
        operations.add(obj -> obj.setOnSelectionChanged(value));
        return this;
    }    
    
    public  TabBuilder onClosed(javafx.event.EventHandler<javafx.event.Event> value) {
        operations.add(obj -> obj.setOnClosed(value));
        return this;
    }
    @SafeVarargs
    public final TabBuilder addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    public final TabBuilder addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }

    
    
    public TabBuilder graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    
    public TabBuilder textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }    
    
    public TabBuilder selectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.selectedProperty()));
        return this;
    }    
    
    public TabBuilder disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    
    public TabBuilder idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    
    public TabBuilder onCloseRequestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.Event>>> op) {
        operations.add(obj -> op.accept(obj.onCloseRequestProperty()));
        return this;
    }    
    
    public TabBuilder tooltipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Tooltip>> op) {
        operations.add(obj -> op.accept(obj.tooltipProperty()));
        return this;
    }    
    
    public TabBuilder stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    
    public TabBuilder disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    
    public TabBuilder contextMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.contextMenuProperty()));
        return this;
    }    
    
    public TabBuilder onClosedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.Event>>> op) {
        operations.add(obj -> op.accept(obj.onClosedProperty()));
        return this;
    }    
    
    public TabBuilder tabPanePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TabPane>> op) {
        operations.add(obj -> op.accept(obj.tabPaneProperty()));
        return this;
    }    
    
    public TabBuilder closablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.closableProperty()));
        return this;
    }    
    
    public TabBuilder contentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.contentProperty()));
        return this;
    }    
    
    public TabBuilder onSelectionChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.event.Event>>> op) {
        operations.add(obj -> op.accept(obj.onSelectionChangedProperty()));
        return this;
    }
}
