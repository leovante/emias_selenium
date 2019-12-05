package com.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.config.ConfigFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.SkipException;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.pages.BasePage.logger;

public class WebDriverInstansiator {
    private RemoteWebDriver remoteDriver;
    private ConfigFile conf;
    public String browser;
    public WebDriver driver;

    public WebDriverInstansiator(String browser) {
        this.conf = new ConfigFile();
        this.browser = browser;
    }

    public void setDriver()   {
        //ручной запуск
        ChromeOptions chromeOptions;
        if (browser == null) {
//            System.setProperty("webdriver.chrome.driver", "%userprofile%/Google Drive/chromedriver/chromedriver.exe");
//            new ChromeDriverService.Builder()
//                    .usingDriverExecutable(new File("%userprofile%/Google Drive/chromedriver/chromedriver.exe"))
//                    .usingAnyFreePort()
//                    .build();
            WebDriverManager.chromedriver().setup();
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("window-size=1919,1079");
            chromeOptions.setHeadless(false);
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().setPosition(new Point(0, 0));
            WebDriverRunner.setWebDriver(driver);
        }
        //селениум грид
        else {
            switch (browser) {
                case "firefox":
                    System.setProperty("webdriver.gecko.remoteDriver", "%userprofile%/Google Drive/chromedriver/geckodriver.exe");
                    System.setProperty("webdriver.gecko.driver", "%userprofile%/Google Drive/chromedriver/geckodriver.exe");

                    FirefoxOptions firefoxOptions = new FirefoxOptions();
//                    firefoxOptions.setHeadless(conf.getHeadless());
//                    firefoxOptions.setLegacy(true);
//                    firefoxOptions.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
//                    firefoxOptions.addArguments("--window-size=1919,1079");
//

                    DesiredCapabilities dcch = DesiredCapabilities.firefox();
//                    dcch.setBrowserName("firefox");
//                    dcch.setCapability("marionette", true);
//                    dcch.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
//                    dcch.setCapability("headless", conf.getHeadless());

                    try {
                        remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    remoteDriver.manage().window().setSize(new Dimension(1919, 1079));
                    remoteDriver.manage().window().setPosition(new Point(0,0));
                    WebDriverRunner.setWebDriver(remoteDriver);
                    break;
                case "chrome":
                    chromeOptions = new ChromeOptions();
                    chromeOptions.setHeadless(conf.getHeadless());
                    chromeOptions.addArguments("window-size=1919,1079");
                    try {
                        remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    remoteDriver.manage().window().setPosition(new Point(0,0));
                    WebDriverRunner.setWebDriver(remoteDriver);
                    break;
            }
        }
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dimension = getWebDriver().manage().window().getSize();

        if (!String.valueOf(dimension).equals("(1919, 1079)")) {
            logger.error("Error. Incorrect windows size dimension");
            throw new SkipException("Ошибка. Размер окна браузера некорректный!" + dimension);
        } else {
            logger.info(
                    "Monitor: " + (int) screenSize.getWidth() + "x" + (int) screenSize.getHeight() + "; " +
                            "Browser resolution: " + dimension + "; " +
                            "Headless: " + conf.getHeadless() + "; ");
        }
        Configuration.timeout = 20000;
        Configuration.reportsFolder = "target/test-result/reports";
        Configuration.savePageSource = false;
        logger.info("Selenium driver is ready");
    }

    public void driverClose() {
        if (driver != null) {
            driver.quit();//только так закрывается chromedriver.exe в диспетчере
//            WebDriverRunner.getWebDriver().close();
        }
        if (remoteDriver != null) {
            WebDriverRunner.closeWebDriver();
        }
        logger.info("Selenium driver is close");
    }
}