package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static pages.AbstractPage.LOGGER;

public class WebDriverInstansiator {
    private Config conf;
    public String browser;
    public RemoteWebDriver driver;
    public ChromeOptions chromeOptions;
    public FirefoxOptions firefoxOptions;
    public DesiredCapabilities dcch;
    public static ChromeDriverService chromeDriverService;
    public Dimension dimension;
    public java.awt.Dimension screenSize;

    public WebDriverInstansiator(String browser) {
        conf = new Config();
        this.browser = browser;
    }

    public RemoteWebDriver setDriver(/*, BrowserMobProxy proxy*/) throws IOException {
        //ручной запуск
        if (browser == null) {
//            proxy.start(5300);
//            Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
//            proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
//            proxy.newHar("demo");

            chromeDriverService = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File("src/main/resources/selenium_grid/chromedriver.exe"))
                    .usingAnyFreePort()
                    .build();
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("window-size=1919,1079");
//            chromeOptions.addArguments("--proxy-server=localhost:", String.valueOf(proxy.getPort()));
            chromeOptions.setHeadless(conf.getHeadless());
//            chromeOptions.setProxy(seleniumProxy);

            this.driver = new ChromeDriver(chromeDriverService, chromeOptions);
            WebDriverRunner.setWebDriver(driver);
            Configuration.timeout = 20000;
            System.setProperty("webdriver.chrome.logfile", "D:\\chromedriver.log");
            System.setProperty("webdriver.chrome.verboseLogging", "true");
        }
        //селениум грид
        else {
            switch (browser) {
                case "firefox":
                    firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setHeadless(conf.getHeadless());
//                    firefoxOptions.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
//                    firefoxOptions.addArguments("--window-size=1919,1079");
//
//                    System.setProperty("webdriver.gecko.driver", "src/main/resources/selenium_grid/geckodriver.exe");
//                    dcch = DesiredCapabilities.firefox();
//                    dcch.setBrowserName("firefox");
//                    dcch.setCapability("marionette", true);
//                    dcch.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
//                    dcch.setCapability("headless", headless);

                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
//                    driver.manage().window().setSize(new Dimension(1919, 1079));
                    WebDriverRunner.setWebDriver(driver);
                    Configuration.timeout = 20000;
                    break;
                case "chrome":
                    chromeOptions = new ChromeOptions();
                    chromeOptions.setHeadless(conf.getHeadless());
                    chromeOptions.addArguments("window-size=1919,1079");
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
                    WebDriverRunner.setWebDriver(driver);
                    Configuration.timeout = 20000;
                    break;
            }
        }
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        dimension = getWebDriver().manage().window().getSize();

        if (!String.valueOf(dimension).equals("(1919, 1079)")) {
            throw new IllegalArgumentException("Ошибка. Размер окна браузера некорректный!" + dimension);
        } else {
            LOGGER.info(
                    "Monitor: " + (int) screenSize.getWidth() + "x" + (int) screenSize.getHeight() + "; " +
                            "Browser resolution: " + dimension + "; " +
                            "Headless: " + conf.getHeadless() + "; ");
        }

        Configuration.reportsFolder = "target/test-result/reports";
        return driver;
    }
}