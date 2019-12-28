package com.settings;

import com.logger.ILogger;

import java.io.IOException;

import static com.settings.STPropertiesReader.getProperties;
import static com.commons.PropertyReader.fillAction;

public abstract class STSettings {
    public static ILogger logger;
    public static String emiasSettingsPath = "test.properties";
    public static boolean headles = true;
    public static String standUrl;
    public static String seleniumhubUrl;
    public static boolean standValid;
    public static IDriver driverFactory;

    public static synchronized void initFromProperties() throws IOException {
        getProperties(emiasSettingsPath);
        fillAction(p -> headles = p.toLowerCase().equals("true") || p.toLowerCase().equals("1"), "st.test.headless");
        fillAction(p -> standUrl = p, "st.test.standUrl");
        fillAction(p -> seleniumhubUrl = p, "st.test.seleniumhubUrl");
        fillAction(p -> standValid = Boolean.parseBoolean(p), "st.test.standvalid");
    }

    public static void initFromProperties(String propeortyPath) throws IOException {
        emiasSettingsPath = propeortyPath;
        initFromProperties();
    }
}