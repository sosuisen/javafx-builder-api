#!/bin/bash

# Deploy JavaFX Builder API to Maven Central
# Usage: ./deploy_api_to_central.sh [JavaFXversion]
# Example: ./deploy_api_to_central.sh 24

DEFAULT_VERSION="25"

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

# Cannot use multithread
mvn clean -P javafx$VERSION
mvn clean compile -pl generator -P javafx$VERSION,controls
mvn javafx:run -pl generator -P javafx$VERSION,controls
mvn javafx:run -pl generator -P javafx$VERSION,graphics
mvn javafx:run -pl generator -P javafx$VERSION,media
mvn javafx:run -pl generator -P javafx$VERSION,web

mvn clean package javadoc:aggregate -Dmaven.test.skip=true -f ./api/$VERSION/pom.xml

mvn clean deploy -pl api/$VERSION/controls
mvn clean deploy -pl api/$VERSION/graphics
mvn clean deploy -pl api/$VERSION/media
mvn clean deploy -pl api/$VERSION/web