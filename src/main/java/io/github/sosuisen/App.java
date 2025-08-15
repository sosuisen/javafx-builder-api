package io.github.sosuisen;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.regex.Pattern;

import io.github.sosuisen.extractor.JarExtractor;
import io.github.sosuisen.extractor.LayoutConstraintsExtractor;
import io.github.sosuisen.extractor.StaticSetterInfo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application {

    private static final String PACKAGE_NAME = "io.github.sosuisen.jfxbuilder";
    private static final String[] INPUT_JARS = {
            "javafx.controls",
            "javafx.graphics",
            "javafx.media",
            "javafx.web"
    };

    private static final String[] OUTPUT_DIRS = {
            "src/main/java/io/github/sosuisen/jfxbuilder"
    };

    private List<StaticSetterInfo> staticSetters;

    @Override
    public void start(Stage stage) throws IOException {
        showVersionInfo();

        staticSetters = extractLayoutConstraints();

        generateBuilderClassesFromJars();

        Platform.exit();
    }

    private void showVersionInfo() {
        System.out.println("JavaFX Version: " + BuildInfo.getJavaFXVersion());
        System.out.println("JavaFX Platform: " + BuildInfo.getJavaFXPlatform());
    }

    private List<StaticSetterInfo> extractLayoutConstraints() {
        try {
            LayoutConstraintsExtractor extractor = new LayoutConstraintsExtractor();
            return extractor.getStaticSetters();
        } catch (IOException e) {
            System.err.println("Error during layout constraints extraction: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private void generateBuilderClassesFromJars() {
        try {
            for (String inputJar : INPUT_JARS) {
                List<String> classes = JarExtractor.getSceneClasses(inputJar);
                generateBuilderClasses(classes);
            }
            System.out.println("Done.");
        } catch (IOException e) {
            System.err.println("Error reading JAR file" + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void generateBuilderClasses(List<String> classes) {
        for (String className : classes) {
            try {
                Class<?> clazz = Class.forName(className);

                Pattern innerClassPattern = Pattern.compile(".*\\$..+$");
                boolean isInnerClass = innerClassPattern.matcher(className).matches();

                if (Modifier.isPublic(clazz.getModifiers())
                        && !Modifier.isAbstract(clazz.getModifiers())
                        && (!Modifier.isStatic(clazz.getModifiers())
                                || (Modifier.isStatic(clazz.getModifiers()) && isInnerClass))) {

                    // Extract second token from module name (e.g. controls from javafx.controls)
                    String moduleToken = getModuleToken(clazz);

                    // Create dynamic package name and output directories
                    String dynamicPackageName = PACKAGE_NAME + "." + moduleToken;
                    String[] dynamicOutputDirs = new String[OUTPUT_DIRS.length];
                    for (int i = 0; i < OUTPUT_DIRS.length; i++) {
                        dynamicOutputDirs[i] = OUTPUT_DIRS[i] + "/" + moduleToken;
                    }

                    BuilderClassGenerator generator = new BuilderClassGenerator(dynamicPackageName, dynamicOutputDirs,
                            clazz, staticSetters);
                    generator.generate();
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found: " + className);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error generating builder for " + className + ": " + e.getMessage());
            }
        }
    }

    @SuppressWarnings("rawtypes")
    private String getModuleToken(Class clazz) {
        String moduleName = clazz.getModule().getName();

        // Extract second token from module name (e.g. controls from javafx.controls)
        String moduleToken = "";
        if (moduleName != null && moduleName.contains(".")) {
            String[] tokens = moduleName.split("\\.");
            if (tokens.length >= 2) {
                moduleToken = tokens[1];
            }
        }
        return moduleToken;
    }
}
