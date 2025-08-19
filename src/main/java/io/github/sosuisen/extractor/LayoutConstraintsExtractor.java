package io.github.sosuisen.extractor;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

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
        List<StaticSetterInfo> staticSetters = new ArrayList<>();
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            if (Modifier.isStatic(method.getModifiers()) &&
                    method.getName().startsWith("set")) {

                List<ParameterInfo> parameters = new ArrayList<>();
                Parameter[] methodParameters = method.getParameters();

                for (Parameter param : methodParameters) {
                    parameters.add(new ParameterInfo(
                            param.getParameterizedType().getTypeName(),
                            param.getName()));
                }

                staticSetters.add(new StaticSetterInfo(
                        clazz,
                        method.getName(),
                        parameters,
                        method.getReturnType().getName()));
            }
        }

        return staticSetters;
    }
}