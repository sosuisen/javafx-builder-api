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
    content.append("    private ").append(className).append(" instance;\n");
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

    // Generate build method based on whether we have default constructor
    if (hasDefaultConstructor) {
      // Has default constructor - include fallback
      content.append("    public ").append(className).append(" build() {\n");
      content.append("        if (instance == null) {\n");
      content.append("            if (constructorArgs == null && mandatoryParams == null) {\n");
      content.append("                instance = new ").append(className).append("();\n");
      content.append("            } else {\n");
      content.append("                // Use reflection for parameterized constructor\n");
      content.append("                try {\n");
      content.append("                    Object[] args = (constructorArgs != null) ? constructorArgs : mandatoryParams;\n");
      content.append("                    java.lang.reflect.Constructor<?>[] constructors = ").append(className).append(".class.getConstructors();\n");
      content.append("                    for (java.lang.reflect.Constructor<?> constructor : constructors) {\n");
      content.append("                        if (constructor.getParameterCount() == args.length) {\n");
      content.append("                            instance = (").append(className).append(") constructor.newInstance(args);\n");
      content.append("                            break;\n");
      content.append("                        }\n");
      content.append("                    }\n");
      content.append("                    if (instance == null) {\n");
      content.append("                        throw new RuntimeException(\"No suitable constructor found\");\n");
      content.append("                    }\n");
      content.append("                } catch (Exception e) {\n");
      content.append("                    throw new RuntimeException(\"Failed to create instance\", e);\n");
      content.append("                }\n");
      content.append("            }\n");
      content.append("            for (java.util.function.Consumer<").append(className).append("> op : operations) {\n");
      content.append("                op.accept(instance);\n");
      content.append("            }\n");
      content.append("        }\n");
      content.append("        return instance;\n");
      content.append("    }\n");
    } else {
      // No default constructor - only use parameters
      content.append("    public ").append(className).append(" build() {\n");
      content.append("        if (instance == null) {\n");
      content.append("            // Use reflection for parameterized constructor\n");
      content.append("            try {\n");
      content.append("                Object[] args = (constructorArgs != null) ? constructorArgs : mandatoryParams;\n");
      content.append("                java.lang.reflect.Constructor<?>[] constructors = ").append(className).append(".class.getConstructors();\n");
      content.append("                for (java.lang.reflect.Constructor<?> constructor : constructors) {\n");
      content.append("                    if (constructor.getParameterCount() == args.length) {\n");
      content.append("                        instance = (").append(className).append(") constructor.newInstance(args);\n");
      content.append("                        break;\n");
      content.append("                    }\n");
      content.append("                }\n");
      content.append("                if (instance == null) {\n");
      content.append("                    throw new RuntimeException(\"No suitable constructor found\");\n");
      content.append("                }\n");
      content.append("            } catch (Exception e) {\n");
      content.append("                throw new RuntimeException(\"Failed to create instance\", e);\n");
      content.append("            }\n");
      content.append("            for (java.util.function.Consumer<").append(className).append("> op : operations) {\n");
      content.append("                op.accept(instance);\n");
      content.append("            }\n");
      content.append("        }\n");
      content.append("        return instance;\n");
      content.append("    }\n");
    }
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
    // Extract base type (without generics)
    String baseType = paramType.replaceAll("<.*?>", "");

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

}