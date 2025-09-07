
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code ComboBoxListViewSkinBuilder} class constructs instances of the {@link javafx.scene.control.skin.ComboBoxListViewSkin ComboBoxListViewSkin} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.skin.ComboBoxListViewSkin ComboBoxListViewSkin} constructor
 * and returns an instance of the {@code ComboBoxListViewSkinBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.skin.ComboBoxListViewSkin ComboBoxListViewSkin}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.skin.ComboBoxListViewSkin ComboBoxListViewSkin} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class ComboBoxListViewSkinBuilder<T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.skin.ComboBoxListViewSkin<T>>> operations = new java.util.ArrayList<>();
    private ComboBoxListViewSkinBuilder() {}
    
    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.skin.ComboBoxListViewSkin#ComboBoxListViewSkin(ComboBox) ComboBoxListViewSkin(ComboBox)}
     * and returns an instance of {@code ComboBoxListViewSkinBuilder<T>}.
     *
     * @return an instance of the {@code ComboBoxListViewSkinBuilder<T>}.
     */
    
    public static <T> ComboBoxListViewSkinBuilder<T> create(javafx.scene.control.ComboBox<T> control) {
        ComboBoxListViewSkinBuilder<T> builder = new ComboBoxListViewSkinBuilder<T>();
        builder.constructorArgs = new Object[]{control};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.skin.ComboBoxListViewSkin<T>} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.skin.ComboBoxListViewSkin ComboBoxListViewSkin} class
     */
    public javafx.scene.control.skin.ComboBoxListViewSkin<T> build() {
        javafx.scene.control.skin.ComboBoxListViewSkin<T> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.skin.ComboBoxListViewSkin<T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.skin.ComboBoxListViewSkin<T> callParameterizedConstructor() {
        javafx.scene.control.skin.ComboBoxListViewSkin<T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.skin.ComboBoxListViewSkin.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.skin.ComboBoxListViewSkin<T>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the ComboBoxListViewSkin instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public ComboBoxListViewSkinBuilder<T> apply(java.util.function.Consumer<javafx.scene.control.skin.ComboBoxListViewSkin<T>> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.control.skin.ComboBoxListViewSkin#setHideOnClick(boolean) setHideOnClick} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  ComboBoxListViewSkinBuilder<T> hideOnClick(boolean value) {
        operations.add(obj -> obj.setHideOnClick(value));
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.skin.ComboBoxListViewSkin#getChildren()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final ComboBoxListViewSkinBuilder<T> addChildren(javafx.scene.Node... elements) {
        operations.add(obj -> {
            obj.getChildren().addAll(elements);
        });
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.skin.ComboBoxListViewSkin#getChildren()} method.
     * 
     * @return builder instance
     */
    public final ComboBoxListViewSkinBuilder<T> addChildren(java.util.Collection<? extends javafx.scene.Node> col) {
        operations.add(obj -> {
            obj.getChildren().addAll(col);
        });
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.skin.ComboBoxListViewSkin#hideOnClickProperty() hideOnClickProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.control.skin.ComboBoxListViewSkin<T>> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.hideOnClickProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .hideOnClickPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public ComboBoxListViewSkinBuilder<T> hideOnClickPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hideOnClickProperty()));
        return this;
    }
}
