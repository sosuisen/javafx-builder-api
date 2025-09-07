package io.github.sosuisen.jfxbuilder.graphics;

import javafx.event.EventHandler;
import javafx.geometry.NodeOrientation;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

// Use TextFX
@ExtendWith(ApplicationExtension.class)
class SceneBuilderTest {

    private Parent rootNode;

    // Called before each test method
    @Start
    void setup(Stage stage) {
        rootNode = new VBox();
    }

    @Test
    @DisplayName("Should create SceneBuilder with root parameter using create")
    void shouldCreateSceneBuildercreateUsingCreate() {
        SceneBuilder builder = SceneBuilder.create(rootNode);
        assertNotNull(builder);

        Scene scene = builder.build();
        assertNotNull(scene);
        assertEquals(rootNode, scene.getRoot());
    }

    @Test
    @DisplayName("Should create SceneBuilder with root, width and height")
    void shouldCreateSceneBuilderWithDimensions() {
        double expectedWidth = 800.0;
        double expectedHeight = 600.0;

        SceneBuilder builder = SceneBuilder.create(rootNode, expectedWidth, expectedHeight);
        assertNotNull(builder);

        Scene scene = builder.build();
        assertNotNull(scene);
        assertEquals(rootNode, scene.getRoot());
        assertEquals(expectedWidth, scene.getWidth(), 0.001);
        assertEquals(expectedHeight, scene.getHeight(), 0.001);
    }

    @Test
    @DisplayName("Should create SceneBuilder with root and paint fill")
    void shouldCreateSceneBuilderWithFill() {
        Paint expectedFill = Color.BLUE;

        SceneBuilder builder = SceneBuilder.create(rootNode, expectedFill);
        assertNotNull(builder);

        Scene scene = builder.build();
        assertNotNull(scene);
        assertEquals(rootNode, scene.getRoot());
        assertEquals(expectedFill, scene.getFill());
    }

    @Test
    @DisplayName("Should create SceneBuilder with depth buffer enabled")
    void shouldCreateSceneBuilderWithDepthBuffer() {
        double expectedWidth = 800.0;
        double expectedHeight = 600.0;
        boolean depthBuffer = true;

        SceneBuilder builder =
            SceneBuilder.create(rootNode, expectedWidth, expectedHeight, depthBuffer);
        assertNotNull(builder);

        Scene scene = builder.build();
        assertNotNull(scene);
        assertEquals(rootNode, scene.getRoot());
    }

    @Test
    @DisplayName("Should create SceneBuilder with antialiasing")
    void shouldCreateSceneBuilderWithAntialiasing() {
        double expectedWidth = 800.0;
        double expectedHeight = 600.0;
        boolean depthBuffer = false;
        SceneAntialiasing antialiasing = SceneAntialiasing.BALANCED;

        SceneBuilder builder =
            SceneBuilder.create(rootNode, expectedWidth, expectedHeight, depthBuffer, antialiasing);
        assertNotNull(builder);

        Scene scene = builder.build();
        assertNotNull(scene);
        assertEquals(rootNode, scene.getRoot());
    }

    @Test
    @DisplayName("Should set root using builder method")
    void shouldSetRootUsingBuilderMethod() {
        Parent newRoot = new Button("Test Button");
        Scene scene = SceneBuilder.create(rootNode)
            .root(newRoot)
            .build();

        assertEquals(newRoot, scene.getRoot());
    }

    @Test
    @DisplayName("Should set fill using builder method")
    void shouldSetFillUsingBuilderMethod() {
        Paint expectedFill = Color.GREEN;
        Scene scene = SceneBuilder.create(rootNode)
            .fill(expectedFill)
            .build();

        assertEquals(expectedFill, scene.getFill());
    }

    @Test
    @DisplayName("Should set user agent stylesheet")
    void shouldSetUserAgentStylesheet() {
        String expectedStylesheet = "test-stylesheet.css";
        Scene scene = SceneBuilder.create(rootNode)
            .userAgentStylesheet(expectedStylesheet)
            .build();

        assertEquals(expectedStylesheet, scene.getUserAgentStylesheet());
    }

    @Test
    @DisplayName("Should set cursor")
    void shouldSetCursor() {
        Cursor expectedCursor = Cursor.CROSSHAIR;
        Scene scene = SceneBuilder.create(rootNode)
            .cursor(expectedCursor)
            .build();

        assertEquals(expectedCursor, scene.getCursor());
    }

    @Test
    @DisplayName("Should set node orientation")
    void shouldSetNodeOrientation() {
        NodeOrientation expectedOrientation = NodeOrientation.RIGHT_TO_LEFT;
        Scene scene = SceneBuilder.create(rootNode)
            .nodeOrientation(expectedOrientation)
            .build();

        assertEquals(expectedOrientation, scene.getNodeOrientation());
    }

    @Test
    @DisplayName("Should set user data")
    void shouldSetUserData() {
        String expectedUserData = "test-data";
        Scene scene = SceneBuilder.create(rootNode)
            .userData(expectedUserData)
            .build();

        assertEquals(expectedUserData, scene.getUserData());
    }

    @Test
    @DisplayName("Should set key pressed event handler")
    void shouldSetKeyPressedEventHandler() {
        boolean[] keyPressed = {false};
        EventHandler<KeyEvent> handler = e -> keyPressed[0] = true;

        Scene scene = SceneBuilder.create(rootNode)
            .onKeyPressed(handler)
            .build();

        assertEquals(handler, scene.getOnKeyPressed());
    }

