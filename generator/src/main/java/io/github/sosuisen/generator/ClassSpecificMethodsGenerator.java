package io.github.sosuisen.generator;

import io.github.sosuisen.model.data.ClassMetadata;
import io.github.sosuisen.model.template.AlertMethodModel;
import io.github.sosuisen.model.template.BorderPaneMethodModel;
import io.github.sosuisen.model.template.GridPaneMethodModel;
import io.github.sosuisen.model.template.XYChartMethodModel;
import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.output.StringOutput;

public class ClassSpecificMethodsGenerator {
    private final TemplateEngine templateEngine;
    private final Class<?> clazz;
    private final ClassMetadata classMetadata;

    public ClassSpecificMethodsGenerator(TemplateEngine templateEngine, Class<?> clazz,
        ClassMetadata classMetadata) {
        this.templateEngine = templateEngine;
        this.clazz = clazz;
        this.classMetadata = classMetadata;
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

    public String generate() {
        StringBuilder content = new StringBuilder();
        String className = clazz.getSimpleName();

        // Handle component-specific methods for normal components
        if ("BorderPane".equals(className)) {
            content.append(generateBorderPaneMethods());
        }

        if ("GridPane".equals(className)) {
            content.append(generateGridPaneMethods());
        }

        if ("Alert".equals(className)) {
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

        return content.toString();
    }
}
