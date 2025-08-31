
package io.github.sosuisen.jfxbuilder.graphics;


public class ArcToBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.shape.ArcTo>> operations = new java.util.ArrayList<>();
    private ArcToBuilder() {}
    

    public static ArcToBuilder create() { return new ArcToBuilder(); }


    
    public static ArcToBuilder create(double radiusX, double radiusY, double xAxisRotation, double x, double y, boolean largeArcFlag, boolean sweepFlag) {
        ArcToBuilder builder = new ArcToBuilder();
        builder.constructorArgs = new Object[]{radiusX, radiusY, xAxisRotation, x, y, largeArcFlag, sweepFlag};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.shape.ArcTo build() {
        javafx.scene.shape.ArcTo newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.shape.ArcTo();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.shape.ArcTo> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.shape.ArcTo callParameterizedConstructor() {
        javafx.scene.shape.ArcTo newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.shape.ArcTo.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.shape.ArcTo) constructor.newInstance(constructorArgs);
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
    
    public ArcToBuilder apply(java.util.function.Consumer<javafx.scene.shape.ArcTo> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.ArcTo#setAbsolute(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ArcToBuilder absolute(boolean value) {
        operations.add(obj -> obj.setAbsolute(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.ArcTo#setLargeArcFlag(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ArcToBuilder largeArcFlag(boolean value) {
        operations.add(obj -> obj.setLargeArcFlag(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.ArcTo#setRadiusX(double)}
     * 
     * @return builder instance
     */    
    
    public  ArcToBuilder radiusX(double value) {
        operations.add(obj -> obj.setRadiusX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.ArcTo#setRadiusY(double)}
     * 
     * @return builder instance
     */    
    
    public  ArcToBuilder radiusY(double value) {
        operations.add(obj -> obj.setRadiusY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.ArcTo#setSweepFlag(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ArcToBuilder sweepFlag(boolean value) {
        operations.add(obj -> obj.setSweepFlag(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.ArcTo#setX(double)}
     * 
     * @return builder instance
     */    
    
    public  ArcToBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.ArcTo#setXAxisRotation(double)}
     * 
     * @return builder instance
     */    
    
    public  ArcToBuilder xAxisRotation(double value) {
        operations.add(obj -> obj.setXAxisRotation(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.ArcTo#setY(double)}
     * 
     * @return builder instance
     */    
    
    public  ArcToBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.ArcTo#XAxisRotationProperty()}.
     * 
     * @return builder instance
     */    
    
    public ArcToBuilder XAxisRotationPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.XAxisRotationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.ArcTo#absoluteProperty()}.
     * 
     * @return builder instance
     */    
    
    public ArcToBuilder absolutePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.absoluteProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.ArcTo#largeArcFlagProperty()}.
     * 
     * @return builder instance
     */    
    
    public ArcToBuilder largeArcFlagPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.largeArcFlagProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.ArcTo#radiusXProperty()}.
     * 
     * @return builder instance
     */    
    
    public ArcToBuilder radiusXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.radiusXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.ArcTo#radiusYProperty()}.
     * 
     * @return builder instance
     */    
    
    public ArcToBuilder radiusYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.radiusYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.ArcTo#sweepFlagProperty()}.
     * 
     * @return builder instance
     */    
    
    public ArcToBuilder sweepFlagPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.sweepFlagProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.ArcTo#xProperty()}.
     * 
     * @return builder instance
     */    
    
    public ArcToBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.ArcTo#yProperty()}.
     * 
     * @return builder instance
     */    
    
    public ArcToBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
