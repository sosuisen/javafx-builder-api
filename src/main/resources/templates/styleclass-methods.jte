@import io.github.sosuisen.template.StyleClassMethodModel

@param StyleClassMethodModel model

    public  ${model.builderClassNameWithTypeParameter()} styleClass(String... cssClassNames) {
        operations.add(obj -> 
            java.util.Arrays.stream(cssClassNames)
                  .forEach(obj.getStyleClass()::add)
        );
        return this;
    }