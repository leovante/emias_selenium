package com.commons;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.settings.ConfigFile;
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
import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.pages.WebPage.logger;
import static com.settings.STSettings.headles;
import static com.settings.STSettings.seleniumhubUrl;
import static com.settings.WebSettings.browserType;

public class WebDriverInstansiator {
    private RemoteWebDriver remoteDriver;
    private WebDriver driver;

    public void setDriver()   {
        //ручной запуск
        ChromeOptions chromeOptions;
        if (browserType == null) {
            WebDriverManager.chromedriver().setup();
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("window-size=1919,1079");
            chromeOptions.setHeadless(false);
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().setPosition(new Point(0, 0));
            WebDriverRunner.setWebDriver(driver);
        }
        else {
            switch (browserType) {
                case "firefox":
                    System.setProperty("webdriver.gecko.remoteDriver", "%userprofile%/Google Drive/chromedriver/geckodriver.exe");
                    System.setProperty("webdriver.gecko.driver", "%userprofile%/Google Drive/chromedriver/geckodriver.exe");
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    try {
                        remoteDriver = new RemoteWebDriver(new URL(seleniumhubUrl + "wd/hub"), firefoxOptions);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    remoteDriver.manage().window().setSize(new Dimension(1919, 1079));
                    remoteDriver.manage().window().setPosition(new Point(0,0));
                    WebDriverRunner.setWebDriver(remoteDriver);
                    break;
                case "chrome":
                    chromeOptions = new ChromeOptions();
                    chromeOptions.setHeadless(headles);
                    chromeOptions.addArguments("window-size=1919,1079");
                    try {
                        remoteDriver = new RemoteWebDriver(new URL(seleniumhubUrl + "wd/hub"), chromeOptions);
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
                            "Headless: " + headles + "; ");
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