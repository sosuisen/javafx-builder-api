
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code RobotBuilder} class constructs instances of the {@link javafx.scene.robot.Robot Robot} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.robot.Robot Robot} constructor
 * and returns an instance of the {@code RobotBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.robot.Robot Robot}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.robot.Robot Robot} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class RobotBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.robot.Robot>> operations = new java.util.ArrayList<>();
    private RobotBuilder() {}
    
    /**
     * Returns an instance of the {@code RobotBuilder}.
     *
     * @return an instance of the {@code RobotBuilder}.
     */
    public static RobotBuilder create() { return new RobotBuilder(); }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.robot.Robot} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.robot.Robot Robot} class
     */
    public javafx.scene.robot.Robot build() {
        javafx.scene.robot.Robot newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.robot.Robot();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.robot.Robot> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.robot.Robot callParameterizedConstructor() {
        javafx.scene.robot.Robot newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.robot.Robot.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.robot.Robot) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Robot instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public RobotBuilder apply(java.util.function.Consumer<javafx.scene.robot.Robot> func) {
        operations.add(func);
        return this;
    }
}
