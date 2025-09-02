package io.github.sosuisen.model.template;

import io.github.sosuisen.model.data.ClassMetadata;

/**
 * Data model for children method JTE template
 */
public record GridPaneMethodModel(
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

        public GridPaneMethodModel build() {
            if (classMetadata == null) {
                throw new IllegalStateException("classMetadata is required");
            }

            return new GridPaneMethodModel(
                    classMetadata.builderClassNameWithTypeParameter());
        }
    }
}