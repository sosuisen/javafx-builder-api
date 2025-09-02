package io.github.sosuisen.model.template;

import io.github.sosuisen.model.data.ClassMetadata;

/**
 * Data model for apply method JTE template
 */
public record ApplyMethodModel(
        String builderClassNameWithTypeParameter,
        String classNameWithTypeParameter) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ClassMetadata classMetadata;

        public Builder classMetadata(ClassMetadata classMetadata) {
            this.classMetadata = classMetadata;
            return this;
        }

        public ApplyMethodModel build() {
            if (classMetadata == null) {
                throw new IllegalStateException("classMetadata is required");
            }

            return new ApplyMethodModel(
                    classMetadata.builderClassNameWithTypeParameter(),
                    classMetadata.classNameWithTypeParameter());
        }
    }
}