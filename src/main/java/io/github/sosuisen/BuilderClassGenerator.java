package io.github.sosuisen;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.sosuisen.mapper.ClassAnnotationManager;
import io.github.sosuisen.mapper.MethodAnnotationManager;
import io.github.sosuisen.mapper.TypeMappingManager;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.output.StringOutput;
import gg.jte.resolve.DirectoryCodeResolver;
import io.github.sosuisen.template.BuildMethodModel;
import io.github.sosuisen.template.ChildrenMethodModel;
import io.github.sosuisen.template.BorderPaneMethodModel;
import io.github.sosuisen.template.StyleClassMethodModel;
import io.github.sosuisen.template.SetterMethodModel;
import io.github.sosuisen.template.ApplyMethodModel;
import io.github.sosuisen.template.CreateMethodModel;
import io.github.sosuisen.template.GridPaneMethodModel;
import io.github.sosuisen.template.ClassHeaderModel;

public class BuilderClassGenerator {
    private static final TemplateEngine templateEngine = initializeTemplateEngine();

    private final String packageName;
    private final String[] outputDir;
    private final Class<?> clazz;
    private final String typeParameters;
    private final String typeParametersExtends;
    private final String className;
    private final String classNameWithTypeParameter;
    private final String builderClassName;
    private final String builderClassNameWithTypeParameter;

    public BuilderClassGenerator(String packageName, String[] outputDir, Class<?> clazz) {
        this.packageName = packageName;
        this.outputDir = outputDir;
        this.clazz = clazz;
        typeParameters = getTypeParameterString(clazz);
        typeParametersExtends = getTypeParameterExtendsString(clazz);
        className = clazz.getCanonicalName();
        classNameWithTypeParameter = className + typeParameters;
        builderClassName = createBuilderClassName();
        builderClassNameWithTypeParameter = builderClassName + typeParameters;
    }

    private String createBuilderClassName() {
        // Find the first uppercase letter
        int firstUpperCaseIndex = -1;
        for (int i = 0; i < className.length(); i++) {
            if (Character.isUpperCase(className.charAt(i))) {
                firstUpperCaseIndex = i;
                break;
            }
        }

        // If no uppercase letter found, use the entire className
        if (firstUpperCaseIndex == -1) {
            return className.replace(".", "") + "Builder";
        }

        // Extract substring from first uppercase letter onwards and remove dots
        String result = className.substring(firstUpperCaseIndex).replace(".", "") + "Builder";
        return result;
    }

    private static TemplateEngine initializeTemplateEngine() {
        Path templatePath = Paths.get("src/main/resources/templates");
        DirectoryCodeResolver codeResolver = new DirectoryCodeResolver(templatePath);
        return TemplateEngine.create(codeResolver, ContentType.Plain);
    }

    private String getTypeParameterString(Class<?> clazz) {
        if (clazz.getTypeParameters().length == 0) {
            return "";
        }

        StringBuilder typeParameterBuilder = new StringBuilder("<");
        for (int i = 0; i < clazz.getTypeParameters().length; i++) {
            if (i > 0)
                typeParameterBuilder.append(", ");

            typeParameterBuilder.append(clazz.getTypeParameters()[i].getName());
        }
        typeParameterBuilder.append(">");
        return typeParameterBuilder.toString();
    }

    private String getTypeParameterExtendsString(Class<?> clazz) {
        if (clazz.getTypeParameters().length == 0) {
            return "";
        }

        StringBuilder typeParameterBuilder = new StringBuilder("<");
        for (int i = 0; i < clazz.getTypeParameters().length; i++) {
            if (i > 0)
                typeParameterBuilder.append(", ");

            Type[] bounds = clazz.getTypeParameters()[i].getBounds();
            if (bounds.length > 0) {
                if (!bounds[0].getTypeName().equals("java.lang.Object")) {
                    // e.g.) CellSkinBase<C extends Cell>
                    typeParameterBuilder
                            .append(clazz.getTypeParameters()[i].getName() + " extends " + bounds[0].getTypeName());
                } else {
                    typeParameterBuilder.append(clazz.getTypeParameters()[i].getName());
                }
            } else {
                typeParameterBuilder.append(clazz.getTypeParameters()[i].getName());
            }

        }
        typeParameterBuilder.append(">");
        return typeParameterBuilder.toString();
    }

