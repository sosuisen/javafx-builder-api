package io.github.sosuisen.jfxbuilder.controls;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

// Use TextFX
@ExtendWith(ApplicationExtension.class)
class ButtonBuilderTest {

    @Test
    @DisplayName("Should create ButtonBuilder with default constructor")
    void shouldCreateButtonBuilderWithDefaultConstructor() {
        ButtonBuilder builder = ButtonBuilder.create();
        assertNotNull(builder);

        Button button = builder.build();
        assertNotNull(button);
        assertEquals("", button.getText());
    }

    @Test
    @DisplayName("Should create ButtonBuilder with text parameter")
    void shouldCreateButtonBuilderWithText() {
        String expectedText = "Test Button";
        ButtonBuilder builder = ButtonBuilder.create(expectedText);
        assertNotNull(builder);

        Button button = builder.build();
        assertNotNull(button);
        assertEquals(expectedText, button.getText());
    }

    @Test
    @DisplayName("Should create ButtonBuilder with text and graphic parameters")
    void shouldCreateButtonBuilderWithTextAndGraphic() {
        String expectedText = "Test Button";
        Button graphic = new Button("graphic");

        ButtonBuilder builder = ButtonBuilder.create(expectedText, graphic);
        assertNotNull(builder);

        Button button = builder.build();
        assertNotNull(button);
        assertEquals(expectedText, button.getText());
        assertEquals(graphic, button.getGraphic());
    }

    @Test
    @DisplayName("Should set text property")
    void shouldSetTextProperty() {
        String expectedText = "Updated Text";
        Button button = ButtonBuilder.create()
                .text(expectedText)
                .build();

        assertEquals(expectedText, button.getText());
    }

    @Test
    @DisplayName("Should set cancel button property")
    void shouldSetCancelButtonProperty() {
        Button button = ButtonBuilder.create()
                .cancelButton(true)
                .build();

        assertTrue(button.isCancelButton());
    }

    @Test
    @DisplayName("Should set default button property")
    void shouldSetDefaultButtonProperty() {
        Button button = ButtonBuilder.create()
                .defaultButton(true)
                .build();

        assertTrue(button.isDefaultButton());
    }

    @Test
    @DisplayName("Should set action handler")
    void shouldSetActionHandler() {
        boolean[] actionCalled = { false };
        EventHandler<ActionEvent> handler = e -> actionCalled[0] = true;

        Button button = ButtonBuilder.create()
                .onAction(handler)
                .build();

        assertEquals(handler, button.getOnAction());
    }

    @Test
    @DisplayName("Should set mnemonic parsing")
    void shouldSetMnemonicParsing() {
        Button button = ButtonBuilder.create()
                .mnemonicParsing(false)
                .build();

        assertFalse(button.isMnemonicParsing());
    }

    @Test
    @DisplayName("Should set font")
    void shouldSetFont() {
        Font expectedFont = Font.font("Arial", 14);
        Button button = ButtonBuilder.create()
                .font(expectedFont)
                .build();

        assertEquals(expectedFont, button.getFont());
    }

    @Test
    @DisplayName("Should set content display")
    void shouldSetContentDisplay() {
        ContentDisplay expectedDisplay = ContentDisplay.TOP;
        Button button = ButtonBuilder.create()
                .contentDisplay(expectedDisplay)
                .build();

        assertEquals(expectedDisplay, button.getContentDisplay());
    }

    @Test
    @DisplayName("Should set underline")
    void shouldSetUnderline() {
        Button button = ButtonBuilder.create()
                .underline(true)
                .build();

        assertTrue(button.isUnderline());
    }

    @Test
    @DisplayName("Should set wrap text")
    void shouldSetWrapText() {
        Button button = ButtonBuilder.create()
                .wrapText(true)
                .build();

        assertTrue(button.isWrapText());
    }

    @Test
    @DisplayName("Should set graphic text gap")
    void shouldSetGraphicTextGap() {
        double expectedGap = 10.0;
        Button button = ButtonBuilder.create()
                .graphicTextGap(expectedGap)
                .build();

        assertEquals(expectedGap, button.getGraphicTextGap(), 0.001);
    }

