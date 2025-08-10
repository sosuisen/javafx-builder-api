@import io.github.sosuisen.template.ConstructorModel

@param ConstructorModel model

@if(model.isPrivate())
    private ${model.builderClassName()}(){}
@elseif(model.parameterList().isEmpty())
    public ${model.builderClassName()}(){}
@else
    @if(model.isVarArgs())@SafeVarargs@endif
    public ${model.builderClassName()}(${model.parameterList()}) {
        this.constructorArgs = new Object[]{${model.argumentList()}};
    }
@endif