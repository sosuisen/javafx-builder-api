
package io.github.sosuisen.jfxbuilder.graphics;


public class TouchEventBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.input.TouchEvent>> operations = new java.util.ArrayList<>();
    private TouchEventBuilder() {}
    

    
    public static TouchEventBuilder create(java.lang.Object source, javafx.event.EventTarget target, javafx.event.EventType<javafx.scene.input.TouchEvent> eventType, javafx.scene.input.TouchPoint touchPoint, java.util.List<javafx.scene.input.TouchPoint> touchPoints, int eventSetId, boolean shiftDown, boolean controlDown, boolean altDown, boolean metaDown) {
        TouchEventBuilder builder = new TouchEventBuilder();
        builder.constructorArgs = new Object[]{source, target, eventType, touchPoint, touchPoints, eventSetId, shiftDown, controlDown, altDown, metaDown};
        return builder;
    }


    
    public static TouchEventBuilder create(javafx.event.EventType<javafx.scene.input.TouchEvent> eventType, javafx.scene.input.TouchPoint touchPoint, java.util.List<javafx.scene.input.TouchPoint> touchPoints, int eventSetId, boolean shiftDown, boolean controlDown, boolean altDown, boolean metaDown) {
        TouchEventBuilder builder = new TouchEventBuilder();
        builder.constructorArgs = new Object[]{eventType, touchPoint, touchPoints, eventSetId, shiftDown, controlDown, altDown, metaDown};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.input.TouchEvent build() {
        javafx.scene.input.TouchEvent newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.input.TouchEvent> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.input.TouchEvent callParameterizedConstructor() {
        javafx.scene.input.TouchEvent newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.input.TouchEvent.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.input.TouchEvent) constructor.newInstance(constructorArgs);
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
     * Applies a function to the TouchEvent instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(touchEvent -> touchEvent.setId("Main" + touchEvent.getTypeSelector()))
     * }</pre>
     * 
     * @return builder instance
     *
     */
    public TouchEventBuilder apply(java.util.function.Consumer<javafx.scene.input.TouchEvent> func) {
        operations.add(func);
        return this;
    }
}
