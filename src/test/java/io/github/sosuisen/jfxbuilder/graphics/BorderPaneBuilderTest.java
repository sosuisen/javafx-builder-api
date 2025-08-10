package io.github.sosuisen.jfxbuilder.graphics;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class BorderPaneBuilderTest {

    @BeforeEach
    void initializeJavaFXRuntime() {
        try {
            javafx.application.Platform.startup(() -> {
            });
        } catch (IllegalStateException e) {
            // Platform already started
        }
    }

    @Test
    @DisplayName("Should create BorderPaneBuilder with default constructor")
    void shouldCreateBorderPaneBuilderWithDefaultConstructor() {
        BorderPaneBuilder builder = new BorderPaneBuilder();
        assertNotNull(builder);

        BorderPane borderPane = builder.build();
        assertNotNull(borderPane);
        assertNull(borderPane.getCenter());
        assertNull(borderPane.getTop());
        assertNull(borderPane.getLeft());
        assertNull(borderPane.getBottom());
        assertNull(borderPane.getRight());
    }

    @Test
    @DisplayName("Should create BorderPaneBuilder with center parameter")
    void shouldCreateBorderPaneBuilderWithCenter() {
        Button centerNode = new Button("Center");
        BorderPaneBuilder builder = new BorderPaneBuilder(centerNode);
        assertNotNull(builder);

        BorderPane borderPane = builder.build();
        assertNotNull(borderPane);
        assertEquals(centerNode, borderPane.getCenter());
    }

    @Test
    @DisplayName("Should create BorderPaneBuilder with all parameters")
    void shouldCreateBorderPaneBuilderWithAllParameters() {
        Button centerNode = new Button("Center");
        Label topNode = new Label("Top");
        Label rightNode = new Label("Right");
        Label bottomNode = new Label("Bottom");
        Label leftNode = new Label("Left");

        BorderPaneBuilder builder = new BorderPaneBuilder(centerNode, topNode, rightNode, bottomNode, leftNode);
        assertNotNull(builder);

        BorderPane borderPane = builder.build();
        assertNotNull(borderPane);
        assertEquals(centerNode, borderPane.getCenter());
        assertEquals(topNode, borderPane.getTop());
        assertEquals(rightNode, borderPane.getRight());
        assertEquals(bottomNode, borderPane.getBottom());
        assertEquals(leftNode, borderPane.getLeft());
    }

    @Test
    @DisplayName("Should set center using instance method")
    void shouldSetCenterUsingInstanceMethod() {
        Button centerNode = new Button("Center");
        BorderPane borderPane = new BorderPaneBuilder()
                .center(centerNode)
                .build();

        assertEquals(centerNode, borderPane.getCenter());
    }

    @Test
    @DisplayName("Should set top using instance method")
    void shouldSetTopUsingInstanceMethod() {
        Label topNode = new Label("Top");
        BorderPane borderPane = new BorderPaneBuilder()
                .top(topNode)
                .build();

        assertEquals(topNode, borderPane.getTop());
    }

    @Test
    @DisplayName("Should set left using instance method")
    void shouldSetLeftUsingInstanceMethod() {
        Label leftNode = new Label("Left");
        BorderPane borderPane = new BorderPaneBuilder()
                .left(leftNode)
                .build();

        assertEquals(leftNode, borderPane.getLeft());
    }

    @Test
    @DisplayName("Should set bottom using instance method")
    void shouldSetBottomUsingInstanceMethod() {
        Label bottomNode = new Label("Bottom");
        BorderPane borderPane = new BorderPaneBuilder()
                .bottom(bottomNode)
                .build();

        assertEquals(bottomNode, borderPane.getBottom());
    }

    @Test
    @DisplayName("Should set right using instance method")
    void shouldSetRightUsingInstanceMethod() {
        Label rightNode = new Label("Right");
        BorderPane borderPane = new BorderPaneBuilder()
                .right(rightNode)
                .build();

        assertEquals(rightNode, borderPane.getRight());
    }

    @Test
    @DisplayName("Should set padding")
    void shouldSetPadding() {
        Insets expectedPadding = new Insets(10, 15, 10, 15);
        BorderPane borderPane = new BorderPaneBuilder()
                .padding(expectedPadding)
                .build();

        assertEquals(expectedPadding, borderPane.getPadding());
    }

    @Test
    @DisplayName("Should set size properties")
    void shouldSetSizeProperties() {
        double expectedWidth = 300.0;
        double expectedHeight = 200.0;

        BorderPane borderPane = new BorderPaneBuilder()
                .prefWidth(expectedWidth)
                .prefHeight(expectedHeight)
                .build();

        assertEquals(expectedWidth, borderPane.getPrefWidth(), 0.001);
        assertEquals(expectedHeight, borderPane.getPrefHeight(), 0.001);
    }

    @Test
    @DisplayName("Should set ID")
    void shouldSetId() {
        String expectedId = "test-borderpane";
        BorderPane borderPane = new BorderPaneBuilder()
                .id(expectedId)
                .build();

        assertEquals(expectedId, borderPane.getId());
    }

    @Test
    @DisplayName("Should set style")
    void shouldSetStyle() {
        String expectedStyle = "-fx-background-color: lightblue;";
        BorderPane borderPane = new BorderPaneBuilder()
                .style(expectedStyle)
                .build();

        assertEquals(expectedStyle, borderPane.getStyle());
    }

    @Test
    @DisplayName("Should set opacity")
    void shouldSetOpacity() {
        double expectedOpacity = 0.8;
        BorderPane borderPane = new BorderPaneBuilder()
                .opacity(expectedOpacity)
                .build();

        assertEquals(expectedOpacity, borderPane.getOpacity(), 0.001);
    }

    @Test
    @DisplayName("Should set visible property")
    void shouldSetVisibleProperty() {
        BorderPane borderPane = new BorderPaneBuilder()
                .visible(false)
                .build();

        assertFalse(borderPane.isVisible());
    }

    @Test
    @DisplayName("Should set managed property")
    void shouldSetManagedProperty() {
        BorderPane borderPane = new BorderPaneBuilder()
                .managed(false)
                .build();

        assertFalse(borderPane.isManaged());
    }

    @Test
    @DisplayName("Should chain multiple builder methods")
    void shouldChainMultipleBuilderMethods() {
        Button centerNode = new Button("Center");
        Label topNode = new Label("Top");
        String expectedId = "chained-borderpane";
        double expectedWidth = 400.0;

        BorderPane borderPane = new BorderPaneBuilder()
                .center(centerNode)
                .top(topNode)
                .id(expectedId)
                .prefWidth(expectedWidth)
                .visible(true)
                .build();

        assertEquals(centerNode, borderPane.getCenter());
        assertEquals(topNode, borderPane.getTop());
        assertEquals(expectedId, borderPane.getId());
        assertEquals(expectedWidth, borderPane.getPrefWidth(), 0.001);
        assertTrue(borderPane.isVisible());
    }

    @Test
    @DisplayName("Should apply custom consumer function")
    void shouldApplyCustomConsumerFunction() {
        Insets customPadding = new Insets(20);

        BorderPane borderPane = new BorderPaneBuilder()
                .apply(bp -> bp.setPadding(customPadding))
                .build();

        assertEquals(customPadding, borderPane.getPadding());
    }

    @Test
    @DisplayName("Should create different instances on multiple build calls")
    void shouldCreateDifferentInstancesOnMultipleBuildCalls() {
        BorderPaneBuilder builder = new BorderPaneBuilder()
                .center(new Button("Test"));
        BorderPane firstBuild = builder.build();
        BorderPane secondBuild = builder.build();

        assertNotSame(firstBuild, secondBuild);
        // Note: The same Button node moves from first to second build
        // This is correct JavaFX behavior - a Node can only have one parent
        assertNull(firstBuild.getCenter());
        assertEquals("Test", ((Button) secondBuild.getCenter()).getText());
    }

    @Test
    @DisplayName("Should allow independent modification of multiple instances from same builder")
    void shouldAllowIndependentModificationOfMultipleInstances() {
        BorderPaneBuilder builder = new BorderPaneBuilder()
                .prefWidth(250.0)
                .prefHeight(150.0);

        BorderPane instance1 = builder.build();
        BorderPane instance2 = builder.build();
        BorderPane instance3 = builder.build();

        // All instances should start with same properties
        assertNotSame(instance1, instance2);
        assertNotSame(instance2, instance3);
        assertEquals(250.0, instance1.getPrefWidth(), 0.001);
        assertEquals(250.0, instance2.getPrefWidth(), 0.001);
        assertEquals(250.0, instance3.getPrefWidth(), 0.001);
        assertEquals(150.0, instance1.getPrefHeight(), 0.001);
        assertEquals(150.0, instance2.getPrefHeight(), 0.001);
        assertEquals(150.0, instance3.getPrefHeight(), 0.001);

        // Modify each instance independently
        instance1.setPrefWidth(300.0);
        instance2.setPrefHeight(200.0);
        instance3.setOpacity(0.5);

        // Each instance should maintain its own state
        assertEquals(300.0, instance1.getPrefWidth(), 0.001);
        assertEquals(250.0, instance2.getPrefWidth(), 0.001);
        assertEquals(250.0, instance3.getPrefWidth(), 0.001);
        assertEquals(150.0, instance1.getPrefHeight(), 0.001);
        assertEquals(200.0, instance2.getPrefHeight(), 0.001);
        assertEquals(150.0, instance3.getPrefHeight(), 0.001);
        assertEquals(1.0, instance1.getOpacity(), 0.001);
        assertEquals(1.0, instance2.getOpacity(), 0.001);
        assertEquals(0.5, instance3.getOpacity(), 0.001);
    }

    @Test
    @DisplayName("Should handle null parameters gracefully")
    void shouldHandleNullParametersGracefully() {
        assertDoesNotThrow(() -> {
            BorderPane borderPane = new BorderPaneBuilder()
                    .center(null)
                    .top(null)
                    .id(null)
                    .style(null)
                    .build();
            assertNotNull(borderPane);
        });
    }

    @Test
    @DisplayName("Should support all position methods in single builder chain")
    void shouldSupportAllPositionMethodsInSingleBuilderChain() {
        Button centerNode = new Button("Center");
        Label topNode = new Label("Top");
        Label rightNode = new Label("Right");
        Label bottomNode = new Label("Bottom");
        Label leftNode = new Label("Left");

        BorderPane borderPane = new BorderPaneBuilder()
                .center(centerNode)
                .top(topNode)
                .right(rightNode)
                .bottom(bottomNode)
                .left(leftNode)
                .build();

        assertEquals(centerNode, borderPane.getCenter());
        assertEquals(topNode, borderPane.getTop());
        assertEquals(rightNode, borderPane.getRight());
        assertEquals(bottomNode, borderPane.getBottom());
        assertEquals(leftNode, borderPane.getLeft());
    }
}