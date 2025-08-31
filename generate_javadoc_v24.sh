#!/bin/bash

mvn javadoc:javadoc -f ./generated-api/24/controls/pom.xml
mvn javadoc:javadoc -f ./generated-api/24/graphics/pom.xml
mvn javadoc:javadoc -f ./generated-api/24/media/pom.xml
mvn javadoc:javadoc -f ./generated-api/24/web/pom.xml