package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code SceneBuilder} class constructs instances of the {@link javafx.scene.Scene} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the constructor arguments of the original {@link javafx.scene.Scene} constructor
 * and returns an instance of the {@code SceneBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.Scene}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.Scene} class.
 * </p>
 *
 * <p>
 * Note 1: Intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 * <p>
 * Note 2: The constructor arguments {@code width}, {@code height}, {@code depthBuffer}, and {@code antiAliasing} do not have setters on the {@link javafx.scene.Scene} class, but custom setters have been added to {@code SceneBuilder}.
 * </p>
 * <p>
 * Example:
 * </p>
 * <pre>{@code
 * StringProperty textProp = new SimpleStringProperty("100");
 *
 * Scene scene = SceneBuilder.withRoot(
 *                     HBoxBuilder.withChildren(
 *                           TextFieldBuilder.create()
 *                               .textPropertyApply(prop -> prop.bindBidirectional(textProp))
 *                               .style("""
 *                                      -fx-font-weight: bold;
 *                                      -fx-alignment: center;
 *                                      """)
 *                               .hGrowInHBox(Priority.ALWAYS)
 *                               .maxWidth(Double.MAX_VALUE)
 *                               .build(),
 *                           ButtonBuilder.create()
 *                               .text("Send")
 *                               .onAction(e -> System.out.println("Sending..."))
 *                               .minWidth(50)
 *                               .build())
 *                         .padding(new Insets(10))
 *                         .build())
 *                   .width(150) // custom setter
 *                   .height(100) // custom setter
 *                   .build();
 * }</pre>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */
