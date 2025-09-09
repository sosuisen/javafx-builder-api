
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code ChoiceDialogBuilder} class constructs instances of the {@link javafx.scene.control.ChoiceDialog ChoiceDialog} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.ChoiceDialog ChoiceDialog} constructor
 * and returns an instance of the {@code ChoiceDialogBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.ChoiceDialog ChoiceDialog}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.ChoiceDialog ChoiceDialog} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class ChoiceDialogBuilder<T> {
    private final java.util.List<java.util.function.Consumer<javafx.scene.control.ChoiceDialog<T>>> operations = new java.util.ArrayList<>();
    private ChoiceDialogBuilder() {}
    
    /**
     * Returns an instance of the {@code ChoiceDialogBuilder<T>}.
     *
     * @return an instance of the {@code ChoiceDialogBuilder<T>}.
     */
    public static <T> ChoiceDialogBuilder<T> create() { return new ChoiceDialogBuilder<T>(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.ChoiceDialog#ChoiceDialog(T, T...) ChoiceDialog(T, T...)}
     * and returns an instance of {@code ChoiceDialogBuilder<T>}.
     *
     * @return an instance of the {@code ChoiceDialogBuilder<T>}.
     */
    @SafeVarargs
    public static <T> ChoiceDialogBuilder<T> create(T defaultChoice, T... choices) {
        ChoiceDialogBuilder<T> builder = new ChoiceDialogBuilder<T>();
        builder.constructorArgs = new Object[]{defaultChoice, choices};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.ChoiceDialog#ChoiceDialog(T, java.util.Collection) ChoiceDialog(T, Collection)}
     * and returns an instance of {@code ChoiceDialogBuilder<T>}.
     *
     * @return an instance of the {@code ChoiceDialogBuilder<T>}.
     */
    public static <T> ChoiceDialogBuilder<T> create(T defaultChoice, java.util.Collection<T> choices) {
        ChoiceDialogBuilder<T> builder = new ChoiceDialogBuilder<T>();
        builder.constructorArgs = new Object[]{defaultChoice, choices};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.ChoiceDialog} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.ChoiceDialog ChoiceDialog} class
     */
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

    /**
     * Applies a function to the ChoiceDialog instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public ChoiceDialogBuilder<T> apply(java.util.function.Consumer<javafx.scene.control.ChoiceDialog<T>> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Dialog#setContentText(java.lang.String) setContentText} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ChoiceDialogBuilder<T> contentText(java.lang.String contentText) {
        operations.add(obj -> obj.setContentText(contentText));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Dialog#setDialogPane(javafx.scene.control.DialogPane) setDialogPane} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ChoiceDialogBuilder<T> dialogPane(javafx.scene.control.DialogPane value) {
        operations.add(obj -> obj.setDialogPane(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Dialog#setGraphic(javafx.scene.Node) setGraphic} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ChoiceDialogBuilder<T> graphic(javafx.scene.Node graphic) {
        operations.add(obj -> obj.setGraphic(graphic));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Dialog#setHeaderText(java.lang.String) setHeaderText} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ChoiceDialogBuilder<T> headerText(java.lang.String headerText) {
        operations.add(obj -> obj.setHeaderText(headerText));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Dialog#setHeight(double) setHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ChoiceDialogBuilder<T> height(double height) {
        operations.add(obj -> obj.setHeight(height));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Dialog#setOnCloseRequest(javafx.event.EventHandler) setOnCloseRequest} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ChoiceDialogBuilder<T> onCloseRequest(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnCloseRequest(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Dialog#setOnHidden(javafx.event.EventHandler) setOnHidden} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ChoiceDialogBuilder<T> onHidden(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnHidden(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Dialog#setOnHiding(javafx.event.EventHandler) setOnHiding} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ChoiceDialogBuilder<T> onHiding(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnHiding(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Dialog#setOnShowing(javafx.event.EventHandler) setOnShowing} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ChoiceDialogBuilder<T> onShowing(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnShowing(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Dialog#setOnShown(javafx.event.EventHandler) setOnShown} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ChoiceDialogBuilder<T> onShown(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnShown(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Dialog#setResizable(boolean) setResizable} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ChoiceDialogBuilder<T> resizable(boolean resizable) {
        operations.add(obj -> obj.setResizable(resizable));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Dialog#setResult(R) setResult} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ChoiceDialogBuilder<T> result(T value) {
        operations.add(obj -> obj.setResult(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Dialog#setResultConverter(javafx.util.Callback) setResultConverter} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ChoiceDialogBuilder<T> resultConverter(javafx.util.Callback<javafx.scene.control.ButtonType, T> value) {
        operations.add(obj -> obj.setResultConverter(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.ChoiceDialog#setSelectedItem(T) setSelectedItem} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ChoiceDialogBuilder<T> selectedItem(T item) {
        operations.add(obj -> obj.setSelectedItem(item));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Dialog#setTitle(java.lang.String) setTitle} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ChoiceDialogBuilder<T> title(java.lang.String title) {
        operations.add(obj -> obj.setTitle(title));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Dialog#setWidth(double) setWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ChoiceDialogBuilder<T> width(double width) {
        operations.add(obj -> obj.setWidth(width));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Dialog#setX(double) setX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ChoiceDialogBuilder<T> x(double x) {
        operations.add(obj -> obj.setX(x));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.Dialog#setY(double) setY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ChoiceDialogBuilder<T> y(double y) {
        operations.add(obj -> obj.setY(y));
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(java.lang.Object[]) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ChoiceDialog#getItems()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final ChoiceDialogBuilder<T> addItems(T... elements) {
        operations.add(obj -> obj.getItems().addAll(elements));
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(java.util.Collection) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ChoiceDialog#getItems()} method.
     * 
     * @return builder instance
     */
    public final ChoiceDialogBuilder<T> addItems(java.util.Collection<? extends T> col) {
        operations.add(obj -> obj.getItems().addAll(col));
        return this;
    }

    /**
     * Creates an instance of the builder, then calls the {@link javafx.collections.ObservableList#addAll(java.lang.Object[]) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ChoiceDialog#getItems()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public static <T> ChoiceDialogBuilder<T> withItems(T... elements) {
        ChoiceDialogBuilder<T> builder = new ChoiceDialogBuilder<T>();
        return builder.addItems(elements);
    }

    /**
     * Creates an instance of the builder, then calls the {@link java.util.List#addAll(java.util.Collection) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ChoiceDialog#getItems()} method.
     * 
     * @return builder instance
     */
    public static <T> ChoiceDialogBuilder<T> withItems(java.util.Collection<? extends T> col) {
        ChoiceDialogBuilder<T> builder = new ChoiceDialogBuilder<T>();
        return builder.addItems(col);
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ChoiceDialog#contentTextProperty() contentTextProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ChoiceDialogBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.contentTextProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .contentTextPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ChoiceDialogBuilder<T> contentTextPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.contentTextProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ChoiceDialog#dialogPaneProperty() dialogPaneProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ChoiceDialogBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.dialogPaneProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .dialogPanePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ChoiceDialogBuilder<T> dialogPanePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.DialogPane>> op) {
        operations.add(obj -> op.accept(obj.dialogPaneProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ChoiceDialog#graphicProperty() graphicProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ChoiceDialogBuilder#apply(java.util.function.Consumer) apply} method.
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
    public ChoiceDialogBuilder<T> graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ChoiceDialog#headerTextProperty() headerTextProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ChoiceDialogBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.headerTextProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .headerTextPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ChoiceDialogBuilder<T> headerTextPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.headerTextProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ChoiceDialog#heightProperty() heightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ChoiceDialogBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.heightProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .heightPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ChoiceDialogBuilder<T> heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ChoiceDialog#onCloseRequestProperty() onCloseRequestProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ChoiceDialogBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onCloseRequestProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onCloseRequestPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ChoiceDialogBuilder<T> onCloseRequestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onCloseRequestProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ChoiceDialog#onHiddenProperty() onHiddenProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ChoiceDialogBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onHiddenProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onHiddenPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ChoiceDialogBuilder<T> onHiddenPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHiddenProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ChoiceDialog#onHidingProperty() onHidingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ChoiceDialogBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onHidingProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onHidingPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ChoiceDialogBuilder<T> onHidingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHidingProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ChoiceDialog#onShowingProperty() onShowingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ChoiceDialogBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onShowingProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onShowingPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ChoiceDialogBuilder<T> onShowingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShowingProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ChoiceDialog#onShownProperty() onShownProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ChoiceDialogBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onShownProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onShownPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ChoiceDialogBuilder<T> onShownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShownProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ChoiceDialog#resizableProperty() resizableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ChoiceDialogBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.resizableProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .resizablePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ChoiceDialogBuilder<T> resizablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.resizableProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ChoiceDialog#resultConverterProperty() resultConverterProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ChoiceDialogBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.resultConverterProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .resultConverterPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ChoiceDialogBuilder<T> resultConverterPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.ButtonType, T>>> op) {
        operations.add(obj -> op.accept(obj.resultConverterProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ChoiceDialog#resultProperty() resultProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ChoiceDialogBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.resultProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .resultPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ChoiceDialogBuilder<T> resultPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<T>> op) {
        operations.add(obj -> op.accept(obj.resultProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ChoiceDialog#selectedItemProperty() selectedItemProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ChoiceDialogBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.selectedItemProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .selectedItemPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ChoiceDialogBuilder<T> selectedItemPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<T>> op) {
        operations.add(obj -> op.accept(obj.selectedItemProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ChoiceDialog#showingProperty() showingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ChoiceDialogBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.showingProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .showingPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ChoiceDialogBuilder<T> showingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.showingProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ChoiceDialog#titleProperty() titleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ChoiceDialogBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.titleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .titlePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ChoiceDialogBuilder<T> titlePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.titleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ChoiceDialog#widthProperty() widthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ChoiceDialogBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.widthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .widthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ChoiceDialogBuilder<T> widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ChoiceDialog#xProperty() xProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ChoiceDialogBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.xProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .xPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ChoiceDialogBuilder<T> xPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.ChoiceDialog#yProperty() yProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ChoiceDialogBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.yProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .yPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ChoiceDialogBuilder<T> yPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