    @Test
    @DisplayName("Should set ellipsis string")
    void shouldSetEllipsisString() {
        String expectedEllipsis = "...";
        Button button = ButtonBuilder.create()
                .ellipsisString(expectedEllipsis)
                .build();

        assertEquals(expectedEllipsis, button.getEllipsisString());
    }

    @Test
    @DisplayName("Should set line spacing")
    void shouldSetLineSpacing() {
        double expectedSpacing = 5.0;
        Button button = ButtonBuilder.create()
                .lineSpacing(expectedSpacing)
                .build();

        assertEquals(expectedSpacing, button.getLineSpacing(), 0.001);
    }

    @Test
    @DisplayName("Should set text alignment")
    void shouldSetTextAlignment() {
        TextAlignment expectedAlignment = TextAlignment.CENTER;
        Button button = ButtonBuilder.create()
                .textAlignment(expectedAlignment)
                .build();

        assertEquals(expectedAlignment, button.getTextAlignment());
    }

    @Test
    @DisplayName("Should set alignment")
    void shouldSetAlignment() {
        Pos expectedAlignment = Pos.CENTER_RIGHT;
        Button button = ButtonBuilder.create()
                .alignment(expectedAlignment)
                .build();

        assertEquals(expectedAlignment, button.getAlignment());
    }

    @Test
    @DisplayName("Should set text fill")
    void shouldSetTextFill() {
        Color expectedColor = Color.RED;
        Button button = ButtonBuilder.create()
                .textFill(expectedColor)
                .build();

        assertEquals(expectedColor, button.getTextFill());
    }

    @Test
    @DisplayName("Should set size properties")
    void shouldSetSizeProperties() {
        double expectedWidth = 200.0;
        double expectedHeight = 50.0;

        Button button = ButtonBuilder.create()
                .prefWidth(expectedWidth)
                .prefHeight(expectedHeight)
                .build();

        assertEquals(expectedWidth, button.getPrefWidth(), 0.001);
        assertEquals(expectedHeight, button.getPrefHeight(), 0.001);
    }

    @Test
    @DisplayName("Should set padding")
    void shouldSetPadding() {
        Insets expectedPadding = new Insets(10, 15, 10, 15);
        Button button = ButtonBuilder.create()
                .padding(expectedPadding)
                .build();

        assertEquals(expectedPadding, button.getPadding());
    }

    @Test
    @DisplayName("Should set cursor")
    void shouldSetCursor() {
        Cursor expectedCursor = Cursor.HAND;
        Button button = ButtonBuilder.create()
                .cursor(expectedCursor)
                .build();

        assertEquals(expectedCursor, button.getCursor());
    }

    @Test
    @DisplayName("Should set disable property")
    void shouldSetDisableProperty() {
        Button button = ButtonBuilder.create()
                .disable(true)
                .build();

        assertTrue(button.isDisable());
    }

    @Test
    @DisplayName("Should set ID")
    void shouldSetId() {
        String expectedId = "test-button";
        Button button = ButtonBuilder.create()
                .id(expectedId)
                .build();

        assertEquals(expectedId, button.getId());
    }

    @Test
    @DisplayName("Should set style")
    void shouldSetStyle() {
        String expectedStyle = "-fx-background-color: blue;";
        Button button = ButtonBuilder.create()
                .style(expectedStyle)
                .build();

        assertEquals(expectedStyle, button.getStyle());
    }

    @Test
    @DisplayName("Should set opacity")
    void shouldSetOpacity() {
        double expectedOpacity = 0.7;
        Button button = ButtonBuilder.create()
                .opacity(expectedOpacity)
                .build();

        assertEquals(expectedOpacity, button.getOpacity(), 0.001);
    }

    @Test
    @DisplayName("Should set visible property")
    void shouldSetVisibleProperty() {
        Button button = ButtonBuilder.create()
                .visible(false)
                .build();

        assertFalse(button.isVisible());
    }

