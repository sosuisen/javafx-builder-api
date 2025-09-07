#!/bin/bash

# Automated installation script for JavaFX JAR files to local Maven repository
# Installs to local repository (~/.m2/repository)

# JavaFX version and identifier (change as needed)
JAVAFX_VERSION="24.0.0"  # Change to match your actual version
CUSTOM_GROUP_ID="com.example.jfx"  # Custom groupId
WIN_CLASSIFIER="win"  # Classifier for Windows-specific JAR files

# JAR file information array
# Format: "filename:groupId:artifactId:version:classifier"
JARS=(
  "build/publications/javafx.fxml.jar:${CUSTOM_GROUP_ID}:javafx-fxml:${JAVAFX_VERSION}:"
  "build/publications/javafx.fxml-win.jar:${CUSTOM_GROUP_ID}:javafx-fxml:${JAVAFX_VERSION}:${WIN_CLASSIFIER}"
  "build/publications/javafx.graphics.jar:${CUSTOM_GROUP_ID}:javafx-graphics:${JAVAFX_VERSION}:"
  "build/publications/javafx.graphics-win.jar:${CUSTOM_GROUP_ID}:javafx-graphics:${JAVAFX_VERSION}:${WIN_CLASSIFIER}"
  "build/publications/javafx.media.jar:${CUSTOM_GROUP_ID}:javafx-media:${JAVAFX_VERSION}:"
  "build/publications/javafx.media-win.jar:${CUSTOM_GROUP_ID}:javafx-media:${JAVAFX_VERSION}:${WIN_CLASSIFIER}"
  "build/publications/javafx.swing.jar:${CUSTOM_GROUP_ID}:javafx-swing:${JAVAFX_VERSION}:"
  "build/publications/javafx.swing-win.jar:${CUSTOM_GROUP_ID}:javafx-swing:${JAVAFX_VERSION}:${WIN_CLASSIFIER}"
  "build/publications/javafx.web.jar:${CUSTOM_GROUP_ID}:javafx-web:${JAVAFX_VERSION}:"
  "build/publications/javafx.web-win.jar:${CUSTOM_GROUP_ID}:javafx-web:${JAVAFX_VERSION}:${WIN_CLASSIFIER}"
  "build/publications/jdk.jsobject.jar:${CUSTOM_GROUP_ID}:jdk-jsobject:${JAVAFX_VERSION}:"
  "build/publications/jdk.jsobject-win.jar:${CUSTOM_GROUP_ID}:jdk-jsobject:${JAVAFX_VERSION}:${WIN_CLASSIFIER}"
  "build/publications/jfx.incubator.input.jar:${CUSTOM_GROUP_ID}:javafx-incubator-input:${JAVAFX_VERSION}:"
  "build/publications/jfx.incubator.input-win.jar:${CUSTOM_GROUP_ID}:javafx-incubator-input:${JAVAFX_VERSION}:${WIN_CLASSIFIER}"
  "build/publications/jfx.incubator.richtext.jar:${CUSTOM_GROUP_ID}:javafx-incubator-richtext:${JAVAFX_VERSION}:"
  "build/publications/jfx.incubator.richtext-win.jar:${CUSTOM_GROUP_ID}:javafx-incubator-richtext:${JAVAFX_VERSION}:${WIN_CLASSIFIER}"
  "build/publications/javafx.base.jar:${CUSTOM_GROUP_ID}:javafx-base:${JAVAFX_VERSION}:"
  "build/publications/javafx.base-win.jar:${CUSTOM_GROUP_ID}:javafx-base:${JAVAFX_VERSION}:${WIN_CLASSIFIER}"
  "build/publications/javafx.controls.jar:${CUSTOM_GROUP_ID}:javafx-controls:${JAVAFX_VERSION}:"
  "build/publications/javafx.controls-win.jar:${CUSTOM_GROUP_ID}:javafx-controls:${JAVAFX_VERSION}:${WIN_CLASSIFIER}"
)

echo "Starting installation of JavaFX JAR files to local Maven repository..."
echo "Target files: ${#JARS[@]}"
echo ""

# Counter variables
success_count=0
error_count=0

for jar_info in "${JARS[@]}"; do
  # Split information
  IFS=':' read -r file groupId artifactId version classifier <<< "$jar_info"
  
  echo "Processing: $(basename "$file")"
  echo "  GroupId: $groupId"
  echo "  ArtifactId: $artifactId"
  echo "  Version: $version"
  if [ -n "$classifier" ]; then
    echo "  Classifier: $classifier"
  fi
  
  # Check file existence
  if [ ! -f "$file" ]; then
    echo "  Error: File not found: $file"
    ((error_count++))
    echo ""
    continue
  fi
  
  # Build and execute Maven install-file command
  if [ -n "$classifier" ]; then
    # With classifier
    mvn install:install-file \
      -DgroupId="$groupId" \
      -DartifactId="$artifactId" \
      -Dversion="$version" \
      -Dclassifier="$classifier" \
      -Dpackaging=jar \
      -Dfile="$file"
  else
    # Without classifier
    mvn install:install-file \
      -DgroupId="$groupId" \
      -DartifactId="$artifactId" \
      -Dversion="$version" \
      -Dpackaging=jar \
      -Dfile="$file"
  fi
  
  # Check execution result
  if [ $? -eq 0 ]; then
    echo "  Success: Installed $(basename "$file")"
    ((success_count++))
  else
    echo "  Error: Failed to install $(basename "$file")"
    ((error_count++))
  fi
  
  echo ""
done

echo "Installation completed"
echo "Success: $success_count files"
echo "Failed: $error_count files"
echo "Total: ${#JARS[@]} files"

if [ $error_count -gt 0 ]; then
  echo "Some files failed to install. Please check the logs."
  exit 1
else
  echo "All files were successfully installed to the local repository."
  exit 0
fi