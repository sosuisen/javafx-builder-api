# Builder API

The builder classes provide a fluent API for creating JavaFX components:

```java
// Example using generated Builders
textProp = new SimpleStringProperty("100");

Scene scene = SceneBuilder.withRoot(
                  HBoxBuilder.withChildren(
                                  TextFieldBuilder.create()
                                      .textPropertyApply(prop -> prop.bindBidirectional(textProp))
                                      .style("""
                                             -fx-font-weight: bold;
                                             -fx-alignment: center;
                                             """)
                                      .hGrowInHBox(Priority.ALWAYS)
                                      .maxWidth(Double.MAX_VALUE)
                                      .build(),
                                  ButtonBuilder.create()
                                      .text("Send")
                                      .onAction(e -> System.out.println("Sending..."))
                                      .minWidth(50)
                                      .build())
                             .padding(new Insets(10))
                             .build())
                .width(150)
                .height(100)
                .build();
```
![](images/example_panel.png)

# Basic APIs

The builder classes generally offer a fluent API with names derived from the original class API using simple conventions.

## Builder Class

A builder class is created for each `javafx.scene.*` class.

Class naming convention:
```
[Original class name] + "Builder"
```

When the original class is a public inner class:

```
[Outer class name] + [Inner class name] + "Builder"
```

Examples:
- `Button` -> `ButtonBuilder`
- `XYChart.Data` -> `XYChartDataBuilder`

## Create Methods (Static)

Each builder class includes a `static create` method with the same arguments as the original class constructor. The `create` method enables a fluent API by returning an instance of the builder class.

Examples:
- `Button()` -> `ButtonBuilder.create()`
- `Button(String text)` -> `ButtonBuilder.create(String text)`

## Build Method

This method builds and returns an instance of the original class.

Note that intermediate methods are not evaluated until build() is called (lazy evaluation).

Example:
```java
Button btn = BuittonBuilder.create().build();
```

## Setter Methods

Each builder class includes a method named `XXX` where the name corresponds to the original class setter by removing `set` from `setXXX` and making the first letter lowercase.

Method naming convention:
```
[method name without "set"]
```

Example:
```java
// Original class
var btn1 = new Button();
btn.setText("hello");

// Builder class has `text(String value)` method
var btn2 = ButtonBuilder.create()
               .text("hello")
               .build();
```

Exception:
- **Class methods** that start with 'set' are ignored.

## Apply Method

When you call `apply()` with a functional interface(Consumer<T>) during the building process, it provides access to the instance currently being built.

Examples:
```java
ButtonBuilder.create()
    .apply(btn -> btn.textProperty().bind(prop))
    .build();
```

Most goals can be accomplished using this `apply` method. However, for commonly used patterns, extra APIs (to be introduced later) are provided for more concise code.


# Extra APIs

You can utilize the builder classes by mastering only the Basic APIs. Additionally, several utilities are provided as Extra APIs for commonly used patterns.

## xxxPropertyApply - Access to Property

You can directly access many properties of the instance using `xxxPropertyApply` methods. 

Method naming convention:
```
[property name]  + "Apply"
```

For example, the following `apply` notation has a shorthand form:

- Original form: `.apply(obj -> obj.textProperty().bind(anotherProperty))`

- Shorthand form: `.textPropertyApply(prop->prop.bind(anotherProperty))`


## xxxIn{ContainerClass} - Parent Container Methods Called from Child Nodes

All static setter methods of javafx.scene.layout.Pane container classes are reciprocally implemented as instance methods in Node-inheriting classes.

Method naming convention:
```
[lowercased method name without "set"] + "In" + [container class name]
```

Examples: 

`HBox`'s `setMargin(Node child, Inset value)` becomes the `marginInHBox(Inset value)` method available on all classes that extend Node.

Original form:
```java
var btn = new Button();
var hbox = new HBox(btn);
HBox.setMargin(btn, new Insets(10));

```
Fluent form:
```java
HBoxBuilder.create(
                ButtonBuilder.create()
                             .marginInHBox(new Insets(10))
                             .build())
           .build();
```

## Add Method - Get ObservableList and Add Items

When the original class has a method that returns an `ObservableList` via `getXXX` method, the builder class has `addXXX` shortcuts.

Method naming convention and its arguments:
```
add + [method name without "get"] + (T... elements)
add + [method name without "get"] + (java.util.Collection<? extends T> col)
```

