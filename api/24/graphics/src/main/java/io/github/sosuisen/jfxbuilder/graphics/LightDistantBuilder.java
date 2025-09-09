
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code LightDistantBuilder} class constructs instances of the {@link javafx.scene.effect.Light.Distant Distant} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.effect.Light.Distant Distant} constructor
 * and returns an instance of the {@code LightDistantBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.effect.Light.Distant Distant}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.effect.Light.Distant Distant} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class LightDistantBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.effect.Light.Distant>> operations = new java.util.ArrayList<>();
    private LightDistantBuilder() {}
    
    /**
     * Returns an instance of the {@code LightDistantBuilder}.
     *
     * @return an instance of the {@code LightDistantBuilder}.
     */
    public static LightDistantBuilder create() { return new LightDistantBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.effect.Light.Distant#Distant(double, double, javafx.scene.paint.Color) Distant(double, double, Color)}
     * and returns an instance of {@code LightDistantBuilder}.
     *
     * @return an instance of the {@code LightDistantBuilder}.
     */
    public static LightDistantBuilder create(double azimuth, double elevation, javafx.scene.paint.Color color) {
        LightDistantBuilder builder = new LightDistantBuilder();
        builder.constructorArgs = new Object[]{azimuth, elevation, color};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.effect.Light.Distant Distant} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.effect.Light.Distant Distant} class
     */
    public javafx.scene.effect.Light.Distant build() {
        javafx.scene.effect.Light.Distant newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.Light.Distant();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.Light.Distant> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.Light.Distant callParameterizedConstructor() {
        javafx.scene.effect.Light.Distant newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.Light.Distant.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.Light.Distant) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Distant instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public LightDistantBuilder apply(java.util.function.Consumer<javafx.scene.effect.Light.Distant> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.Light.Distant#setAzimuth(double) setAzimuth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  LightDistantBuilder azimuth(double value) {
        operations.add(obj -> obj.setAzimuth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.Light#setColor(javafx.scene.paint.Color) setColor} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  LightDistantBuilder color(javafx.scene.paint.Color value) {
        operations.add(obj -> obj.setColor(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.Light.Distant#setElevation(double) setElevation} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  LightDistantBuilder elevation(double value) {
        operations.add(obj -> obj.setElevation(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Distant#azimuthProperty() azimuthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link LightDistantBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.azimuthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .azimuthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public LightDistantBuilder azimuthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.azimuthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.Light#colorProperty() colorProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link LightDistantBuilder#apply(java.util.function.Consumer) apply} method.
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
    public LightDistantBuilder colorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Color>> op) {
        operations.add(obj -> op.accept(obj.colorProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Distant#elevationProperty() elevationProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link LightDistantBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.elevationProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .elevationPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public LightDistantBuilder elevationPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.elevationProperty()));
        return this;
    }
}
