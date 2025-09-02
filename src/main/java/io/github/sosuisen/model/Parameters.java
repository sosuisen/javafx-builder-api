package io.github.sosuisen.model;

import java.lang.reflect.Parameter;

import io.github.sosuisen.mapper.TypeMappingManager;

public class Parameters {
    public static String buildParameterListWithTypes(Parameter[] parameters, String className, boolean isVarArgs) {
        StringBuilder paramList = new StringBuilder();
        for (int i = 0; i < parameters.length; i++) {
            Parameter param = parameters[i];

            String paramType = param.getParameterizedType().getTypeName();
            if (isVarArgs && i == parameters.length - 1) {
                paramType = paramType.replace("[]", "...");
            }
            paramType = paramType.replaceAll("\\$", ".");

            // Check for type replacement first
            paramType = TypeMappingManager.getReplacement(className, paramType);

            paramList.append(paramType);
            paramList.append(" ").append(param.getName());
            if (i < parameters.length - 1) {
                paramList.append(", ");
            }
        }
        return paramList.toString();
    }

    public static String buildParameterListNamesOnly(Parameter[] parameters) {
        StringBuilder argList = new StringBuilder();
        for (int i = 0; i < parameters.length; i++) {
            Parameter param = parameters[i];
            argList.append(param.getName());
            if (i < parameters.length - 1) {
                argList.append(", ");
            }
        }
        return argList.toString();
    }

    public static String buildParameterListTypesOnly(Parameter[] parameters) {
        StringBuilder argList = new StringBuilder();
        for (int i = 0; i < parameters.length; i++) {
            Parameter param = parameters[i];
            String typeName = TypeNameConverter.toReadableTypeName(param.getType().getName());
            argList.append(typeName);
            if (i < parameters.length - 1) {
                argList.append(", ");
            }
        }
        return argList.toString();
    }
}
