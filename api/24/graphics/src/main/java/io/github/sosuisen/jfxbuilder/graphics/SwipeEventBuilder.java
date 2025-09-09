
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code SwipeEventBuilder} class constructs instances of the {@link javafx.scene.input.SwipeEvent SwipeEvent} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.input.SwipeEvent SwipeEvent} constructor
 * and returns an instance of the {@code SwipeEventBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.input.SwipeEvent SwipeEvent}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.input.SwipeEvent SwipeEvent} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class SwipeEventBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.input.SwipeEvent>> operations = new java.util.ArrayList<>();
    private SwipeEventBuilder() {}
    
    /**
     * Accepts the constructor arguments of {@link javafx.scene.input.SwipeEvent#SwipeEvent(java.lang.Object, javafx.event.EventTarget, javafx.event.EventType, double, double, double, double, boolean, boolean, boolean, boolean, boolean, int, javafx.scene.input.PickResult) SwipeEvent(Object, EventTarget, EventType, double, double, double, double, boolean, boolean, boolean, boolean, boolean, int, PickResult)}
     * and returns an instance of {@code SwipeEventBuilder}.
     *
     * @return an instance of the {@code SwipeEventBuilder}.
     */
    public static SwipeEventBuilder create(java.lang.Object source, javafx.event.EventTarget target, javafx.event.EventType<javafx.scene.input.SwipeEvent> eventType, double x, double y, double screenX, double screenY, boolean shiftDown, boolean controlDown, boolean altDown, boolean metaDown, boolean direct, int touchCount, javafx.scene.input.PickResult pickResult) {
        SwipeEventBuilder builder = new SwipeEventBuilder();
        builder.constructorArgs = new Object[]{source, target, eventType, x, y, screenX, screenY, shiftDown, controlDown, altDown, metaDown, direct, touchCount, pickResult};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.input.SwipeEvent#SwipeEvent(javafx.event.EventType, double, double, double, double, boolean, boolean, boolean, boolean, boolean, int, javafx.scene.input.PickResult) SwipeEvent(EventType, double, double, double, double, boolean, boolean, boolean, boolean, boolean, int, PickResult)}
     * and returns an instance of {@code SwipeEventBuilder}.
     *
     * @return an instance of the {@code SwipeEventBuilder}.
     */
    public static SwipeEventBuilder create(javafx.event.EventType<javafx.scene.input.SwipeEvent> eventType, double x, double y, double screenX, double screenY, boolean shiftDown, boolean controlDown, boolean altDown, boolean metaDown, boolean direct, int touchCount, javafx.scene.input.PickResult pickResult) {
        SwipeEventBuilder builder = new SwipeEventBuilder();
        builder.constructorArgs = new Object[]{eventType, x, y, screenX, screenY, shiftDown, controlDown, altDown, metaDown, direct, touchCount, pickResult};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.input.SwipeEvent SwipeEvent} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.input.SwipeEvent SwipeEvent} class
     */
    public javafx.scene.input.SwipeEvent build() {
        javafx.scene.input.SwipeEvent newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.input.SwipeEvent> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.input.SwipeEvent callParameterizedConstructor() {
        javafx.scene.input.SwipeEvent newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.input.SwipeEvent.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.input.SwipeEvent) constructor.newInstance(constructorArgs);
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
     * Applies a function to the SwipeEvent instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public SwipeEventBuilder apply(java.util.function.Consumer<javafx.scene.input.SwipeEvent> func) {
        operations.add(func);
        return this;
    }
}
