
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code PixelFormatTypeBuilder} class constructs instances of the {@link javafx.scene.image.PixelFormat.Type Type} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.image.PixelFormat.Type Type} constructor
 * and returns an instance of the {@code PixelFormatTypeBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.image.PixelFormat.Type Type}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.image.PixelFormat.Type Type} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class PixelFormatTypeBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.image.PixelFormat.Type>> operations = new java.util.ArrayList<>();
    private PixelFormatTypeBuilder() {}
    
    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.image.PixelFormat.Type} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.image.PixelFormat.Type Type} class
     */
    public javafx.scene.image.PixelFormat.Type build() {
        javafx.scene.image.PixelFormat.Type newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.image.PixelFormat.Type> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.image.PixelFormat.Type callParameterizedConstructor() {
        javafx.scene.image.PixelFormat.Type newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.image.PixelFormat.Type.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.image.PixelFormat.Type) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Type instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public PixelFormatTypeBuilder apply(java.util.function.Consumer<javafx.scene.image.PixelFormat.Type> func) {
        operations.add(func);
        return this;
    }
}
