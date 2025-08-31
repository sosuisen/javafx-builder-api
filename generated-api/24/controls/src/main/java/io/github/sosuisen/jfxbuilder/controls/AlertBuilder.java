
package io.github.sosuisen.jfxbuilder.controls;


public class AlertBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.Alert>> operations = new java.util.ArrayList<>();
    private AlertBuilder() {}
    

    
    public static AlertBuilder create(javafx.scene.control.Alert.AlertType alertType) {
        AlertBuilder builder = new AlertBuilder();
        builder.constructorArgs = new Object[]{alertType};
        return builder;
    }


    @SafeVarargs
    public static AlertBuilder create(javafx.scene.control.Alert.AlertType alertType, java.lang.String contentText, javafx.scene.control.ButtonType... buttons) {
        AlertBuilder builder = new AlertBuilder();
        builder.constructorArgs = new Object[]{alertType, contentText, buttons};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.control.Alert build() {
        javafx.scene.control.Alert newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.Alert> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.Alert callParameterizedConstructor() {
        javafx.scene.control.Alert newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.Alert.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.Alert) constructor.newInstance(constructorArgs);
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
    
    public AlertBuilder apply(java.util.function.Consumer<javafx.scene.control.Alert> func) {
        operations.add(func);
        return this;
    }    
    
    public  AlertBuilder alertType(javafx.scene.control.Alert.AlertType alertType) {
        operations.add(obj -> obj.setAlertType(alertType));
        return this;
    }    
    
    public  AlertBuilder x(double x) {
        operations.add(obj -> obj.setX(x));
        return this;
    }    
    
    public  AlertBuilder y(double y) {
        operations.add(obj -> obj.setY(y));
        return this;
    }    
    
    public  AlertBuilder title(java.lang.String title) {
        operations.add(obj -> obj.setTitle(title));
        return this;
    }    
    
    public  AlertBuilder result(javafx.scene.control.ButtonType value) {
        operations.add(obj -> obj.setResult(value));
        return this;
    }    
    
    public  AlertBuilder resizable(boolean resizable) {
        operations.add(obj -> obj.setResizable(resizable));
        return this;
    }    
    
    public  AlertBuilder onCloseRequest(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnCloseRequest(value));
        return this;
    }    
    
    public  AlertBuilder graphic(javafx.scene.Node graphic) {
        operations.add(obj -> obj.setGraphic(graphic));
        return this;
    }    
    
    public  AlertBuilder width(double width) {
        operations.add(obj -> obj.setWidth(width));
        return this;
    }    
    
    public  AlertBuilder onShown(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnShown(value));
        return this;
    }    
    
    public  AlertBuilder height(double height) {
        operations.add(obj -> obj.setHeight(height));
        return this;
    }    
    
    public  AlertBuilder dialogPane(javafx.scene.control.DialogPane value) {
        operations.add(obj -> obj.setDialogPane(value));
        return this;
    }    
    
    public  AlertBuilder contentText(java.lang.String contentText) {
        operations.add(obj -> obj.setContentText(contentText));
        return this;
    }    
    
    public  AlertBuilder headerText(java.lang.String headerText) {
        operations.add(obj -> obj.setHeaderText(headerText));
        return this;
    }    
    
    public  AlertBuilder resultConverter(javafx.util.Callback<javafx.scene.control.ButtonType, javafx.scene.control.ButtonType> value) {
        operations.add(obj -> obj.setResultConverter(value));
        return this;
    }    
    
    public  AlertBuilder onHidden(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnHidden(value));
        return this;
    }    
    
    public  AlertBuilder onHiding(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnHiding(value));
        return this;
    }    
    
    public  AlertBuilder onShowing(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnShowing(value));
        return this;
    }
    @SafeVarargs
    public final AlertBuilder addButtonTypes(javafx.scene.control.ButtonType... elements) {
        operations.add(obj -> {
            obj.getButtonTypes().addAll(elements);
        });
        return this;
    }

    public final AlertBuilder addButtonTypes(java.util.Collection<? extends javafx.scene.control.ButtonType> col) {
        operations.add(obj -> {
            obj.getButtonTypes().addAll(col);
        });
        return this;
    }

    
    
    public AlertBuilder alertTypePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Alert.AlertType>> op) {
        operations.add(obj -> op.accept(obj.alertTypeProperty()));
        return this;
    }    
    
    public AlertBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    
    public AlertBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }    
    
    public AlertBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    
    public AlertBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    
    public AlertBuilder graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    
    public AlertBuilder resizablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.resizableProperty()));
        return this;
    }    
    
    public AlertBuilder titlePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.titleProperty()));
        return this;
    }    
    
    public AlertBuilder onShowingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShowingProperty()));
        return this;
    }    
    
    public AlertBuilder onCloseRequestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onCloseRequestProperty()));
        return this;
    }    
    
    public AlertBuilder dialogPanePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.DialogPane>> op) {
        operations.add(obj -> op.accept(obj.dialogPaneProperty()));
        return this;
    }    
    
    public AlertBuilder headerTextPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.headerTextProperty()));
        return this;
    }    
    
    public AlertBuilder resultPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ButtonType>> op) {
        operations.add(obj -> op.accept(obj.resultProperty()));
        return this;
    }    
    
    public AlertBuilder showingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.showingProperty()));
        return this;
    }    
    
    public AlertBuilder resultConverterPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.ButtonType, javafx.scene.control.ButtonType>>> op) {
        operations.add(obj -> op.accept(obj.resultConverterProperty()));
        return this;
    }    
    
    public AlertBuilder contentTextPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.contentTextProperty()));
        return this;
    }    
    
    public AlertBuilder onHiddenPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHiddenProperty()));
        return this;
    }    
    
    public AlertBuilder onShownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShownProperty()));
        return this;
    }    
    
    public AlertBuilder onHidingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHidingProperty()));
        return this;
    }
}
