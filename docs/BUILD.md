# Build and generate builder classes

## Project Structure

```
├── generated-api/          # Generated builder API projects
├── sdk/                    # JavaFX SDK JAR files
├── src/main/java/io/github/sosuisen/
│   ├── extractor/          # JAR analysis and metadata extraction
│   ├── jfxbuilder/         # Copied generated code, kept under the source path 
│   │                         for easier static verification.
│   ├── mapper/             # Class and method annotation mapping
│   ├── parser/             # Code parsing utilities
│   └── template/           # Template model classes
|   App.java                # Entry point called from Launcher
|   BuilderClassGenerator.java # Generator class
|   Launcher.java           # Launch from this point
├── src/main/resources/
│   ├── mapper/             # Individual rules
│   ├── pom/                # pom.xml templates for builder API projects
│   └── templates/          # JTE template files
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

### Install JavaFX Builder API to Your Local Maven Repository

run `install_builder_to_local_v24.sh`.

## Architecture

### Code Generation Process

- **JAR Analysis**: The `JarExtractor` analyzes JavaFX SDK JAR files to discover classes.
- **Class Generation**: Reflection is used to automatically generate Builder classes, while specific aspects that cannot be automated are handled through individual rules located in files under `src/main/resources/mapper/`.

