
package io.github.sosuisen.jfxbuilder.graphics;


public class BlendBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.Blend>> operations = new java.util.ArrayList<>();
    private BlendBuilder() {}
    

    public static BlendBuilder create() { return new BlendBuilder(); }


    
    public static BlendBuilder create(javafx.scene.effect.BlendMode mode) {
        BlendBuilder builder = new BlendBuilder();
        builder.constructorArgs = new Object[]{mode};
        return builder;
    }


    
    public static BlendBuilder create(javafx.scene.effect.BlendMode mode, javafx.scene.effect.Effect bottomInput, javafx.scene.effect.Effect topInput) {
        BlendBuilder builder = new BlendBuilder();
        builder.constructorArgs = new Object[]{mode, bottomInput, topInput};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.effect.Blend build() {
        javafx.scene.effect.Blend newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.Blend();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.Blend> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.Blend callParameterizedConstructor() {
        javafx.scene.effect.Blend newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.Blend.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.Blend) constructor.newInstance(constructorArgs);
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
    
    public BlendBuilder apply(java.util.function.Consumer<javafx.scene.effect.Blend> func) {
        operations.add(func);
        return this;
    }    
    
    public  BlendBuilder bottomInput(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setBottomInput(value));
        return this;
    }    
    
    public  BlendBuilder mode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setMode(value));
        return this;
    }    
    
    public  BlendBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }    
    
    public  BlendBuilder topInput(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setTopInput(value));
        return this;
    }    
    
    public BlendBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    
    public BlendBuilder bottomInputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.bottomInputProperty()));
        return this;
    }    
    
    public BlendBuilder modePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.modeProperty()));
        return this;
    }    
    
    public BlendBuilder topInputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.topInputProperty()));
        return this;
    }
}
