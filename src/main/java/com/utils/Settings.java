package com.utils;

import com.utils.interfaces.IAsserter;
import com.utils.interfaces.IDriver;
import com.utils.logger.ILogger;
import com.utils.logger.LogLevels;

import java.io.IOException;

import static com.utils.PropertyReader.fillAction;
import static java.lang.Integer.parseInt;

public abstract class Settings {
    public static ILogger logger;
    public static IAsserter asserter;
    public static TimeoutSettings timeouts = new TimeoutSettings();
    public static boolean isDemoMode;
    public static HighlightSettings highlightSettings = new HighlightSettings();
    public static boolean shortLogMessagesFormat = true;
    public static String jdiSettingsPath = "config.properties";
    public static IDriver driverFactory;
    public static boolean USE_CACHE = false;

    protected Settings() {
    }

    public static void toLog(String message, LogLevels level) {
        switch (level) {
            case STEP:
                logger.step(message);
                break;
            case INFO:
                logger.info(message);
                break;
            case ERROR:
                logger.error(message);
                break;
            default:
                logger.debug(message);
        }
    }

    public static String useDriver(String driverName) {
        return driverFactory.registerDriver(driverName);
    }

    public static synchronized void initFromProperties() throws IOException {
        JDIpropertiesReader.getProperties(jdiSettingsPath);
        fillAction(p -> shortLogMessagesFormat = p.toLowerCase().equals("short"), "log.message.format");
        fillAction(p -> USE_CACHE = p.toLowerCase().equals("true") || p.toLowerCase().equals("1"), "cache");
        fillAction(p -> isDemoMode = p.toLowerCase().equals("true") || p.toLowerCase().equals("1"), "demo.mode");
        fillAction(p -> highlightSettings.setTimeoutInSec(parseInt(p)), "demo.delay");
        fillAction(p -> timeouts.setDefaultTimeoutSec(parseInt(p)), "timeout.wait.element");
        fillAction(driverFactory::setRunType, "run.type");
        fillAction(driverFactory::setRemoteHubUrl, "remote.url");
        fillAction(driverFactory::registerDriver, "driver");
        // fillAction(p -> timeouts.waitPageLoadSec = parseInt(p), "timeout.wait.pageLoad");
    }

    public static void initFromProperties(String propertyPath) throws IOException {
        jdiSettingsPath = propertyPath;
        initFromProperties();
    }
    public static RuntimeException exception(String msg, Object... args) {
        return asserter.exception(msg, args);
    }
}
