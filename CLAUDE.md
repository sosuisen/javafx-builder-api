# Project structure

## Read only directories
You can read the files under the directory, but cannot modify them.
- src/main/java/io/github/sosuisen/jfxbuilder
- generated-api/src/main/java/io/github/sosuisen/jfxbuilder

## sdk directory
This project reads the class names which are included in the sdk jar files.
The sdk jar files are under the sdk/${javafx.version} directory.

# Scripts

## How to run class generator
`mvn clean compile javafx:run -P javafx24,controls`

## How to test builder classes
`mvn test -f ./generated-api/24/controls/pom.xml`
