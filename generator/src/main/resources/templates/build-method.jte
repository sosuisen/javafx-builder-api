@import io.github.sosuisen.model.template.BuildMethodModel

@param BuildMethodModel model

    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link ${model.canonicalClassName()}} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link ${model.canonicalClassName()} ${model.simpleClassName()}} class
     */
    public ${model.returnType()} build() {
        ${model.returnType()} newInstance;
@if(model.hasDefaultConstructor())
        if (constructorArgs == null) {
@if(model.hasGenerics())
            newInstance = new ${model.canonicalClassName()}<>();
@else
            newInstance = new ${model.canonicalClassName()}();
@endif
        } else {
            newInstance = callParameterizedConstructor();
        }
@else
        newInstance = callParameterizedConstructor();
@endif
@if(model.isPaneSubclass())
        newInstance.getStyleClass().add("${model.styleClass()}");
@endif
        for (java.util.function.Consumer<${model.returnType()}> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }

@if(model.suppressWarnings())
    @SuppressWarnings("unchecked")
@endif
    private ${model.returnType()} callParameterizedConstructor() {
        ${model.returnType()} newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = ${model.canonicalClassName()}.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (${model.returnType()}) constructor.newInstance(constructorArgs);
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