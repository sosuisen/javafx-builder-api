# JavaFX Builder API Generator

A Maven-based tool that generates fluent builder APIs for JavaFX components by analyzing the JavaFX SDK and creating corresponding builder classes.

## Overview

This project generates builder pattern implementations for JavaFX UI components, enabling the creation of JavaFX applications through a fluent, strongly-typed declarative API. The UI code crafted with the builder API can represent nested structures that closely resemble the container hierarchy of the UI.

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

- **Automatic Builder Generation**: Creates builder classes for JavaFX controls, graphics, media, and web packages.
- **JavaFX 24 Support**: Currently supports JavaFX 24.0.0. I plan to provide JAR files for each version of JavaFX.
- **Template-based Generation**: Utilizes JTE (Java Template Engine) for flexible code generation.
- **Maven Integration**: Offers full Maven build lifecycle support with profiles for different modules.

## Background

This project aims to reintroduce the builder classes to JavaFX.

The builder classes were included in JavaFX 2.0 but were removed from the official class library due to concerns about maintenance overhead and memory usage, as noted in a 2013 post:

https://mail.openjdk.org/pipermail/openjfx-dev/2013-March/006725.html

The three advantages of the builder classes mentioned in that post remain valid today:
- Ability to set up generic configurations once and "stamp out" multiple copies.
- Structured code style that closely approximates the "container hierarchy" of the UI.
- Strongly-typed "declarative" style programming.

These advantages are particularly appealing for those using JavaFX with Java (rather than Scala or Kotlin), enabling a declarative and hierarchical coding style common in other frameworks.

Memory usage concerns may have diminished compared to a decade ago. Additionally, having the builder classes as an option outside the official class library remains a beneficial idea.

My approach utilizes reflection to automatically generate the builder classes, while certain aspects that cannot be automated are managed through individual rules. Unlike JavaFX 2.0, the builder classes have no inheritance relationships and are flat, which leads to increased memory consumption. There is also some call overhead. However, this may be advantageous for those interested in this programming style.

## Use of JavaFX Builder API 

The API has not yet been registered with Maven Central, but you can try it out using the SNAPSHOT version.

The SNAPSHOT version will soon be discontinued and replaced by a stable release. Please plan to update accordingly.

You can also generate and install the API in your local repository for you use.

To generate it yourself, please refer to the instructions in [Generate builder classes](./docs/BUILD.md).

## Builder API

**API Specification Overview**:

 [JavaFX Builder API](./docs/API.md).

**JavaDoc pages**:

- [io.github.sosuisen.jfxbuilder.controls](./generated-api/24/controls/apidocs/)
- [io.github.sosuisen.jfxbuilder.graphics](./generated-api/24/graphics/apidocs/)
- [io.github.sosuisen.jfxbuilder.media](./generated-api/24/media/apidocs/)
- [io.github.sosuisen.jfxbuilder.web](./generated-api/24/web/apidocs/)

**Generated Source Code**: 

The generated JavaFX Builder API source code is available at:
https://github.com/sosuisen/javafx-builder-api-generator/tree/main/generated-api

Most of the code comprises simple wrapper classes generated through mechanical transformation rules outlined in [./docs/API.md](./docs/API.md).

## Dependencies

**Important**: Currently not available in Maven Central. SNAPSHOT only.

### groupId

io.github.sosuisen

### artifactId

Add builder artifacts corresponding to the JavaFX artifacts specified in your dependencies.

e.g.) The builder class artifact corresponding to `javafx-controls` is `javafx-builder-controls`.

### version

Specify a builder with the same major version as the JavaFX major version.

### Examples

for javafx-controls:

package `io.github.sosuisen.jfxbuilder.controls.*`
```xml
      <groupId>io.github.sosuisen</groupId>
      <artifactId>javafx-builder-controls</artifactId>     
      <version>${javafx.builder.version}</version>
```

for javafx-graphics:

package `io.github.sosuisen.jfxbuilder.graphics.*`
```xml
      <groupId>io.github.sosuisen</groupId>
      <artifactId>javafx-builder-graphics</artifactId>     
      <version>${javafx.builder.version}</version>
```

for javafx-media:

package `io.github.sosuisen.jfxbuilder.media.*`
```xml
      <groupId>io.github.sosuisen</groupId>
      <artifactId>javafx-builder-media</artifactId>     
      <version>${javafx.builder.version}</version>
```

for javafx-web:

package `io.github.sosuisen.jfxbuilder.web.*`
```xml
      <groupId>io.github.sosuisen</groupId>
      <artifactId>javafx-builder-web</artifactId>     
      <version>${javafx.builder.version}</version>
```

### Use SNAPSHOT

You need to add the maven-snapshots repository to pom.xml:
```xml
  <properties>
    <javafx.version>24.0.2</javafx.version>
    <javafx.builder.version>24.0.0-SNAPSHOT</javafx.builder.version>
  </properties>

  <repositories>
    <repository>
      <name>Central Portal Snapshots</name>
      <id>central-portal-snapshots</id>
      <url>https://central.sonatype.com/repository/maven-snapshots/</url>
      <releases>
        <enabled>false</enabled>
      </releases>
      <snapshots>
        <enabled>true</enabled>
      </snapshots>
    </repository>
  </repositories>

  <dependencies>
    <dependency>
      <groupId>org.openjfx</groupId>
      <artifactId>javafx-controls</artifactId>
      <version>${javafx.version}</version>
    </dependency>
    <dependency>    
      <groupId>org.openjfx</groupId>
      <artifactId>javafx-graphics</artifactId>     
      <version>${javafx.version}</version>
    </dependency>
    <dependency>
      <groupId>io.github.sosuisen</groupId>
      <artifactId>javafx-builder-controls</artifactId>
      <version>${javafx.builder.version}</version>
    </dependency>
    <dependency>    
      <groupId>io.github.sosuisen</groupId>
      <artifactId>javafx-builder-graphics</artifactId>     
      <version>${javafx.builder.version}</version>
    </dependency>
 </dependencies>
```

### Transitive dependencies

The builder implementation depends solely on the original JavaFX artifact. 

**Important**: Maven automatically manages transitive dependencies for JavaFX artifacts; however, builder API artifacts must be installed manually.

For example, `javafx-builder-graphics` is not strictly necessary, but it is generally required when your project depends on `javafx-controls`, since `javafx-graphics` is a transitive dependency.

pom.xml
```xml
  <dependencies>
    <dependency>
      <groupId>org.openjfx</groupId>
      <artifactId>javafx-controls</artifactId>
      <version>${javafx.version}</version>
    </dependency>
    <dependency>
      <groupId>io.github.sosuisen</groupId>
      <artifactId>javafx-builder-controls</artifactId>
      <version>${javafx.builder.version}</version>
    </dependency>
    <dependency>    
      <groupId>io.github.sosuisen</groupId>
      <artifactId>javafx-builder-graphics</artifactId>     
      <version>${javafx.builder.version}</version>
    </dependency>   
  </dependencies>
```

## Sample Project Using Builder API

The BMI (Body Mass Index) calculator demonstrates modern JavaFX development utilizing MVVM architecture, fluent UI construction, and internationalization support.

https://github.com/sosuisen/bmi-mvvm-with-builder

## LICENSE

MIT
