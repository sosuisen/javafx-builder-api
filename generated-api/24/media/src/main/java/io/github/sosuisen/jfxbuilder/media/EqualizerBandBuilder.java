
package io.github.sosuisen.jfxbuilder.media;


public class EqualizerBandBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.media.EqualizerBand>> operations = new java.util.ArrayList<>();
    private EqualizerBandBuilder() {}
    

    public static EqualizerBandBuilder create() { return new EqualizerBandBuilder(); }


    
    public static EqualizerBandBuilder create(double centerFrequency, double bandwidth, double gain) {
        EqualizerBandBuilder builder = new EqualizerBandBuilder();
        builder.constructorArgs = new Object[]{centerFrequency, bandwidth, gain};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.media.EqualizerBand build() {
        javafx.scene.media.EqualizerBand newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.media.EqualizerBand();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.media.EqualizerBand> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.media.EqualizerBand callParameterizedConstructor() {
        javafx.scene.media.EqualizerBand newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.media.EqualizerBand.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.media.EqualizerBand) constructor.newInstance(constructorArgs);
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
    
    public EqualizerBandBuilder apply(java.util.function.Consumer<javafx.scene.media.EqualizerBand> func) {
        operations.add(func);
        return this;
    }    
    
    public  EqualizerBandBuilder gain(double value) {
        operations.add(obj -> obj.setGain(value));
        return this;
    }    
    
    public  EqualizerBandBuilder bandwidth(double value) {
        operations.add(obj -> obj.setBandwidth(value));
        return this;
    }    
    
    public  EqualizerBandBuilder centerFrequency(double value) {
        operations.add(obj -> obj.setCenterFrequency(value));
        return this;
    }    
    
    public EqualizerBandBuilder centerFrequencyPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.centerFrequencyProperty()));
        return this;
    }    
    
    public EqualizerBandBuilder bandwidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.bandwidthProperty()));
        return this;
    }    
    
    public EqualizerBandBuilder gainPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.gainProperty()));
        return this;
    }
}
