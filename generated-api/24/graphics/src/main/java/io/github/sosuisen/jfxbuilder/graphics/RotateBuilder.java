
package io.github.sosuisen.jfxbuilder.graphics;


public class RotateBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.transform.Rotate>> operations = new java.util.ArrayList<>();
    private RotateBuilder() {}
    

    
    public static RotateBuilder create(double angle, double pivotX, double pivotY, double pivotZ, javafx.geometry.Point3D axis) {
        RotateBuilder builder = new RotateBuilder();
        builder.constructorArgs = new Object[]{angle, pivotX, pivotY, pivotZ, axis};
        return builder;
    }


    
    public static RotateBuilder create(double angle, double pivotX, double pivotY, double pivotZ) {
        RotateBuilder builder = new RotateBuilder();
        builder.constructorArgs = new Object[]{angle, pivotX, pivotY, pivotZ};
        return builder;
    }


    
    public static RotateBuilder create(double angle, double pivotX, double pivotY) {
        RotateBuilder builder = new RotateBuilder();
        builder.constructorArgs = new Object[]{angle, pivotX, pivotY};
        return builder;
    }


    public static RotateBuilder create() { return new RotateBuilder(); }


    
    public static RotateBuilder create(double angle) {
        RotateBuilder builder = new RotateBuilder();
        builder.constructorArgs = new Object[]{angle};
        return builder;
    }


    
    public static RotateBuilder create(double angle, javafx.geometry.Point3D axis) {
        RotateBuilder builder = new RotateBuilder();
        builder.constructorArgs = new Object[]{angle, axis};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.transform.Rotate build() {
        javafx.scene.transform.Rotate newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.transform.Rotate();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.transform.Rotate> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.transform.Rotate callParameterizedConstructor() {
        javafx.scene.transform.Rotate newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.transform.Rotate.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.transform.Rotate) constructor.newInstance(constructorArgs);
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
    
    public RotateBuilder apply(java.util.function.Consumer<javafx.scene.transform.Rotate> func) {
        operations.add(func);
        return this;
    }    
    
    public  RotateBuilder angle(double value) {
        operations.add(obj -> obj.setAngle(value));
        return this;
    }    
    
    public  RotateBuilder pivotX(double value) {
        operations.add(obj -> obj.setPivotX(value));
        return this;
    }    
    
    public  RotateBuilder pivotY(double value) {
        operations.add(obj -> obj.setPivotY(value));
        return this;
    }    
    
    public  RotateBuilder axis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setAxis(value));
        return this;
    }    
    
    public  RotateBuilder pivotZ(double value) {
        operations.add(obj -> obj.setPivotZ(value));
        return this;
    }    
    
    public  RotateBuilder onTransformChanged(javafx.event.EventHandler<? super javafx.scene.transform.TransformChangedEvent> value) {
        operations.add(obj -> obj.setOnTransformChanged(value));
        return this;
    }    
    
    public RotateBuilder pivotXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pivotXProperty()));
        return this;
    }    
    
    public RotateBuilder anglePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.angleProperty()));
        return this;
    }    
    
    public RotateBuilder pivotZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pivotZProperty()));
        return this;
    }    
    
    public RotateBuilder pivotYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pivotYProperty()));
        return this;
    }    
    
    public RotateBuilder axisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.axisProperty()));
        return this;
    }    
    
    public RotateBuilder type2DPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.type2DProperty()));
        return this;
    }    
    
    public RotateBuilder identityPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.identityProperty()));
        return this;
    }    
    
    public RotateBuilder onTransformChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.transform.TransformChangedEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTransformChangedProperty()));
        return this;
    }
}
