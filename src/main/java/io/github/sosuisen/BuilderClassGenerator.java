package io.github.sosuisen;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;

public class BuilderClassGenerator {
    private final String packageName;
    private final String[] outputDir;

    public BuilderClassGenerator(String packageName, String[] outputDir) {
        this.packageName = packageName;
        this.outputDir = outputDir;
    }

    public void generate(Class<?> clazz) throws IOException {
        String content = generateBuilderClass(clazz);
        writeToFiles(content, clazz.getSimpleName() + "Builder");
    }

    private String generateBuilderClass(Class<?> clazz) {
        StringBuilder content = new StringBuilder();

        content.append(generateClassHeader(clazz));
        content.append(generateConstructors(clazz));
        content.append(generateBuildMethod(clazz));
        content.append(generateTypeCompatibilityCheckMethods());
        content.append(generateApplyMethod(clazz));
        content.append(generateSetterMethods(clazz));
        content.append(generateSpecialMethods(clazz));
        content.append("}\n");

        return content.toString();
    }

    private String generateClassHeader(Class<?> clazz) {
        Set<String> imports = collectImports(clazz);

        String className = clazz.getSimpleName();
        String builderClassName = className + "Builder";
        String genericParameters = getGenericParameters(clazz);
        String classNameWithGenerics = className + genericParameters;

        StringBuilder content = new StringBuilder();

        // Output package and imports
        content.append("package ").append(packageName).append(";\n");
        for (String importLine : imports) {
            content.append("import ").append(importLine).append(";\n");
        }
        content.append("\n");

        // Class declaration and fields with generic support
        content.append("public class ").append(builderClassName).append(genericParameters).append(" {\n");
        content.append("    private Object[] constructorArgs;\n");
        content.append("    private Object[] mandatoryParams;\n");
        content.append("    private java.util.List<java.util.function.Consumer<").append(classNameWithGenerics)
                .append(">> operations = new java.util.ArrayList<>();\n");

        return content.toString();
    }

    private String getGenericParameters(Class<?> clazz) {
        if (clazz.getTypeParameters().length == 0) {
            return "";
        }

        StringBuilder genericBuilder = new StringBuilder("<");
        for (int i = 0; i < clazz.getTypeParameters().length; i++) {
            if (i > 0)
                genericBuilder.append(", ");
            genericBuilder.append(clazz.getTypeParameters()[i].getName());
        }
        genericBuilder.append(">");
        return genericBuilder.toString();
    }

