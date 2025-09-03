
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code ColorInputBuilder} class constructs instances of the {@link javafx.scene.effect.ColorInput ColorInput} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.effect.ColorInput ColorInput} constructor
 * and returns an instance of the {@code ColorInputBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.effect.ColorInput ColorInput}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.effect.ColorInput ColorInput} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class ColorInputBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.ColorInput>> operations = new java.util.ArrayList<>();
    private ColorInputBuilder() {}
    

    /**
     * Returns an instance of the {@code ColorInputBuilder}.
     *
     * @return an instance of the {@code ColorInputBuilder}.
     */
    public static ColorInputBuilder create() { return new ColorInputBuilder(); }


    /**
     * Accepts the same arguments as {@link javafx.scene.effect.ColorInput#ColorInput(double x, double y, double width, double height, javafx.scene.paint.Paint paint) ColorInput(double, double, double, double, Paint)}
     * and returns an instance of the {@code ColorInputBuilder}.
     *
     * @return an instance of the {@code ColorInputBuilder}.
     */
    
    public static ColorInputBuilder create(double x, double y, double width, double height, javafx.scene.paint.Paint paint) {
        ColorInputBuilder builder = new ColorInputBuilder();
        builder.constructorArgs = new Object[]{x, y, width, height, paint};
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
     * @return new instance of the {@link javafx.scene.effect.ColorInput ColorInput} class
     */
    public javafx.scene.effect.ColorInput build() {
        javafx.scene.effect.ColorInput newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.ColorInput();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.ColorInput> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.ColorInput callParameterizedConstructor() {
        javafx.scene.effect.ColorInput newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.ColorInput.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.ColorInput) constructor.newInstance(constructorArgs);
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
     * Applies a function to the ColorInput instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public ColorInputBuilder apply(java.util.function.Consumer<javafx.scene.effect.ColorInput> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.ColorInput#setHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  ColorInputBuilder height(double value) {
        operations.add(obj -> obj.setHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.ColorInput#setPaint(javafx.scene.paint.Paint)}
     * 
     * @return builder instance
     */    
    
    public  ColorInputBuilder paint(javafx.scene.paint.Paint value) {
        operations.add(obj -> obj.setPaint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.ColorInput#setWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ColorInputBuilder width(double value) {
        operations.add(obj -> obj.setWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.ColorInput#setX(double)}
     * 
     * @return builder instance
     */    
    
    public  ColorInputBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.ColorInput#setY(double)}
     * 
     * @return builder instance
     */    
    
    public  ColorInputBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.ColorInput#heightProperty() heightProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.ColorInput> func) apply} method.
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
    
    public ColorInputBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.ColorInput#paintProperty() paintProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.ColorInput> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.paintProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .paintPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public ColorInputBuilder paintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Paint>> op) {
        operations.add(obj -> op.accept(obj.paintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.ColorInput#widthProperty() widthProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.ColorInput> func) apply} method.
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
    
    public ColorInputBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.ColorInput#xProperty() xProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.ColorInput> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.xProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .xPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public ColorInputBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.ColorInput#yProperty() yProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.effect.ColorInput> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.yProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .yPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public ColorInputBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
