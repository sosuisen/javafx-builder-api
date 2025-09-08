
package io.github.sosuisen.jfxbuilder.web;

/**
 * The {@code WebHistoryEntryBuilder} class constructs instances of the {@link javafx.scene.web.WebHistory.Entry Entry} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.web.WebHistory.Entry Entry} constructor
 * and returns an instance of the {@code WebHistoryEntryBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.web.WebHistory.Entry Entry}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.web.WebHistory.Entry Entry} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class WebHistoryEntryBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.web.WebHistory.Entry>> operations = new java.util.ArrayList<>();
    private WebHistoryEntryBuilder() {}
    
    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.web.WebHistory.Entry} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.web.WebHistory.Entry Entry} class
     */
    public javafx.scene.web.WebHistory.Entry build() {
        javafx.scene.web.WebHistory.Entry newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.web.WebHistory.Entry> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.web.WebHistory.Entry callParameterizedConstructor() {
        javafx.scene.web.WebHistory.Entry newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.web.WebHistory.Entry.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.web.WebHistory.Entry) constructor.newInstance(constructorArgs);
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
     * Applies a function to the Entry instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public WebHistoryEntryBuilder apply(java.util.function.Consumer<javafx.scene.web.WebHistory.Entry> func) {
        operations.add(func);
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.web.WebHistory.Entry#lastVisitedDateProperty() lastVisitedDateProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link WebHistoryEntryBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.lastVisitedDateProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .lastVisitedDatePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public WebHistoryEntryBuilder lastVisitedDatePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<java.util.Date>> op) {
        operations.add(obj -> op.accept(obj.lastVisitedDateProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.scene.web.WebHistory.Entry#titleProperty() titleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link WebHistoryEntryBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.titleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .titlePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public WebHistoryEntryBuilder titlePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.titleProperty()));
        return this;
    }
}
