package com.utils;

import java.io.IOException;
import java.util.Properties;

public class JDIpropertiesReader {
    public static Properties getProperties(String path) throws IOException {
        Properties p = PropertyReader.getProperties("/../../target/classes/" + path);
        return p.size() > 0 ? p : PropertyReader.getProperties(path);
    }

}
