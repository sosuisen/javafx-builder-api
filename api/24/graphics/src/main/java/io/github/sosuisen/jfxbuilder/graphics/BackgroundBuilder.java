
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code BackgroundBuilder} class constructs instances of the {@link javafx.scene.layout.Background Background} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.layout.Background Background} constructor
 * and returns an instance of the {@code BackgroundBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.layout.Background Background}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.layout.Background Background} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class BackgroundBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.layout.Background>> operations = new java.util.ArrayList<>();
    private BackgroundBuilder() {}
    
    /**
     * Accepts the constructor arguments of {@link javafx.scene.layout.Background#Background(java.util.List, java.util.List) Background(List, List)}
     * and returns an instance of {@code BackgroundBuilder}.
     *
     * @return an instance of the {@code BackgroundBuilder}.
     */
    public static BackgroundBuilder create(java.util.List<javafx.scene.layout.BackgroundFill> fills, java.util.List<javafx.scene.layout.BackgroundImage> images) {
        BackgroundBuilder builder = new BackgroundBuilder();
        builder.constructorArgs = new Object[]{fills, images};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.layout.Background#Background(javafx.scene.layout.BackgroundFill...) Background(BackgroundFill...)}
     * and returns an instance of {@code BackgroundBuilder}.
     *
     * @return an instance of the {@code BackgroundBuilder}.
     */
    @SafeVarargs
    public static BackgroundBuilder create(javafx.scene.layout.BackgroundFill... fills) {
        BackgroundBuilder builder = new BackgroundBuilder();
        builder.constructorArgs = new Object[]{fills};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.layout.Background#Background(javafx.scene.layout.BackgroundFill..., javafx.scene.layout.BackgroundImage...) Background(BackgroundFill..., BackgroundImage...)}
     * and returns an instance of {@code BackgroundBuilder}.
     *
     * @return an instance of the {@code BackgroundBuilder}.
     */
    public static BackgroundBuilder create(javafx.scene.layout.BackgroundFill[] fills, javafx.scene.layout.BackgroundImage[] images) {
        BackgroundBuilder builder = new BackgroundBuilder();
        builder.constructorArgs = new Object[]{fills, images};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.layout.Background#Background(javafx.scene.layout.BackgroundImage...) Background(BackgroundImage...)}
     * and returns an instance of {@code BackgroundBuilder}.
     *
     * @return an instance of the {@code BackgroundBuilder}.
     */
    @SafeVarargs
    public static BackgroundBuilder create(javafx.scene.layout.BackgroundImage... images) {
        BackgroundBuilder builder = new BackgroundBuilder();
        builder.constructorArgs = new Object[]{images};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.layout.Background} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.layout.Background Background} class
     */
    public javafx.scene.layout.Background build() {
        javafx.scene.layout.Background newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.layout.Background> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.layout.Background callParameterizedConstructor() {
        javafx.scene.layout.Background newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.layout.Background.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.layout.Background) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Background instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public BackgroundBuilder apply(java.util.function.Consumer<javafx.scene.layout.Background> func) {
        operations.add(func);
        return this;
    }
}
