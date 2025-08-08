@import io.github.sosuisen.template.ChildrenMethodModel

@param ChildrenMethodModel model

    public  ${model.builderClassNameWithTypeParameter()} children(javafx.scene.Node... elements) {
        operations.add(obj -> {
            if (elements == null) {
                obj.getChildren().clear();
            } else {
                java.util.List<javafx.scene.Node> validChildren = java.util.Arrays.stream(elements)
                    .filter(java.util.Objects::nonNull)
                    .collect(java.util.stream.Collectors.toList());
                obj.getChildren().setAll(validChildren);
            }
        });
        return this;
    }

    public static ${model.builderClassName()} withChildren(javafx.scene.Node... elements) {
        ${model.builderClassName()} builder = new ${model.builderClassName()}();
        return builder.children(elements);
    }