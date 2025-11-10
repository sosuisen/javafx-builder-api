package io.github.sosuisen.generator;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import io.github.sosuisen.model.MethodComparator;
import io.github.sosuisen.model.data.ClassMetadata;
import io.github.sosuisen.model.template.BuildMethodModel;
import io.github.sosuisen.model.template.ClassHeaderModel;
import io.github.sosuisen.model.template.CreateMethodModel;
import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.output.StringOutput;

public class StandardCoreGenerator {
    private final TemplateEngine templateEngine;
    private final Class<?> clazz;
    private final ClassMetadata classMetadata;

    public StandardCoreGenerator(TemplateEngine templateEngine, Class<?> clazz,
        ClassMetadata classMetadata) {
        this.templateEngine = templateEngine;
        this.clazz = clazz;
        this.classMetadata = classMetadata;
    }

    public String generate() {
        StringBuilder content = new StringBuilder();

        content.append(generateClassHeader());
        content.append(generateCreateMethods());
        content.append(generateBuildMethod());

        return content.toString();
    }

    private String generateClassHeader() {
        ClassHeaderModel model = ClassHeaderModel.builder()
            .classMetadata(classMetadata)
            .build();
        TemplateOutput output = new StringOutput();
        templateEngine.render("class-header.jte", model, output);
        return output.toString();
    }

    private String generateCreateMethods() {
        StringBuilder content = new StringBuilder();
        Constructor<?>[] constructors = clazz.getConstructors();

        // Sort constructors by their string representation to ensure consistent output order
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
}
