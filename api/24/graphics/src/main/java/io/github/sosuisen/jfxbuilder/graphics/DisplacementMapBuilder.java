
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code DisplacementMapBuilder} class constructs instances of the {@link javafx.scene.effect.DisplacementMap DisplacementMap} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.effect.DisplacementMap DisplacementMap} constructor
 * and returns an instance of the {@code DisplacementMapBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.effect.DisplacementMap DisplacementMap}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.effect.DisplacementMap DisplacementMap} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class DisplacementMapBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.effect.DisplacementMap>> operations = new java.util.ArrayList<>();
    private DisplacementMapBuilder() {}
    
    /**
     * Returns an instance of the {@code DisplacementMapBuilder}.
     *
     * @return an instance of the {@code DisplacementMapBuilder}.
     */
    public static DisplacementMapBuilder create() { return new DisplacementMapBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.effect.DisplacementMap#DisplacementMap(javafx.scene.effect.FloatMap) DisplacementMap(FloatMap)}
     * and returns an instance of {@code DisplacementMapBuilder}.
     *
     * @return an instance of the {@code DisplacementMapBuilder}.
     */
    public static DisplacementMapBuilder create(javafx.scene.effect.FloatMap mapData) {
        DisplacementMapBuilder builder = new DisplacementMapBuilder();
        builder.constructorArgs = new Object[]{mapData};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.effect.DisplacementMap#DisplacementMap(javafx.scene.effect.FloatMap, double, double, double, double) DisplacementMap(FloatMap, double, double, double, double)}
     * and returns an instance of {@code DisplacementMapBuilder}.
     *
     * @return an instance of the {@code DisplacementMapBuilder}.
     */
    public static DisplacementMapBuilder create(javafx.scene.effect.FloatMap mapData, double offsetX, double offsetY, double scaleX, double scaleY) {
        DisplacementMapBuilder builder = new DisplacementMapBuilder();
        builder.constructorArgs = new Object[]{mapData, offsetX, offsetY, scaleX, scaleY};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.effect.DisplacementMap} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.effect.DisplacementMap DisplacementMap} class
     */
    public javafx.scene.effect.DisplacementMap build() {
        javafx.scene.effect.DisplacementMap newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.DisplacementMap();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.DisplacementMap> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.DisplacementMap callParameterizedConstructor() {
        javafx.scene.effect.DisplacementMap newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.DisplacementMap.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.DisplacementMap) constructor.newInstance(constructorArgs);
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
     * Applies a function to the DisplacementMap instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public DisplacementMapBuilder apply(java.util.function.Consumer<javafx.scene.effect.DisplacementMap> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.DisplacementMap#setInput(javafx.scene.effect.Effect) setInput} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  DisplacementMapBuilder input(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setInput(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.DisplacementMap#setMapData(javafx.scene.effect.FloatMap) setMapData} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  DisplacementMapBuilder mapData(javafx.scene.effect.FloatMap value) {
        operations.add(obj -> obj.setMapData(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.DisplacementMap#setOffsetX(double) setOffsetX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  DisplacementMapBuilder offsetX(double value) {
        operations.add(obj -> obj.setOffsetX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.DisplacementMap#setOffsetY(double) setOffsetY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  DisplacementMapBuilder offsetY(double value) {
        operations.add(obj -> obj.setOffsetY(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.DisplacementMap#setScaleX(double) setScaleX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  DisplacementMapBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.DisplacementMap#setScaleY(double) setScaleY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  DisplacementMapBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.effect.DisplacementMap#setWrap(boolean) setWrap} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  DisplacementMapBuilder wrap(boolean value) {
        operations.add(obj -> obj.setWrap(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.DisplacementMap#inputProperty() inputProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link DisplacementMapBuilder#apply(java.util.function.Consumer) apply} method.
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
    public DisplacementMapBuilder inputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.inputProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.DisplacementMap#mapDataProperty() mapDataProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link DisplacementMapBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.mapDataProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .mapDataPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public DisplacementMapBuilder mapDataPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.FloatMap>> op) {
        operations.add(obj -> op.accept(obj.mapDataProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.DisplacementMap#offsetXProperty() offsetXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link DisplacementMapBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.offsetXProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .offsetXPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public DisplacementMapBuilder offsetXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.offsetXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.DisplacementMap#offsetYProperty() offsetYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link DisplacementMapBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.offsetYProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .offsetYPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public DisplacementMapBuilder offsetYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.offsetYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.DisplacementMap#scaleXProperty() scaleXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link DisplacementMapBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.scaleXProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .scaleXPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public DisplacementMapBuilder scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.DisplacementMap#scaleYProperty() scaleYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link DisplacementMapBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.scaleYProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .scaleYPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public DisplacementMapBuilder scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.effect.DisplacementMap#wrapProperty() wrapProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link DisplacementMapBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.wrapProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .wrapPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public DisplacementMapBuilder wrapPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.wrapProperty()));
        return this;
    }
}
