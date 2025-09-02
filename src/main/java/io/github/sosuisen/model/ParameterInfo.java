package io.github.sosuisen.model;

import java.util.List;

import io.github.sosuisen.mapper.TypeMappingManager;

public record ParameterInfo(
        String typeName,
        String parameterName) {

    public boolean isNodeType() {
        return typeName.equals("javafx.scene.Node") ||
                typeName.startsWith("javafx.scene.Node<") ||
                typeName.endsWith(".Node");
    }

    public String toParameterString(String className) {
        String paramType = TypeMappingManager.getReplacement(className, typeName);
        return paramType + " " + parameterName;
    }

    public static List<ParameterInfo> filterNodeParameters(List<ParameterInfo> parameters) {
        return parameters.stream()
                .filter(param -> !param.isNodeType())
                .collect(java.util.stream.Collectors.toList());
    }

    public static String buildParameterList(List<ParameterInfo> parameters, String className) {
        StringBuilder paramList = new StringBuilder();
        for (int i = 0; i < parameters.size(); i++) {
            if (i > 0)
                paramList.append(", ");
            paramList.append(parameters.get(i).toParameterString(className));
        }
        return paramList.toString();
    }

    public static String buildArgumentList(List<ParameterInfo> parameters) {
        StringBuilder argList = new StringBuilder();
        for (int i = 0; i < parameters.size(); i++) {
            if (i > 0)
                argList.append(", ");
            argList.append(parameters.get(i).parameterName());
        }
        return argList.toString();
    }
}