
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code ShadowBuilder} class constructs instances of the {@link javafx.scene.effect.Shadow Shadow} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.effect.Shadow Shadow} constructor
 * and returns an instance of the {@code ShadowBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.effect.Shadow Shadow}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.effect.Shadow Shadow} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class ShadowBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.Shadow>> operations = new java.util.ArrayList<>();
    private ShadowBuilder() {}
    

    /**
     * Returns an instance of the {@code ShadowBuilder}.
     *
     * @return an instance of the {@code ShadowBuilder}.
     */
    public static ShadowBuilder create() { return new ShadowBuilder(); }


    /**
     * Accepts the same arguments as {@link javafx.scene.effect.Shadow#Shadow(double, Color) Shadow(double, Color)}
     * and returns an instance of the {@code ShadowBuilder}.
     *
     * @return an instance of the {@code ShadowBuilder}.
     */
    
    public static ShadowBuilder create(double radius, javafx.scene.paint.Color color) {
        ShadowBuilder builder = new ShadowBuilder();
        builder.constructorArgs = new Object[]{radius, color};
        return builder;
    }


    /**
     * Accepts the same arguments as {@link javafx.scene.effect.Shadow#Shadow(BlurType, Color, double) Shadow(BlurType, Color, double)}
     * and returns an instance of the {@code ShadowBuilder}.
     *
     * @return an instance of the {@code ShadowBuilder}.
     */
    
    public static ShadowBuilder create(javafx.scene.effect.BlurType blurType, javafx.scene.paint.Color color, double radius) {
        ShadowBuilder builder = new ShadowBuilder();
        builder.constructorArgs = new Object[]{blurType, color, radius};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.effect.Shadow} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.effect.Shadow Shadow} class
     */
    public javafx.scene.effect.Shadow build() {
        javafx.scene.effect.Shadow newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.Shadow();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.Shadow> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.Shadow callParameterizedConstructor() {
        javafx.scene.effect.Shadow newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.Shadow.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.Shadow) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Shadow instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public ShadowBuilder apply(java.util.function.Consumer<javafx.scene.effect.Shadow> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Shadow#setBlurType(javafx.scene.effect.BlurType)}
     * 
     * @return builder instance
     */    
    
    public  ShadowBuilder blurType(javafx.scene.effect.BlurType value) {
        operations.add(obj -> obj.setBlurType(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Shadow#setColor(javafx.scene.paint.Color)}
     * 
     * @return builder instance
     */    
    
    public  ShadowBuilder color(javafx.scene.paint.Color value) {
        operations.add(obj -> obj.setColor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Shadow#setHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  ShadowBuilder height(double value) {
        operations.add(obj -> obj.setHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Shadow#setInput(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  ShadowBuilder input(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setInput(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Shadow#setRadius(double)}
     * 
     * @return builder instance
     */    
    
    public  ShadowBuilder radius(double value) {
        operations.add(obj -> obj.setRadius(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Shadow#setWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ShadowBuilder width(double value) {
        operations.add(obj -> obj.setWidth(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Shadow#blurTypeProperty() blurTypeProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.Shadow> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.blurTypeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .blurTypePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public ShadowBuilder blurTypePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlurType>> op) {
        operations.add(obj -> op.accept(obj.blurTypeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Shadow#colorProperty() colorProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.Shadow> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.colorProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .colorPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public ShadowBuilder colorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Color>> op) {
        operations.add(obj -> op.accept(obj.colorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Shadow#heightProperty() heightProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.Shadow> func) apply} method.
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
    
    public ShadowBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Shadow#inputProperty() inputProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.Shadow> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.inputProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .inputPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public ShadowBuilder inputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.inputProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Shadow#radiusProperty() radiusProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.Shadow> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.radiusProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .radiusPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public ShadowBuilder radiusPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.radiusProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Shadow#widthProperty() widthProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.Shadow> func) apply} method.
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
    
    public ShadowBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }
}
