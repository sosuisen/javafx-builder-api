package io.github.sosuisen.model.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import io.github.sosuisen.model.data.BuildInfo;

public class FinalReplacementManager {
    private static final Map<String, String> STRING_MAPPINGS = new HashMap<>();

    static {
        loadReplacements();
    }

    private static void loadReplacements() {
        try (InputStream is = FinalReplacementManager.class
            .getResourceAsStream(
                "/mapper/" + BuildInfo.getJavaFXMajorVersion() + "/final-replacement.properties"
            )) {
            if (is != null) {
                Properties props = new Properties();
                props.load(is);

                for (String key : props.stringPropertyNames()) {
                    String value = props.getProperty(key);
                    if (key.contains("%")) {
                        // Format: {className}%{matchString}={replacementString}
                        STRING_MAPPINGS.put(key, value);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to load type mappings: " + e.getMessage());
        }
    }

    /**
     * Get replaced document
     * 
     * @param className The class name that contains this parameter
     * @param doc The original document
     * @return The replaced document
     */
    public static String getReplacement(String className, String doc) {
        for (Map.Entry<String, String> entry : STRING_MAPPINGS.entrySet()) {
            String key = entry.getKey();
            if (key.contains("%")) {
                String replacementString = entry.getValue();
                String[] parts = key.split("%", 2);
                String mappingClassName = parts[0];
                String matchString = parts[1];
                if (className.equals(mappingClassName)) {
                    return doc.replace(matchString, replacementString);
                }
            }
        }
        return doc;
    }
}
