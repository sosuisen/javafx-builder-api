
package io.github.sosuisen.jfxbuilder.graphics;


public class DragboardBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.input.Dragboard>> operations = new java.util.ArrayList<>();
    private DragboardBuilder() {}
    
    private Object[] constructorArgs;

    public javafx.scene.input.Dragboard build() {
        javafx.scene.input.Dragboard newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.input.Dragboard> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.input.Dragboard callParameterizedConstructor() {
        javafx.scene.input.Dragboard newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.input.Dragboard.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.input.Dragboard) constructor.newInstance(constructorArgs);
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
    
    public DragboardBuilder apply(java.util.function.Consumer<javafx.scene.input.Dragboard> func) {
        operations.add(func);
        return this;
    }    
    
    public  DragboardBuilder dragViewOffsetY(double offsetY) {
        operations.add(obj -> obj.setDragViewOffsetY(offsetY));
        return this;
    }    
    
    public  DragboardBuilder dragViewOffsetX(double offsetX) {
        operations.add(obj -> obj.setDragViewOffsetX(offsetX));
        return this;
    }    
    
    public  DragboardBuilder dragView(javafx.scene.image.Image image, double offsetX, double offsetY) {
        operations.add(obj -> obj.setDragView(image, offsetX, offsetY));
        return this;
    }    
    
    public  DragboardBuilder dragView(javafx.scene.image.Image image) {
        operations.add(obj -> obj.setDragView(image));
        return this;
    }    
    
    public  DragboardBuilder content(java.util.Map<javafx.scene.input.DataFormat, java.lang.Object> content) {
        operations.add(obj -> obj.setContent(content));
        return this;
    }
}