public class SceneBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.scene.Scene>> operations = new java.util.ArrayList<>();
    private SceneBuilder() {}
  
    // Default values for constructor parameters
    // See
    // https://github.com/openjdk/jfx/blob/1dda20b72eae2b9e12eb1217504977b45ddff6b8/modules/javafx.graphics/src/main/java/javafx/scene/Scene.java
    /**
     * -1
     */
    public static final double DEFAULT_WIDTH = -1;
    /**
     * -1
     */
    public static final double DEFAULT_HEIGHT = -1;
    /**
     * false
     */
    public static final boolean DEFAULT_DEPTH_BUFFER = false;
    /**
     * {@link javafx.scene.SceneAntialiasing#DISABLED}
     */
    public static final javafx.scene.SceneAntialiasing DEFAULT_ANTI_ALIASING = javafx.scene.SceneAntialiasing.DISABLED;
    
    private static final javafx.scene.paint.Paint DEFAULT_FILL = javafx.scene.paint.Color.WHITE;

    private javafx.scene.Parent root;    
    private double width = DEFAULT_WIDTH;
    private double height = DEFAULT_HEIGHT;
    private boolean depthBuffer = DEFAULT_DEPTH_BUFFER;
    private javafx.scene.SceneAntialiasing antiAliasing = DEFAULT_ANTI_ALIASING;

    /**
     * Performs the same processing as the {@link io.github.sosuisen.jfxbuilder.graphics.SceneBuilder#create(javafx.scene.Parent) create(javafx.scene.Parent)} method.
     * This alias ensures consistency with other methods, such as the {@code withChildren} method found in container classes.
     *
     * @return an instance of the SceneBuilder.
     */
    public static SceneBuilder withRoot(javafx.scene.Parent root) {
        SceneBuilder builder = new SceneBuilder();
        builder.root = root;
        return builder;
    }

    /**
     * Sets the width of the scene. The default value is {@link #DEFAULT_WIDTH}.
     * 
     * @return builder instance
     */    
    public SceneBuilder width(double width) {
        this.width = width;
        return this;
    }

    /**
     * Sets the height of the scene. The default value is {@link #DEFAULT_HEIGHT}.
     * 
     * @return builder instance
     */    
    public SceneBuilder height(double height) {
        this.height = height;
        return this;
    }

    /**
     * Sets the depthBuffer of the scene. The default value is {@link #DEFAULT_DEPTH_BUFFER}.
     * 
     * @return builder instance
     */    
    public SceneBuilder depthBuffer(boolean depthBuffer) {
        this.depthBuffer = depthBuffer;
        return this;
    }

    /**
     * Sets the antiAliasing of the scene. The default value is {@link #DEFAULT_ANTI_ALIASING}.
     * 
     * @return builder instance
     */    
    public SceneBuilder antiAliasing(javafx.scene.SceneAntialiasing antiAliasing) {
        this.antiAliasing = antiAliasing;
        return this;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.Scene#Scene(javafx.scene.Parent) Scene(Parent)}
     * and returns an instance of the SceneBuilder.
     *
     * @return an instance of the SceneBuilder.
     */
    public static SceneBuilder create(javafx.scene.Parent root) {
        SceneBuilder builder = new SceneBuilder();
        builder.root = root;
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.Scene#Scene(javafx.scene.Parent, javafx.scene.paint.Paint) Scene(Parent, Paint)}
     * and returns an instance of the SceneBuilder.
     *
     * @return an instance of the SceneBuilder.
     */
    public static SceneBuilder create(javafx.scene.Parent root, javafx.scene.paint.Paint fill) {
        SceneBuilder builder = new SceneBuilder();
        builder.root = root;
        builder.operations.add(obj -> obj.setFill(fill));
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.Scene#Scene(javafx.scene.Parent, double, double) Scene(Parent, double, double)}
     * and returns an instance of the SceneBuilder.
     *
     * @return an instance of the SceneBuilder.
     */
    public static SceneBuilder create(javafx.scene.Parent root, double width, double height) {
        SceneBuilder builder = new SceneBuilder();
        builder.root = root;
        builder.width = width;
        builder.height = height;
        builder.operations.add(obj -> obj.setFill(DEFAULT_FILL));
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.Scene#Scene(javafx.scene.Parent, double, double, javafx.scene.paint.Paint) Scene(Parent, double, double Paint)}
     * and returns an instance of the SceneBuilder.
     *
     * @return an instance of the SceneBuilder.
     */
    public static SceneBuilder create(javafx.scene.Parent root, double width, double height,
            javafx.scene.paint.Paint fill) {
        SceneBuilder builder = new SceneBuilder();
        builder.root = root;
        builder.width = width;
        builder.height = height;
        builder.operations.add(obj -> obj.setFill(fill));
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.Scene#Scene(javafx.scene.Parent, double, double, boolean) Scene(Parent, double, double, boolean)}
     * and returns an instance of the SceneBuilder.
     *
     * @return an instance of the SceneBuilder.
     */
    public static SceneBuilder create(javafx.scene.Parent root, double width, double height, boolean depthBuffer) {
        SceneBuilder builder = new SceneBuilder();
        builder.root = root;
        builder.width = width;
        builder.height = height;
        builder.depthBuffer = depthBuffer;
        builder.operations.add(obj -> obj.setFill(DEFAULT_FILL));
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.scene.Scene#Scene(javafx.scene.Parent, double, double, boolean, javafx.scene.SceneAntialiasing) Scene(Parent, double, double, boolean, SceneAntialiasing)}
     * and returns an instance of the SceneBuilder.
     *
     * @return an instance of the SceneBuilder.
     */
    public static SceneBuilder create(javafx.scene.Parent root, double width, double height, boolean depthBuffer,
            javafx.scene.SceneAntialiasing antiAliasing) {
        SceneBuilder builder = new SceneBuilder();
        builder.root = root;
        builder.width = width;
        builder.height = height;
        builder.depthBuffer = depthBuffer;
        builder.antiAliasing = antiAliasing;
        builder.operations.add(obj -> obj.setFill(DEFAULT_FILL));
        return builder;
    }

    /**
     * Builds and returns an instance of the {@link javafx.scene.Scene} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.Scene} class
     */
    public javafx.scene.Scene build() {
        javafx.scene.Scene newInstance;

        newInstance = new javafx.scene.Scene(root, width, height, depthBuffer, antiAliasing);

        for (java.util.function.Consumer<javafx.scene.Scene> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }

    /**
     * Utility setter to add CSS string for this scene's contents.
     * For example:
     * <pre>{@code
     * SceneBuilder builder = SceneBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();}
     * </pre>
     *
     * @param css CSS string
     */
    public SceneBuilder addStylesheetsText(String css) {
        operations.add(obj -> obj.getStylesheets().addAll("data:text/css;base64," +
                java.util.Base64.getEncoder().encodeToString(css.getBytes())));
        return this;
    }
