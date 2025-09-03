
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code FloatMapBuilder} class constructs instances of the {@link javafx.scene.effect.FloatMap FloatMap} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.effect.FloatMap FloatMap} constructor
 * and returns an instance of the {@code FloatMapBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.effect.FloatMap FloatMap}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.effect.FloatMap FloatMap} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class FloatMapBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.FloatMap>> operations = new java.util.ArrayList<>();
    private FloatMapBuilder() {}
    

    /**
     * Returns an instance of the {@code FloatMapBuilder}.
     *
     * @return an instance of the {@code FloatMapBuilder}.
     */
    public static FloatMapBuilder create() { return new FloatMapBuilder(); }


    /**
     * Accepts the same arguments as {@link javafx.scene.effect.FloatMap#FloatMap(int width, int height) FloatMap(int, int)}
     * and returns an instance of the {@code FloatMapBuilder}.
     *
     * @return an instance of the {@code FloatMapBuilder}.
     */
    
    public static FloatMapBuilder create(int width, int height) {
        FloatMapBuilder builder = new FloatMapBuilder();
        builder.constructorArgs = new Object[]{width, height};
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
     * @return new instance of the {@link javafx.scene.effect.FloatMap FloatMap} class
     */
    public javafx.scene.effect.FloatMap build() {
        javafx.scene.effect.FloatMap newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.FloatMap();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.FloatMap> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.FloatMap callParameterizedConstructor() {
        javafx.scene.effect.FloatMap newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.FloatMap.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.FloatMap) constructor.newInstance(constructorArgs);
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
     * Applies a function to the FloatMap instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public FloatMapBuilder apply(java.util.function.Consumer<javafx.scene.effect.FloatMap> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.FloatMap#setHeight(int)}
     * 
     * @return builder instance
     */    
    
    public  FloatMapBuilder height(int value) {
        operations.add(obj -> obj.setHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.FloatMap#setSample(int, int, int, float)}
     * 
     * @return builder instance
     */    
    
    public  FloatMapBuilder sample(int x, int y, int band, float s) {
        operations.add(obj -> obj.setSample(x, y, band, s));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.FloatMap#setSamples(int, int, float)}
     * 
     * @return builder instance
     */    
    
    public  FloatMapBuilder samples(int x, int y, float s0) {
        operations.add(obj -> obj.setSamples(x, y, s0));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.FloatMap#setSamples(int, int, float, float)}
     * 
     * @return builder instance
     */    
    
    public  FloatMapBuilder samples(int x, int y, float s0, float s1) {
        operations.add(obj -> obj.setSamples(x, y, s0, s1));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.FloatMap#setSamples(int, int, float, float, float)}
     * 
     * @return builder instance
     */    
    
    public  FloatMapBuilder samples(int x, int y, float s0, float s1, float s2) {
        operations.add(obj -> obj.setSamples(x, y, s0, s1, s2));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.FloatMap#setSamples(int, int, float, float, float, float)}
     * 
     * @return builder instance
     */    
    
    public  FloatMapBuilder samples(int x, int y, float s0, float s1, float s2, float s3) {
        operations.add(obj -> obj.setSamples(x, y, s0, s1, s2, s3));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.FloatMap#setWidth(int)}
     * 
     * @return builder instance
     */    
    
    public  FloatMapBuilder width(int value) {
        operations.add(obj -> obj.setWidth(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.FloatMap#heightProperty() heightProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.FloatMap> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.heightProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .heightPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public FloatMapBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.FloatMap#widthProperty() widthProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.FloatMap> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.widthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .widthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public FloatMapBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
