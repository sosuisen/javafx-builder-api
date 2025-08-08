package io.github.sosuisen;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        try {
            var javaFxVersion = BuildInfo.getJavaFXVersion();
            var javaFxPlatform = BuildInfo.getJavaFXPlatform();
            System.out.println("JavaFX Version: " + javaFxVersion);
            System.out.println("JavaFX Platform: " + javaFxPlatform);

            // Construct the path to the JavaFX controls JAR file
            String jarFileName = String.format("javafx.controls-%s.jar", javaFxPlatform);
            Path jarPath = Paths.get("sdk", javaFxVersion, jarFileName);
            
            System.out.println("Reading JAR file: " + jarPath);
            
            // Read and list all classes in the JAR file
            List<String> classes = listClassesInJar(jarPath.toString());
            
            System.out.println("\nClasses found in " + jarFileName + ":");
            System.out.println("Total classes: " + classes.size());
            System.out.println("==========================================");
            
            for (String className : classes) {
                System.out.println(className);
            }
            
        } catch (IOException e) {
            System.err.println("Error reading JAR file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static List<String> listClassesInJar(String jarPath) throws IOException {
        List<String> classes = new ArrayList<>();
        
        try (JarFile jarFile = new JarFile(jarPath)) {
            jarFile.stream()
                .map(JarEntry::getName)
                .filter(name -> name.endsWith(".class"))
                .map(name -> name.replace('/', '.').substring(0, name.length() - 6)) // Remove .class extension
                .filter(className -> className.startsWith("javafx.scene.")) // Filter classes starting with javafx.scene.
                .filter(className -> !className.matches(".*\\$\\d+$")) // Skip classes ending with $digit (anonymous classes)
                .sorted()
                .forEach(classes::add);
        }
        
        return classes;
    }

}
