#!/bin/bash

mvn clean deploy -f ./generated-api/24/controls/pom.xml
mvn clean deploy -f ./generated-api/24/graphics/pom.xml
mvn clean deploy -f ./generated-api/24/media/pom.xml
mvn clean deploy -f ./generated-api/24/web/pom.xml