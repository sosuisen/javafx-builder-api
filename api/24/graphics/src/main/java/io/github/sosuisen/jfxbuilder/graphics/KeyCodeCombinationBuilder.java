
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code KeyCodeCombinationBuilder} class constructs instances of the {@link javafx.scene.input.KeyCodeCombination KeyCodeCombination} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.input.KeyCodeCombination KeyCodeCombination} constructor
 * and returns an instance of the {@code KeyCodeCombinationBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.input.KeyCodeCombination KeyCodeCombination}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.input.KeyCodeCombination KeyCodeCombination} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class KeyCodeCombinationBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.input.KeyCodeCombination>> operations = new java.util.ArrayList<>();
    private KeyCodeCombinationBuilder() {}
    
    /**
     * Accepts the constructor arguments of {@link javafx.scene.input.KeyCodeCombination#KeyCodeCombination(javafx.scene.input.KeyCode, javafx.scene.input.KeyCombination.ModifierValue, javafx.scene.input.KeyCombination.ModifierValue, javafx.scene.input.KeyCombination.ModifierValue, javafx.scene.input.KeyCombination.ModifierValue, javafx.scene.input.KeyCombination.ModifierValue) KeyCodeCombination(KeyCode, KeyCombination.ModifierValue, KeyCombination.ModifierValue, KeyCombination.ModifierValue, KeyCombination.ModifierValue, KeyCombination.ModifierValue)}
     * and returns an instance of {@code KeyCodeCombinationBuilder}.
     *
     * @return an instance of the {@code KeyCodeCombinationBuilder}.
     */
    public static KeyCodeCombinationBuilder create(javafx.scene.input.KeyCode code, javafx.scene.input.KeyCombination.ModifierValue shift, javafx.scene.input.KeyCombination.ModifierValue control, javafx.scene.input.KeyCombination.ModifierValue alt, javafx.scene.input.KeyCombination.ModifierValue meta, javafx.scene.input.KeyCombination.ModifierValue shortcut) {
        KeyCodeCombinationBuilder builder = new KeyCodeCombinationBuilder();
        builder.constructorArgs = new Object[]{code, shift, control, alt, meta, shortcut};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.input.KeyCodeCombination#KeyCodeCombination(javafx.scene.input.KeyCode, javafx.scene.input.KeyCombination.Modifier...) KeyCodeCombination(KeyCode, KeyCombination.Modifier...)}
     * and returns an instance of {@code KeyCodeCombinationBuilder}.
     *
     * @return an instance of the {@code KeyCodeCombinationBuilder}.
     */
    public static KeyCodeCombinationBuilder create(javafx.scene.input.KeyCode code, javafx.scene.input.KeyCombination.Modifier... modifiers) {
        KeyCodeCombinationBuilder builder = new KeyCodeCombinationBuilder();
        builder.constructorArgs = new Object[]{code, modifiers};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.input.KeyCodeCombination} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.input.KeyCodeCombination KeyCodeCombination} class
     */
    public javafx.scene.input.KeyCodeCombination build() {
        javafx.scene.input.KeyCodeCombination newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.input.KeyCodeCombination> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.input.KeyCodeCombination callParameterizedConstructor() {
        javafx.scene.input.KeyCodeCombination newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.input.KeyCodeCombination.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.input.KeyCodeCombination) constructor.newInstance(constructorArgs);
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
     * Applies a function to the KeyCodeCombination instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public KeyCodeCombinationBuilder apply(java.util.function.Consumer<javafx.scene.input.KeyCodeCombination> func) {
        operations.add(func);
        return this;
    }
}
