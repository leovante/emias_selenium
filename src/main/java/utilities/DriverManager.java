package utilities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.awt.*;
import java.io.File;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static pages.AbstractPage.LOGGER;

@Deprecated
public class DriverManager {
    public ChromeOptions chromeOptions;
    public ChromeDriverService chromeDriverService;
    public FirefoxOptions firefoxOptions;
    public GeckoDriverService geckoDriverService;
    public String browser;
    public WebDriver driver;

    public DriverManager(String browser) {
        this.browser = browser;
    }

    public WebDriver createDriver(Boolean headless) {
        if (browser.equals("firefox")) {
//            this.geckoDriverService = new GeckoDriverService.Builder()
//                    .usingDriverExecutable(new File("src/main/resources/geckodriver.exe"))
//                    .usingAnyFreePort()
//                    .build();
//            this.options = new FirefoxOptions();
//            this.options.setHeadless(false);
//            this.options.addArguments("window-size=1300,1020");
//            driver = new FirefoxDriver(geckoDriverService, options);
        }
        if (browser.equals("chrome")) {
//            ChromeDriverManager.getInstance().setup();
//            Configuration.browser = browser;
//            Configuration.headless = true;
//            Configuration.timeout = 10000;
//            Configuration.browserSize = "1920x1070";
//            Configuration.browserPosition = "0x0";
//            this.driver = getWebDriver();
//            driver.manage().window().setSize(new Dimension(1920, 1080));

            this.chromeDriverService = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File("src/main/resources/chromedriver.exe"))
                    .usingAnyFreePort()
                    .build();
            this.chromeOptions = new ChromeOptions();
            this.chromeOptions.setHeadless(headless);
            this.chromeOptions.addArguments("window-size=1919,1079");
            driver = new ChromeDriver(chromeDriverService, chromeOptions);
            WebDriverRunner.setWebDriver(driver);
            Configuration.timeout = 20000;

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            LOGGER.info("Monitor resolution: " + (int) screenSize.getWidth() + "x" + (int) screenSize.getHeight());
            LOGGER.info("Chrome window resolution: " + getWebDriver().manage().window().getSize());
        }
        LOGGER.info("DriverManager - " + getWebDriver());
        return driver;
    }

    /*public class WebDriverFactory {
    public static WebDriver createWebDriver() {
        String webdriver = System.getProperty("browser", "firefox");
        switch(webdriver) {
            case "firefox":
                return new FirefoxDriver();
            case "chrome":
                return new ChromeDriver();
            default:
                throw new RuntimeException("Unsupported webdriver: " + webdriver);
        }
    }
}*/
}