# JavaFX Builder API Generator

A Maven-based tool that generates fluent builder APIs for JavaFX components by analyzing the JavaFX SDK and creating corresponding builder classes.

## Overview

This project generates builder pattern implementations for JavaFX UI components, facilitating the creation of JavaFX applications with a fluent, declarative API. The UI code written with the builder API can represent nested structures that closely approximate the container hierarchy of the UI.

```java
// Example using JavaFX Builder APIs
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

## Features

- **Automatic Builder Generation**: Creates builder classes for JavaFX controls, graphics, media, and web components.
- **JavaFX 24 Support**: Currently supports JavaFX 24.0.0. I plan to provide JAR files for each version of JavaFX.
- **Modular Architecture**: Separates builders into logical modules (controls, graphics, media, web).
- **Template-based Generation**: Utilizes JTE (Java Template Engine) for flexible code generation.
- **Maven Integration**: Offers full Maven build lifecycle support with profiles for different modules.

## Background

This project aims to reintroduce Builder classes to JavaFX.

Builder classes were present in JavaFX 2.0, but they were removed from the official class library due to concerns about maintenance overhead and memory usage, as noted in a 2013 post.

https://mail.openjdk.org/pipermail/openjfx-dev/2013-March/006725.html

The three advantages of Builder classes mentioned in that post remain valid today:
- Ability to set up generic configurations once and "stamp out" multiple copies.
- Structured code style that closely approximates the "container hierarchy" of the UI.
- Strongly-typed "declarative" style programming.

These advantages are particularly appealing for those using JavaFX with Java (rather than Scala or Kotlin), enabling a declarative and hierarchical coding style common in other frameworks.

Memory usage concerns may have diminished compared to a decade ago. Additionally, having Builder classes as an option outside the official class library remains a beneficial idea.

My approach utilizes reflection to automatically generate Builder classes, while certain aspects that cannot be automated are managed through individual rules. Unlike JavaFX 2.0, the builder classes have no inheritance relationships and are flat, which leads to increased memory consumption. There is also some call overhead. However, this may be advantageous for those interested in this programming style.

## Use of Generator

JAR files of the Builder API are planned for publication to Maven Central but are not yet available. Currently, you need to generate and install them in your local repository to use them.

To generate it yourself, please see the instructions in [Generate builder classes](./docs/BUILD.md).

## Builder API

Refer [Builder API](./docs/API.md).

## Sample Project Using Builder API

https://github.com/sosuisen/bmi-mvvm-with-builder

## LICENSE

MIT
