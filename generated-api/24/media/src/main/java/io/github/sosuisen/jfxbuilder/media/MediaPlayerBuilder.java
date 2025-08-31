
package io.github.sosuisen.jfxbuilder.media;


public class MediaPlayerBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.media.MediaPlayer>> operations = new java.util.ArrayList<>();
    private MediaPlayerBuilder() {}
    

    
    public static MediaPlayerBuilder create(javafx.scene.media.Media media) {
        MediaPlayerBuilder builder = new MediaPlayerBuilder();
        builder.constructorArgs = new Object[]{media};
        return builder;
    }

    private Object[] constructorArgs;

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
    
    public MediaPlayerBuilder apply(java.util.function.Consumer<javafx.scene.media.MediaPlayer> func) {
        operations.add(func);
        return this;
    }    
    
    public  MediaPlayerBuilder volume(double value) {
        operations.add(obj -> obj.setVolume(value));
        return this;
    }    
    
    public  MediaPlayerBuilder rate(double value) {
        operations.add(obj -> obj.setRate(value));
        return this;
    }    
    
    public  MediaPlayerBuilder balance(double value) {
        operations.add(obj -> obj.setBalance(value));
        return this;
    }    
    
    public  MediaPlayerBuilder audioSpectrumThreshold(int value) {
        operations.add(obj -> obj.setAudioSpectrumThreshold(value));
        return this;
    }    
    
    public  MediaPlayerBuilder audioSpectrumListener(javafx.scene.media.AudioSpectrumListener listener) {
        operations.add(obj -> obj.setAudioSpectrumListener(listener));
        return this;
    }    
    
    public  MediaPlayerBuilder audioSpectrumInterval(double value) {
        operations.add(obj -> obj.setAudioSpectrumInterval(value));
        return this;
    }    
    
    public  MediaPlayerBuilder audioSpectrumNumBands(int value) {
        operations.add(obj -> obj.setAudioSpectrumNumBands(value));
        return this;
    }    
    
    public  MediaPlayerBuilder onError(java.lang.Runnable value) {
        operations.add(obj -> obj.setOnError(value));
        return this;
    }    
    
    public  MediaPlayerBuilder mute(boolean value) {
        operations.add(obj -> obj.setMute(value));
        return this;
    }    
    
    public  MediaPlayerBuilder onEndOfMedia(java.lang.Runnable value) {
        operations.add(obj -> obj.setOnEndOfMedia(value));
        return this;
    }    
    
    public  MediaPlayerBuilder onHalted(java.lang.Runnable value) {
        operations.add(obj -> obj.setOnHalted(value));
        return this;
    }    
    
    public  MediaPlayerBuilder onMarker(javafx.event.EventHandler<javafx.scene.media.MediaMarkerEvent> onMarker) {
        operations.add(obj -> obj.setOnMarker(onMarker));
        return this;
    }    
    
    public  MediaPlayerBuilder onPaused(java.lang.Runnable value) {
        operations.add(obj -> obj.setOnPaused(value));
        return this;
    }    
    
    public  MediaPlayerBuilder onPlaying(java.lang.Runnable value) {
        operations.add(obj -> obj.setOnPlaying(value));
        return this;
    }    
    
    public  MediaPlayerBuilder onStalled(java.lang.Runnable value) {
        operations.add(obj -> obj.setOnStalled(value));
        return this;
    }    
    
    public  MediaPlayerBuilder onStopped(java.lang.Runnable value) {
        operations.add(obj -> obj.setOnStopped(value));
        return this;
    }    
    
    public  MediaPlayerBuilder onRepeat(java.lang.Runnable value) {
        operations.add(obj -> obj.setOnRepeat(value));
        return this;
    }    
    
    public  MediaPlayerBuilder stopTime(javafx.util.Duration value) {
        operations.add(obj -> obj.setStopTime(value));
        return this;
    }    
    
    public  MediaPlayerBuilder onReady(java.lang.Runnable value) {
        operations.add(obj -> obj.setOnReady(value));
        return this;
    }    
    
    public  MediaPlayerBuilder autoPlay(boolean value) {
        operations.add(obj -> obj.setAutoPlay(value));
        return this;
    }    
    
    public  MediaPlayerBuilder startTime(javafx.util.Duration value) {
        operations.add(obj -> obj.setStartTime(value));
        return this;
    }    
    
    public  MediaPlayerBuilder cycleCount(int value) {
        operations.add(obj -> obj.setCycleCount(value));
        return this;
    }    
    
    public MediaPlayerBuilder onErrorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Runnable>> op) {
        operations.add(obj -> op.accept(obj.onErrorProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder audioSpectrumThresholdPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.audioSpectrumThresholdProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder audioSpectrumIntervalPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.audioSpectrumIntervalProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder audioSpectrumNumBandsPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.audioSpectrumNumBandsProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder audioSpectrumListenerPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.media.AudioSpectrumListener>> op) {
        operations.add(obj -> op.accept(obj.audioSpectrumListenerProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder bufferProgressTimePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.bufferProgressTimeProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder onEndOfMediaPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Runnable>> op) {
        operations.add(obj -> op.accept(obj.onEndOfMediaProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder currentRatePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.currentRateProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder cycleDurationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.cycleDurationProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder currentCountPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyIntegerProperty> op) {
        operations.add(obj -> op.accept(obj.currentCountProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder currentTimePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.currentTimeProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder totalDurationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.totalDurationProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder statusPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.media.MediaPlayer.Status>> op) {
        operations.add(obj -> op.accept(obj.statusProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder autoPlayPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.autoPlayProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder startTimePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.startTimeProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder stopTimePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.stopTimeProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder mutePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.muteProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder onStalledPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Runnable>> op) {
        operations.add(obj -> op.accept(obj.onStalledProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder onMarkerPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.media.MediaMarkerEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMarkerProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder onPlayingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Runnable>> op) {
        operations.add(obj -> op.accept(obj.onPlayingProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder onReadyPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Runnable>> op) {
        operations.add(obj -> op.accept(obj.onReadyProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder onStoppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Runnable>> op) {
        operations.add(obj -> op.accept(obj.onStoppedProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder onHaltedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Runnable>> op) {
        operations.add(obj -> op.accept(obj.onHaltedProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder onRepeatPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Runnable>> op) {
        operations.add(obj -> op.accept(obj.onRepeatProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder onPausedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Runnable>> op) {
        operations.add(obj -> op.accept(obj.onPausedProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder errorPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.media.MediaException>> op) {
        operations.add(obj -> op.accept(obj.errorProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder volumePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.volumeProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder ratePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rateProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder balancePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.balanceProperty()));
        return this;
    }    
    
    public MediaPlayerBuilder cycleCountPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.cycleCountProperty()));
        return this;
    }
}
