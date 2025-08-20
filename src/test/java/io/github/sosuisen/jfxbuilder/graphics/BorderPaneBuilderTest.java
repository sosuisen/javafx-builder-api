package io.github.sosuisen.jfxbuilder.graphics;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

// Use TextFX
@ExtendWith(ApplicationExtension.class)
class BorderPaneBuilderTest {

    @Test
    @DisplayName("Should create BorderPaneBuilder with default constructor")
    void shouldCreateBorderPaneBuilderWithDefaultConstructor() {
        BorderPaneBuilder builder = BorderPaneBuilder.create();
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
        BorderPaneBuilder builder = BorderPaneBuilder.create(centerNode);
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

        BorderPaneBuilder builder = BorderPaneBuilder.create(centerNode, topNode, rightNode, bottomNode, leftNode);
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
        BorderPane borderPane = BorderPaneBuilder.create()
                .center(centerNode)
                .build();

        assertEquals(centerNode, borderPane.getCenter());
    }

    @Test
    @DisplayName("Should set top using instance method")
    void shouldSetTopUsingInstanceMethod() {
        Label topNode = new Label("Top");
        BorderPane borderPane = BorderPaneBuilder.create()
                .top(topNode)
                .build();

        assertEquals(topNode, borderPane.getTop());
    }

    @Test
    @DisplayName("Should set left using instance method")
    void shouldSetLeftUsingInstanceMethod() {
        Label leftNode = new Label("Left");
        BorderPane borderPane = BorderPaneBuilder.create()
                .left(leftNode)
                .build();

        assertEquals(leftNode, borderPane.getLeft());
    }

    @Test
    @DisplayName("Should set bottom using instance method")
    void shouldSetBottomUsingInstanceMethod() {
        Label bottomNode = new Label("Bottom");
        BorderPane borderPane = BorderPaneBuilder.create()
                .bottom(bottomNode)
                .build();

        assertEquals(bottomNode, borderPane.getBottom());
    }

    @Test
    @DisplayName("Should set right using instance method")
    void shouldSetRightUsingInstanceMethod() {
        Label rightNode = new Label("Right");
        BorderPane borderPane = BorderPaneBuilder.create()
                .right(rightNode)
                .build();

        assertEquals(rightNode, borderPane.getRight());
    }

    @Test
    @DisplayName("Should set center using static method")
    void shouldSetCenterUsingStaticMethod() {
        Button centerNode = new Button("Static Center");
        BorderPane borderPane = BorderPaneBuilder.withCenter(centerNode)
                .build();

        assertEquals(centerNode, borderPane.getCenter());
    }

    @Test
    @DisplayName("Should set top using static method")
    void shouldSetTopUsingStaticMethod() {
        Label topNode = new Label("Static Top");
        BorderPane borderPane = BorderPaneBuilder.withTop(topNode)
                .build();

        assertEquals(topNode, borderPane.getTop());
    }

    @Test
    @DisplayName("Should set left using static method")
    void shouldSetLeftUsingStaticMethod() {
        Label leftNode = new Label("Static Left");
        BorderPane borderPane = BorderPaneBuilder.withLeft(leftNode)
                .build();

        assertEquals(leftNode, borderPane.getLeft());
    }

    @Test
    @DisplayName("Should set bottom using static method")
    void shouldSetBottomUsingStaticMethod() {
        Label bottomNode = new Label("Static Bottom");
        BorderPane borderPane = BorderPaneBuilder.withBottom(bottomNode)
                .build();

        assertEquals(bottomNode, borderPane.getBottom());
    }

    @Test
    @DisplayName("Should set right using static method")
    void shouldSetRightUsingStaticMethod() {
        Label rightNode = new Label("Static Right");
        BorderPane borderPane = BorderPaneBuilder.withRight(rightNode)
                .build();

        assertEquals(rightNode, borderPane.getRight());
    }

    @Test
    @DisplayName("Should chain static and instance methods")
    void shouldChainStaticAndInstanceMethods() {
        Button centerNode = new Button("Static Center");
        Label topNode = new Label("Instance Top");
        Label leftNode = new Label("Instance Left");

        BorderPane borderPane = BorderPaneBuilder.withCenter(centerNode)
                .top(topNode)
                .left(leftNode)
                .build();

        assertEquals(centerNode, borderPane.getCenter());
        assertEquals(topNode, borderPane.getTop());
        assertEquals(leftNode, borderPane.getLeft());
        assertNull(borderPane.getBottom());
        assertNull(borderPane.getRight());
    }

    @Test
    @DisplayName("Should set padding")
    void shouldSetPadding() {
        Insets expectedPadding = new Insets(10, 15, 10, 15);
        BorderPane borderPane = BorderPaneBuilder.create()
                .padding(expectedPadding)
                .build();

        assertEquals(expectedPadding, borderPane.getPadding());
    }

    @Test
    @DisplayName("Should set size properties")
    void shouldSetSizeProperties() {
        double expectedWidth = 300.0;
        double expectedHeight = 200.0;

        BorderPane borderPane = BorderPaneBuilder.create()
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
        BorderPane borderPane = BorderPaneBuilder.create()
                .id(expectedId)
                .build();

        assertEquals(expectedId, borderPane.getId());
    }

    @Test
    @DisplayName("Should set style")
    void shouldSetStyle() {
        String expectedStyle = "-fx-background-color: lightblue;";
        BorderPane borderPane = BorderPaneBuilder.create()
                .style(expectedStyle)
                .build();

        assertEquals(expectedStyle, borderPane.getStyle());
    }

    @Test
    @DisplayName("Should set opacity")
    void shouldSetOpacity() {
        double expectedOpacity = 0.8;
        BorderPane borderPane = BorderPaneBuilder.create()
                .opacity(expectedOpacity)
                .build();

        assertEquals(expectedOpacity, borderPane.getOpacity(), 0.001);
    }

    @Test
    @DisplayName("Should set visible property")
    void shouldSetVisibleProperty() {
        BorderPane borderPane = BorderPaneBuilder.create()
                .visible(false)
                .build();

        assertFalse(borderPane.isVisible());
    }

    @Test
    @DisplayName("Should set managed property")
    void shouldSetManagedProperty() {
        BorderPane borderPane = BorderPaneBuilder.create()
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

        BorderPane borderPane = BorderPaneBuilder.create()
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

        BorderPane borderPane = BorderPaneBuilder.create()
                .apply(bp -> bp.setPadding(customPadding))
                .build();

        assertEquals(customPadding, borderPane.getPadding());
    }

    @Test
    @DisplayName("Should create different instances on multiple build calls")
    void shouldCreateDifferentInstancesOnMultipleBuildCalls() {
        BorderPaneBuilder builder = BorderPaneBuilder.create()
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
        BorderPaneBuilder builder = BorderPaneBuilder.create()
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
            BorderPane borderPane = BorderPaneBuilder.create()
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

        BorderPane borderPane = BorderPaneBuilder.create()
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