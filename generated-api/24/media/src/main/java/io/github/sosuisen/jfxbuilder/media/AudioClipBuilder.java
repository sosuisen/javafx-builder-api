
package io.github.sosuisen.jfxbuilder.media;


public class AudioClipBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.media.AudioClip>> operations = new java.util.ArrayList<>();
    private AudioClipBuilder() {}
    

    
    public static AudioClipBuilder create(java.lang.String source) {
        AudioClipBuilder builder = new AudioClipBuilder();
        builder.constructorArgs = new Object[]{source};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.media.AudioClip build() {
        javafx.scene.media.AudioClip newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.media.AudioClip> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.media.AudioClip callParameterizedConstructor() {
        javafx.scene.media.AudioClip newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.media.AudioClip.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.media.AudioClip) constructor.newInstance(constructorArgs);
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
    
    public AudioClipBuilder apply(java.util.function.Consumer<javafx.scene.media.AudioClip> func) {
        operations.add(func);
        return this;
    }    
    
    public  AudioClipBuilder volume(double value) {
        operations.add(obj -> obj.setVolume(value));
        return this;
    }    
    
    public  AudioClipBuilder rate(double rate) {
        operations.add(obj -> obj.setRate(rate));
        return this;
    }    
    
    public  AudioClipBuilder pan(double pan) {
        operations.add(obj -> obj.setPan(pan));
        return this;
    }    
    
    public  AudioClipBuilder balance(double balance) {
        operations.add(obj -> obj.setBalance(balance));
        return this;
    }    
    
    public  AudioClipBuilder priority(int priority) {
        operations.add(obj -> obj.setPriority(priority));
        return this;
    }    
    
    public  AudioClipBuilder cycleCount(int count) {
        operations.add(obj -> obj.setCycleCount(count));
        return this;
    }    
    
    public AudioClipBuilder volumePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.volumeProperty()));
        return this;
    }    
    
    public AudioClipBuilder panPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.panProperty()));
        return this;
    }    
    
    public AudioClipBuilder priorityPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.priorityProperty()));
        return this;
    }    
    
    public AudioClipBuilder ratePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rateProperty()));
        return this;
    }    
    
    public AudioClipBuilder balancePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.balanceProperty()));
        return this;
    }    
    
    public AudioClipBuilder cycleCountPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.cycleCountProperty()));
        return this;
    }
}
