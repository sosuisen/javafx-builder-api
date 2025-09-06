package io.github.sosuisen.model.template;

import io.github.sosuisen.model.data.ClassMetadata;

/**
 * Data model for methods for Alert JTE template
 */
public record AlertMethodModel(
    String canonicalClassName,
    String simpleClassName,
    String builderClassName,
    String builderClassNameWithTypeParameter,
    String typeParametersWithExtends) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ClassMetadata classMetadata;

        public Builder classMetadata(ClassMetadata classMetadata) {
            this.classMetadata = classMetadata;
            return this;
        }

        public AlertMethodModel build() {
            if (classMetadata == null) {
                throw new IllegalStateException("classMetadata are required");
            }

            return new AlertMethodModel(
                classMetadata.getCanonicalClassName(),
                classMetadata.getSimpleClassName(),
                classMetadata.getBuilderClassName(),
                classMetadata.builderClassNameWithTypeParameter(),
                classMetadata.getTypeParametersWithExtends()
            );
        }
    }
}
