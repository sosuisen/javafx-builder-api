package io.github.sosuisen.model.data;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

public class ClassMetadata {
    private final Class<?> targetClass;
    final String typeParameters;
    final String typeParametersWithExtends;
    final String canonicalClassName;
    final String simpleClassName;
    final String builderClassName;
    final String packageName;

    public ClassMetadata(Class<?> clazz, String packageName) {
        this.targetClass = clazz;
        typeParameters = getTypeParameterString();
        typeParametersWithExtends = getTypeParametersWithExtendsString();
        canonicalClassName = clazz.getCanonicalName();
        simpleClassName = clazz.getSimpleName();
        builderClassName = createBuilderClassName();
        this.packageName = packageName;
    }

    public String getTypeParameters() {
        return typeParameters;
    }

    public String gettypeParametersWithExtends() {
        return typeParametersWithExtends;
    }

    public String getCanonicalClassName() {
        return canonicalClassName;
    }

    public String getSimpleClassName() {
        return simpleClassName;
    }

    public String getBuilderClassName() {
        return builderClassName;
    }

    public String getPackageName() {
        return packageName;
    }

    public String classNameWithTypeParameter() {
        return canonicalClassName + typeParameters;
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
        for (int i = 0; i < canonicalClassName.length(); i++) {
            if (Character.isUpperCase(canonicalClassName.charAt(i))) {
                firstUpperCaseIndex = i;
                break;
            }
        }

        // If no uppercase letter found, use the entire className
        if (firstUpperCaseIndex == -1) {
            return canonicalClassName.replace(".", "") + "Builder";
        }

        // Extract substring from first uppercase letter onwards and remove dots
        String result = canonicalClassName.substring(firstUpperCaseIndex).replace(".", "") + "Builder";
        return result;
    }

    private String getTypeParameterString() {
        if (targetClass.getTypeParameters().length == 0) {
            return "";
        }

        StringBuilder typeParameterBuilder = new StringBuilder("<");
        for (int i = 0; i < targetClass.getTypeParameters().length; i++) {
            if (i > 0)
                typeParameterBuilder.append(", ");

            typeParameterBuilder.append(targetClass.getTypeParameters()[i].getName());
        }
        typeParameterBuilder.append(">");
        return typeParameterBuilder.toString();
    }

    private String getTypeParametersWithExtendsString() {
        if (targetClass.getTypeParameters().length == 0) {
            return "";
        }

        StringBuilder typeParameterBuilder = new StringBuilder("<");
        for (int i = 0; i < targetClass.getTypeParameters().length; i++) {
            if (i > 0)
                typeParameterBuilder.append(", ");

            Type[] bounds = targetClass.getTypeParameters()[i].getBounds();
            if (bounds.length > 0) {
                if (!bounds[0].getTypeName().equals("java.lang.Object")) {
                    // e.g.) CellSkinBase<C extends Cell>
                    typeParameterBuilder
                            .append(targetClass.getTypeParameters()[i].getName() + " extends "
                                    + bounds[0].getTypeName());
                } else {
                    typeParameterBuilder.append(targetClass.getTypeParameters()[i].getName());
                }
            } else {
                typeParameterBuilder.append(targetClass.getTypeParameters()[i].getName());
            }

        }
        typeParameterBuilder.append(">");
        return typeParameterBuilder.toString();
    }

    public boolean isNodeClass() {
        try {
            Class<?> nodeClass = Class.forName("javafx.scene.Node");
            return nodeClass.isAssignableFrom(targetClass);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public boolean isParentClass() {
        try {
            Class<?> parentClass = Class.forName("javafx.scene.Parent");
            return parentClass.isAssignableFrom(targetClass);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