    @Test
    @DisplayName("Should set key released event handler")
    void shouldSetKeyReleasedEventHandler() {
        boolean[] keyReleased = {false};
        EventHandler<KeyEvent> handler = e -> keyReleased[0] = true;

        Scene scene = SceneBuilder.create(rootNode)
            .onKeyReleased(handler)
            .build();

        assertEquals(handler, scene.getOnKeyReleased());
    }

    @Test
    @DisplayName("Should set key typed event handler")
    void shouldSetKeyTypedEventHandler() {
        boolean[] keyTyped = {false};
        EventHandler<KeyEvent> handler = e -> keyTyped[0] = true;

        Scene scene = SceneBuilder.create(rootNode)
            .onKeyTyped(handler)
            .build();

        assertEquals(handler, scene.getOnKeyTyped());
    }

    @Test
    @DisplayName("Should set mouse clicked event handler")
    void shouldSetMouseClickedEventHandler() {
        boolean[] mouseClicked = {false};
        EventHandler<MouseEvent> handler = e -> mouseClicked[0] = true;

        Scene scene = SceneBuilder.create(rootNode)
            .onMouseClicked(handler)
            .build();

        assertEquals(handler, scene.getOnMouseClicked());
    }

    @Test
    @DisplayName("Should set mouse pressed event handler")
    void shouldSetMousePressedEventHandler() {
        boolean[] mousePressed = {false};
        EventHandler<MouseEvent> handler = e -> mousePressed[0] = true;

        Scene scene = SceneBuilder.create(rootNode)
            .onMousePressed(handler)
            .build();

        assertEquals(handler, scene.getOnMousePressed());
    }

    @Test
    @DisplayName("Should set mouse released event handler")
    void shouldSetMouseReleasedEventHandler() {
        boolean[] mouseReleased = {false};
        EventHandler<MouseEvent> handler = e -> mouseReleased[0] = true;

        Scene scene = SceneBuilder.create(rootNode)
            .onMouseReleased(handler)
            .build();

        assertEquals(handler, scene.getOnMouseReleased());
    }

    @Test
    @DisplayName("Should set mouse entered event handler")
    void shouldSetMouseEnteredEventHandler() {
        boolean[] mouseEntered = {false};
        EventHandler<MouseEvent> handler = e -> mouseEntered[0] = true;

        Scene scene = SceneBuilder.create(rootNode)
            .onMouseEntered(handler)
            .build();

        assertEquals(handler, scene.getOnMouseEntered());
    }

    @Test
    @DisplayName("Should set mouse exited event handler")
    void shouldSetMouseExitedEventHandler() {
        boolean[] mouseExited = {false};
        EventHandler<MouseEvent> handler = e -> mouseExited[0] = true;

        Scene scene = SceneBuilder.create(rootNode)
            .onMouseExited(handler)
            .build();

        assertEquals(handler, scene.getOnMouseExited());
    }

    @Test
    @DisplayName("Should set mouse moved event handler")
    void shouldSetMouseMovedEventHandler() {
        boolean[] mouseMoved = {false};
        EventHandler<MouseEvent> handler = e -> mouseMoved[0] = true;

        Scene scene = SceneBuilder.create(rootNode)
            .onMouseMoved(handler)
            .build();

        assertEquals(handler, scene.getOnMouseMoved());
    }

    @Test
    @DisplayName("Should set mouse dragged event handler")
    void shouldSetMouseDraggedEventHandler() {
        boolean[] mouseDragged = {false};
        EventHandler<MouseEvent> handler = e -> mouseDragged[0] = true;

        Scene scene = SceneBuilder.create(rootNode)
            .onMouseDragged(handler)
            .build();

        assertEquals(handler, scene.getOnMouseDragged());
    }

    @Test
    @DisplayName("Should chain multiple builder methods")
    void shouldChainMultipleBuilderMethods() {
        Paint expectedFill = Color.YELLOW;
        Cursor expectedCursor = Cursor.WAIT;
        String expectedUserData = "chained-scene";

        Scene scene = SceneBuilder.create(rootNode)
            .fill(expectedFill)
            .cursor(expectedCursor)
            .userData(expectedUserData)
            .nodeOrientation(NodeOrientation.LEFT_TO_RIGHT)
            .build();

        assertEquals(rootNode, scene.getRoot());
        assertEquals(expectedFill, scene.getFill());
        assertEquals(expectedCursor, scene.getCursor());
        assertEquals(expectedUserData, scene.getUserData());
        assertEquals(NodeOrientation.LEFT_TO_RIGHT, scene.getNodeOrientation());
    }

    @Test
    @DisplayName("Should apply custom consumer function")
    void shouldApplyCustomConsumerFunction() {
        Paint customFill = Color.PURPLE;

        Scene scene = SceneBuilder.create(rootNode)
            .apply(sc -> sc.setFill(customFill))
            .build();

        assertEquals(customFill, scene.getFill());
    }

    @Test
    @DisplayName("Should handle null parameters gracefully")
    void shouldHandleNullParametersGracefully() {
        assertDoesNotThrow(() -> {
            Scene scene = SceneBuilder.create(rootNode)
                .userAgentStylesheet(null)
                .userData(null)
                .build();
            assertNotNull(scene);
        });
    }

    @Test
    @DisplayName("Should throw exception when root is null")
    void shouldThrowExceptionWhenRootIsNull() {
        assertThrows(RuntimeException.class, () -> {
            SceneBuilder.create(null).build();
        });
    }
}
