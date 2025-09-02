
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code DropShadowBuilder} class constructs instances of the {@link javafx.scene.effect.DropShadow DropShadow} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.effect.DropShadow DropShadow} constructor
 * and returns an instance of the {@code DropShadowBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.effect.DropShadow DropShadow}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.effect.DropShadow DropShadow} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class DropShadowBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.DropShadow>> operations = new java.util.ArrayList<>();
    private DropShadowBuilder() {}
    

    /**
     * Returns an instance of the {@code DropShadowBuilder}.
     *
     * @return an instance of the {@code DropShadowBuilder}.
     */
    public static DropShadowBuilder create() { return new DropShadowBuilder(); }


    /**
     * Accepts the same arguments as {@link javafx.scene.effect.DropShadow#DropShadow(double radius, double offsetX, double offsetY, javafx.scene.paint.Color color) DropShadow(double, double, double, Color)}
     * and returns an instance of the {@code DropShadowBuilder}.
     *
     * @return an instance of the {@code DropShadowBuilder}.
     */
    
    public static DropShadowBuilder create(double radius, double offsetX, double offsetY, javafx.scene.paint.Color color) {
        DropShadowBuilder builder = new DropShadowBuilder();
        builder.constructorArgs = new Object[]{radius, offsetX, offsetY, color};
        return builder;
    }


    /**
     * Accepts the same arguments as {@link javafx.scene.effect.DropShadow#DropShadow(double radius, javafx.scene.paint.Color color) DropShadow(double, Color)}
     * and returns an instance of the {@code DropShadowBuilder}.
     *
     * @return an instance of the {@code DropShadowBuilder}.
     */
    
    public static DropShadowBuilder create(double radius, javafx.scene.paint.Color color) {
        DropShadowBuilder builder = new DropShadowBuilder();
        builder.constructorArgs = new Object[]{radius, color};
        return builder;
    }


    /**
     * Accepts the same arguments as {@link javafx.scene.effect.DropShadow#DropShadow(javafx.scene.effect.BlurType blurType, javafx.scene.paint.Color color, double radius, double spread, double offsetX, double offsetY) DropShadow(BlurType, Color, double, double, double, double)}
     * and returns an instance of the {@code DropShadowBuilder}.
     *
     * @return an instance of the {@code DropShadowBuilder}.
     */
    
    public static DropShadowBuilder create(javafx.scene.effect.BlurType blurType, javafx.scene.paint.Color color, double radius, double spread, double offsetX, double offsetY) {
        DropShadowBuilder builder = new DropShadowBuilder();
        builder.constructorArgs = new Object[]{blurType, color, radius, spread, offsetX, offsetY};
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
     * @return new instance of the {@link javafx.scene.effect.DropShadow DropShadow} class
     */
    public javafx.scene.effect.DropShadow build() {
        javafx.scene.effect.DropShadow newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.DropShadow();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.DropShadow> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.DropShadow callParameterizedConstructor() {
        javafx.scene.effect.DropShadow newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.DropShadow.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.DropShadow) constructor.newInstance(constructorArgs);
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
     * Applies a function to the DropShadow instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public DropShadowBuilder apply(java.util.function.Consumer<javafx.scene.effect.DropShadow> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.DropShadow#setBlurType(javafx.scene.effect.BlurType)}
     * 
     * @return builder instance
     */    
    
    public  DropShadowBuilder blurType(javafx.scene.effect.BlurType value) {
        operations.add(obj -> obj.setBlurType(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.DropShadow#setColor(javafx.scene.paint.Color)}
     * 
     * @return builder instance
     */    
    
    public  DropShadowBuilder color(javafx.scene.paint.Color value) {
        operations.add(obj -> obj.setColor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.DropShadow#setHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  DropShadowBuilder height(double value) {
        operations.add(obj -> obj.setHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.DropShadow#setInput(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  DropShadowBuilder input(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setInput(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.DropShadow#setOffsetX(double)}
     * 
     * @return builder instance
     */    
    
    public  DropShadowBuilder offsetX(double value) {
        operations.add(obj -> obj.setOffsetX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.DropShadow#setOffsetY(double)}
     * 
     * @return builder instance
     */    
    
    public  DropShadowBuilder offsetY(double value) {
        operations.add(obj -> obj.setOffsetY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.DropShadow#setRadius(double)}
     * 
     * @return builder instance
     */    
    
    public  DropShadowBuilder radius(double value) {
        operations.add(obj -> obj.setRadius(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.DropShadow#setSpread(double)}
     * 
     * @return builder instance
     */    
    
    public  DropShadowBuilder spread(double value) {
        operations.add(obj -> obj.setSpread(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.DropShadow#setWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  DropShadowBuilder width(double value) {
        operations.add(obj -> obj.setWidth(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.DropShadow#blurTypeProperty()}.
     * 
     * @return builder instance
     */    
    
    public DropShadowBuilder blurTypePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlurType>> op) {
        operations.add(obj -> op.accept(obj.blurTypeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.DropShadow#colorProperty()}.
     * 
     * @return builder instance
     */    
    
    public DropShadowBuilder colorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Color>> op) {
        operations.add(obj -> op.accept(obj.colorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.DropShadow#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public DropShadowBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.DropShadow#inputProperty()}.
     * 
     * @return builder instance
     */    
    
    public DropShadowBuilder inputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.inputProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.DropShadow#offsetXProperty()}.
     * 
     * @return builder instance
     */    
    
    public DropShadowBuilder offsetXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.offsetXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.DropShadow#offsetYProperty()}.
     * 
     * @return builder instance
     */    
    
    public DropShadowBuilder offsetYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.offsetYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.DropShadow#radiusProperty()}.
     * 
     * @return builder instance
     */    
    
    public DropShadowBuilder radiusPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.radiusProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.DropShadow#spreadProperty()}.
     * 
     * @return builder instance
     */    
    
    public DropShadowBuilder spreadPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.spreadProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.DropShadow#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public DropShadowBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
