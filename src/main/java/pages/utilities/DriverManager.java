package pages.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;

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

    public WebDriver createDriver() {
        if (browser.equals("firefox")) {
            this.geckoDriverService = new GeckoDriverService.Builder()
                    .usingDriverExecutable(new File("src/resources/geckodriver.exe"))
                    .usingAnyFreePort()
                    .build();
            this.firefoxOptions = new FirefoxOptions();
            this.firefoxOptions.setHeadless(false);
            this.firefoxOptions.addArguments("window-size=1300,1020");
            driver = new FirefoxDriver(geckoDriverService, firefoxOptions);
        } else {
            this.chromeDriverService = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File("src/resources/chromedriver.exe"))
                    .usingAnyFreePort()
                    .build();
            this.chromeOptions = new ChromeOptions();
            this.chromeOptions.setHeadless(false);
            this.chromeOptions.addArguments("window-size=1300,1020");
            driver = new ChromeDriver(chromeDriverService, chromeOptions);
        }
//        else {
//            Assert.assertTrue(false, "There is a problem on browser selection! Please check testng xml file!");
//        }
        return driver;
    }
}

//    @Before
//    public void setUp() throws InterruptedException, AWTException {
//        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setHeadless(false);
//        webDriver = new ChromeDriver(chromeOptions);
//        step = new Steps(webDriver);
//        step.loginPage().loginEmias();
//    }
