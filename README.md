# JavaFX Builder API Generator

A code generator that creates fluent builder APIs for JavaFX.

## Overview

This project generates builder pattern implementations for JavaFX UI components, enabling the creation of JavaFX applications through a fluent, strongly typed, declarative API. 
The UI code produced using the builder API can represent nested structures that closely resemble the container hierarchy of the UI.

This Maven-based tool automatically analyzes the JavaFX SDK and generates the corresponding builder classes.

```java
// Example using generated builder APIs
StringProperty textProp = new SimpleStringProperty("100");

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
- **JavaFX 24 Support**: Currently supports JavaFX 24. I plan to provide JAR files for each version of JavaFX.
- **Template-based Generation**: Utilizes JTE (Java Template Engine) for flexible code generation.
- **Maven Integration**: Offers full Maven build lifecycle support with profiles for different modules.

## Background

This project aims to reintroduce builder classes to JavaFX.

The builder classes were included in JavaFX 2.0 but were removed from the official class library due to concerns about maintenance overhead and memory usage, as noted in a 2013 post:

https://mail.openjdk.org/pipermail/openjfx-dev/2013-March/006725.html

The three advantages of the builder classes mentioned in that post remain valid today:
- Ability to set up generic configurations once and "stamp out" multiple copies.
- Structured code style that closely approximates the "container hierarchy" of the UI.
- Strongly-typed "declarative" style programming.

These advantages are especially appealing for JavaFX users working with Java (rather than Scala or Kotlin), as they enable a declarative and hierarchical coding style typical of other frameworks.

Concerns about memory usage have likely decreased compared to a decade ago. 
Even if they are not included in the official JavaFX library, it is beneficial for third parties to offer builder classes as an option.

My approach utilizes reflection to automatically generate the builder classes, while certain aspects that cannot be automated are handled through a few mapping rules. 
Unlike JavaFX 2.0, the builder classes do not have inheritance relationships, which may increase memory consumption.
Additionally, builders may incur call overhead.
Nonetheless, the builder APIs appeal to those who prefer this programming style.

## Use of JavaFX Builder API 

The API has not yet been registered with Maven Central, but you can try it out using the SNAPSHOT version.

The SNAPSHOT version will soon be discontinued and replaced by a stable release. Please plan to update accordingly.

You can also generate and install the API in your local repository for your use.

To generate it yourself, please refer to the instructions in [Generate builder classes](./docs/BUILD.md).

## Builder API

**API Overview**:

 [JavaFX Builder API](./docs/API.md).

**JavaDoc pages**:

https://sosuisen.github.io/javafx-builder-api-generator/

**Generated Source Code**: 

The generated JavaFX Builder API source code is available at:
https://github.com/sosuisen/javafx-builder-api-generator/tree/main/generated-api

Most of the code comprises simple wrapper classes generated through mechanical transformation rules outlined in [./docs/API.md](./docs/API.md).

## About Component

**Important**: Currently not available in Maven Central. SNAPSHOT only.

### groupId

io.github.sosuisen

### artifactId

Add builder components corresponding to the JavaFX components specified in your dependencies.

e.g.) The builder class component corresponding to `javafx-controls` is `javafx-builder-controls`.

### version

Specify a builder with the same major version as the JavaFX major version.

### Examples

for javafx-controls:

package `io.github.sosuisen.jfxbuilder.controls.*`
```xml
<dependency>
      <groupId>io.github.sosuisen</groupId>
      <artifactId>javafx-builder-controls</artifactId>     
      <version>${javafx.builder.version}</version>
</dependency>
```

for javafx-graphics:

package `io.github.sosuisen.jfxbuilder.graphics.*`
```xml
<dependency>
      <groupId>io.github.sosuisen</groupId>
      <artifactId>javafx-builder-graphics</artifactId>     
      <version>${javafx.builder.version}</version>
</dependency>      
```

for javafx-media:

package `io.github.sosuisen.jfxbuilder.media.*`
```xml
<dependency>
      <groupId>io.github.sosuisen</groupId>
      <artifactId>javafx-builder-media</artifactId>     
      <version>${javafx.builder.version}</version>
</dependency>      
```

for javafx-web:

package `io.github.sosuisen.jfxbuilder.web.*`
```xml
<dependency>
      <groupId>io.github.sosuisen</groupId>
      <artifactId>javafx-builder-web</artifactId>     
      <version>${javafx.builder.version}</version>
</dependency>      
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

The builder implementation depends solely on the original JavaFX compoment. 

**Important**: Maven automatically manages transitive dependencies for JavaFX components; however, builder API components must be installed individually.

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
