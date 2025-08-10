#!/bin/bash
mvn clean compile javafx:run -P javafx24
mvn compile -P javafx24,compile-builders
mvn test -P javafx24
mvn assembly:single install -P javafx24,controls -Dmaven.test.skip=true
mvn assembly:single install -P javafx24,graphics -Dmaven.test.skip=true
mvn assembly:single install -P javafx24,media -Dmaven.test.skip=true
mvn assembly:single install -P javafx24,web -Dmaven.test.skip=true