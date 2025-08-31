
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
    
    public LightSpotBuilder apply(java.util.function.Consumer<javafx.scene.effect.Light.Spot> func) {
        operations.add(func);
        return this;
    }    
    
    public  LightSpotBuilder specularExponent(double value) {
        operations.add(obj -> obj.setSpecularExponent(value));
        return this;
    }    
    
    public  LightSpotBuilder pointsAtZ(double value) {
        operations.add(obj -> obj.setPointsAtZ(value));
        return this;
    }    
    
    public  LightSpotBuilder pointsAtX(double value) {
        operations.add(obj -> obj.setPointsAtX(value));
        return this;
    }    
    
    public  LightSpotBuilder pointsAtY(double value) {
        operations.add(obj -> obj.setPointsAtY(value));
        return this;
    }    
    
    public  LightSpotBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }    
    
    public  LightSpotBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }    
    
    public  LightSpotBuilder z(double value) {
        operations.add(obj -> obj.setZ(value));
        return this;
    }    
    
    public  LightSpotBuilder color(javafx.scene.paint.Color value) {
        operations.add(obj -> obj.setColor(value));
        return this;
    }    
    
    public LightSpotBuilder specularExponentPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.specularExponentProperty()));
        return this;
    }    
    
    public LightSpotBuilder pointsAtZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pointsAtZProperty()));
        return this;
    }    
    
    public LightSpotBuilder pointsAtXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pointsAtXProperty()));
        return this;
    }    
    
    public LightSpotBuilder pointsAtYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pointsAtYProperty()));
        return this;
    }    
    
    public LightSpotBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }    
    
    public LightSpotBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    
    public LightSpotBuilder zPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.zProperty()));
        return this;
    }    
    
    public LightSpotBuilder colorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Color>> op) {
        operations.add(obj -> op.accept(obj.colorProperty()));
        return this;
    }
}
