@import io.github.sosuisen.model.template.BorderPaneMethodModel

@param BorderPaneMethodModel model

@if(model.isBorderPane())
    /**
     * Creates an instance of the builder,
     * then call the {@link javafx.scene.layout.BorderPane#setCenter(javafx.scene.Node) setCenter} method on the BorderPane instance.
     * 
     * @return builder instance
     */
    public static ${model.builderClassName()} withCenter(javafx.scene.Node node) {
        ${model.builderClassName()} builder = new ${model.builderClassName()}();
        builder.operations.add(obj -> obj.setCenter(node));
        return builder;
    }

    /**
     * Creates an instance of the builder,
     * then call the {@link javafx.scene.layout.BorderPane#setTop(javafx.scene.Node) setTop} method on the BorderPane instance.
     * 
     * @return builder instance
     */
    public static ${model.builderClassName()} withTop(javafx.scene.Node node) {
        ${model.builderClassName()} builder = new ${model.builderClassName()}();
        builder.operations.add(obj -> obj.setTop(node));
        return builder;
    }

    /**
     * Creates an instance of the builder,
     * then call the {@link javafx.scene.layout.BorderPane#setLeft(javafx.scene.Node) setLeft} method on the BorderPane instance.
     * 
     * @return builder instance
     */
    public static ${model.builderClassName()} withLeft(javafx.scene.Node node) {
        ${model.builderClassName()} builder = new ${model.builderClassName()}();
        builder.operations.add(obj -> obj.setLeft(node));
        return builder;
    }

    /**
     * Creates an instance of the builder,
     * then call the {@link javafx.scene.layout.BorderPane#setBottom(javafx.scene.Node) setBottom} method on the BorderPane instance.
     * 
     * @return builder instance
     */
    public static ${model.builderClassName()} withBottom(javafx.scene.Node node) {
        ${model.builderClassName()} builder = new ${model.builderClassName()}();
        builder.operations.add(obj -> obj.setBottom(node));
        return builder;
    }

    /**
     * Creates an instance of the builder,
     * then call the {@link javafx.scene.layout.BorderPane#setRight(javafx.scene.Node) setRight} method on the BorderPane instance.
     * 
     * @return builder instance
     */
    public static ${model.builderClassName()} withRight(javafx.scene.Node node) {
        ${model.builderClassName()} builder = new ${model.builderClassName()}();
        builder.operations.add(obj -> obj.setRight(node));
        return builder;
    }

@endif