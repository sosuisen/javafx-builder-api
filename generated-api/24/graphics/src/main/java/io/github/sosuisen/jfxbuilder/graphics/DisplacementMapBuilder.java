
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
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.DisplacementMap>> operations = new java.util.ArrayList<>();
    private DisplacementMapBuilder() {}
    

    /**
     * Returns an instance of the {@code DisplacementMapBuilder}.
     *
     * @return an instance of the {@code DisplacementMapBuilder}.
     */
    public static DisplacementMapBuilder create() { return new DisplacementMapBuilder(); }


    /**
     * Accepts the same arguments as {@link javafx.scene.effect.DisplacementMap#DisplacementMap(javafx.scene.effect.FloatMap mapData) DisplacementMap(FloatMap)}
     * and returns an instance of the {@code DisplacementMapBuilder}.
     *
     * @return an instance of the {@code DisplacementMapBuilder}.
     */
    
    public static DisplacementMapBuilder create(javafx.scene.effect.FloatMap mapData) {
        DisplacementMapBuilder builder = new DisplacementMapBuilder();
        builder.constructorArgs = new Object[]{mapData};
        return builder;
    }


    /**
     * Accepts the same arguments as {@link javafx.scene.effect.DisplacementMap#DisplacementMap(javafx.scene.effect.FloatMap mapData, double offsetX, double offsetY, double scaleX, double scaleY) DisplacementMap(FloatMap, double, double, double, double)}
     * and returns an instance of the {@code DisplacementMapBuilder}.
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
     * This method builds and returns an instance of the original class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the build() method
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
     * Applies a function to the DisplacementMap instance currently being built.
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
     * Builder method for {@link javafx.scene.effect.DisplacementMap#setInput(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  DisplacementMapBuilder input(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setInput(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.DisplacementMap#setMapData(javafx.scene.effect.FloatMap)}
     * 
     * @return builder instance
     */    
    
    public  DisplacementMapBuilder mapData(javafx.scene.effect.FloatMap value) {
        operations.add(obj -> obj.setMapData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.DisplacementMap#setOffsetX(double)}
     * 
     * @return builder instance
     */    
    
    public  DisplacementMapBuilder offsetX(double value) {
        operations.add(obj -> obj.setOffsetX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.DisplacementMap#setOffsetY(double)}
     * 
     * @return builder instance
     */    
    
    public  DisplacementMapBuilder offsetY(double value) {
        operations.add(obj -> obj.setOffsetY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.DisplacementMap#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  DisplacementMapBuilder scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.DisplacementMap#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  DisplacementMapBuilder scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.DisplacementMap#setWrap(boolean)}
     * 
     * @return builder instance
     */    
    
    public  DisplacementMapBuilder wrap(boolean value) {
        operations.add(obj -> obj.setWrap(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.DisplacementMap#inputProperty()}.
     * 
     * @return builder instance
     */    
    
    public DisplacementMapBuilder inputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.inputProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.DisplacementMap#mapDataProperty()}.
     * 
     * @return builder instance
     */    
    
    public DisplacementMapBuilder mapDataPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.FloatMap>> op) {
        operations.add(obj -> op.accept(obj.mapDataProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.DisplacementMap#offsetXProperty()}.
     * 
     * @return builder instance
     */    
    
    public DisplacementMapBuilder offsetXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.offsetXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.DisplacementMap#offsetYProperty()}.
     * 
     * @return builder instance
     */    
    
    public DisplacementMapBuilder offsetYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.offsetYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.DisplacementMap#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public DisplacementMapBuilder scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.DisplacementMap#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public DisplacementMapBuilder scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.DisplacementMap#wrapProperty()}.
     * 
     * @return builder instance
     */    
    
    public DisplacementMapBuilder wrapPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.wrapProperty()));
        return this;
    }
}
