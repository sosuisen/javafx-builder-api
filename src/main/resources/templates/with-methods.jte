@import io.github.sosuisen.template.WithMethodModel

@param WithMethodModel model

@if(!model.hasCommonParams())
    public static ${model.typeParametersExtends().isEmpty() ? "" : model.typeParametersExtends() + " "}${model.builderClassNameWithTypeParameter()} create() { return new ${model.builderClassNameWithTypeParameter()}(); }
@else
    public static ${model.typeParametersExtends().isEmpty() ? "" : model.typeParametersExtends() + " "}${model.builderClassNameWithTypeParameter()} ${model.methodName()}(${model.paramList()}) {
        ${model.builderClassNameWithTypeParameter()} builder = new ${model.builderClassNameWithTypeParameter()}();
        builder.mandatoryParams = new Object[]{${model.argList()}};
        return builder;
    }

@endif
    private ${model.builderClassName()}() {}
