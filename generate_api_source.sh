#!/bin/bash

# JavaFX Builder API Source Generator Script
# Usage: ./generate_api_source.sh [JavaFXversion]
# Example: ./generate_api_source.sh 24
#          ./generate_api_source.sh 21

DEFAULT_VERSION="21"

if [ $# -eq 0 ]; then
    echo "Usage: $0 [JavaFXversion]"
    echo "Example: $0 21"
    echo ""
    read -p "Enter JavaFX version (default: $DEFAULT_VERSION): " VERSION
    if [ -z "$VERSION" ]; then
        VERSION=$DEFAULT_VERSION
    fi
else
    VERSION=$1
fi

if ! [[ "$VERSION" =~ ^[0-9]+$ ]]; then
    echo "Error: JavaFXversion need to be a number"
    echo "Example: $0 21"
    exit 1
fi

mvn clean -P javafx$VERSION
mvn clean compile -pl generator -P javafx$VERSION,controls
mvn javafx:run -pl generator -P javafx$VERSION,controls
mvn javafx:run -pl generator -P javafx$VERSION,graphics
mvn javafx:run -pl generator -P javafx$VERSION,media
mvn javafx:run -pl generator -P javafx$VERSION,web
