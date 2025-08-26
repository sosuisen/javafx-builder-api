# Builder API

The generated builders provide a fluent API for creating JavaFX components:

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

# Basic API

The Builder API generally provides a Fluent API with names converted from the original class API using simple rules.

## Builder class

A builder class is prepared for each `javafx.scene.*` class.

Class naming convention:
```
[Original class name] + "Builder"
```

When the original class is public inner class:

```
[Outer class name] + [Inner class name] + "Builder"
```

Examples:
- `Button` -> `ButtonBuilder`
- `XYChart.Data` -> `XYChartDataBuilder`

## create methods (static)

A builder class has a class method `create` with the same arguments as the original class constructor. The `create` method provides a Fluent API by returning an instance of the builder class.

Examples:
- `Button()` -> `ButtonBuilder.create()`
- `Button(String text)` -> `ButtonBuilder.create(String text)`

## build method

Build and return an instance of the original class.

Note that intermediate methods are not evaluated until build() is called (lazy evaluation).

Example:
```
Button btn = BuittonBuilder.create().build();
```

## setter methods

A builder class has a method named `XXX` with the same name as the original class setter, removing `set` from `setXXX` and making the first letter lowercase.

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

## apply method

When you call `apply()` with a functional interface(Consumer<T>) during the building process, it provides access to the instance currently being built.

Examples:
```
ButtonBuilder.create()
    .apply(btn -> btn.textProperty().bind(prop))
    .build();
```

Most of what you want to accomplish with the builder can be achieved using this `apply` method. However, for commonly used patterns, extra APIs (which will be introduced later) are provided, allowing you to write more concise code.

# Extra API

You can use the Builder API by learning only the Basic API. On the other hand, for commonly used patterns, several utilities are provided as Extra API.

## xxxPropertyApply - Access to property

You can directly access many properties of the instance by `xxxPropertyApply` methods. 

Method naming convention:
```
[property name]  + "Apply"
```

Namely, the following `apply` notation has a shorthand form.

Example: 

- Original form: `.apply(obj -> obj.textProperty().bind(anotherProperty))`

- Shorthand form: `.textPropertyApply(prop->prop.bind(anotherProperty))`


## xxxIn{ContainerClass} - Calling class methods fluently on the container side

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

## add method - Get ObservableList and add items


## with method (static)


## styles

### addStylesheetsText


### Default styleClass for container classes



## Class specific API

### Stage


### Scene


### GridPane