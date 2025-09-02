
package io.github.sosuisen.jfxbuilder.graphics;


public class SnapshotParametersBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.SnapshotParameters>> operations = new java.util.ArrayList<>();
    private SnapshotParametersBuilder() {}
    

    public static SnapshotParametersBuilder create() { return new SnapshotParametersBuilder(); }

    private Object[] constructorArgs;

    /**
     * This method builds and returns an instance of the original class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the build() method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.SnapshotParameters SnapshotParameters} class
     */
    public javafx.scene.SnapshotParameters build() {
        javafx.scene.SnapshotParameters newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.SnapshotParameters();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.SnapshotParameters> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.SnapshotParameters callParameterizedConstructor() {
        javafx.scene.SnapshotParameters newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.SnapshotParameters.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.SnapshotParameters) constructor.newInstance(constructorArgs);
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
     * Applies a function to the SnapshotParameters instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public SnapshotParametersBuilder apply(java.util.function.Consumer<javafx.scene.SnapshotParameters> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.SnapshotParameters#setCamera(javafx.scene.Camera)}
     * 
     * @return builder instance
     */    
    
    public  SnapshotParametersBuilder camera(javafx.scene.Camera camera) {
        operations.add(obj -> obj.setCamera(camera));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.SnapshotParameters#setDepthBuffer(boolean)}
     * 
     * @return builder instance
     */    
    
    public  SnapshotParametersBuilder depthBuffer(boolean depthBuffer) {
        operations.add(obj -> obj.setDepthBuffer(depthBuffer));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.SnapshotParameters#setFill(javafx.scene.paint.Paint)}
     * 
     * @return builder instance
     */    
    
    public  SnapshotParametersBuilder fill(javafx.scene.paint.Paint fill) {
        operations.add(obj -> obj.setFill(fill));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.SnapshotParameters#setTransform(javafx.scene.transform.Transform)}
     * 
     * @return builder instance
     */    
    
    public  SnapshotParametersBuilder transform(javafx.scene.transform.Transform transform) {
        operations.add(obj -> obj.setTransform(transform));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.SnapshotParameters#setViewport(javafx.geometry.Rectangle2D)}
     * 
     * @return builder instance
     */    
    
    public  SnapshotParametersBuilder viewport(javafx.geometry.Rectangle2D viewport) {
        operations.add(obj -> obj.setViewport(viewport));
        return this;
    }
}
