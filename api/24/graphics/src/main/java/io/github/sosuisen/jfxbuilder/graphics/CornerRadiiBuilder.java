
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code CornerRadiiBuilder} class constructs instances of the {@link javafx.scene.layout.CornerRadii CornerRadii} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.layout.CornerRadii CornerRadii} constructor
 * and returns an instance of the {@code CornerRadiiBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.layout.CornerRadii CornerRadii}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.layout.CornerRadii CornerRadii} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class CornerRadiiBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.layout.CornerRadii>> operations = new java.util.ArrayList<>();
    private CornerRadiiBuilder() {}
    
    /**
     * Accepts the constructor arguments of {@link javafx.scene.layout.CornerRadii#CornerRadii(double) CornerRadii(double)}
     * and returns an instance of {@code CornerRadiiBuilder}.
     *
     * @return an instance of the {@code CornerRadiiBuilder}.
     */
    public static CornerRadiiBuilder create(double radius) {
        CornerRadiiBuilder builder = new CornerRadiiBuilder();
        builder.constructorArgs = new Object[]{radius};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.layout.CornerRadii#CornerRadii(double, boolean) CornerRadii(double, boolean)}
     * and returns an instance of {@code CornerRadiiBuilder}.
     *
     * @return an instance of the {@code CornerRadiiBuilder}.
     */
    public static CornerRadiiBuilder create(double radius, boolean asPercent) {
        CornerRadiiBuilder builder = new CornerRadiiBuilder();
        builder.constructorArgs = new Object[]{radius, asPercent};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.layout.CornerRadii#CornerRadii(double, double, double, double, boolean) CornerRadii(double, double, double, double, boolean)}
     * and returns an instance of {@code CornerRadiiBuilder}.
     *
     * @return an instance of the {@code CornerRadiiBuilder}.
     */
    public static CornerRadiiBuilder create(double topLeft, double topRight, double bottomRight, double bottomLeft, boolean asPercent) {
        CornerRadiiBuilder builder = new CornerRadiiBuilder();
        builder.constructorArgs = new Object[]{topLeft, topRight, bottomRight, bottomLeft, asPercent};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.layout.CornerRadii#CornerRadii(double, double, double, double, double, double, double, double, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean) CornerRadii(double, double, double, double, double, double, double, double, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean)}
     * and returns an instance of {@code CornerRadiiBuilder}.
     *
     * @return an instance of the {@code CornerRadiiBuilder}.
     */
    public static CornerRadiiBuilder create(double topLeftHorizontalRadius, double topLeftVerticalRadius, double topRightVerticalRadius, double topRightHorizontalRadius, double bottomRightHorizontalRadius, double bottomRightVerticalRadius, double bottomLeftVerticalRadius, double bottomLeftHorizontalRadius, boolean topLeftHorizontalRadiusAsPercent, boolean topLeftVerticalRadiusAsPercent, boolean topRightVerticalRadiusAsPercent, boolean topRightHorizontalRadiusAsPercent, boolean bottomRightHorizontalRadiusAsPercent, boolean bottomRightVerticalRadiusAsPercent, boolean bottomLeftVerticalRadiusAsPercent, boolean bottomLeftHorizontalRadiusAsPercent) {
        CornerRadiiBuilder builder = new CornerRadiiBuilder();
        builder.constructorArgs = new Object[]{topLeftHorizontalRadius, topLeftVerticalRadius, topRightVerticalRadius, topRightHorizontalRadius, bottomRightHorizontalRadius, bottomRightVerticalRadius, bottomLeftVerticalRadius, bottomLeftHorizontalRadius, topLeftHorizontalRadiusAsPercent, topLeftVerticalRadiusAsPercent, topRightVerticalRadiusAsPercent, topRightHorizontalRadiusAsPercent, bottomRightHorizontalRadiusAsPercent, bottomRightVerticalRadiusAsPercent, bottomLeftVerticalRadiusAsPercent, bottomLeftHorizontalRadiusAsPercent};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.layout.CornerRadii CornerRadii} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.layout.CornerRadii CornerRadii} class
     */
    public javafx.scene.layout.CornerRadii build() {
        javafx.scene.layout.CornerRadii newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.layout.CornerRadii> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.layout.CornerRadii callParameterizedConstructor() {
        javafx.scene.layout.CornerRadii newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.layout.CornerRadii.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.layout.CornerRadii) constructor.newInstance(constructorArgs);
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
     * Applies a function to the CornerRadii instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public CornerRadiiBuilder apply(java.util.function.Consumer<javafx.scene.layout.CornerRadii> func) {
        operations.add(func);
        return this;
    }
}
