
package io.github.sosuisen.jfxbuilder.graphics;


public class TriangleMeshBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.shape.TriangleMesh>> operations = new java.util.ArrayList<>();
    private TriangleMeshBuilder() {}
    

    
    public static TriangleMeshBuilder create(javafx.scene.shape.VertexFormat vertexFormat) {
        TriangleMeshBuilder builder = new TriangleMeshBuilder();
        builder.constructorArgs = new Object[]{vertexFormat};
        return builder;
    }


    public static TriangleMeshBuilder create() { return new TriangleMeshBuilder(); }

    private Object[] constructorArgs;

    public javafx.scene.shape.TriangleMesh build() {
        javafx.scene.shape.TriangleMesh newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.shape.TriangleMesh();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.shape.TriangleMesh> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.shape.TriangleMesh callParameterizedConstructor() {
        javafx.scene.shape.TriangleMesh newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.shape.TriangleMesh.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.shape.TriangleMesh) constructor.newInstance(constructorArgs);
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
    
    public TriangleMeshBuilder apply(java.util.function.Consumer<javafx.scene.shape.TriangleMesh> func) {
        operations.add(func);
        return this;
    }    
    
    public  TriangleMeshBuilder vertexFormat(javafx.scene.shape.VertexFormat value) {
        operations.add(obj -> obj.setVertexFormat(value));
        return this;
    }    
    
    public TriangleMeshBuilder vertexFormatPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.VertexFormat>> op) {
        operations.add(obj -> op.accept(obj.vertexFormatProperty()));
        return this;
    }
}
