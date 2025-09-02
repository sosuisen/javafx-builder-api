
package io.github.sosuisen.jfxbuilder.controls;


public class TreeItemTreeModificationEventBuilder<T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.TreeItem.TreeModificationEvent<T>>> operations = new java.util.ArrayList<>();
    private TreeItemTreeModificationEventBuilder() {}
    

    
    public static <T> TreeItemTreeModificationEventBuilder<T> create(javafx.event.EventType<? extends javafx.event.Event> eventType, javafx.scene.control.TreeItem<T> treeItem) {
        TreeItemTreeModificationEventBuilder<T> builder = new TreeItemTreeModificationEventBuilder<T>();
        builder.constructorArgs = new Object[]{eventType, treeItem};
        return builder;
    }


    
    public static <T> TreeItemTreeModificationEventBuilder<T> create(javafx.event.EventType<? extends javafx.event.Event> eventType, javafx.scene.control.TreeItem<T> treeItem, T newValue) {
        TreeItemTreeModificationEventBuilder<T> builder = new TreeItemTreeModificationEventBuilder<T>();
        builder.constructorArgs = new Object[]{eventType, treeItem, newValue};
        return builder;
    }


    
    public static <T> TreeItemTreeModificationEventBuilder<T> create(javafx.event.EventType<? extends javafx.event.Event> eventType, javafx.scene.control.TreeItem<T> treeItem, boolean expanded) {
        TreeItemTreeModificationEventBuilder<T> builder = new TreeItemTreeModificationEventBuilder<T>();
        builder.constructorArgs = new Object[]{eventType, treeItem, expanded};
        return builder;
    }


    
    public static <T> TreeItemTreeModificationEventBuilder<T> create(javafx.event.EventType<? extends javafx.event.Event> eventType, javafx.scene.control.TreeItem<T> treeItem, java.util.List<? extends javafx.scene.control.TreeItem<T>> added, java.util.List<? extends javafx.scene.control.TreeItem<T>> removed) {
        TreeItemTreeModificationEventBuilder<T> builder = new TreeItemTreeModificationEventBuilder<T>();
        builder.constructorArgs = new Object[]{eventType, treeItem, added, removed};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.control.TreeItem.TreeModificationEvent<T> build() {
        javafx.scene.control.TreeItem.TreeModificationEvent<T> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.TreeItem.TreeModificationEvent<T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.TreeItem.TreeModificationEvent<T> callParameterizedConstructor() {
        javafx.scene.control.TreeItem.TreeModificationEvent<T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TreeItem.TreeModificationEvent.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TreeItem.TreeModificationEvent<T>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the TreeModificationEvent instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(treeModificationEvent -> treeModificationEvent.setId("Main" + treeModificationEvent.getTypeSelector()))
     * }</pre>
     * 
     * @return builder instance
     *
     */
    public TreeItemTreeModificationEventBuilder<T> apply(java.util.function.Consumer<javafx.scene.control.TreeItem.TreeModificationEvent<T>> func) {
        operations.add(func);
        return this;
    }
}
