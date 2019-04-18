package utils;

import org.apache.commons.text.RandomStringGenerator;

@Deprecated
public class StringGenerator {

    public static String generator() {
        String name = new RandomStringGenerator
                .Builder()
                .withinRange('а', 'я')
                .build()
                .generate(8);
        return stringUpper(name);
    }

    private static String stringUpper(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;
    }

    public static String nameGen() {
        return String.valueOf(new StringGenerator().generator());
    }
}