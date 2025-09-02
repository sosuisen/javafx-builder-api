
package io.github.sosuisen.jfxbuilder.media;

/**
 * The {@code AudioClipBuilder} class constructs instances of the {@link javafx.scene.media.AudioClip AudioClip} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.media.AudioClip AudioClip} constructor
 * and returns an instance of the {@code AudioClipBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.media.AudioClip AudioClip}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.media.AudioClip AudioClip} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class AudioClipBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.media.AudioClip>> operations = new java.util.ArrayList<>();
    private AudioClipBuilder() {}
    

    /**
     * Accepts the same arguments as {@link javafx.scene.media.AudioClip#AudioClip(java.lang.String source) AudioClip(String)}
     * and returns an instance of the {@code AudioClipBuilder}.
     *
     * @return an instance of the {@code AudioClipBuilder}.
     */
    
    public static AudioClipBuilder create(java.lang.String source) {
        AudioClipBuilder builder = new AudioClipBuilder();
        builder.constructorArgs = new Object[]{source};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * This method builds and returns an instance of the original class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the build() method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.media.AudioClip AudioClip} class
     */
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
    /**
     * Applies a function to the AudioClip instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public AudioClipBuilder apply(java.util.function.Consumer<javafx.scene.media.AudioClip> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.AudioClip#setBalance(double)}
     * 
     * @return builder instance
     */    
    
    public  AudioClipBuilder balance(double balance) {
        operations.add(obj -> obj.setBalance(balance));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.AudioClip#setCycleCount(int)}
     * 
     * @return builder instance
     */    
    
    public  AudioClipBuilder cycleCount(int count) {
        operations.add(obj -> obj.setCycleCount(count));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.AudioClip#setPan(double)}
     * 
     * @return builder instance
     */    
    
    public  AudioClipBuilder pan(double pan) {
        operations.add(obj -> obj.setPan(pan));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.AudioClip#setPriority(int)}
     * 
     * @return builder instance
     */    
    
    public  AudioClipBuilder priority(int priority) {
        operations.add(obj -> obj.setPriority(priority));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.AudioClip#setRate(double)}
     * 
     * @return builder instance
     */    
    
    public  AudioClipBuilder rate(double rate) {
        operations.add(obj -> obj.setRate(rate));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.AudioClip#setVolume(double)}
     * 
     * @return builder instance
     */    
    
    public  AudioClipBuilder volume(double value) {
        operations.add(obj -> obj.setVolume(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.AudioClip#balanceProperty()}.
     * 
     * @return builder instance
     */    
    
    public AudioClipBuilder balancePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.balanceProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.AudioClip#cycleCountProperty()}.
     * 
     * @return builder instance
     */    
    
    public AudioClipBuilder cycleCountPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.cycleCountProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.AudioClip#panProperty()}.
     * 
     * @return builder instance
     */    
    
    public AudioClipBuilder panPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.panProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.AudioClip#priorityProperty()}.
     * 
     * @return builder instance
     */    
    
    public AudioClipBuilder priorityPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.priorityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.AudioClip#rateProperty()}.
     * 
     * @return builder instance
     */    
    
    public AudioClipBuilder ratePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.AudioClip#volumeProperty()}.
     * 
     * @return builder instance
     */    
    
    public AudioClipBuilder volumePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.volumeProperty()));
        return this;
    }
}
