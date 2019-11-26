package com.utils;

import java.io.IOException;

import static java.lang.Runtime.getRuntime;
import static java.lang.String.format;
import static com.utils.Settings.logger;
public class WebDriverUtils {
    private WebDriverUtils() {
    }

    /**
     * @throws IOException
     */
    public static void killAllRunWebBrowsers() {
        String os = System.getProperty("os.name");
        try {
            if (os.contains("Mac")) {
                killAllMacOSDriverProcesses();
            } else {
                killAllWindowsDriverProcesses();
            }
        }
        catch (Exception ignore){
            logger.info("Can't kill driver processes");
        }
    }

    private static void killAllMacOSDriverProcesses() {
        killMacOSDriverProcesses("firefox");
        killMacOSDriverProcesses("chrome");
    }

    /**
     *
     */
    private static void killAllWindowsDriverProcesses() throws IOException {
        killByName("chromedriver");
        killByName("geckodriver");
        killByName("IEDriverServer");
        killByName("MicrosoftWebDriver");
    }

    private static void killByName(String value) throws IOException {
        getRuntime().exec(format("taskkill /F /IM %s.exe /T", value));
    }

    private static void killMacOSDriverProcesses(String browserName) {
        String name = null;
        switch (browserName.toLowerCase()) {
            case "firefox":
                name = "geckodriver";
                break;
            case "chrome":
                name = "chromedriver";
                break;

        }
        if (name != null) {
            killAllMacOSDriverProcessesByName(name);
        }
    }

    /**
     * @param driverName
     */
    private static void killAllMacOSDriverProcessesByName(String driverName) {
//        killProcessesTree(driverName);
    }

}
