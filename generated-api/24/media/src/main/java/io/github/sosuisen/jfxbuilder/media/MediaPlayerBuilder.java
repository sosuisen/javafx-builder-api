
package io.github.sosuisen.jfxbuilder.media;

/**
 * The {@code MediaPlayerBuilder} class constructs instances of the {@link javafx.scene.media.MediaPlayer MediaPlayer} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.media.MediaPlayer MediaPlayer} constructor
 * and returns an instance of the {@code MediaPlayerBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.media.MediaPlayer MediaPlayer}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.media.MediaPlayer MediaPlayer} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class MediaPlayerBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.media.MediaPlayer>> operations = new java.util.ArrayList<>();
    private MediaPlayerBuilder() {}
    

    /**
     * Accepts the constructor arguments of {@link javafx.scene.media.MediaPlayer#MediaPlayer(Media) MediaPlayer(Media)}
     * and returns an instance of {@code MediaPlayerBuilder}.
     *
     * @return an instance of the {@code MediaPlayerBuilder}.
     */
    
    public static MediaPlayerBuilder create(javafx.scene.media.Media media) {
        MediaPlayerBuilder builder = new MediaPlayerBuilder();
        builder.constructorArgs = new Object[]{media};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.media.MediaPlayer} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.media.MediaPlayer MediaPlayer} class
     */
    public javafx.scene.media.MediaPlayer build() {
        javafx.scene.media.MediaPlayer newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.media.MediaPlayer> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.media.MediaPlayer callParameterizedConstructor() {
        javafx.scene.media.MediaPlayer newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.media.MediaPlayer.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.media.MediaPlayer) constructor.newInstance(constructorArgs);
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
     * Applies a function to the MediaPlayer instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public MediaPlayerBuilder apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setAudioSpectrumInterval(double)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder audioSpectrumInterval(double value) {
        operations.add(obj -> obj.setAudioSpectrumInterval(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setAudioSpectrumListener(javafx.scene.media.AudioSpectrumListener)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder audioSpectrumListener(javafx.scene.media.AudioSpectrumListener listener) {
        operations.add(obj -> obj.setAudioSpectrumListener(listener));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setAudioSpectrumNumBands(int)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder audioSpectrumNumBands(int value) {
        operations.add(obj -> obj.setAudioSpectrumNumBands(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setAudioSpectrumThreshold(int)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder audioSpectrumThreshold(int value) {
        operations.add(obj -> obj.setAudioSpectrumThreshold(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setAutoPlay(boolean)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder autoPlay(boolean value) {
        operations.add(obj -> obj.setAutoPlay(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setBalance(double)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder balance(double value) {
        operations.add(obj -> obj.setBalance(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setCycleCount(int)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder cycleCount(int value) {
        operations.add(obj -> obj.setCycleCount(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setMute(boolean)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder mute(boolean value) {
        operations.add(obj -> obj.setMute(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setOnEndOfMedia(java.lang.Runnable)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder onEndOfMedia(java.lang.Runnable value) {
        operations.add(obj -> obj.setOnEndOfMedia(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setOnError(java.lang.Runnable)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder onError(java.lang.Runnable value) {
        operations.add(obj -> obj.setOnError(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setOnHalted(java.lang.Runnable)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder onHalted(java.lang.Runnable value) {
        operations.add(obj -> obj.setOnHalted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setOnMarker(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder onMarker(javafx.event.EventHandler<javafx.scene.media.MediaMarkerEvent> onMarker) {
        operations.add(obj -> obj.setOnMarker(onMarker));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setOnPaused(java.lang.Runnable)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder onPaused(java.lang.Runnable value) {
        operations.add(obj -> obj.setOnPaused(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setOnPlaying(java.lang.Runnable)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder onPlaying(java.lang.Runnable value) {
        operations.add(obj -> obj.setOnPlaying(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setOnReady(java.lang.Runnable)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder onReady(java.lang.Runnable value) {
        operations.add(obj -> obj.setOnReady(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setOnRepeat(java.lang.Runnable)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder onRepeat(java.lang.Runnable value) {
        operations.add(obj -> obj.setOnRepeat(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setOnStalled(java.lang.Runnable)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder onStalled(java.lang.Runnable value) {
        operations.add(obj -> obj.setOnStalled(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setOnStopped(java.lang.Runnable)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder onStopped(java.lang.Runnable value) {
        operations.add(obj -> obj.setOnStopped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setRate(double)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder rate(double value) {
        operations.add(obj -> obj.setRate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setStartTime(javafx.util.Duration)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder startTime(javafx.util.Duration value) {
        operations.add(obj -> obj.setStartTime(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setStopTime(javafx.util.Duration)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder stopTime(javafx.util.Duration value) {
        operations.add(obj -> obj.setStopTime(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.media.MediaPlayer#setVolume(double)}
     * 
     * @return builder instance
     */    
    
    public  MediaPlayerBuilder volume(double value) {
        operations.add(obj -> obj.setVolume(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#audioSpectrumIntervalProperty() audioSpectrumIntervalProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.audioSpectrumIntervalProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .audioSpectrumIntervalPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder audioSpectrumIntervalPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.audioSpectrumIntervalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#audioSpectrumListenerProperty() audioSpectrumListenerProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.audioSpectrumListenerProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .audioSpectrumListenerPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder audioSpectrumListenerPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.media.AudioSpectrumListener>> op) {
        operations.add(obj -> op.accept(obj.audioSpectrumListenerProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#audioSpectrumNumBandsProperty() audioSpectrumNumBandsProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.audioSpectrumNumBandsProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .audioSpectrumNumBandsPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder audioSpectrumNumBandsPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.audioSpectrumNumBandsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#audioSpectrumThresholdProperty() audioSpectrumThresholdProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.audioSpectrumThresholdProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .audioSpectrumThresholdPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder audioSpectrumThresholdPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.audioSpectrumThresholdProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#autoPlayProperty() autoPlayProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.autoPlayProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .autoPlayPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder autoPlayPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.autoPlayProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#balanceProperty() balanceProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.balanceProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .balancePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder balancePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.balanceProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#bufferProgressTimeProperty() bufferProgressTimeProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.bufferProgressTimeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .bufferProgressTimePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder bufferProgressTimePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.bufferProgressTimeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#currentCountProperty() currentCountProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.currentCountProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .currentCountPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder currentCountPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyIntegerProperty> op) {
        operations.add(obj -> op.accept(obj.currentCountProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#currentRateProperty() currentRateProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.currentRateProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .currentRatePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder currentRatePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.currentRateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#currentTimeProperty() currentTimeProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.currentTimeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .currentTimePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder currentTimePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.currentTimeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#cycleCountProperty() cycleCountProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.cycleCountProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .cycleCountPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder cycleCountPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.cycleCountProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#cycleDurationProperty() cycleDurationProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.cycleDurationProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .cycleDurationPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder cycleDurationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.cycleDurationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#errorProperty() errorProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.errorProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .errorPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder errorPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.media.MediaException>> op) {
        operations.add(obj -> op.accept(obj.errorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#muteProperty() muteProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.muteProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .mutePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder mutePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.muteProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#onEndOfMediaProperty() onEndOfMediaProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onEndOfMediaProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onEndOfMediaPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder onEndOfMediaPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Runnable>> op) {
        operations.add(obj -> op.accept(obj.onEndOfMediaProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#onErrorProperty() onErrorProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onErrorProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onErrorPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder onErrorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Runnable>> op) {
        operations.add(obj -> op.accept(obj.onErrorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#onHaltedProperty() onHaltedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onHaltedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onHaltedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder onHaltedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Runnable>> op) {
        operations.add(obj -> op.accept(obj.onHaltedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#onMarkerProperty() onMarkerProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onMarkerProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onMarkerPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder onMarkerPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.media.MediaMarkerEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMarkerProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#onPausedProperty() onPausedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onPausedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onPausedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder onPausedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Runnable>> op) {
        operations.add(obj -> op.accept(obj.onPausedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#onPlayingProperty() onPlayingProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onPlayingProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onPlayingPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder onPlayingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Runnable>> op) {
        operations.add(obj -> op.accept(obj.onPlayingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#onReadyProperty() onReadyProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onReadyProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onReadyPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder onReadyPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Runnable>> op) {
        operations.add(obj -> op.accept(obj.onReadyProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#onRepeatProperty() onRepeatProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onRepeatProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onRepeatPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder onRepeatPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Runnable>> op) {
        operations.add(obj -> op.accept(obj.onRepeatProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#onStalledProperty() onStalledProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onStalledProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onStalledPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder onStalledPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Runnable>> op) {
        operations.add(obj -> op.accept(obj.onStalledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#onStoppedProperty() onStoppedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onStoppedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onStoppedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder onStoppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Runnable>> op) {
        operations.add(obj -> op.accept(obj.onStoppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#rateProperty() rateProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.rateProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .ratePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder ratePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#startTimeProperty() startTimeProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.startTimeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .startTimePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder startTimePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.startTimeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#statusProperty() statusProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.statusProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .statusPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder statusPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.media.MediaPlayer.Status>> op) {
        operations.add(obj -> op.accept(obj.statusProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#stopTimeProperty() stopTimeProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.stopTimeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .stopTimePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder stopTimePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.stopTimeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#totalDurationProperty() totalDurationProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.totalDurationProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .totalDurationPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder totalDurationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.totalDurationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.media.MediaPlayer#volumeProperty() volumeProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.volumeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .volumePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public MediaPlayerBuilder volumePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.volumeProperty()));
        return this;
    }
}
