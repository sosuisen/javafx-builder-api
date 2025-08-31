
package io.github.sosuisen.jfxbuilder.graphics;


public class MotionBlurBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.MotionBlur>> operations = new java.util.ArrayList<>();
    private MotionBlurBuilder() {}
    

    public static MotionBlurBuilder create() { return new MotionBlurBuilder(); }


    
    public static MotionBlurBuilder create(double angle, double radius) {
        MotionBlurBuilder builder = new MotionBlurBuilder();
        builder.constructorArgs = new Object[]{angle, radius};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.effect.MotionBlur build() {
        javafx.scene.effect.MotionBlur newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.MotionBlur();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.MotionBlur> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.MotionBlur callParameterizedConstructor() {
        javafx.scene.effect.MotionBlur newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.MotionBlur.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.MotionBlur) constructor.newInstance(constructorArgs);
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
    
    public MotionBlurBuilder apply(java.util.function.Consumer<javafx.scene.effect.MotionBlur> func) {
        operations.add(func);
        return this;
    }    
    
    public  MotionBlurBuilder input(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setInput(value));
        return this;
    }    
    
    public  MotionBlurBuilder radius(double value) {
        operations.add(obj -> obj.setRadius(value));
        return this;
    }    
    
    public  MotionBlurBuilder angle(double value) {
        operations.add(obj -> obj.setAngle(value));
        return this;
    }    
    
    public MotionBlurBuilder anglePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.angleProperty()));
        return this;
    }    
    
    public MotionBlurBuilder inputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.inputProperty()));
        return this;
    }    
    
    public MotionBlurBuilder radiusPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.radiusProperty()));
        return this;
    }
}
