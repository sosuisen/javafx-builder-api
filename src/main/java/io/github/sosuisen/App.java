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

    private static final String PACKAGE_NAME = "io.github.sosuisen.jfxbuilder";
    private static final String[] INPUT_JARS = {
            "javafx.controls",
            "javafx.graphics",
            "javafx.media",
            "javafx.web"
    };

    private static final String[] OUTPUT_DIRS = {
            "target/builder-classes/io/github/sosuisen/jfxbuilder",
            "src/main/java/io/github/sosuisen/jfxbuilder"
    };

    @Override
    public void start(Stage stage) throws IOException {
        startGenerateBuilderClasses();
        Platform.exit();
    }

    private void startGenerateBuilderClasses() {
        try {
            for (String inputJar : INPUT_JARS) {
                System.out.println("Processing: " + inputJar);
                Path jarPath = resolveJarPath(inputJar);
                List<String> classes = extractJavaFXSceneClasses(jarPath);
                generateBuilderClasses(classes);
            }
            System.out.println("Done.");
        } catch (IOException e) {
            System.err.println("Error reading JAR file" + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    private Path resolveJarPath(String inputJar) {
        String javaFxVersion = BuildInfo.getJavaFXVersion();
        String javaFxPlatform = BuildInfo.getJavaFXPlatform();
        System.out.println("JavaFX Version: " + javaFxVersion);
        System.out.println("JavaFX Platform: " + javaFxPlatform);

        String jarFileName = String.format("%s-%s.jar", inputJar, javaFxPlatform);
        Path jarPath = Paths.get("sdk", javaFxVersion, jarFileName);
        System.out.println("Reading JAR file: " + jarPath);
        return jarPath;
    }

    private List<String> extractJavaFXSceneClasses(Path jarPath) throws IOException {
        List<String> classes = new ArrayList<>();

        try (JarFile jarFile = new JarFile(jarPath.toString())) {
            jarFile.stream()
                    .map(JarEntry::getName)
                    .filter(name -> name.endsWith(".class"))
                    // Remove .class extension
                    .map(name -> name.replace('/', '.').substring(0, name.length() - 6))
                    .filter(className -> className.startsWith("javafx.scene."))
                    // Skip classes ending with $digit (anonymous classes)
                    .filter(className -> !className.matches(".*\\$\\d+$"))
                    .sorted()
                    .forEach(classes::add);
        }
        // return List.of("javafx.scene.control.Button",
        // "javafx.scene.layout.BorderPane",
        // "javafx.scene.control.ListView",
        // "javafx.scene.Scene",
        // "javafx.scene.control.TableView",
        // "javafx.scene.layout.VBox");
        return classes;
    }

    private void generateBuilderClasses(List<String> classes) {
        for (String className : classes) {
            try {
                Class<?> clazz = Class.forName(className);
                System.out.println(className + "," + clazz.getModifiers());
                if (Modifier.isPublic(clazz.getModifiers())
                        && !Modifier.isAbstract(clazz.getModifiers())) {
                    BuilderClassGenerator generator = new BuilderClassGenerator(PACKAGE_NAME, OUTPUT_DIRS, clazz);
                    generator.generate();
                }
            } catch (ClassNotFoundException e) {
                System.out.println("  x Class not found: " + className);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("  x Error generating builder for " + className + ": " + e.getMessage());
            }
        }
    }

}
