package io.github.sosuisen.template;

import io.github.sosuisen.model.ClassMetadata;

/**
 * Data model for class header JTE template
 */
public record ClassHeaderModel(
        String packageName,
        String builderClassName,
        String typeParameters,
        String typeParametersWithExtends,
        String classNameWithTypeParameter,
        String classAnnotation) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ClassMetadata classMetadata;
        private String classAnnotation;

        public Builder classMetadata(ClassMetadata classMetadata) {
            this.classMetadata = classMetadata;
            return this;
        }

        public Builder classAnnotation(String classAnnotation) {
            this.classAnnotation = classAnnotation;
            return this;
        }

        public ClassHeaderModel build() {
            if (classMetadata == null) {
                throw new IllegalStateException("classMetadata are required");
            }

            return new ClassHeaderModel(
                    classMetadata.getPackageName(),
                    classMetadata.getBuilderClassName(),
                    classMetadata.getTypeParameters(),
                    classMetadata.gettypeParametersWithExtends(),
                    classMetadata.classNameWithTypeParameter(),
                    classAnnotation != null ? classAnnotation : "");
        }
    }

}