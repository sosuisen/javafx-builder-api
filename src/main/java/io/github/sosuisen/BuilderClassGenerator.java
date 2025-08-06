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

public class BuilderClassGenerator {

  private static final String PACKAGE_NAME = "io.github.sosuisen.jfxbuilder";
  private static final String[] OUTPUT_DIRS = {
    "target/builder-classes/io/github/sosuisen/jfxbuilder",
    "src/main/java/io/github/sosuisen/jfxbuilder"
  };

  public void generate(Class<?> clazz) throws IOException {
    Set<String> imports = collectImports(clazz);
    String className = clazz.getSimpleName();
    String builderClassName = className + "Builder";
    
    StringBuilder content = new StringBuilder();

    // Output package and imports
    content.append("package ").append(PACKAGE_NAME).append(";\n");
    for (String importLine : imports) {
      content.append("import ").append(importLine).append(";\n");
    }
    content.append("\n");

    content.append("public class ").append(builderClassName).append(" {\n");
    content.append("    private Object[] constructorArgs;\n");
    content.append("    private Object[] mandatoryParams;\n");
    content.append("    private java.util.List<java.util.function.Consumer<").append(className).append(">> operations = new java.util.ArrayList<>();\n");

    // Generate constructors
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
      java.util.List<Parameter> commonParams = findCommonParameters(constructors);
      generateWithMethods(commonParams, clazz, content);
    }
    
    // Always generate create(parameters) methods for ALL parameterized constructors
    for (Constructor<?> constructor : constructors) {
      if (constructor.getParameterCount() > 0) {
        parseConstructor(constructor, clazz, content);
      }
    }

    // Generate build method - always create new instance
    content.append("    public ").append(className).append(" build() {\n");
    content.append("        ").append(className).append(" newInstance;\n");
    if (hasDefaultConstructor) {
      content.append("        if (constructorArgs == null && mandatoryParams == null) {\n");
      content.append("            newInstance = new ").append(className).append("();\n");
      content.append("        } else {\n");
      content.append("            // Use reflection for parameterized constructor\n");
      content.append("            try {\n");
      content.append("                Object[] args = (constructorArgs != null) ? constructorArgs : mandatoryParams;\n");
      content.append("                java.lang.reflect.Constructor<?>[] constructors = ").append(className).append(".class.getConstructors();\n");
      content.append("                newInstance = null;\n");
      content.append("                for (java.lang.reflect.Constructor<?> constructor : constructors) {\n");
      content.append("                    if (constructor.getParameterCount() == args.length && isConstructorCompatible(constructor, args)) {\n");
      content.append("                        newInstance = (").append(className).append(") constructor.newInstance(args);\n");
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
      content.append("            Object[] args = (constructorArgs != null) ? constructorArgs : mandatoryParams;\n");
      content.append("            java.lang.reflect.Constructor<?>[] constructors = ").append(className).append(".class.getConstructors();\n");
      content.append("            newInstance = null;\n");
      content.append("            for (java.lang.reflect.Constructor<?> constructor : constructors) {\n");
      content.append("                if (constructor.getParameterCount() == args.length && isConstructorCompatible(constructor, args)) {\n");
      content.append("                    newInstance = (").append(className).append(") constructor.newInstance(args);\n");
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
    content.append("        for (java.util.function.Consumer<").append(className).append("> op : operations) {\n");
    content.append("            op.accept(newInstance);\n");
    content.append("        }\n");
    content.append("        return newInstance;\n");
    content.append("    }\n");
    content.append("    \n");
    content.append("    private static boolean isConstructorCompatible(java.lang.reflect.Constructor<?> constructor, Object[] args) {\n");
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
    content.append("    private static boolean isPrimitiveCompatible(Class<?> primitiveType, Class<?> wrapperType) {\n");
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
    content.append("    \n");
    content.append("    public ").append(builderClassName).append(" apply(java.util.function.Consumer<").append(className).append("> func) {\n");
    content.append("        operations.add(func);\n");
    content.append("        return this;\n");
    content.append("    }\n");

    Method[] methods = clazz.getMethods();    
    for (Method method : methods) {
      if (method.getName().startsWith("set")) {
        parseSetter(method, clazz, content);
      }
    }

    // Generate styleClass method for Node-based classes
    generateStyleClassMethod(clazz, content);

    // Check for getChildren method and generate children method
    generateChildrenMethod(clazz, content);

    content.append("}\n");
    
    // Create directories and write files to all output locations
    for (String outputDirPath : OUTPUT_DIRS) {
      Path outputDir = Paths.get(outputDirPath);
      Files.createDirectories(outputDir);
      
      Path outputFile = outputDir.resolve(builderClassName + ".java");
      Files.write(outputFile, content.toString().getBytes());
      
      System.out.println("Generated " + builderClassName + ".java at " + outputFile);
    }
  }

