# Build and generate builder classes

## Project Structure

```
├── generated-api/          # Generated builder API projects
├── sdk/                    # JavaFX SDK JAR files
├── src/main/java/io/github/sosuisen/
|   ├── jfxbuilder/         # Copied generated code under the source path (for quick static verification)
|   ├── model/
│   │     ├── data/         # Data classes
│   │     ├── mapper/       # Manager for individual rules
│   │     └── template/     # Model classes for JTE
|   ├── App.java            # Entry point called from Launcher
|   ├── BuilderClassGenerator.java # Generator class
|   ├── Launcher.java       # Launch from this point
├── src/main/resources/
│   ├── mapper/             # Individual rules
│   ├── package-info/       # package-info files for JavaDoc
│   ├── pom/                # pom.xml templates for builder API projects
│   └── templates/          # JTE template files
```

## Quick Start

Under the `generated-api` directory, there are Maven projects for the generated JavaFX Builder API.

You can install them to your local Maven repository using:
```bash
./install_builder_to_local_v24.sh
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

Generated builder classes are OS-agnostic; however, the generator currently supports only Windows.

### Clone

Clone this repository to your local PC.

### Build OpenJFX
- See https://wiki.openjdk.org/display/OpenJFX/Building+OpenJFX
- Clone the OpenJFX SDK.
- Change the target SDK branch (e.g., jfx24)
- Modify `build.gradle` to add `compile.options.compilerArgs += [ "-parameters" ]` in `allprojects` block.
- Copy `sdk-script/install_to_m2_repository_jfx24.sh` to the SDK project root folder and run it.
- This will install the JavaFX runtime with parameters in your local Maven repository.
- This runtime will be used for extracting JavaFX class information via reflection.

### Copy JARs

Copy the following JARs from the SDK folder to the `sdk/{version}` folder of this repository. (e.g., sdk\24.0.0)
- `build/publications/javafx.controls-win.jar`
- `build/publications/javafx.graphics-win.jar`
- `build/publications/javafx.media-win.jar`
- `build/publications/javafx.web-win.jar`

These JARs will be used to extract JavaFX class names.

### Generate Builder Classes

Run the generator to analyze JavaFX SDK and generate builder classes:

```bash
./generate_builder_v24.sh
```

### Generate Builder JavaDocs

```bash
./generate_javadoc_v24.sh
```

### Install JavaFX Builder API to Your Local Maven Repository

```bash
./install_builder_to_local_v24.sh
```
JavaDocs will be generated under `docs` directory.

## Architecture

### Code Generation Process

- **JAR Analysis**: The `JarExtractor` analyzes JavaFX SDK JAR files to discover classes.
- **Class Generation**: Reflection is used to automatically generate Builder classes, while specific aspects that cannot be automated are handled through individual rules located in files under `src/main/resources/mapper/`.

