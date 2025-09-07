package io.github.sosuisen.model.template;

import io.github.sosuisen.model.data.ClassMetadata;

/**
 * Data model for apply method JTE template
 */
public record ApplyMethodModel(
    String builderClassNameWithTypeParameter,
    String classNameWithTypeParameter,
    String simpleClassName,
    String camelCaseOfClassName,
    boolean isNodeClass) {

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

            String camelCaseOfClassName =
                classMetadata.getSimpleClassName().substring(0, 1).toLowerCase()
                    + classMetadata.getSimpleClassName().substring(1);

            return new ApplyMethodModel(
                classMetadata.builderClassNameWithTypeParameter(),
                classMetadata.classNameWithTypeParameter(),
                classMetadata.getSimpleClassName(),
                camelCaseOfClassName,
                classMetadata.isNodeClass()
            );
        }
    }

}
