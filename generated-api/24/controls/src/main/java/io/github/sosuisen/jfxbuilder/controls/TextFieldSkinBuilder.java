
package io.github.sosuisen.jfxbuilder.controls;


public class TextFieldSkinBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.skin.TextFieldSkin>> operations = new java.util.ArrayList<>();
    private TextFieldSkinBuilder() {}
    

    
    public static TextFieldSkinBuilder create(javafx.scene.control.TextField control) {
        TextFieldSkinBuilder builder = new TextFieldSkinBuilder();
        builder.constructorArgs = new Object[]{control};
        return builder;
    }

    private Object[] constructorArgs;

    public javafx.scene.control.skin.TextFieldSkin build() {
        javafx.scene.control.skin.TextFieldSkin newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.control.skin.TextFieldSkin> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.skin.TextFieldSkin callParameterizedConstructor() {
        javafx.scene.control.skin.TextFieldSkin newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.skin.TextFieldSkin.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.skin.TextFieldSkin) constructor.newInstance(constructorArgs);
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
    
    public TextFieldSkinBuilder apply(java.util.function.Consumer<javafx.scene.control.skin.TextFieldSkin> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TextFieldSkin#setCaretAnimating(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TextFieldSkinBuilder caretAnimating(boolean value) {
        operations.add(obj -> obj.setCaretAnimating(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.skin.TextFieldSkin#setForwardBias(boolean)}
     * 
     * @return builder instance
     */    
    
    public  TextFieldSkinBuilder forwardBias(boolean isLeading) {
        operations.add(obj -> obj.setForwardBias(isLeading));
        return this;
    }
    @SafeVarargs
    public final TextFieldSkinBuilder addChildren(javafx.scene.Node... elements) {
        operations.add(obj -> {
            obj.getChildren().addAll(elements);
        });
        return this;
    }

    public final TextFieldSkinBuilder addChildren(java.util.Collection<? extends javafx.scene.Node> col) {
        operations.add(obj -> {
            obj.getChildren().addAll(col);
        });
        return this;
    }


}
