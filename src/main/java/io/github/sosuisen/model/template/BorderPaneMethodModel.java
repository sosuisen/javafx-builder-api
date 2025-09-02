package io.github.sosuisen.model.template;

import io.github.sosuisen.model.data.ClassMetadata;

/**
 * Data model for BorderPane method JTE template
 */
public record BorderPaneMethodModel(
        String builderClassName,
        boolean isBorderPane) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ClassMetadata classMetadata;

        public Builder classMetadata(ClassMetadata classMetadata) {
            this.classMetadata = classMetadata;
            return this;
        }

        public BorderPaneMethodModel build() {
            if (classMetadata == null) {
                throw new IllegalStateException("classMetadata is required");
            }

            boolean isBorderPane = "BorderPane".equals(classMetadata.getTargetClass().getSimpleName());

            return new BorderPaneMethodModel(
                    classMetadata.getBuilderClassName(),
                    isBorderPane);
        }
    }
}