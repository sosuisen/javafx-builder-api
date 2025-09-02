package io.github.sosuisen.model.template;

import io.github.sosuisen.model.data.ClassMetadata;
import io.github.sosuisen.model.mapper.ClassAnnotationManager;

/**
 * Data model for class header JTE template
 */
public record ClassHeaderModel(
        String packageName,
        String canonicalClassName,
        String simpleClassName,
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

        public Builder classMetadata(ClassMetadata classMetadata) {
            this.classMetadata = classMetadata;
            return this;
        }

        public ClassHeaderModel build() {
            if (classMetadata == null) {
                throw new IllegalStateException("classMetadata are required");
            }
            String classAnnotation = ClassAnnotationManager.getClassAnnotation(classMetadata.getCanonicalClassName());
            return new ClassHeaderModel(
                    classMetadata.getPackageName(),
                    classMetadata.getCanonicalClassName(),
                    classMetadata.getSimpleClassName(),
                    classMetadata.getBuilderClassName(),
                    classMetadata.getTypeParameters(),
                    classMetadata.gettypeParametersWithExtends(),
                    classMetadata.classNameWithTypeParameter(),
                    classAnnotation != null ? classAnnotation : "");
        }
    }

}