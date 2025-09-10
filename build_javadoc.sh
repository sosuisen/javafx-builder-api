#!/bin/bash

# JavaFX Builder API JavaDoc build Script
# Usage: ./build_javadoc.sh [JavaFXversion]
# Example: ./build_javadoc.sh 24
#          ./build_javadoc.sh 21

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

# package phase is needed to generate javadoc of modular project.
mvn clean package javadoc:aggregate -Dmaven.test.skip=true -f ./api/$VERSION/pom.xml