  private String buildParameterListWithTypes(Parameter[] parameters) {
    StringBuilder paramList = new StringBuilder();
    for (int i = 0; i < parameters.length; i++) {
      Parameter param = parameters[i];
      String paramType = param.getParameterizedType().getTypeName();
      paramType = paramType.replaceAll("java\\.lang\\.", "");
      paramType = paramType.replaceAll("javafx\\.[a-z.]+\\.", "");
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

  private Set<String> collectImports(Class<?> clazz) {
    Set<String> imports = new TreeSet<>();

    // Collect all parameter types from setter methods
    Method[] methods = clazz.getMethods();
    for (Method method : methods) {
      if (method.getName().startsWith("set")) {
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
    String baseType = paramType.replaceAll("<.*?>", "").replaceAll("\\[\\]", "");

    // Skip primitive types and java.lang types
    if (baseType.contains(".") &&
        !baseType.startsWith("java.lang.") &&
        !baseType.equals("boolean") &&
        !baseType.equals("int") &&
        !baseType.equals("double") &&
        !baseType.equals("float") &&
        !baseType.equals("long")) {
      imports.add(baseType);
    }
    
    // Extract generic parameter types (e.g., ActionEvent from EventHandler<ActionEvent>)
    java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("<([^<>]+)>");
    java.util.regex.Matcher matcher = pattern.matcher(paramType);
    while (matcher.find()) {
      String genericType = matcher.group(1);
      // Handle nested generics like "? super MouseEvent"
      if (genericType.contains("super ")) {
        genericType = genericType.replace("? super ", "");
      }
      if (genericType.contains("extends ")) {
        genericType = genericType.replace("? extends ", "");
      }
      // Remove array brackets from generic types as well
      genericType = genericType.replaceAll("\\[\\]", "");
      if (genericType.contains(".") && 
          !genericType.startsWith("java.lang.") &&
          !genericType.equals("?")) {
        imports.add(genericType.trim());
      }
    }
  }

  private void parseConstructor(Constructor<?> constructor, Class<?> clazz, StringBuilder content) {
    String className = clazz.getSimpleName();
    String builderClassName = className + "Builder";
    Parameter[] parameters = constructor.getParameters();

    String parameterList = buildParameterListWithTypes(parameters);
    String argumentList = buildParameterListNamesOnly(parameters);

    if (parameters.length == 0) {
      // Default constructor - just create empty builder
      content.append("    public static  ").append(builderClassName).append(" create() { return new ").append(builderClassName).append("(); }\n");
      content.append("    private ").append(builderClassName).append("() {}\n");
    } else {
      // Parameterized constructor - store parameters for delayed initialization
      content.append("    public static  ").append(builderClassName).append(" create(").append(parameterList).append(") {\n");
      content.append("        ").append(builderClassName).append(" builder = new ").append(builderClassName).append("();\n");
      content.append("        builder.constructorArgs = new Object[]{").append(argumentList).append("};\n");
      content.append("        return builder;\n");
      content.append("    }\n");
    }
  }

  private java.util.List<Parameter> findCommonParameters(Constructor<?>[] constructors) {
    if (constructors.length == 0) return new java.util.ArrayList<>();
    
    // Start with parameters from first constructor
    java.util.List<Parameter> common = new java.util.ArrayList<>();
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

  private void generateWithMethods(java.util.List<Parameter> commonParams, Class<?> clazz, StringBuilder content) {
    if (commonParams.isEmpty()) {
      // No common parameters, generate a basic create method
      content.append("    public static  ").append(clazz.getSimpleName()).append("Builder create() { return new ").append(clazz.getSimpleName()).append("Builder(); }\n");
      content.append("    private ").append(clazz.getSimpleName()).append("Builder() {}\n");
      return;
    }
    
    String builderClassName = clazz.getSimpleName() + "Builder";
    
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
    content.append("    public static  ").append(builderClassName).append(" ").append(methodName).append("(").append(paramList).append(") {\n");
    content.append("        ").append(builderClassName).append(" builder = new ").append(builderClassName).append("();\n");
    content.append("        builder.mandatoryParams = new Object[]{").append(argList).append("};\n");
    content.append("        return builder;\n");
    content.append("    }\n");
    
    // Generate private constructor
    content.append("    private ").append(builderClassName).append("() {}\n");
  }

  private void parseSetter(Method method, Class<?> clazz, StringBuilder content) {
    String className = clazz.getSimpleName();
    String builderClassName = className + "Builder";
    String methodName = method.getName().substring(3);
    methodName = Character.toLowerCase(methodName.charAt(0)) + methodName.substring(1);

    Parameter[] parameters = method.getParameters();
    String parameterList = buildParameterListWithTypes(parameters);
    String argumentList = buildParameterListNamesOnly(parameters);

    content.append("    public  ").append(builderClassName).append(" ").append(methodName).append("(").append(parameterList).append(") {\n");
    content.append("        operations.add(obj -> obj.").append(method.getName()).append("(").append(argumentList).append("));\n");
    content.append("        return this;\n");
    content.append("    }\n");
  }

  
  private void generateStyleClassMethod(Class<?> clazz, StringBuilder content) {
    String className = clazz.getSimpleName();
    String builderClassName = className + "Builder";
    
    // Check if the class has getStyleClass method (inherits from Node)
    try {
      Method getStyleClassMethod = clazz.getMethod("getStyleClass");
      if (getStyleClassMethod != null && getStyleClassMethod.getReturnType().getName().contains("ObservableList")) {
        content.append("    public  ").append(builderClassName).append(" styleClass(String... cssClassNames) {\n");
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
        content.append("    public  ").append(builderClassName).append(" children(javafx.scene.Node... elements) {\n");
        content.append("        operations.add(obj -> {\n");
        content.append("            if (elements == null) {\n");
        content.append("                obj.getChildren().clear();\n");
        content.append("            } else {\n");
        content.append("                java.util.List<javafx.scene.Node> validChildren = java.util.Arrays.stream(elements)\n");
        content.append("                    .filter(java.util.Objects::nonNull)\n");
        content.append("                    .collect(java.util.stream.Collectors.toList());\n");
        content.append("                obj.getChildren().setAll(validChildren);\n");
        content.append("            }\n");
        content.append("        });\n");
        content.append("        return this;\n");
        content.append("    }\n");
        content.append("\n");
        
        // Static method: withChildren() - returns builder, not built object
        content.append("    public static ").append(builderClassName).append(" withChildren(javafx.scene.Node... elements) {\n");
        content.append("        ").append(builderClassName).append(" builder = new ").append(builderClassName).append("();\n");
        content.append("        return builder.children(elements);\n");
        content.append("    }\n");
      }
    } catch (NoSuchMethodException e) {
      // Class doesn't have getChildren method, skip
    }
  }

}