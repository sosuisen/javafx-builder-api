package io.github.sosuisen.model.data;

import java.util.List;

import io.github.sosuisen.model.mapper.TypeMappingManager;

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

    public String toSimpleParameterType(String className) {
        String paramType = TypeMappingManager.getReplacement(className, typeName);
        paramType = paramType.substring(findLastDotWordIndexReverse(paramType) + 1);
        return paramType;
    }

    /**
     * Finds the index of the last occurrence of a period followed by a single
     * letter.
     * 
     * Example: ".S" matches in "java.lang.String..." and returns 9.
     * 
     */
    private static int findLastDotWordIndexReverse(String str) {
        for (int i = str.length() - 2; i >= 0; i--) {
            if (str.charAt(i) == '.' &&
                    Character.isLetterOrDigit(str.charAt(i + 1))) {
                return i;
            }
        }
        return -1;
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

    public static String buildParameterListSimpleTypesOnly(List<ParameterInfo> parameters, String className) {
        StringBuilder paramList = new StringBuilder();
        for (int i = 0; i < parameters.size(); i++) {
            if (i > 0)
                paramList.append(", ");
            paramList.append(parameters.get(i).toSimpleParameterType(className));
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