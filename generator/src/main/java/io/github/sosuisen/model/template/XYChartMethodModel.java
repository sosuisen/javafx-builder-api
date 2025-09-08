package io.github.sosuisen.model.template;

import io.github.sosuisen.model.data.ClassMetadata;

/**
 * Data model for methods for XYChart JTE template
 */
public record XYChartMethodModel(
    String canonicalClassName,
    String simpleClassName,
    String canonicalBuilderClassName,
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

        public XYChartMethodModel build() {
            if (classMetadata == null) {
                throw new IllegalStateException("classMetadata are required");
            }

            return new XYChartMethodModel(
                classMetadata.getCanonicalClassName(),
                classMetadata.getSimpleClassName(),
                classMetadata.getCanonicalBuilderClassName(),
                classMetadata.getBuilderClassName(),
                classMetadata.builderClassNameWithTypeParameter(),
                classMetadata.getTypeParametersWithExtends()
            );
        }
    }
}
