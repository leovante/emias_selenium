package pages.utilities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebDriverInstansiator {
    public RemoteWebDriver driver;
    public FirefoxOptions firefoxOptions;
    public ChromeOptions chromeOptions;
    public String browser;

    public WebDriverInstansiator(String browser) {
        this.browser = browser;
    }


    public void setDriver(Boolean headless) throws MalformedURLException {
        if (browser.equals("firefox")) {
            FirefoxDriverManager.getInstance().setup();
            Configuration.timeout = 20000;

            firefoxOptions = new FirefoxOptions();
            firefoxOptions.setHeadless(headless);
            firefoxOptions.addArguments("window-size=1919,1079");

            DesiredCapabilities dc = DesiredCapabilities.firefox();
            dc.setCapability("marionette", true);
            dc.setBrowserName("firefox");

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
            WebDriverRunner.setWebDriver(driver);
        }
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            Configuration.browser = browser;
            Configuration.timeout = 20000;

            chromeOptions = new ChromeOptions();
            chromeOptions.setHeadless(headless);
            chromeOptions.addArguments("window-size=1919,1079");

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
            WebDriverRunner.setWebDriver(driver);
        }

        System.out.println("DriverManager - " + getWebDriver());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("Monitor resolution: " + (int)
                screenSize.getWidth() + "x" + (int) screenSize.getHeight());
        System.out.println("Chrome window resolution: " + getWebDriver().manage().window().getSize());
    }
}