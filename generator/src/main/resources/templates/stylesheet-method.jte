@import io.github.sosuisen.model.template.StylesheetMethodModel

@param StylesheetMethodModel model
    
    /**
     * Utility setter to add CSS string for this ${model.simpleClassName()}'s contents.
     * For example:
     * {@snippet :
     * ${model.builderClassName()} builder = ${model.builderClassName()}.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();
     * }
     *
     * @param css CSS string
     */
    public ${model.builderClassNameWithTypeParameter()} addStylesheetsText(String css) {
        operations.add(obj -> obj.getStylesheets().addAll("data:text/css;base64," +
                java.util.Base64.getEncoder().encodeToString(css.getBytes())));
        return this;
    }
