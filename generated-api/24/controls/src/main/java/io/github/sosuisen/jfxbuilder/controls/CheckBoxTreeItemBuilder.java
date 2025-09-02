
package io.github.sosuisen.jfxbuilder.controls;


public class CheckBoxTreeItemBuilder<T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.CheckBoxTreeItem<T>>> operations = new java.util.ArrayList<>();
    private CheckBoxTreeItemBuilder() {}
    

    public static <T> CheckBoxTreeItemBuilder<T> create() { return new CheckBoxTreeItemBuilder<T>(); }


    
    public static <T> CheckBoxTreeItemBuilder<T> create(T value) {
        CheckBoxTreeItemBuilder<T> builder = new CheckBoxTreeItemBuilder<T>();
        builder.constructorArgs = new Object[]{value};
        return builder;
    }


    
    public static <T> CheckBoxTreeItemBuilder<T> create(T value, javafx.scene.Node graphic) {
        CheckBoxTreeItemBuilder<T> builder = new CheckBoxTreeItemBuilder<T>();
        builder.constructorArgs = new Object[]{value, graphic};
        return builder;
    }


    
    public static <T> CheckBoxTreeItemBuilder<T> create(T value, javafx.scene.Node graphic, boolean selected) {
        CheckBoxTreeItemBuilder<T> builder = new CheckBoxTreeItemBuilder<T>();
        builder.constructorArgs = new Object[]{value, graphic, selected};
        return builder;
    }


    
    public static <T> CheckBoxTreeItemBuilder<T> create(T value, javafx.scene.Node graphic, boolean selected, boolean independent) {
        CheckBoxTreeItemBuilder<T> builder = new CheckBoxTreeItemBuilder<T>();
        builder.constructorArgs = new Object[]{value, graphic, selected, independent};
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
     * @return new instance of the {@link javafx.scene.control.CheckBoxTreeItem CheckBoxTreeItem} class
     */
    public javafx.scene.control.CheckBoxTreeItem<T> build() {
        javafx.scene.control.CheckBoxTreeItem<T> newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.CheckBoxTreeItem<>();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.CheckBoxTreeItem<T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.CheckBoxTreeItem<T> callParameterizedConstructor() {
        javafx.scene.control.CheckBoxTreeItem<T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.CheckBoxTreeItem.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.CheckBoxTreeItem<T>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the CheckBoxTreeItem instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public CheckBoxTreeItemBuilder<T> apply(java.util.function.Consumer<javafx.scene.control.CheckBoxTreeItem<T>> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CheckBoxTreeItem#setExpanded(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTreeItemBuilder<T> expanded(boolean value) {
        operations.add(obj -> obj.setExpanded(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CheckBoxTreeItem#setGraphic(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTreeItemBuilder<T> graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CheckBoxTreeItem#setIndependent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTreeItemBuilder<T> independent(boolean value) {
        operations.add(obj -> obj.setIndependent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CheckBoxTreeItem#setIndeterminate(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTreeItemBuilder<T> indeterminate(boolean value) {
        operations.add(obj -> obj.setIndeterminate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CheckBoxTreeItem#setSelected(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTreeItemBuilder<T> selected(boolean value) {
        operations.add(obj -> obj.setSelected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.CheckBoxTreeItem#setValue(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTreeItemBuilder<T> value(T value) {
        operations.add(obj -> obj.setValue(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.CheckBoxTreeItem#getChildren()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final CheckBoxTreeItemBuilder<T> addChildren(javafx.scene.control.TreeItem<T>... elements) {
        operations.add(obj -> {
            obj.getChildren().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.CheckBoxTreeItem#getChildren()} method.
     * 
     * @return builder instance
     */
    public final CheckBoxTreeItemBuilder<T> addChildren(java.util.Collection<? extends javafx.scene.control.TreeItem<T>> col) {
        operations.add(obj -> {
            obj.getChildren().addAll(col);
        });
        return this;
    }


    /**
     * Create an instance of the builder, then call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.CheckBoxTreeItem#getChildren()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public static <T> CheckBoxTreeItemBuilder<T> withChildren(javafx.scene.control.TreeItem<T>... elements) {
        CheckBoxTreeItemBuilder<T> builder = new CheckBoxTreeItemBuilder<T>();
        return builder.addChildren(elements);
    }

    /**
     * Create an instance of the builder, then call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.CheckBoxTreeItem#getChildren()} method.
     * 
     * @return builder instance
     */
    public static <T> CheckBoxTreeItemBuilder<T> withChildren(java.util.Collection<? extends javafx.scene.control.TreeItem<T>> col) {
        CheckBoxTreeItemBuilder<T> builder = new CheckBoxTreeItemBuilder<T>();
        return builder.addChildren(col);
    }

    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckBoxTreeItem#expandedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTreeItemBuilder<T> expandedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.expandedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckBoxTreeItem#graphicProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTreeItemBuilder<T> graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckBoxTreeItem#independentProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTreeItemBuilder<T> independentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.independentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckBoxTreeItem#indeterminateProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTreeItemBuilder<T> indeterminatePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.indeterminateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckBoxTreeItem#leafProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTreeItemBuilder<T> leafPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.leafProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckBoxTreeItem#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTreeItemBuilder<T> parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TreeItem<T>>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckBoxTreeItem#selectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTreeItemBuilder<T> selectedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.selectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.CheckBoxTreeItem#valueProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTreeItemBuilder<T> valuePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<T>> op) {
        operations.add(obj -> op.accept(obj.valueProperty()));
        return this;
    }
}
