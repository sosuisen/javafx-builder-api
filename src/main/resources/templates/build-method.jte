@import io.github.sosuisen.template.BuildMethodModel

@param BuildMethodModel model

    public ${model.returnType()} build() {
        ${model.returnType()} newInstance;
@if(model.hasDefaultConstructor())
        if (constructorArgs == null) {
@if(model.hasGenerics())
            newInstance = new ${model.className()}<>();
@else
            newInstance = new ${model.className()}();
@endif
        } else {
            newInstance = callParameterizedConstructor();
        }
@else
        newInstance = callParameterizedConstructor();
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
            java.lang.reflect.Constructor<?>[] constructors = ${model.className()}.class.getConstructors();
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
