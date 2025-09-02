
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code PickResultBuilder} class constructs instances of the {@link javafx.scene.input.PickResult PickResult} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.input.PickResult PickResult} constructor
 * and returns an instance of the {@code PickResultBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.input.PickResult PickResult}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.input.PickResult PickResult} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class PickResultBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.input.PickResult>> operations = new java.util.ArrayList<>();
    private PickResultBuilder() {}
    

    
    public static PickResultBuilder create(javafx.event.EventTarget target, double sceneX, double sceneY) {
        PickResultBuilder builder = new PickResultBuilder();
        builder.constructorArgs = new Object[]{target, sceneX, sceneY};
        return builder;
    }


    
    public static PickResultBuilder create(javafx.scene.Node node, javafx.geometry.Point3D point, double distance) {
        PickResultBuilder builder = new PickResultBuilder();
        builder.constructorArgs = new Object[]{node, point, distance};
        return builder;
    }


    
    public static PickResultBuilder create(javafx.scene.Node node, javafx.geometry.Point3D point, double distance, int face, javafx.geometry.Point2D texCoord) {
        PickResultBuilder builder = new PickResultBuilder();
        builder.constructorArgs = new Object[]{node, point, distance, face, texCoord};
        return builder;
    }


    
    public static PickResultBuilder create(javafx.scene.Node node, javafx.geometry.Point3D point, double distance, int face, javafx.geometry.Point3D normal, javafx.geometry.Point2D texCoord) {
        PickResultBuilder builder = new PickResultBuilder();
        builder.constructorArgs = new Object[]{node, point, distance, face, normal, texCoord};
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
     * @return new instance of the {@link javafx.scene.input.PickResult PickResult} class
     */
    public javafx.scene.input.PickResult build() {
        javafx.scene.input.PickResult newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.input.PickResult> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.input.PickResult callParameterizedConstructor() {
        javafx.scene.input.PickResult newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.input.PickResult.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.input.PickResult) constructor.newInstance(constructorArgs);
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
     * Applies a function to the PickResult instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public PickResultBuilder apply(java.util.function.Consumer<javafx.scene.input.PickResult> func) {
        operations.add(func);
        return this;
    }
}
