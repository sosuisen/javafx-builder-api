
package io.github.sosuisen.jfxbuilder.graphics;


public class PerspectiveTransformBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.PerspectiveTransform>> operations = new java.util.ArrayList<>();
    private PerspectiveTransformBuilder() {}
    

    public static PerspectiveTransformBuilder create() { return new PerspectiveTransformBuilder(); }


    
    public static PerspectiveTransformBuilder create(double ulx, double uly, double urx, double ury, double lrx, double lry, double llx, double lly) {
        PerspectiveTransformBuilder builder = new PerspectiveTransformBuilder();
        builder.constructorArgs = new Object[]{ulx, uly, urx, ury, lrx, lry, llx, lly};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.effect.PerspectiveTransform build() {
        javafx.scene.effect.PerspectiveTransform newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.PerspectiveTransform();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.PerspectiveTransform> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.PerspectiveTransform callParameterizedConstructor() {
        javafx.scene.effect.PerspectiveTransform newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.PerspectiveTransform.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.PerspectiveTransform) constructor.newInstance(constructorArgs);
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
    
    public PerspectiveTransformBuilder apply(java.util.function.Consumer<javafx.scene.effect.PerspectiveTransform> func) {
        operations.add(func);
        return this;
    }    
    
    public  PerspectiveTransformBuilder input(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setInput(value));
        return this;
    }    
    
    public  PerspectiveTransformBuilder llx(double value) {
        operations.add(obj -> obj.setLlx(value));
        return this;
    }    
    
    public  PerspectiveTransformBuilder lly(double value) {
        operations.add(obj -> obj.setLly(value));
        return this;
    }    
    
    public  PerspectiveTransformBuilder lrx(double value) {
        operations.add(obj -> obj.setLrx(value));
        return this;
    }    
    
    public  PerspectiveTransformBuilder lry(double value) {
        operations.add(obj -> obj.setLry(value));
        return this;
    }    
    
    public  PerspectiveTransformBuilder ulx(double value) {
        operations.add(obj -> obj.setUlx(value));
        return this;
    }    
    
    public  PerspectiveTransformBuilder uly(double value) {
        operations.add(obj -> obj.setUly(value));
        return this;
    }    
    
    public  PerspectiveTransformBuilder urx(double value) {
        operations.add(obj -> obj.setUrx(value));
        return this;
    }    
    
    public  PerspectiveTransformBuilder ury(double value) {
        operations.add(obj -> obj.setUry(value));
        return this;
    }    
    
    public PerspectiveTransformBuilder inputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.inputProperty()));
        return this;
    }    
    
    public PerspectiveTransformBuilder llxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.llxProperty()));
        return this;
    }    
    
    public PerspectiveTransformBuilder llyPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.llyProperty()));
        return this;
    }    
    
    public PerspectiveTransformBuilder lrxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.lrxProperty()));
        return this;
    }    
    
    public PerspectiveTransformBuilder lryPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.lryProperty()));
        return this;
    }    
    
    public PerspectiveTransformBuilder ulxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.ulxProperty()));
        return this;
    }    
    
    public PerspectiveTransformBuilder ulyPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.ulyProperty()));
        return this;
    }    
    
    public PerspectiveTransformBuilder urxPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.urxProperty()));
        return this;
    }    
    
    public PerspectiveTransformBuilder uryPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.uryProperty()));
        return this;
    }
}
