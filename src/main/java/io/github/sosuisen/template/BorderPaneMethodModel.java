package io.github.sosuisen.template;

/**
 * Data model for BorderPane method JTE template
 */
public record BorderPaneMethodModel(
    String builderClassName,
    boolean isBorderPane
) {
    
    public static BorderPaneMethodModel create(Class<?> clazz, String builderClassName) {
        boolean isBorderPane = "BorderPane".equals(clazz.getSimpleName());
        
        return new BorderPaneMethodModel(
            builderClassName,
            isBorderPane
        );
    }
}