package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code StageBuilder} class constructs instances of the {@link javafx.stage.Stage} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.stage.Stage} constructor
 * and returns an instance of the {@code StageBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.stage.Stage}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.stage.Stage} class.
 * </p>
 *
 * <p>
 * Note 1: Intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 * <p>
 * Note 2: There is no setter for the optional constructor argument {@code StageStyle}, but {@code StageBuilder} has a {@code stageStyle} method.
 * </p>
 * <p>
 * Example:
 * </p>
 * <pre>{@code 
 * StageBuilder.withScene(
 *       SceneBuilder.withRoot(
 *             AnchorPaneBuilder.withChildren(
 *                   LabelBuilder.create()
                         .text("Hello, JavaFX!")
                         .style("-fx-font-weight: bold;")
                         .build())
 *                 .build())
 *           .build())
 *     .width(640)
 *     .height(480)
 *     .build();
 * }</pre>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */
public class StageBuilder {
    private java.util.List<java.util.function.Consumer<javafx.stage.Stage>> operations = new java.util.ArrayList<>();
    private StageBuilder() {}
    
    private javafx.stage.StageStyle style = javafx.stage.StageStyle.DECORATED;

    /**
     * Creates an instance of the builder and then calls the {@link setScene(Scene scene)} method.
     * This shorthand ensures consistency with other methods, such as the `withChildren` method found in container classes.
     *
     * @return an instance of the StageBuilder.
     */
    public static StageBuilder withScene(javafx.scene.Scene scene) {
        StageBuilder builder = new StageBuilder();
        builder.scene(scene);
        return builder;
    }


    /**
     * Sets a {@link javafx.stage.StageStyle}.
     *
     * There is no setter for the optional constructor argument {@code StageStyle};
     * however, the {@code StageBuilder} includes a convenient {@code stageStyle} method.
     *
     * @return an instance of the StageBuilder.
     */
    public StageBuilder stageStyle(javafx.stage.StageStyle style) {
        this.style = style;
        return this;
    }

    /**
     * Returns an instance of the StageBuilder.
     *
     * @return an instance of the StageBuilder.
     */
    public static StageBuilder create() {
        StageBuilder builder = new StageBuilder();
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.stage.Stage#Stage(javafx.stage.StageStyle)}
     * and returns an instance of the StageBuilder.
     *
     * @return an instance of the StageBuilder.
     */
    public static StageBuilder create(javafx.stage.StageStyle style) {
        StageBuilder builder = new StageBuilder();
        builder.style = style;
        return builder;
    }

    /**
     * Builds and returns an instance of the {@link javafx.stage.Stage} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.stage.Stage} class
     */
    public javafx.stage.Stage build() {
        javafx.stage.Stage newInstance;

        newInstance = new javafx.stage.Stage(style);

        for (java.util.function.Consumer<javafx.stage.Stage> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }

