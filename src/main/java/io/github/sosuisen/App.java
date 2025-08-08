package io.github.sosuisen;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.util.List;
import java.util.ArrayList;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
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

            BuilderClassGenerator generator = new BuilderClassGenerator();

            System.out.println("Processing: " + jarFileName);

            for (String className : classes) {

                try {
                    Class<?> clazz = Class.forName(className);

                    // Check if the class is public before generating builder
                    if (Modifier.isPublic(clazz.getModifiers())) {
                        generator.generate(clazz);
                    } else {
                        // System.out.println(" - Skipping non-public class: " + className);
                    }
                } catch (ClassNotFoundException e) {
                    System.out.println("  x Class not found: " + className);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("  x Error generating builder for " + className + ": " + e.getMessage());
                }
            }

            System.out.println("Done.");
        } catch (IOException e) {
            System.err.println("Error reading JAR file: " + e.getMessage());
            e.printStackTrace();
        }

        Platform.exit();
    }

    private static List<String> listClassesInJar(String jarPath) throws IOException {
        List<String> classes = new ArrayList<>();

        try (JarFile jarFile = new JarFile(jarPath)) {
            jarFile.stream()
                    .map(JarEntry::getName)
                    .filter(name -> name.endsWith(".class"))
                    .map(name -> name.replace('/', '.').substring(0, name.length() - 6)) // Remove .class extension
                    .filter(className -> className.startsWith("javafx.scene.")) // Filter classes starting with
                                                                                // javafx.scene.
                    .filter(className -> !className.matches(".*\\$\\d+$")) // Skip classes ending with $digit (anonymous
                                                                           // classes)
                    .sorted()
                    .forEach(classes::add);
        }

        return classes;
    }

}
