
package io.github.sosuisen.jfxbuilder.controls;


public class TreeItemPropertyValueFactoryBuilder<S, T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.cell.TreeItemPropertyValueFactory<S, T>>> operations = new java.util.ArrayList<>();
    private TreeItemPropertyValueFactoryBuilder() {}
    

    
    public static <S, T> TreeItemPropertyValueFactoryBuilder<S, T> create(java.lang.String property) {
        TreeItemPropertyValueFactoryBuilder<S, T> builder = new TreeItemPropertyValueFactoryBuilder<S, T>();
        builder.constructorArgs = new Object[]{property};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.control.cell.TreeItemPropertyValueFactory<S, T> build() {
        javafx.scene.control.cell.TreeItemPropertyValueFactory<S, T> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.cell.TreeItemPropertyValueFactory<S, T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.cell.TreeItemPropertyValueFactory<S, T> callParameterizedConstructor() {
        javafx.scene.control.cell.TreeItemPropertyValueFactory<S, T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.cell.TreeItemPropertyValueFactory.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.cell.TreeItemPropertyValueFactory<S, T>) constructor.newInstance(constructorArgs);
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
    /**
     * Applies a function to the TreeItemPropertyValueFactory instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TreeItemPropertyValueFactoryBuilder<S, T> apply(java.util.function.Consumer<javafx.scene.control.cell.TreeItemPropertyValueFactory<S, T>> func) {
        operations.add(func);
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.TreeItemPropertyValueFactory#getProperty()}.
     * 
     * @return builder instance
     */    
    
    public TreeItemPropertyValueFactoryBuilder<S, T> getPropertyApply(java.util.function.Consumer<java.lang.String> op) {
        operations.add(obj -> op.accept(obj.getProperty()));
        return this;
    }
}
