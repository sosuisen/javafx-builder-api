
package io.github.sosuisen.jfxbuilder.graphics;


public class BoxBlurBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.BoxBlur>> operations = new java.util.ArrayList<>();
    private BoxBlurBuilder() {}
    

    public static BoxBlurBuilder create() { return new BoxBlurBuilder(); }


    
    public static BoxBlurBuilder create(double width, double height, int iterations) {
        BoxBlurBuilder builder = new BoxBlurBuilder();
        builder.constructorArgs = new Object[]{width, height, iterations};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.effect.BoxBlur build() {
        javafx.scene.effect.BoxBlur newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.BoxBlur();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.BoxBlur> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.BoxBlur callParameterizedConstructor() {
        javafx.scene.effect.BoxBlur newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.BoxBlur.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.BoxBlur) constructor.newInstance(constructorArgs);
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
    
    public BoxBlurBuilder apply(java.util.function.Consumer<javafx.scene.effect.BoxBlur> func) {
        operations.add(func);
        return this;
    }    
    
    public  BoxBlurBuilder input(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setInput(value));
        return this;
    }    
    
    public  BoxBlurBuilder width(double value) {
        operations.add(obj -> obj.setWidth(value));
        return this;
    }    
    
    public  BoxBlurBuilder height(double value) {
        operations.add(obj -> obj.setHeight(value));
        return this;
    }    
    
    public  BoxBlurBuilder iterations(int value) {
        operations.add(obj -> obj.setIterations(value));
        return this;
    }    
    
    public BoxBlurBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    
    public BoxBlurBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    
    public BoxBlurBuilder inputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.inputProperty()));
        return this;
    }    
    
    public BoxBlurBuilder iterationsPropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.iterationsProperty()));
        return this;
    }
}
