
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code ShearBuilder} class constructs instances of the {@link javafx.scene.transform.Shear Shear} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.transform.Shear Shear} constructor
 * and returns an instance of the {@code ShearBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.transform.Shear Shear}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.transform.Shear Shear} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class ShearBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.transform.Shear>> operations = new java.util.ArrayList<>();
    private ShearBuilder() {}
    

    public static ShearBuilder create() { return new ShearBuilder(); }


    
    public static ShearBuilder create(double x, double y) {
        ShearBuilder builder = new ShearBuilder();
        builder.constructorArgs = new Object[]{x, y};
        return builder;
    }


    
    public static ShearBuilder create(double x, double y, double pivotX, double pivotY) {
        ShearBuilder builder = new ShearBuilder();
        builder.constructorArgs = new Object[]{x, y, pivotX, pivotY};
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
     * @return new instance of the {@link javafx.scene.transform.Shear Shear} class
     */
    public javafx.scene.transform.Shear build() {
        javafx.scene.transform.Shear newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.transform.Shear();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.transform.Shear> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.transform.Shear callParameterizedConstructor() {
        javafx.scene.transform.Shear newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.transform.Shear.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.transform.Shear) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Shear instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public ShearBuilder apply(java.util.function.Consumer<javafx.scene.transform.Shear> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Shear#setOnTransformChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ShearBuilder onTransformChanged(javafx.event.EventHandler<? super javafx.scene.transform.TransformChangedEvent> value) {
        operations.add(obj -> obj.setOnTransformChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Shear#setPivotX(double)}
     * 
     * @return builder instance
     */    
    
    public  ShearBuilder pivotX(double value) {
        operations.add(obj -> obj.setPivotX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Shear#setPivotY(double)}
     * 
     * @return builder instance
     */    
    
    public  ShearBuilder pivotY(double value) {
        operations.add(obj -> obj.setPivotY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Shear#setX(double)}
     * 
     * @return builder instance
     */    
    
    public  ShearBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Shear#setY(double)}
     * 
     * @return builder instance
     */    
    
    public  ShearBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Shear#identityProperty()}.
     * 
     * @return builder instance
     */    
    
    public ShearBuilder identityPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.identityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Shear#onTransformChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ShearBuilder onTransformChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.transform.TransformChangedEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTransformChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Shear#pivotXProperty()}.
     * 
     * @return builder instance
     */    
    
    public ShearBuilder pivotXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pivotXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Shear#pivotYProperty()}.
     * 
     * @return builder instance
     */    
    
    public ShearBuilder pivotYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pivotYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Shear#type2DProperty()}.
     * 
     * @return builder instance
     */    
    
    public ShearBuilder type2DPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.type2DProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Shear#xProperty()}.
     * 
     * @return builder instance
     */    
    
    public ShearBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Shear#yProperty()}.
     * 
     * @return builder instance
     */    
    
    public ShearBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
