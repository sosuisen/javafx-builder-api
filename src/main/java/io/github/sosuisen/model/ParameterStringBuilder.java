package io.github.sosuisen.model;

import java.lang.reflect.Parameter;
import java.util.Map;

import io.github.sosuisen.model.mapper.TypeMappingManager;

public class ParameterStringBuilder {
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

    public static String buildParameterListCanonicalTypesOnly(Parameter[] parameters) {
        StringBuilder argList = new StringBuilder();
        for (int i = 0; i < parameters.length; i++) {
            Parameter param = parameters[i];
            String typeName = toReadableTypeName(param.getType().getName());
            argList.append(typeName);
            if (i < parameters.length - 1) {
                argList.append(", ");
            }
        }
        return argList.toString();
    }

    public static String buildParameterListSimpleTypesOnly(Parameter[] parameters) {
        StringBuilder argList = new StringBuilder();
        for (int i = 0; i < parameters.length; i++) {
            Parameter param = parameters[i];
            String typeName = toReadableTypeName(param.getType().getName());

            typeName = typeName.substring(findLastDotWordIndexReverse(typeName) + 1);
            argList.append(typeName);
            if (i < parameters.length - 1) {
                argList.append(", ");
            }
        }
        return argList.toString();
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

    // Mapping for primitive array type descriptors to readable names with varargs
    private static final Map<String, String> PRIMITIVE_ARRAY_MAP = Map.of(
            "[Z", "boolean...",
            "[B", "byte...",
            "[C", "char...",
            "[D", "double...",
            "[F", "float...",
            "[I", "int...",
            "[J", "long...",
            "[S", "short...");

    /**
     * Converts internal Java type name to readable format with varargs notation.
     * Handles primitive arrays like [D -> double..., [I -> int..., etc.
     * 
     * @param internalTypeName The internal type name from Class.getName()
     * @return Readable type name with varargs notation
     */
    private static String toReadableTypeName(String internalTypeName) {
        // Handle primitive arrays
        if (PRIMITIVE_ARRAY_MAP.containsKey(internalTypeName)) {
            return PRIMITIVE_ARRAY_MAP.get(internalTypeName);
        }

        // Handle object arrays like [Ljava.lang.String; -> java.lang.String...
        if (internalTypeName.startsWith("[L") && internalTypeName.endsWith(";")) {
            String className = internalTypeName.substring(2, internalTypeName.length() - 1);
            return className + "...";
        }

        // For regular types, return as-is
        return internalTypeName;
    }
}
