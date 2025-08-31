
package io.github.sosuisen.jfxbuilder.graphics;


public class FloatMapBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.FloatMap>> operations = new java.util.ArrayList<>();
    private FloatMapBuilder() {}
    

    public static FloatMapBuilder create() { return new FloatMapBuilder(); }


    
    public static FloatMapBuilder create(int width, int height) {
        FloatMapBuilder builder = new FloatMapBuilder();
        builder.constructorArgs = new Object[]{width, height};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.effect.FloatMap build() {
        javafx.scene.effect.FloatMap newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.FloatMap();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.FloatMap> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.FloatMap callParameterizedConstructor() {
        javafx.scene.effect.FloatMap newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.FloatMap.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.FloatMap) constructor.newInstance(constructorArgs);
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
    
    public FloatMapBuilder apply(java.util.function.Consumer<javafx.scene.effect.FloatMap> func) {
        operations.add(func);
        return this;
    }    
    
    public  FloatMapBuilder height(int value) {
        operations.add(obj -> obj.setHeight(value));
        return this;
    }    
    
    public  FloatMapBuilder sample(int x, int y, int band, float s) {
        operations.add(obj -> obj.setSample(x, y, band, s));
        return this;
    }    
    
    public  FloatMapBuilder samples(int x, int y, float s0) {
        operations.add(obj -> obj.setSamples(x, y, s0));
        return this;
    }    
    
    public  FloatMapBuilder samples(int x, int y, float s0, float s1) {
        operations.add(obj -> obj.setSamples(x, y, s0, s1));
        return this;
    }    
    
    public  FloatMapBuilder samples(int x, int y, float s0, float s1, float s2) {
        operations.add(obj -> obj.setSamples(x, y, s0, s1, s2));
        return this;
    }    
    
    public  FloatMapBuilder samples(int x, int y, float s0, float s1, float s2, float s3) {
        operations.add(obj -> obj.setSamples(x, y, s0, s1, s2, s3));
        return this;
    }    
    
    public  FloatMapBuilder width(int value) {
        operations.add(obj -> obj.setWidth(value));
        return this;
    }    
    
    public FloatMapBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    
    public FloatMapBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }
}
