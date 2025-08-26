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

The builder class generally offers a fluent API with names derived from the original class API using simple conventions.

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
```
Button btn = BuittonBuilder.create().build();
```

## Setter Methods

Each builder class includes a method named `XXX` where the name corresponds to the original class setter by removing `set` from `setXXX` and making the first letter lowercase.

Method naming convention:
```
[method name without "set"]
```

Example:
```
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
```
ButtonBuilder.create()
    .apply(btn -> btn.textProperty().bind(prop))
    .build();
```

Most goals can be accomplished using this `apply` method. However, for commonly used patterns, extra APIs (to be introduced later) are provided to enable more concise code.

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


## xxxIn{ContainerClass} - Fluent Method Calls on the Container Side

All static setter methods of javafx.scene.layout.Pane container classes are reciprocally implemented as instance methods in Node-inheriting classes.

Method naming convention:
```
[lowercased method name without "set"] + "In" + [container class name]
```

Examples: 

`HBox`'s `setMargin(Node child, Inset value)` becomes `marginInHBox(Inset value)` method available on all classes that extend Node.

Original forms:
```
var btn = new Button();
var hbox = new HBox(btn);
HBox.setMargin(btn, new Insets(10));

```
Fluent form:
```
HBoxBuilder.create(
                ButtonBuilder.create()
                             .marginInHBox(new Insets(10))
                             .build())
           .build();
```

## Add Method - Get ObservableList and Add Items

## With Method (Static)


## Styles

### addStylesheetsText


### Default styleClass for Container Classes



## Class-Specific API

### Stage


### Scene


### GridPane