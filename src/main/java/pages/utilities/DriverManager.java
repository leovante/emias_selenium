package pages.utilities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import ru.stqa.selenium.factory.WebDriverPool;

import java.awt.*;
import java.io.File;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

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

    public WebDriver createDriver() {


        switch (browser) {
            case "firefox":
                this.geckoDriverService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(new File("src/main/resources/geckodriver.exe"))
                        .usingAnyFreePort()
                        .build();
                this.firefoxOptions = new FirefoxOptions();
                this.firefoxOptions.setHeadless(true);
                this.chromeOptions.addArguments("window-size=1900,1020");
                driver = new FirefoxDriver(geckoDriverService, firefoxOptions);
                WebDriverRunner.setWebDriver(driver);
                Configuration.timeout = 20000;
                Dimension screenSizeFF = Toolkit.getDefaultToolkit().getScreenSize();
                System.out.println("Monitor resolution: " + (int) screenSizeFF.getWidth() + "x" + (int) screenSizeFF.getHeight());
                System.out.println("Chrome window resolution: " + getWebDriver().manage().window().getSize());
                break;
            case "chrome":
//                ChromeDriverManager.getInstance().setup();
//                Configuration.browser = browser;
////                Configuration.headless = true;
//                Configuration.timeout = 20000;
//                Configuration.browserSize = "1919x1079";
//                Configuration.browserPosition = "0x0";
//                this.driver = getWebDriver();

//                driver.manage().window().setSize(new Dimension(1920, 1080));
//                this.chromeDriverService = new ChromeDriverService.Builder()
//                        .usingDriverExecutable(new File("src/main/resources/chromedriver.exe"))
//                        .usingAnyFreePort()
//                        .build();
//                this.chromeOptions = new ChromeOptions();
//                this.chromeOptions.setHeadless(true);
//                this.chromeOptions.addArguments("window-size=1919,1079");
//                driver = new ChromeDriver(chromeDriverService, chromeOptions);
                driver = WebDriverPool.DEFAULT.getDriver(new ChromeOptions());

                WebDriverRunner.setWebDriver(driver);
                Configuration.timeout = 20000;

                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                System.out.println("Monitor resolution: " + (int) screenSize.getWidth() + "x" + (int) screenSize.getHeight());
                System.out.println("Chrome window resolution: " + getWebDriver().manage().window().getSize());
                break;
        }
//        System.out.println("DriverManager - " + getWebDriver());
        return driver;
    }
}