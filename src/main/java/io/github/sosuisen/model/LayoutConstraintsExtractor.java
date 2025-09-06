package io.github.sosuisen.model;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import io.github.sosuisen.model.data.ParameterInfo;
import io.github.sosuisen.model.data.StaticSetterInfo;

public class LayoutConstraintsExtractor {

    // LAYOUT_CONSTRAINTS_JAR contains static setter methods for layout constraints
    private static final String LAYOUT_CONSTRAINTS_JAR = "javafx.graphics";
    private static final String CONTAINER_SUPER_CLASS = "javafx.scene.layout.Pane";

    public List<StaticSetterInfo> getStaticSetters() throws IOException {
        List<StaticSetterInfo> staticSetters = new ArrayList<>();

        List<String> targetClasses = JarExtractor.getTargetClasses(LAYOUT_CONSTRAINTS_JAR);

        for (String className : targetClasses) {
            try {
                Class<?> clazz = Class.forName(className);

                if (isContainerClass(clazz)) {
                    staticSetters.addAll(extractStaticSettersFromClass(clazz));
                }
            } catch (ClassNotFoundException e) {
                // Skip if class not found
            }
        }

        return staticSetters;
    }

    private boolean isContainerClass(Class<?> clazz) {
        try {
            Class<?> paneClass = Class.forName(CONTAINER_SUPER_CLASS);
            return paneClass.isAssignableFrom(clazz);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private List<StaticSetterInfo> extractStaticSettersFromClass(Class<?> clazz) {
        Method[] methods = clazz.getMethods();

        // Filter static setter methods and sort them by their string representation to
        // ensure consistent output order
        List<Method> staticSetterMethods = Arrays.stream(methods)
            .filter(
                method -> Modifier.isStatic(method.getModifiers()) &&
                    method.getName().startsWith("set")
            )
            .sorted(MethodComparator.forMethod())
            .collect(Collectors.toList());

        List<StaticSetterInfo> staticSetters = new ArrayList<>();
        for (Method method : staticSetterMethods) {
            List<ParameterInfo> parameters = new ArrayList<>();
            Parameter[] methodParameters = method.getParameters();

            for (Parameter param : methodParameters) {
                parameters.add(
                    new ParameterInfo(
                        param.getParameterizedType().getTypeName(),
                        param.getName()
                    )
                );
            }

            staticSetters.add(
                new StaticSetterInfo(
                    clazz,
                    method.getName(),
                    parameters,
                    method.getReturnType().getName()
                )
            );
        }

        return staticSetters;
    }
}
