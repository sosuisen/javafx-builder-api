#!/bin/bash

# Install JavaFX Builder API to local repository
# Usage: ./install_api_to_local.sh [JavaFXversion]
# Example: ./install_api_to_local.sh 24

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

mvn install -T 4 -pl api/$VERSION/controls,api/$VERSION/graphics,api/$VERSION/media,api/$VERSION/web
