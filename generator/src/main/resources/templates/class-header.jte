@import io.github.sosuisen.model.template.ClassHeaderModel

@param ClassHeaderModel model

package ${model.packageName()};

/**
 * The {@code ${model.builderClassName()}} class constructs instances of the {@link ${model.canonicalClassName()} ${model.simpleClassName()}} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link ${model.canonicalClassName()} ${model.simpleClassName()}} constructor
 * and returns an instance of the {@code ${model.builderClassName()}}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link ${model.canonicalClassName()} ${model.simpleClassName()}}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link ${model.canonicalClassName()} ${model.simpleClassName()}} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */
${model.classAnnotation()}
public class ${model.builderClassName()}${model.typeParametersWithExtends()} {
    private final java.util.List<java.util.function.Consumer<${model.classNameWithTypeParameter()}>> operations = new java.util.ArrayList<>();
    private ${model.builderClassName()}() {}
    