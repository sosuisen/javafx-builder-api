
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code BackgroundSizeBuilder} class constructs instances of the {@link javafx.scene.layout.BackgroundSize BackgroundSize} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.layout.BackgroundSize BackgroundSize} constructor
 * and returns an instance of the {@code BackgroundSizeBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.layout.BackgroundSize BackgroundSize}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.layout.BackgroundSize BackgroundSize} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class BackgroundSizeBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.layout.BackgroundSize>> operations = new java.util.ArrayList<>();
    private BackgroundSizeBuilder() {}
    

    /**
     * Accepts the constructor arguments of {@link javafx.scene.layout.BackgroundSize#BackgroundSize(double, double, boolean, boolean, boolean, boolean) BackgroundSize(double, double, boolean, boolean, boolean, boolean)}
     * and returns an instance of {@code BackgroundSizeBuilder}.
     *
     * @return an instance of the {@code BackgroundSizeBuilder}.
     */
    
    public static BackgroundSizeBuilder create(double width, double height, boolean widthAsPercentage, boolean heightAsPercentage, boolean contain, boolean cover) {
        BackgroundSizeBuilder builder = new BackgroundSizeBuilder();
        builder.constructorArgs = new Object[]{width, height, widthAsPercentage, heightAsPercentage, contain, cover};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.layout.BackgroundSize} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.layout.BackgroundSize BackgroundSize} class
     */
    public javafx.scene.layout.BackgroundSize build() {
        javafx.scene.layout.BackgroundSize newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.layout.BackgroundSize> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.layout.BackgroundSize callParameterizedConstructor() {
        javafx.scene.layout.BackgroundSize newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.layout.BackgroundSize.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.layout.BackgroundSize) constructor.newInstance(constructorArgs);
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
     * Applies a function to the BackgroundSize instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public BackgroundSizeBuilder apply(java.util.function.Consumer<javafx.scene.layout.BackgroundSize> func) {
        operations.add(func);
        return this;
    }
}
