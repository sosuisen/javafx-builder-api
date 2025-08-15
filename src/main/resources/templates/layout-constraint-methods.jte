@import io.github.sosuisen.template.LayoutConstraintMethodModel

@param LayoutConstraintMethodModel model

@for(var methodInfo : model.methods())
    public ${model.builderClassNameWithTypeParameter()} ${methodInfo.methodName()}(${methodInfo.parameterList()}) {
        operations.add(obj -> {
@for(var staticCall : methodInfo.staticCalls())
            ${staticCall.sourceClassFullName()}.${staticCall.staticMethodName()}(obj@if(!staticCall.argumentList().isEmpty()), ${staticCall.argumentList()}@endif);
@endfor
        });
        return this;
    }

@endfor