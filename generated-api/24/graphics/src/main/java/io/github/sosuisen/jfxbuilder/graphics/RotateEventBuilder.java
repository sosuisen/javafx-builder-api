
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code RotateEventBuilder} class constructs instances of the {@link javafx.scene.input.RotateEvent RotateEvent} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.input.RotateEvent RotateEvent} constructor
 * and returns an instance of the {@code RotateEventBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.input.RotateEvent RotateEvent}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.input.RotateEvent RotateEvent} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class RotateEventBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.input.RotateEvent>> operations = new java.util.ArrayList<>();
    private RotateEventBuilder() {}
    

    
    public static RotateEventBuilder create(java.lang.Object source, javafx.event.EventTarget target, javafx.event.EventType<javafx.scene.input.RotateEvent> eventType, double x, double y, double screenX, double screenY, boolean shiftDown, boolean controlDown, boolean altDown, boolean metaDown, boolean direct, boolean inertia, double angle, double totalAngle, javafx.scene.input.PickResult pickResult) {
        RotateEventBuilder builder = new RotateEventBuilder();
        builder.constructorArgs = new Object[]{source, target, eventType, x, y, screenX, screenY, shiftDown, controlDown, altDown, metaDown, direct, inertia, angle, totalAngle, pickResult};
        return builder;
    }


    
    public static RotateEventBuilder create(javafx.event.EventType<javafx.scene.input.RotateEvent> eventType, double x, double y, double screenX, double screenY, boolean shiftDown, boolean controlDown, boolean altDown, boolean metaDown, boolean direct, boolean inertia, double angle, double totalAngle, javafx.scene.input.PickResult pickResult) {
        RotateEventBuilder builder = new RotateEventBuilder();
        builder.constructorArgs = new Object[]{eventType, x, y, screenX, screenY, shiftDown, controlDown, altDown, metaDown, direct, inertia, angle, totalAngle, pickResult};
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
     * @return new instance of the {@link javafx.scene.input.RotateEvent RotateEvent} class
     */
    public javafx.scene.input.RotateEvent build() {
        javafx.scene.input.RotateEvent newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.input.RotateEvent> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.input.RotateEvent callParameterizedConstructor() {
        javafx.scene.input.RotateEvent newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.input.RotateEvent.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.input.RotateEvent) constructor.newInstance(constructorArgs);
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
     * Applies a function to the RotateEvent instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public RotateEventBuilder apply(java.util.function.Consumer<javafx.scene.input.RotateEvent> func) {
        operations.add(func);
        return this;
    }
}
