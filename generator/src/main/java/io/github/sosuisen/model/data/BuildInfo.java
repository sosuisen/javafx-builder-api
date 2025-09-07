package io.github.sosuisen.model.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BuildInfo {
    private static final Properties BUILD_PROPS = new Properties();

    static {
        try (InputStream is = BuildInfo.class.getResourceAsStream("/build.properties")) {
            BUILD_PROPS.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read build.properties", e);
        }
    }

    public static String getJavaFXVersion() {
        return BUILD_PROPS.getProperty("javafx.version");
    }

    public static String getJavaFXMajorVersion() {
        var version = BUILD_PROPS.getProperty("javafx.version");
        var verArr = version.split("\\.");
        if (verArr.length > 0) {
            return verArr[0];
        } else {
            return "0";
        }
    }

    public static String getJavaFXPlatform() {
        return BUILD_PROPS.getProperty("javafx.platform");
    }

    public static String getBuilderComponent() {
        return BUILD_PROPS.getProperty("builder.component");
    }

}
