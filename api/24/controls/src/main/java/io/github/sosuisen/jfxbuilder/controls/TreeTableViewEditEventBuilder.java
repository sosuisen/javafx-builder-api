
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code TreeTableViewEditEventBuilder} class constructs instances of the {@link javafx.scene.control.TreeTableView.EditEvent EditEvent} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.TreeTableView.EditEvent EditEvent} constructor
 * and returns an instance of the {@code TreeTableViewEditEventBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.TreeTableView.EditEvent EditEvent}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.TreeTableView.EditEvent EditEvent} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */
@SuppressWarnings("rawtypes")
public class TreeTableViewEditEventBuilder<S> {
    private final java.util.List<java.util.function.Consumer<javafx.scene.control.TreeTableView.EditEvent<S>>> operations = new java.util.ArrayList<>();
    private TreeTableViewEditEventBuilder() {}
    
    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.TreeTableView.EditEvent#EditEvent(javafx.scene.control.TreeTableView, javafx.event.EventType, javafx.scene.control.TreeItem, java.lang.Object, java.lang.Object) EditEvent(TreeTableView, EventType, TreeItem, Object, Object)}
     * and returns an instance of {@code TreeTableViewEditEventBuilder<S>}.
     *
     * @return an instance of the {@code TreeTableViewEditEventBuilder<S>}.
     */
    public static <S> TreeTableViewEditEventBuilder<S> create(javafx.scene.control.TreeTableView<S> source, javafx.event.EventType<? extends javafx.scene.control.TreeTableView.EditEvent> eventType, javafx.scene.control.TreeItem<S> treeItem, S oldValue, S newValue) {
        TreeTableViewEditEventBuilder<S> builder = new TreeTableViewEditEventBuilder<S>();
        builder.constructorArgs = new Object[]{source, eventType, treeItem, oldValue, newValue};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.TreeTableView.EditEvent} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.TreeTableView.EditEvent EditEvent} class
     */
    public javafx.scene.control.TreeTableView.EditEvent<S> build() {
        javafx.scene.control.TreeTableView.EditEvent<S> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.TreeTableView.EditEvent<S>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.TreeTableView.EditEvent<S> callParameterizedConstructor() {
        javafx.scene.control.TreeTableView.EditEvent<S> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TreeTableView.EditEvent.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TreeTableView.EditEvent<S>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the EditEvent instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TreeTableViewEditEventBuilder<S> apply(java.util.function.Consumer<javafx.scene.control.TreeTableView.EditEvent<S>> func) {
        operations.add(func);
        return this;
    }
}
