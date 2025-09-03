@import io.github.sosuisen.model.template.ApplyMethodModel

@param ApplyMethodModel model

    /**
     * Applies a function to the ${model.simpleClassName()} instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *@if(model.isNodeClass())
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(${model.camelCaseOfClassName()} -> ${model.camelCaseOfClassName()}.setId("Main" + ${model.camelCaseOfClassName()}.getTypeSelector()))
     * }</pre>
     *@endif
     * @return builder instance
     *
     */
    public ${model.builderClassNameWithTypeParameter()} apply(java.util.function.Consumer<${model.classNameWithTypeParameter()}> func) {
        operations.add(func);
        return this;
    }