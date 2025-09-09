
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code CellSkinBaseBuilder} class constructs instances of the {@link javafx.scene.control.skin.CellSkinBase CellSkinBase} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.skin.CellSkinBase CellSkinBase} constructor
 * and returns an instance of the {@code CellSkinBaseBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.skin.CellSkinBase CellSkinBase}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.skin.CellSkinBase CellSkinBase} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */
@SuppressWarnings("rawtypes")
public class CellSkinBaseBuilder<C extends javafx.scene.control.Cell> {
    private final java.util.List<java.util.function.Consumer<javafx.scene.control.skin.CellSkinBase<C>>> operations = new java.util.ArrayList<>();
    private CellSkinBaseBuilder() {}
    
    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.skin.CellSkinBase#CellSkinBase(javafx.scene.control.Cell) CellSkinBase(C)}
     * and returns an instance of {@code CellSkinBaseBuilder<C>}.
     *
     * @return an instance of the {@code CellSkinBaseBuilder<C>}.
     */
    public static <C extends javafx.scene.control.Cell> CellSkinBaseBuilder<C> create(C control) {
        CellSkinBaseBuilder<C> builder = new CellSkinBaseBuilder<C>();
        builder.constructorArgs = new Object[]{control};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.skin.CellSkinBase CellSkinBase} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.skin.CellSkinBase CellSkinBase} class
     */
    public javafx.scene.control.skin.CellSkinBase<C> build() {
        javafx.scene.control.skin.CellSkinBase<C> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.skin.CellSkinBase<C>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.skin.CellSkinBase<C> callParameterizedConstructor() {
        javafx.scene.control.skin.CellSkinBase<C> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.skin.CellSkinBase.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.skin.CellSkinBase<C>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the CellSkinBase instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public CellSkinBaseBuilder<C> apply(java.util.function.Consumer<javafx.scene.control.skin.CellSkinBase<C>> func) {
        operations.add(func);
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(java.lang.Object[]) addAll} method on the ObservableList
     * returned by the {@link javafx.scene.control.SkinBase#getChildren() CellSkinBase#getChildren()} method.
     * 
     * @return builder instance
     */
    public final CellSkinBaseBuilder<C> addChildren(javafx.scene.Node... elements) {
        operations.add(obj -> obj.getChildren().addAll(elements));
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(java.util.Collection) addAll} method on the ObservableList
     * returned by the {@link javafx.scene.control.SkinBase#getChildren() CellSkinBase#getChildren()} method.
     * 
     * @return builder instance
     */
    public final CellSkinBaseBuilder<C> addChildren(java.util.Collection<? extends javafx.scene.Node> col) {
        operations.add(obj -> obj.getChildren().addAll(col));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.control.skin.CellSkinBase#cellSizeProperty() cellSizeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link CellSkinBaseBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * {@snippet :
     * // Use apply
     * .apply(obj -> obj.cellSizeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .cellSizePropertyApply(prop -> prop.bind(anotherProperty))
     * }
     *
     * @return builder instance
     */
    public CellSkinBaseBuilder<C> cellSizePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.cellSizeProperty()));
        return this;
    }
}
