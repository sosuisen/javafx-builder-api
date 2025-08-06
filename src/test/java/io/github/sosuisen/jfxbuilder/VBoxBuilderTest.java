package io.github.sosuisen.jfxbuilder;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class VBoxBuilderTest {

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
    @DisplayName("Should create VBoxBuilder with default constructor")
    void shouldCreateVBoxBuilderWithDefaultConstructor() {
        VBoxBuilder builder = VBoxBuilder.create();
        assertNotNull(builder);

        VBox vbox = builder.build();
        assertNotNull(vbox);
        assertEquals(0, vbox.getChildren().size());
        assertEquals(0.0, vbox.getSpacing(), 0.001);
    }

    @Test
    @DisplayName("Should create VBoxBuilder with spacing parameter")
    void shouldCreateVBoxBuilderWithSpacing() {
        double expectedSpacing = 10.0;
        VBoxBuilder builder = VBoxBuilder.create(expectedSpacing);
        assertNotNull(builder);

        VBox vbox = builder.build();
        assertNotNull(vbox);
        assertEquals(expectedSpacing, vbox.getSpacing(), 0.001);
    }

    @Test
    @DisplayName("Should create VBoxBuilder with children array parameter")
    void shouldCreateVBoxBuilderWithChildrenArray() {
        Button button1 = new Button("Button 1");
        Label label1 = new Label("Label 1");
        Node[] children = { button1, label1 };

        VBoxBuilder builder = VBoxBuilder.create(children);
        assertNotNull(builder);

        VBox vbox = builder.build();
        assertNotNull(vbox);
        assertEquals(2, vbox.getChildren().size());
        assertTrue(vbox.getChildren().contains(button1));
        assertTrue(vbox.getChildren().contains(label1));
    }

    @Test
    @DisplayName("Should create VBoxBuilder with spacing and children parameters")
    void shouldCreateVBoxBuilderWithSpacingAndChildren() {
        double expectedSpacing = 15.0;
        Button button1 = new Button("Button 1");
        Label label1 = new Label("Label 1");
        Node[] children = { button1, label1 };

        VBoxBuilder builder = VBoxBuilder.create(expectedSpacing, children);
        assertNotNull(builder);

        VBox vbox = builder.build();
        assertNotNull(vbox);
        assertEquals(expectedSpacing, vbox.getSpacing(), 0.001);
        assertEquals(2, vbox.getChildren().size());
        assertTrue(vbox.getChildren().contains(button1));
        assertTrue(vbox.getChildren().contains(label1));
    }

    @Test
    @DisplayName("Should set spacing property")
    void shouldSetSpacingProperty() {
        double expectedSpacing = 20.0;
        VBox vbox = VBoxBuilder.create()
                .spacing(expectedSpacing)
                .build();

        assertEquals(expectedSpacing, vbox.getSpacing(), 0.001);
    }

    @Test
    @DisplayName("Should set alignment property")
    void shouldSetAlignmentProperty() {
        Pos expectedAlignment = Pos.CENTER;
        VBox vbox = VBoxBuilder.create()
                .alignment(expectedAlignment)
                .build();

        assertEquals(expectedAlignment, vbox.getAlignment());
    }

    @Test
    @DisplayName("Should set fillWidth property")
    void shouldSetFillWidthProperty() {
        VBox vbox = VBoxBuilder.create()
                .fillWidth(false)
                .build();

        assertFalse(vbox.isFillWidth());
    }

    @Test
    @DisplayName("Should set padding property")
    void shouldSetPaddingProperty() {
        Insets expectedPadding = new Insets(10, 15, 10, 15);
        VBox vbox = VBoxBuilder.create()
                .padding(expectedPadding)
                .build();

        assertEquals(expectedPadding, vbox.getPadding());
    }

    @Test
    @DisplayName("Should set size properties")
    void shouldSetSizeProperties() {
        double expectedWidth = 300.0;
        double expectedHeight = 200.0;

        VBox vbox = VBoxBuilder.create()
                .prefWidth(expectedWidth)
                .prefHeight(expectedHeight)
                .build();

        assertEquals(expectedWidth, vbox.getPrefWidth(), 0.001);
        assertEquals(expectedHeight, vbox.getPrefHeight(), 0.001);
    }

    @Test
    @DisplayName("Should set ID")
    void shouldSetId() {
        String expectedId = "test-vbox";
        VBox vbox = VBoxBuilder.create()
                .id(expectedId)
                .build();

        assertEquals(expectedId, vbox.getId());
    }

    @Test
    @DisplayName("Should set style")
    void shouldSetStyle() {
        String expectedStyle = "-fx-background-color: lightgray;";
        VBox vbox = VBoxBuilder.create()
                .style(expectedStyle)
                .build();

        assertEquals(expectedStyle, vbox.getStyle());
    }

    @Test
    @DisplayName("Should set visible property")
    void shouldSetVisibleProperty() {
        VBox vbox = VBoxBuilder.create()
                .visible(false)
                .build();

        assertFalse(vbox.isVisible());
    }

    @Test
    @DisplayName("Should set managed property")
    void shouldSetManagedProperty() {
        VBox vbox = VBoxBuilder.create()
                .managed(false)
                .build();

        assertFalse(vbox.isManaged());
    }

    @Test
    @DisplayName("Should set margin for child node")
    void shouldSetMarginForChildNode() {
        Button button = new Button("Test Button");
        Insets expectedMargin = new Insets(5, 10, 5, 10);

        VBox vbox = VBoxBuilder.create()
                .margin(button, expectedMargin)
                .children(button)
                .build();

        assertEquals(expectedMargin, VBox.getMargin(button));
    }

    @Test
    @DisplayName("Should set vgrow for child node")
    void shouldSetVgrowForChildNode() {
        Button button = new Button("Test Button");
        Priority expectedPriority = Priority.ALWAYS;

        VBox vbox = VBoxBuilder.create()
                .vgrow(button, expectedPriority)
                .children(button)
                .build();

        assertEquals(expectedPriority, VBox.getVgrow(button));
    }

    @Test
    @DisplayName("Should add children using children() method")
    void shouldAddChildrenUsingChildrenMethod() {
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Label label1 = new Label("Label 1");

        VBox vbox = VBoxBuilder.create()
                .children(button1, button2, label1)
                .build();

        assertEquals(3, vbox.getChildren().size());
        assertEquals(button1, vbox.getChildren().get(0));
        assertEquals(button2, vbox.getChildren().get(1));
        assertEquals(label1, vbox.getChildren().get(2));
    }

    @Test
    @DisplayName("Should replace children when children() method is called multiple times")
    void shouldReplaceChildrenWhenChildrenMethodCalledMultipleTimes() {
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Label label1 = new Label("Label 1");
        Label label2 = new Label("Label 2");

        VBox vbox = VBoxBuilder.create()
                .children(button1, button2)
                .children(label1, label2)
                .build();

        // Should only contain the last set of children
        assertEquals(2, vbox.getChildren().size());
        assertEquals(label1, vbox.getChildren().get(0));
        assertEquals(label2, vbox.getChildren().get(1));
        assertFalse(vbox.getChildren().contains(button1));
        assertFalse(vbox.getChildren().contains(button2));
    }

    @Test
    @DisplayName("Should create VBoxBuilder with children using withChildren() static method")
    void shouldCreateVBoxBuilderWithChildrenUsingWithChildrenStaticMethod() {
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Label label1 = new Label("Label 1");

        VBoxBuilder builder = VBoxBuilder.withChildren(button1, button2, label1);
        assertNotNull(builder);

        VBox vbox = builder.build();
        assertNotNull(vbox);
        assertEquals(3, vbox.getChildren().size());
        assertEquals(button1, vbox.getChildren().get(0));
        assertEquals(button2, vbox.getChildren().get(1));
        assertEquals(label1, vbox.getChildren().get(2));
    }

    @Test
    @DisplayName("Should create empty VBoxBuilder using withChildren() with no arguments")
    void shouldCreateEmptyVBoxBuilderUsingWithChildrenWithNoArguments() {
        VBoxBuilder builder = VBoxBuilder.withChildren();
        assertNotNull(builder);

        VBox vbox = builder.build();
        assertNotNull(vbox);
        assertEquals(0, vbox.getChildren().size());
    }

    @Test
    @DisplayName("Should create VBoxBuilder with single child using withChildren()")
    void shouldCreateVBoxBuilderWithSingleChildUsingWithChildren() {
        Button button = new Button("Single Button");

        VBoxBuilder builder = VBoxBuilder.withChildren(button);
        assertNotNull(builder);

        VBox vbox = builder.build();
        assertNotNull(vbox);
        assertEquals(1, vbox.getChildren().size());
        assertEquals(button, vbox.getChildren().get(0));
    }

    @Test
    @DisplayName("Should chain multiple builder methods")
    void shouldChainMultipleBuilderMethods() {
        Button button1 = new Button("Button 1");
        Label label1 = new Label("Label 1");
        double expectedSpacing = 10.0;
        String expectedId = "chained-vbox";
        Pos expectedAlignment = Pos.CENTER;

        VBox vbox = VBoxBuilder.create()
                .spacing(expectedSpacing)
                .alignment(expectedAlignment)
                .id(expectedId)
                .fillWidth(false)
                .children(button1, label1)
                .visible(true)
                .build();

        assertEquals(expectedSpacing, vbox.getSpacing(), 0.001);
        assertEquals(expectedAlignment, vbox.getAlignment());
        assertEquals(expectedId, vbox.getId());
        assertFalse(vbox.isFillWidth());
        assertEquals(2, vbox.getChildren().size());
        assertTrue(vbox.isVisible());
    }

    @Test
    @DisplayName("Should apply custom consumer function")
    void shouldApplyCustomConsumerFunction() {
        double customSpacing = 25.0;

        VBox vbox = VBoxBuilder.create()
                .apply(vb -> vb.setSpacing(customSpacing))
                .build();

        assertEquals(customSpacing, vbox.getSpacing(), 0.001);
    }

    @Test
    @DisplayName("Should create different instances on multiple build calls")
    void shouldCreateDifferentInstancesOnMultipleBuildCalls() {
        VBoxBuilder builder = VBoxBuilder.create().spacing(10.0);
        VBox firstBuild = builder.build();
        VBox secondBuild = builder.build();

        assertNotSame(firstBuild, secondBuild);
        assertEquals(firstBuild.getSpacing(), secondBuild.getSpacing(), 0.001);
    }

    @Test
    @DisplayName("Should allow independent modification of multiple instances from same builder")
    void shouldAllowIndependentModificationOfMultipleInstances() {
        Button sharedButton = new Button("Shared");

        VBoxBuilder builder = VBoxBuilder.create()
                .spacing(5.0)
                .children(sharedButton);

        VBox instance1 = builder.build();
        VBox instance2 = builder.build();
        VBox instance3 = builder.build();

        // All instances should start with same properties
        assertNotSame(instance1, instance2);
        assertNotSame(instance2, instance3);
        assertEquals(5.0, instance1.getSpacing(), 0.001);
        assertEquals(5.0, instance2.getSpacing(), 0.001);
        assertEquals(5.0, instance3.getSpacing(), 0.001);
        // The button cannot be shared. The button move to the last parent.
        assertEquals(0, instance1.getChildren().size());
        assertEquals(0, instance2.getChildren().size());
        assertEquals(1, instance3.getChildren().size());

        // Modify each instance independently
        instance1.setSpacing(10.0);
        instance2.setSpacing(15.0);
        instance3.getChildren().clear();

        // Each instance should maintain its own state
        assertEquals(10.0, instance1.getSpacing(), 0.001);
        assertEquals(15.0, instance2.getSpacing(), 0.001);
        assertEquals(5.0, instance3.getSpacing(), 0.001);
    }

    @Test
    @DisplayName("Should support delayed initialization with parameterized constructor")
    void shouldSupportDelayedInitializationWithParameterizedConstructor() {
        double constructorSpacing = 12.0;
        VBoxBuilder builder = VBoxBuilder.create(constructorSpacing)
                .alignment(Pos.CENTER)
                .fillWidth(false);

        VBox instance1 = builder.build();
        VBox instance2 = builder.build();

        assertNotSame(instance1, instance2);
        assertEquals(constructorSpacing, instance1.getSpacing(), 0.001);
        assertEquals(constructorSpacing, instance2.getSpacing(), 0.001);
        assertEquals(Pos.CENTER, instance1.getAlignment());
        assertEquals(Pos.CENTER, instance2.getAlignment());
        assertFalse(instance1.isFillWidth());
        assertFalse(instance2.isFillWidth());

        // Modify one instance - shouldn't affect the other
        instance1.setSpacing(20.0);
        assertEquals(20.0, instance1.getSpacing(), 0.001);
        assertEquals(constructorSpacing, instance2.getSpacing(), 0.001);
    }

    @Test
    @DisplayName("Should handle null children gracefully")
    void shouldHandleNullChildrenGracefully() {
        assertDoesNotThrow(() -> {
            VBox vbox = VBoxBuilder.create()
                    .children((Node[]) null)
                    .build();
            assertNotNull(vbox);
            // children() with null should clear the children list
            assertEquals(0, vbox.getChildren().size());
        });
    }

    @Test
    @DisplayName("Should handle mixed null and valid children")
    void shouldHandleMixedNullAndValidChildren() {
        Button validButton = new Button("Valid");

        assertDoesNotThrow(() -> {
            VBox vbox = VBoxBuilder.create()
                    .children(validButton, null, new Label("Valid Label"))
                    .build();
            assertNotNull(vbox);
            // Should contain non-null children
            assertTrue(vbox.getChildren().contains(validButton));
            assertTrue(vbox.getChildren().stream()
                    .anyMatch(child -> child instanceof Label && "Valid Label".equals(((Label) child).getText())));
        });
    }

    @Test
    @DisplayName("Should verify array import works correctly - Node array parameter should import Node class")
    void shouldVerifyArrayImportWorksCorrectly() {
        // This test verifies that the code compiles correctly, which means
        // the import logic correctly imported Node class instead of Node[]
        Button button = new Button("Test");
        Label label = new Label("Test");
        Node[] nodeArray = { button, label };

        // If the import logic is working correctly, this should compile and run
        assertDoesNotThrow(() -> {
            VBox vbox1 = VBoxBuilder.create(nodeArray).build();
            assertNotNull(vbox1);
            assertEquals(2, vbox1.getChildren().size());
        });
    }
}