    @Test
    @DisplayName("Should set managed property")
    void shouldSetManagedProperty() {
        Button button = ButtonBuilder.create()
                .managed(false)
                .build();

        assertFalse(button.isManaged());
    }

    @Test
    @DisplayName("Should chain multiple builder methods")
    void shouldChainMultipleBuilderMethods() {
        String expectedText = "Chained Button";
        String expectedId = "chained-button";
        double expectedWidth = 150.0;

        Button button = ButtonBuilder.create()
                .text(expectedText)
                .id(expectedId)
                .prefWidth(expectedWidth)
                .defaultButton(true)
                .visible(true)
                .build();

        assertEquals(expectedText, button.getText());
        assertEquals(expectedId, button.getId());
        assertEquals(expectedWidth, button.getPrefWidth(), 0.001);
        assertTrue(button.isDefaultButton());
        assertTrue(button.isVisible());
    }

    @Test
    @DisplayName("Should apply custom consumer function")
    void shouldApplyCustomConsumerFunction() {
        String customText = "Custom Function";

        Button button = ButtonBuilder.create()
                .apply(btn -> btn.setText(customText))
                .build();

        assertEquals(customText, button.getText());
    }

    @Test
    @DisplayName("Should create different instances on multiple build calls - delayed initialization")
    void shouldCreateDifferentInstancesOnMultipleBuildCalls() {
        ButtonBuilder builder = ButtonBuilder.create().text("Test");
        Button firstBuild = builder.build();
        Button secondBuild = builder.build();

        assertNotSame(firstBuild, secondBuild);
        assertEquals(firstBuild.getText(), secondBuild.getText());
    }

    @Test
    @DisplayName("Should allow independent modification of multiple instances from same builder")
    void shouldAllowIndependentModificationOfMultipleInstances() {
        ButtonBuilder builder = ButtonBuilder.create()
                .text("Original Text")
                .prefWidth(100.0);

        Button instance1 = builder.build();
        Button instance2 = builder.build();
        Button instance3 = builder.build();

        // All instances should start with same properties
        assertNotSame(instance1, instance2);
        assertNotSame(instance2, instance3);
        assertEquals("Original Text", instance1.getText());
        assertEquals("Original Text", instance2.getText());
        assertEquals("Original Text", instance3.getText());
        assertEquals(100.0, instance1.getPrefWidth(), 0.001);
        assertEquals(100.0, instance2.getPrefWidth(), 0.001);
        assertEquals(100.0, instance3.getPrefWidth(), 0.001);

        // Modify each instance independently
        instance1.setText("Modified Instance 1");
        instance2.setText("Modified Instance 2");
        instance3.setPrefWidth(200.0);

        // Each instance should maintain its own state
        assertEquals("Modified Instance 1", instance1.getText());
        assertEquals("Modified Instance 2", instance2.getText());
        assertEquals("Original Text", instance3.getText());
        assertEquals(100.0, instance1.getPrefWidth(), 0.001);
        assertEquals(100.0, instance2.getPrefWidth(), 0.001);
        assertEquals(200.0, instance3.getPrefWidth(), 0.001);
    }

    @Test
    @DisplayName("Should support delayed initialization with multiple instances from parameterized constructor")
    void shouldSupportDelayedInitializationWithMultipleInstancesFromParameterizedConstructor() {
        String constructorText = "Constructor Text";
        ButtonBuilder builder = ButtonBuilder.create(constructorText)
                .defaultButton(true)
                .prefWidth(150.0);

        Button instance1 = builder.build();
        Button instance2 = builder.build();

        assertNotSame(instance1, instance2);
        assertEquals(constructorText, instance1.getText());
        assertEquals(constructorText, instance2.getText());
        assertTrue(instance1.isDefaultButton());
        assertTrue(instance2.isDefaultButton());
        assertEquals(150.0, instance1.getPrefWidth(), 0.001);
        assertEquals(150.0, instance2.getPrefWidth(), 0.001);

        // Modify one instance - shouldn't affect the other
        instance1.setText("Modified");
        assertEquals("Modified", instance1.getText());
        assertEquals(constructorText, instance2.getText());
    }

