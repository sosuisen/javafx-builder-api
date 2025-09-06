package io.github.sosuisen;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.regex.Pattern;

import io.github.sosuisen.model.JarExtractor;
import io.github.sosuisen.model.LayoutConstraintsExtractor;
import io.github.sosuisen.model.data.BuildInfo;
import io.github.sosuisen.model.data.StaticSetterInfo;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application {

    private static final String PACKAGE_NAME = "io.github.sosuisen.jfxbuilder";
    private static final String INPUT_JAR_PREFIX = "javafx.";

    private static final String OUTPUT_ROOT = "generated-api";
    private static final String OUTPUT_PATH = "src/main/java/io/github/sosuisen/jfxbuilder";

    // private static final String ERRORCHECK_OUTPUT_PATH =
    // "src/main/java/io/github/sosuisen/jfxbuilder";

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
            String inputJar = INPUT_JAR_PREFIX + BuildInfo.getBuilderComponent();
            List<String> classes = JarExtractor.getTargetClasses(inputJar);
            generateBuilderClasses(classes);
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
                    String[] dynamicOutputDirs = new String[1];

                    dynamicOutputDirs[0] =
                        OUTPUT_ROOT + "/" + BuildInfo.getJavaFXVersion().substring(0, 2) + "/"
                            + moduleToken
                            + "/" + OUTPUT_PATH + "/" + moduleToken;

                    // dynamicOutputDirs[1] = ERRORCHECK_OUTPUT_PATH + "/" + moduleToken;

                    BuilderClassGenerator generator = new BuilderClassGenerator(
                        dynamicPackageName, dynamicOutputDirs,
                        clazz, staticSetters
                    );
                    generator.generate();
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found: " + className);
            } catch (Exception e) {
                e.printStackTrace();
                System.out
                    .println("Error generating builder for " + className + ": " + e.getMessage());
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
