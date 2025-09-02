
package io.github.sosuisen.jfxbuilder.controls;


public class SplitPaneDividerBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.SplitPane.Divider>> operations = new java.util.ArrayList<>();
    private SplitPaneDividerBuilder() {}
    

    public static SplitPaneDividerBuilder create() { return new SplitPaneDividerBuilder(); }

    private Object[] constructorArgs;

    /**
     * This method builds and returns an instance of the original class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the build() method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.SplitPane.Divider Divider} class
     */
    public javafx.scene.control.SplitPane.Divider build() {
        javafx.scene.control.SplitPane.Divider newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.SplitPane.Divider();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.SplitPane.Divider> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.control.SplitPane.Divider callParameterizedConstructor() {
        javafx.scene.control.SplitPane.Divider newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.SplitPane.Divider.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.SplitPane.Divider) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Divider instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public SplitPaneDividerBuilder apply(java.util.function.Consumer<javafx.scene.control.SplitPane.Divider> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.SplitPane.Divider#setPosition(double)}
     * 
     * @return builder instance
     */    
    
    public  SplitPaneDividerBuilder position(double value) {
        operations.add(obj -> obj.setPosition(value));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.SplitPane.Divider#positionProperty()}.
     * 
     * @return builder instance
     */    
    
    public SplitPaneDividerBuilder positionPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.positionProperty()));
        return this;
    }
}
