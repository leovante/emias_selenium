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

//import static com.commons.Settings.exception;

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

    @Override
    public void setRemoteHubUrl(String url) {
        remoteHubUrl = url;
    }
}