
package io.github.sosuisen.jfxbuilder.graphics;


public class CubicCurveToBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.shape.CubicCurveTo>> operations = new java.util.ArrayList<>();
    private CubicCurveToBuilder() {}
    

    public static CubicCurveToBuilder create() { return new CubicCurveToBuilder(); }


    
    public static CubicCurveToBuilder create(double controlX1, double controlY1, double controlX2, double controlY2, double x, double y) {
        CubicCurveToBuilder builder = new CubicCurveToBuilder();
        builder.constructorArgs = new Object[]{controlX1, controlY1, controlX2, controlY2, x, y};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.shape.CubicCurveTo build() {
        javafx.scene.shape.CubicCurveTo newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.shape.CubicCurveTo();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.shape.CubicCurveTo> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.shape.CubicCurveTo callParameterizedConstructor() {
        javafx.scene.shape.CubicCurveTo newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.shape.CubicCurveTo.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.shape.CubicCurveTo) constructor.newInstance(constructorArgs);
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
    
    public CubicCurveToBuilder apply(java.util.function.Consumer<javafx.scene.shape.CubicCurveTo> func) {
        operations.add(func);
        return this;
    }    
    
    public  CubicCurveToBuilder absolute(boolean value) {
        operations.add(obj -> obj.setAbsolute(value));
        return this;
    }    
    
    public  CubicCurveToBuilder controlX1(double value) {
        operations.add(obj -> obj.setControlX1(value));
        return this;
    }    
    
    public  CubicCurveToBuilder controlX2(double value) {
        operations.add(obj -> obj.setControlX2(value));
        return this;
    }    
    
    public  CubicCurveToBuilder controlY1(double value) {
        operations.add(obj -> obj.setControlY1(value));
        return this;
    }    
    
    public  CubicCurveToBuilder controlY2(double value) {
        operations.add(obj -> obj.setControlY2(value));
        return this;
    }    
    
    public  CubicCurveToBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }    
    
    public  CubicCurveToBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }    
    
    public CubicCurveToBuilder controlY2PropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.controlY2Property()));
        return this;
    }    
    
    public CubicCurveToBuilder controlY1PropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.controlY1Property()));
        return this;
    }    
    
    public CubicCurveToBuilder controlX2PropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.controlX2Property()));
        return this;
    }    
    
    public CubicCurveToBuilder controlX1PropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.controlX1Property()));
        return this;
    }    
    
    public CubicCurveToBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }    
    
    public CubicCurveToBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    
    public CubicCurveToBuilder absolutePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.absoluteProperty()));
        return this;
    }
}
