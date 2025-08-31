
package io.github.sosuisen.jfxbuilder.graphics;


public class ScaleBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.transform.Scale>> operations = new java.util.ArrayList<>();
    private ScaleBuilder() {}
    

    public static ScaleBuilder create() { return new ScaleBuilder(); }


    
    public static ScaleBuilder create(double x, double y) {
        ScaleBuilder builder = new ScaleBuilder();
        builder.constructorArgs = new Object[]{x, y};
        return builder;
    }


    
    public static ScaleBuilder create(double x, double y, double z) {
        ScaleBuilder builder = new ScaleBuilder();
        builder.constructorArgs = new Object[]{x, y, z};
        return builder;
    }


    
    public static ScaleBuilder create(double x, double y, double pivotX, double pivotY) {
        ScaleBuilder builder = new ScaleBuilder();
        builder.constructorArgs = new Object[]{x, y, pivotX, pivotY};
        return builder;
    }


    
    public static ScaleBuilder create(double x, double y, double z, double pivotX, double pivotY, double pivotZ) {
        ScaleBuilder builder = new ScaleBuilder();
        builder.constructorArgs = new Object[]{x, y, z, pivotX, pivotY, pivotZ};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.transform.Scale build() {
        javafx.scene.transform.Scale newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.transform.Scale();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.transform.Scale> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.transform.Scale callParameterizedConstructor() {
        javafx.scene.transform.Scale newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.transform.Scale.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.transform.Scale) constructor.newInstance(constructorArgs);
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
    
    public ScaleBuilder apply(java.util.function.Consumer<javafx.scene.transform.Scale> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Scale#setOnTransformChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ScaleBuilder onTransformChanged(javafx.event.EventHandler<? super javafx.scene.transform.TransformChangedEvent> value) {
        operations.add(obj -> obj.setOnTransformChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Scale#setPivotX(double)}
     * 
     * @return builder instance
     */    
    
    public  ScaleBuilder pivotX(double value) {
        operations.add(obj -> obj.setPivotX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Scale#setPivotY(double)}
     * 
     * @return builder instance
     */    
    
    public  ScaleBuilder pivotY(double value) {
        operations.add(obj -> obj.setPivotY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Scale#setPivotZ(double)}
     * 
     * @return builder instance
     */    
    
    public  ScaleBuilder pivotZ(double value) {
        operations.add(obj -> obj.setPivotZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Scale#setX(double)}
     * 
     * @return builder instance
     */    
    
    public  ScaleBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Scale#setY(double)}
     * 
     * @return builder instance
     */    
    
    public  ScaleBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.transform.Scale#setZ(double)}
     * 
     * @return builder instance
     */    
    
    public  ScaleBuilder z(double value) {
        operations.add(obj -> obj.setZ(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Scale#identityProperty()}.
     * 
     * @return builder instance
     */    
    
    public ScaleBuilder identityPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.identityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Scale#onTransformChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ScaleBuilder onTransformChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.transform.TransformChangedEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTransformChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Scale#pivotXProperty()}.
     * 
     * @return builder instance
     */    
    
    public ScaleBuilder pivotXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pivotXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Scale#pivotYProperty()}.
     * 
     * @return builder instance
     */    
    
    public ScaleBuilder pivotYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pivotYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Scale#pivotZProperty()}.
     * 
     * @return builder instance
     */    
    
    public ScaleBuilder pivotZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.pivotZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Scale#type2DProperty()}.
     * 
     * @return builder instance
     */    
    
    public ScaleBuilder type2DPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.type2DProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Scale#xProperty()}.
     * 
     * @return builder instance
     */    
    
    public ScaleBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Scale#yProperty()}.
     * 
     * @return builder instance
     */    
    
    public ScaleBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.transform.Scale#zProperty()}.
     * 
     * @return builder instance
     */    
    
    public ScaleBuilder zPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.zProperty()));
        return this;
    }
}
