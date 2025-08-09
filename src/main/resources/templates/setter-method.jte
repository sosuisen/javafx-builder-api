@import io.github.sosuisen.template.SetterMethodModel

@param SetterMethodModel model
    
    ${model.methodAnnotation()}
    public  ${model.builderClassNameWithTypeParameter()} ${model.methodName()}(${model.parameterList()}) {
        operations.add(obj -> obj.${model.originalMethodName()}(${model.argumentList()}));
        return this;
    }