# Project structure

## Read only directories
You can read the files under the directory, but cannot modify them.
- src/main/java/io/github/sosuisen/jfxbuilder

## sdk directory
This project reads the class names which are included in the sdk jar files.
The sdk jar files are under the sdk/${javafx.version} directory.

# Scripts

## How to run class generater
`mvn clean compile javafx:run -P javafx24`

## How to compile builder classes
`mvn compile -P javafx24,compile-builders`

## How to test builder classes
mvn test -P javafx24

