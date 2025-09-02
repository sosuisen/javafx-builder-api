
package io.github.sosuisen.jfxbuilder.graphics;


public class LightPointBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.Light.Point>> operations = new java.util.ArrayList<>();
    private LightPointBuilder() {}
    

    public static LightPointBuilder create() { return new LightPointBuilder(); }


    
    public static LightPointBuilder create(double x, double y, double z, javafx.scene.paint.Color color) {
        LightPointBuilder builder = new LightPointBuilder();
        builder.constructorArgs = new Object[]{x, y, z, color};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.effect.Light.Point build() {
        javafx.scene.effect.Light.Point newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.Light.Point();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.Light.Point> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.Light.Point callParameterizedConstructor() {
        javafx.scene.effect.Light.Point newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.Light.Point.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.Light.Point) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Point instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(point -> point.setId("Main" + point.getTypeSelector()))
     * }</pre>
     * 
     * @return builder instance
     *
     */
    public LightPointBuilder apply(java.util.function.Consumer<javafx.scene.effect.Light.Point> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Light.Point#setColor(javafx.scene.paint.Color)}
     * 
     * @return builder instance
     */    
    
    public  LightPointBuilder color(javafx.scene.paint.Color value) {
        operations.add(obj -> obj.setColor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Light.Point#setX(double)}
     * 
     * @return builder instance
     */    
    
    public  LightPointBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Light.Point#setY(double)}
     * 
     * @return builder instance
     */    
    
    public  LightPointBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Light.Point#setZ(double)}
     * 
     * @return builder instance
     */    
    
    public  LightPointBuilder z(double value) {
        operations.add(obj -> obj.setZ(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Point#colorProperty()}.
     * 
     * @return builder instance
     */    
    
    public LightPointBuilder colorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Color>> op) {
        operations.add(obj -> op.accept(obj.colorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Point#xProperty()}.
     * 
     * @return builder instance
     */    
    
    public LightPointBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Point#yProperty()}.
     * 
     * @return builder instance
     */    
    
    public LightPointBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Point#zProperty()}.
     * 
     * @return builder instance
     */    
    
    public LightPointBuilder zPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.zProperty()));
        return this;
    }
}
