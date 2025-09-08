package io.github.sosuisen.model.template;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

import io.github.sosuisen.model.ParameterStringBuilder;
import io.github.sosuisen.model.data.ClassMetadata;

/**
 * Data model for constructor method JTE template
 */
public record CreateMethodModel(
    String canonicalClassName,
    String simpleClassName,
    String typeParametersWithExtends,
    String builderClassNameWithTypeParameter,
    String builderClassName,
    boolean isDefaultConstructor,
    String parameterList,
    String parameterListTypesOnly,
    String parameterListSimpleTypesOnly,
    String argumentList,
    boolean isVarArgs) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ClassMetadata classMetadata;
        private Constructor<?> constructor;

        public Builder classMetadata(ClassMetadata classMetadata) {
            this.classMetadata = classMetadata;
            return this;
        }

        public Builder constructor(Constructor<?> constructor) {
            this.constructor = constructor;
            return this;
        }

        public CreateMethodModel build() {
            if (classMetadata == null || constructor == null) {
                throw new IllegalStateException("classMetadata and constructor are required");
            }

            Parameter[] parameters = constructor.getParameters();
            boolean isDefaultConstructor = parameters.length == 0;

            String parameterList = "";
            String parameterListTypesOnly = "";
            String parameterListSimpleTypesOnly = "";
            String argumentList = "";
            boolean isVarArgs = constructor.isVarArgs();

            if (!isDefaultConstructor) {
                parameterList = ParameterStringBuilder.buildParameterListWithTypes(
                    parameters,
                    classMetadata.getCanonicalClassName(),
                    isVarArgs
                );
                parameterListTypesOnly =
                    ParameterStringBuilder.buildParameterListCanonicalTypesOnly(parameters);
                parameterListSimpleTypesOnly =
                    ParameterStringBuilder.buildParameterListSimpleTypesOnly(parameters);
                argumentList = ParameterStringBuilder.buildParameterListNamesOnly(parameters);
            }

            return new CreateMethodModel(
                classMetadata.getCanonicalClassName(),
                classMetadata.getSimpleClassName(),
                classMetadata.getTypeParametersWithExtends(),
                classMetadata.builderClassNameWithTypeParameter(),
                classMetadata.getBuilderClassName(),
                isDefaultConstructor,
                parameterList,
                parameterListTypesOnly,
                parameterListSimpleTypesOnly,
                argumentList,
                isVarArgs
            );
        }

    }

}
