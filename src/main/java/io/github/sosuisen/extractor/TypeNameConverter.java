package io.github.sosuisen.extractor;

import java.util.Map;

/**
 * Utility class for converting Java internal type names to readable type names.
 * Handles primitive arrays and converts them to varargs notation.
 */
public class TypeNameConverter {
    
    // Mapping for primitive array type descriptors to readable names with varargs
    private static final Map<String, String> PRIMITIVE_ARRAY_MAP = Map.of(
        "[Z", "boolean...",
        "[B", "byte...",
        "[C", "char...",
        "[D", "double...",
        "[F", "float...",
        "[I", "int...",
        "[J", "long...",
        "[S", "short..."
    );
    
    /**
     * Converts internal Java type name to readable format with varargs notation.
     * Handles primitive arrays like [D -> double..., [I -> int..., etc.
     * 
     * @param internalTypeName The internal type name from Class.getName()
     * @return Readable type name with varargs notation
     */
    public static String toReadableTypeName(String internalTypeName) {
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