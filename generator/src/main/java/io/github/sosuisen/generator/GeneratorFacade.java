package io.github.sosuisen.generator;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import io.github.sosuisen.model.data.ClassMetadata;
import io.github.sosuisen.model.data.StaticSetterInfo;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;

public class GeneratorFacade {
    private static final String templatePath = "src/main/resources/templates";

    private final ClassMetadata classMetadata;

    private final StandardCoreGenerator standardCoreGenerator;
    private final CustomizedCoreGenerator customizedCoreGenerator;
    private final CommonMethodsGenerator commonMethodsGenerator;
    private final LayoutConstraintsGenerator layoutConstraintsGenerator;
    private final ClassSpecificMethodsGenerator classSpecificMethodsGenerator;

    private final BuilderFileWriter fileWriter;

    /**
     * Initializes the generator facade.
     * 
     * @param packageName   The package name for the generated builder class. It cannot be empty.
     * @param clazz         The target class to generate the builder for.
     * @param outputDir     The output directory paths to which the generated builder class will be written. It cannot be empty.
     * @param staticSetters The list of static setter information
     * @throws IllegalArgumentException if packageName is empty or outputDir is empty.
     * @throws NullPointerException     if any argument is null.
     */
    public GeneratorFacade(String packageName, Class<?> clazz, String[] outputDir,
        List<StaticSetterInfo> staticSetters) {
        if (packageName == null || packageName.isEmpty()) {
            throw new IllegalArgumentException("Package name cannot be null or empty");
        }
        Objects.requireNonNull(clazz);
        Objects.requireNonNull(outputDir);
        if (outputDir.length == 0) {
            throw new IllegalArgumentException("Output directory array cannot be empty");
        }
        Objects.requireNonNull(staticSetters);

        var templateEngine = initializeTemplateEngine();

        this.classMetadata = new ClassMetadata(clazz, packageName);

        this.standardCoreGenerator =
            new StandardCoreGenerator(templateEngine, clazz, classMetadata);
        this.customizedCoreGenerator = new CustomizedCoreGenerator(templateEngine, clazz);

        this.commonMethodsGenerator =
            new CommonMethodsGenerator(templateEngine, clazz, classMetadata);
        this.classSpecificMethodsGenerator =
            new ClassSpecificMethodsGenerator(templateEngine, clazz, classMetadata);
        this.layoutConstraintsGenerator =
            new LayoutConstraintsGenerator(templateEngine, classMetadata, staticSetters);

        this.fileWriter = new BuilderFileWriter(outputDir, classMetadata);
    }

    /**
     * Generates the builder class and writes it to the output directories.
     * 
     * @throws IOException
     */
    public void generate() throws IOException {
        String content = generateBuilderClass();
        fileWriter.writeToDirectories(content);
    }

    private TemplateEngine initializeTemplateEngine() {
        var codeResolver = new DirectoryCodeResolver(Paths.get(templatePath));
        return TemplateEngine.create(codeResolver, ContentType.Plain);
    }

    private String generateBuilderClass() {
        StringBuilder content = new StringBuilder();

        if (customizedCoreGenerator.hasCustomGenerator()) {
            content.append(customizedCoreGenerator.generate());
        } else {
            content.append(standardCoreGenerator.generate());
        }

        content.append(commonMethodsGenerator.generate());
        content.append(layoutConstraintsGenerator.generate());
        content.append(classSpecificMethodsGenerator.generate());


        content.append("\n}\n");

        return content.toString();
    }
}
