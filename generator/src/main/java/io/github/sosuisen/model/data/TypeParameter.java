package io.github.sosuisen.model.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypeParameter {
    private static Pattern pattern = Pattern.compile("<(.+)>$");
    private static Pattern singleCharPattern = Pattern.compile("^\\w$");

    public static boolean hasTypeParameter(String typeName) {
        Matcher diamondMatcher = pattern.matcher(typeName);
        if (diamondMatcher.find()) {
            // e.g.) javafx.scene.chart.XYChart.Series<X, Y>...
            return true;
        }
        Matcher singleCharMatcher =
            singleCharPattern.matcher(typeName);
        if (singleCharMatcher.find()) {
            // e.g.) T...
            return true;
        }
        return false;
    }
}
