@import io.github.sosuisen.template.PropertyMethodModel

@param PropertyMethodModel model
    
    ${model.methodAnnotation()}
    public ${model.builderClassNameWithTypeParameter()} ${model.methodName()}(java.util.function.Consumer<${model.propertyType()}> op) {
        operations.add(obj -> op.accept(obj.${model.propertyName()}()));
        return this;
    }