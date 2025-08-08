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
        StringBuilder content = new StringBuilder();

        // Output package and imports
        content.append("package ").append(packageName).append(";\n");
        content.append("\n");

        // Class declaration and fields with generic support
        content.append("public class ").append(builderClassName).append(typeParameters).append(" {\n");
        content.append("    private Object[] constructorArgs;\n");
        content.append("    private Object[] mandatoryParams;\n");
        content.append("    private java.util.List<java.util.function.Consumer<").append(classNameWithTypeParameter)
                .append(">> operations = new java.util.ArrayList<>();\n");

        return content.toString();
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
                    parseConstructor(constructor, content);
                    break;
                }
            }
        } else {
            // Find common parameters and generate withXXX method
            List<Parameter> commonParams = findCommonParameters(constructors);
            generateWithMethods(commonParams, content);
        }

        // Always generate create(parameters) methods for ALL parameterized constructors
        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterCount() > 0) {
                parseConstructor(constructor, content);
            }
        }

        return content.toString();
    }

    private void parseConstructor(Constructor<?> constructor, StringBuilder content) {
        Parameter[] parameters = constructor.getParameters();

        String parameterList = buildParameterListWithTypes(parameters);
        String argumentList = buildParameterListNamesOnly(parameters);

        if (parameters.length == 0) {
            // Default constructor - just create empty builder
            content.append("    public static ").append(typeParameters.isEmpty() ? "" : typeParameters + " ")
                    .append(builderClassNameWithTypeParameter).append(" create() { return new ")
                    .append(builderClassNameWithTypeParameter).append("(); }\n");
            content.append("    private ").append(builderClassName).append("() {}\n");
        } else {
            // Parameterized constructor - store parameters for delayed initialization
            content.append("    public static ").append(typeParameters.isEmpty() ? "" : typeParameters + " ")
                    .append(builderClassNameWithTypeParameter).append(" create(").append(parameterList)
                    .append(") {\n");
            content.append("        ").append(builderClassNameWithTypeParameter).append(" builder = new ")
                    .append(builderClassNameWithTypeParameter)
                    .append("();\n");
            content.append("        builder.constructorArgs = new Object[]{").append(argumentList).append("};\n");
            content.append("        return builder;\n");
            content.append("    }\n");
        }
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

    private void generateWithMethods(List<Parameter> commonParams, StringBuilder content) {
        if (commonParams.isEmpty()) {
            // No common parameters, generate a basic create method
            content.append("    public static ").append(typeParameters.isEmpty() ? "" : typeParameters + " ")
                    .append(builderClassNameWithTypeParameter).append(" create() { return new ")
                    .append(builderClassNameWithTypeParameter).append("(); }\n");
            content.append("    private ").append(builderClassName).append("() {}\n");
            return;
        }

        // Generate withXXX method
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

        // Generate the withXXX static method
        content.append("    public static ").append(typeParameters.isEmpty() ? "" : typeParameters + " ")
                .append(builderClassNameWithTypeParameter).append(" ").append(methodName).append("(")
                .append(paramList).append(") {\n");
        content.append("        ").append(builderClassNameWithTypeParameter).append(" builder = new ")
                .append(builderClassNameWithTypeParameter)
                .append("();\n");
        content.append("        builder.mandatoryParams = new Object[]{").append(argList).append("};\n");
        content.append("        return builder;\n");
        content.append("    }\n");

        // Generate private constructor
        content.append("    private ").append(builderClassName).append("() {}\n");
    }

    private String generateBuildMethod() {
        BuildMethodModel model = BuildMethodModel.create(clazz, className, classNameWithTypeParameter, typeParameters);
        TemplateOutput output = new StringOutput();
        templateEngine.render("build-method.jte", model, output);
        return output.toString();
    }

    private String generateTypeCompatibilityCheckMethods() {
        StringBuilder content = new StringBuilder();

        content.append("    \n");
        content.append(
                "    private static boolean isConstructorCompatible(java.lang.reflect.Constructor<?> constructor, Object[] args) {\n");
        content.append("        Class<?>[] paramTypes = constructor.getParameterTypes();\n");
        content.append("        if (paramTypes.length != args.length) return false;\n");
        content.append("        \n");
        content.append("        for (int i = 0; i < paramTypes.length; i++) {\n");
        content.append("            if (args[i] != null) {\n");
        content.append("                Class<?> paramType = paramTypes[i];\n");
        content.append("                Class<?> argType = args[i].getClass();\n");
        content.append("                \n");
        content.append("                // Check if argument type is assignable to parameter type\n");
        content.append("                if (!paramType.isAssignableFrom(argType)) {\n");
        content.append("                    // Handle primitive types\n");
        content.append("                    if (paramType.isPrimitive()) {\n");
        content.append("                        if (!isPrimitiveCompatible(paramType, argType)) {\n");
        content.append("                            return false;\n");
        content.append("                        }\n");
        content.append("                    } else if (argType.isPrimitive()) {\n");
        content.append("                        if (!isPrimitiveCompatible(argType, paramType)) {\n");
        content.append("                            return false;\n");
        content.append("                        }\n");
        content.append("                    } else {\n");
        content.append("                        return false;\n");
        content.append("                    }\n");
        content.append("                }\n");
        content.append("            }\n");
        content.append("        }\n");
        content.append("        return true;\n");
        content.append("    }\n");
        content.append("    \n");
        content.append(
                "    private static boolean isPrimitiveCompatible(Class<?> primitiveType, Class<?> wrapperType) {\n");
        content.append("        if (primitiveType == boolean.class) return wrapperType == Boolean.class;\n");
        content.append("        if (primitiveType == byte.class) return wrapperType == Byte.class;\n");
        content.append("        if (primitiveType == char.class) return wrapperType == Character.class;\n");
        content.append("        if (primitiveType == short.class) return wrapperType == Short.class;\n");
        content.append("        if (primitiveType == int.class) return wrapperType == Integer.class;\n");
        content.append("        if (primitiveType == long.class) return wrapperType == Long.class;\n");
        content.append("        if (primitiveType == float.class) return wrapperType == Float.class;\n");
        content.append("        if (primitiveType == double.class) return wrapperType == Double.class;\n");
        content.append("        return false;\n");
        content.append("    }\n");

        return content.toString();
    }

    private String generateApplyMethod() {
        StringBuilder content = new StringBuilder();

        content.append("    \n");
        content.append("    public ").append(builderClassNameWithTypeParameter)
                .append(" apply(java.util.function.Consumer<")
                .append(classNameWithTypeParameter).append("> func) {\n");
        content.append("        operations.add(func);\n");
        content.append("        return this;\n");
        content.append("    }\n");

        return content.toString();
    }

    private String generateSetterMethods() {
        StringBuilder content = new StringBuilder();
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            if (method.getName().startsWith("set") && !java.lang.reflect.Modifier.isStatic(method.getModifiers())) {
                parseSetter(method, content);
            }
        }

        return content.toString();
    }

    private void parseSetter(Method method, StringBuilder content) {
        String methodName = method.getName().substring(3);
        methodName = Character.toLowerCase(methodName.charAt(0)) + methodName.substring(1);

        Parameter[] parameters = method.getParameters();
        String parameterList = buildParameterListWithTypes(parameters);
        String argumentList = buildParameterListNamesOnly(parameters);

        content.append("    public  ").append(builderClassNameWithTypeParameter).append(" ").append(methodName)
                .append("(")
                .append(parameterList).append(") {\n");
        content.append("        operations.add(obj -> obj.").append(method.getName()).append("(").append(argumentList)
                .append("));\n");
        content.append("        return this;\n");
        content.append("    }\n");
    }

    private String generateSpecialMethods() {
        StringBuilder content = new StringBuilder();

        // Generate styleClass method for Node-based classes
        generateStyleClassMethod(content);

        // Check for getChildren method and generate children method
        generateChildrenMethod(content);

        // Generate BorderPane specific static methods
        generateBorderPaneMethods(content);

        return content.toString();
    }

    private void generateStyleClassMethod(StringBuilder content) {
        // Check if the class has getStyleClass method (inherits from Node)
        try {
            Method getStyleClassMethod = clazz.getMethod("getStyleClass");
            if (getStyleClassMethod != null
                    && getStyleClassMethod.getReturnType().getName().contains("ObservableList")) {
                content.append("    public  ").append(builderClassNameWithTypeParameter)
                        .append(" styleClass(String... cssClassNames) {\n");
                content.append("        operations.add(obj -> \n");
                content.append("            java.util.Arrays.stream(cssClassNames)\n");
                content.append("                  .forEach(obj.getStyleClass()::add)\n");
                content.append("        );\n");
                content.append("        return this;\n");
                content.append("    }\n");
            }
        } catch (NoSuchMethodException e) {
            // Class doesn't have getStyleClass method, skip generation
        }
    }

    private void generateChildrenMethod(StringBuilder content) {
        // Check if the class has a getChildren method
        try {
            Method getChildrenMethod = clazz.getMethod("getChildren");
            // Verify that getChildren returns ObservableList<Node>
            if (getChildrenMethod.getReturnType().getCanonicalName().equals("javafx.collections.ObservableList")) {
                // Instance method: children()
                content.append("    public  ").append(builderClassName)
                        .append(" children(javafx.scene.Node... elements) {\n");
                content.append("        operations.add(obj -> {\n");
                content.append("            if (elements == null) {\n");
                content.append("                obj.getChildren().clear();\n");
                content.append("            } else {\n");
                content.append(
                        "                java.util.List<javafx.scene.Node> validChildren = java.util.Arrays.stream(elements)\n");
                content.append("                    .filter(java.util.Objects::nonNull)\n");
                content.append("                    .collect(java.util.stream.Collectors.toList());\n");
                content.append("                obj.getChildren().setAll(validChildren);\n");
                content.append("            }\n");
                content.append("        });\n");
                content.append("        return this;\n");
                content.append("    }\n");
                content.append("\n");

                // Static method: withChildren() - returns builder, not built object
                content.append("    public static ").append(builderClassName)
                        .append(" withChildren(javafx.scene.Node... elements) {\n");
                content.append("        ").append(builderClassName).append(" builder = new ").append(builderClassName)
                        .append("();\n");
                content.append("        return builder.children(elements);\n");
                content.append("    }\n");
            }
        } catch (NoSuchMethodException e) {
            // Class doesn't have getChildren method, skip
        }
    }

    private void generateBorderPaneMethods(StringBuilder content) {
        // Check if the class is BorderPane
        if (!"BorderPane".equals(clazz.getSimpleName())) {
            return;
        }

        // Generate static methods for BorderPane positioning
        String[] positions = { "center", "top", "left", "bottom", "right" };
        for (String position : positions) {
            String capitalizedPosition = Character.toUpperCase(position.charAt(0)) + position.substring(1);

            content.append("    public static ").append(builderClassName)
                    .append(" with").append(capitalizedPosition).append("(javafx.scene.Node node) {\n");
            content.append("        ").append(builderClassName).append(" builder = new ")
                    .append(builderClassName).append("();\n");
            content.append("        builder.operations.add(obj -> obj.set").append(capitalizedPosition)
                    .append("(node));\n");
            content.append("        return builder;\n");
            content.append("    }\n\n");
        }
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