    public void generate() throws IOException {
        String content = generateBuilderClass();
        writeToFiles(content);
    }

    private String generateBuilderClass() {
        StringBuilder content = new StringBuilder();

        content.append(generateClassHeader());
        content.append(generateConstructors());
        content.append(generateBuildMethod());
        content.append(generateTypeCompatibilityCheckMethods());
        content.append(generateApplyMethod());
        content.append(generateSetterMethods());
        content.append(generateSpecialMethods());
        content.append("}\n");

        return content.toString();
    }

    private String generateClassHeader() {
        String classAnnotation = ClassAnnotationManager.getClassAnnotation(className);

        ClassHeaderModel model = ClassHeaderModel.create(
                packageName,
                builderClassName,
                typeParameters,
                typeParametersExtends,
                classNameWithTypeParameter,
                classAnnotation);

        TemplateOutput output = new StringOutput();
        templateEngine.render("class-header.jte", model, output);
        return output.toString();
    }

    private String generateConstructors() {
        StringBuilder content = new StringBuilder();
        Constructor<?>[] constructors = clazz.getConstructors();

        for (Constructor<?> constructor : constructors) {
            content.append(generateCreateMethods(constructor));
        }

        return content.toString();
    }

    private String generateCreateMethods(Constructor<?> constructor) {
        Parameter[] parameters = constructor.getParameters();

        CreateMethodModel model;

        if (parameters.length == 0) {
            model = CreateMethodModel.createDefault(
                    typeParameters,
                    typeParametersExtends,
                    builderClassNameWithTypeParameter,
                    builderClassName);
        } else {
            String parameterList = buildParameterListWithTypes(parameters, constructor.isVarArgs());
            String argumentList = buildParameterListNamesOnly(parameters);

            model = CreateMethodModel.createParameterized(
                    typeParameters,
                    typeParametersExtends,
                    builderClassNameWithTypeParameter,
                    builderClassName,
                    parameterList,
                    argumentList,
                    constructor.isVarArgs());
        }

        TemplateOutput output = new StringOutput();
        templateEngine.render("create-method.jte", model, output);
        return output.toString();
    }

    private String buildParameterListWithTypes(Parameter[] parameters, boolean isVarArgs) {
        StringBuilder paramList = new StringBuilder();
        for (int i = 0; i < parameters.length; i++) {
            Parameter param = parameters[i];

            String paramType = param.getParameterizedType().getTypeName();
            if (isVarArgs) {
                paramType = paramType.replace("[]", "...");
            }
            paramType = paramType.replaceAll("\\$", ".");

            // Check for type replacement first
            paramType = TypeMappingManager.getReplacement(className, paramType);

            paramList.append(paramType);
            paramList.append(" ").append(param.getName());
            if (i < parameters.length - 1) {
                paramList.append(", ");
            }
        }
        return paramList.toString();
    }

    private String buildParameterListNamesOnly(Parameter[] parameters) {
        StringBuilder argList = new StringBuilder();
        for (int i = 0; i < parameters.length; i++) {
            Parameter param = parameters[i];
            argList.append(param.getName());
            if (i < parameters.length - 1) {
                argList.append(", ");
            }
        }
        return argList.toString();
    }

    private String generateBuildMethod() {
        BuildMethodModel model = BuildMethodModel.create(clazz, className, classNameWithTypeParameter, typeParameters);
        TemplateOutput output = new StringOutput();
        templateEngine.render("build-method.jte", model, output);
        return output.toString();
    }

    private String generateTypeCompatibilityCheckMethods() {
        TemplateOutput output = new StringOutput();
        templateEngine.render("type-compatibility-methods.jte", null, output);
        return output.toString();
    }

    private String generateApplyMethod() {
        ApplyMethodModel model = ApplyMethodModel.create(builderClassNameWithTypeParameter, classNameWithTypeParameter);
        TemplateOutput output = new StringOutput();
        templateEngine.render("apply-method.jte", model, output);
        return output.toString();
    }