    private Set<String> collectImports(Class<?> clazz) {
        Set<String> imports = new TreeSet<>();

        // Collect all parameter types from non-static setter methods
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("set") && !java.lang.reflect.Modifier.isStatic(method.getModifiers())) {
                Parameter[] parameters = method.getParameters();
                for (Parameter param : parameters) {
                    String paramType = param.getParameterizedType().getTypeName();
                    addImportIfNeeded(imports, paramType);
                }
            }
        }

        // Collect parameter types from constructors
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            Parameter[] parameters = constructor.getParameters();
            for (Parameter param : parameters) {
                String paramType = param.getParameterizedType().getTypeName();
                addImportIfNeeded(imports, paramType);
            }
        }

        // Add required imports for constructors and method types
        imports.add(clazz.getName());

        return imports;
    }

    private void addImportIfNeeded(Set<String> imports, String paramType) {
        // Extract base type (without generics and arrays)
        String baseType = paramType.replaceAll("<.*?>$", "").replaceAll("\\[\\]", "");

        // Convert inner class notation from $ to . for proper import statements
        baseType = baseType.replace("$", ".");

        // Skip primitive types, java.lang types, and empty/invalid types
        if (baseType.contains(".") &&
                !baseType.startsWith("java.lang.") &&
                !baseType.equals("boolean") &&
                !baseType.equals("int") &&
                !baseType.equals("double") &&
                !baseType.equals("float") &&
                !baseType.equals("long") &&
                !baseType.isEmpty() &&
                isValidClassName(baseType)) {
            imports.add(baseType);
        }

        // Extract generic parameter types with proper handling of nested generics
        extractGenericTypes(paramType, imports);
    }

    private boolean isValidClassName(String className) {
        // Check if the string is a valid Java class name
        if (className == null || className.isEmpty()) {
            return false;
        }

        // Should not contain invalid characters for import statements
        if (className.contains(",") || className.contains("<") || className.contains(">") || className.contains("$")) {
            return false;
        }

        // Should contain at least one dot (package separator)
        return className.contains(".");
    }

    private void extractGenericTypes(String paramType, Set<String> imports) {
        int start = paramType.indexOf('<');
        if (start == -1)
            return;

        int depth = 0;
        int genericStart = start + 1;
        for (int i = start; i < paramType.length(); i++) {
            char c = paramType.charAt(i);
            if (c == '<') {
                depth++;
            } else if (c == '>') {
                depth--;
                if (depth == 0) {
                    // Extract the content between the outermost < >
                    String genericContent = paramType.substring(genericStart, i);
                    processGenericContent(genericContent, imports);

                    // Continue searching for more generic sections in the remaining string
                    if (i + 1 < paramType.length()) {
                        String remaining = paramType.substring(i + 1);
                        extractGenericTypes(remaining, imports);
                    }
                    return;
                }
            }
        }
    }

    private void processGenericContent(String genericContent, Set<String> imports) {
        // Split by comma, but respect nested generics
        List<String> types = splitGenericTypes(genericContent);

        for (String type : types) {
            type = type.trim();

            // Handle wildcards like "? super MouseEvent" or "? extends Node"
            if (type.startsWith("? super ")) {
                type = type.substring("? super ".length()).trim();
            } else if (type.startsWith("? extends ")) {
                type = type.substring("? extends ".length()).trim();
            } else if (type.equals("?")) {
                continue; // Skip wildcard without bounds
            }

            // Remove array brackets
            type = type.replaceAll("\\[\\]", "");

            // Extract the base type (without its own generics) for import
            String baseType = type.replaceAll("<.*?>", "");

            // Clean up the base type - remove any remaining angle brackets or invalid
            // characters
            baseType = baseType.replaceAll("[<>]", "").trim();

            // Convert inner class notation from $ to . for proper import statements
            baseType = baseType.replace("$", ".");

            if (baseType.contains(".") &&
                    !baseType.startsWith("java.lang.") &&
                    !baseType.isEmpty() &&
                    isValidClassName(baseType)) {
                imports.add(baseType);
            }

            // Recursively process nested generics
            extractGenericTypes(type, imports);
        }
    }

    private List<String> splitGenericTypes(String genericContent) {
        List<String> types = new ArrayList<>();
        int start = 0;
        int depth = 0;

        for (int i = 0; i < genericContent.length(); i++) {
            char c = genericContent.charAt(i);
            if (c == '<') {
                depth++;
            } else if (c == '>') {
                depth--;
            } else if (c == ',' && depth == 0) {
                types.add(genericContent.substring(start, i));
                start = i + 1;
            }
        }
        types.add(genericContent.substring(start));
        return types;
    }

    private String generateConstructors(Class<?> clazz) {
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
                    parseConstructor(constructor, clazz, content);
                    break;
                }
            }
        } else {
            // Find common parameters and generate withXXX method
            List<Parameter> commonParams = findCommonParameters(constructors);
            generateWithMethods(commonParams, clazz, content);
        }

        // Always generate create(parameters) methods for ALL parameterized constructors
        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterCount() > 0) {
                parseConstructor(constructor, clazz, content);
            }
        }

        return content.toString();
    }

    private void parseConstructor(Constructor<?> constructor, Class<?> clazz, StringBuilder content) {
        String className = clazz.getSimpleName();
        String genericParameters = getGenericParameters(clazz);
        String builderClassName = className + "Builder" + genericParameters;
        Parameter[] parameters = constructor.getParameters();

        String parameterList = buildParameterListWithTypes(parameters);
        String argumentList = buildParameterListNamesOnly(parameters);

        if (parameters.length == 0) {
            // Default constructor - just create empty builder
            content.append("    public static ").append(genericParameters.isEmpty() ? "" : genericParameters + " ")
                    .append(builderClassName).append(" create() { return new ")
                    .append(builderClassName).append("(); }\n");
            content.append("    private ").append(className + "Builder").append("() {}\n");
        } else {
            // Parameterized constructor - store parameters for delayed initialization
            content.append("    public static ").append(genericParameters.isEmpty() ? "" : genericParameters + " ")
                    .append(builderClassName).append(" create(").append(parameterList)
                    .append(") {\n");
            content.append("        ").append(builderClassName).append(" builder = new ").append(builderClassName)
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
            paramType = simplifyParameterType(paramType);
            paramList.append(paramType);
            paramList.append(" ").append(param.getName());
            if (i < parameters.length - 1) {
                paramList.append(", ");
            }
        }
        return paramList.toString();
    }

    private String simplifyParameterType(String paramType) {
        // Convert inner class notation from $ to . for proper type references
        paramType = paramType.replace("$", ".");

        // Find generic start
        int genericStart = paramType.indexOf('<');
        if (genericStart == -1) {
            // No generics, simple case - just simplify the class name
            return simplifyClassName(paramType);
        } else {
            // Has generics, need to process base type and generic parameters separately
            String baseType = paramType.substring(0, genericStart);
            String genericPart = paramType.substring(genericStart);

            // Simplify the base type (without generics)
            String simplifiedBase = simplifyClassName(baseType);

            // Process the generic part recursively
            String simplifiedGeneric = simplifyGenericPart(genericPart);

            return simplifiedBase + simplifiedGeneric;
        }
    }

    private String simplifyClassName(String className) {
        // Remove java.lang package
        className = className.replaceAll("java\\.lang\\.", "");

        // For JavaFX classes, keep the last two parts (Class.InnerClass) but remove the
        // rest
        if (className.contains("javafx.")) {
            // Split by dots and keep meaningful parts
            String[] parts = className.split("\\.");
            if (parts.length > 2) {
                // For inner classes, keep ClassName.InnerClassName
                // For regular classes, just keep ClassName
                String lastPart = parts[parts.length - 1];
                if (parts.length > 1) {
                    String secondLastPart = parts[parts.length - 2];
                    // Check if it looks like an inner class (starts with capital)
                    if (Character.isUpperCase(lastPart.charAt(0)) && Character.isUpperCase(secondLastPart.charAt(0))) {
                        return secondLastPart + "." + lastPart;
                    }
                }
                return lastPart;
            }
        }

        return className;
    }

    private String simplifyGenericPart(String genericPart) {
        if (genericPart.length() <= 2) { // Just "<>"
            return genericPart;
        }

        StringBuilder result = new StringBuilder("<");
        List<String> typeParams = parseGenericParameters(genericPart.substring(1, genericPart.length() - 1));

        for (int i = 0; i < typeParams.size(); i++) {
            if (i > 0) {
                result.append(", ");
            }
            result.append(simplifyParameterType(typeParams.get(i)));
        }

        result.append(">");
        return result.toString();
    }

    private List<String> parseGenericParameters(String genericContent) {
        List<String> params = new ArrayList<>();
        int start = 0;
        int depth = 0;

        for (int i = 0; i < genericContent.length(); i++) {
            char c = genericContent.charAt(i);
            if (c == '<') {
                depth++;
            } else if (c == '>') {
                depth--;
            } else if (c == ',' && depth == 0) {
                // Found a parameter separator at the top level
                String param = genericContent.substring(start, i).trim();
                if (!param.isEmpty()) {
                    params.add(param);
                }
                start = i + 1;
            }
        }

        // Add the last parameter
        String lastParam = genericContent.substring(start).trim();
        if (!lastParam.isEmpty()) {
            params.add(lastParam);
        }

        return params;
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

    private void generateWithMethods(List<Parameter> commonParams, Class<?> clazz, StringBuilder content) {
        String className = clazz.getSimpleName();
        String genericParameters = getGenericParameters(clazz);
        String builderClassName = className + "Builder" + genericParameters;

        if (commonParams.isEmpty()) {
            // No common parameters, generate a basic create method
            content.append("    public static ").append(genericParameters.isEmpty() ? "" : genericParameters + " ")
                    .append(builderClassName).append(" create() { return new ")
                    .append(builderClassName).append("(); }\n");
            content.append("    private ").append(className + "Builder").append("() {}\n");
            return;
        }

        // Generate withXXX method
        StringBuilder methodName = new StringBuilder("with");
        StringBuilder paramList = new StringBuilder();
        StringBuilder argList = new StringBuilder();

        for (int i = 0; i < commonParams.size(); i++) {
            Parameter param = commonParams.get(i);
            String paramName = param.getName();
            String typeName = param.getType().getSimpleName();

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
        content.append("    public static ").append(genericParameters.isEmpty() ? "" : genericParameters + " ")
                .append(builderClassName).append(" ").append(methodName).append("(")
                .append(paramList).append(") {\n");
        content.append("        ").append(builderClassName).append(" builder = new ").append(builderClassName)
                .append("();\n");
        content.append("        builder.mandatoryParams = new Object[]{").append(argList).append("};\n");
        content.append("        return builder;\n");
        content.append("    }\n");

        // Generate private constructor
        content.append("    private ").append(className + "Builder").append("() {}\n");
    }

    private String generateBuildMethod(Class<?> clazz) {
        // Check if there's a default constructor for build method generation
        boolean hasDefaultConstructor = false;
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterCount() == 0) {
                hasDefaultConstructor = true;
                break;
            }
        }

        String className = clazz.getSimpleName();
        String genericParameters = getGenericParameters(clazz);
        String classNameWithGenerics = className + genericParameters;
        StringBuilder content = new StringBuilder();

        // Generate build method - always create new instance
        if (!genericParameters.isEmpty()) {
            content.append("    @SuppressWarnings(\"unchecked\")\n");
        }
        content.append("    public ").append(classNameWithGenerics).append(" build() {\n");
        content.append("        ").append(classNameWithGenerics).append(" newInstance;\n");
        if (hasDefaultConstructor) {
            content.append("        if (constructorArgs == null && mandatoryParams == null) {\n");
            if (genericParameters.isEmpty()) {
                content.append("            newInstance = new ").append(className).append("();\n");
            } else {
                content.append("            newInstance = new ").append(className).append("<>();\n");
            }
            content.append("        } else {\n");
            content.append("            // Use reflection for parameterized constructor\n");
            content.append("            try {\n");
            content.append(
                    "                Object[] args = (constructorArgs != null) ? constructorArgs : mandatoryParams;\n");
            content.append("                java.lang.reflect.Constructor<?>[] constructors = ").append(className)
                    .append(".class.getConstructors();\n");
            content.append("                newInstance = null;\n");
            content.append("                for (java.lang.reflect.Constructor<?> constructor : constructors) {\n");
            content.append(
                    "                    if (constructor.getParameterCount() == args.length && isConstructorCompatible(constructor, args)) {\n");
            content.append("                        newInstance = (").append(classNameWithGenerics)
                    .append(") constructor.newInstance(args);\n");
            content.append("                        break;\n");
            content.append("                    }\n");
            content.append("                }\n");
            content.append("                if (newInstance == null) {\n");
            content.append("                    throw new RuntimeException(\"No suitable constructor found\");\n");
            content.append("                }\n");
            content.append("            } catch (Exception e) {\n");
            content.append("                throw new RuntimeException(\"Failed to create instance\", e);\n");
            content.append("            }\n");
            content.append("        }\n");
        } else {
            content.append("        // Use reflection for parameterized constructor\n");
            content.append("        try {\n");
            content.append(
                    "            Object[] args = (constructorArgs != null) ? constructorArgs : mandatoryParams;\n");
            content.append("            java.lang.reflect.Constructor<?>[] constructors = ").append(className)
                    .append(".class.getConstructors();\n");
            content.append("            newInstance = null;\n");
            content.append("            for (java.lang.reflect.Constructor<?> constructor : constructors) {\n");
            content.append(
                    "                if (constructor.getParameterCount() == args.length && isConstructorCompatible(constructor, args)) {\n");
            content.append("                    newInstance = (").append(classNameWithGenerics)
                    .append(") constructor.newInstance(args);\n");
            content.append("                    break;\n");
            content.append("                }\n");
            content.append("            }\n");
            content.append("            if (newInstance == null) {\n");
            content.append("                throw new RuntimeException(\"No suitable constructor found\");\n");
            content.append("            }\n");
            content.append("        } catch (Exception e) {\n");
            content.append("            throw new RuntimeException(\"Failed to create instance\", e);\n");
            content.append("        }\n");
        }
        content.append("        for (java.util.function.Consumer<").append(classNameWithGenerics)
                .append("> op : operations) {\n");
        content.append("            op.accept(newInstance);\n");
        content.append("        }\n");
        content.append("        return newInstance;\n");
        content.append("    }\n");

        return content.toString();
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

    private String generateApplyMethod(Class<?> clazz) {
        String className = clazz.getSimpleName();
        String genericParameters = getGenericParameters(clazz);
        String builderClassName = className + "Builder" + genericParameters;
        String classNameWithGenerics = className + genericParameters;
        StringBuilder content = new StringBuilder();

        content.append("    \n");
        content.append("    public ").append(builderClassName).append(" apply(java.util.function.Consumer<")
                .append(classNameWithGenerics).append("> func) {\n");
        content.append("        operations.add(func);\n");
        content.append("        return this;\n");
        content.append("    }\n");

        return content.toString();
    }

    private String generateSetterMethods(Class<?> clazz) {
        StringBuilder content = new StringBuilder();
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            if (method.getName().startsWith("set") && !java.lang.reflect.Modifier.isStatic(method.getModifiers())) {
                parseSetter(method, clazz, content);
            }
        }

        return content.toString();
    }

    private void parseSetter(Method method, Class<?> clazz, StringBuilder content) {
        String className = clazz.getSimpleName();
        String genericParameters = getGenericParameters(clazz);
        String builderClassName = className + "Builder" + genericParameters;
        String methodName = method.getName().substring(3);
        methodName = Character.toLowerCase(methodName.charAt(0)) + methodName.substring(1);

        Parameter[] parameters = method.getParameters();
        String parameterList = buildParameterListWithTypes(parameters);
        String argumentList = buildParameterListNamesOnly(parameters);

        content.append("    public  ").append(builderClassName).append(" ").append(methodName).append("(")
                .append(parameterList).append(") {\n");
        content.append("        operations.add(obj -> obj.").append(method.getName()).append("(").append(argumentList)
                .append("));\n");
        content.append("        return this;\n");
        content.append("    }\n");
    }

    private String generateSpecialMethods(Class<?> clazz) {
        StringBuilder content = new StringBuilder();

        // Generate styleClass method for Node-based classes
        generateStyleClassMethod(clazz, content);

        // Check for getChildren method and generate children method
        generateChildrenMethod(clazz, content);

        // Generate BorderPane specific static methods
        generateBorderPaneMethods(clazz, content);

        return content.toString();
    }

    private void generateStyleClassMethod(Class<?> clazz, StringBuilder content) {
        String className = clazz.getSimpleName();
        String genericParameters = getGenericParameters(clazz);
        String builderClassName = className + "Builder" + genericParameters;

        // Check if the class has getStyleClass method (inherits from Node)
        try {
            Method getStyleClassMethod = clazz.getMethod("getStyleClass");
            if (getStyleClassMethod != null
                    && getStyleClassMethod.getReturnType().getName().contains("ObservableList")) {
                content.append("    public  ").append(builderClassName)
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

    private void generateChildrenMethod(Class<?> clazz, StringBuilder content) {
        String className = clazz.getSimpleName();
        String builderClassName = className + "Builder";

        // Check if the class has a getChildren method
        try {
            Method getChildrenMethod = clazz.getMethod("getChildren");
            // Verify that getChildren returns ObservableList<Node>
            if (getChildrenMethod.getReturnType().getName().equals("javafx.collections.ObservableList")) {
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

    private void generateBorderPaneMethods(Class<?> clazz, StringBuilder content) {
        // Check if the class is BorderPane
        if (!"BorderPane".equals(clazz.getSimpleName())) {
            return;
        }

        String builderClassName = clazz.getSimpleName() + "Builder";

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

    private void writeToFiles(String content, String builderClassName) throws IOException {
        // Create directories and write files to all output locations
        for (String outputDirPath : outputDir) {
            Path outputDir = Paths.get(outputDirPath);
            Files.createDirectories(outputDir);

            Path outputFile = outputDir.resolve(builderClassName + ".java");
            Files.write(outputFile, content.getBytes());

            System.out.println("Generated " + builderClassName + ".java at " +
                    outputFile);
        }
    }

}