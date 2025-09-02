package io.github.sosuisen.model.template;

import java.util.ArrayList;
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
            StaticCall staticCall) {
    }

    private final String builderClassNameWithTypeParameter;
    private final List<LayoutConstraintMethod> methods;

    private LayoutConstraintMethodModel(String builderClassNameWithTypeParameter,
            List<LayoutConstraintMethod> methods) {
        this.builderClassNameWithTypeParameter = builderClassNameWithTypeParameter;
        this.methods = methods;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ClassMetadata classMetadata;
        private List<StaticSetterInfo> staticSetters;

        public Builder classMetadata(ClassMetadata classMetadata) {
            this.classMetadata = classMetadata;
            return this;
        }

        public Builder staticSetters(List<StaticSetterInfo> staticSetters) {
            this.staticSetters = staticSetters;
            return this;
        }

        public LayoutConstraintMethodModel build() {
            if (classMetadata == null || staticSetters == null) {
                throw new IllegalStateException("classMetadata and staticSetters are required");
            }

            // Check if current class inherits from javafx.scene.Node
            if (!classMetadata.isNodeClass()) {
                return new LayoutConstraintMethodModel(
                        classMetadata.builderClassNameWithTypeParameter(),
                        new ArrayList<>());
            }

            // Create individual methods for each static setter
            List<LayoutConstraintMethod> methods = new ArrayList<>();

            for (StaticSetterInfo setterInfo : staticSetters) {
                // Create method name as XXXXIn{SourceClassName}
                String setterName = setterInfo.methodName().substring(3); // Remove "set" prefix
                String sourceClassName = setterInfo.sourceClass().getSimpleName();

                // Apply special naming logic
                String camelCaseSetterName = convertToSpecialCamelCase(setterName);
                String methodName = camelCaseSetterName + "In" + sourceClassName;

                // Filter out Node parameters and create parameter list
                var filteredParams = ParameterInfo.filterNodeParameters(setterInfo.parameters());
                String parameterList = ParameterInfo.buildParameterList(filteredParams, classMetadata.getClassName());
                String argumentList = ParameterInfo.buildArgumentList(filteredParams);

                // Create single StaticCall for this setter
                StaticCall staticCall = new StaticCall(
                        setterInfo.sourceClass().getName(),
                        setterInfo.methodName(),
                        argumentList);

                methods.add(new LayoutConstraintMethod(
                        methodName,
                        parameterList,
                        staticCall));
            }

            return new LayoutConstraintMethodModel(
                    classMetadata.builderClassNameWithTypeParameter(),
                    methods);
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

    public List<LayoutConstraintMethod> methods() {
        return methods;
    }
}