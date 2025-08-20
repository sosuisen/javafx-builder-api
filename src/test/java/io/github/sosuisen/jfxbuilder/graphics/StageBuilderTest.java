package io.github.sosuisen.jfxbuilder.graphics;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

// Use TextFX
@ExtendWith(ApplicationExtension.class)
class StageBuilderTest {

    private Scene testScene;

    // Called before each test method
    @Start
    void setup(Stage stage) {
        VBox rootNode = new VBox();
        rootNode.getChildren().add(new Button("Test Button"));
        testScene = new Scene(rootNode, 400, 300);
    }

    @Test
    @DisplayName("Should create StageBuilder using create")
    void shouldCreateStageBuilderUsingCreate() {
        Platform.runLater(() -> {
            StageBuilder builder = StageBuilder.create();
            assertNotNull(builder);

            Stage stage = builder.build();
            assertNotNull(stage);
            assertEquals(StageStyle.DECORATED, stage.getStyle());
        });
    }

    @Test
    @DisplayName("Should create StageBuilder with specific style")
    void shouldCreateStageBuilderWithStyle() {
        StageStyle expectedStyle = StageStyle.UNDECORATED;

        Platform.runLater(() -> {
            StageBuilder builder = StageBuilder.create(expectedStyle);
            assertNotNull(builder);

            Stage stage = builder.build();
            assertNotNull(stage);
            assertEquals(expectedStyle, stage.getStyle());
        });
    }

    @Test
    @DisplayName("Should create StageBuilder with scene using withScene")
    void shouldCreateStageBuilderWithScene() {
        Platform.runLater(() -> {
            StageBuilder builder = StageBuilder.withScene(testScene);
            assertNotNull(builder);

            Stage stage = builder.build();
            assertNotNull(stage);
            assertEquals(testScene, stage.getScene());
            assertEquals(StageStyle.DECORATED, stage.getStyle());
        });
    }

    @Test
    @DisplayName("Should set stageStyle using stageStyle method")
    void shouldSetStageStyleUsingStageStyleMethod() {
        StageStyle expectedStyle = StageStyle.TRANSPARENT;

        Platform.runLater(() -> {
            Stage stage = StageBuilder.create()
                    .stageStyle(expectedStyle)
                    .build();

            assertEquals(expectedStyle, stage.getStyle());
        });
    }

    @Test
    @DisplayName("Should set stageStyle to UNDECORATED")
    void shouldSetStageStyleToUndecorated() {
        StageStyle expectedStyle = StageStyle.UNDECORATED;

        Platform.runLater(() -> {
            Stage stage = StageBuilder.create()
                    .stageStyle(expectedStyle)
                    .build();

            assertEquals(expectedStyle, stage.getStyle());
        });
    }

    @Test
    @DisplayName("Should combine withScene and stageStyle")
    void shouldCombineWithSceneAndStageStyle() {
        StageStyle expectedStyle = StageStyle.TRANSPARENT;

        Platform.runLater(() -> {
            Stage stage = StageBuilder.withScene(testScene)
                    .stageStyle(expectedStyle)
                    .build();

            assertEquals(testScene, stage.getScene());
            assertEquals(expectedStyle, stage.getStyle());
        });
    }

    @Test
    @DisplayName("Should set scene using scene method")
    void shouldSetSceneUsingSceneMethod() {
        Platform.runLater(() -> {
            Stage stage = StageBuilder.create()
                    .scene(testScene)
                    .build();

            assertEquals(testScene, stage.getScene());
        });
    }

    @Test
    @DisplayName("Should chain multiple methods including stageStyle")
    void shouldChainMultipleMethodsIncludingStageStyle() {
        StageStyle expectedStyle = StageStyle.UNDECORATED;
        String expectedTitle = "Test Stage";
        double expectedWidth = 500.0;
        double expectedHeight = 400.0;

        Platform.runLater(() -> {
            Stage stage = StageBuilder.create()
                    .stageStyle(expectedStyle)
                    .scene(testScene)
                    .title(expectedTitle)
                    .width(expectedWidth)
                    .height(expectedHeight)
                    .build();

            assertEquals(expectedStyle, stage.getStyle());
            assertEquals(testScene, stage.getScene());
            assertEquals(expectedTitle, stage.getTitle());
            assertEquals(expectedWidth, stage.getWidth(), 0.001);
            assertEquals(expectedHeight, stage.getHeight(), 0.001);
        });
    }

    @Test
    @DisplayName("Should override stageStyle when called multiple times")
    void shouldOverrideStageStyleWhenCalledMultipleTimes() {
        StageStyle finalStyle = StageStyle.UTILITY;

        Platform.runLater(() -> {
            Stage stage = StageBuilder.create()
                    .stageStyle(StageStyle.UNDECORATED)
                    .stageStyle(StageStyle.TRANSPARENT)
                    .stageStyle(finalStyle)
                    .build();

            assertEquals(finalStyle, stage.getStyle());
        });
    }

    @Test
    @DisplayName("Should use DECORATED as default style")
    void shouldUseDecoratedAsDefaultStyle() {
        Platform.runLater(() -> {
            Stage stage = StageBuilder.create()
                    .scene(testScene)
                    .title("Default Style Test")
                    .build();

            assertEquals(StageStyle.DECORATED, stage.getStyle());
        });
    }

}