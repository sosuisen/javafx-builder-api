@import io.github.sosuisen.template.ClassHeaderModel

@param ClassHeaderModel model

package ${model.packageName()};

${model.classAnnotation()}
public class ${model.builderClassName()}${model.typeParametersWithExtends()} {
    private java.util.List<java.util.function.Consumer<${model.classNameWithTypeParameter()}>> operations = new java.util.ArrayList<>();
    private ${model.builderClassName()}() {}
    