
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code TriangleMeshBuilder} class constructs instances of the {@link javafx.scene.shape.TriangleMesh TriangleMesh} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.shape.TriangleMesh TriangleMesh} constructor
 * and returns an instance of the {@code TriangleMeshBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.shape.TriangleMesh TriangleMesh}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.shape.TriangleMesh TriangleMesh} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class TriangleMeshBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.shape.TriangleMesh>> operations = new java.util.ArrayList<>();
    private TriangleMeshBuilder() {}
    

    /**
     * Returns an instance of the {@code TriangleMeshBuilder}.
     *
     * @return an instance of the {@code TriangleMeshBuilder}.
     */
    public static TriangleMeshBuilder create() { return new TriangleMeshBuilder(); }


    /**
     * Accepts the same arguments as {@link javafx.scene.shape.TriangleMesh#TriangleMesh(VertexFormat) TriangleMesh(VertexFormat)}
     * and returns an instance of the {@code TriangleMeshBuilder}.
     *
     * @return an instance of the {@code TriangleMeshBuilder}.
     */
    
    public static TriangleMeshBuilder create(javafx.scene.shape.VertexFormat vertexFormat) {
        TriangleMeshBuilder builder = new TriangleMeshBuilder();
        builder.constructorArgs = new Object[]{vertexFormat};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.shape.TriangleMesh} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.shape.TriangleMesh TriangleMesh} class
     */
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
    /**
     * Applies a function to the TriangleMesh instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public TriangleMeshBuilder apply(java.util.function.Consumer<javafx.scene.shape.TriangleMesh> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.shape.TriangleMesh#setVertexFormat(javafx.scene.shape.VertexFormat)}
     * 
     * @return builder instance
     */    
    
    public  TriangleMeshBuilder vertexFormat(javafx.scene.shape.VertexFormat value) {
        operations.add(obj -> obj.setVertexFormat(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.shape.TriangleMesh#vertexFormatProperty() vertexFormatProperty} 
     * of the instance currently being constructed. 
     * This serves as a shorthand form of the {@link #apply(java.util.function.Consumer<javafx.scene.shape.TriangleMesh> func) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.vertexFormatProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .vertexFormatPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */    
    
    public TriangleMeshBuilder vertexFormatPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.VertexFormat>> op) {
        operations.add(obj -> op.accept(obj.vertexFormatProperty()));
        return this;
    }
}
