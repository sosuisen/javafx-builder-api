package io.github.sosuisen;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.sosuisen.extractor.ParameterInfo;
import io.github.sosuisen.extractor.StaticSetterInfo;
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
import io.github.sosuisen.template.ItemsMethodModel;
import io.github.sosuisen.template.BorderPaneMethodModel;
import io.github.sosuisen.template.StyleClassMethodModel;
import io.github.sosuisen.template.SetterMethodModel;
import io.github.sosuisen.template.ApplyMethodModel;
import io.github.sosuisen.template.CreateMethodModel;
import io.github.sosuisen.template.GridPaneMethodModel;
import io.github.sosuisen.template.ClassHeaderModel;
import io.github.sosuisen.template.LayoutConstraintMethodModel;
import io.github.sosuisen.template.PropertyMethodModel;

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
    private final List<StaticSetterInfo> staticSetters;

    public BuilderClassGenerator(String packageName, String[] outputDir, Class<?> clazz,
            List<StaticSetterInfo> staticSetters) {
        this.packageName = packageName;
        this.outputDir = outputDir;
        this.clazz = clazz;
        typeParameters = getTypeParameterString(clazz);
        typeParametersExtends = getTypeParameterExtendsString(clazz);
        className = clazz.getCanonicalName();
        classNameWithTypeParameter = className + typeParameters;
        builderClassName = createBuilderClassName();
        builderClassNameWithTypeParameter = builderClassName + typeParameters;

        this.staticSetters = staticSetters;
    }

    public void generate() throws IOException {
        String content = generateBuilderClass();
        writeToFiles(content);
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

    private String generateBuilderClass() {
        StringBuilder content = new StringBuilder();

        content.append(generateClassHeader());

        if ("Scene".equals(clazz.getSimpleName())) {
            content.append(generateSceneMethods());
        } else {
            content.append(generateCreateMethods());
            content.append(generateBuildMethod());
        }

        content.append(generateApplyMethod());
        content.append(generateSetterMethods());
        content.append(generateSpecialMethods());
        content.append(generateLayoutConstraintMethods());
        content.append(generatePropertyMethods());

        content.append("\n}\n");

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

    private String generateSceneMethods() {
        TemplateOutput output = new StringOutput();
        templateEngine.render("scene-methods.jte", null, output);
        return output.toString();
    }

    private String generateCreateMethods() {
        StringBuilder content = new StringBuilder();
        Constructor<?>[] constructors = clazz.getConstructors();

        for (Constructor<?> constructor : constructors) {
            content.append(generateCreateMethod(constructor));
        }

        return content.toString();
    }

    private String generateCreateMethod(Constructor<?> constructor) {
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

        // Check for getItems method and generate addItems method
        content.append(generateAddItemsMethod());

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

    private String generateAddItemsMethod() {
        try {
            Method getItemsMethod = clazz.getMethod("getItems");
            String returnType = getItemsMethod.getGenericReturnType().getTypeName();
            if (returnType.startsWith("javafx.collections.ObservableList<")) {
                Pattern pattern = Pattern.compile("<(.+)>$");
                Matcher matcher = pattern.matcher(returnType);
                if (matcher.find()) {
                    String observableListTypeParameter = matcher.group(1);
                    ItemsMethodModel model = ItemsMethodModel.create(builderClassName,
                            builderClassNameWithTypeParameter,
                            observableListTypeParameter,
                            typeParametersExtends);
                    TemplateOutput output = new StringOutput();
                    templateEngine.render("items-methods.jte", model, output);
                    return output.toString();
                } else {
                    return "";
                }
            }
        } catch (NoSuchMethodException e) {
            // Class doesn't have getItems method, skip
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

    private String generateLayoutConstraintMethods() {
        // Check if current class inherits from javafx.scene.Node
        if (!isNodeClass()) {
            return "";
        }

        // Create individual methods for each static setter
        List<LayoutConstraintMethodModel.LayoutConstraintMethod> methods = new ArrayList<>();

        for (StaticSetterInfo setterInfo : staticSetters) {
            // Create method name as XXXXIn{SourceClassName}
            String setterName = setterInfo.methodName().substring(3); // Remove "set" prefix
            String sourceClassName = setterInfo.sourceClass().getSimpleName();

            // Apply special naming logic
            String camelCaseSetterName;
            // Special handling for names starting with 'H' or 'V' followed by lowercase
            // e.g., "Halignment" -> "hAlignment", "Vgrow" -> "vGrow"
            if (setterName.length() >= 2 &&
                    (setterName.charAt(0) == 'H' || setterName.charAt(0) == 'V') &&
                    Character.isLowerCase(setterName.charAt(1))) {

                String firstChar = String.valueOf(setterName.charAt(0)).toLowerCase();
                String secondChar = String.valueOf(setterName.charAt(1)).toUpperCase();
                String remainder = setterName.substring(2);
                camelCaseSetterName = firstChar + secondChar + remainder;
            } else {
                // Standard case: just lowercase the first character
                String firstChar = String.valueOf(setterName.charAt(0)).toLowerCase();
                String remainder = setterName.substring(1);
                camelCaseSetterName = firstChar + remainder;
            }

            String methodName = camelCaseSetterName + "In" + sourceClassName;

            // Filter out Node parameters and create parameter list
            var filteredParams = ParameterInfo.filterNodeParameters(setterInfo.parameters());
            String parameterList = ParameterInfo.buildParameterList(filteredParams, className);
            String argumentList = ParameterInfo.buildArgumentList(filteredParams);

            // Create single StaticCall for this setter
            LayoutConstraintMethodModel.StaticCall staticCall = new LayoutConstraintMethodModel.StaticCall(
                    setterInfo.sourceClass().getName(),
                    setterInfo.methodName(),
                    argumentList);

            methods.add(new LayoutConstraintMethodModel.LayoutConstraintMethod(
                    methodName,
                    parameterList,
                    staticCall));
        }

        if (methods.isEmpty()) {
            return "";
        }

        LayoutConstraintMethodModel model = LayoutConstraintMethodModel.create(
                builderClassNameWithTypeParameter,
                methods);

        TemplateOutput output = new StringOutput();
        templateEngine.render("layout-constraint-methods.jte", model, output);
        return output.toString();
    }

    private boolean isNodeClass() {
        try {
            Class<?> nodeClass = Class.forName("javafx.scene.Node");
            return nodeClass.isAssignableFrom(clazz);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private String generatePropertyMethods() {
        StringBuilder content = new StringBuilder();
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            if (method.getName().endsWith("Property") && !java.lang.reflect.Modifier.isStatic(method.getModifiers())
                    && method.getParameterCount() == 0) {

                String propertyName = method.getName(); // e.g., "textProperty"
                String methodBaseName = propertyName.substring(0, propertyName.length() - 8); // Remove "Property",
                                                                                              // e.g., "text"
                String methodName = methodBaseName + "PropertyApply"; // e.g., "textPropertyApply"

                // Get the return type of the property method with generics (e.g.,
                // StringProperty, ObservableList<Node>)
                String propertyType = method.getGenericReturnType().getTypeName().replace("$", ".");
                // Check for type replacement
                propertyType = TypeMappingManager.getReplacement(className, propertyType);

                String methodAnnotation = MethodAnnotationManager.getMethodAnnotation(className, propertyName);
                PropertyMethodModel model = PropertyMethodModel.create(
                        builderClassNameWithTypeParameter,
                        methodName,
                        propertyName,
                        propertyType,
                        methodAnnotation);

                TemplateOutput output = new StringOutput();
                templateEngine.render("property-method.jte", model, output);

                content.append(output.toString());
            }
        }

        return content.toString();
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