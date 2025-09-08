package io.github.sosuisen.model.template;

import java.lang.reflect.Method;

import io.github.sosuisen.model.ParameterStringBuilder;
import io.github.sosuisen.model.data.ClassMetadata;
import io.github.sosuisen.model.mapper.MethodAnnotationManager;

/**
 * Data model for setter method JTE template
 */
public record SetterMethodModel(
    String builderClassNameWithTypeParameter,
    String methodName,
    String parameterList,
    String parameterTypeList,
    String argumentList,
    String originalClassName,
    String originalMethodName,
    String methodAnnotation) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ClassMetadata classMetadata;
        private Method setterMethod;

        public Builder classMetadata(ClassMetadata classMetadata) {
            this.classMetadata = classMetadata;
            return this;
        }

        public Builder setterMethod(Method setterMethod) {
            this.setterMethod = setterMethod;
            return this;
        }

        public SetterMethodModel build() {
            if (classMetadata == null || setterMethod == null) {
                throw new IllegalStateException("classMetadata and setterMethod are required");
            }

            // Calculate method name by removing "set" prefix and lowercasing first char
            String methodName = setterMethod.getName().substring(3);
            methodName = Character.toLowerCase(methodName.charAt(0)) + methodName.substring(1);

            // Build parameter lists
            String parameterList = ParameterStringBuilder.buildParameterListWithTypes(
                setterMethod.getParameters(), classMetadata.getCanonicalClassName(),
                setterMethod.isVarArgs()
            );
            String parameterTypeList = ParameterStringBuilder
                .buildParameterListCanonicalTypesOnly(setterMethod.getGenericParameterTypes());
            String argumentList =
                ParameterStringBuilder.buildParameterListNamesOnly(setterMethod.getParameters());

            // Get method annotation
            String methodAnnotation = MethodAnnotationManager.getMethodAnnotation(
                classMetadata.getCanonicalClassName(), setterMethod.getName()
            );

            return new SetterMethodModel(
                classMetadata.builderClassNameWithTypeParameter(),
                methodName,
                parameterList,
                parameterTypeList,
                argumentList,
                classMetadata.getCanonicalClassName(),
                setterMethod.getName(),
                methodAnnotation != null ? methodAnnotation : ""
            );
        }
    }

}
