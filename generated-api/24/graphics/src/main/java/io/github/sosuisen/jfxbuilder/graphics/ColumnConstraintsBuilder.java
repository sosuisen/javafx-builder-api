
package io.github.sosuisen.jfxbuilder.graphics;


public class ColumnConstraintsBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.layout.ColumnConstraints>> operations = new java.util.ArrayList<>();
    private ColumnConstraintsBuilder() {}
    

    public static ColumnConstraintsBuilder create() { return new ColumnConstraintsBuilder(); }


    
    public static ColumnConstraintsBuilder create(double width) {
        ColumnConstraintsBuilder builder = new ColumnConstraintsBuilder();
        builder.constructorArgs = new Object[]{width};
        return builder;
    }


    
    public static ColumnConstraintsBuilder create(double minWidth, double prefWidth, double maxWidth) {
        ColumnConstraintsBuilder builder = new ColumnConstraintsBuilder();
        builder.constructorArgs = new Object[]{minWidth, prefWidth, maxWidth};
        return builder;
    }


    
    public static ColumnConstraintsBuilder create(double minWidth, double prefWidth, double maxWidth, javafx.scene.layout.Priority hgrow, javafx.geometry.HPos halignment, boolean fillWidth) {
        ColumnConstraintsBuilder builder = new ColumnConstraintsBuilder();
        builder.constructorArgs = new Object[]{minWidth, prefWidth, maxWidth, hgrow, halignment, fillWidth};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.layout.ColumnConstraints build() {
        javafx.scene.layout.ColumnConstraints newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.layout.ColumnConstraints();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.layout.ColumnConstraints> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.layout.ColumnConstraints callParameterizedConstructor() {
        javafx.scene.layout.ColumnConstraints newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.layout.ColumnConstraints.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.layout.ColumnConstraints) constructor.newInstance(constructorArgs);
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
     * Applies a function to the ColumnConstraints instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public ColumnConstraintsBuilder apply(java.util.function.Consumer<javafx.scene.layout.ColumnConstraints> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.ColumnConstraints#setFillWidth(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ColumnConstraintsBuilder fillWidth(boolean value) {
        operations.add(obj -> obj.setFillWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.ColumnConstraints#setHalignment(javafx.geometry.HPos)}
     * 
     * @return builder instance
     */    
    
    public  ColumnConstraintsBuilder halignment(javafx.geometry.HPos value) {
        operations.add(obj -> obj.setHalignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.ColumnConstraints#setHgrow(javafx.scene.layout.Priority)}
     * 
     * @return builder instance
     */    
    
    public  ColumnConstraintsBuilder hgrow(javafx.scene.layout.Priority value) {
        operations.add(obj -> obj.setHgrow(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.ColumnConstraints#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ColumnConstraintsBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.ColumnConstraints#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ColumnConstraintsBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.ColumnConstraints#setPercentWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ColumnConstraintsBuilder percentWidth(double value) {
        operations.add(obj -> obj.setPercentWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.layout.ColumnConstraints#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ColumnConstraintsBuilder prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.ColumnConstraints#fillWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ColumnConstraintsBuilder fillWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.fillWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.ColumnConstraints#halignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public ColumnConstraintsBuilder halignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.HPos>> op) {
        operations.add(obj -> op.accept(obj.halignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.ColumnConstraints#hgrowProperty()}.
     * 
     * @return builder instance
     */    
    
    public ColumnConstraintsBuilder hgrowPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Priority>> op) {
        operations.add(obj -> op.accept(obj.hgrowProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.ColumnConstraints#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ColumnConstraintsBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.ColumnConstraints#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ColumnConstraintsBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.ColumnConstraints#percentWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ColumnConstraintsBuilder percentWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.percentWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.layout.ColumnConstraints#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ColumnConstraintsBuilder prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }
}
