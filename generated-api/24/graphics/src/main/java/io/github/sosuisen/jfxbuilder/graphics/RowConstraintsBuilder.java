
package io.github.sosuisen.jfxbuilder.graphics;


public class RowConstraintsBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.layout.RowConstraints>> operations = new java.util.ArrayList<>();
    private RowConstraintsBuilder() {}
    

    
    public static RowConstraintsBuilder create(double minHeight, double prefHeight, double maxHeight, javafx.scene.layout.Priority vgrow, javafx.geometry.VPos valignment, boolean fillHeight) {
        RowConstraintsBuilder builder = new RowConstraintsBuilder();
        builder.constructorArgs = new Object[]{minHeight, prefHeight, maxHeight, vgrow, valignment, fillHeight};
        return builder;
    }


    
    public static RowConstraintsBuilder create(double minHeight, double prefHeight, double maxHeight) {
        RowConstraintsBuilder builder = new RowConstraintsBuilder();
        builder.constructorArgs = new Object[]{minHeight, prefHeight, maxHeight};
        return builder;
    }


    
    public static RowConstraintsBuilder create(double height) {
        RowConstraintsBuilder builder = new RowConstraintsBuilder();
        builder.constructorArgs = new Object[]{height};
        return builder;
    }


    public static RowConstraintsBuilder create() { return new RowConstraintsBuilder(); }

    private Object[] constructorArgs;

    public javafx.scene.layout.RowConstraints build() {
        javafx.scene.layout.RowConstraints newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.layout.RowConstraints();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.layout.RowConstraints> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.layout.RowConstraints callParameterizedConstructor() {
        javafx.scene.layout.RowConstraints newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.layout.RowConstraints.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.layout.RowConstraints) constructor.newInstance(constructorArgs);
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
    
    public RowConstraintsBuilder apply(java.util.function.Consumer<javafx.scene.layout.RowConstraints> func) {
        operations.add(func);
        return this;
    }    
    
    public  RowConstraintsBuilder prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }    
    
    public  RowConstraintsBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }    
    
    public  RowConstraintsBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }    
    
    public  RowConstraintsBuilder vgrow(javafx.scene.layout.Priority value) {
        operations.add(obj -> obj.setVgrow(value));
        return this;
    }    
    
    public  RowConstraintsBuilder fillHeight(boolean value) {
        operations.add(obj -> obj.setFillHeight(value));
        return this;
    }    
    
    public  RowConstraintsBuilder valignment(javafx.geometry.VPos value) {
        operations.add(obj -> obj.setValignment(value));
        return this;
    }    
    
    public  RowConstraintsBuilder percentHeight(double value) {
        operations.add(obj -> obj.setPercentHeight(value));
        return this;
    }    
    
    public RowConstraintsBuilder prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    
    public RowConstraintsBuilder maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    
    public RowConstraintsBuilder minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    
    public RowConstraintsBuilder vgrowPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Priority>> op) {
        operations.add(obj -> op.accept(obj.vgrowProperty()));
        return this;
    }    
    
    public RowConstraintsBuilder fillHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.fillHeightProperty()));
        return this;
    }    
    
    public RowConstraintsBuilder valignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.VPos>> op) {
        operations.add(obj -> op.accept(obj.valignmentProperty()));
        return this;
    }    
    
    public RowConstraintsBuilder percentHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.percentHeightProperty()));
        return this;
    }
}
