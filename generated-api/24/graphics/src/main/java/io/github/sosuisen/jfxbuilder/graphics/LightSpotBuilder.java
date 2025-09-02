
package io.github.sosuisen.jfxbuilder.graphics;


public class LightSpotBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.Light.Spot>> operations = new java.util.ArrayList<>();
    private LightSpotBuilder() {}
    

    public static LightSpotBuilder create() { return new LightSpotBuilder(); }


    
    public static LightSpotBuilder create(double x, double y, double z, double specularExponent, javafx.scene.paint.Color color) {
        LightSpotBuilder builder = new LightSpotBuilder();
        builder.constructorArgs = new Object[]{x, y, z, specularExponent, color};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.effect.Light.Spot build() {
        javafx.scene.effect.Light.Spot newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.Light.Spot();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.Light.Spot> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.Light.Spot callParameterizedConstructor() {
        javafx.scene.effect.Light.Spot newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.Light.Spot.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.Light.Spot) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Spot instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public LightSpotBuilder apply(java.util.function.Consumer<javafx.scene.effect.Light.Spot> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Light.Spot#setColor(javafx.scene.paint.Color)}
     * 
     * @return builder instance
     */    
    
    public  LightSpotBuilder color(javafx.scene.paint.Color value) {
        operations.add(obj -> obj.setColor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Light.Spot#setPointsAtX(double)}
     * 
     * @return builder instance
     */    
    
    public  LightSpotBuilder pointsAtX(double value) {
        operations.add(obj -> obj.setPointsAtX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Light.Spot#setPointsAtY(double)}
     * 
     * @return builder instance
     */    
    
    public  LightSpotBuilder pointsAtY(double value) {
        operations.add(obj -> obj.setPointsAtY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Light.Spot#setPointsAtZ(double)}
     * 
     * @return builder instance
     */    
    
    public  LightSpotBuilder pointsAtZ(double value) {
        operations.add(obj -> obj.setPointsAtZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Light.Spot#setSpecularExponent(double)}
     * 
     * @return builder instance
     */    
    
    public  LightSpotBuilder specularExponent(double value) {
        operations.add(obj -> obj.setSpecularExponent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Light.Spot#setX(double)}
     * 
     * @return builder instance
     */    
    
    public  LightSpotBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Light.Spot#setY(double)}
     * 
     * @return builder instance
     */    
    
    public  LightSpotBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Light.Spot#setZ(double)}
     * 
     * @return builder instance
     */    
    
    public  LightSpotBuilder z(double value) {
        operations.add(obj -> obj.setZ(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Spot#colorProperty()}.
     * 
     * @return builder instance
     */    
    
    public LightSpotBuilder colorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Color>> op) {
        operations.add(obj -> op.accept(obj.colorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Spot#pointsAtXProperty()}.
     * 
     * @return builder instance
     */    
    
    public LightSpotBuilder pointsAtXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pointsAtXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Spot#pointsAtYProperty()}.
     * 
     * @return builder instance
     */    
    
    public LightSpotBuilder pointsAtYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pointsAtYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Spot#pointsAtZProperty()}.
     * 
     * @return builder instance
     */    
    
    public LightSpotBuilder pointsAtZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pointsAtZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Spot#specularExponentProperty()}.
     * 
     * @return builder instance
     */    
    
    public LightSpotBuilder specularExponentPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.specularExponentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Spot#xProperty()}.
     * 
     * @return builder instance
     */    
    
    public LightSpotBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Spot#yProperty()}.
     * 
     * @return builder instance
     */    
    
    public LightSpotBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Light.Spot#zProperty()}.
     * 
     * @return builder instance
     */    
    
    public LightSpotBuilder zPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.zProperty()));
        return this;
    }
}
