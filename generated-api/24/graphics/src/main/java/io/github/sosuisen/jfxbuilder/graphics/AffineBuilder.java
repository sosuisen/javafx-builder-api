
package io.github.sosuisen.jfxbuilder.graphics;


public class AffineBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.transform.Affine>> operations = new java.util.ArrayList<>();
    private AffineBuilder() {}
    

    public static AffineBuilder create() { return new AffineBuilder(); }


    
    public static AffineBuilder create(double mxx, double mxy, double tx, double myx, double myy, double ty) {
        AffineBuilder builder = new AffineBuilder();
        builder.constructorArgs = new Object[]{mxx, mxy, tx, myx, myy, ty};
        return builder;
    }


    
    public static AffineBuilder create(double mxx, double mxy, double mxz, double tx, double myx, double myy, double myz, double ty, double mzx, double mzy, double mzz, double tz) {
        AffineBuilder builder = new AffineBuilder();
        builder.constructorArgs = new Object[]{mxx, mxy, mxz, tx, myx, myy, myz, ty, mzx, mzy, mzz, tz};
        return builder;
    }


    
    public static AffineBuilder create(double[] matrix, javafx.scene.transform.MatrixType type, int offset) {
        AffineBuilder builder = new AffineBuilder();
        builder.constructorArgs = new Object[]{matrix, type, offset};
        return builder;
    }


    
    public static AffineBuilder create(javafx.scene.transform.Transform transform) {
        AffineBuilder builder = new AffineBuilder();
        builder.constructorArgs = new Object[]{transform};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.transform.Affine build() {
        javafx.scene.transform.Affine newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.transform.Affine();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.transform.Affine> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.transform.Affine callParameterizedConstructor() {
        javafx.scene.transform.Affine newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.transform.Affine.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.transform.Affine) constructor.newInstance(constructorArgs);
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
    
    public AffineBuilder apply(java.util.function.Consumer<javafx.scene.transform.Affine> func) {
        operations.add(func);
        return this;
    }    
    
    public  AffineBuilder element(javafx.scene.transform.MatrixType type, int row, int column, double value) {
        operations.add(obj -> obj.setElement(type, row, column, value));
        return this;
    }    
    
    public  AffineBuilder mxx(double value) {
        operations.add(obj -> obj.setMxx(value));
        return this;
    }    
    
    public  AffineBuilder mxy(double value) {
        operations.add(obj -> obj.setMxy(value));
        return this;
    }    
    
    public  AffineBuilder mxz(double value) {
        operations.add(obj -> obj.setMxz(value));
        return this;
    }    
    
    public  AffineBuilder myx(double value) {
        operations.add(obj -> obj.setMyx(value));
        return this;
    }    
    
    public  AffineBuilder myy(double value) {
        operations.add(obj -> obj.setMyy(value));
        return this;
    }    
    
    public  AffineBuilder myz(double value) {
        operations.add(obj -> obj.setMyz(value));
        return this;
    }    
    
    public  AffineBuilder mzx(double value) {
        operations.add(obj -> obj.setMzx(value));
        return this;
    }    
    
    public  AffineBuilder mzy(double value) {
        operations.add(obj -> obj.setMzy(value));
        return this;
    }    
    
    public  AffineBuilder mzz(double value) {
        operations.add(obj -> obj.setMzz(value));
        return this;
    }    
    
    public  AffineBuilder onTransformChanged(javafx.event.EventHandler<? super javafx.scene.transform.TransformChangedEvent> value) {
        operations.add(obj -> obj.setOnTransformChanged(value));
        return this;
    }    
    
    public  AffineBuilder toIdentity() {
        operations.add(obj -> obj.setToIdentity());
        return this;
    }    
    
    public  AffineBuilder toTransform(double mxx, double mxy, double tx, double myx, double myy, double ty) {
        operations.add(obj -> obj.setToTransform(mxx, mxy, tx, myx, myy, ty));
        return this;
    }    
    
    public  AffineBuilder toTransform(double mxx, double mxy, double mxz, double tx, double myx, double myy, double myz, double ty, double mzx, double mzy, double mzz, double tz) {
        operations.add(obj -> obj.setToTransform(mxx, mxy, mxz, tx, myx, myy, myz, ty, mzx, mzy, mzz, tz));
        return this;
    }    
    
    public  AffineBuilder toTransform(double[] matrix, javafx.scene.transform.MatrixType type, int offset) {
        operations.add(obj -> obj.setToTransform(matrix, type, offset));
        return this;
    }    
    
    public  AffineBuilder toTransform(javafx.scene.transform.Transform transform) {
        operations.add(obj -> obj.setToTransform(transform));
        return this;
    }    
    
    public  AffineBuilder tx(double value) {
        operations.add(obj -> obj.setTx(value));
        return this;
    }    
    
    public  AffineBuilder ty(double value) {
        operations.add(obj -> obj.setTy(value));
        return this;
    }    
    
    public  AffineBuilder tz(double value) {
        operations.add(obj -> obj.setTz(value));
        return this;
    }    
    
    public AffineBuilder mzzPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.mzzProperty()));
        return this;
    }    
    
    public AffineBuilder myzPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.myzProperty()));
        return this;
    }    
    
    public AffineBuilder mxxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.mxxProperty()));
        return this;
    }    
    
    public AffineBuilder myxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.myxProperty()));
        return this;
    }    
    
    public AffineBuilder mzyPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.mzyProperty()));
        return this;
    }    
    
    public AffineBuilder mxyPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.mxyProperty()));
        return this;
    }    
    
    public AffineBuilder mxzPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.mxzProperty()));
        return this;
    }    
    
    public AffineBuilder mzxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.mzxProperty()));
        return this;
    }    
    
    public AffineBuilder myyPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.myyProperty()));
        return this;
    }    
    
    public AffineBuilder tzPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.tzProperty()));
        return this;
    }    
    
    public AffineBuilder txPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.txProperty()));
        return this;
    }    
    
    public AffineBuilder tyPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.tyProperty()));
        return this;
    }    
    
    public AffineBuilder onTransformChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.transform.TransformChangedEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTransformChangedProperty()));
        return this;
    }    
    
    public AffineBuilder type2DPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.type2DProperty()));
        return this;
    }    
    
    public AffineBuilder identityPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.identityProperty()));
        return this;
    }
}
