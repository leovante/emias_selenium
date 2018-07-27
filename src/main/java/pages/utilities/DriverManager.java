package pages.utilities;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DriverManager {
    public ChromeOptions chromeOptions;
    public FirefoxOptions firefoxOptions;
    public ChromeDriverService chromeDriverService;
    public GeckoDriverService geckoDriverService;
    public String browser;
    public WebDriver driver;

    public DriverManager(String browser) {
        this.browser = browser;
    }

    public void createDriver() {
        if (browser.equals("firefox")) {
//            this.geckoDriverService = new GeckoDriverService.Builder()
//                    .usingDriverExecutable(new File("src/main/resources/geckodriver.exe"))
//                    .usingAnyFreePort()
//                    .build();
//            this.firefoxOptions = new FirefoxOptions();
//            this.firefoxOptions.setHeadless(false);
//            this.firefoxOptions.addArguments("window-size=1300,1020");
//            driver = new FirefoxDriver(geckoDriverService, firefoxOptions);
        }
        if (browser.equals("chrome")) {
//            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//            System.setProperty("selenide.browser", "Chrome");

            ChromeDriverManager.getInstance().setup();
            Configuration.browser = browser;
            Configuration.headless = true;
            Configuration.timeout = 10000;
            Configuration.browserSize = "1910x1070";
            Configuration.startMaximized = true;
            Configuration.browserPosition = "0x0";

//            this.chromeDriverService = new ChromeDriverService.Builder()
//                    .usingDriverExecutable(new File("src/main/resources/chromedriver.exe"))
//                    .usingAnyFreePort()
//                    .build();
//            this.chromeOptions = new ChromeOptions();
//            this.chromeOptions.setHeadless(false);
//            this.chromeOptions.addArguments("window-size=1900,1020");
//            driver = new ChromeDriver(chromeDriverService, chromeOptions);
//            System.setProperty("selenide.browser", "Chrome");
        }
        System.out.println("DriverManager - " + getWebDriver());
    }
}