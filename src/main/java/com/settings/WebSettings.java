package com.settings;

import com.logger.TestNGLogger;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.commons.PropertyReader.fillAction;
import static com.settings.STPropertiesReader.getProperties;

public class WebSettings extends STSettings {

    public static JavascriptExecutor getJSExecutor() {
        try {
            initFromProperties();
            if (getWebDriver() instanceof JavascriptExecutor)
                return (JavascriptExecutor) getWebDriver();
            else
                throw new ClassCastException("JavaScript Executor doesn't support");
        } catch (Throwable ex) {
            throw new RuntimeException("Can't Get JS Executor: " + ex.getMessage());
        }
    }

    public static synchronized void init() {
        try {
            logger = new TestNGLogger("ST Logger");
        } catch (Throwable e) {
            throw new RuntimeException("Can't init ST Settigns: " + e.getMessage());
        }
    }

    public static synchronized void initFromProperties(){
        try{
            init();
            getProperties(emiasSettingsPath);
            STSettings.initFromProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}