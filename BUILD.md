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

Generated classes are OS agnostic, however the generator currently supports only Windows. 

### Clone

Clone this repository to your local PC.

### Build OpenJFX
- See https://wiki.openjdk.org/display/OpenJFX/Building+OpenJFX
- Clone SDK.
- Change target SDK branch (e.g. jfx24)
- Modify build.gradle to add `compile.options.compilerArgs += [ "-parameters" ]` in `allprojects` block.
- Copy `sdk-script/install_to_m2_repository_jfx24.sh` to SDK project root folder, and run it.
- Then, JavaFX runtime with parameters are installed to your local maven repository.
- These runtime will be used for extracting JavaFX class information by reflection.

### Copy jars

Copy following jars from SDK folder to sdk\{version} folder of this repository. (e.g. sdk\24.0.0)
- `build\publications\javafx.controls-win.jar`
- `build\publications\javafx.graphics-win.jar`
- `build\publications\javafx.media-win.jar`
- `build\publications\javafx.web-win.jar`

These jars will be used for extracting JavaFX class names.

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

### Install JavaFX Builder API to your local maven repository

run `install_local_javafx24.sh`

## Architecture

### Code Generation Process

1. **JAR Analysis**: The `JarExtractor` analyzes JavaFX SDK JAR files to discover classes
2. **Metadata Extraction**: Extracts constructor parameters, setter methods, and property information
3. **Template Processing**: Uses JTE templates to generate builder class source code
4. **Class Generation**: Outputs builder classes with fluent APIs and build methods

### Key Components

- **BuilderClassGenerator**: Main orchestrator for the generation process
- **JarExtractor**: Analyzes JAR files and extracts class metadata
- **TypeMappingManager**: Handles exceptional type mappings and annotations
- **JTE Templates**: Define the structure and format of generated code

