@import io.github.sosuisen.model.template.PropertyMethodModel

@param PropertyMethodModel model


    /**
     * Applies a function to the {@link ${model.declaringClassName()}#${model.propertyName()}() ${model.propertyName()}} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link ${model.builderClassName()}#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * {@snippet :
     * // Use apply
     * .apply(obj -> obj.${model.propertyName()}().bind(anotherProperty))
     *
     * // Use shorthand form
     * .${model.methodName()}(prop -> prop.bind(anotherProperty))
     * }
     *
     * @return builder instance
     */@if(!model.methodAnnotation().isEmpty())
    ${model.methodAnnotation()}@endif
    public ${model.builderClassNameWithTypeParameter()} ${model.methodName()}(java.util.function.Consumer<${model.propertyType()}> op) {
        operations.add(obj -> op.accept(obj.${model.propertyName()}()));
        return this;
    }