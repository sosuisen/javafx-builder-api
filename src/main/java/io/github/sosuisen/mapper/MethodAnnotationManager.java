package io.github.sosuisen.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import io.github.sosuisen.model.data.BuildInfo;

public class MethodAnnotationManager {
    private static final Map<String, String> METHOD_ANNOTATIONS = new HashMap<>();

    static {
        loadMethodAnnotations();
    }

    private static void loadMethodAnnotations() {
        try (InputStream is = MethodAnnotationManager.class
                .getResourceAsStream("/mapper/" + BuildInfo.getJavaFXVersion() + "/method-annotation.properties")) {
            if (is != null) {
                Properties props = new Properties();
                props.load(is);

                for (String key : props.stringPropertyNames()) {
                    String value = props.getProperty(key);
                    METHOD_ANNOTATIONS.put(key, value);
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to load method annotations: " + e.getMessage());
        }
    }

    /**
     * Get method annotation for a class and method name if it exists
     * 
     * @param className  The class name
     * @param methodName The method name
     * @return The annotation if found, otherwise empty string
     */
    public static String getMethodAnnotation(String className, String methodName) {
        String key = className + "#" + methodName;
        return METHOD_ANNOTATIONS.getOrDefault(key, "");
    }
}