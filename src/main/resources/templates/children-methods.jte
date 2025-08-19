@import io.github.sosuisen.template.ChildrenMethodModel

@param ChildrenMethodModel model


    public static ${model.typeParametersExtends().isEmpty() ? "" : model.typeParametersExtends() + " "}${model.builderClassNameWithTypeParameter()} withChildren(@if(model.observableListTypeParameter().matches(".*<.+>.*"))@SuppressWarnings("unchecked") @endif${model.observableListTypeParameter()}... elements) {
        ${model.builderClassNameWithTypeParameter()} builder = new ${model.builderClassNameWithTypeParameter()}();
        return builder.addChildren(elements);
    }