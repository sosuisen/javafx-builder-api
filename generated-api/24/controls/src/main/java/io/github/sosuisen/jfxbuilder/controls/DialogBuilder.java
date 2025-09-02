
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code DialogBuilder} class constructs instances of the {@link javafx.scene.control.Dialog Dialog} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.Dialog Dialog} constructor
 * and returns an instance of the {@code DialogBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.Dialog Dialog}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.Dialog Dialog} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class DialogBuilder<R> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.Dialog<R>>> operations = new java.util.ArrayList<>();
    private DialogBuilder() {}
    

    /**
     * Returns an instance of the {@code <R> DialogBuilder<R>}.
     *
     * @return an instance of the {@code <R> DialogBuilder<R>}.
     */
    public static <R> DialogBuilder<R> create() { return new DialogBuilder<R>(); }

    private Object[] constructorArgs;

    /**
     * This method builds and returns an instance of the original class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the build() method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.Dialog Dialog} class
     */
    public javafx.scene.control.Dialog<R> build() {
        javafx.scene.control.Dialog<R> newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.Dialog<>();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.Dialog<R>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.Dialog<R> callParameterizedConstructor() {
        javafx.scene.control.Dialog<R> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.Dialog.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.Dialog<R>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Dialog instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public DialogBuilder<R> apply(java.util.function.Consumer<javafx.scene.control.Dialog<R>> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Dialog#setContentText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  DialogBuilder<R> contentText(java.lang.String contentText) {
        operations.add(obj -> obj.setContentText(contentText));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Dialog#setDialogPane(javafx.scene.control.DialogPane)}
     * 
     * @return builder instance
     */    
    
    public  DialogBuilder<R> dialogPane(javafx.scene.control.DialogPane value) {
        operations.add(obj -> obj.setDialogPane(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Dialog#setGraphic(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  DialogBuilder<R> graphic(javafx.scene.Node graphic) {
        operations.add(obj -> obj.setGraphic(graphic));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Dialog#setHeaderText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  DialogBuilder<R> headerText(java.lang.String headerText) {
        operations.add(obj -> obj.setHeaderText(headerText));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Dialog#setHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  DialogBuilder<R> height(double height) {
        operations.add(obj -> obj.setHeight(height));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Dialog#setOnCloseRequest(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DialogBuilder<R> onCloseRequest(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnCloseRequest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Dialog#setOnHidden(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DialogBuilder<R> onHidden(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnHidden(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Dialog#setOnHiding(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DialogBuilder<R> onHiding(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnHiding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Dialog#setOnShowing(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DialogBuilder<R> onShowing(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnShowing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Dialog#setOnShown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  DialogBuilder<R> onShown(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnShown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Dialog#setResizable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  DialogBuilder<R> resizable(boolean resizable) {
        operations.add(obj -> obj.setResizable(resizable));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Dialog#setResult(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  DialogBuilder<R> result(R value) {
        operations.add(obj -> obj.setResult(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Dialog#setResultConverter(javafx.util.Callback)}
     * 
     * @return builder instance
     */    
    
    public  DialogBuilder<R> resultConverter(javafx.util.Callback<javafx.scene.control.ButtonType, R> value) {
        operations.add(obj -> obj.setResultConverter(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Dialog#setTitle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  DialogBuilder<R> title(java.lang.String title) {
        operations.add(obj -> obj.setTitle(title));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Dialog#setWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  DialogBuilder<R> width(double width) {
        operations.add(obj -> obj.setWidth(width));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Dialog#setX(double)}
     * 
     * @return builder instance
     */    
    
    public  DialogBuilder<R> x(double x) {
        operations.add(obj -> obj.setX(x));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Dialog#setY(double)}
     * 
     * @return builder instance
     */    
    
    public  DialogBuilder<R> y(double y) {
        operations.add(obj -> obj.setY(y));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Dialog#contentTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public DialogBuilder<R> contentTextPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.contentTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Dialog#dialogPaneProperty()}.
     * 
     * @return builder instance
     */    
    
    public DialogBuilder<R> dialogPanePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.DialogPane>> op) {
        operations.add(obj -> op.accept(obj.dialogPaneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Dialog#graphicProperty()}.
     * 
     * @return builder instance
     */    
    
    public DialogBuilder<R> graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Dialog#headerTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public DialogBuilder<R> headerTextPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.headerTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Dialog#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public DialogBuilder<R> heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Dialog#onCloseRequestProperty()}.
     * 
     * @return builder instance
     */    
    
    public DialogBuilder<R> onCloseRequestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onCloseRequestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Dialog#onHiddenProperty()}.
     * 
     * @return builder instance
     */    
    
    public DialogBuilder<R> onHiddenPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHiddenProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Dialog#onHidingProperty()}.
     * 
     * @return builder instance
     */    
    
    public DialogBuilder<R> onHidingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHidingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Dialog#onShowingProperty()}.
     * 
     * @return builder instance
     */    
    
    public DialogBuilder<R> onShowingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShowingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Dialog#onShownProperty()}.
     * 
     * @return builder instance
     */    
    
    public DialogBuilder<R> onShownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Dialog#resizableProperty()}.
     * 
     * @return builder instance
     */    
    
    public DialogBuilder<R> resizablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.resizableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Dialog#resultConverterProperty()}.
     * 
     * @return builder instance
     */    
    
    public DialogBuilder<R> resultConverterPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.ButtonType, R>>> op) {
        operations.add(obj -> op.accept(obj.resultConverterProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Dialog#resultProperty()}.
     * 
     * @return builder instance
     */    
    
    public DialogBuilder<R> resultPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<R>> op) {
        operations.add(obj -> op.accept(obj.resultProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Dialog#showingProperty()}.
     * 
     * @return builder instance
     */    
    
    public DialogBuilder<R> showingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.showingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Dialog#titleProperty()}.
     * 
     * @return builder instance
     */    
    
    public DialogBuilder<R> titlePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.titleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Dialog#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public DialogBuilder<R> widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Dialog#xProperty()}.
     * 
     * @return builder instance
     */    
    
    public DialogBuilder<R> xPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Dialog#yProperty()}.
     * 
     * @return builder instance
     */    
    
    public DialogBuilder<R> yPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
