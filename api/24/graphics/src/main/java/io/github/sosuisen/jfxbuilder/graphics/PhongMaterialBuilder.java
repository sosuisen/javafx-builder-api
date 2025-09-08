
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code PhongMaterialBuilder} class constructs instances of the {@link javafx.scene.paint.PhongMaterial PhongMaterial} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.paint.PhongMaterial PhongMaterial} constructor
 * and returns an instance of the {@code PhongMaterialBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.paint.PhongMaterial PhongMaterial}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.paint.PhongMaterial PhongMaterial} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class PhongMaterialBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.paint.PhongMaterial>> operations = new java.util.ArrayList<>();
    private PhongMaterialBuilder() {}
    
    /**
     * Returns an instance of the {@code PhongMaterialBuilder}.
     *
     * @return an instance of the {@code PhongMaterialBuilder}.
     */
    public static PhongMaterialBuilder create() { return new PhongMaterialBuilder(); }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.paint.PhongMaterial#PhongMaterial(javafx.scene.paint.Color) PhongMaterial(Color)}
     * and returns an instance of {@code PhongMaterialBuilder}.
     *
     * @return an instance of the {@code PhongMaterialBuilder}.
     */
    public static PhongMaterialBuilder create(javafx.scene.paint.Color diffuseColor) {
        PhongMaterialBuilder builder = new PhongMaterialBuilder();
        builder.constructorArgs = new Object[]{diffuseColor};
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.paint.PhongMaterial#PhongMaterial(javafx.scene.paint.Color, javafx.scene.image.Image, javafx.scene.image.Image, javafx.scene.image.Image, javafx.scene.image.Image) PhongMaterial(Color, Image, Image, Image, Image)}
     * and returns an instance of {@code PhongMaterialBuilder}.
     *
     * @return an instance of the {@code PhongMaterialBuilder}.
     */
    public static PhongMaterialBuilder create(javafx.scene.paint.Color diffuseColor, javafx.scene.image.Image diffuseMap, javafx.scene.image.Image specularMap, javafx.scene.image.Image bumpMap, javafx.scene.image.Image selfIlluminationMap) {
        PhongMaterialBuilder builder = new PhongMaterialBuilder();
        builder.constructorArgs = new Object[]{diffuseColor, diffuseMap, specularMap, bumpMap, selfIlluminationMap};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.paint.PhongMaterial} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.paint.PhongMaterial PhongMaterial} class
     */
    public javafx.scene.paint.PhongMaterial build() {
        javafx.scene.paint.PhongMaterial newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.paint.PhongMaterial();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.paint.PhongMaterial> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.paint.PhongMaterial callParameterizedConstructor() {
        javafx.scene.paint.PhongMaterial newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.paint.PhongMaterial.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.paint.PhongMaterial) constructor.newInstance(constructorArgs);
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
     * Applies a function to the PhongMaterial instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public PhongMaterialBuilder apply(java.util.function.Consumer<javafx.scene.paint.PhongMaterial> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.paint.PhongMaterial#setBumpMap(javafx.scene.image.Image) setBumpMap} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PhongMaterialBuilder bumpMap(javafx.scene.image.Image value) {
        operations.add(obj -> obj.setBumpMap(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.paint.PhongMaterial#setDiffuseColor(javafx.scene.paint.Color) setDiffuseColor} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PhongMaterialBuilder diffuseColor(javafx.scene.paint.Color value) {
        operations.add(obj -> obj.setDiffuseColor(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.paint.PhongMaterial#setDiffuseMap(javafx.scene.image.Image) setDiffuseMap} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PhongMaterialBuilder diffuseMap(javafx.scene.image.Image value) {
        operations.add(obj -> obj.setDiffuseMap(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.paint.PhongMaterial#setSelfIlluminationMap(javafx.scene.image.Image) setSelfIlluminationMap} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PhongMaterialBuilder selfIlluminationMap(javafx.scene.image.Image value) {
        operations.add(obj -> obj.setSelfIlluminationMap(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.paint.PhongMaterial#setSpecularColor(javafx.scene.paint.Color) setSpecularColor} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PhongMaterialBuilder specularColor(javafx.scene.paint.Color value) {
        operations.add(obj -> obj.setSpecularColor(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.paint.PhongMaterial#setSpecularMap(javafx.scene.image.Image) setSpecularMap} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PhongMaterialBuilder specularMap(javafx.scene.image.Image value) {
        operations.add(obj -> obj.setSpecularMap(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.paint.PhongMaterial#setSpecularPower(double) setSpecularPower} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  PhongMaterialBuilder specularPower(double value) {
        operations.add(obj -> obj.setSpecularPower(value));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.paint.PhongMaterial#bumpMapProperty() bumpMapProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PhongMaterialBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.bumpMapProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .bumpMapPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public PhongMaterialBuilder bumpMapPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.image.Image>> op) {
        operations.add(obj -> op.accept(obj.bumpMapProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.paint.PhongMaterial#diffuseColorProperty() diffuseColorProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PhongMaterialBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.diffuseColorProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .diffuseColorPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public PhongMaterialBuilder diffuseColorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Color>> op) {
        operations.add(obj -> op.accept(obj.diffuseColorProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.paint.PhongMaterial#diffuseMapProperty() diffuseMapProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PhongMaterialBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.diffuseMapProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .diffuseMapPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public PhongMaterialBuilder diffuseMapPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.image.Image>> op) {
        operations.add(obj -> op.accept(obj.diffuseMapProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.paint.PhongMaterial#selfIlluminationMapProperty() selfIlluminationMapProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PhongMaterialBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.selfIlluminationMapProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .selfIlluminationMapPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public PhongMaterialBuilder selfIlluminationMapPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.image.Image>> op) {
        operations.add(obj -> op.accept(obj.selfIlluminationMapProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.paint.PhongMaterial#specularColorProperty() specularColorProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PhongMaterialBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.specularColorProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .specularColorPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public PhongMaterialBuilder specularColorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Color>> op) {
        operations.add(obj -> op.accept(obj.specularColorProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.paint.PhongMaterial#specularMapProperty() specularMapProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PhongMaterialBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.specularMapProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .specularMapPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public PhongMaterialBuilder specularMapPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.image.Image>> op) {
        operations.add(obj -> op.accept(obj.specularMapProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.paint.PhongMaterial#specularPowerProperty() specularPowerProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link PhongMaterialBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.specularPowerProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .specularPowerPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public PhongMaterialBuilder specularPowerPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.specularPowerProperty()));
        return this;
    }
}
