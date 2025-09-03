
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code ToggleGroupBuilder} class constructs instances of the {@link javafx.scene.control.ToggleGroup ToggleGroup} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.ToggleGroup ToggleGroup} constructor
 * and returns an instance of the {@code ToggleGroupBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.ToggleGroup ToggleGroup}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.ToggleGroup ToggleGroup} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class ToggleGroupBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.ToggleGroup>> operations = new java.util.ArrayList<>();
    private ToggleGroupBuilder() {}
    

    /**
     * Returns an instance of the {@code ToggleGroupBuilder}.
     *
     * @return an instance of the {@code ToggleGroupBuilder}.
     */
    public static ToggleGroupBuilder create() { return new ToggleGroupBuilder(); }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.ToggleGroup} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.ToggleGroup ToggleGroup} class
     */
    public javafx.scene.control.ToggleGroup build() {
        javafx.scene.control.ToggleGroup newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.ToggleGroup();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.ToggleGroup> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.ToggleGroup callParameterizedConstructor() {
        javafx.scene.control.ToggleGroup newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.ToggleGroup.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.ToggleGroup) constructor.newInstance(constructorArgs);
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
     * Applies a function to the ToggleGroup instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public ToggleGroupBuilder apply(java.util.function.Consumer<javafx.scene.control.ToggleGroup> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ToggleGroup#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  ToggleGroupBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ToggleGroup#getToggles()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final ToggleGroupBuilder addToggles(javafx.scene.control.Toggle... elements) {
        operations.add(obj -> {
            obj.getToggles().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ToggleGroup#getToggles()} method.
     * 
     * @return builder instance
     */
    public final ToggleGroupBuilder addToggles(java.util.Collection<? extends javafx.scene.control.Toggle> col) {
        operations.add(obj -> {
            obj.getToggles().addAll(col);
        });
        return this;
    }


    /**
     * Create an instance of the builder, then call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ToggleGroup#getToggles()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public static ToggleGroupBuilder withToggles(javafx.scene.control.Toggle... elements) {
        ToggleGroupBuilder builder = new ToggleGroupBuilder();
        return builder.addToggles(elements);
    }

    /**
     * Create an instance of the builder, then call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.ToggleGroup#getToggles()} method.
     * 
     * @return builder instance
     */
    public static ToggleGroupBuilder withToggles(java.util.Collection<? extends javafx.scene.control.Toggle> col) {
        ToggleGroupBuilder builder = new ToggleGroupBuilder();
        return builder.addToggles(col);
    }

    
    /**
     * Applies a function to the {@link javafx.scene.control.ToggleGroup#selectedToggleProperty() selectedToggleProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.ToggleGroup> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.selectedToggleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .selectedTogglePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public ToggleGroupBuilder selectedTogglePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.Toggle>> op) {
        operations.add(obj -> op.accept(obj.selectedToggleProperty()));
        return this;
    }
}
