@import io.github.sosuisen.model.template.LayoutConstraintMethodModel

@param LayoutConstraintMethodModel model

    /**
     * Invokes the {@link ${model.sourceClassFullName()}#${model.staticMethodName()}(Node child, ${model.parameterList()}) ${model.sourceClassSimpleName()}.${model.staticMethodName()}(Node, ${model.parameterListSimpleTypesOnly()})} 
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
     * ${model.sourceClassSimpleName().replaceAll(".", " ")}                       ButtonBuilder.create()
     * ${model.sourceClassSimpleName().replaceAll(".", " ")}                                    .${model.methodName()}(new Insets(10))
     * ${model.sourceClassSimpleName().replaceAll(".", " ")}                                    .build())
     * ${model.sourceClassSimpleName().replaceAll(".", " ")}                  .build();
     * }</pre>
     *
     * @return builder instance
     */
    public ${model.builderClassNameWithTypeParameter()} ${model.methodName()}(${model.parameterList()}) {
        operations.add(obj -> ${model.sourceClassFullName()}.${model.staticMethodName()}(obj@if(!model.argumentList().isEmpty()), ${model.argumentList()}@endif));
        return this;
    }
