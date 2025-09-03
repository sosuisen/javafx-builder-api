
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code TranslateBuilder} class constructs instances of the {@link javafx.scene.transform.Translate Translate} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.transform.Translate Translate} constructor
 * and returns an instance of the {@code TranslateBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.transform.Translate Translate}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.transform.Translate Translate} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class TranslateBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.transform.Translate>> operations = new java.util.ArrayList<>();
    private TranslateBuilder() {}
    

    /**
     * Returns an instance of the {@code TranslateBuilder}.
     *
     * @return an instance of the {@code TranslateBuilder}.
     */
    public static TranslateBuilder create() { return new TranslateBuilder(); }


    /**
     * Accepts the constructor arguments of {@link javafx.scene.transform.Translate#Translate(double, double) Translate(double, double)}
     * and returns an instance of {@code TranslateBuilder}.
     *
     * @return an instance of the {@code TranslateBuilder}.
     */
    
    public static TranslateBuilder create(double x, double y) {
        TranslateBuilder builder = new TranslateBuilder();
        builder.constructorArgs = new Object[]{x, y};
        return builder;
    }


    /**
     * Accepts the constructor arguments of {@link javafx.scene.transform.Translate#Translate(double, double, double) Translate(double, double, double)}
     * and returns an instance of {@code TranslateBuilder}.
     *
     * @return an instance of the {@code TranslateBuilder}.
     */
    
    public static TranslateBuilder create(double x, double y, double z) {
        TranslateBuilder builder = new TranslateBuilder();
        builder.constructorArgs = new Object[]{x, y, z};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.transform.Translate} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.transform.Translate Translate} class
     */
    public javafx.scene.transform.Translate build() {
        javafx.scene.transform.Translate newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.transform.Translate();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.transform.Translate> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.transform.Translate callParameterizedConstructor() {
        javafx.scene.transform.Translate newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.transform.Translate.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.transform.Translate) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Translate instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TranslateBuilder apply(java.util.function.Consumer<javafx.scene.transform.Translate> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Translate#setOnTransformChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  TranslateBuilder onTransformChanged(javafx.event.EventHandler<? super javafx.scene.transform.TransformChangedEvent> value) {
        operations.add(obj -> obj.setOnTransformChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Translate#setX(double)}
     * 
     * @return builder instance
     */    
    
    public  TranslateBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Translate#setY(double)}
     * 
     * @return builder instance
     */    
    
    public  TranslateBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Translate#setZ(double)}
     * 
     * @return builder instance
     */    
    
    public  TranslateBuilder z(double value) {
        operations.add(obj -> obj.setZ(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Translate#identityProperty() identityProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Translate> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.identityProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .identityPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public TranslateBuilder identityPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.identityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Translate#onTransformChangedProperty() onTransformChangedProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Translate> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onTransformChangedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onTransformChangedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public TranslateBuilder onTransformChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.transform.TransformChangedEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTransformChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Translate#type2DProperty() type2DProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Translate> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.type2DProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .type2DPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public TranslateBuilder type2DPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.type2DProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Translate#xProperty() xProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Translate> func) apply} method.
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
    
    public TranslateBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Translate#yProperty() yProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Translate> func) apply} method.
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
    
    public TranslateBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Translate#zProperty() zProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.transform.Translate> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.zProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .zPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public TranslateBuilder zPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.zProperty()));
        return this;
    }
}
