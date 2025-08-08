package io.github.sosuisen;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
import io.github.sosuisen.template.WithMethodModel;
import io.github.sosuisen.template.ConstructorMethodModel;
import io.github.sosuisen.template.ClassHeaderModel;

public class BuilderClassGenerator {
    private static final TemplateEngine templateEngine = initializeTemplateEngine();

    private final String packageName;
    private final String[] outputDir;
    private final Class<?> clazz;
    private final String typeParameters;
    private final String className;
    private final String classNameWithTypeParameter;
    private final String builderClassName;
    private final String builderClassNameWithTypeParameter;

    public BuilderClassGenerator(String packageName, String[] outputDir, Class<?> clazz) {
        this.packageName = packageName;
        this.outputDir = outputDir;
        this.clazz = clazz;
        typeParameters = getTypeParameterString(clazz);
        className = clazz.getCanonicalName();
        classNameWithTypeParameter = className + typeParameters;
        builderClassName = clazz.getSimpleName() + "Builder";
        builderClassNameWithTypeParameter = clazz.getSimpleName() + "Builder" + typeParameters;
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
        ClassHeaderModel model = ClassHeaderModel.create(
            packageName,
            builderClassName,
            typeParameters,
            classNameWithTypeParameter
        );
        
        TemplateOutput output = new StringOutput();
        templateEngine.render("class-header.jte", model, output);
        return output.toString();
    }

    private String generateConstructors() {
        StringBuilder content = new StringBuilder();
        Constructor<?>[] constructors = clazz.getConstructors();
        boolean hasDefaultConstructor = false;

        // Check if there's a default constructor (no parameters)
        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterCount() == 0) {
                hasDefaultConstructor = true;
                break;
            }
        }

        // Generate constructors
        if (hasDefaultConstructor) {
            // Generate default constructor first
            for (Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == 0) {
                    content.append(generateCreateMethods(constructor));
                    break;
                }
            }
        } else {
            // Find common parameters and generate withXXX method
            List<Parameter> commonParams = findCommonParameters(constructors);
            content.append(generateWithMethods(commonParams));
        }

        // Always generate create(parameters) methods for ALL parameterized constructors
        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterCount() > 0) {
                content.append(generateCreateMethods(constructor));
            }
        }

        return content.toString();
    }

    private String generateCreateMethods(Constructor<?> constructor) {
        Parameter[] parameters = constructor.getParameters();

        ConstructorMethodModel model;

        if (parameters.length == 0) {
            model = ConstructorMethodModel.createDefault(
                    typeParameters,
                    builderClassNameWithTypeParameter,
                    builderClassName);
        } else {
            String parameterList = buildParameterListWithTypes(parameters);
            String argumentList = buildParameterListNamesOnly(parameters);

            model = ConstructorMethodModel.createParameterized(
                    typeParameters,
                    builderClassNameWithTypeParameter,
                    builderClassName,
                    parameterList,
                    argumentList);
        }

        TemplateOutput output = new StringOutput();
        templateEngine.render("create-method.jte", model, output);
        return output.toString();
    }

    private String buildParameterListWithTypes(Parameter[] parameters) {
        StringBuilder paramList = new StringBuilder();
        for (int i = 0; i < parameters.length; i++) {
            Parameter param = parameters[i];
            String paramType = param.getParameterizedType().getTypeName();
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

    private List<Parameter> findCommonParameters(Constructor<?>[] constructors) {
        if (constructors.length == 0)
            return new ArrayList<>();

        // Start with parameters from first constructor
        List<Parameter> common = new ArrayList<>();
        Constructor<?> firstConstructor = constructors[0];

        // Find shortest constructor to determine maximum possible common parameters
        int minParams = constructors[0].getParameterCount();
        for (Constructor<?> constructor : constructors) {
            minParams = Math.min(minParams, constructor.getParameterCount());
        }

        // Check each position up to minParams
        for (int pos = 0; pos < minParams; pos++) {
            Parameter candidate = firstConstructor.getParameters()[pos];
            boolean isCommon = true;

            // Check if this parameter position has same type across all constructors
            for (Constructor<?> constructor : constructors) {
                Parameter[] params = constructor.getParameters();
                if (pos >= params.length || !params[pos].getType().equals(candidate.getType())) {
                    isCommon = false;
                    break;
                }
            }

            if (isCommon) {
                common.add(candidate);
            } else {
                break; // Stop at first non-common parameter
            }
        }

        return common;
    }

    private String generateWithMethods(List<Parameter> commonParams) {
        WithMethodModel model;

        if (commonParams.isEmpty()) {
            model = WithMethodModel.createEmpty(typeParameters, builderClassNameWithTypeParameter, builderClassName);
        } else {
            // Generate withXXX method name and parameters
            StringBuilder methodName = new StringBuilder("with");
            StringBuilder paramList = new StringBuilder();
            StringBuilder argList = new StringBuilder();

            for (int i = 0; i < commonParams.size(); i++) {
                Parameter param = commonParams.get(i);
                String paramName = param.getName();
                String typeName = param.getType().getCanonicalName();

                // Capitalize first letter for method name
                String capitalizedName = Character.toUpperCase(paramName.charAt(0)) + paramName.substring(1);
                methodName.append(capitalizedName);
                if (i < commonParams.size() - 1) {
                    methodName.append("And");
                }

                // Build parameter list
                paramList.append(typeName).append(" ").append(paramName);
                argList.append(paramName);
                if (i < commonParams.size() - 1) {
                    paramList.append(", ");
                    argList.append(", ");
                }
            }

            model = WithMethodModel.create(
                    typeParameters,
                    builderClassNameWithTypeParameter,
                    builderClassName,
                    methodName.toString(),
                    paramList.toString(),
                    argList.toString());
        }

        TemplateOutput output = new StringOutput();
        templateEngine.render("with-methods.jte", model, output);
        return output.toString();
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
                content.append(parseSetter(method));
            }
        }

        return content.toString();
    }

    private String parseSetter(Method method) {
        String methodName = method.getName().substring(3);
        methodName = Character.toLowerCase(methodName.charAt(0)) + methodName.substring(1);

        Parameter[] parameters = method.getParameters();
        String parameterList = buildParameterListWithTypes(parameters);
        String argumentList = buildParameterListNamesOnly(parameters);

        SetterMethodModel model = SetterMethodModel.create(
                builderClassNameWithTypeParameter,
                methodName,
                parameterList,
                argumentList,
                method.getName());

        TemplateOutput output = new StringOutput();
        templateEngine.render("setter-method.jte", model, output);
        return output.toString();
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
            if (getChildrenMethod.getReturnType().getCanonicalName().equals("javafx.collections.ObservableList")) {
                ChildrenMethodModel model = ChildrenMethodModel.create(builderClassName,
                        builderClassNameWithTypeParameter);
                TemplateOutput output = new StringOutput();
                templateEngine.render("children-methods.jte", model, output);
                return output.toString();
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