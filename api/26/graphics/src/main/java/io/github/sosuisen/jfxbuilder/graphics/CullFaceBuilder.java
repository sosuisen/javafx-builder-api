
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code CullFaceBuilder} class constructs instances of the {@link javafx.scene.shape.CullFace CullFace} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.shape.CullFace CullFace} constructor
 * and returns an instance of the {@code CullFaceBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.shape.CullFace CullFace}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.shape.CullFace CullFace} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class CullFaceBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.shape.CullFace>> operations = new java.util.ArrayList<>();
    private CullFaceBuilder() {}
    
    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.shape.CullFace CullFace} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.shape.CullFace CullFace} class
     */
    public javafx.scene.shape.CullFace build() {
        javafx.scene.shape.CullFace newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.shape.CullFace> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.shape.CullFace callParameterizedConstructor() {
        javafx.scene.shape.CullFace newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.shape.CullFace.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.shape.CullFace) constructor.newInstance(constructorArgs);
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
     * Applies a function to the CullFace instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public CullFaceBuilder apply(java.util.function.Consumer<javafx.scene.shape.CullFace> func) {
        operations.add(func);
        return this;
    }
}
