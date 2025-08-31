
package io.github.sosuisen.jfxbuilder.graphics;


public class MouseEventBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.input.MouseEvent>> operations = new java.util.ArrayList<>();
    private MouseEventBuilder() {}
    

    
    public static MouseEventBuilder create(java.lang.Object source, javafx.event.EventTarget target, javafx.event.EventType<? extends javafx.scene.input.MouseEvent> eventType, double x, double y, double screenX, double screenY, javafx.scene.input.MouseButton button, int clickCount, boolean shiftDown, boolean controlDown, boolean altDown, boolean metaDown, boolean primaryButtonDown, boolean middleButtonDown, boolean secondaryButtonDown, boolean backButtonDown, boolean forwardButtonDown, boolean synthesized, boolean popupTrigger, boolean stillSincePress, javafx.scene.input.PickResult pickResult) {
        MouseEventBuilder builder = new MouseEventBuilder();
        builder.constructorArgs = new Object[]{source, target, eventType, x, y, screenX, screenY, button, clickCount, shiftDown, controlDown, altDown, metaDown, primaryButtonDown, middleButtonDown, secondaryButtonDown, backButtonDown, forwardButtonDown, synthesized, popupTrigger, stillSincePress, pickResult};
        return builder;
    }


    
    public static MouseEventBuilder create(java.lang.Object source, javafx.event.EventTarget target, javafx.event.EventType<? extends javafx.scene.input.MouseEvent> eventType, double x, double y, double screenX, double screenY, javafx.scene.input.MouseButton button, int clickCount, boolean shiftDown, boolean controlDown, boolean altDown, boolean metaDown, boolean primaryButtonDown, boolean middleButtonDown, boolean secondaryButtonDown, boolean synthesized, boolean popupTrigger, boolean stillSincePress, javafx.scene.input.PickResult pickResult) {
        MouseEventBuilder builder = new MouseEventBuilder();
        builder.constructorArgs = new Object[]{source, target, eventType, x, y, screenX, screenY, button, clickCount, shiftDown, controlDown, altDown, metaDown, primaryButtonDown, middleButtonDown, secondaryButtonDown, synthesized, popupTrigger, stillSincePress, pickResult};
        return builder;
    }


    
    public static MouseEventBuilder create(javafx.event.EventType<? extends javafx.scene.input.MouseEvent> eventType, double x, double y, double screenX, double screenY, javafx.scene.input.MouseButton button, int clickCount, boolean shiftDown, boolean controlDown, boolean altDown, boolean metaDown, boolean primaryButtonDown, boolean middleButtonDown, boolean secondaryButtonDown, boolean backButtonDown, boolean forwardButtonDown, boolean synthesized, boolean popupTrigger, boolean stillSincePress, javafx.scene.input.PickResult pickResult) {
        MouseEventBuilder builder = new MouseEventBuilder();
        builder.constructorArgs = new Object[]{eventType, x, y, screenX, screenY, button, clickCount, shiftDown, controlDown, altDown, metaDown, primaryButtonDown, middleButtonDown, secondaryButtonDown, backButtonDown, forwardButtonDown, synthesized, popupTrigger, stillSincePress, pickResult};
        return builder;
    }


    
    public static MouseEventBuilder create(javafx.event.EventType<? extends javafx.scene.input.MouseEvent> eventType, double x, double y, double screenX, double screenY, javafx.scene.input.MouseButton button, int clickCount, boolean shiftDown, boolean controlDown, boolean altDown, boolean metaDown, boolean primaryButtonDown, boolean middleButtonDown, boolean secondaryButtonDown, boolean synthesized, boolean popupTrigger, boolean stillSincePress, javafx.scene.input.PickResult pickResult) {
        MouseEventBuilder builder = new MouseEventBuilder();
        builder.constructorArgs = new Object[]{eventType, x, y, screenX, screenY, button, clickCount, shiftDown, controlDown, altDown, metaDown, primaryButtonDown, middleButtonDown, secondaryButtonDown, synthesized, popupTrigger, stillSincePress, pickResult};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.input.MouseEvent build() {
        javafx.scene.input.MouseEvent newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.input.MouseEvent> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.input.MouseEvent callParameterizedConstructor() {
        javafx.scene.input.MouseEvent newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.input.MouseEvent.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.input.MouseEvent) constructor.newInstance(constructorArgs);
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
    
    public MouseEventBuilder apply(java.util.function.Consumer<javafx.scene.input.MouseEvent> func) {
        operations.add(func);
        return this;
    }    
    
    public  MouseEventBuilder dragDetect(boolean dragDetect) {
        operations.add(obj -> obj.setDragDetect(dragDetect));
        return this;
    }
}