    @Test
    @DisplayName("Should create multiple instances with complex builder operations")
    void shouldCreateMultipleInstancesWithComplexBuilderOperations() {
        ButtonBuilder builder = ButtonBuilder.create("Shared Button")
                .defaultButton(true)
                .prefWidth(200.0)
                .prefHeight(50.0)
                .visible(true)
                .apply(btn -> btn.setOpacity(0.9))
                .style("-fx-background-color: blue;")
                .id("shared-button");

        Button[] instances = new Button[5];
        for (int i = 0; i < 5; i++) {
            instances[i] = builder.build();
        }

        // All instances should be different objects but have same properties
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                assertNotSame(instances[i], instances[j]);
            }
            assertEquals("Shared Button", instances[i].getText());
            assertTrue(instances[i].isDefaultButton());
            assertEquals(200.0, instances[i].getPrefWidth(), 0.001);
            assertEquals(50.0, instances[i].getPrefHeight(), 0.001);
            assertTrue(instances[i].isVisible());
            assertEquals(0.9, instances[i].getOpacity(), 0.001);
            assertEquals("-fx-background-color: blue;", instances[i].getStyle());
            assertEquals("shared-button", instances[i].getId());
        }

        // Modify each instance uniquely
        for (int i = 0; i < 5; i++) {
            instances[i].setText("Button " + i);
            instances[i].setPrefWidth(100 + (i * 50));
        }

        // Verify independent modifications
        for (int i = 0; i < 5; i++) {
            assertEquals("Button " + i, instances[i].getText());
            assertEquals(100 + (i * 50), instances[i].getPrefWidth(), 0.001);
        }
    }

    @Test
    @DisplayName("Should handle null parameters gracefully")
    void shouldHandleNullParametersGracefully() {
        assertDoesNotThrow(() -> {
            Button button = ButtonBuilder.create()
                    .text(null)
                    .id(null)
                    .style(null)
                    .build();
            assertNotNull(button);
        });
    }

    @Test
    @DisplayName("Should add CSS stylesheet text")
    void shouldAddCssStylesheetText() {
        String cssText = ".my-button { -fx-text-fill: white; -fx-background-color: red; }";
        
        Button button = ButtonBuilder.create()
                .text("Test Button")
                .addStylesheetsText(cssText)
                .build();

        assertNotNull(button);
        assertEquals("Test Button", button.getText());
        
        // Verify that the stylesheet was added
        assertFalse(button.getStylesheets().isEmpty());
        assertEquals(1, button.getStylesheets().size());
        
        String addedStylesheet = button.getStylesheets().get(0);
        assertTrue(addedStylesheet.startsWith("data:text/css;base64,"));
        
        // Decode and verify the CSS content
        String base64Part = addedStylesheet.substring("data:text/css;base64,".length());
        String decodedCss = new String(java.util.Base64.getDecoder().decode(base64Part));
        assertEquals(cssText, decodedCss);
    }

    @Test
    @DisplayName("Should chain addStylesheetsText with other methods")
    void shouldChainAddStylesheetsTextWithOtherMethods() {
        String cssText = ".my-button { -fx-font-size: 16px; }";
        String expectedText = "Styled Button";
        String expectedId = "styled-button";
        
        Button button = ButtonBuilder.create()
                .text(expectedText)
                .id(expectedId)
                .addStylesheetsText(cssText)
                .prefWidth(200.0)
                .build();

        assertEquals(expectedText, button.getText());
        assertEquals(expectedId, button.getId());
        assertEquals(200.0, button.getPrefWidth(), 0.001);
        assertEquals(1, button.getStylesheets().size());
        
        String addedStylesheet = button.getStylesheets().get(0);
        assertTrue(addedStylesheet.startsWith("data:text/css;base64,"));
    }
}