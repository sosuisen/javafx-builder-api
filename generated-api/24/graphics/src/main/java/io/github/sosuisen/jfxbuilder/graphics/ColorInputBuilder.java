
package io.github.sosuisen.jfxbuilder.graphics;


public class ColorInputBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.effect.ColorInput>> operations = new java.util.ArrayList<>();
    private ColorInputBuilder() {}
    

    public static ColorInputBuilder create() { return new ColorInputBuilder(); }


    
    public static ColorInputBuilder create(double x, double y, double width, double height, javafx.scene.paint.Paint paint) {
        ColorInputBuilder builder = new ColorInputBuilder();
        builder.constructorArgs = new Object[]{x, y, width, height, paint};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.effect.ColorInput build() {
        javafx.scene.effect.ColorInput newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.effect.ColorInput();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.effect.ColorInput> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.effect.ColorInput callParameterizedConstructor() {
        javafx.scene.effect.ColorInput newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.effect.ColorInput.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.effect.ColorInput) constructor.newInstance(constructorArgs);
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
    
    public ColorInputBuilder apply(java.util.function.Consumer<javafx.scene.effect.ColorInput> func) {
        operations.add(func);
        return this;
    }    
    
    public  ColorInputBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }    
    
    public  ColorInputBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }    
    
    public  ColorInputBuilder paint(javafx.scene.paint.Paint value) {
        operations.add(obj -> obj.setPaint(value));
        return this;
    }    
    
    public  ColorInputBuilder height(double value) {
        operations.add(obj -> obj.setHeight(value));
        return this;
    }    
    
    public  ColorInputBuilder width(double value) {
        operations.add(obj -> obj.setWidth(value));
        return this;
    }    
    
    public ColorInputBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    
    public ColorInputBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    
    public ColorInputBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }    
    
    public ColorInputBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    
    public ColorInputBuilder paintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Paint>> op) {
        operations.add(obj -> op.accept(obj.paintProperty()));
        return this;
    }
}
