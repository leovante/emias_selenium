package com.settings;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.commons.Settings.exception;

import static com.settings.DownloadDriverManager.downloadDriver;
import static com.settings.DownloadDriverManager.shouldDownloadDriver;
import static com.settings.DriverTypes.*;
import static com.settings.RunTypes.LOCAL;
import static java.lang.System.setProperty;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.openqa.selenium.ie.InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS;
import static org.openqa.selenium.remote.CapabilityType.PAGE_LOAD_STRATEGY;

public class SeleniumDriverFactory implements IDriver<WebDriver>{
    public String remoteHubUrl;
    public RunTypes runType = LOCAL;
    private String driversPath = FOLDER_PATH;
    static final String FOLDER_PATH = new File("").getAbsolutePath() + "\\src\\main\\resources\\driver\\";
    public static String pageLoadStrategy = "normal";
    public static String currentDriverName = "CHROME";

    @Override
    public void setRemoteHubUrl(String url) {
        remoteHubUrl = url;
    }

    @Override
    public String registerDriver(String driverName) {
        switch (driverName.toLowerCase()) {
            case "chrome":
                return registerDriver(CHROME);
            case "firefox":
                return registerDriver(FIREFOX);
            case "ie":
            case "internetexplorer":
                return registerDriver(IE);
            default:
                throw exception("Register driver failed. Unknown driver: " + driverName);
        }
    }

    public String registerDriver(DriverTypes driverType){
        switch (runType) {
            case LOCAL:
                return registerLocalDriver(driverType);
            case REMOTE:
                return registerDriver("Remote " + driverType,
                        () -> new RemoteWebDriver(getRemoteURL(), getCapabilities(driverType)));
        }
        throw exception("Register driver failed. Unknown driver: " + driverType);
    }

    private URL getRemoteURL() {
        try {
            if (!isBlank(remoteHubUrl)) {
                String url = remoteHubUrl.replaceAll("/*$", "/");
                if (!url.contains("wd/hub"))
                    url += "wd/hub/";
                return new URL(url);
            }
            throw exception("You run tests in Remote mode, please specify 'remote.url' in test.properties");
        } catch(Exception ex) { throw exception("Can't get remote Url: " + ex.getMessage()); }
    }

    private Capabilities getCapabilities(DriverTypes driverType) {
        switch (driverType) {
            case CHROME: return defaultChromeOptions();
            case FIREFOX: return defaultFirefoxOptions();
            case IE: return defaultIEOptions();
        }
        throw exception("Get capabilities failed. Unknown driver: " + driverType);
    }

    public String registerLocalDriver(DriverTypes driverType){
        if (shouldDownloadDriver())
            downloadDriver(driverType);
        else setUpDrivers(driverType);
        return registerDriver(driverType, getDefaultDriver(driverType));
    }

    private Supplier<WebDriver> getDefaultDriver(DriverTypes driverType) {
        switch (driverType) {
            case CHROME: return () -> new ChromeDriver(defaultChromeOptions());
            case FIREFOX: return () -> new FirefoxDriver(defaultFirefoxOptions());
            case IE: return () -> new InternetExplorerDriver(defaultIEOptions());
        }
        throw exception("Unknown driver: " + driverType);
    }

    public static Function<MutableCapabilities, MutableCapabilities> modifyCapabilities =
            cap -> { cap.setCapability(PAGE_LOAD_STRATEGY, pageLoadStrategy); return cap; };

    public FirefoxOptions defaultFirefoxOptions() {
        FirefoxOptions cap = new FirefoxOptions();
        return (FirefoxOptions) modifyCapabilities.apply(cap);
    }

    public ChromeOptions defaultChromeOptions() {
        ChromeOptions cap = new ChromeOptions();
        return (ChromeOptions) modifyCapabilities.apply(cap);
    }
    public InternetExplorerOptions defaultIEOptions() {
        InternetExplorerOptions cap = new InternetExplorerOptions();
        cap.setCapability(INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        cap.setCapability("ignoreZoomSetting", true);
        //cap.setCapability("requireWindowFocus", true);
        return (InternetExplorerOptions) modifyCapabilities.apply(cap);
    }

    public String registerDriver(DriverTypes driverType, Supplier<WebDriver> driver) {
        int numerator = 2;
        String driverName = driverType.toString();
        // TODO correct constant 100
        while (!drivers.add(driverName, driver) && numerator < 100)
            driverName = driverType.toString() + numerator++;
        currentDriverName = driverName;
        return driverName;
    }

    public String registerDriver(String driverName, Supplier<WebDriver> driver) {
        if (!drivers.add(driverName, driver))
            throw exception("Can't register WebDriver '%s'. Driver with same name already registered", driverName);
        currentDriverName = driverName;
        return driverName;
    }

    private void setUpDrivers(DriverTypes driverType){
        switch (driverType) {
            case CHROME: setProperty("webdriver.chrome.driver",
                    getChromeDriverPath(getDriverPath())); break;
            case FIREFOX: setProperty("webdriver.gecko.driver",
                    getFirefoxDriverPath(getDriverPath())); break;
            case IE: setProperty("webdriver.ie.driver",
                    getIEDriverPath(getDriverPath())); break;
            default: throw exception("Setup driver failed. Wrong driver type: " + driverType);
        }
    }

    static final String getChromeDriverPath(String folderPath) {
        return (checkOS().equals("win") ? folderPath + "\\chromedriver.exe" : folderPath + "\\chromedriver").replace("\\", File.separator);
    }

    static final String getFirefoxDriverPath(String folderPath) {
        return (checkOS().equals("win") ? folderPath + "\\geckodriver.exe" : folderPath + "\\geckodriver").replace("\\", File.separator);
    }

    static final String getIEDriverPath(String folderPath) {
        return (folderPath + "\\IEDriverServer.exe").replace("\\", File.separator);
    }

    static String checkOS() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            return "mac";
        } else if (osName.contains("win") || osName.contains("ms")) {
            return "win";
        } else {
            return "nix";
        }
    }

    public String getDriverPath() {
        return driversPath;
//        return correctPath(driversPath);
    }
}