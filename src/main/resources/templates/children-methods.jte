@import io.github.sosuisen.template.ChildrenMethodModel

@param ChildrenMethodModel model


    public  ${model.builderClassNameWithTypeParameter()} children(@if(model.observableListTypeParameter().matches(".*<.+>.*"))@SuppressWarnings("unchecked") @endif${model.observableListTypeParameter()}... elements) {
        operations.add(obj -> {
            if (elements == null) {
                obj.getChildren().clear();
            } else {
                java.util.List<${model.observableListTypeParameter()}> validChildren = java.util.Arrays.stream(elements)
                    .filter(java.util.Objects::nonNull)
                    .collect(java.util.stream.Collectors.toList());
                obj.getChildren().setAll(validChildren);
            }
        });
        return this;
    }
    
    public static ${model.typeParametersExtends().isEmpty() ? "" : model.typeParametersExtends() + " "}${model.builderClassNameWithTypeParameter()} withChildren(@if(model.observableListTypeParameter().matches(".*<.+>.*"))@SuppressWarnings("unchecked") @endif${model.observableListTypeParameter()}... elements) {
        ${model.builderClassNameWithTypeParameter()} builder = new ${model.builderClassNameWithTypeParameter()}();
        return builder.children(elements);
    }