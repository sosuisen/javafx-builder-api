package io.github.sosuisen.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Comparator;

/**
 * Utility class providing consistent method and constructor comparison for sorting. This ensures
 * deterministic output order in generated code.
 */
public class MethodComparator {

    /**
     * Creates a comparator for methods based on their string representation. The comparison
     * includes method name and parameter types.
     * 
     * @return Comparator for Method objects
     */
    public static Comparator<Method> forMethod() {
        return Comparator.comparing(MethodComparator::getSignature);
    }

    /**
     * Creates a comparator for constructors based on their string representation. The comparison
     * includes constructor name and parameter types.
     * 
     * @return Comparator for Constructor objects
     */
    public static Comparator<Constructor<?>> forConstructor() {
        return Comparator.comparing(MethodComparator::getSignature);
    }

    /**
     * Creates a string representation of the executable (method or constructor) signature. Format:
     * name(paramType1, paramType2, ...)
     * 
     * @param executable Method or Constructor to get signature from
     * @return String representation of the signature
     */
    private static String getSignature(Executable executable) {
        StringBuilder sb = new StringBuilder();
        sb.append(executable.getName());
        sb.append("(");

        Parameter[] params = executable.getParameters();
        for (int i = 0; i < params.length; i++) {
            if (i > 0)
                sb.append(", ");
            sb.append(params[i].getParameterizedType().getTypeName());
        }
        sb.append(")");
        return sb.toString();
    }
}
