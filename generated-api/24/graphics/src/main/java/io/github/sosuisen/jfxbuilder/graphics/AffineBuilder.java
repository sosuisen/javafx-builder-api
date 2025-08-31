
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
    /**
     * Builder method for {@link javafx.scene.transform.Affine#setElement(javafx.scene.transform.MatrixType, int, int, double)}
     * 
     * @return builder instance
     */    
    
    public  AffineBuilder element(javafx.scene.transform.MatrixType type, int row, int column, double value) {
        operations.add(obj -> obj.setElement(type, row, column, value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Affine#setMxx(double)}
     * 
     * @return builder instance
     */    
    
    public  AffineBuilder mxx(double value) {
        operations.add(obj -> obj.setMxx(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Affine#setMxy(double)}
     * 
     * @return builder instance
     */    
    
    public  AffineBuilder mxy(double value) {
        operations.add(obj -> obj.setMxy(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Affine#setMxz(double)}
     * 
     * @return builder instance
     */    
    
    public  AffineBuilder mxz(double value) {
        operations.add(obj -> obj.setMxz(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Affine#setMyx(double)}
     * 
     * @return builder instance
     */    
    
    public  AffineBuilder myx(double value) {
        operations.add(obj -> obj.setMyx(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Affine#setMyy(double)}
     * 
     * @return builder instance
     */    
    
    public  AffineBuilder myy(double value) {
        operations.add(obj -> obj.setMyy(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Affine#setMyz(double)}
     * 
     * @return builder instance
     */    
    
    public  AffineBuilder myz(double value) {
        operations.add(obj -> obj.setMyz(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Affine#setMzx(double)}
     * 
     * @return builder instance
     */    
    
    public  AffineBuilder mzx(double value) {
        operations.add(obj -> obj.setMzx(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Affine#setMzy(double)}
     * 
     * @return builder instance
     */    
    
    public  AffineBuilder mzy(double value) {
        operations.add(obj -> obj.setMzy(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Affine#setMzz(double)}
     * 
     * @return builder instance
     */    
    
    public  AffineBuilder mzz(double value) {
        operations.add(obj -> obj.setMzz(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Affine#setOnTransformChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  AffineBuilder onTransformChanged(javafx.event.EventHandler<? super javafx.scene.transform.TransformChangedEvent> value) {
        operations.add(obj -> obj.setOnTransformChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Affine#setToIdentity()}
     * 
     * @return builder instance
     */    
    
    public  AffineBuilder toIdentity() {
        operations.add(obj -> obj.setToIdentity());
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Affine#setToTransform(double, double, double, double, double, double)}
     * 
     * @return builder instance
     */    
    
    public  AffineBuilder toTransform(double mxx, double mxy, double tx, double myx, double myy, double ty) {
        operations.add(obj -> obj.setToTransform(mxx, mxy, tx, myx, myy, ty));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Affine#setToTransform(double, double, double, double, double, double, double, double, double, double, double, double)}
     * 
     * @return builder instance
     */    
    
    public  AffineBuilder toTransform(double mxx, double mxy, double mxz, double tx, double myx, double myy, double myz, double ty, double mzx, double mzy, double mzz, double tz) {
        operations.add(obj -> obj.setToTransform(mxx, mxy, mxz, tx, myx, myy, myz, ty, mzx, mzy, mzz, tz));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Affine#setToTransform(double..., javafx.scene.transform.MatrixType, int)}
     * 
     * @return builder instance
     */    
    
    public  AffineBuilder toTransform(double[] matrix, javafx.scene.transform.MatrixType type, int offset) {
        operations.add(obj -> obj.setToTransform(matrix, type, offset));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Affine#setToTransform(javafx.scene.transform.Transform)}
     * 
     * @return builder instance
     */    
    
    public  AffineBuilder toTransform(javafx.scene.transform.Transform transform) {
        operations.add(obj -> obj.setToTransform(transform));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Affine#setTx(double)}
     * 
     * @return builder instance
     */    
    
    public  AffineBuilder tx(double value) {
        operations.add(obj -> obj.setTx(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Affine#setTy(double)}
     * 
     * @return builder instance
     */    
    
    public  AffineBuilder ty(double value) {
        operations.add(obj -> obj.setTy(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Affine#setTz(double)}
     * 
     * @return builder instance
     */    
    
    public  AffineBuilder tz(double value) {
        operations.add(obj -> obj.setTz(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#identityProperty()}.
     * 
     * @return builder instance
     */    
    
    public AffineBuilder identityPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.identityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#mxxProperty()}.
     * 
     * @return builder instance
     */    
    
    public AffineBuilder mxxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.mxxProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#mxyProperty()}.
     * 
     * @return builder instance
     */    
    
    public AffineBuilder mxyPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.mxyProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#mxzProperty()}.
     * 
     * @return builder instance
     */    
    
    public AffineBuilder mxzPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.mxzProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#myxProperty()}.
     * 
     * @return builder instance
     */    
    
    public AffineBuilder myxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.myxProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#myyProperty()}.
     * 
     * @return builder instance
     */    
    
    public AffineBuilder myyPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.myyProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#myzProperty()}.
     * 
     * @return builder instance
     */    
    
    public AffineBuilder myzPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.myzProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#mzxProperty()}.
     * 
     * @return builder instance
     */    
    
    public AffineBuilder mzxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.mzxProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#mzyProperty()}.
     * 
     * @return builder instance
     */    
    
    public AffineBuilder mzyPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.mzyProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#mzzProperty()}.
     * 
     * @return builder instance
     */    
    
    public AffineBuilder mzzPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.mzzProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#onTransformChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public AffineBuilder onTransformChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.transform.TransformChangedEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTransformChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#txProperty()}.
     * 
     * @return builder instance
     */    
    
    public AffineBuilder txPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.txProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#tyProperty()}.
     * 
     * @return builder instance
     */    
    
    public AffineBuilder tyPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.tyProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#type2DProperty()}.
     * 
     * @return builder instance
     */    
    
    public AffineBuilder type2DPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.type2DProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Affine#tzProperty()}.
     * 
     * @return builder instance
     */    
    
    public AffineBuilder tzPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.tzProperty()));
        return this;
    }
}
