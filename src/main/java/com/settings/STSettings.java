package com.settings;

import com.logger.ILogger;

import java.io.IOException;

import static com.settings.STPropertiesReader.getProperties;
import static com.commons.PropertyReader.fillAction;

public abstract class STSettings {
    public static ILogger logger;
    public static String emiasSettingsPath = "test.properties";
    public static boolean headles = true;
    public static IDriver driverFactory;

    public static synchronized void initFromProperties() throws IOException {
        getProperties(emiasSettingsPath);
        fillAction(p -> headles = p.toLowerCase().equals("true") || p.toLowerCase().equals("1"), "headless");
        fillAction(driverFactory :: setRemoteHubUrl, "seleniumhub.url");
    }

    public static void initFromProperties(String propeortyPath) throws IOException {
        emiasSettingsPath = propeortyPath;
        initFromProperties();
    }
}