#!/bin/bash

mvn install -f ./generated-api/24/controls/pom.xml
mvn install -f ./generated-api/24/graphics/pom.xml
mvn install -f ./generated-api/24/media/pom.xml
mvn install -f ./generated-api/24/web/pom.xml