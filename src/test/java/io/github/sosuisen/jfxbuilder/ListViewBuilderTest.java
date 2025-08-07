package io.github.sosuisen.jfxbuilder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class ListViewBuilderTest {

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
    @DisplayName("Should create ListViewBuilder with default constructor")
    void shouldCreateListViewBuilderWithDefaultConstructor() {
        ListViewBuilder<String> builder = ListViewBuilder.create();
        assertNotNull(builder);

        ListView<String> listView = builder.build();
        assertNotNull(listView);
        assertNotNull(listView.getItems());
        assertEquals(0, listView.getItems().size());
    }

    @Test
    @DisplayName("Should create ListViewBuilder with items parameter")
    void shouldCreateListViewBuilderWithItems() {
        ObservableList<String> items = FXCollections.observableArrayList("Item 1", "Item 2", "Item 3");
        ListViewBuilder<String> builder = ListViewBuilder.create(items);
        assertNotNull(builder);

        ListView<String> listView = builder.build();
        assertNotNull(listView);
        assertEquals(items, listView.getItems());
        assertEquals(3, listView.getItems().size());
    }

    @Test
    @DisplayName("Should set items property")
    void shouldSetItemsProperty() {
        ObservableList<String> items = FXCollections.observableArrayList("Test 1", "Test 2");
        ListView<String> listView = ListViewBuilder.<String>create()
                .items(items)
                .build();

        assertEquals(items, listView.getItems());
        assertEquals(2, listView.getItems().size());
    }

    @Test
    @DisplayName("Should set orientation property")
    void shouldSetOrientationProperty() {
        Orientation expectedOrientation = Orientation.HORIZONTAL;
        ListView<String> listView = ListViewBuilder.<String>create()
                .orientation(expectedOrientation)
                .build();

        assertEquals(expectedOrientation, listView.getOrientation());
    }

    @Test
    @DisplayName("Should set editable property")
    void shouldSetEditableProperty() {
        ListView<String> listView = ListViewBuilder.<String>create()
                .editable(true)
                .build();

        assertTrue(listView.isEditable());
    }

    @Test
    @DisplayName("Should set fixedCellSize property")
    void shouldSetFixedCellSizeProperty() {
        double expectedCellSize = 50.0;
        ListView<String> listView = ListViewBuilder.<String>create()
                .fixedCellSize(expectedCellSize)
                .build();

        assertEquals(expectedCellSize, listView.getFixedCellSize(), 0.001);
    }

    @Test
    @DisplayName("Should set placeholder property")
    void shouldSetPlaceholderProperty() {
        Label placeholder = new Label("No items available");
        ListView<String> listView = ListViewBuilder.<String>create()
                .placeholder(placeholder)
                .build();

        assertEquals(placeholder, listView.getPlaceholder());
    }

    @Test
    @DisplayName("Should set size properties")
    void shouldSetSizeProperties() {
        double expectedWidth = 300.0;
        double expectedHeight = 200.0;

        ListView<String> listView = ListViewBuilder.<String>create()
                .prefWidth(expectedWidth)
                .prefHeight(expectedHeight)
                .build();

        assertEquals(expectedWidth, listView.getPrefWidth(), 0.001);
        assertEquals(expectedHeight, listView.getPrefHeight(), 0.001);
    }

    @Test
    @DisplayName("Should set ID")
    void shouldSetId() {
        String expectedId = "test-listview";
        ListView<String> listView = ListViewBuilder.<String>create()
                .id(expectedId)
                .build();

        assertEquals(expectedId, listView.getId());
    }

    @Test
    @DisplayName("Should set style")
    void shouldSetStyle() {
        String expectedStyle = "-fx-background-color: lightblue;";
        ListView<String> listView = ListViewBuilder.<String>create()
                .style(expectedStyle)
                .build();

        assertEquals(expectedStyle, listView.getStyle());
    }

    @Test
    @DisplayName("Should set visible property")
    void shouldSetVisibleProperty() {
        ListView<String> listView = ListViewBuilder.<String>create()
                .visible(false)
                .build();

        assertFalse(listView.isVisible());
    }

    @Test
    @DisplayName("Should set managed property")
    void shouldSetManagedProperty() {
        ListView<String> listView = ListViewBuilder.<String>create()
                .managed(false)
                .build();

        assertFalse(listView.isManaged());
    }

    @Test
    @DisplayName("Should chain multiple builder methods")
    void shouldChainMultipleBuilderMethods() {
        ObservableList<String> items = FXCollections.observableArrayList("Item A", "Item B");
        String expectedId = "chained-listview";
        Orientation expectedOrientation = Orientation.VERTICAL;
        double expectedCellSize = 30.0;

        ListView<String> listView = ListViewBuilder.<String>create()
                .items(items)
                .orientation(expectedOrientation)
                .id(expectedId)
                .fixedCellSize(expectedCellSize)
                .editable(false)
                .visible(true)
                .build();

        assertEquals(items, listView.getItems());
        assertEquals(expectedOrientation, listView.getOrientation());
        assertEquals(expectedId, listView.getId());
        assertEquals(expectedCellSize, listView.getFixedCellSize(), 0.001);
        assertFalse(listView.isEditable());
        assertTrue(listView.isVisible());
    }

    @Test
    @DisplayName("Should apply custom consumer function")
    void shouldApplyCustomConsumerFunction() {
        double customCellSize = 75.0;

        ListView<String> listView = ListViewBuilder.<String>create()
                .apply(lv -> lv.setFixedCellSize(customCellSize))
                .build();

        assertEquals(customCellSize, listView.getFixedCellSize(), 0.001);
    }

    @Test
    @DisplayName("Should create different instances on multiple build calls")
    void shouldCreateDifferentInstancesOnMultipleBuildCalls() {
        ListViewBuilder<String> builder = ListViewBuilder.<String>create().fixedCellSize(25.0);
        ListView<String> firstBuild = builder.build();
        ListView<String> secondBuild = builder.build();

        assertNotSame(firstBuild, secondBuild);
        assertEquals(firstBuild.getFixedCellSize(), secondBuild.getFixedCellSize(), 0.001);
    }

    @Test
    @DisplayName("Should allow independent modification of multiple instances from same builder")
    void shouldAllowIndependentModificationOfMultipleInstances() {
        ObservableList<String> items = FXCollections.observableArrayList("Shared Item");

        ListViewBuilder<String> builder = ListViewBuilder.<String>create()
                .fixedCellSize(20.0)
                .items(items);

        ListView<String> instance1 = builder.build();
        ListView<String> instance2 = builder.build();
        ListView<String> instance3 = builder.build();

        // All instances should start with same properties
        assertNotSame(instance1, instance2);
        assertNotSame(instance2, instance3);
        assertEquals(20.0, instance1.getFixedCellSize(), 0.001);
        assertEquals(20.0, instance2.getFixedCellSize(), 0.001);
        assertEquals(20.0, instance3.getFixedCellSize(), 0.001);
        assertEquals(items, instance1.getItems());
        assertEquals(items, instance2.getItems());
        assertEquals(items, instance3.getItems());

        // Modify each instance independently
        instance1.setFixedCellSize(30.0);
        instance2.setFixedCellSize(40.0);
        instance3.getItems().clear();

        // Each instance should maintain its own state
        assertEquals(30.0, instance1.getFixedCellSize(), 0.001);
        assertEquals(40.0, instance2.getFixedCellSize(), 0.001);
        assertEquals(20.0, instance3.getFixedCellSize(), 0.001);
        assertEquals(0, instance1.getItems().size());
        assertEquals(0, instance2.getItems().size());
        assertEquals(0, instance3.getItems().size());
    }

    @Test
    @DisplayName("Should support delayed initialization with parameterized constructor")
    void shouldSupportDelayedInitializationWithParameterizedConstructor() {
        ObservableList<String> constructorItems = FXCollections.observableArrayList("Constructor Item");
        ListViewBuilder<String> builder = ListViewBuilder.create(constructorItems)
                .orientation(Orientation.HORIZONTAL)
                .editable(true);

        ListView<String> instance1 = builder.build();
        ListView<String> instance2 = builder.build();

        assertNotSame(instance1, instance2);
        assertEquals(constructorItems, instance1.getItems());
        assertEquals(constructorItems, instance2.getItems());
        assertEquals(Orientation.HORIZONTAL, instance1.getOrientation());
        assertEquals(Orientation.HORIZONTAL, instance2.getOrientation());
        assertTrue(instance1.isEditable());
        assertTrue(instance2.isEditable());

        // Modify one instance - shouldn't affect the other
        instance1.setOrientation(Orientation.VERTICAL);
        assertEquals(Orientation.VERTICAL, instance1.getOrientation());
        assertEquals(Orientation.HORIZONTAL, instance2.getOrientation());
    }

    @Test
    @DisplayName("Should handle null items gracefully")
    void shouldHandleNullItemsGracefully() {
        assertDoesNotThrow(() -> {
            ListView<String> listView = ListViewBuilder.<String>create()
                    .items(null)
                    .build();
            assertNotNull(listView);
            assertNull(listView.getItems());
        });
    }

    @Test
    @DisplayName("Should work with different generic types")
    void shouldWorkWithDifferentGenericTypes() {
        ObservableList<Integer> intItems = FXCollections.observableArrayList(1, 2, 3, 4, 5);
        ListView<Integer> intListView = ListViewBuilder.<Integer>create(intItems)
                .fixedCellSize(25.0)
                .build();

        assertNotNull(intListView);
        assertEquals(intItems, intListView.getItems());
        assertEquals(25.0, intListView.getFixedCellSize(), 0.001);
        assertEquals(5, intListView.getItems().size());
    }
}