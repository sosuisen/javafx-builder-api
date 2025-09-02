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
        private String packageName;
        private ClassMetadata classMetadata;
        private String classAnnotation;

        public Builder packageName(String packageName) {
            this.packageName = packageName;
            return this;
        }

        public Builder classMetadata(ClassMetadata classMetadata) {
            this.classMetadata = classMetadata;
            return this;
        }

        public Builder classAnnotation(String classAnnotation) {
            this.classAnnotation = classAnnotation;
            return this;
        }

        public ClassHeaderModel build() {
            if (packageName == null || classMetadata == null) {
                throw new IllegalStateException("packageName and classMetadata are required");
            }

            return new ClassHeaderModel(
                    packageName,
                    classMetadata.getBuilderClassName(),
                    classMetadata.getTypeParameters(),
                    classMetadata.gettypeParametersWithExtends(),
                    classMetadata.classNameWithTypeParameter(),
                    classAnnotation != null ? classAnnotation : "");
        }
    }

    // Keep the old create method for backward compatibility (deprecated)
    @Deprecated
    public static ClassHeaderModel create(
            String packageName,
            String builderClassName,
            String typeParameters,
            String typeParametersWithExtends,
            String classNameWithTypeParameter,
            String classAnnotation) {
        return new ClassHeaderModel(
                packageName,
                builderClassName,
                typeParameters,
                typeParametersWithExtends,
                classNameWithTypeParameter,
                classAnnotation);
    }
}