package io.github.sosuisen.model.template;

import io.github.sosuisen.model.data.ClassMetadata;

/**
 * Data model for stylesheet method JTE template
 */
public record StylesheetMethodModel(
    String simpleClassName,
    String builderClassName,
    String builderClassNameWithTypeParameter) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ClassMetadata classMetadata;

        public Builder classMetadata(ClassMetadata classMetadata) {
            this.classMetadata = classMetadata;
            return this;
        }

        public StylesheetMethodModel build() {
            if (classMetadata == null) {
                throw new IllegalStateException("classMetadata is required");
            }

            String simpleClassName = classMetadata.getTargetClass().getSimpleName();

            return new StylesheetMethodModel(
                simpleClassName,
                classMetadata.getBuilderClassName(),
                classMetadata.builderClassNameWithTypeParameter()
            );
        }
    }
}
