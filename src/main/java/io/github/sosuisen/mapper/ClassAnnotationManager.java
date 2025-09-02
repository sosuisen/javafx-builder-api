package io.github.sosuisen.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import io.github.sosuisen.model.data.BuildInfo;

public class ClassAnnotationManager {
    private static final Map<String, String> CLASS_ANNOTATIONS = new HashMap<>();

    static {
        loadClassAnnotations();
    }

    private static void loadClassAnnotations() {
        try (InputStream is = ClassAnnotationManager.class
                .getResourceAsStream("/mapper/" + BuildInfo.getJavaFXVersion() + "/class-annotation.properties")) {
            if (is != null) {
                Properties props = new Properties();
                props.load(is);

                for (String key : props.stringPropertyNames()) {
                    String value = props.getProperty(key);
                    CLASS_ANNOTATIONS.put(key, value);
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to load class annotations: " + e.getMessage());
        }
    }

    /**
     * Get class annotation for a class name if it exists
     * 
     * @param className The class name to look up
     * @return The annotation if found, otherwise empty string
     */
    public static String getClassAnnotation(String className) {
        return CLASS_ANNOTATIONS.getOrDefault(className, "");
    }

    /**
     * Check if a class has an annotation defined
     * 
     * @param className The class name to check
     * @return true if annotation exists, false otherwise
     */
    public static boolean hasClassAnnotation(String className) {
        return CLASS_ANNOTATIONS.containsKey(className);
    }
}