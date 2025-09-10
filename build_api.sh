#!/bin/bash

# JavaFX Builder API build Script 
# (must be run after generate_api_source.sh)
# Usage: ./build_api.sh [JavaFXversion]
# Example: ./build_api.sh 24
#          ./build_api.sh 21

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

# Use -T 4 to be multithread.
mvn clean compile test -T 4 -pl api/$VERSION/controls,api/$VERSION/graphics,api/$VERSION/media,api/$VERSION/web
