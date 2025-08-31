
package io.github.sosuisen.jfxbuilder.media;


public class MediaBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.media.Media>> operations = new java.util.ArrayList<>();
    private MediaBuilder() {}
    

    
    public static MediaBuilder create(java.lang.String source) {
        MediaBuilder builder = new MediaBuilder();
        builder.constructorArgs = new Object[]{source};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.media.Media build() {
        javafx.scene.media.Media newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.media.Media> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.media.Media callParameterizedConstructor() {
        javafx.scene.media.Media newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.media.Media.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.media.Media) constructor.newInstance(constructorArgs);
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
    
    public MediaBuilder apply(java.util.function.Consumer<javafx.scene.media.Media> func) {
        operations.add(func);
        return this;
    }    
    
    public  MediaBuilder onError(java.lang.Runnable value) {
        operations.add(obj -> obj.setOnError(value));
        return this;
    }
    @SafeVarargs
    public final MediaBuilder addTracks(javafx.scene.media.Track... elements) {
        operations.add(obj -> {
            obj.getTracks().addAll(elements);
        });
        return this;
    }

    public final MediaBuilder addTracks(java.util.Collection<? extends javafx.scene.media.Track> col) {
        operations.add(obj -> {
            obj.getTracks().addAll(col);
        });
        return this;
    }

    
    
    public MediaBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyIntegerProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    
    public MediaBuilder errorPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.media.MediaException>> op) {
        operations.add(obj -> op.accept(obj.errorProperty()));
        return this;
    }    
    
    public MediaBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyIntegerProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    
    public MediaBuilder onErrorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.Runnable>> op) {
        operations.add(obj -> op.accept(obj.onErrorProperty()));
        return this;
    }    
    
    public MediaBuilder durationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.util.Duration>> op) {
        operations.add(obj -> op.accept(obj.durationProperty()));
        return this;
    }
}