For example, the following `apply` notation has two shorthand forms:
- Original form 1: `VBoxBuilder.create().apply(vbox -> vbox.getChildren().addChildren(elements))`
- Shorthand form 1: `VBoxBuilder.create().addChildren(elements)`
- Original form 2: `VBoxBuilder.create().apply(vbox -> vbox.getChildren().addChildren(col))`
- Shorthand form 2: `VBoxBuilder.create().addChildren(col)`

Exception:
- `getChildrenUnmodifiable` is excluded.

## With Method (Static)

Builder classes that have `addXXX` methods also have a **class method** `withXXX` that takes the same arguments.

This method creates and returns an instance of the builder class, then executes `addXXX` method.

Examples:

- Original form: `VBoxBuilder.create(elements)`
- Another form: `VBoxBuilder.create().apply(vbox -> vbox.getChildren().addChildren(elements))`
- Shorthand of the another form: `VBoxBuilder.withChildren(elements)`
 
Container classes include those like VBox where children can be specified in the constructor, and those like GridPane where children cannot be specified in the constructor.
Therefore, having all containers able to create builders with child elements via withXXX methods provides better consistency.

Exceptions:
- If the original class does not have a default constructor, `withXXX` is impossible and therefore not provided, such as `LineChart`.
- The following appearance-related methods are excluded:
  - getStylesheets
  - getTransforms
  - getStyleClass

Note:
- Since it's "add", it's merely adding values to the default `ObservableList`. Use this when values can be fixed rather than reactive.
- When you want to replace the entire ObservableList itself, use the default setter provided by the Basic APIs.
- Example:
  - `ListViewBuilder.create().items(ObservableList list)`

## Styles

### addStylesheetsText

The `Scene` class and classes that inherit from `Parent` have an `addStylesheets(String... elements)` method according to the rule above. Its arguments are CSS URLs.

They also have an `addStylesheetsText(String css)` method, a utility setter to add a CSS string directly.

Example:
- `SceneBuilder.create().addStylesheetsText(".my-button { -fx-text-fill: white; }")`

### Default styleClass for Container Classes

In JavaFX, only classes in the `javafx.scene.control` package have default style classes based on their class names.

Example: `Button` can be referenced with the `.button` selector.

For instances created by builders, default style classes are also set for container classes in `javafx.scene.layout.Pane`.

Example: `BorderPane` becomes referenceable with the `.border-pane` selector.

## Class-Specific API

### Stage

The `StageBuilder` class has a `withScene(Scene scene)` method to maintain consistency with methods like `withChildren`.

There is no setter for the optional constructor argument `StageStyle`, but `StageBuilder` has  a `stageStyle` method. Other classes don't get such granular shortcuts, but `Stage` receives special treatment as it's at the top of the scene graph.

### Scene

The `SceneBuilder` class has a `withRoot(Parent root)` method to maintain consistency with methods like `withChildren`.

The constructor arguments `width`, `height`, `depthBuffer`, and `antiAliasing` do not have setters on the `Scene` class, but custom setters have been added to `SceneBuilder`. Other classes don't get such granular shortcuts, but `Scene` receives special treatment as it's at the top of the scene graph.

Example:
```java
StageBuilder.withScene(
        SceneBuilder.withRoot(
                AnchorPaneBuilder.withChildren(
                        LabelBuilder.create()
                                .text("BMI Calculator")
                                .style("-fx-font-weight: bold;")
                                .build())
                        .build())
              .build())
        .width(640)
        .height(480)
        .build();
```

### BorderPane

`BorderPaneBuilder` has `withCenter`, `withLeft`, `withRight`, `withBottom` and `withTop` methods to maintain consistency with methods like `withChildren`.

### GridPane

Builder classes generally only have shortcuts for `setXXX` methods, but `GridPaneBuilder` has methods with the same name and arguments for the following original methods:
- add(Node, columnIndex, rowIndex)
- add(Node, columnIndex, rowIndex, colspan, rowspan)
- addRow(rowIndex, children)
- addColumn(columnIndex, children)

Examples:
```java
 GridPaneBuilder.create()
                .add(LabelBuilder.create()
                                .text("Hello"))
                                .alignment(Pos.CENTER)
                                .build(),`
                     0, 0)
                .build();
```

```java
GridPaneBuilder.create()
               .addRow(0,
                        LabelBuilder.create()
                                .text(I18n.get("name"))
                                .alignment(Pos.CENTER)
                                .build(),
                        TextFieldBuilder.create()
                                .alignment(Pos.CENTER)
                                .build())
               .addRow(1,
                        LabelBuilder.create()
                                .text(I18n.get("age"))
                                .alignment(Pos.CENTER)
                                .build(),
                        TextFieldBuilder.create()
                                .alignment(Pos.CENTER)
                                .build())
                .build();
```