
package io.github.sosuisen.jfxbuilder.graphics;


public class MouseDragEventBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.input.MouseDragEvent>> operations = new java.util.ArrayList<>();
    private MouseDragEventBuilder() {}
    

    
    public static MouseDragEventBuilder create(java.lang.Object source, javafx.event.EventTarget target, javafx.event.EventType<javafx.scene.input.MouseDragEvent> eventType, double x, double y, double screenX, double screenY, javafx.scene.input.MouseButton button, int clickCount, boolean shiftDown, boolean controlDown, boolean altDown, boolean metaDown, boolean primaryButtonDown, boolean middleButtonDown, boolean secondaryButtonDown, boolean backButtonDown, boolean forwardButtonDown, boolean synthesized, boolean popupTrigger, javafx.scene.input.PickResult pickResult, java.lang.Object gestureSource) {
        MouseDragEventBuilder builder = new MouseDragEventBuilder();
        builder.constructorArgs = new Object[]{source, target, eventType, x, y, screenX, screenY, button, clickCount, shiftDown, controlDown, altDown, metaDown, primaryButtonDown, middleButtonDown, secondaryButtonDown, backButtonDown, forwardButtonDown, synthesized, popupTrigger, pickResult, gestureSource};
        return builder;
    }


    
    public static MouseDragEventBuilder create(java.lang.Object source, javafx.event.EventTarget target, javafx.event.EventType<javafx.scene.input.MouseDragEvent> eventType, double x, double y, double screenX, double screenY, javafx.scene.input.MouseButton button, int clickCount, boolean shiftDown, boolean controlDown, boolean altDown, boolean metaDown, boolean primaryButtonDown, boolean middleButtonDown, boolean secondaryButtonDown, boolean synthesized, boolean popupTrigger, javafx.scene.input.PickResult pickResult, java.lang.Object gestureSource) {
        MouseDragEventBuilder builder = new MouseDragEventBuilder();
        builder.constructorArgs = new Object[]{source, target, eventType, x, y, screenX, screenY, button, clickCount, shiftDown, controlDown, altDown, metaDown, primaryButtonDown, middleButtonDown, secondaryButtonDown, synthesized, popupTrigger, pickResult, gestureSource};
        return builder;
    }


    
    public static MouseDragEventBuilder create(javafx.event.EventType<javafx.scene.input.MouseDragEvent> eventType, double x, double y, double screenX, double screenY, javafx.scene.input.MouseButton button, int clickCount, boolean shiftDown, boolean controlDown, boolean altDown, boolean metaDown, boolean primaryButtonDown, boolean middleButtonDown, boolean secondaryButtonDown, boolean synthesized, boolean popupTrigger, javafx.scene.input.PickResult pickResult, java.lang.Object gestureSource) {
        MouseDragEventBuilder builder = new MouseDragEventBuilder();
        builder.constructorArgs = new Object[]{eventType, x, y, screenX, screenY, button, clickCount, shiftDown, controlDown, altDown, metaDown, primaryButtonDown, middleButtonDown, secondaryButtonDown, synthesized, popupTrigger, pickResult, gestureSource};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.input.MouseDragEvent build() {
        javafx.scene.input.MouseDragEvent newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.input.MouseDragEvent> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.input.MouseDragEvent callParameterizedConstructor() {
        javafx.scene.input.MouseDragEvent newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.input.MouseDragEvent.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.input.MouseDragEvent) constructor.newInstance(constructorArgs);
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
     * Applies a function to the MouseDragEvent instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(mouseDragEvent -> mouseDragEvent.setId("Main" + mouseDragEvent.getTypeSelector()))
     * }</pre>
     * 
     * @return builder instance
     *
     */
    public MouseDragEventBuilder apply(java.util.function.Consumer<javafx.scene.input.MouseDragEvent> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.input.MouseDragEvent#setDragDetect(boolean)}
     * 
     * @return builder instance
     */    
    
    public  MouseDragEventBuilder dragDetect(boolean dragDetect) {
        operations.add(obj -> obj.setDragDetect(dragDetect));
        return this;
    }
}
