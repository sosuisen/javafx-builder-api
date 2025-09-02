
package io.github.sosuisen.jfxbuilder.graphics;


public class LinearGradientBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.paint.LinearGradient>> operations = new java.util.ArrayList<>();
    private LinearGradientBuilder() {}
    

    
    public static LinearGradientBuilder create(double startX, double startY, double endX, double endY, boolean proportional, javafx.scene.paint.CycleMethod cycleMethod, java.util.List<javafx.scene.paint.Stop> stops) {
        LinearGradientBuilder builder = new LinearGradientBuilder();
        builder.constructorArgs = new Object[]{startX, startY, endX, endY, proportional, cycleMethod, stops};
        return builder;
    }


    @SafeVarargs
    public static LinearGradientBuilder create(double startX, double startY, double endX, double endY, boolean proportional, javafx.scene.paint.CycleMethod cycleMethod, javafx.scene.paint.Stop... stops) {
        LinearGradientBuilder builder = new LinearGradientBuilder();
        builder.constructorArgs = new Object[]{startX, startY, endX, endY, proportional, cycleMethod, stops};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.paint.LinearGradient build() {
        javafx.scene.paint.LinearGradient newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.paint.LinearGradient> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.paint.LinearGradient callParameterizedConstructor() {
        javafx.scene.paint.LinearGradient newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.paint.LinearGradient.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.paint.LinearGradient) constructor.newInstance(constructorArgs);
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
     * Applies a function to the LinearGradient instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(linearGradient -> linearGradient.setId("Main" + linearGradient.getTypeSelector()))
     * }</pre>
     * 
     * @return builder instance
     *
     */
    public LinearGradientBuilder apply(java.util.function.Consumer<javafx.scene.paint.LinearGradient> func) {
        operations.add(func);
        return this;
    }
}
