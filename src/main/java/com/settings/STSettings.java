package com.settings;

/*
 * Copyright 2004-2016 EPAM Systems
 *
 * This file is part of JDI project.
 */

import java.io.IOException;

import static com.settings.STPropertiesReader.getProperties;
import static com.commons.PropertyReader.fillAction;

public abstract class STSettings {
    public static String emiasSettingsPath = "test.properties";
    public static boolean headles = true;

    public static synchronized void initFromProperties() throws IOException {
        getProperties(emiasSettingsPath);
        fillAction(p -> headles = p.toLowerCase().equals("true") || p.toLowerCase().equals("1"), "headless");
    }

    public static void initFromProperties(String propeortyPath) throws IOException {
        emiasSettingsPath = propeortyPath;
        initFromProperties();
    }
}