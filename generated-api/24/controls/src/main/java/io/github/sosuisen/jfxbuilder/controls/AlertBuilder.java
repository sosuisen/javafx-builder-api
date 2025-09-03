
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code AlertBuilder} class constructs instances of the {@link javafx.scene.control.Alert Alert} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.Alert Alert} constructor
 * and returns an instance of the {@code AlertBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.Alert Alert}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.Alert Alert} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class AlertBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.Alert>> operations = new java.util.ArrayList<>();
    private AlertBuilder() {}
    

    /**
     * Accepts the same arguments as {@link javafx.scene.control.Alert#Alert(javafx.scene.control.Alert.AlertType alertType) Alert(Alert$AlertType)}
     * and returns an instance of the {@code AlertBuilder}.
     *
     * @return an instance of the {@code AlertBuilder}.
     */
    
    public static AlertBuilder create(javafx.scene.control.Alert.AlertType alertType) {
        AlertBuilder builder = new AlertBuilder();
        builder.constructorArgs = new Object[]{alertType};
        return builder;
    }


    /**
     * Accepts the same arguments as {@link javafx.scene.control.Alert#Alert(javafx.scene.control.Alert.AlertType alertType, java.lang.String contentText, javafx.scene.control.ButtonType... buttons) Alert(Alert$AlertType, String, ButtonType...)}
     * and returns an instance of the {@code AlertBuilder}.
     *
     * @return an instance of the {@code AlertBuilder}.
     */
    @SafeVarargs
    public static AlertBuilder create(javafx.scene.control.Alert.AlertType alertType, java.lang.String contentText, javafx.scene.control.ButtonType... buttons) {
        AlertBuilder builder = new AlertBuilder();
        builder.constructorArgs = new Object[]{alertType, contentText, buttons};
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
     * @return new instance of the {@link javafx.scene.control.Alert Alert} class
     */
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
    /**
     * Applies a function to the Alert instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public AlertBuilder apply(java.util.function.Consumer<javafx.scene.control.Alert> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Alert#setAlertType(javafx.scene.control.Alert$AlertType)}
     * 
     * @return builder instance
     */    
    
    public  AlertBuilder alertType(javafx.scene.control.Alert.AlertType alertType) {
        operations.add(obj -> obj.setAlertType(alertType));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Alert#setContentText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  AlertBuilder contentText(java.lang.String contentText) {
        operations.add(obj -> obj.setContentText(contentText));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Alert#setDialogPane(javafx.scene.control.DialogPane)}
     * 
     * @return builder instance
     */    
    
    public  AlertBuilder dialogPane(javafx.scene.control.DialogPane value) {
        operations.add(obj -> obj.setDialogPane(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Alert#setGraphic(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  AlertBuilder graphic(javafx.scene.Node graphic) {
        operations.add(obj -> obj.setGraphic(graphic));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Alert#setHeaderText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  AlertBuilder headerText(java.lang.String headerText) {
        operations.add(obj -> obj.setHeaderText(headerText));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Alert#setHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  AlertBuilder height(double height) {
        operations.add(obj -> obj.setHeight(height));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Alert#setOnCloseRequest(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AlertBuilder onCloseRequest(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnCloseRequest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Alert#setOnHidden(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AlertBuilder onHidden(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnHidden(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Alert#setOnHiding(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AlertBuilder onHiding(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnHiding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Alert#setOnShowing(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AlertBuilder onShowing(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnShowing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Alert#setOnShown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AlertBuilder onShown(javafx.event.EventHandler<javafx.scene.control.DialogEvent> value) {
        operations.add(obj -> obj.setOnShown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Alert#setResizable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AlertBuilder resizable(boolean resizable) {
        operations.add(obj -> obj.setResizable(resizable));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Alert#setResult(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  AlertBuilder result(javafx.scene.control.ButtonType value) {
        operations.add(obj -> obj.setResult(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Alert#setResultConverter(javafx.util.Callback)}
     * 
     * @return builder instance
     */    
    
    public  AlertBuilder resultConverter(javafx.util.Callback<javafx.scene.control.ButtonType, javafx.scene.control.ButtonType> value) {
        operations.add(obj -> obj.setResultConverter(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Alert#setTitle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  AlertBuilder title(java.lang.String title) {
        operations.add(obj -> obj.setTitle(title));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Alert#setWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  AlertBuilder width(double width) {
        operations.add(obj -> obj.setWidth(width));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Alert#setX(double)}
     * 
     * @return builder instance
     */    
    
    public  AlertBuilder x(double x) {
        operations.add(obj -> obj.setX(x));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.Alert#setY(double)}
     * 
     * @return builder instance
     */    
    
    public  AlertBuilder y(double y) {
        operations.add(obj -> obj.setY(y));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.Alert#getButtonTypes()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final AlertBuilder addButtonTypes(javafx.scene.control.ButtonType... elements) {
        operations.add(obj -> {
            obj.getButtonTypes().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.Alert#getButtonTypes()} method.
     * 
     * @return builder instance
     */
    public final AlertBuilder addButtonTypes(java.util.Collection<? extends javafx.scene.control.ButtonType> col) {
        operations.add(obj -> {
            obj.getButtonTypes().addAll(col);
        });
        return this;
    }


    
    /**
     * Applies a function to the {@link javafx.scene.control.Alert#alertTypeProperty() alertTypeProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.Alert> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.alertTypeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .alertTypePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public AlertBuilder alertTypePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Alert.AlertType>> op) {
        operations.add(obj -> op.accept(obj.alertTypeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Alert#contentTextProperty() contentTextProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.Alert> func) apply} method.
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
    
    public AlertBuilder contentTextPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.contentTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Alert#dialogPaneProperty() dialogPaneProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.Alert> func) apply} method.
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
    
    public AlertBuilder dialogPanePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.DialogPane>> op) {
        operations.add(obj -> op.accept(obj.dialogPaneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Alert#graphicProperty() graphicProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.Alert> func) apply} method.
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
    
    public AlertBuilder graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Alert#headerTextProperty() headerTextProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.Alert> func) apply} method.
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
    
    public AlertBuilder headerTextPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.headerTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Alert#heightProperty() heightProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.Alert> func) apply} method.
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
    
    public AlertBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Alert#onCloseRequestProperty() onCloseRequestProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.Alert> func) apply} method.
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
    
    public AlertBuilder onCloseRequestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onCloseRequestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Alert#onHiddenProperty() onHiddenProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.Alert> func) apply} method.
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
    
    public AlertBuilder onHiddenPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHiddenProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Alert#onHidingProperty() onHidingProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.Alert> func) apply} method.
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
    
    public AlertBuilder onHidingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHidingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Alert#onShowingProperty() onShowingProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.Alert> func) apply} method.
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
    
    public AlertBuilder onShowingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShowingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Alert#onShownProperty() onShownProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.Alert> func) apply} method.
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
    
    public AlertBuilder onShownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.control.DialogEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Alert#resizableProperty() resizableProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.Alert> func) apply} method.
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
    
    public AlertBuilder resizablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.resizableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Alert#resultConverterProperty() resultConverterProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.Alert> func) apply} method.
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
    
    public AlertBuilder resultConverterPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.ButtonType, javafx.scene.control.ButtonType>>> op) {
        operations.add(obj -> op.accept(obj.resultConverterProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Alert#resultProperty() resultProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.Alert> func) apply} method.
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
    
    public AlertBuilder resultPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ButtonType>> op) {
        operations.add(obj -> op.accept(obj.resultProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Alert#showingProperty() showingProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.Alert> func) apply} method.
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
    
    public AlertBuilder showingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.showingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Alert#titleProperty() titleProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.Alert> func) apply} method.
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
    
    public AlertBuilder titlePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.titleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Alert#widthProperty() widthProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.Alert> func) apply} method.
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
    
    public AlertBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Alert#xProperty() xProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.Alert> func) apply} method.
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
    
    public AlertBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.Alert#yProperty() yProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.Alert> func) apply} method.
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
    
    public AlertBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
