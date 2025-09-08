package io.github.sosuisen;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import io.github.sosuisen.model.MethodComparator;
import io.github.sosuisen.model.data.ClassMetadata;
import io.github.sosuisen.model.data.StaticSetterInfo;
import io.github.sosuisen.model.mapper.FinalReplacementManager;
import io.github.sosuisen.model.template.AddWithMethodModel;
import io.github.sosuisen.model.template.AlertMethodModel;
import io.github.sosuisen.model.template.ApplyMethodModel;
import io.github.sosuisen.model.template.BorderPaneMethodModel;
import io.github.sosuisen.model.template.BuildMethodModel;
import io.github.sosuisen.model.template.ClassHeaderModel;
import io.github.sosuisen.model.template.CreateMethodModel;
import io.github.sosuisen.model.template.GridPaneMethodModel;
import io.github.sosuisen.model.template.LayoutConstraintMethodModel;
import io.github.sosuisen.model.template.PropertyMethodModel;
import io.github.sosuisen.model.template.SetterMethodModel;
import io.github.sosuisen.model.template.StylesheetMethodModel;
import io.github.sosuisen.model.template.XYChartMethodModel;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.output.StringOutput;
import gg.jte.resolve.DirectoryCodeResolver;

public class BuilderClassGenerator {
    private static final TemplateEngine templateEngine = initializeTemplateEngine();

    private final String[] outputDir;
    private final Class<?> clazz;
    private final ClassMetadata classMetadata;

    private final List<StaticSetterInfo> staticSetters;

    public BuilderClassGenerator(String packageName, String[] outputDir, Class<?> clazz,
        List<StaticSetterInfo> staticSetters) {
        this.outputDir = outputDir;
        this.clazz = clazz;
        this.staticSetters = staticSetters;

        classMetadata = new ClassMetadata(clazz, packageName);
    }

    private static TemplateEngine initializeTemplateEngine() {
        Path templatePath = Paths.get("src/main/resources/templates");
        DirectoryCodeResolver codeResolver = new DirectoryCodeResolver(templatePath);
        return TemplateEngine.create(codeResolver, ContentType.Plain);
    }

    public void generate() throws IOException {
        String content = generateBuilderClass();
        writeToFiles(content);
    }

