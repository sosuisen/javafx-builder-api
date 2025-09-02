@import io.github.sosuisen.model.template.LayoutConstraintMethodModel

@param LayoutConstraintMethodModel model


    public ${model.builderClassNameWithTypeParameter()} ${model.methodName()}(${model.parameterList()}) {
        operations.add(obj -> ${model.sourceClassFullName()}.${model.staticMethodName()}(obj@if(!model.argumentList().isEmpty()), ${model.argumentList()}@endif));
        return this;
    }
