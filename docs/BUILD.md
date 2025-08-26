# Build and generate builder classes

## Project Structure

```
├── src/main/java/io/github/sosuisen/
│   ├── extractor/          # JAR analysis and metadata extraction
│   ├── jfxbuilder/         # Generated builder classes
│   │   ├── controls/       # JavaFX Controls builders
│   │   ├── graphics/       # JavaFX Graphics builders
│   │   ├── media/          # JavaFX Media builders
│   │   └── web/            # JavaFX Web builders
│   ├── mapper/             # Class and method annotation mapping
│   ├── parser/             # Code parsing utilities
│   └── template/           # Template model classes
|   App.java                # Entry point
|   BuilderClassGenerator.java # Generator class
├── src/main/resources/
│   ├── mapper/             # Mapping configuration files
│   └── templates/          # JTE template files
├── sdk/24.0.0/             # JavaFX SDK JAR files
└── assembly-descriptor/    # Maven assembly configurations
```

## Getting Started

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

Copy the following JARs from the SDK folder to the `sdk\{version}` folder of this repository. (e.g., sdk\24.0.0)
- `build\publications\javafx.controls-win.jar`
- `build\publications\javafx.graphics-win.jar`
- `build\publications\javafx.media-win.jar`
- `build\publications\javafx.web-win.jar`

These JARs will be used to extract JavaFX class names.

### Generate Builder Classes

Run the class generator to analyze JavaFX SDK and generate builder classes:

```bash
mvn clean compile javafx:run -P javafx24
```

### Compile Builder Classes

After generation, compile the generated builder classes:

```bash
mvn compile -P javafx24,compile-builders
```

### Run Tests

Test the generated builder classes:

```bash
mvn test -P javafx24
```

### Build Module JARs

Build specific module JARs using Maven profiles:

```bash
# Build controls module
mvn clean compile assembly:single install -P javafx24,compile-builders,controls

# Build graphics module
mvn clean compile assembly:single install -P javafx24,compile-builders,graphics

# Build media module
mvn clean compile assembly:single install -P javafx24,compile-builders,media

# Build web module
mvn clean compile assembly:single install -P javafx24,compile-builders,web
```

### Install JavaFX Builder API to Your Local Maven Repository

run `install_local_javafx24.sh`

## Architecture

### Code Generation Process

1. **JAR Analysis**: The `JarExtractor` analyzes JavaFX SDK JAR files to discover classes.
2. **Metadata Extraction**: Extracts constructor parameters, setter methods, and property information.
3. **Template Processing**: Uses JTE templates to generate builder class source code.
4. **Class Generation**: Outputs builder classes with fluent APIs and build methods.

### Key Components

- **BuilderClassGenerator**: Main orchestrator for the generation process.
- **JarExtractor**: Analyzes JAR files and extracts class metadata.
- **TypeMappingManager**: Handles exceptional type mappings and annotations.
- **JTE Templates**: Define the structure and format of generated code.

