
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code ImageInputBuilder} class constructs instances of the {@link javafx.scene.effect.ImageInput ImageInput} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.effect.ImageInput ImageInput} constructor
 * and returns an instance of the {@code ImageInputBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.effect.ImageInput ImageInput}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.effect.ImageInput ImageInput} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class ImageInputBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.ImageInput>> operations = new java.util.ArrayList<>();
    private ImageInputBuilder() {}
    

    /**
     * Returns an instance of the {@code ImageInputBuilder}.
     *
     * @return an instance of the {@code ImageInputBuilder}.
     */
    public static ImageInputBuilder create() { return new ImageInputBuilder(); }


    /**
     * Accepts the same arguments as {@link javafx.scene.effect.ImageInput#ImageInput(javafx.scene.image.Image source) ImageInput(Image)}
     * and returns an instance of the {@code ImageInputBuilder}.
     *
     * @return an instance of the {@code ImageInputBuilder}.
     */
    
    public static ImageInputBuilder create(javafx.scene.image.Image source) {
        ImageInputBuilder builder = new ImageInputBuilder();
        builder.constructorArgs = new Object[]{source};
        return builder;
    }


    /**
     * Accepts the same arguments as {@link javafx.scene.effect.ImageInput#ImageInput(javafx.scene.image.Image source, double x, double y) ImageInput(Image, double, double)}
     * and returns an instance of the {@code ImageInputBuilder}.
     *
     * @return an instance of the {@code ImageInputBuilder}.
     */
    
    public static ImageInputBuilder create(javafx.scene.image.Image source, double x, double y) {
        ImageInputBuilder builder = new ImageInputBuilder();
        builder.constructorArgs = new Object[]{source, x, y};
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
     * @return new instance of the {@link javafx.scene.effect.ImageInput ImageInput} class
     */
    public javafx.scene.effect.ImageInput build() {
        javafx.scene.effect.ImageInput newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.ImageInput();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.ImageInput> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.ImageInput callParameterizedConstructor() {
        javafx.scene.effect.ImageInput newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.ImageInput.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.ImageInput) constructor.newInstance(constructorArgs);
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
     * Applies a function to the ImageInput instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public ImageInputBuilder apply(java.util.function.Consumer<javafx.scene.effect.ImageInput> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.ImageInput#setSource(javafx.scene.image.Image)}
     * 
     * @return builder instance
     */    
    
    public  ImageInputBuilder source(javafx.scene.image.Image value) {
        operations.add(obj -> obj.setSource(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.ImageInput#setX(double)}
     * 
     * @return builder instance
     */    
    
    public  ImageInputBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.ImageInput#setY(double)}
     * 
     * @return builder instance
     */    
    
    public  ImageInputBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.ImageInput#sourceProperty()}.
     * 
     * @return builder instance
     */    
    
    public ImageInputBuilder sourcePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.image.Image>> op) {
        operations.add(obj -> op.accept(obj.sourceProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.ImageInput#xProperty()}.
     * 
     * @return builder instance
     */    
    
    public ImageInputBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.ImageInput#yProperty()}.
     * 
     * @return builder instance
     */    
    
    public ImageInputBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
