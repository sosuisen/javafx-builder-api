package io.github.sosuisen;

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

    public static String getJavaFXPlatform() {
        return BUILD_PROPS.getProperty("javafx.platform");
    }
}