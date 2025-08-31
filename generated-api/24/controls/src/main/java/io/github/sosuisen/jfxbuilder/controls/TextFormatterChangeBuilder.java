
package io.github.sosuisen.jfxbuilder.controls;


public class TextFormatterChangeBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.TextFormatter.Change>> operations = new java.util.ArrayList<>();
    private TextFormatterChangeBuilder() {}
    
    private Object[] constructorArgs;

    public javafx.scene.control.TextFormatter.Change build() {
        javafx.scene.control.TextFormatter.Change newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.TextFormatter.Change> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.TextFormatter.Change callParameterizedConstructor() {
        javafx.scene.control.TextFormatter.Change newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TextFormatter.Change.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TextFormatter.Change) constructor.newInstance(constructorArgs);
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
    
    public TextFormatterChangeBuilder apply(java.util.function.Consumer<javafx.scene.control.TextFormatter.Change> func) {
        operations.add(func);
        return this;
    }    
    
    public  TextFormatterChangeBuilder anchor(int newAnchor) {
        operations.add(obj -> obj.setAnchor(newAnchor));
        return this;
    }    
    
    public  TextFormatterChangeBuilder text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }    
    
    public  TextFormatterChangeBuilder range(int start, int end) {
        operations.add(obj -> obj.setRange(start, end));
        return this;
    }    
    
    public  TextFormatterChangeBuilder caretPosition(int newCaretPosition) {
        operations.add(obj -> obj.setCaretPosition(newCaretPosition));
        return this;
    }
}
