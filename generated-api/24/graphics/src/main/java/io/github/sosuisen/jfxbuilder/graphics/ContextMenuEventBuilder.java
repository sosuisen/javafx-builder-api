
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code ContextMenuEventBuilder} class constructs instances of the {@link javafx.scene.input.ContextMenuEvent ContextMenuEvent} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.input.ContextMenuEvent ContextMenuEvent} constructor
 * and returns an instance of the {@code ContextMenuEventBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.input.ContextMenuEvent ContextMenuEvent}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.input.ContextMenuEvent ContextMenuEvent} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class ContextMenuEventBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.input.ContextMenuEvent>> operations = new java.util.ArrayList<>();
    private ContextMenuEventBuilder() {}
    

    /**
     * Accepts the same arguments as {@link javafx.scene.input.ContextMenuEvent#ContextMenuEvent(Object, EventTarget, EventType, double, double, double, double, boolean, PickResult) ContextMenuEvent(Object, EventTarget, EventType, double, double, double, double, boolean, PickResult)}
     * and returns an instance of the {@code ContextMenuEventBuilder}.
     *
     * @return an instance of the {@code ContextMenuEventBuilder}.
     */
    
    public static ContextMenuEventBuilder create(java.lang.Object source, javafx.event.EventTarget target, javafx.event.EventType<javafx.scene.input.ContextMenuEvent> eventType, double x, double y, double screenX, double screenY, boolean keyboardTrigger, javafx.scene.input.PickResult pickResult) {
        ContextMenuEventBuilder builder = new ContextMenuEventBuilder();
        builder.constructorArgs = new Object[]{source, target, eventType, x, y, screenX, screenY, keyboardTrigger, pickResult};
        return builder;
    }


    /**
     * Accepts the same arguments as {@link javafx.scene.input.ContextMenuEvent#ContextMenuEvent(EventType, double, double, double, double, boolean, PickResult) ContextMenuEvent(EventType, double, double, double, double, boolean, PickResult)}
     * and returns an instance of the {@code ContextMenuEventBuilder}.
     *
     * @return an instance of the {@code ContextMenuEventBuilder}.
     */
    
    public static ContextMenuEventBuilder create(javafx.event.EventType<javafx.scene.input.ContextMenuEvent> eventType, double x, double y, double screenX, double screenY, boolean keyboardTrigger, javafx.scene.input.PickResult pickResult) {
        ContextMenuEventBuilder builder = new ContextMenuEventBuilder();
        builder.constructorArgs = new Object[]{eventType, x, y, screenX, screenY, keyboardTrigger, pickResult};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.input.ContextMenuEvent} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.input.ContextMenuEvent ContextMenuEvent} class
     */
    public javafx.scene.input.ContextMenuEvent build() {
        javafx.scene.input.ContextMenuEvent newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.input.ContextMenuEvent> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.input.ContextMenuEvent callParameterizedConstructor() {
        javafx.scene.input.ContextMenuEvent newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.input.ContextMenuEvent.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.input.ContextMenuEvent) constructor.newInstance(constructorArgs);
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
     * Applies a function to the ContextMenuEvent instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public ContextMenuEventBuilder apply(java.util.function.Consumer<javafx.scene.input.ContextMenuEvent> func) {
        operations.add(func);
        return this;
    }
}
