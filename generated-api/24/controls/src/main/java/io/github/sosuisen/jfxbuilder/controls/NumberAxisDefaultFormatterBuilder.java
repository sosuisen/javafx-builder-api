
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code NumberAxisDefaultFormatterBuilder} class constructs instances of the {@link javafx.scene.chart.NumberAxis.DefaultFormatter DefaultFormatter} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.chart.NumberAxis.DefaultFormatter DefaultFormatter} constructor
 * and returns an instance of the {@code NumberAxisDefaultFormatterBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.chart.NumberAxis.DefaultFormatter DefaultFormatter}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.chart.NumberAxis.DefaultFormatter DefaultFormatter} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class NumberAxisDefaultFormatterBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.chart.NumberAxis.DefaultFormatter>> operations = new java.util.ArrayList<>();
    private NumberAxisDefaultFormatterBuilder() {}
    

    /**
     * Accepts the constructor arguments of {@link javafx.scene.chart.NumberAxis.DefaultFormatter#DefaultFormatter(NumberAxis) DefaultFormatter(NumberAxis)}
     * and returns an instance of {@code NumberAxisDefaultFormatterBuilder}.
     *
     * @return an instance of the {@code NumberAxisDefaultFormatterBuilder}.
     */
    
    public static NumberAxisDefaultFormatterBuilder create(javafx.scene.chart.NumberAxis axis) {
        NumberAxisDefaultFormatterBuilder builder = new NumberAxisDefaultFormatterBuilder();
        builder.constructorArgs = new Object[]{axis};
        return builder;
    }


    /**
     * Accepts the constructor arguments of {@link javafx.scene.chart.NumberAxis.DefaultFormatter#DefaultFormatter(NumberAxis, String, String) DefaultFormatter(NumberAxis, String, String)}
     * and returns an instance of {@code NumberAxisDefaultFormatterBuilder}.
     *
     * @return an instance of the {@code NumberAxisDefaultFormatterBuilder}.
     */
    
    public static NumberAxisDefaultFormatterBuilder create(javafx.scene.chart.NumberAxis axis, java.lang.String prefix, java.lang.String suffix) {
        NumberAxisDefaultFormatterBuilder builder = new NumberAxisDefaultFormatterBuilder();
        builder.constructorArgs = new Object[]{axis, prefix, suffix};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.chart.NumberAxis.DefaultFormatter} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.chart.NumberAxis.DefaultFormatter DefaultFormatter} class
     */
    public javafx.scene.chart.NumberAxis.DefaultFormatter build() {
        javafx.scene.chart.NumberAxis.DefaultFormatter newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.chart.NumberAxis.DefaultFormatter> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.chart.NumberAxis.DefaultFormatter callParameterizedConstructor() {
        javafx.scene.chart.NumberAxis.DefaultFormatter newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.chart.NumberAxis.DefaultFormatter.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.chart.NumberAxis.DefaultFormatter) constructor.newInstance(constructorArgs);
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
     * Applies a function to the DefaultFormatter instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public NumberAxisDefaultFormatterBuilder apply(java.util.function.Consumer<javafx.scene.chart.NumberAxis.DefaultFormatter> func) {
        operations.add(func);
        return this;
    }
}
