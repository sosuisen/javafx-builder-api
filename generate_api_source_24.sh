#!/bin/bash
mvn clean compile -pl generator -P javafx24,controls
mvn javafx:run -pl generator -P javafx24,controls
mvn javafx:run -pl generator -P javafx24,graphics
mvn javafx:run -pl generator -P javafx24,media
mvn javafx:run -pl generator -P javafx24,web
