# Project structure

## Read only directories
You can read the files under the directory, but cannot modify them.
- src/main/java/io/github/sosuisen/jfxbuilder

## sdk directory
This project reads the class names which are included in the sdk jar files.
The sdk jar files are under the sdk/${javafx.version} directory.

# Scripts

## How to compile
mvn clean compile -P javafx24

## How to run
mvn exec:java -P javafx24

## How to test
mvn test -P javafx24

