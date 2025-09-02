
package io.github.sosuisen.jfxbuilder.controls;


public class TreeTableViewResizeFeaturesBuilder<S> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.TreeTableView.ResizeFeatures<S>>> operations = new java.util.ArrayList<>();
    private TreeTableViewResizeFeaturesBuilder() {}
    

    
    public static <S> TreeTableViewResizeFeaturesBuilder<S> create(javafx.scene.control.TreeTableView<S> treeTable, javafx.scene.control.TreeTableColumn<S, ?> column, java.lang.Double delta) {
        TreeTableViewResizeFeaturesBuilder<S> builder = new TreeTableViewResizeFeaturesBuilder<S>();
        builder.constructorArgs = new Object[]{treeTable, column, delta};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.control.TreeTableView.ResizeFeatures<S> build() {
        javafx.scene.control.TreeTableView.ResizeFeatures<S> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.TreeTableView.ResizeFeatures<S>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.TreeTableView.ResizeFeatures<S> callParameterizedConstructor() {
        javafx.scene.control.TreeTableView.ResizeFeatures<S> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TreeTableView.ResizeFeatures.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TreeTableView.ResizeFeatures<S>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the ResizeFeatures instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(resizeFeatures -> resizeFeatures.setId("Main" + resizeFeatures.getTypeSelector()))
     * }</pre>
     * 
     * @return builder instance
     *
     */
    public TreeTableViewResizeFeaturesBuilder<S> apply(java.util.function.Consumer<javafx.scene.control.TreeTableView.ResizeFeatures<S>> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.TreeTableView.ResizeFeatures#setColumnWidth(javafx.scene.control.TableColumnBase, double)}
     * 
     * @return builder instance
     */    
    
    public  TreeTableViewResizeFeaturesBuilder<S> columnWidth(javafx.scene.control.TreeTableColumn<S, ?> col, double width) {
        operations.add(obj -> obj.setColumnWidth(col, width));
        return this;
    }
}
