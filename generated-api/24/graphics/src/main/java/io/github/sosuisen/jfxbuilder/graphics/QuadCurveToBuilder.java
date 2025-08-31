
package io.github.sosuisen.jfxbuilder.graphics;


public class QuadCurveToBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.shape.QuadCurveTo>> operations = new java.util.ArrayList<>();
    private QuadCurveToBuilder() {}
    

    public static QuadCurveToBuilder create() { return new QuadCurveToBuilder(); }


    
    public static QuadCurveToBuilder create(double controlX, double controlY, double x, double y) {
        QuadCurveToBuilder builder = new QuadCurveToBuilder();
        builder.constructorArgs = new Object[]{controlX, controlY, x, y};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.shape.QuadCurveTo build() {
        javafx.scene.shape.QuadCurveTo newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.shape.QuadCurveTo();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.shape.QuadCurveTo> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.shape.QuadCurveTo callParameterizedConstructor() {
        javafx.scene.shape.QuadCurveTo newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.shape.QuadCurveTo.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.shape.QuadCurveTo) constructor.newInstance(constructorArgs);
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
    
    public QuadCurveToBuilder apply(java.util.function.Consumer<javafx.scene.shape.QuadCurveTo> func) {
        operations.add(func);
        return this;
    }    
    
    public  QuadCurveToBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }    
    
    public  QuadCurveToBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }    
    
    public  QuadCurveToBuilder controlY(double value) {
        operations.add(obj -> obj.setControlY(value));
        return this;
    }    
    
    public  QuadCurveToBuilder controlX(double value) {
        operations.add(obj -> obj.setControlX(value));
        return this;
    }    
    
    public  QuadCurveToBuilder absolute(boolean value) {
        operations.add(obj -> obj.setAbsolute(value));
        return this;
    }    
    
    public QuadCurveToBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }    
    
    public QuadCurveToBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    
    public QuadCurveToBuilder controlYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.controlYProperty()));
        return this;
    }    
    
    public QuadCurveToBuilder controlXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.controlXProperty()));
        return this;
    }    
    
    public QuadCurveToBuilder absolutePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.absoluteProperty()));
        return this;
    }
}
