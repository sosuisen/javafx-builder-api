# Build and generate builder classes

## Project Structure

```
├── api/                        # Generated builder API projects
|── docs/                       # Documents and generated javadocs
└── generator
    ├── config-sources/         # Configuration files to be copied to API projects
    ├── sdk/                    # JAR files from JavaFX SDK
    ├── src/main/java/io/github/sosuisen/
    |    ├── model/
    |    │    ├── data/         # Data classes
    |    │    ├── mapper/       # Manager for individual mapping rules
    |    │    └── template/     # Model classes for JTE
    |    ├── App.java           # Entry point called from Launcher
    |    ├── BuilderClassGenerator.java  # Generator class
    |    └── Launcher.java      # Launch from this point
    └── src/main/resources/
         ├── mapper/            # Individual mapping rules
         └── templates/         # JTE template files
```

## Quick Start

Under the `api` directory, there are Maven projects for the generated JavaFX Builder API.

You can install them to your local Maven repository using:
```bash
./install_api_to_local.sh
```

That's it! Now you can use them in your project. Here's an example pom.xml:
```xml
  <properties>
    <javafx.version>24.0.2</javafx.version>
    <javafx.builder.version>24.0.0-SNAPSHOT</javafx.builder.version>
  </properties>

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

## Generate JavaFX Builder API

If you want to modify the Builder API project, follow these steps to generate it.

Generated builder classes are OS-agnostic; however, this generator document currently supports only Linux.

### Clone

Clone this repository to your local PC.

### Build OpenJFX
- Clone the OpenJFX SDK.
- Change the target SDK branch (e.g., jfx24)
- Modify `build.gradle` to add `compile.options.compilerArgs += [ "-parameters" ]` in `allprojects` block.
- See https://wiki.openjdk.org/display/OpenJFX/Building+OpenJFX to build it.

### Copy JARs

Copy the following JARs from the SDK folder to the `generator/sdk/{version}` folder of this repository. (e.g., generator/sdk/24)
- `build/publications/javafx.base-linux.jar`
- `build/publications/javafx.controls-linux.jar`
- `build/publications/javafx.graphics-linux.jar`
- `build/publications/javafx.media-linux.jar`
- `build/publications/javafx.web-linux.jar`

### Generate Builder API Projects

Run the generator to analyze JavaFX JARs and generate builder API projects.

```bash
./generate_api_source.sh
```

### Build API Projects

```bash
./build_api.sh
```

### Build JavaDoc

```bash
./build_javadoc.sh
```
JavaDocs will be generated under `docs` directory.

### Install JavaFX Builder API to Your Local Maven Repository

```bash
./install_api_to_local.sh
```

## Architecture

### Code Generation Process

- **JAR Analysis**: The `JarExtractor` analyzes JavaFX JAR files to discover classes.
- **Class Generation**: Reflection is used to automatically generate builder classes, while specific aspects that cannot be automated are handled through individual rules located in files under `src/main/resources/mapper/`.

