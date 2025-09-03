
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code TableColumnCellEditEventBuilder} class constructs instances of the {@link javafx.scene.control.TableColumn.CellEditEvent CellEditEvent} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.TableColumn.CellEditEvent CellEditEvent} constructor
 * and returns an instance of the {@code TableColumnCellEditEventBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.TableColumn.CellEditEvent CellEditEvent}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.TableColumn.CellEditEvent CellEditEvent} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class TableColumnCellEditEventBuilder<S, T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.TableColumn.CellEditEvent<S, T>>> operations = new java.util.ArrayList<>();
    private TableColumnCellEditEventBuilder() {}
    

    /**
     * Accepts the constructor arguments of {@link javafx.scene.control.TableColumn.CellEditEvent#CellEditEvent(TableView, TablePosition, EventType, Object) CellEditEvent(TableView, TablePosition, EventType, Object)}
     * and returns an instance of {@code TableColumnCellEditEventBuilder<S, T>}.
     *
     * @return an instance of the {@code TableColumnCellEditEventBuilder<S, T>}.
     */
    
    public static <S, T> TableColumnCellEditEventBuilder<S, T> create(javafx.scene.control.TableView<S> table, javafx.scene.control.TablePosition<S, T> pos, javafx.event.EventType<javafx.scene.control.TableColumn.CellEditEvent<S, T>> eventType, T newValue) {
        TableColumnCellEditEventBuilder<S, T> builder = new TableColumnCellEditEventBuilder<S, T>();
        builder.constructorArgs = new Object[]{table, pos, eventType, newValue};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.control.TableColumn.CellEditEvent<S, T>} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.TableColumn.CellEditEvent CellEditEvent} class
     */
    public javafx.scene.control.TableColumn.CellEditEvent<S, T> build() {
        javafx.scene.control.TableColumn.CellEditEvent<S, T> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.TableColumn.CellEditEvent<S, T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.TableColumn.CellEditEvent<S, T> callParameterizedConstructor() {
        javafx.scene.control.TableColumn.CellEditEvent<S, T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TableColumn.CellEditEvent.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TableColumn.CellEditEvent<S, T>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the CellEditEvent instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TableColumnCellEditEventBuilder<S, T> apply(java.util.function.Consumer<javafx.scene.control.TableColumn.CellEditEvent<S, T>> func) {
        operations.add(func);
        return this;
    }
}
