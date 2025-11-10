package io.github.sosuisen.generator;

import io.github.sosuisen.model.data.ClassMetadata;
import io.github.sosuisen.model.data.StaticSetterInfo;
import io.github.sosuisen.model.template.LayoutConstraintMethodModel;
import java.util.List;
import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.output.StringOutput;

public class LayoutConstraintsGenerator {
    private final TemplateEngine templateEngine;
    private final ClassMetadata classMetadata;
    private final List<StaticSetterInfo> staticSetters;

    public LayoutConstraintsGenerator(TemplateEngine templateEngine, ClassMetadata classMetadata,
        List<StaticSetterInfo> staticSetters) {
        this.templateEngine = templateEngine;
        this.classMetadata = classMetadata;
        this.staticSetters = staticSetters;
    }

    public String generate() {
        if (!classMetadata.isNodeClass()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (StaticSetterInfo setterInfo : staticSetters) {
            result.append(generateLayoutConstraintMethod(setterInfo));
        }
        return result.toString();
    }

    private String generateLayoutConstraintMethod(StaticSetterInfo setterInfo) {
        LayoutConstraintMethodModel model = LayoutConstraintMethodModel.builder()
            .classMetadata(classMetadata)
            .setterInfo(setterInfo)
            .build();
        TemplateOutput output = new StringOutput();
        templateEngine.render("layout-constraint-methods.jte", model, output);
        return output.toString();
    }
}
