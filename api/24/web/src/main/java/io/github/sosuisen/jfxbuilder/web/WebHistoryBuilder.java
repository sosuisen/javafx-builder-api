
package io.github.sosuisen.jfxbuilder.web;

/**
 * The {@code WebHistoryBuilder} class constructs instances of the {@link javafx.scene.web.WebHistory WebHistory} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.web.WebHistory WebHistory} constructor
 * and returns an instance of the {@code WebHistoryBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.web.WebHistory WebHistory}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.web.WebHistory WebHistory} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class WebHistoryBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.web.WebHistory>> operations = new java.util.ArrayList<>();
    private WebHistoryBuilder() {}
    
    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.web.WebHistory WebHistory} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.web.WebHistory WebHistory} class
     */
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
     * Applies a function to the WebHistory instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public WebHistoryBuilder apply(java.util.function.Consumer<javafx.scene.web.WebHistory> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.web.WebHistory#setMaxSize(int) setMaxSize} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  WebHistoryBuilder maxSize(int value) {
        operations.add(obj -> obj.setMaxSize(value));
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(java.lang.Object[]) addAll} method on the ObservableList
     * returned by the {@link javafx.scene.web.WebHistory#getEntries() WebHistory#getEntries()} method.
     * 
     * @return builder instance
     */
    public final WebHistoryBuilder addEntries(javafx.scene.web.WebHistory.Entry... elements) {
        operations.add(obj -> obj.getEntries().addAll(elements));
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(java.util.Collection) addAll} method on the ObservableList
     * returned by the {@link javafx.scene.web.WebHistory#getEntries() WebHistory#getEntries()} method.
     * 
     * @return builder instance
     */
    public final WebHistoryBuilder addEntries(java.util.Collection<? extends javafx.scene.web.WebHistory.Entry> col) {
        operations.add(obj -> obj.getEntries().addAll(col));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.web.WebHistory#currentIndexProperty() currentIndexProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link WebHistoryBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * {@snippet :
     * // Use apply
     * .apply(obj -> obj.currentIndexProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .currentIndexPropertyApply(prop -> prop.bind(anotherProperty))
     * }
     *
     * @return builder instance
     */
    public WebHistoryBuilder currentIndexPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyIntegerProperty> op) {
        operations.add(obj -> op.accept(obj.currentIndexProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.web.WebHistory#maxSizeProperty() maxSizeProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link WebHistoryBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * {@snippet :
     * // Use apply
     * .apply(obj -> obj.maxSizeProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .maxSizePropertyApply(prop -> prop.bind(anotherProperty))
     * }
     *
     * @return builder instance
     */
    public WebHistoryBuilder maxSizePropertyApply(java.util.function.Consumer<javafx.beans.property.IntegerProperty> op) {
        operations.add(obj -> op.accept(obj.maxSizeProperty()));
        return this;
    }
}
