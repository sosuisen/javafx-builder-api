
package io.github.sosuisen.jfxbuilder.controls;


public class TextInputDialogBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.TextInputDialog>> operations = new java.util.ArrayList<>();
    private TextInputDialogBuilder() {}
    

    public static TextInputDialogBuilder create() { return new TextInputDialogBuilder(); }


    
    public static TextInputDialogBuilder create(java.lang.String defaultValue) {
        TextInputDialogBuilder builder = new TextInputDialogBuilder();
        builder.constructorArgs = new Object[]{defaultValue};
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
     * @return new instance of the {@link javafx.scene.control.TextInputDialog TextInputDialog} class
     */
    public javafx.scene.control.TextInputDialog build() {
        javafx.scene.control.TextInputDialog newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.TextInputDialog();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.TextInputDialog> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.TextInputDialog callParameterizedConstructor() {
        javafx.scene.control.TextInputDialog newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TextInputDialog.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TextInputDialog) constructor.newInstance(constructorArgs);
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
     * Applies a function to the TextInputDialog instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TextInputDialogBuilder apply(java.util.function.Consumer<javafx.scene.control.TextInputDialog> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TextInputDialog#setContentText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TextInputDialogBuilder contentText(java.lang.String contentText) {
        operations.add(obj -> obj.setContentText(contentText));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TextInputDialog#setDialogPane(javafx.scene.control.DialogPane)}
     * 
     * @return builder instance
     */    
    
    public  TextInputDialogBuilder dialogPane(javafx.scene.control.DialogPane value) {
        operations.add(obj -> obj.setDialogPane(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TextInputDialog#setGraphic(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  TextInputDialogBuilder graphic(javafx.scene.Node graphic) {
        operations.add(obj -> obj.setGraphic(graphic));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TextInputDialog#setHeaderText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TextInputDialogBuilder headerText(java.lang.String headerText) {
        operations.add(obj -> obj.setHeaderText(headerText));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TextInputDialog#setHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  TextInputDialogBuilder height(double height) {
        operations.add(obj -> obj.setHeight(height));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TextInputDialog#setOnCloseRequest(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextInputDialogBuilder onCloseRequest(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnCloseRequest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TextInputDialog#setOnHidden(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextInputDialogBuilder onHidden(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnHidden(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TextInputDialog#setOnHiding(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextInputDialogBuilder onHiding(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnHiding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TextInputDialog#setOnShowing(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextInputDialogBuilder onShowing(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnShowing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TextInputDialog#setOnShown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TextInputDialogBuilder onShown(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnShown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TextInputDialog#setResizable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TextInputDialogBuilder resizable(boolean resizable) {
        operations.add(obj -> obj.setResizable(resizable));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TextInputDialog#setResult(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  TextInputDialogBuilder result(java.lang.String value) {
        operations.add(obj -> obj.setResult(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TextInputDialog#setResultConverter(javafx.util.Callback)}
     * 
     * @return builder instance
     */    
    
    public  TextInputDialogBuilder resultConverter(javafx.util.Callback<javafx.scene.control.ButtonType, java.lang.String> value) {
        operations.add(obj -> obj.setResultConverter(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TextInputDialog#setTitle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  TextInputDialogBuilder title(java.lang.String title) {
        operations.add(obj -> obj.setTitle(title));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TextInputDialog#setWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  TextInputDialogBuilder width(double width) {
        operations.add(obj -> obj.setWidth(width));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TextInputDialog#setX(double)}
     * 
     * @return builder instance
     */    
    
    public  TextInputDialogBuilder x(double x) {
        operations.add(obj -> obj.setX(x));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TextInputDialog#setY(double)}
     * 
     * @return builder instance
     */    
    
    public  TextInputDialogBuilder y(double y) {
        operations.add(obj -> obj.setY(y));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TextInputDialog#contentTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextInputDialogBuilder contentTextPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.contentTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TextInputDialog#dialogPaneProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextInputDialogBuilder dialogPanePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.DialogPane>> op) {
        operations.add(obj -> op.accept(obj.dialogPaneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TextInputDialog#graphicProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextInputDialogBuilder graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TextInputDialog#headerTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextInputDialogBuilder headerTextPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.headerTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TextInputDialog#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextInputDialogBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TextInputDialog#onCloseRequestProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextInputDialogBuilder onCloseRequestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onCloseRequestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TextInputDialog#onHiddenProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextInputDialogBuilder onHiddenPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHiddenProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TextInputDialog#onHidingProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextInputDialogBuilder onHidingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHidingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TextInputDialog#onShowingProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextInputDialogBuilder onShowingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShowingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TextInputDialog#onShownProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextInputDialogBuilder onShownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TextInputDialog#resizableProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextInputDialogBuilder resizablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.resizableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TextInputDialog#resultConverterProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextInputDialogBuilder resultConverterPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.ButtonType, java.lang.String>>> op) {
        operations.add(obj -> op.accept(obj.resultConverterProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TextInputDialog#resultProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextInputDialogBuilder resultPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.resultProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TextInputDialog#showingProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextInputDialogBuilder showingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.showingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TextInputDialog#titleProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextInputDialogBuilder titlePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.titleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TextInputDialog#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextInputDialogBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TextInputDialog#xProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextInputDialogBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TextInputDialog#yProperty()}.
     * 
     * @return builder instance
     */    
    
    public TextInputDialogBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