    private String generateBuilderClass() {
        StringBuilder content = new StringBuilder();

        if ("Stage".equals(clazz.getSimpleName())) {
            content.append(generateStageMethods());
        } else if ("Scene".equals(clazz.getSimpleName())) {
            content.append(generateSceneMethods());
        } else {
            content.append(generateClassHeader());
            content.append(generateCreateMethods());
            content.append(generateBuildMethod());
        }

        content.append(generateApplyMethod());

        content.append(generateSetterMethods());

        content.append(generateAddAndWithMethods());

        if (classMetadata.isParentClass()) {
            content.append(generateStylesheetMethod());
        }

        content.append(generateLayoutConstraintMethods());

        content.append(generatePropertyMethods());

        if ("BorderPane".equals(clazz.getSimpleName())) {
            content.append(generateBorderPaneMethods());
        }

        if ("GridPane".equals(clazz.getSimpleName())) {
            content.append(generateGridPaneMethods());
        }

        if ("Alert".equals(clazz.getSimpleName())) {
            content.append(generateAlertMethods());
        }

        try {
            Class<?> xychartClass = Class.forName("javafx.scene.chart.XYChart");
            if (xychartClass.isAssignableFrom(clazz)) {
                content.append(generateXYChartMethod());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(
                "Error generating builder for " + classMetadata.getCanonicalClassName() + ": "
                    + e.getMessage()
            );
        }

        content.append("\n}\n");

        String doc = FinalReplacementManager
            .getReplacement(classMetadata.getCanonicalClassName(), content.toString());

        return doc;
    }

    private String generateClassHeader() {
        ClassHeaderModel model = ClassHeaderModel.builder()
            .classMetadata(classMetadata)
            .build();
        TemplateOutput output = new StringOutput();
        templateEngine.render("class-header.jte", model, output);
        return output.toString();
    }

    private String generateStageMethods() {
        TemplateOutput output = new StringOutput();
        templateEngine.render("stage-methods.jte", null, output);
        return output.toString();
    }

    private String generateSceneMethods() {
        TemplateOutput output = new StringOutput();
        templateEngine.render("scene-methods.jte", null, output);
        return output.toString();
    }

    private String generateCreateMethods() {
        StringBuilder content = new StringBuilder();
        Constructor<?>[] constructors = clazz.getConstructors();

        // Sort constructors by their string representation to ensure consistent output
        // order
        Arrays.sort(constructors, MethodComparator.forConstructor());

        for (Constructor<?> constructor : constructors) {
            content.append(generateCreateMethod(constructor));
        }

        return content.toString();
    }

    private String generateCreateMethod(Constructor<?> constructor) {
        CreateMethodModel model = CreateMethodModel.builder()
            .classMetadata(classMetadata)
            .constructor(constructor)
            .build();
        TemplateOutput output = new StringOutput();
        templateEngine.render("create-method.jte", model, output);
        return output.toString();
    }

    private String generateBuildMethod() {
        BuildMethodModel model = BuildMethodModel.builder()
            .classMetadata(classMetadata)
            .build();
        TemplateOutput output = new StringOutput();
        templateEngine.render("build-method.jte", model, output);
        return output.toString();
    }

    private String generateApplyMethod() {
        ApplyMethodModel model = ApplyMethodModel.builder()
            .classMetadata(classMetadata)
            .build();
        TemplateOutput output = new StringOutput();
        templateEngine.render("apply-method.jte", model, output);
        return output.toString();
    }

    private String generateSetterMethods() {
        StringBuilder content = new StringBuilder();
        Method[] methods = clazz.getMethods();

        // Filter setter methods and sort them by their string representation to ensure
        // consistent output order
        List<Method> setterMethods = Arrays.stream(methods)
            .filter(
                method -> method.getName().startsWith("set")
                    && !java.lang.reflect.Modifier.isStatic(method.getModifiers())
            )
            .sorted(MethodComparator.forMethod())
            .collect(Collectors.toList());

        for (Method method : setterMethods) {
            content.append(generateSetterMethod(method));
        }
        return content.toString();
    }

    private String generateSetterMethod(Method method) {
        SetterMethodModel model = SetterMethodModel.builder()
            .classMetadata(classMetadata)
            .setterMethod(method)
            .build();
        TemplateOutput output = new StringOutput();
        templateEngine.render("setter-method.jte", model, output);
        return output.toString();
    }

    private String generateAddAndWithMethods() {
        StringBuilder result = new StringBuilder();

        // Find all getXxxx methods that return ObservableList and sort them by method
        // name
        Method[] methods = clazz.getMethods();
        List<Method> observableListMethods = Arrays.stream(methods)
            .filter(method -> {
                String methodName = method.getName();
                return !methodName.equals("getChildrenUnmodifiable") &&
                    methodName.startsWith("get") &&
                    !java.lang.reflect.Modifier.isStatic(method.getModifiers()) &&
                    methodName.length() > 3 &&
                    method.getParameterCount() == 0 &&
                    method.getGenericReturnType().getTypeName()
                        .startsWith("javafx.collections.ObservableList<");
            })
            .sorted(Comparator.comparing(Method::getName))
            .collect(Collectors.toList());

        for (Method method : observableListMethods) {
            result.append(generateAddAndWithMethod(method.getName()));
        }

        return result.toString();
    }

    private String generateAddAndWithMethod(String getterMethodName) {
        try {
            AddWithMethodModel model = AddWithMethodModel.builder()
                .getterMethodName(getterMethodName)
                .classMetadata(classMetadata)
                .build();
            TemplateOutput output = new StringOutput();
            templateEngine.render("add-with-methods.jte", model, output);
            return output.toString();
        } catch (IllegalArgumentException e) {
            // Method doesn't exist or doesn't return ObservableList, skip
            return "";
        }
    }

    private String generateStylesheetMethod() {
        StylesheetMethodModel model = StylesheetMethodModel.builder()
            .classMetadata(classMetadata)
            .build();
        TemplateOutput output = new StringOutput();
        templateEngine.render("stylesheet-method.jte", model, output);
        return output.toString();
    }

    private String generateLayoutConstraintMethods() {
        if (!classMetadata.isNodeClass()) { return ""; }
        StringBuilder result = new StringBuilder();
        for (StaticSetterInfo setterInfo : staticSetters) {
            result.append(generateLayoutConstraintMethod(setterInfo));
        }
        return result.toString();
    }

    private String generateLayoutConstraintMethod(StaticSetterInfo setterInfo) {
        LayoutConstraintMethodModel model = LayoutConstraintMethodModel.builder()
            .classMetadata(classMetadata)
            .setterInfo(setterInfo)
            .build();
        TemplateOutput output = new StringOutput();
        templateEngine.render("layout-constraint-methods.jte", model, output);
        return output.toString();
    }

    private String generatePropertyMethods() {
        StringBuilder content = new StringBuilder();
        Method[] methods = clazz.getMethods();

        Arrays.sort(methods, MethodComparator.forMethod());

        for (Method method : methods) {
            if (method.getName().endsWith("Property")
                && !java.lang.reflect.Modifier.isStatic(method.getModifiers())
                && method.getParameterCount() == 0) {

                content.append(generatePropertyMethod(method));
            }
        }

        return content.toString();
    }

    private String generatePropertyMethod(Method method) {
        PropertyMethodModel model = PropertyMethodModel.builder()
            .classMetadata(classMetadata)
            .propertyMethod(method)
            .build();
        TemplateOutput output = new StringOutput();
        templateEngine.render("property-method.jte", model, output);
        return output.toString();
    }

    private String generateBorderPaneMethods() {
        BorderPaneMethodModel model = BorderPaneMethodModel.builder()
            .classMetadata(classMetadata)
            .build();
        TemplateOutput output = new StringOutput();
        templateEngine.render("borderpane-methods.jte", model, output);
        return output.toString();
    }

    private String generateGridPaneMethods() {
        GridPaneMethodModel model = GridPaneMethodModel.builder()
            .classMetadata(classMetadata)
            .build();
        TemplateOutput output = new StringOutput();
        templateEngine.render("gridpane-methods.jte", model, output);
        return output.toString();
    }

    private String generateAlertMethods() {
        AlertMethodModel model = AlertMethodModel.builder()
            .classMetadata(classMetadata)
            .build();
        TemplateOutput output = new StringOutput();
        templateEngine.render("alert-methods.jte", model, output);
        return output.toString();
    }

    private String generateXYChartMethod() {
        XYChartMethodModel model = XYChartMethodModel.builder()
            .classMetadata(classMetadata)
            .build();
        TemplateOutput output = new StringOutput();
        templateEngine.render("xychart-methods.jte", model, output);
        return output.toString();
    }

    private void writeToFiles(String content) throws IOException {
        // Create directories and write files to all output locations
        for (String outputDirPath : outputDir) {
            Path outputDir = Paths.get(outputDirPath);
            Files.createDirectories(outputDir);

            Path outputFile = outputDir.resolve(classMetadata.getBuilderClassName() + ".java");
            Files.write(outputFile, content.getBytes());
        }
    }

}
