package io.github.sosuisen.template;

import io.github.sosuisen.model.ClassMetadata;

/**
 * Data model for build method JTE template
 */
public record BuildMethodModel(
        String className,
        String returnType,
        boolean hasDefaultConstructor,
        boolean hasGenerics,
        boolean suppressWarnings,
        boolean isPaneSubclass,
        String styleClass) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ClassMetadata classMetadata;

        public Builder classMetadata(ClassMetadata classMetadata) {
            this.classMetadata = classMetadata;
            return this;
        }

        public BuildMethodModel build() {
            if (classMetadata == null) {
                throw new IllegalStateException("classMetadata is required");
            }

            boolean hasDefaultConstructor = classMetadata.hasDefaultConstructor();
            boolean hasGenerics = !classMetadata.getTypeParameters().isEmpty();
            boolean suppressWarnings = hasGenerics;
            boolean isPaneSubclass = isPaneSubclass(classMetadata.getTargetClass());
            String styleClass = isPaneSubclass ? toKebabCase(classMetadata.getClassName()) : null;

            return new BuildMethodModel(
                    classMetadata.getClassName(),
                    classMetadata.classNameWithTypeParameter(),
                    hasDefaultConstructor,
                    hasGenerics,
                    suppressWarnings,
                    isPaneSubclass,
                    styleClass);
        }
    }

    // Keep the old create method for backward compatibility (deprecated)
    @Deprecated
    public static BuildMethodModel create(Class<?> clazz, String className, String classNameWithTypeParameter,
            String typeParameters) {
        boolean hasDefaultConstructor = clazz != null ? new ClassMetadata(clazz).hasDefaultConstructor() : false;
        boolean hasGenerics = !typeParameters.isEmpty();
        boolean suppressWarnings = hasGenerics;
        boolean isPaneSubclass = isPaneSubclass(clazz);
        String styleClass = isPaneSubclass ? toKebabCase(className) : null;

        return new BuildMethodModel(
                className,
                classNameWithTypeParameter,
                hasDefaultConstructor,
                hasGenerics,
                suppressWarnings,
                isPaneSubclass,
                styleClass);
    }

    private static boolean isPaneSubclass(Class<?> clazz) {
        try {
            Class<?> paneClass = Class.forName("javafx.scene.layout.Pane");
            return paneClass.isAssignableFrom(clazz);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private static String toKebabCase(String className) {
        // Extract simple class name from fully qualified class name
        String simpleName = className;
        int lastDotIndex = className.lastIndexOf('.');
        if (lastDotIndex >= 0) {
            simpleName = className.substring(lastDotIndex + 1);
        }

        StringBuilder result = new StringBuilder();
        result.append('.');
        for (int i = 0; i < simpleName.length(); i++) {
            char c = simpleName.charAt(i);
            if (Character.isUpperCase(c)) {
                if (i > 0) {
                    result.append('-');
                }
                result.append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}