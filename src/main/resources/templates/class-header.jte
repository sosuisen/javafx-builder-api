@import io.github.sosuisen.template.ClassHeaderModel

@param ClassHeaderModel model

package ${model.packageName()};

public class ${model.builderClassName()}${model.typeParametersExtends()} {
    private Object[] constructorArgs;
    private Object[] mandatoryParams;
    private java.util.List<java.util.function.Consumer<${model.classNameWithTypeParameter()}>> operations = new java.util.ArrayList<>();