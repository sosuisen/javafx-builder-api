

    // Default values for constructor parameters
    // See
    // https://github.com/openjdk/jfx/blob/1dda20b72eae2b9e12eb1217504977b45ddff6b8/modules/javafx.graphics/src/main/java/javafx/scene/Scene.java
    private javafx.scene.Parent root;
    private double width = -1;
    private double height = -1;
    private boolean depthBuffer = false;
    private javafx.scene.SceneAntialiasing antiAliasing = javafx.scene.SceneAntialiasing.DISABLED;
    private static javafx.scene.paint.Paint DEFAULT_FILL = javafx.scene.paint.Color.WHITE;

    // Custom methods for SceneBuilder - start
    public static SceneBuilder withRoot(javafx.scene.Parent root) {
        SceneBuilder builder = new SceneBuilder();
        builder.root = root;
        return builder;
    }

    public SceneBuilder width(double width) {
        this.width = width;
        return this;
    }

    public SceneBuilder height(double height) {
        this.height = height;
        return this;
    }

    public SceneBuilder depthBuffer(boolean depthBuffer) {
        this.depthBuffer = depthBuffer;
        return this;
    }

    public SceneBuilder antiAliasing(javafx.scene.SceneAntialiasing antiAliasing) {
        this.antiAliasing = antiAliasing;
        return this;
    }

    public static SceneBuilder create(javafx.scene.Parent root) {
        SceneBuilder builder = new SceneBuilder();
        builder.root = root;
        return builder;
    }

    public static SceneBuilder create(javafx.scene.Parent root, javafx.scene.paint.Paint fill) {
        SceneBuilder builder = new SceneBuilder();
        builder.root = root;
        builder.operations.add(obj -> obj.setFill(fill));
        return builder;
    }

    public static SceneBuilder create(javafx.scene.Parent root, double width, double height) {
        SceneBuilder builder = new SceneBuilder();
        builder.root = root;
        builder.width = width;
        builder.height = height;
        builder.operations.add(obj -> obj.setFill(DEFAULT_FILL));
        return builder;
    }

    public static SceneBuilder create(javafx.scene.Parent root, double width, double height,
            javafx.scene.paint.Paint fill) {
        SceneBuilder builder = new SceneBuilder();
        builder.root = root;
        builder.width = width;
        builder.height = height;
        builder.operations.add(obj -> obj.setFill(fill));
        return builder;
    }

    public static SceneBuilder create(javafx.scene.Parent root, double width, double height, boolean depthBuffer) {
        SceneBuilder builder = new SceneBuilder();
        builder.root = root;
        builder.width = width;
        builder.height = height;
        builder.depthBuffer = depthBuffer;
        builder.operations.add(obj -> obj.setFill(DEFAULT_FILL));
        return builder;
    }

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

    public javafx.scene.Scene build() {
        javafx.scene.Scene newInstance;

        newInstance = new javafx.scene.Scene(root, width, height, depthBuffer, antiAliasing);

        for (java.util.function.Consumer<javafx.scene.Scene> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }
