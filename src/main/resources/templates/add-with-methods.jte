@import io.github.sosuisen.template.AddWithMethodModel

@param AddWithMethodModel model

    @SafeVarargs
    public final ${model.builderClassNameWithTypeParameter()} ${model.addMethodName()}(${model.observableListTypeParameter()}... elements) {
        operations.add(obj -> {
            obj.${model.getterMethodName()}().addAll(elements);
        });
        return this;
    }

    public final ${model.builderClassNameWithTypeParameter()} ${model.addMethodName()}(java.util.Collection<? extends ${model.observableListTypeParameter()}> col) {
        operations.add(obj -> {
            obj.${model.getterMethodName()}().addAll(col);
        });
        return this;
    }

@if(model.withMethodName() != null && !model.withMethodName().equals(""))
    @SafeVarargs
    public static ${model.typeParametersExtends().isEmpty() ? "" : model.typeParametersExtends() + " "}${model.builderClassNameWithTypeParameter()} ${model.withMethodName()}(${model.observableListTypeParameter()}... elements) {
        ${model.builderClassNameWithTypeParameter()} builder = new ${model.builderClassNameWithTypeParameter()}();
        return builder.${model.addMethodName()}(elements);
    }

    public static ${model.typeParametersExtends().isEmpty() ? "" : model.typeParametersExtends() + " "}${model.builderClassNameWithTypeParameter()} ${model.withMethodName()}(java.util.Collection<? extends ${model.observableListTypeParameter()}> col) {
        ${model.builderClassNameWithTypeParameter()} builder = new ${model.builderClassNameWithTypeParameter()}();
        return builder.${model.addMethodName()}(col);
    }
@endif