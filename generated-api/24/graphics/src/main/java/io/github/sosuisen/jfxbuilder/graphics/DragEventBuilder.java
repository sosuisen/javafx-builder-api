
package io.github.sosuisen.jfxbuilder.graphics;


public class DragEventBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.input.DragEvent>> operations = new java.util.ArrayList<>();
    private DragEventBuilder() {}
    

    
    public static DragEventBuilder create(java.lang.Object source, javafx.event.EventTarget target, javafx.event.EventType<javafx.scene.input.DragEvent> eventType, javafx.scene.input.Dragboard dragboard, double x, double y, double screenX, double screenY, javafx.scene.input.TransferMode transferMode, java.lang.Object gestureSource, java.lang.Object gestureTarget, javafx.scene.input.PickResult pickResult) {
        DragEventBuilder builder = new DragEventBuilder();
        builder.constructorArgs = new Object[]{source, target, eventType, dragboard, x, y, screenX, screenY, transferMode, gestureSource, gestureTarget, pickResult};
        return builder;
    }


    
    public static DragEventBuilder create(javafx.event.EventType<javafx.scene.input.DragEvent> eventType, javafx.scene.input.Dragboard dragboard, double x, double y, double screenX, double screenY, javafx.scene.input.TransferMode transferMode, java.lang.Object gestureSource, java.lang.Object gestureTarget, javafx.scene.input.PickResult pickResult) {
        DragEventBuilder builder = new DragEventBuilder();
        builder.constructorArgs = new Object[]{eventType, dragboard, x, y, screenX, screenY, transferMode, gestureSource, gestureTarget, pickResult};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.input.DragEvent build() {
        javafx.scene.input.DragEvent newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.input.DragEvent> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.input.DragEvent callParameterizedConstructor() {
        javafx.scene.input.DragEvent newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.input.DragEvent.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.input.DragEvent) constructor.newInstance(constructorArgs);
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
     * Applies a function to the DragEvent instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(dragEvent -> dragEvent.setId("Main" + dragEvent.getTypeSelector()))
     * }</pre>
     * 
     * @return builder instance
     *
     */
    public DragEventBuilder apply(java.util.function.Consumer<javafx.scene.input.DragEvent> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.input.DragEvent#setDropCompleted(boolean)}
     * 
     * @return builder instance
     */    
    
    public  DragEventBuilder dropCompleted(boolean isTransferDone) {
        operations.add(obj -> obj.setDropCompleted(isTransferDone));
        return this;
    }
}
