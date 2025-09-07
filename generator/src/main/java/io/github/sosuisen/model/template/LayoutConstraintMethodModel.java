package io.github.sosuisen.model.template;

import java.util.List;

import io.github.sosuisen.model.data.ClassMetadata;
import io.github.sosuisen.model.data.ParameterInfo;
import io.github.sosuisen.model.data.StaticSetterInfo;

public class LayoutConstraintMethodModel {

    public record StaticCall(
        String sourceClassFullName,
        String staticMethodName,
        String argumentList) {
    }

    public record LayoutConstraintMethod(
        String methodName,
        String parameterList,
        String parameterListSimpleTypesOnly,
        StaticCall staticCall) {
    }

    private final String builderClassNameWithTypeParameter;
    private final LayoutConstraintMethod method;

    private LayoutConstraintMethodModel(String builderClassNameWithTypeParameter,
        LayoutConstraintMethod method) {
        this.builderClassNameWithTypeParameter = builderClassNameWithTypeParameter;
        this.method = method;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ClassMetadata classMetadata;
        private StaticSetterInfo setterInfo;

        public Builder classMetadata(ClassMetadata classMetadata) {
            this.classMetadata = classMetadata;
            return this;
        }

        public Builder setterInfo(StaticSetterInfo setterInfo) {
            this.setterInfo = setterInfo;
            return this;
        }

        public LayoutConstraintMethodModel build() {
            if (classMetadata == null || setterInfo == null) {
                throw new IllegalStateException("classMetadata and setterInfo are required");
            }

            // Create method name as XXXXIn{SourceClassName}
            String setterName = setterInfo.methodName().substring(3); // Remove "set" prefix
            String sourceClassName = setterInfo.sourceClass().getSimpleName();

            // Apply special naming logic
            String camelCaseSetterName = convertToSpecialCamelCase(setterName);
            String methodName = camelCaseSetterName + "In" + sourceClassName;

            // Filter out Node parameters and create parameter list
            List<ParameterInfo> filteredParams =
                ParameterInfo.filterNodeParameters(setterInfo.parameters());
            String parameterList = ParameterInfo.buildParameterList(
                filteredParams,
                classMetadata.getCanonicalClassName()
            );

            String parameterListSimpleTypesOnly = ParameterInfo.buildParameterListSimpleTypesOnly(
                filteredParams,
                classMetadata.getCanonicalClassName()
            );

            String argumentList = ParameterInfo.buildArgumentList(filteredParams);

            // Create single StaticCall for this setter
            StaticCall staticCall = new StaticCall(
                setterInfo.sourceClass().getName(),
                setterInfo.methodName(),
                argumentList
            );

            return new LayoutConstraintMethodModel(
                classMetadata.builderClassNameWithTypeParameter(),
                new LayoutConstraintMethod(
                    methodName,
                    parameterList,
                    parameterListSimpleTypesOnly,
                    staticCall
                )
            );
        }

        private String convertToSpecialCamelCase(String setterName) {
            // Special handling for names starting with 'H' or 'V' followed by lowercase
            // e.g., "Halignment" -> "hAlignment", "Vgrow" -> "vGrow"
            if (setterName.length() >= 2 &&
                (setterName.charAt(0) == 'H' || setterName.charAt(0) == 'V') &&
                Character.isLowerCase(setterName.charAt(1))) {

                String firstChar = String.valueOf(setterName.charAt(0)).toLowerCase();
                String secondChar = String.valueOf(setterName.charAt(1)).toUpperCase();
                String remainder = setterName.substring(2);
                return firstChar + secondChar + remainder;
            } else {
                // Standard case: just lowercase the first character
                String firstChar = String.valueOf(setterName.charAt(0)).toLowerCase();
                String remainder = setterName.substring(1);
                return firstChar + remainder;
            }
        }

    }

    public String builderClassNameWithTypeParameter() {
        return builderClassNameWithTypeParameter;
    }

    public String sourceClassSimpleName() {
        String canonicalName = method.staticCall().sourceClassFullName();
        return canonicalName.substring(canonicalName.lastIndexOf('.') + 1);
    }

    public String sourceClassFullName() {
        return method.staticCall().sourceClassFullName();
    }

    public String staticMethodName() {
        return method.staticCall().staticMethodName();
    }

    public String methodName() {
        return method.methodName();
    }

    public String parameterList() {
        return method.parameterList();
    }

    public String parameterListSimpleTypesOnly() {
        return method.parameterListSimpleTypesOnly();
    }

    public String argumentList() {
        return method.staticCall().argumentList();
    }
}
