
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code MnemonicBuilder} class constructs instances of the {@link javafx.scene.input.Mnemonic Mnemonic} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.input.Mnemonic Mnemonic} constructor
 * and returns an instance of the {@code MnemonicBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.input.Mnemonic Mnemonic}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.input.Mnemonic Mnemonic} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class MnemonicBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.input.Mnemonic>> operations = new java.util.ArrayList<>();
    private MnemonicBuilder() {}
    

    /**
     * Accepts the constructor arguments of {@link javafx.scene.input.Mnemonic#Mnemonic(Node, KeyCombination) Mnemonic(Node, KeyCombination)}
     * and returns an instance of {@code MnemonicBuilder}.
     *
     * @return an instance of the {@code MnemonicBuilder}.
     */
    
    public static MnemonicBuilder create(javafx.scene.Node node, javafx.scene.input.KeyCombination keyCombination) {
        MnemonicBuilder builder = new MnemonicBuilder();
        builder.constructorArgs = new Object[]{node, keyCombination};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.input.Mnemonic} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.input.Mnemonic Mnemonic} class
     */
    public javafx.scene.input.Mnemonic build() {
        javafx.scene.input.Mnemonic newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.input.Mnemonic> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.input.Mnemonic callParameterizedConstructor() {
        javafx.scene.input.Mnemonic newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.input.Mnemonic.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.input.Mnemonic) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Mnemonic instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public MnemonicBuilder apply(java.util.function.Consumer<javafx.scene.input.Mnemonic> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.input.Mnemonic#setKeyCombination(javafx.scene.input.KeyCombination)}
     * 
     * @return builder instance
     */    
    
    public  MnemonicBuilder keyCombination(javafx.scene.input.KeyCombination keyCombination) {
        operations.add(obj -> obj.setKeyCombination(keyCombination));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.input.Mnemonic#setNode(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  MnemonicBuilder node(javafx.scene.Node node) {
        operations.add(obj -> obj.setNode(node));
        return this;
    }
}
