
package io.github.sosuisen.jfxbuilder.media;


public class AudioEqualizerBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.media.AudioEqualizer>> operations = new java.util.ArrayList<>();
    private AudioEqualizerBuilder() {}
    
    private Object[] constructorArgs;

    public javafx.scene.media.AudioEqualizer build() {
        javafx.scene.media.AudioEqualizer newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.media.AudioEqualizer> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.media.AudioEqualizer callParameterizedConstructor() {
        javafx.scene.media.AudioEqualizer newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.media.AudioEqualizer.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.media.AudioEqualizer) constructor.newInstance(constructorArgs);
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
     * Applies a function to the AudioEqualizer instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(audioEqualizer -> audioEqualizer.setId("Main" + audioEqualizer.getTypeSelector()))
     * }</pre>
     * 
     * @return builder instance
     *
     */
    public AudioEqualizerBuilder apply(java.util.function.Consumer<javafx.scene.media.AudioEqualizer> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.AudioEqualizer#setEnabled(boolean)}
     * 
     * @return builder instance
     */    
    
    public  AudioEqualizerBuilder enabled(boolean value) {
        operations.add(obj -> obj.setEnabled(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.media.AudioEqualizer#getBands()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final AudioEqualizerBuilder addBands(javafx.scene.media.EqualizerBand... elements) {
        operations.add(obj -> {
            obj.getBands().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.media.AudioEqualizer#getBands()} method.
     * 
     * @return builder instance
     */
    public final AudioEqualizerBuilder addBands(java.util.Collection<? extends javafx.scene.media.EqualizerBand> col) {
        operations.add(obj -> {
            obj.getBands().addAll(col);
        });
        return this;
    }


    
    /**
     * Applies a function to the {@link javafx.scene.media.AudioEqualizer#enabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public AudioEqualizerBuilder enabledPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.enabledProperty()));
        return this;
    }
}
