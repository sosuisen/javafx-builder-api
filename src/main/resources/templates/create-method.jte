@import io.github.sosuisen.model.template.CreateMethodModel

@param CreateMethodModel model

@if(model.isDefaultConstructor())
    /**
     * Returns an instance of the {@code ${model.builderClassNameWithTypeParameter()}}.
     *
     * @return an instance of the {@code ${model.builderClassNameWithTypeParameter()}}.
     */
    public static ${model.typeParametersWithExtends().isEmpty() ? "" : model.typeParametersWithExtends() + " "}${model.builderClassNameWithTypeParameter()} create() { return new ${model.builderClassNameWithTypeParameter()}(); }
@else
    /**
     * Accepts the constructor arguments of {@link ${model.canonicalClassName()}#${model.simpleClassName()}(${model.parameterListSimpleTypesOnly()}) ${model.simpleClassName()}(${model.parameterListSimpleTypesOnly()})}
     * and returns an instance of {@code ${model.builderClassNameWithTypeParameter()}}.
     *
     * @return an instance of the {@code ${model.builderClassNameWithTypeParameter()}}.
     */
    @if(model.isVarArgs())@SafeVarargs@endif
    public static ${model.typeParametersWithExtends().isEmpty() ? "" : model.typeParametersWithExtends() + " "}${model.builderClassNameWithTypeParameter()} create(${model.parameterList()}) {
        ${model.builderClassNameWithTypeParameter()} builder = new ${model.builderClassNameWithTypeParameter()}();
        builder.constructorArgs = new Object[]{${model.argumentList()}};
        return builder;
    }
@endif