    private String generateSetterMethods() {
        StringBuilder content = new StringBuilder();
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            if (method.getName().startsWith("set") && !java.lang.reflect.Modifier.isStatic(method.getModifiers())) {

                String methodName = method.getName().substring(3);
                methodName = Character.toLowerCase(methodName.charAt(0)) + methodName.substring(1);

                Parameter[] parameters = method.getParameters();
                String parameterList = buildParameterListWithTypes(parameters, method.isVarArgs());
                String argumentList = buildParameterListNamesOnly(parameters);

                String methodAnnotation = MethodAnnotationManager.getMethodAnnotation(className, method.getName());
                SetterMethodModel model = SetterMethodModel.create(
                        builderClassNameWithTypeParameter,
                        methodName,
                        parameterList,
                        argumentList,
                        method.getName(),
                        methodAnnotation);

                TemplateOutput output = new StringOutput();
                templateEngine.render("setter-method.jte", model, output);

                content.append(output.toString());
            }
        }

        return content.toString();
    }

    private String generateSpecialMethods() {
        StringBuilder content = new StringBuilder();

        // Generate styleClass method for Node-based classes
        content.append(generateStyleClassMethod());

        // Check for getChildren method and generate children method
        content.append(generateChildrenMethod());

        // Generate BorderPane specific static methods
        if ("BorderPane".equals(clazz.getSimpleName())) {
            content.append(generateBorderPaneMethods());
        }

        if ("GridPane".equals(clazz.getSimpleName())) {
            content.append(generateGridPaneMethods());
        }

        return content.toString();
    }

    private String generateStyleClassMethod() {
        try {
            Method getStyleClassMethod = clazz.getMethod("getStyleClass");
            if (getStyleClassMethod != null
                    && getStyleClassMethod.getReturnType().getName().contains("ObservableList")) {
                StyleClassMethodModel model = StyleClassMethodModel.create(builderClassNameWithTypeParameter);
                TemplateOutput output = new StringOutput();
                templateEngine.render("styleclass-methods.jte", model, output);
                return output.toString();
            }
        } catch (NoSuchMethodException e) {
            // Class doesn't have getStyleClass method, skip generation
        }
        return "";
    }

    private String generateChildrenMethod() {
        try {
            Method getChildrenMethod = clazz.getMethod("getChildren");
            String returnType = getChildrenMethod.getGenericReturnType().getTypeName();
            if (returnType.startsWith("javafx.collections.ObservableList<")) {
                Pattern pattern = Pattern.compile("<(.+)>$");
                Matcher matcher = pattern.matcher(returnType);
                if (matcher.find()) {
                    String observableListTypeParameter = matcher.group(1);
                    ChildrenMethodModel model = ChildrenMethodModel.create(builderClassName,
                            builderClassNameWithTypeParameter,
                            observableListTypeParameter,
                            typeParametersExtends);
                    TemplateOutput output = new StringOutput();
                    templateEngine.render("children-methods.jte", model, output);
                    return output.toString();
                } else {
                    return "";
                }
            }
        } catch (NoSuchMethodException e) {
            // Class doesn't have getChildren method, skip
        }
        return "";
    }

    private String generateBorderPaneMethods() {
        BorderPaneMethodModel model = BorderPaneMethodModel.create(clazz, builderClassName);
        TemplateOutput output = new StringOutput();
        templateEngine.render("borderpane-methods.jte", model, output);
        return output.toString();
    }

    private String generateGridPaneMethods() {
        GridPaneMethodModel model = GridPaneMethodModel.create(builderClassName);
        TemplateOutput output = new StringOutput();
        templateEngine.render("gridpane-methods.jte", model, output);
        return output.toString();
    }

    private void writeToFiles(String content) throws IOException {
        // Create directories and write files to all output locations
        for (String outputDirPath : outputDir) {
            Path outputDir = Paths.get(outputDirPath);
            Files.createDirectories(outputDir);

            Path outputFile = outputDir.resolve(builderClassName + ".java");
            Files.write(outputFile, content.getBytes());
        }
    }

}