package io.github.sosuisen.model.data;

import java.util.List;

public record StaticSetterInfo(
        Class<?> sourceClass,
        String methodName,
        List<ParameterInfo> parameters,
        String returnType) {
}