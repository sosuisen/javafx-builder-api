
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code KeyEventBuilder} class constructs instances of the {@link javafx.scene.input.KeyEvent KeyEvent} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.input.KeyEvent KeyEvent} constructor
 * and returns an instance of the {@code KeyEventBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.input.KeyEvent KeyEvent}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.input.KeyEvent KeyEvent} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class KeyEventBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.input.KeyEvent>> operations = new java.util.ArrayList<>();
    private KeyEventBuilder() {}
    

    /**
     * Accepts the constructor arguments of {@link javafx.scene.input.KeyEvent#KeyEvent(Object, EventTarget, EventType, String, String, KeyCode, boolean, boolean, boolean, boolean) KeyEvent(Object, EventTarget, EventType, String, String, KeyCode, boolean, boolean, boolean, boolean)}
     * and returns an instance of {@code KeyEventBuilder}.
     *
     * @return an instance of the {@code KeyEventBuilder}.
     */
    
    public static KeyEventBuilder create(java.lang.Object source, javafx.event.EventTarget target, javafx.event.EventType<javafx.scene.input.KeyEvent> eventType, java.lang.String character, java.lang.String text, javafx.scene.input.KeyCode code, boolean shiftDown, boolean controlDown, boolean altDown, boolean metaDown) {
        KeyEventBuilder builder = new KeyEventBuilder();
        builder.constructorArgs = new Object[]{source, target, eventType, character, text, code, shiftDown, controlDown, altDown, metaDown};
        return builder;
    }


    /**
     * Accepts the constructor arguments of {@link javafx.scene.input.KeyEvent#KeyEvent(EventType, String, String, KeyCode, boolean, boolean, boolean, boolean) KeyEvent(EventType, String, String, KeyCode, boolean, boolean, boolean, boolean)}
     * and returns an instance of {@code KeyEventBuilder}.
     *
     * @return an instance of the {@code KeyEventBuilder}.
     */
    
    public static KeyEventBuilder create(javafx.event.EventType<javafx.scene.input.KeyEvent> eventType, java.lang.String character, java.lang.String text, javafx.scene.input.KeyCode code, boolean shiftDown, boolean controlDown, boolean altDown, boolean metaDown) {
        KeyEventBuilder builder = new KeyEventBuilder();
        builder.constructorArgs = new Object[]{eventType, character, text, code, shiftDown, controlDown, altDown, metaDown};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.input.KeyEvent} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.input.KeyEvent KeyEvent} class
     */
    public javafx.scene.input.KeyEvent build() {
        javafx.scene.input.KeyEvent newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.input.KeyEvent> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.input.KeyEvent callParameterizedConstructor() {
        javafx.scene.input.KeyEvent newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.input.KeyEvent.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.input.KeyEvent) constructor.newInstance(constructorArgs);
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
     * Applies a function to the KeyEvent instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public KeyEventBuilder apply(java.util.function.Consumer<javafx.scene.input.KeyEvent> func) {
        operations.add(func);
        return this;
    }
}
