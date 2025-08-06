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
    content.append("    private ").append(className).append(" in;\n");

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
    
    // If default constructor exists, only generate that one. Otherwise, generate all.
    if (hasDefaultConstructor) {
      for (Constructor<?> constructor : constructors) {
        if (constructor.getParameterCount() == 0) {
          parseConstructor(constructor, clazz, content);
          break;
        }
      }
    } else {
      for (Constructor<?> constructor : constructors) {
        parseConstructor(constructor, clazz, content);
      }
    }

    content.append("    public ").append(className).append(" build() { return in; }\n");
    content.append("    public ").append(builderClassName).append(" apply(java.util.function.Consumer<").append(className).append("> func) {\n");
    content.append("        func.accept((").append(className).append(") in);\n");
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

    // Generate static create method
    content.append("    public static  ").append(builderClassName).append(" create(").append(parameterList)
        .append(") { return new ").append(builderClassName).append("(").append(argumentList).append("); }\n");

    // Generate private constructor
    content.append("    private ").append(builderClassName).append("(").append(parameterList)
        .append(") { in = new ").append(className).append("(").append(argumentList).append("); }\n");
  }

  private void parseSetter(Method method, Class<?> clazz, StringBuilder content) {
    String className = clazz.getSimpleName();
    String builderClassName = className + "Builder";
    String methodName = method.getName().substring(3);
    methodName = Character.toLowerCase(methodName.charAt(0)) + methodName.substring(1);

    Parameter[] parameters = method.getParameters();
    String parameterList = buildParameterListWithTypes(parameters);
    String argumentList = buildParameterListNamesOnly(parameters);

    content.append("    public  ").append(builderClassName).append(" ").append(methodName).append("(").append(parameterList)
        .append(") { in.").append(method.getName()).append("(").append(argumentList).append("); return this; }\n");
  }

}