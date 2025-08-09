package io.github.sosuisen.mapper;

import io.github.sosuisen.BuildInfo;
import io.github.sosuisen.TypeParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TypeMappingManager {
    private static final Map<String, String> TYPE_MAPPINGS = new HashMap<>();

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
                    TYPE_MAPPINGS.put(key, value);
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
        MappingEntry entry = findMappingEntry(className);

        if (entry != null) {
            // Found match, process paramType with parsing
            return TypeParser.parseAndProcess(paramType, (token) -> replaceToken(token, entry));
        }

        // No match found, return original paramType
        return paramType;
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

}