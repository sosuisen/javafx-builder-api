@import io.github.sosuisen.model.template.LayoutConstraintMethodModel

@param LayoutConstraintMethodModel model

    /**
     * Invokes the {@link ${model.sourceClassFullName()}#${model.staticMethodName()}(javafx.scene.Node child, ${model.parameterList()}) ${model.sourceClassSimpleName()}.${model.staticMethodName()}(javafx.scene.Node, ${model.parameterListSimpleTypesOnly()})} 
     * using a fluent API.
     *
     * <p>
     * Example:
     * </p>
     * <pre>{@code
     * // Original API
     * var btn = new Button();
     * var root = new ${model.sourceClassSimpleName()}(btn);
     * ${model.sourceClassSimpleName()}.${model.staticMethodName()}(btn, new Insets(10));
     *
     * // Fluent API
     * var root = ${model.sourceClassSimpleName()}Builder.create(
     *                  ButtonBuilder.create()
     *                      .${model.methodName()}(new Insets(10))
     *                      .build())
     *                .build();
     * }</pre>
     *
     * @return builder instance
     */
    public ${model.builderClassNameWithTypeParameter()} ${model.methodName()}(${model.parameterList()}) {
        operations.add(obj -> ${model.sourceClassFullName()}.${model.staticMethodName()}(obj@if(!model.argumentList().isEmpty()), ${model.argumentList()}@endif));
        return this;
    }
