
package io.github.sosuisen.jfxbuilder.controls;


public class ChoiceDialogBuilder<T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.ChoiceDialog<T>>> operations = new java.util.ArrayList<>();
    private ChoiceDialogBuilder() {}
    

    public static <T> ChoiceDialogBuilder<T> create() { return new ChoiceDialogBuilder<T>(); }


    @SafeVarargs
    public static <T> ChoiceDialogBuilder<T> create(T defaultChoice, T... choices) {
        ChoiceDialogBuilder<T> builder = new ChoiceDialogBuilder<T>();
        builder.constructorArgs = new Object[]{defaultChoice, choices};
        return builder;
    }


    
    public static <T> ChoiceDialogBuilder<T> create(T defaultChoice, java.util.Collection<T> choices) {
        ChoiceDialogBuilder<T> builder = new ChoiceDialogBuilder<T>();
        builder.constructorArgs = new Object[]{defaultChoice, choices};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.control.ChoiceDialog<T> build() {
        javafx.scene.control.ChoiceDialog<T> newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.ChoiceDialog<>();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.ChoiceDialog<T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.ChoiceDialog<T> callParameterizedConstructor() {
        javafx.scene.control.ChoiceDialog<T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.ChoiceDialog.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.ChoiceDialog<T>) constructor.newInstance(constructorArgs);
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
    
    public ChoiceDialogBuilder<T> apply(java.util.function.Consumer<javafx.scene.control.ChoiceDialog<T>> func) {
        operations.add(func);
        return this;
    }    
    
    public  ChoiceDialogBuilder<T> contentText(java.lang.String contentText) {
        operations.add(obj -> obj.setContentText(contentText));
        return this;
    }    
    
    public  ChoiceDialogBuilder<T> dialogPane(javafx.scene.control.DialogPane value) {
        operations.add(obj -> obj.setDialogPane(value));
        return this;
    }    
    
    public  ChoiceDialogBuilder<T> graphic(javafx.scene.Node graphic) {
        operations.add(obj -> obj.setGraphic(graphic));
        return this;
    }    
    
    public  ChoiceDialogBuilder<T> headerText(java.lang.String headerText) {
        operations.add(obj -> obj.setHeaderText(headerText));
        return this;
    }    
    
    public  ChoiceDialogBuilder<T> height(double height) {
        operations.add(obj -> obj.setHeight(height));
        return this;
    }    
    
    public  ChoiceDialogBuilder<T> onCloseRequest(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnCloseRequest(value));
        return this;
    }    
    
    public  ChoiceDialogBuilder<T> onHidden(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnHidden(value));
        return this;
    }    
    
    public  ChoiceDialogBuilder<T> onHiding(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnHiding(value));
        return this;
    }    
    
    public  ChoiceDialogBuilder<T> onShowing(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnShowing(value));
        return this;
    }    
    
    public  ChoiceDialogBuilder<T> onShown(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnShown(value));
        return this;
    }    
    
    public  ChoiceDialogBuilder<T> resizable(boolean resizable) {
        operations.add(obj -> obj.setResizable(resizable));
        return this;
    }    
    
    public  ChoiceDialogBuilder<T> result(T value) {
        operations.add(obj -> obj.setResult(value));
        return this;
    }    
    
    public  ChoiceDialogBuilder<T> resultConverter(javafx.util.Callback<javafx.scene.control.ButtonType, T> value) {
        operations.add(obj -> obj.setResultConverter(value));
        return this;
    }    
    
    public  ChoiceDialogBuilder<T> selectedItem(T item) {
        operations.add(obj -> obj.setSelectedItem(item));
        return this;
    }    
    
    public  ChoiceDialogBuilder<T> title(java.lang.String title) {
        operations.add(obj -> obj.setTitle(title));
        return this;
    }    
    
    public  ChoiceDialogBuilder<T> width(double width) {
        operations.add(obj -> obj.setWidth(width));
        return this;
    }    
    
    public  ChoiceDialogBuilder<T> x(double x) {
        operations.add(obj -> obj.setX(x));
        return this;
    }    
    
    public  ChoiceDialogBuilder<T> y(double y) {
        operations.add(obj -> obj.setY(y));
        return this;
    }
    @SafeVarargs
    public final ChoiceDialogBuilder<T> addItems(T... elements) {
        operations.add(obj -> {
            obj.getItems().addAll(elements);
        });
        return this;
    }

    public final ChoiceDialogBuilder<T> addItems(java.util.Collection<? extends T> col) {
        operations.add(obj -> {
            obj.getItems().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public static <T> ChoiceDialogBuilder<T> withItems(T... elements) {
        ChoiceDialogBuilder<T> builder = new ChoiceDialogBuilder<T>();
        return builder.addItems(elements);
    }

    public static <T> ChoiceDialogBuilder<T> withItems(java.util.Collection<? extends T> col) {
        ChoiceDialogBuilder<T> builder = new ChoiceDialogBuilder<T>();
        return builder.addItems(col);
    }
    
    
    public ChoiceDialogBuilder<T> selectedItemPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<T>> op) {
        operations.add(obj -> op.accept(obj.selectedItemProperty()));
        return this;
    }    
    
    public ChoiceDialogBuilder<T> heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    
    public ChoiceDialogBuilder<T> widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    
    public ChoiceDialogBuilder<T> xPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    
    public ChoiceDialogBuilder<T> yPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }    
    
    public ChoiceDialogBuilder<T> graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    
    public ChoiceDialogBuilder<T> resizablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.resizableProperty()));
        return this;
    }    
    
    public ChoiceDialogBuilder<T> titlePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.titleProperty()));
        return this;
    }    
    
    public ChoiceDialogBuilder<T> resultConverterPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.ButtonType, T>>> op) {
        operations.add(obj -> op.accept(obj.resultConverterProperty()));
        return this;
    }    
    
    public ChoiceDialogBuilder<T> contentTextPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.contentTextProperty()));
        return this;
    }    
    
    public ChoiceDialogBuilder<T> showingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.showingProperty()));
        return this;
    }    
    
    public ChoiceDialogBuilder<T> onShowingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShowingProperty()));
        return this;
    }    
    
    public ChoiceDialogBuilder<T> onShownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShownProperty()));
        return this;
    }    
    
    public ChoiceDialogBuilder<T> onHidingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHidingProperty()));
        return this;
    }    
    
    public ChoiceDialogBuilder<T> onHiddenPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHiddenProperty()));
        return this;
    }    
    
    public ChoiceDialogBuilder<T> onCloseRequestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onCloseRequestProperty()));
        return this;
    }    
    
    public ChoiceDialogBuilder<T> headerTextPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.headerTextProperty()));
        return this;
    }    
    
    public ChoiceDialogBuilder<T> resultPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<T>> op) {
        operations.add(obj -> op.accept(obj.resultProperty()));
        return this;
    }    
    
    public ChoiceDialogBuilder<T> dialogPanePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.DialogPane>> op) {
        operations.add(obj -> op.accept(obj.dialogPaneProperty()));
        return this;
    }
}
