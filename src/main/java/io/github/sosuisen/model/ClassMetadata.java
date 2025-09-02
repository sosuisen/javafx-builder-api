package io.github.sosuisen.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

public class ClassMetadata {
    private final Class<?> targetClass;
    final String typeParameters;
    final String typeParametersWithExtends;
    final String className;
    final String builderClassName;

    public ClassMetadata(Class<?> clazz) {
        this.targetClass = clazz;
        typeParameters = getTypeParameterString(clazz);
        typeParametersWithExtends = getTypeParametersWithExtendsString(clazz);
        className = clazz.getCanonicalName();
        builderClassName = createBuilderClassName();
    }

    public String getTypeParameters() {
        return typeParameters;
    }

    public String gettypeParametersWithExtends() {
        return typeParametersWithExtends;
    }

    public String getClassName() {
        return className;
    }

    public String getBuilderClassName() {
        return builderClassName;
    }

    public String classNameWithTypeParameter() {
        return className + typeParameters;
    }

    public String builderClassNameWithTypeParameter() {
        return builderClassName + typeParameters;
    }

    public boolean hasDefaultConstructor() {
        Constructor<?>[] constructors = targetClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterCount() == 0) {
                return true;
            }
        }
        return false;
    }

    public Class<?> getTargetClass() {
        return targetClass;
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

    private String getTypeParametersWithExtendsString(Class<?> clazz) {
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
}
