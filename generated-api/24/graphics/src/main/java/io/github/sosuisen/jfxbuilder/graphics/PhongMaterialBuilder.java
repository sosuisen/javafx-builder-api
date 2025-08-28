
package io.github.sosuisen.jfxbuilder.graphics;


public class PhongMaterialBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.paint.PhongMaterial>> operations = new java.util.ArrayList<>();
    private PhongMaterialBuilder() {}
    

    
    public static PhongMaterialBuilder create(javafx.scene.paint.Color diffuseColor, javafx.scene.image.Image diffuseMap, javafx.scene.image.Image specularMap, javafx.scene.image.Image bumpMap, javafx.scene.image.Image selfIlluminationMap) {
        PhongMaterialBuilder builder = new PhongMaterialBuilder();
        builder.constructorArgs = new Object[]{diffuseColor, diffuseMap, specularMap, bumpMap, selfIlluminationMap};
        return builder;
    }


    
    public static PhongMaterialBuilder create(javafx.scene.paint.Color diffuseColor) {
        PhongMaterialBuilder builder = new PhongMaterialBuilder();
        builder.constructorArgs = new Object[]{diffuseColor};
        return builder;
    }


    public static PhongMaterialBuilder create() { return new PhongMaterialBuilder(); }

    private Object[] constructorArgs;

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
    
    public PhongMaterialBuilder apply(java.util.function.Consumer<javafx.scene.paint.PhongMaterial> func) {
        operations.add(func);
        return this;
    }    
    
    public  PhongMaterialBuilder diffuseColor(javafx.scene.paint.Color value) {
        operations.add(obj -> obj.setDiffuseColor(value));
        return this;
    }    
    
    public  PhongMaterialBuilder specularColor(javafx.scene.paint.Color value) {
        operations.add(obj -> obj.setSpecularColor(value));
        return this;
    }    
    
    public  PhongMaterialBuilder diffuseMap(javafx.scene.image.Image value) {
        operations.add(obj -> obj.setDiffuseMap(value));
        return this;
    }    
    
    public  PhongMaterialBuilder specularMap(javafx.scene.image.Image value) {
        operations.add(obj -> obj.setSpecularMap(value));
        return this;
    }    
    
    public  PhongMaterialBuilder specularPower(double value) {
        operations.add(obj -> obj.setSpecularPower(value));
        return this;
    }    
    
    public  PhongMaterialBuilder bumpMap(javafx.scene.image.Image value) {
        operations.add(obj -> obj.setBumpMap(value));
        return this;
    }    
    
    public  PhongMaterialBuilder selfIlluminationMap(javafx.scene.image.Image value) {
        operations.add(obj -> obj.setSelfIlluminationMap(value));
        return this;
    }    
    
    public PhongMaterialBuilder bumpMapPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.image.Image>> op) {
        operations.add(obj -> op.accept(obj.bumpMapProperty()));
        return this;
    }    
    
    public PhongMaterialBuilder diffuseMapPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.image.Image>> op) {
        operations.add(obj -> op.accept(obj.diffuseMapProperty()));
        return this;
    }    
    
    public PhongMaterialBuilder selfIlluminationMapPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.image.Image>> op) {
        operations.add(obj -> op.accept(obj.selfIlluminationMapProperty()));
        return this;
    }    
    
    public PhongMaterialBuilder specularMapPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.image.Image>> op) {
        operations.add(obj -> op.accept(obj.specularMapProperty()));
        return this;
    }    
    
    public PhongMaterialBuilder diffuseColorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Color>> op) {
        operations.add(obj -> op.accept(obj.diffuseColorProperty()));
        return this;
    }    
    
    public PhongMaterialBuilder specularColorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Color>> op) {
        operations.add(obj -> op.accept(obj.specularColorProperty()));
        return this;
    }    
    
    public PhongMaterialBuilder specularPowerPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.specularPowerProperty()));
        return this;
    }
}
