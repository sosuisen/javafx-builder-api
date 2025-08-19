@import io.github.sosuisen.template.AddMethodModel

@param AddMethodModel model

    @SafeVarargs
    public final ${model.builderClassNameWithTypeParameter()} ${model.methodName()}(${model.observableListTypeParameter()}... elements) {
        operations.add(obj -> {
            obj.${model.getterMethodName()}().addAll(elements);
        });
        return this;
    }