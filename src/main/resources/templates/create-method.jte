@import io.github.sosuisen.template.ConstructorMethodModel

@param ConstructorMethodModel model

@if(model.isDefaultConstructor())
    public static ${model.typeParameters().isEmpty() ? "" : model.typeParameters() + " "}${model.builderClassNameWithTypeParameter()} create() { return new ${model.builderClassNameWithTypeParameter()}(); }
    private ${model.builderClassName()}() {}
@else
    public static ${model.typeParameters().isEmpty() ? "" : model.typeParameters() + " "}${model.builderClassNameWithTypeParameter()} create(${model.parameterList()}) {
        ${model.builderClassNameWithTypeParameter()} builder = new ${model.builderClassNameWithTypeParameter()}();
        builder.constructorArgs = new Object[]{${model.argumentList()}};
        return builder;
    }
@endif