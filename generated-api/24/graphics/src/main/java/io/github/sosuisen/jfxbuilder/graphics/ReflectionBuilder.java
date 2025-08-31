
package io.github.sosuisen.jfxbuilder.graphics;


public class ReflectionBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.Reflection>> operations = new java.util.ArrayList<>();
    private ReflectionBuilder() {}
    

    public static ReflectionBuilder create() { return new ReflectionBuilder(); }


    
    public static ReflectionBuilder create(double topOffset, double fraction, double topOpacity, double bottomOpacity) {
        ReflectionBuilder builder = new ReflectionBuilder();
        builder.constructorArgs = new Object[]{topOffset, fraction, topOpacity, bottomOpacity};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.effect.Reflection build() {
        javafx.scene.effect.Reflection newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.Reflection();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.Reflection> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.Reflection callParameterizedConstructor() {
        javafx.scene.effect.Reflection newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.Reflection.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.Reflection) constructor.newInstance(constructorArgs);
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
    
    public ReflectionBuilder apply(java.util.function.Consumer<javafx.scene.effect.Reflection> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Reflection#setBottomOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  ReflectionBuilder bottomOpacity(double value) {
        operations.add(obj -> obj.setBottomOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Reflection#setFraction(double)}
     * 
     * @return builder instance
     */    
    
    public  ReflectionBuilder fraction(double value) {
        operations.add(obj -> obj.setFraction(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Reflection#setInput(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  ReflectionBuilder input(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setInput(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Reflection#setTopOffset(double)}
     * 
     * @return builder instance
     */    
    
    public  ReflectionBuilder topOffset(double value) {
        operations.add(obj -> obj.setTopOffset(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.effect.Reflection#setTopOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  ReflectionBuilder topOpacity(double value) {
        operations.add(obj -> obj.setTopOpacity(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Reflection#bottomOpacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public ReflectionBuilder bottomOpacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.bottomOpacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Reflection#fractionProperty()}.
     * 
     * @return builder instance
     */    
    
    public ReflectionBuilder fractionPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.fractionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Reflection#inputProperty()}.
     * 
     * @return builder instance
     */    
    
    public ReflectionBuilder inputPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.inputProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Reflection#topOffsetProperty()}.
     * 
     * @return builder instance
     */    
    
    public ReflectionBuilder topOffsetPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.topOffsetProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.effect.Reflection#topOpacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public ReflectionBuilder topOpacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.topOpacityProperty()));
        return this;
    }
}
