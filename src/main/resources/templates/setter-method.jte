@import io.github.sosuisen.model.template.SetterMethodModel

@param SetterMethodModel model

    /**
     * Builder method for {@link ${model.originalClassName()}#${model.originalMethodName()}(${model.parameterTypeList()})}
     * 
     * @return builder instance
     */    
    ${model.methodAnnotation()}
    public  ${model.builderClassNameWithTypeParameter()} ${model.methodName()}(${model.parameterList()}) {
        operations.add(obj -> obj.${model.originalMethodName()}(${model.argumentList()}));
        return this;
    }