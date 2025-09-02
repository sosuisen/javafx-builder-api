package io.github.sosuisen.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;

import io.github.sosuisen.model.data.BuildInfo;

public class TypeMappingManager {
    private static final Map<String, String> TYPE_MAPPINGS = new HashMap<>();
    private static final Map<String, String> STRING_MAPPINGS = new HashMap<>();

    static {
        loadTypeMappings();
    }

    private static void loadTypeMappings() {
        try (InputStream is = TypeMappingManager.class
                .getResourceAsStream("/mapper/" + BuildInfo.getJavaFXVersion() + "/type-mapping.properties")) {
            if (is != null) {
                Properties props = new Properties();
                props.load(is);

                for (String key : props.stringPropertyNames()) {
                    String value = props.getProperty(key);
                    if (key.contains("%")) {
                        // New format: className%matchString=replacementString
                        STRING_MAPPINGS.put(key, value);
                    } else {
                        // Existing format: className#matchType=replacementType
                        TYPE_MAPPINGS.put(key, value);
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
    public static String getReplacement(String className, String paramType) {
        // First check string mappings (new format with %)
        String stringReplacement = findStringReplacement(className, paramType);
        if (stringReplacement != null) {
            paramType = stringReplacement;
        }

        // Then check type mappings (existing format with #)
        MappingEntry entry = findMappingEntry(className);

        if (entry != null) {
            // Found match, process paramType with parsing
            return parseAndProcess(paramType, (token) -> replaceToken(token, entry));
        }

        // Return paramType (potentially modified by string replacement)
        return paramType;
    }

    private static String findStringReplacement(String className, String paramType) {
        // Check STRING_MAPPINGS for matching class and string
        for (Map.Entry<String, String> entry : STRING_MAPPINGS.entrySet()) {
            String key = entry.getKey();
            String replacementString = entry.getValue();

            if (key.contains("%")) {
                String[] parts = key.split("%", 2);
                String mappingClassName = parts[0];
                String matchString = parts[1];

                // If className matches the mapping and paramType contains the match string
                if (className.equals(mappingClassName) && paramType.contains(matchString)) {
                    return paramType.replace(matchString, replacementString);
                }
            }
        }

        return null; // No match found
    }

    private static MappingEntry findMappingEntry(String className) {
        // Check TYPE_MAPPINGS for matching class
        for (Map.Entry<String, String> entry : TYPE_MAPPINGS.entrySet()) {
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

    private static String replaceToken(String token, MappingEntry entry) {
        if (token.endsWith(entry.matchType)) {
            return token.replace(entry.matchType, entry.replacementType);
        } else {
            return token;
        }
    }

    /**
     * Parses a Java type string and processes each token through the provided
     * processor function.
     * 
     * @param typeString The Java type string to parse (e.g., "Map<String, Number>")
     * @param processor  Function to process each token (e.g., "Map", "String",
     *                   "Number")
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