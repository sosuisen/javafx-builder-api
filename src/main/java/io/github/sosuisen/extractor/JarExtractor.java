package io.github.sosuisen.extractor;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import io.github.sosuisen.BuildInfo;

public class JarExtractor {
    private static final String SCENE_CLASS_STARTS_WITH = "javafx.scene.";
    private static final String STAGE_CLASS = "javafx.stage.Stage";

    private static Path resolveJarPath(String inputJar) {
        String jarFileName = String.format("%s-%s.jar", inputJar, BuildInfo.getJavaFXPlatform());
        Path jarPath = Paths.get("sdk", BuildInfo.getJavaFXVersion(), jarFileName);
        System.out.println("Reading JAR file: " + jarPath);
        return jarPath;
    }

    public static List<String> getTargetClasses(String inputjar) throws IOException {
        Path jarPath = resolveJarPath(inputjar);

        List<String> classes = new ArrayList<>();

        try (JarFile jarFile = new JarFile(jarPath.toString())) {
            jarFile.stream()
                    .map(JarEntry::getName)
                    .filter(name -> name.endsWith(".class"))
                    // Remove .class extension
                    .map(name -> name.replace('/', '.').substring(0, name.length() - 6))
                    .filter(className -> className.startsWith(SCENE_CLASS_STARTS_WITH)
                            || className.equals(STAGE_CLASS))
                    // Skip classes ending with $digit (anonymous classes)
                    .filter(className -> !className.matches(".*\\$\\d+$"))
                    .sorted()
                    .forEach(classes::add);
        }
        return classes;
    }
}
