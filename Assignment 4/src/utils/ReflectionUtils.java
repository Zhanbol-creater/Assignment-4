package utils;

import java.util.Arrays;

public class ReflectionUtils {
    public static void inspect(Object obj) {
        Class<?> clazz = obj.getClass();
        System.out.println("Class: " + clazz.getName());

        System.out.println("=== Fields ===");
        Arrays.stream(clazz.getDeclaredFields())
                .forEach(f -> System.out.println("Field: " + f.getName()));

        System.out.println("=== Methods ===");
        Arrays.stream(clazz.getDeclaredMethods())
                .forEach(m -> System.out.println("Method: " + m.getName()));
    }
}