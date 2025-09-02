
package io.github.sosuisen.jfxbuilder.web;


public class WebHistoryBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.web.WebHistory>> operations = new java.util.ArrayList<>();
    private WebHistoryBuilder() {}
    
    private Object[] constructorArgs;

    public javafx.scene.web.WebHistory build() {
        javafx.scene.web.WebHistory newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.web.WebHistory> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.web.WebHistory callParameterizedConstructor() {
        javafx.scene.web.WebHistory newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.web.WebHistory.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.web.WebHistory) constructor.newInstance(constructorArgs);
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
     * Applies a function to the WebHistory instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(webHistory -> webHistory.setId("Main" + webHistory.getTypeSelector()))
     * }</pre>
     * 
     * @return builder instance
     *
     */
    public WebHistoryBuilder apply(java.util.function.Consumer<javafx.scene.web.WebHistory> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.web.WebHistory#setMaxSize(int)}
     * 
     * @return builder instance
     */    
    
    public  WebHistoryBuilder maxSize(int value) {
        operations.add(obj -> obj.setMaxSize(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.web.WebHistory#getEntries()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public final WebHistoryBuilder addEntries(javafx.scene.web.WebHistory.Entry... elements) {
        operations.add(obj -> {
            obj.getEntries().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.web.WebHistory#getEntries()} method.
     * 
     * @return builder instance
     */     
    public final WebHistoryBuilder addEntries(java.util.Collection<? extends javafx.scene.web.WebHistory.Entry> col) {
        operations.add(obj -> {
            obj.getEntries().addAll(col);
        });
        return this;
    }


    
    /**
     * Applies a function to the {@link javafx.scene.web.WebHistory#currentIndexProperty()}.
     * 
     * @return builder instance
     */    
    
    public WebHistoryBuilder currentIndexPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyIntegerProperty> op) {
        operations.add(obj -> op.accept(obj.currentIndexProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.web.WebHistory#maxSizeProperty()}.
     * 
     * @return builder instance
     */    
    
    public WebHistoryBuilder maxSizePropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.maxSizeProperty()));
        return this;
    }
}
