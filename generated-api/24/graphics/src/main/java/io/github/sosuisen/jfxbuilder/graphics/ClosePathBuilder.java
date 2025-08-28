
package io.github.sosuisen.jfxbuilder.graphics;


public class ClosePathBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.shape.ClosePath>> operations = new java.util.ArrayList<>();
    private ClosePathBuilder() {}
    

    public static ClosePathBuilder create() { return new ClosePathBuilder(); }

    private Object[] constructorArgs;

    public javafx.scene.shape.ClosePath build() {
        javafx.scene.shape.ClosePath newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.shape.ClosePath();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.shape.ClosePath> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.shape.ClosePath callParameterizedConstructor() {
        javafx.scene.shape.ClosePath newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.shape.ClosePath.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.shape.ClosePath) constructor.newInstance(constructorArgs);
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
    
    public ClosePathBuilder apply(java.util.function.Consumer<javafx.scene.shape.ClosePath> func) {
        operations.add(func);
        return this;
    }    
    
    public  ClosePathBuilder absolute(boolean value) {
        operations.add(obj -> obj.setAbsolute(value));
        return this;
    }    
    
    public ClosePathBuilder absolutePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.absoluteProperty()));
        return this;
    }
}
