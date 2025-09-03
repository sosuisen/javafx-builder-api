
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code TableColumnCellDataFeaturesBuilder} class constructs instances of the {@link javafx.scene.control.TableColumn.CellDataFeatures CellDataFeatures} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.TableColumn.CellDataFeatures CellDataFeatures} constructor
 * and returns an instance of the {@code TableColumnCellDataFeaturesBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.TableColumn.CellDataFeatures CellDataFeatures}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.TableColumn.CellDataFeatures CellDataFeatures} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class TableColumnCellDataFeaturesBuilder<S, T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.TableColumn.CellDataFeatures<S, T>>> operations = new java.util.ArrayList<>();
    private TableColumnCellDataFeaturesBuilder() {}
    

    /**
     * Accepts the same arguments as {@link javafx.scene.control.TableColumn.CellDataFeatures#CellDataFeatures(javafx.scene.control.TableView<S> tableView, javafx.scene.control.TableColumn<S, T> tableColumn, S value) CellDataFeatures(TableView, TableColumn, Object)}
     * and returns an instance of the {@code <S, T> TableColumnCellDataFeaturesBuilder<S, T>}.
     *
     * @return an instance of the {@code <S, T> TableColumnCellDataFeaturesBuilder<S, T>}.
     */
    
    public static <S, T> TableColumnCellDataFeaturesBuilder<S, T> create(javafx.scene.control.TableView<S> tableView, javafx.scene.control.TableColumn<S, T> tableColumn, S value) {
        TableColumnCellDataFeaturesBuilder<S, T> builder = new TableColumnCellDataFeaturesBuilder<S, T>();
        builder.constructorArgs = new Object[]{tableView, tableColumn, value};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * This method builds and returns an instance of the original class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the build() method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.TableColumn.CellDataFeatures CellDataFeatures} class
     */
    public javafx.scene.control.TableColumn.CellDataFeatures<S, T> build() {
        javafx.scene.control.TableColumn.CellDataFeatures<S, T> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.TableColumn.CellDataFeatures<S, T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.TableColumn.CellDataFeatures<S, T> callParameterizedConstructor() {
        javafx.scene.control.TableColumn.CellDataFeatures<S, T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TableColumn.CellDataFeatures.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TableColumn.CellDataFeatures<S, T>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the CellDataFeatures instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TableColumnCellDataFeaturesBuilder<S, T> apply(java.util.function.Consumer<javafx.scene.control.TableColumn.CellDataFeatures<S, T>> func) {
        operations.add(func);
        return this;
    }
}
