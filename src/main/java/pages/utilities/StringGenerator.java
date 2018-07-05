package pages.utilities;

import org.apache.commons.text.RandomStringGenerator;

public class StringGenerator {

    public String generator() {
        String name = new RandomStringGenerator
                .Builder()
                .withinRange('а', 'я')
                .build()
                .generate(8);
        return stringUpper(name);
    }

    private String stringUpper(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;
    }
}