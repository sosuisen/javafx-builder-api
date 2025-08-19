@import io.github.sosuisen.template.ItemsMethodModel

@param ItemsMethodModel model

    @SafeVarargs
    public final ${model.builderClassNameWithTypeParameter()} ${model.methodName()}(@if(model.observableListTypeParameter().matches(".*<.+>.*"))@SuppressWarnings("unchecked") @endif${model.observableListTypeParameter()}... elements) {
        operations.add(obj -> {
            if (elements != null) {
                java.util.List<${model.observableListTypeParameter()}> validItems = java.util.Arrays.stream(elements)
                    .filter(java.util.Objects::nonNull)
                    .collect(java.util.stream.Collectors.toList());
                obj.${model.getterMethodName()}().addAll(validItems);
            }
        });
        return this;
    }