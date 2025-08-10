@import io.github.sosuisen.template.CreateMethodModel

@param CreateMethodModel model

@if(model.isDefaultConstructor())
    public static ${model.typeParametersExtends().isEmpty() ? "" : model.typeParametersExtends() + " "}${model.builderClassNameWithTypeParameter()} create() { return new ${model.builderClassNameWithTypeParameter()}(); }
@else
    @if(model.isVarArgs())@SafeVarargs@endif
    public static ${model.typeParametersExtends().isEmpty() ? "" : model.typeParametersExtends() + " "}${model.builderClassNameWithTypeParameter()} create(${model.parameterList()}) {
        ${model.builderClassNameWithTypeParameter()} builder = new ${model.builderClassNameWithTypeParameter()}();
        builder.constructorArgs = new Object[]{${model.argumentList()}};
        return builder;
    }
@endif