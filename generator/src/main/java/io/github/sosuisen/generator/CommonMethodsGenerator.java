package io.github.sosuisen.generator;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import io.github.sosuisen.model.MethodComparator;
import io.github.sosuisen.model.data.ClassMetadata;
import io.github.sosuisen.model.template.AddWithMethodModel;
import io.github.sosuisen.model.template.ApplyMethodModel;
import io.github.sosuisen.model.template.PropertyMethodModel;
import io.github.sosuisen.model.template.SetterMethodModel;
import io.github.sosuisen.model.template.StylesheetMethodModel;
import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.output.StringOutput;

public class CommonMethodsGenerator {
    private final TemplateEngine templateEngine;
    private final Class<?> clazz;
    private final ClassMetadata classMetadata;

    public CommonMethodsGenerator(TemplateEngine templateEngine, Class<?> clazz,
        ClassMetadata classMetadata) {
        this.templateEngine = templateEngine;
        this.clazz = clazz;
        this.classMetadata = classMetadata;
    }

    public String generateApplyMethod() {
        ApplyMethodModel model = ApplyMethodModel.builder()
            .classMetadata(classMetadata)
            .build();
        TemplateOutput output = new StringOutput();
        templateEngine.render("apply-method.jte", model, output);
        return output.toString();
    }

    public String generateSetterMethods() {
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

    public String generateAddAndWithMethods() {
        StringBuilder result = new StringBuilder();

        // Find all getXxxx methods that return ObservableList and sort them by method name
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

    public String generateStylesheetMethod() {
        StylesheetMethodModel model = StylesheetMethodModel.builder()
            .classMetadata(classMetadata)
            .build();
        TemplateOutput output = new StringOutput();
        templateEngine.render("stylesheet-method.jte", model, output);
        return output.toString();
    }

    public String generatePropertyMethods() {
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

    public String generate() {
        StringBuilder content = new StringBuilder();

        // Standard builder methods

        content.append(generateApplyMethod());

        content.append(generateSetterMethods());
        content.append(generateAddAndWithMethods());

        if (classMetadata.isParentClass()) {
            content.append(generateStylesheetMethod());
        }

        content.append(generatePropertyMethods());

        return content.toString();
    }
}
