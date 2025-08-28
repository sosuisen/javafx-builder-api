#!/bin/bash
mvn clean compile javafx:run -P javafx24-dev
mvn compile -P javafx24-dev,compile-builders
# mvn test -P javafx24-dev
mvn assembly:single install -P javafx24-dev,controls -Dmaven.test.skip=true
mvn assembly:single install -P javafx24-dev,graphics -Dmaven.test.skip=true
mvn assembly:single install -P javafx24-dev,media -Dmaven.test.skip=true
mvn assembly:single install -P javafx24-dev,web -Dmaven.test.skip=true