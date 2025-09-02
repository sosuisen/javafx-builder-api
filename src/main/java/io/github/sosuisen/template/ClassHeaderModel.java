package io.github.sosuisen.template;

import io.github.sosuisen.mapper.ClassAnnotationManager;
import io.github.sosuisen.model.data.ClassMetadata;

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

        public Builder classMetadata(ClassMetadata classMetadata) {
            this.classMetadata = classMetadata;
            return this;
        }

        public ClassHeaderModel build() {
            if (classMetadata == null) {
                throw new IllegalStateException("classMetadata are required");
            }
            String classAnnotation = ClassAnnotationManager.getClassAnnotation(classMetadata.getClassName());
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