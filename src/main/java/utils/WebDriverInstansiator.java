package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static pages.AbstractPage.LOGGER;

public class WebDriverInstansiator {
    private Config conf;
    public String browser;
    public WebDriver driver;
    RemoteWebDriver remoteDriver;

    public WebDriverInstansiator(String browser) {
        this.conf = new Config();
        this.browser = browser;
    }

    public void setDriver() throws IOException {
        //ручной запуск
        ChromeOptions chromeOptions;
        if (browser == null) {
            WebDriverManager.chromedriver().setup();
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("window-size=1919,1079");
            chromeOptions.setHeadless(conf.getHeadless());
            driver = new ChromeDriver(chromeOptions);
            WebDriverRunner.setWebDriver(driver);
            Configuration.timeout = 20000;
        }
        //селениум грид
        else {
            switch (browser) {
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setHeadless(conf.getHeadless());
//                    firefoxOptions.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
//                    firefoxOptions.addArguments("--window-size=1919,1079");
//
//                    System.setProperty("webdriver.gecko.remoteDriver", "src/main/resources/selenium_grid/geckodriver.exe");
//                    dcch = DesiredCapabilities.firefox();
//                    dcch.setBrowserName("firefox");
//                    dcch.setCapability("marionette", true);
//                    dcch.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
//                    dcch.setCapability("headless", headless);

                    remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
//                    remoteDriver.manage().window().setSize(new Dimension(1919, 1079));
                    WebDriverRunner.setWebDriver(remoteDriver);
                    Configuration.timeout = 20000;
                    break;
                case "chrome":
                    chromeOptions = new ChromeOptions();
                    chromeOptions.setHeadless(conf.getHeadless());
                    chromeOptions.addArguments("window-size=1919,1079");
                    remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
                    WebDriverRunner.setWebDriver(remoteDriver);
                    Configuration.timeout = 20000;
                    break;
            }
        }
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dimension = getWebDriver().manage().window().getSize();

        if (!String.valueOf(dimension).equals("(1919, 1079)")) {
            throw new IllegalArgumentException("Ошибка. Размер окна браузера некорректный!" + dimension);
        } else {
            LOGGER.info(
                    "Monitor: " + (int) screenSize.getWidth() + "x" + (int) screenSize.getHeight() + "; " +
                            "Browser resolution: " + dimension + "; " +
                            "Headless: " + conf.getHeadless() + "; ");
        }

        Configuration.reportsFolder = "target/test-result/reports";
        LOGGER.info("Тест начинается!");
    }

    public void driverClose() {
        if (driver != null) {
            driver.quit();//только так закрывается chromedriver.exe в диспетчере
//            WebDriverRunner.getWebDriver().close();
        }
        if (remoteDriver != null) {
            WebDriverRunner.closeWebDriver();
        }
        LOGGER.info("Тест завершен!");
    }
}