

    private javafx.stage.StageStyle style = javafx.stage.StageStyle.DECORATED;

    public static StageBuilder withScene(javafx.scene.Scene scene) {
        StageBuilder builder = new StageBuilder();
        builder.scene(scene);
        return builder;
    }

    public StageBuilder stageStyle(javafx.stage.StageStyle style) {
        this.style = style;
        return this;
    }

    public static StageBuilder create() {
        StageBuilder builder = new StageBuilder();
        return builder;
    }

    public static StageBuilder create(javafx.stage.StageStyle style) {
        StageBuilder builder = new StageBuilder();
        builder.style = style;
        return builder;
    }

    public javafx.stage.Stage build() {
        javafx.stage.Stage newInstance;

        newInstance = new javafx.stage.Stage(style);

        for (java.util.function.Consumer<javafx.stage.Stage> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }

