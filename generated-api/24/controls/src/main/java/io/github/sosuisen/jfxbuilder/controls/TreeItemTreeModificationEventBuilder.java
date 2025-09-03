
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code TreeItemTreeModificationEventBuilder} class constructs instances of the {@link javafx.scene.control.TreeItem.TreeModificationEvent TreeModificationEvent} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.TreeItem.TreeModificationEvent TreeModificationEvent} constructor
 * and returns an instance of the {@code TreeItemTreeModificationEventBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.TreeItem.TreeModificationEvent TreeModificationEvent}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.TreeItem.TreeModificationEvent TreeModificationEvent} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class TreeItemTreeModificationEventBuilder<T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.TreeItem.TreeModificationEvent<T>>> operations = new java.util.ArrayList<>();
    private TreeItemTreeModificationEventBuilder() {}
    

    /**
     * Accepts the same arguments as {@link javafx.scene.control.TreeItem.TreeModificationEvent#TreeModificationEvent(EventType, TreeItem) TreeModificationEvent(EventType, TreeItem)}
     * and returns an instance of the {@code TreeItemTreeModificationEventBuilder<T>}.
     *
     * @return an instance of the {@code TreeItemTreeModificationEventBuilder<T>}.
     */
    
    public static <T> TreeItemTreeModificationEventBuilder<T> create(javafx.event.EventType<? extends javafx.event.Event> eventType, javafx.scene.control.TreeItem<T> treeItem) {
        TreeItemTreeModificationEventBuilder<T> builder = new TreeItemTreeModificationEventBuilder<T>();
        builder.constructorArgs = new Object[]{eventType, treeItem};
        return builder;
    }


    /**
     * Accepts the same arguments as {@link javafx.scene.control.TreeItem.TreeModificationEvent#TreeModificationEvent(EventType, TreeItem, Object) TreeModificationEvent(EventType, TreeItem, Object)}
     * and returns an instance of the {@code TreeItemTreeModificationEventBuilder<T>}.
     *
     * @return an instance of the {@code TreeItemTreeModificationEventBuilder<T>}.
     */
    
    public static <T> TreeItemTreeModificationEventBuilder<T> create(javafx.event.EventType<? extends javafx.event.Event> eventType, javafx.scene.control.TreeItem<T> treeItem, T newValue) {
        TreeItemTreeModificationEventBuilder<T> builder = new TreeItemTreeModificationEventBuilder<T>();
        builder.constructorArgs = new Object[]{eventType, treeItem, newValue};
        return builder;
    }


    /**
     * Accepts the same arguments as {@link javafx.scene.control.TreeItem.TreeModificationEvent#TreeModificationEvent(EventType, TreeItem, boolean) TreeModificationEvent(EventType, TreeItem, boolean)}
     * and returns an instance of the {@code TreeItemTreeModificationEventBuilder<T>}.
     *
     * @return an instance of the {@code TreeItemTreeModificationEventBuilder<T>}.
     */
    
    public static <T> TreeItemTreeModificationEventBuilder<T> create(javafx.event.EventType<? extends javafx.event.Event> eventType, javafx.scene.control.TreeItem<T> treeItem, boolean expanded) {
        TreeItemTreeModificationEventBuilder<T> builder = new TreeItemTreeModificationEventBuilder<T>();
        builder.constructorArgs = new Object[]{eventType, treeItem, expanded};
        return builder;
    }


    /**
     * Accepts the same arguments as {@link javafx.scene.control.TreeItem.TreeModificationEvent#TreeModificationEvent(EventType, TreeItem, List, List) TreeModificationEvent(EventType, TreeItem, List, List)}
     * and returns an instance of the {@code TreeItemTreeModificationEventBuilder<T>}.
     *
     * @return an instance of the {@code TreeItemTreeModificationEventBuilder<T>}.
     */
    
    public static <T> TreeItemTreeModificationEventBuilder<T> create(javafx.event.EventType<? extends javafx.event.Event> eventType, javafx.scene.control.TreeItem<T> treeItem, java.util.List<? extends javafx.scene.control.TreeItem<T>> added, java.util.List<? extends javafx.scene.control.TreeItem<T>> removed) {
        TreeItemTreeModificationEventBuilder<T> builder = new TreeItemTreeModificationEventBuilder<T>();
        builder.constructorArgs = new Object[]{eventType, treeItem, added, removed};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.TreeItem.TreeModificationEvent<T>} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.TreeItem.TreeModificationEvent TreeModificationEvent} class
     */
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
     * Applies a function to the TreeModificationEvent instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TreeItemTreeModificationEventBuilder<T> apply(java.util.function.Consumer<javafx.scene.control.TreeItem.TreeModificationEvent<T>> func) {
        operations.add(func);
        return this;
    }
}
