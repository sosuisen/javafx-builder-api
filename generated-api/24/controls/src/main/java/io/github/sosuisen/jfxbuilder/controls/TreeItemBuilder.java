
package io.github.sosuisen.jfxbuilder.controls;


public class TreeItemBuilder<T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.TreeItem<T>>> operations = new java.util.ArrayList<>();
    private TreeItemBuilder() {}
    

    
    public static <T> TreeItemBuilder<T> create(T value) {
        TreeItemBuilder<T> builder = new TreeItemBuilder<T>();
        builder.constructorArgs = new Object[]{value};
        return builder;
    }


    public static <T> TreeItemBuilder<T> create() { return new TreeItemBuilder<T>(); }


    
    public static <T> TreeItemBuilder<T> create(T value, javafx.scene.Node graphic) {
        TreeItemBuilder<T> builder = new TreeItemBuilder<T>();
        builder.constructorArgs = new Object[]{value, graphic};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.control.TreeItem<T> build() {
        javafx.scene.control.TreeItem<T> newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.TreeItem<>();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.TreeItem<T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.TreeItem<T> callParameterizedConstructor() {
        javafx.scene.control.TreeItem<T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.TreeItem.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.TreeItem<T>) constructor.newInstance(constructorArgs);
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
    
    public TreeItemBuilder<T> apply(java.util.function.Consumer<javafx.scene.control.TreeItem<T>> func) {
        operations.add(func);
        return this;
    }    
    
    public  TreeItemBuilder<T> value(T value) {
        operations.add(obj -> obj.setValue(value));
        return this;
    }    
    
    public  TreeItemBuilder<T> graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }    
    
    public  TreeItemBuilder<T> expanded(boolean value) {
        operations.add(obj -> obj.setExpanded(value));
        return this;
    }
    @SafeVarargs
    public final TreeItemBuilder<T> addChildren(javafx.scene.control.TreeItem<T>... elements) {
        operations.add(obj -> {
            obj.getChildren().addAll(elements);
        });
        return this;
    }

    public final TreeItemBuilder<T> addChildren(java.util.Collection<? extends javafx.scene.control.TreeItem<T>> col) {
        operations.add(obj -> {
            obj.getChildren().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public static <T> TreeItemBuilder<T> withChildren(javafx.scene.control.TreeItem<T>... elements) {
        TreeItemBuilder<T> builder = new TreeItemBuilder<T>();
        return builder.addChildren(elements);
    }

    public static <T> TreeItemBuilder<T> withChildren(java.util.Collection<? extends javafx.scene.control.TreeItem<T>> col) {
        TreeItemBuilder<T> builder = new TreeItemBuilder<T>();
        return builder.addChildren(col);
    }
    
    
    public TreeItemBuilder<T> graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    
    public TreeItemBuilder<T> expandedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.expandedProperty()));
        return this;
    }    
    
    public TreeItemBuilder<T> leafPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.leafProperty()));
        return this;
    }    
    
    public TreeItemBuilder<T> parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TreeItem<T>>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    
    public TreeItemBuilder<T> valuePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<T>> op) {
        operations.add(obj -> op.accept(obj.valueProperty()));
        return this;
    }
}
