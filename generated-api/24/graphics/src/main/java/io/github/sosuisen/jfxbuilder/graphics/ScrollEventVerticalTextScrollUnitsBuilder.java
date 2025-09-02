
package io.github.sosuisen.jfxbuilder.graphics;


public class ScrollEventVerticalTextScrollUnitsBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.input.ScrollEvent.VerticalTextScrollUnits>> operations = new java.util.ArrayList<>();
    private ScrollEventVerticalTextScrollUnitsBuilder() {}
    
    private Object[] constructorArgs;

    /**
     * This method builds and returns an instance of the original class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the build() method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.input.ScrollEvent.VerticalTextScrollUnits VerticalTextScrollUnits} class
     */
    public javafx.scene.input.ScrollEvent.VerticalTextScrollUnits build() {
        javafx.scene.input.ScrollEvent.VerticalTextScrollUnits newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.input.ScrollEvent.VerticalTextScrollUnits> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.input.ScrollEvent.VerticalTextScrollUnits callParameterizedConstructor() {
        javafx.scene.input.ScrollEvent.VerticalTextScrollUnits newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.input.ScrollEvent.VerticalTextScrollUnits.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.input.ScrollEvent.VerticalTextScrollUnits) constructor.newInstance(constructorArgs);
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
     * Applies a function to the VerticalTextScrollUnits instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public ScrollEventVerticalTextScrollUnitsBuilder apply(java.util.function.Consumer<javafx.scene.input.ScrollEvent.VerticalTextScrollUnits> func) {
        operations.add(func);
        return this;
    }
}
