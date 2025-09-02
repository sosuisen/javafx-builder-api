
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code MenuBarSkinBuilder} class constructs instances of the {@link javafx.scene.control.skin.MenuBarSkin MenuBarSkin} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.skin.MenuBarSkin MenuBarSkin} constructor
 * and returns an instance of the {@code MenuBarSkinBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.skin.MenuBarSkin MenuBarSkin}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.skin.MenuBarSkin MenuBarSkin} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class MenuBarSkinBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.skin.MenuBarSkin>> operations = new java.util.ArrayList<>();
    private MenuBarSkinBuilder() {}
    

    
    public static MenuBarSkinBuilder create(javafx.scene.control.MenuBar control) {
        MenuBarSkinBuilder builder = new MenuBarSkinBuilder();
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
     * @return new instance of the {@link javafx.scene.control.skin.MenuBarSkin MenuBarSkin} class
     */
    public javafx.scene.control.skin.MenuBarSkin build() {
        javafx.scene.control.skin.MenuBarSkin newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.skin.MenuBarSkin> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.skin.MenuBarSkin callParameterizedConstructor() {
        javafx.scene.control.skin.MenuBarSkin newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.skin.MenuBarSkin.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.skin.MenuBarSkin) constructor.newInstance(constructorArgs);
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
     * Applies a function to the MenuBarSkin instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public MenuBarSkinBuilder apply(java.util.function.Consumer<javafx.scene.control.skin.MenuBarSkin> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.MenuBarSkin#setContainerAlignment(javafx.geometry.Pos)}
     * 
     * @return builder instance
     */    
    
    public  MenuBarSkinBuilder containerAlignment(javafx.geometry.Pos value) {
        operations.add(obj -> obj.setContainerAlignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.MenuBarSkin#setSpacing(double)}
     * 
     * @return builder instance
     */    
    
    public  MenuBarSkinBuilder spacing(double value) {
        operations.add(obj -> obj.setSpacing(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.skin.MenuBarSkin#getChildren()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final MenuBarSkinBuilder addChildren(javafx.scene.Node... elements) {
        operations.add(obj -> {
            obj.getChildren().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.skin.MenuBarSkin#getChildren()} method.
     * 
     * @return builder instance
     */
    public final MenuBarSkinBuilder addChildren(java.util.Collection<? extends javafx.scene.Node> col) {
        operations.add(obj -> {
            obj.getChildren().addAll(col);
        });
        return this;
    }


    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.MenuBarSkin#containerAlignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuBarSkinBuilder containerAlignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Pos>> op) {
        operations.add(obj -> op.accept(obj.containerAlignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.skin.MenuBarSkin#spacingProperty()}.
     * 
     * @return builder instance
     */    
    
    public MenuBarSkinBuilder spacingPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.spacingProperty()));
        return this;
    }
}
