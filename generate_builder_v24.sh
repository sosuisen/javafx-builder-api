#!/bin/bash
mvn clean compile javafx:run -P javafx24,controls
mvn clean compile javafx:run -P javafx24,graphics
mvn clean compile javafx:run -P javafx24,media
mvn clean compile javafx:run -P javafx24,web
