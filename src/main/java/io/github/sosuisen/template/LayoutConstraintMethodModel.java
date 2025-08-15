package io.github.sosuisen.template;

import java.util.List;

public class LayoutConstraintMethodModel {
    
    public record StaticCall(
        String sourceClassFullName,
        String staticMethodName,
        String argumentList
    ) {}

    public record LayoutConstraintMethod(
        String methodName,
        String parameterList,
        List<StaticCall> staticCalls
    ) {}

    private final String builderClassNameWithTypeParameter;
    private final List<LayoutConstraintMethod> methods;

    private LayoutConstraintMethodModel(String builderClassNameWithTypeParameter, List<LayoutConstraintMethod> methods) {
        this.builderClassNameWithTypeParameter = builderClassNameWithTypeParameter;
        this.methods = methods;
    }

    public static LayoutConstraintMethodModel create(String builderClassNameWithTypeParameter, List<LayoutConstraintMethod> methods) {
        return new LayoutConstraintMethodModel(builderClassNameWithTypeParameter, methods);
    }

    public String builderClassNameWithTypeParameter() {
        return builderClassNameWithTypeParameter;
    }

    public List<LayoutConstraintMethod> methods() {
        return methods;
    }
}