package pages.utilities;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverManager {

    public DesiredCapabilities caps = null;
    public ChromeOptions options = null;
    public String browser = null;
    public WebDriver driver = null;

    public DriverManager(DesiredCapabilities capabilities, String browser) {
        this.caps = capabilities;
        this.browser = browser;
    }

    public WebDriver createDriver() {
        if (browser.equals("firefox")) {
//            driver = new FirefoxDriver(options);
        } else if (browser.equals("chrome")) {
            driver = new ChromeDriver(options);
        } else {
            Assert.assertTrue(false, "There is a problem on browser selection! Please check testng xml file!");
        }
        return driver;
    }
}

//    @Before
//    public void setUp() throws InterruptedException, AWTException {
//        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(false);
//        webDriver = new ChromeDriver(options);
//        step = new Steps(webDriver);
//        step.loginPage().loginEmias();
//    }
