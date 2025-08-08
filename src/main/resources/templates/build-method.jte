@import io.github.sosuisen.template.BuildMethodModel

@param BuildMethodModel model

@if(model.suppressWarnings())
    @SuppressWarnings("unchecked")
@endif
    public ${model.returnType()} build() {
        ${model.returnType()} newInstance;
@if(model.hasDefaultConstructor())
        if (constructorArgs == null && mandatoryParams == null) {
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

    private ${model.returnType()} callParameterizedConstructor() {
        ${model.returnType()} newInstance;        
        try {
            Object[] args = (constructorArgs != null) ? constructorArgs : mandatoryParams;
            java.lang.reflect.Constructor<?>[] constructors = ${model.className()}.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == args.length && isConstructorCompatible(constructor, args)) {
                    newInstance = (${model.returnType()}) constructor.newInstance(args);
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
