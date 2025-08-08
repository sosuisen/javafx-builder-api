@import io.github.sosuisen.template.ApplyMethodModel

@param ApplyMethodModel model

    
    public ${model.builderClassNameWithTypeParameter()} apply(java.util.function.Consumer<${model.classNameWithTypeParameter()}> func) {
        operations.add(func);
        return this;
    }