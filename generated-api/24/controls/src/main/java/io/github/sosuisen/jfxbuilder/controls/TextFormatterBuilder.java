
package io.github.sosuisen.jfxbuilder.controls;


public class TextFormatterBuilder<V> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.TextFormatter<V>>> operations = new java.util.ArrayList<>();
    private TextFormatterBuilder() {}
    

    
    public static <V> TextFormatterBuilder<V> create(javafx.util.StringConverter<V> valueConverter) {
        TextFormatterBuilder<V> builder = new TextFormatterBuilder<V>();
        builder.constructorArgs = new Object[]{valueConverter};
        return builder;
    }


    
    public static <V> TextFormatterBuilder<V> create(javafx.util.StringConverter<V> valueConverter, V defaultValue) {
        TextFormatterBuilder<V> builder = new TextFormatterBuilder<V>();
        builder.constructorArgs = new Object[]{valueConverter, defaultValue};
        return builder;
    }


    
    public static <V> TextFormatterBuilder<V> create(javafx.util.StringConverter<V> valueConverter, V defaultValue, java.util.function.UnaryOperator<javafx.scene.control.TextFormatter.Change> filter) {
        TextFormatterBuilder<V> builder = new TextFormatterBuilder<V>();
        builder.constructorArgs = new Object[]{valueConverter, defaultValue, filter};
        return builder;
    }


    
    public static <V> TextFormatterBuilder<V> create(java.util.function.UnaryOperator<javafx.scene.control.TextFormatter.Change> filter) {
        TextFormatterBuilder<V> builder = new TextFormatterBuilder<V>();
        builder.constructorArgs = new Object[]{filter};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.control.TextFormatter<V> build() {
        javafx.scene.control.TextFormatter<V> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.TextFormatter<V>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.TextFormatter<V> callParameterizedConstructor() {
        javafx.scene.control.TextFormatter<V> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TextFormatter.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TextFormatter<V>) constructor.newInstance(constructorArgs);
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
    
    public TextFormatterBuilder<V> apply(java.util.function.Consumer<javafx.scene.control.TextFormatter<V>> func) {
        operations.add(func);
        return this;
    }    
    
    public  TextFormatterBuilder<V> value(V value) {
        operations.add(obj -> obj.setValue(value));
        return this;
    }    
    
    public TextFormatterBuilder<V> valuePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<V>> op) {
        operations.add(obj -> op.accept(obj.valueProperty()));
        return this;
    }
}
