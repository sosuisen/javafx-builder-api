
package io.github.sosuisen.jfxbuilder.graphics;


public class ShearBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.transform.Shear>> operations = new java.util.ArrayList<>();
    private ShearBuilder() {}
    

    
    public static ShearBuilder create(double x, double y, double pivotX, double pivotY) {
        ShearBuilder builder = new ShearBuilder();
        builder.constructorArgs = new Object[]{x, y, pivotX, pivotY};
        return builder;
    }


    
    public static ShearBuilder create(double x, double y) {
        ShearBuilder builder = new ShearBuilder();
        builder.constructorArgs = new Object[]{x, y};
        return builder;
    }


    public static ShearBuilder create() { return new ShearBuilder(); }

    private Object[] constructorArgs;

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
    
    public ShearBuilder apply(java.util.function.Consumer<javafx.scene.transform.Shear> func) {
        operations.add(func);
        return this;
    }    
    
    public  ShearBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }    
    
    public  ShearBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }    
    
    public  ShearBuilder pivotX(double value) {
        operations.add(obj -> obj.setPivotX(value));
        return this;
    }    
    
    public  ShearBuilder pivotY(double value) {
        operations.add(obj -> obj.setPivotY(value));
        return this;
    }    
    
    public  ShearBuilder onTransformChanged(javafx.event.EventHandler<? super javafx.scene.transform.TransformChangedEvent> value) {
        operations.add(obj -> obj.setOnTransformChanged(value));
        return this;
    }    
    
    public ShearBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }    
    
    public ShearBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    
    public ShearBuilder pivotXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pivotXProperty()));
        return this;
    }    
    
    public ShearBuilder pivotYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pivotYProperty()));
        return this;
    }    
    
    public ShearBuilder type2DPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.type2DProperty()));
        return this;
    }    
    
    public ShearBuilder identityPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.identityProperty()));
        return this;
    }    
    
    public ShearBuilder onTransformChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.transform.TransformChangedEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTransformChangedProperty()));
        return this;
    }
}
