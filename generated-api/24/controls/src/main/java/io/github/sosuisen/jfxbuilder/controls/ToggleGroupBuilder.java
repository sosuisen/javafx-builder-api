
package io.github.sosuisen.jfxbuilder.controls;


public class ToggleGroupBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.ToggleGroup>> operations = new java.util.ArrayList<>();
    private ToggleGroupBuilder() {}
    

    public static ToggleGroupBuilder create() { return new ToggleGroupBuilder(); }

    private Object[] constructorArgs;

    public javafx.scene.control.ToggleGroup build() {
        javafx.scene.control.ToggleGroup newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.ToggleGroup();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.ToggleGroup> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.ToggleGroup callParameterizedConstructor() {
        javafx.scene.control.ToggleGroup newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.ToggleGroup.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.ToggleGroup) constructor.newInstance(constructorArgs);
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
    
    public ToggleGroupBuilder apply(java.util.function.Consumer<javafx.scene.control.ToggleGroup> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.ToggleGroup#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  ToggleGroupBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    @SafeVarargs
    public final ToggleGroupBuilder addToggles(javafx.scene.control.Toggle... elements) {
        operations.add(obj -> {
            obj.getToggles().addAll(elements);
        });
        return this;
    }

    public final ToggleGroupBuilder addToggles(java.util.Collection<? extends javafx.scene.control.Toggle> col) {
        operations.add(obj -> {
            obj.getToggles().addAll(col);
        });
        return this;
    }


    @SafeVarargs
    public static ToggleGroupBuilder withToggles(javafx.scene.control.Toggle... elements) {
        ToggleGroupBuilder builder = new ToggleGroupBuilder();
        return builder.addToggles(elements);
    }

    public static ToggleGroupBuilder withToggles(java.util.Collection<? extends javafx.scene.control.Toggle> col) {
        ToggleGroupBuilder builder = new ToggleGroupBuilder();
        return builder.addToggles(col);
    }
    
    /**
     * Applies a function to the {@link javafx.scene.control.ToggleGroup#selectedToggleProperty()}.
     * 
     * @return builder instance
     */    
    
    public ToggleGroupBuilder selectedTogglePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.Toggle>> op) {
        operations.add(obj -> op.accept(obj.selectedToggleProperty()));
        return this;
    }
}
