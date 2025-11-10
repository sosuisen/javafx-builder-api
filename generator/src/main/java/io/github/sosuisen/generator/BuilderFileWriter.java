package io.github.sosuisen.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.github.sosuisen.model.data.ClassMetadata;

public class BuilderFileWriter {
    private final String[] outputDir;
    private final ClassMetadata classMetadata;

    public BuilderFileWriter(String[] outputDir, ClassMetadata classMetadata) {
        this.outputDir = outputDir;
        this.classMetadata = classMetadata;
    }

    public void writeToDirectories(String content) throws IOException {
        // Create directories and write files to all output locations
        for (String outputDirPath : outputDir) {
            Path outputDir = Paths.get(outputDirPath);
            Files.createDirectories(outputDir);

            Path outputFile = outputDir.resolve(classMetadata.getBuilderClassName() + ".java");
            Files.write(outputFile, content.getBytes());
        }
    }
}
