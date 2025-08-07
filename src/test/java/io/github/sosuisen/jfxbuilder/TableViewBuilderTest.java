package io.github.sosuisen.jfxbuilder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class TableViewBuilderTest {

    // Test data class
    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

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
    @DisplayName("Should create TableViewBuilder with default constructor")
    void shouldCreateTableViewBuilderWithDefaultConstructor() {
        TableViewBuilder<Person> builder = TableViewBuilder.create();
        assertNotNull(builder);

        TableView<Person> tableView = builder.build();
        assertNotNull(tableView);
        assertNotNull(tableView.getItems());
        assertEquals(0, tableView.getItems().size());
        assertEquals(0, tableView.getColumns().size());
    }

    @Test
    @DisplayName("Should create TableViewBuilder with items parameter")
    void shouldCreateTableViewBuilderWithItems() {
        ObservableList<Person> items = FXCollections.observableArrayList(
                new Person("John", 25),
                new Person("Jane", 30),
                new Person("Bob", 35));
        TableViewBuilder<Person> builder = TableViewBuilder.create(items);
        assertNotNull(builder);

        TableView<Person> tableView = builder.build();
        assertNotNull(tableView);
        assertEquals(items, tableView.getItems());
        assertEquals(3, tableView.getItems().size());
    }

    @Test
    @DisplayName("Should set items property")
    void shouldSetItemsProperty() {
        ObservableList<Person> items = FXCollections.observableArrayList(
                new Person("Alice", 28),
                new Person("Charlie", 32));
        TableView<Person> tableView = TableViewBuilder.<Person>create()
                .items(items)
                .build();

        assertEquals(items, tableView.getItems());
        assertEquals(2, tableView.getItems().size());
    }

    @Test
    @DisplayName("Should set editable property")
    void shouldSetEditableProperty() {
        TableView<Person> tableView = TableViewBuilder.<Person>create()
                .editable(true)
                .build();

        assertTrue(tableView.isEditable());
    }

    @Test
    @DisplayName("Should set fixedCellSize property")
    void shouldSetFixedCellSizeProperty() {
        double expectedCellSize = 40.0;
        TableView<Person> tableView = TableViewBuilder.<Person>create()
                .fixedCellSize(expectedCellSize)
                .build();

        assertEquals(expectedCellSize, tableView.getFixedCellSize(), 0.001);
    }

    @Test
    @DisplayName("Should set placeholder property")
    void shouldSetPlaceholderProperty() {
        Label placeholder = new Label("No data available");
        TableView<Person> tableView = TableViewBuilder.<Person>create()
                .placeholder(placeholder)
                .build();

        assertEquals(placeholder, tableView.getPlaceholder());
    }

    @Test
    @DisplayName("Should set tableMenuButtonVisible property")
    void shouldSetTableMenuButtonVisibleProperty() {
        TableView<Person> tableView = TableViewBuilder.<Person>create()
                .tableMenuButtonVisible(true)
                .build();

        assertTrue(tableView.isTableMenuButtonVisible());
    }

    @Test
    @DisplayName("Should set size properties")
    void shouldSetSizeProperties() {
        double expectedWidth = 400.0;
        double expectedHeight = 300.0;

        TableView<Person> tableView = TableViewBuilder.<Person>create()
                .prefWidth(expectedWidth)
                .prefHeight(expectedHeight)
                .build();

        assertEquals(expectedWidth, tableView.getPrefWidth(), 0.001);
        assertEquals(expectedHeight, tableView.getPrefHeight(), 0.001);
    }

    @Test
    @DisplayName("Should set ID")
    void shouldSetId() {
        String expectedId = "test-tableview";
        TableView<Person> tableView = TableViewBuilder.<Person>create()
                .id(expectedId)
                .build();

        assertEquals(expectedId, tableView.getId());
    }

    @Test
    @DisplayName("Should set style")
    void shouldSetStyle() {
        String expectedStyle = "-fx-background-color: lightgray;";
        TableView<Person> tableView = TableViewBuilder.<Person>create()
                .style(expectedStyle)
                .build();

        assertEquals(expectedStyle, tableView.getStyle());
    }

    @Test
    @DisplayName("Should set visible property")
    void shouldSetVisibleProperty() {
        TableView<Person> tableView = TableViewBuilder.<Person>create()
                .visible(false)
                .build();

        assertFalse(tableView.isVisible());
    }

    @Test
    @DisplayName("Should set managed property")
    void shouldSetManagedProperty() {
        TableView<Person> tableView = TableViewBuilder.<Person>create()
                .managed(false)
                .build();

        assertFalse(tableView.isManaged());
    }

    @Test
    @DisplayName("Should chain multiple builder methods")
    void shouldChainMultipleBuilderMethods() {
        ObservableList<Person> items = FXCollections.observableArrayList(
                new Person("David", 40),
                new Person("Emma", 35));
        String expectedId = "chained-tableview";
        double expectedCellSize = 45.0;

        TableView<Person> tableView = TableViewBuilder.<Person>create()
                .items(items)
                .id(expectedId)
                .fixedCellSize(expectedCellSize)
                .editable(true)
                .tableMenuButtonVisible(false)
                .visible(true)
                .build();

        assertEquals(items, tableView.getItems());
        assertEquals(expectedId, tableView.getId());
        assertEquals(expectedCellSize, tableView.getFixedCellSize(), 0.001);
        assertTrue(tableView.isEditable());
        assertFalse(tableView.isTableMenuButtonVisible());
        assertTrue(tableView.isVisible());
    }

    @Test
    @DisplayName("Should apply custom consumer function")
    void shouldApplyCustomConsumerFunction() {
        double customCellSize = 55.0;

        TableView<Person> tableView = TableViewBuilder.<Person>create()
                .apply(tv -> tv.setFixedCellSize(customCellSize))
                .build();

        assertEquals(customCellSize, tableView.getFixedCellSize(), 0.001);
    }

    @Test
    @DisplayName("Should create different instances on multiple build calls")
    void shouldCreateDifferentInstancesOnMultipleBuildCalls() {
        TableViewBuilder<Person> builder = TableViewBuilder.<Person>create().fixedCellSize(30.0);
        TableView<Person> firstBuild = builder.build();
        TableView<Person> secondBuild = builder.build();

        assertNotSame(firstBuild, secondBuild);
        assertEquals(firstBuild.getFixedCellSize(), secondBuild.getFixedCellSize(), 0.001);
    }

    @Test
    @DisplayName("Should allow independent modification of multiple instances from same builder")
    void shouldAllowIndependentModificationOfMultipleInstances() {
        ObservableList<Person> items = FXCollections.observableArrayList(new Person("Shared", 50));

        TableViewBuilder<Person> builder = TableViewBuilder.<Person>create()
                .fixedCellSize(25.0)
                .items(items);

        TableView<Person> instance1 = builder.build();
        TableView<Person> instance2 = builder.build();
        TableView<Person> instance3 = builder.build();

        // All instances should start with same properties
        assertNotSame(instance1, instance2);
        assertNotSame(instance2, instance3);
        assertEquals(25.0, instance1.getFixedCellSize(), 0.001);
        assertEquals(25.0, instance2.getFixedCellSize(), 0.001);
        assertEquals(25.0, instance3.getFixedCellSize(), 0.001);
        assertEquals(items, instance1.getItems());
        assertEquals(items, instance2.getItems());
        assertEquals(items, instance3.getItems());

        // Modify each instance independently
        instance1.setFixedCellSize(35.0);
        instance2.setFixedCellSize(45.0);
        instance3.getItems().clear();

        // Each instance should maintain its own state
        assertEquals(35.0, instance1.getFixedCellSize(), 0.001);
        assertEquals(45.0, instance2.getFixedCellSize(), 0.001);
        assertEquals(25.0, instance3.getFixedCellSize(), 0.001);
        assertEquals(0, instance1.getItems().size());
        assertEquals(0, instance2.getItems().size());
        assertEquals(0, instance3.getItems().size());
    }

    @Test
    @DisplayName("Should support delayed initialization with parameterized constructor")
    void shouldSupportDelayedInitializationWithParameterizedConstructor() {
        ObservableList<Person> constructorItems = FXCollections.observableArrayList(new Person("Constructor", 60));
        TableViewBuilder<Person> builder = TableViewBuilder.create(constructorItems)
                .editable(true)
                .tableMenuButtonVisible(false);

        TableView<Person> instance1 = builder.build();
        TableView<Person> instance2 = builder.build();

        assertNotSame(instance1, instance2);
        assertEquals(constructorItems, instance1.getItems());
        assertEquals(constructorItems, instance2.getItems());
        assertTrue(instance1.isEditable());
        assertTrue(instance2.isEditable());
        assertFalse(instance1.isTableMenuButtonVisible());
        assertFalse(instance2.isTableMenuButtonVisible());

        // Modify one instance - shouldn't affect the other
        instance1.setEditable(false);
        assertFalse(instance1.isEditable());
        assertTrue(instance2.isEditable());
    }

    @Test
    @DisplayName("Should handle null items gracefully")
    void shouldHandleNullItemsGracefully() {
        assertDoesNotThrow(() -> {
            TableView<Person> tableView = TableViewBuilder.<Person>create()
                    .items(null)
                    .build();
            assertNotNull(tableView);
            assertNull(tableView.getItems());
        });
    }

    @Test
    @DisplayName("Should work with different generic types")
    void shouldWorkWithDifferentGenericTypes() {
        ObservableList<String> stringItems = FXCollections.observableArrayList("Item1", "Item2", "Item3");
        TableView<String> stringTableView = TableViewBuilder.<String>create(stringItems)
                .fixedCellSize(35.0)
                .build();

        assertNotNull(stringTableView);
        assertEquals(stringItems, stringTableView.getItems());
        assertEquals(35.0, stringTableView.getFixedCellSize(), 0.001);
        assertEquals(3, stringTableView.getItems().size());
    }

    @Test
    @DisplayName("Should handle columns correctly after creation")
    void shouldHandleColumnsCorrectlyAfterCreation() {
        TableView<Person> tableView = TableViewBuilder.<Person>create().build();

        // Add columns manually to verify table works correctly
        TableColumn<Person, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Person, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        tableView.getColumns().addAll(nameColumn, ageColumn);

        assertEquals(2, tableView.getColumns().size());
        assertEquals("Name", tableView.getColumns().get(0).getText());
        assertEquals("Age", tableView.getColumns().get(1).getText());
    }
}