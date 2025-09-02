package io.github.sosuisen.template;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

import io.github.sosuisen.model.ParameterStringBuilder;
import io.github.sosuisen.model.data.ClassMetadata;

/**
 * Data model for constructor method JTE template
 */
public record CreateMethodModel(
        String typeParameters,
        String typeParametersWithExtends,
        String builderClassNameWithTypeParameter,
        String builderClassName,
        boolean isDefaultConstructor,
        String parameterList,
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
            String argumentList = "";
            boolean isVarArgs = constructor.isVarArgs();

            if (!isDefaultConstructor) {
                parameterList = ParameterStringBuilder.buildParameterListWithTypes(parameters,
                        classMetadata.getClassName(),
                        isVarArgs);
                argumentList = ParameterStringBuilder.buildParameterListNamesOnly(parameters);
            }

            return new CreateMethodModel(
                    classMetadata.getTypeParameters(),
                    classMetadata.gettypeParametersWithExtends(),
                    classMetadata.builderClassNameWithTypeParameter(),
                    classMetadata.getBuilderClassName(),
                    isDefaultConstructor,
                    parameterList,
                    argumentList,
                    isVarArgs);
        }

    }

}