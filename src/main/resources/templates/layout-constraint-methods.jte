@import io.github.sosuisen.template.LayoutConstraintMethodModel

@param LayoutConstraintMethodModel model

@for(var methodInfo : model.methods())
    public ${model.builderClassNameWithTypeParameter()} ${methodInfo.methodName()}(${methodInfo.parameterList()}) {
        operations.add(obj -> ${methodInfo.staticCall().sourceClassFullName()}.${methodInfo.staticCall().staticMethodName()}(obj@if(!methodInfo.staticCall().argumentList().isEmpty()), ${methodInfo.staticCall().argumentList()}@endif));
        return this;
    }

@endfor