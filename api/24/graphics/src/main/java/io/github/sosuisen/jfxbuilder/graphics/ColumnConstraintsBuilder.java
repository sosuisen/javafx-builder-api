
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code ColumnConstraintsBuilder} class constructs instances of the {@link javafx.scene.layout.ColumnConstraints ColumnConstraints} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.layout.ColumnConstraints ColumnConstraints} constructor
 * and returns an instance of the {@code ColumnConstraintsBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.layout.ColumnConstraints ColumnConstraints}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.layout.ColumnConstraints ColumnConstraints} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class ColumnConstraintsBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.layout.ColumnConstraints>> operations = new java.util.ArrayList<>();
    private ColumnConstraintsBuilder() {}
    
    /**
     * Returns an instance of the {@code ColumnConstraintsBuilder}.
     *
     * @return an instance of the {@code ColumnConstraintsBuilder}.
     */
    public static ColumnConstraintsBuilder create() { return new ColumnConstraintsBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.layout.ColumnConstraints#ColumnConstraints(double) ColumnConstraints(double)}
     * and returns an instance of {@code ColumnConstraintsBuilder}.
     *
     * @return an instance of the {@code ColumnConstraintsBuilder}.
     */
    
    public static ColumnConstraintsBuilder create(double width) {
        ColumnConstraintsBuilder builder = new ColumnConstraintsBuilder();
        builder.constructorArgs = new Object[]{width};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.layout.ColumnConstraints#ColumnConstraints(double, double, double) ColumnConstraints(double, double, double)}
     * and returns an instance of {@code ColumnConstraintsBuilder}.
     *
     * @return an instance of the {@code ColumnConstraintsBuilder}.
     */
    
    public static ColumnConstraintsBuilder create(double minWidth, double prefWidth, double maxWidth) {
        ColumnConstraintsBuilder builder = new ColumnConstraintsBuilder();
        builder.constructorArgs = new Object[]{minWidth, prefWidth, maxWidth};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.layout.ColumnConstraints#ColumnConstraints(double, double, double, Priority, HPos, boolean) ColumnConstraints(double, double, double, Priority, HPos, boolean)}
     * and returns an instance of {@code ColumnConstraintsBuilder}.
     *
     * @return an instance of the {@code ColumnConstraintsBuilder}.
     */
    
    public static ColumnConstraintsBuilder create(double minWidth, double prefWidth, double maxWidth, javafx.scene.layout.Priority hgrow, javafx.geometry.HPos halignment, boolean fillWidth) {
        ColumnConstraintsBuilder builder = new ColumnConstraintsBuilder();
        builder.constructorArgs = new Object[]{minWidth, prefWidth, maxWidth, hgrow, halignment, fillWidth};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.layout.ColumnConstraints} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.layout.ColumnConstraints ColumnConstraints} class
     */
    public javafx.scene.layout.ColumnConstraints build() {
        javafx.scene.layout.ColumnConstraints newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.layout.ColumnConstraints();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.layout.ColumnConstraints> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.layout.ColumnConstraints callParameterizedConstructor() {
        javafx.scene.layout.ColumnConstraints newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.layout.ColumnConstraints.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.layout.ColumnConstraints) constructor.newInstance(constructorArgs);
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
     * Applies a function to the ColumnConstraints instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public ColumnConstraintsBuilder apply(java.util.function.Consumer<javafx.scene.layout.ColumnConstraints> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.ColumnConstraints#setFillWidth(boolean) setFillWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ColumnConstraintsBuilder fillWidth(boolean value) {
        operations.add(obj -> obj.setFillWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.ColumnConstraints#setHalignment(javafx.geometry.HPos) setHalignment} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ColumnConstraintsBuilder halignment(javafx.geometry.HPos value) {
        operations.add(obj -> obj.setHalignment(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.ColumnConstraints#setHgrow(javafx.scene.layout.Priority) setHgrow} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ColumnConstraintsBuilder hgrow(javafx.scene.layout.Priority value) {
        operations.add(obj -> obj.setHgrow(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.ColumnConstraints#setMaxWidth(double) setMaxWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ColumnConstraintsBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.ColumnConstraints#setMinWidth(double) setMinWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ColumnConstraintsBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.ColumnConstraints#setPercentWidth(double) setPercentWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ColumnConstraintsBuilder percentWidth(double value) {
        operations.add(obj -> obj.setPercentWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.ColumnConstraints#setPrefWidth(double) setPrefWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ColumnConstraintsBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.ColumnConstraints#fillWidthProperty() fillWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ColumnConstraintsBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.fillWidthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .fillWidthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ColumnConstraintsBuilder fillWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.fillWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.ColumnConstraints#halignmentProperty() halignmentProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ColumnConstraintsBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.halignmentProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .halignmentPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ColumnConstraintsBuilder halignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.HPos>> op) {
        operations.add(obj -> op.accept(obj.halignmentProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.ColumnConstraints#hgrowProperty() hgrowProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ColumnConstraintsBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.hgrowProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .hgrowPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ColumnConstraintsBuilder hgrowPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Priority>> op) {
        operations.add(obj -> op.accept(obj.hgrowProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.ColumnConstraints#maxWidthProperty() maxWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ColumnConstraintsBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.maxWidthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .maxWidthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ColumnConstraintsBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.ColumnConstraints#minWidthProperty() minWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ColumnConstraintsBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.minWidthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .minWidthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ColumnConstraintsBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.ColumnConstraints#percentWidthProperty() percentWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ColumnConstraintsBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.percentWidthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .percentWidthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ColumnConstraintsBuilder percentWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.percentWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.layout.ColumnConstraints#prefWidthProperty() prefWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ColumnConstraintsBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.prefWidthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .prefWidthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ColumnConstraintsBuilder prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }
}
