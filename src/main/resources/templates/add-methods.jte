@import io.github.sosuisen.template.AddMethodModel

@param AddMethodModel model

    @SafeVarargs
    public final ${model.builderClassNameWithTypeParameter()} ${model.methodName()}(${model.observableListTypeParameter()}... elements) {
        operations.add(obj -> {
            obj.${model.getterMethodName()}().addAll(elements);
        });
        return this;
    }

    public final ${model.builderClassNameWithTypeParameter()} ${model.methodName()}(java.util.Collection<? extends ${model.observableListTypeParameter()}> col) {
        operations.add(obj -> {
            obj.${model.getterMethodName()}().addAll(col);
        });
        return this;
    }

    