package pages.utilities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverInstansiator {
    public static RemoteWebDriver driver;
    public static ChromeOptions chromeOptions;

//    private static InheritableThreadLocal<WebDriver> webDriver = new InheritableThreadLocal<WebDriver>();
//    private static WebDriverFactory factory;

    public static void setDriver(String browser, String browserVersion) throws MalformedURLException {
        ChromeDriverManager.getInstance().setup();
        Configuration.browser = browser;

        chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        chromeOptions.addArguments("window-size=1919,1079");

        DesiredCapabilities dc = DesiredCapabilities.chrome();
        dc.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        driver = new RemoteWebDriver(new URL("http://172.16.101.70:4444/wd/hub"), dc);
        WebDriverRunner.setWebDriver(driver);

//        factory = new WebDriverFactory();
//        webDriver.set(factory.createWebDriver();
//        webDriver.set(factory.getWebDriver(browser, browserVersion));
    }

//    public static WebDriver getDriver() {
//        return webDriver.get();
//    }


}