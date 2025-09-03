
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code MenuButtonSkinBaseBuilder} class constructs instances of the {@link javafx.scene.control.skin.MenuButtonSkinBase MenuButtonSkinBase} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.skin.MenuButtonSkinBase MenuButtonSkinBase} constructor
 * and returns an instance of the {@code MenuButtonSkinBaseBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.skin.MenuButtonSkinBase MenuButtonSkinBase}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.skin.MenuButtonSkinBase MenuButtonSkinBase} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class MenuButtonSkinBaseBuilder<C extends javafx.scene.control.MenuButton> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.skin.MenuButtonSkinBase<C>>> operations = new java.util.ArrayList<>();
    private MenuButtonSkinBaseBuilder() {}
    

    /**
     * Accepts the same arguments as {@link javafx.scene.control.skin.MenuButtonSkinBase#MenuButtonSkinBase(C control) MenuButtonSkinBase(MenuButton)}
     * and returns an instance of the {@code <C extends javafx.scene.control.MenuButton> MenuButtonSkinBaseBuilder<C>}.
     *
     * @return an instance of the {@code <C extends javafx.scene.control.MenuButton> MenuButtonSkinBaseBuilder<C>}.
     */
    
    public static <C extends javafx.scene.control.MenuButton> MenuButtonSkinBaseBuilder<C> create(C control) {
        MenuButtonSkinBaseBuilder<C> builder = new MenuButtonSkinBaseBuilder<C>();
        builder.constructorArgs = new Object[]{control};
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
     * @return new instance of the {@link javafx.scene.control.skin.MenuButtonSkinBase MenuButtonSkinBase} class
     */
    public javafx.scene.control.skin.MenuButtonSkinBase<C> build() {
        javafx.scene.control.skin.MenuButtonSkinBase<C> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.skin.MenuButtonSkinBase<C>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.skin.MenuButtonSkinBase<C> callParameterizedConstructor() {
        javafx.scene.control.skin.MenuButtonSkinBase<C> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.skin.MenuButtonSkinBase.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.skin.MenuButtonSkinBase<C>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the MenuButtonSkinBase instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public MenuButtonSkinBaseBuilder<C> apply(java.util.function.Consumer<javafx.scene.control.skin.MenuButtonSkinBase<C>> func) {
        operations.add(func);
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.skin.MenuButtonSkinBase#getChildren()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final MenuButtonSkinBaseBuilder<C> addChildren(javafx.scene.Node... elements) {
        operations.add(obj -> {
            obj.getChildren().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.skin.MenuButtonSkinBase#getChildren()} method.
     * 
     * @return builder instance
     */
    public final MenuButtonSkinBaseBuilder<C> addChildren(java.util.Collection<? extends javafx.scene.Node> col) {
        operations.add(obj -> {
            obj.getChildren().addAll(col);
        });
        return this;
    }



}
