package io.github.sosuisen.model.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.function.Function;

import io.github.sosuisen.model.data.BuildInfo;
import io.github.sosuisen.model.data.ClassMetadata;

public class JavaDocMappingManager {
    private static final Map<String, String> TYPE_MAPPINGS = new HashMap<>();
    private static final Map<String, String> SUPER_TYPE_MAPPINGS = new HashMap<>();

    static {
        loadTypeMappings();
    }

    private static void loadTypeMappings() {
        try (InputStream is = TypeMappingManager.class
            .getResourceAsStream(
                "/mapper/" + BuildInfo.getJavaFXMajorVersion() + "/javadoc-mapping.properties"
            )) {
            if (is != null) {
                Properties props = new Properties();
                props.load(is);

                for (String key : props.stringPropertyNames()) {
                    String value = props.getProperty(key);

                    if (key.contains("#")) {
                        // Format: {className}#{matchType}={replacementType}
                        TYPE_MAPPINGS.put(key, value);
                    } else if (key.contains("^")) {
                        // Format: {superClassName}^{matchString}={replacementString}
                        SUPER_TYPE_MAPPINGS.put(key, value);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to load type mappings: " + e.getMessage());
        }
    }

    private record MappingEntry(String matchType, String replacementType) {
    }

    /**
     * Get replacement type for a parameter type if it matches any mapping rules
     * 
     * @param className The class name that contains this parameter
     * @param paramType The original parameter type
     * @return The replacement type if found, otherwise the original type
     */
    public static String getReplacement(ClassMetadata classMetadata, String paramType) {
        MappingEntry superMappingEntry = findSuperMappingEntry(classMetadata.getClass());
        if (superMappingEntry != null) {
            return parseAndProcess(paramType, (token) -> replaceToken(token, superMappingEntry));
        }

        MappingEntry entry = findMappingEntry(classMetadata.getCanonicalClassName());
        if (entry != null) {
            return parseAndProcess(paramType, (token) -> replaceToken(token, entry));
        }

        return defaultMapping(paramType);
    }

    private static MappingEntry findSuperMappingEntry(Class<?> clazz) {
        Set<Map.Entry<String, String>> entrySet = SUPER_TYPE_MAPPINGS.entrySet();

        for (Map.Entry<String, String> entry : entrySet) {
            String key = entry.getKey();
            String replacementType = entry.getValue();

            if (key.contains("^")) {
                String[] parts = key.split("\\^", 2);
                String superClassName = parts[0];
                String matchType = parts[1];

                try {
                    Class<?> superClass = Class.forName(superClassName);
                    if (superClass.isAssignableFrom(clazz)) {
                        return new MappingEntry(matchType, replacementType);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        return null; // No match found
    }

    private static MappingEntry findMappingEntry(String className) {
        Set<Map.Entry<String, String>> entrySet = TYPE_MAPPINGS.entrySet();

        for (Map.Entry<String, String> entry : entrySet) {
            String key = entry.getKey();
            String replacementType = entry.getValue();

            if (key.contains("#")) {
                String[] parts = key.split("#", 2);
                String mappingClassName = parts[0];
                String matchType = parts[1];

                // If className matches the mapping
                if (className.equals(mappingClassName)) {
                    return new MappingEntry(matchType, replacementType);
                }
            }
        }

        return null; // No match found
    }

    private static String defaultMapping(String paramType) {
        return switch (paramType) {
            case "C" -> "java.lang.Object";
            case "S" -> "java.lang.Object";
            case "T" -> "java.lang.Object";
            case "R" -> "java.lang.Object";
            case "V" -> "java.lang.Object";
            case "X" -> "java.lang.Object";
            case "Y" -> "java.lang.Object";
            case "T..." -> "java.lang.Object...";
            default -> paramType;
        };
    }

    private static String replaceToken(String token, MappingEntry entry) {
        if (token.endsWith(entry.matchType)) {
            return token.replace(entry.matchType, entry.replacementType);
        } else {
            return token;
        }
    }

    /**
     * Parses a Java type string and processes each token through the provided processor function.
     * 
     * @param typeString The Java type string to parse (e.g., "Map<String, Number>")
     * @param processor Function to process each token (e.g., "Map", "String", "Number")
     * @return Processed type string in which tokens are replaced by the processor.
     */
    public static String parseAndProcess(String typeString, Function<String, String> processor) {
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < typeString.length()) {
            StringBuilder token = new StringBuilder();

            // Parse one token - read characters until end of string or delimiters < , >
            while (i < typeString.length()) {
                char c = typeString.charAt(i);
                if (c == '<' || c == ',' || c == '>') {
                    break;
                }
                token.append(c);
                i++;
            }
            // Process the token if it's not empty
            if (token.length() > 0) {
                String processedToken = processor.apply(token.toString());
                result.append(processedToken);
            }

            // Add the delimiter character if we're not at the end
            if (i < typeString.length()) {
                result.append(typeString.charAt(i));
                i++;
            }
        }
        return result.toString();
    }
}
