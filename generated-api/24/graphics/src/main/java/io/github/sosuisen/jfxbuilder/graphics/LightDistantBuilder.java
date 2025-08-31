
package io.github.sosuisen.jfxbuilder.graphics;


public class LightDistantBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.Light.Distant>> operations = new java.util.ArrayList<>();
    private LightDistantBuilder() {}
    

    public static LightDistantBuilder create() { return new LightDistantBuilder(); }


    
    public static LightDistantBuilder create(double azimuth, double elevation, javafx.scene.paint.Color color) {
        LightDistantBuilder builder = new LightDistantBuilder();
        builder.constructorArgs = new Object[]{azimuth, elevation, color};
        return builder;
    }

    private Object[] constructorArgs;

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
    
    public LightDistantBuilder apply(java.util.function.Consumer<javafx.scene.effect.Light.Distant> func) {
        operations.add(func);
        return this;
    }    
    
    public  LightDistantBuilder elevation(double value) {
        operations.add(obj -> obj.setElevation(value));
        return this;
    }    
    
    public  LightDistantBuilder azimuth(double value) {
        operations.add(obj -> obj.setAzimuth(value));
        return this;
    }    
    
    public  LightDistantBuilder color(javafx.scene.paint.Color value) {
        operations.add(obj -> obj.setColor(value));
        return this;
    }    
    
    public LightDistantBuilder azimuthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.azimuthProperty()));
        return this;
    }    
    
    public LightDistantBuilder elevationPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.elevationProperty()));
        return this;
    }    
    
    public LightDistantBuilder colorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Color>> op) {
        operations.add(obj -> op.accept(obj.colorProperty()));
        return this;
    }
}
