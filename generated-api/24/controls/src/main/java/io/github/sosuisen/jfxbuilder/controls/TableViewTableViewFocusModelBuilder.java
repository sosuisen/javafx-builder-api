
package io.github.sosuisen.jfxbuilder.controls;


public class TableViewTableViewFocusModelBuilder<S> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.TableView.TableViewFocusModel<S>>> operations = new java.util.ArrayList<>();
    private TableViewTableViewFocusModelBuilder() {}
    

    
    public static <S> TableViewTableViewFocusModelBuilder<S> create(javafx.scene.control.TableView<S> tableView) {
        TableViewTableViewFocusModelBuilder<S> builder = new TableViewTableViewFocusModelBuilder<S>();
        builder.constructorArgs = new Object[]{tableView};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.control.TableView.TableViewFocusModel<S> build() {
        javafx.scene.control.TableView.TableViewFocusModel<S> newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.TableView.TableViewFocusModel<S>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.TableView.TableViewFocusModel<S> callParameterizedConstructor() {
        javafx.scene.control.TableView.TableViewFocusModel<S> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TableView.TableViewFocusModel.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TableView.TableViewFocusModel<S>) constructor.newInstance(constructorArgs);
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
    
    public TableViewTableViewFocusModelBuilder<S> apply(java.util.function.Consumer<javafx.scene.control.TableView.TableViewFocusModel<S>> func) {
        operations.add(func);
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView.TableViewFocusModel#focusedCellProperty()}.
     * 
     * @return builder instance
     */    
    @SuppressWarnings("rawtypes")
    public TableViewTableViewFocusModelBuilder<S> focusedCellPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TablePosition>> op) {
        operations.add(obj -> op.accept(obj.focusedCellProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView.TableViewFocusModel#focusedIndexProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewTableViewFocusModelBuilder<S> focusedIndexPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyIntegerProperty> op) {
        operations.add(obj -> op.accept(obj.focusedIndexProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.TableView.TableViewFocusModel#focusedItemProperty()}.
     * 
     * @return builder instance
     */    
    
    public TableViewTableViewFocusModelBuilder<S> focusedItemPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<S>> op) {
        operations.add(obj -> op.accept(obj.focusedItemProperty()));
        return this;
    }
}
