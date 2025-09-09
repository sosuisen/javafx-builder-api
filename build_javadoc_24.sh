#!/bin/bash
# package phase is needed to generate javadoc of modular project.
mvn clean package javadoc:aggregate -Dmaven.test.skip=true -f ./api/24/pom.xml
