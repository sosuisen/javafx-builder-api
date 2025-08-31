
package io.github.sosuisen.jfxbuilder.graphics;


public class SepiaToneBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.SepiaTone>> operations = new java.util.ArrayList<>();
    private SepiaToneBuilder() {}
    

    public static SepiaToneBuilder create() { return new SepiaToneBuilder(); }


    
    public static SepiaToneBuilder create(double level) {
        SepiaToneBuilder builder = new SepiaToneBuilder();
        builder.constructorArgs = new Object[]{level};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.effect.SepiaTone build() {
        javafx.scene.effect.SepiaTone newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.SepiaTone();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.SepiaTone> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.SepiaTone callParameterizedConstructor() {
        javafx.scene.effect.SepiaTone newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.SepiaTone.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.SepiaTone) constructor.newInstance(constructorArgs);
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
    
    public SepiaToneBuilder apply(java.util.function.Consumer<javafx.scene.effect.SepiaTone> func) {
        operations.add(func);
        return this;
    }    
    
    public  SepiaToneBuilder level(double value) {
        operations.add(obj -> obj.setLevel(value));
        return this;
    }    
    
    public  SepiaToneBuilder input(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setInput(value));
        return this;
    }    
    
    public SepiaToneBuilder inputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.inputProperty()));
        return this;
    }    
    
    public SepiaToneBuilder levelPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.levelProperty()));
        return this;
    }
}
