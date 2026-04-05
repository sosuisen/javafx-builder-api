package io.github.sosuisen.generator;

import java.util.Map;
import java.util.function.Supplier;
import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.output.StringOutput;

public class CustomizedCoreGenerator {
    private final TemplateEngine templateEngine;
    private final Class<?> clazz;
    private final Map<String, Supplier<String>> classSpecificGenerators = Map.of(
        "Stage", this::generateStageMethods,
        "Scene", this::generateSceneMethods
    );

    public CustomizedCoreGenerator(TemplateEngine templateEngine, Class<?> clazz) {
        this.templateEngine = templateEngine;
        this.clazz = clazz;
    }

    public boolean hasCustomGenerator() {
        return classSpecificGenerators.containsKey(clazz.getSimpleName());
    }

    public String generate() {
        StringBuilder content = new StringBuilder();
        String className = clazz.getSimpleName();

        for (Map.Entry<String, Supplier<String>> entry : classSpecificGenerators.entrySet()) {
            if (entry.getKey().equals(className)) {
                content.append(entry.getValue().get());
            }
        }
        return content.toString();
    }

    private String generateStageMethods() {
        TemplateOutput output = new StringOutput();
        templateEngine.render("stage-core.jte", null, output);
        return output.toString();
    }

    private String generateSceneMethods() {
        TemplateOutput output = new StringOutput();
        templateEngine.render("scene-core.jte", null, output);
        return output.toString();
    }
}
