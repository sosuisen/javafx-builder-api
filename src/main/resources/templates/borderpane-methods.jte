@import io.github.sosuisen.template.BorderPaneMethodModel

@param BorderPaneMethodModel model

@if(model.isBorderPane())
    public static ${model.builderClassName()} withCenter(javafx.scene.Node node) {
        ${model.builderClassName()} builder = new ${model.builderClassName()}();
        builder.operations.add(obj -> obj.setCenter(node));
        return builder;
    }

    public static ${model.builderClassName()} withTop(javafx.scene.Node node) {
        ${model.builderClassName()} builder = new ${model.builderClassName()}();
        builder.operations.add(obj -> obj.setTop(node));
        return builder;
    }

    public static ${model.builderClassName()} withLeft(javafx.scene.Node node) {
        ${model.builderClassName()} builder = new ${model.builderClassName()}();
        builder.operations.add(obj -> obj.setLeft(node));
        return builder;
    }

    public static ${model.builderClassName()} withBottom(javafx.scene.Node node) {
        ${model.builderClassName()} builder = new ${model.builderClassName()}();
        builder.operations.add(obj -> obj.setBottom(node));
        return builder;
    }

    public static ${model.builderClassName()} withRight(javafx.scene.Node node) {
        ${model.builderClassName()} builder = new ${model.builderClassName()}();
        builder.operations.add(obj -> obj.setRight(node));
        return builder;
    }

@endif