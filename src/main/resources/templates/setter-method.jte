@import io.github.sosuisen.model.template.SetterMethodModel

@param SetterMethodModel model


    /**
     * A builder method that invokes the {@link ${model.originalClassName()}#${model.originalMethodName()}(${model.parameterTypeList()}) ${model.originalMethodName()}} method on the instance being constructed.
     *
     * @return builder instance
     */@if(!model.methodAnnotation().isEmpty())
    ${model.methodAnnotation()}@endif
    public  ${model.builderClassNameWithTypeParameter()} ${model.methodName()}(${model.parameterList()}) {
        operations.add(obj -> obj.${model.originalMethodName()}(${model.argumentList()}));
        return this;
    }