package io.github.sosuisen.parser;

import java.lang.reflect.Constructor;

public class ConstructorParser {
    public static boolean hasDefaultConstructor(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterCount() == 0) {
                return true;
            }
        }

        return false;
    }
}
