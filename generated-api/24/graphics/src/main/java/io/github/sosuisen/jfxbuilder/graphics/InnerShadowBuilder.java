
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code InnerShadowBuilder} class constructs instances of the {@link javafx.scene.effect.InnerShadow InnerShadow} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.effect.InnerShadow InnerShadow} constructor
 * and returns an instance of the {@code InnerShadowBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.effect.InnerShadow InnerShadow}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.effect.InnerShadow InnerShadow} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class InnerShadowBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.InnerShadow>> operations = new java.util.ArrayList<>();
    private InnerShadowBuilder() {}
    

    public static InnerShadowBuilder create() { return new InnerShadowBuilder(); }


    
    public static InnerShadowBuilder create(double radius, double offsetX, double offsetY, javafx.scene.paint.Color color) {
        InnerShadowBuilder builder = new InnerShadowBuilder();
        builder.constructorArgs = new Object[]{radius, offsetX, offsetY, color};
        return builder;
    }


    
    public static InnerShadowBuilder create(double radius, javafx.scene.paint.Color color) {
        InnerShadowBuilder builder = new InnerShadowBuilder();
        builder.constructorArgs = new Object[]{radius, color};
        return builder;
    }


    
    public static InnerShadowBuilder create(javafx.scene.effect.BlurType blurType, javafx.scene.paint.Color color, double radius, double choke, double offsetX, double offsetY) {
        InnerShadowBuilder builder = new InnerShadowBuilder();
        builder.constructorArgs = new Object[]{blurType, color, radius, choke, offsetX, offsetY};
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
     * @return new instance of the {@link javafx.scene.effect.InnerShadow InnerShadow} class
     */
    public javafx.scene.effect.InnerShadow build() {
        javafx.scene.effect.InnerShadow newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.InnerShadow();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.InnerShadow> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.InnerShadow callParameterizedConstructor() {
        javafx.scene.effect.InnerShadow newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.InnerShadow.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.InnerShadow) constructor.newInstance(constructorArgs);
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
     * Applies a function to the InnerShadow instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public InnerShadowBuilder apply(java.util.function.Consumer<javafx.scene.effect.InnerShadow> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.InnerShadow#setBlurType(javafx.scene.effect.BlurType)}
     * 
     * @return builder instance
     */    
    
    public  InnerShadowBuilder blurType(javafx.scene.effect.BlurType value) {
        operations.add(obj -> obj.setBlurType(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.InnerShadow#setChoke(double)}
     * 
     * @return builder instance
     */    
    
    public  InnerShadowBuilder choke(double value) {
        operations.add(obj -> obj.setChoke(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.InnerShadow#setColor(javafx.scene.paint.Color)}
     * 
     * @return builder instance
     */    
    
    public  InnerShadowBuilder color(javafx.scene.paint.Color value) {
        operations.add(obj -> obj.setColor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.InnerShadow#setHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  InnerShadowBuilder height(double value) {
        operations.add(obj -> obj.setHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.InnerShadow#setInput(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  InnerShadowBuilder input(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setInput(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.InnerShadow#setOffsetX(double)}
     * 
     * @return builder instance
     */    
    
    public  InnerShadowBuilder offsetX(double value) {
        operations.add(obj -> obj.setOffsetX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.InnerShadow#setOffsetY(double)}
     * 
     * @return builder instance
     */    
    
    public  InnerShadowBuilder offsetY(double value) {
        operations.add(obj -> obj.setOffsetY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.InnerShadow#setRadius(double)}
     * 
     * @return builder instance
     */    
    
    public  InnerShadowBuilder radius(double value) {
        operations.add(obj -> obj.setRadius(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.InnerShadow#setWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  InnerShadowBuilder width(double value) {
        operations.add(obj -> obj.setWidth(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.InnerShadow#blurTypeProperty()}.
     * 
     * @return builder instance
     */    
    
    public InnerShadowBuilder blurTypePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlurType>> op) {
        operations.add(obj -> op.accept(obj.blurTypeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.InnerShadow#chokeProperty()}.
     * 
     * @return builder instance
     */    
    
    public InnerShadowBuilder chokePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.chokeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.InnerShadow#colorProperty()}.
     * 
     * @return builder instance
     */    
    
    public InnerShadowBuilder colorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Color>> op) {
        operations.add(obj -> op.accept(obj.colorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.InnerShadow#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public InnerShadowBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.InnerShadow#inputProperty()}.
     * 
     * @return builder instance
     */    
    
    public InnerShadowBuilder inputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.inputProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.InnerShadow#offsetXProperty()}.
     * 
     * @return builder instance
     */    
    
    public InnerShadowBuilder offsetXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.offsetXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.InnerShadow#offsetYProperty()}.
     * 
     * @return builder instance
     */    
    
    public InnerShadowBuilder offsetYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.offsetYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.InnerShadow#radiusProperty()}.
     * 
     * @return builder instance
     */    
    
    public InnerShadowBuilder radiusPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.radiusProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.InnerShadow#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public InnerShadowBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
