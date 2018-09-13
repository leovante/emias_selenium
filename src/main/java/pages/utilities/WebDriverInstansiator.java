package pages.utilities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebDriverInstansiator {
    public DesiredCapabilities dc;
    public RemoteWebDriver driver;
    public FirefoxOptions firefoxOptions;
    public ChromeOptions chromeOptions;
    public String browser;

    public WebDriverInstansiator(String browser) {
        this.browser = browser;
    }

    public void setDriver(Boolean headless) throws MalformedURLException {
        switch (browser) {
            case "firefox":
                firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(headless);
                firefoxOptions.addArguments("window-size=1919,1079");

                dc = DesiredCapabilities.firefox();
                dc.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);

                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
                WebDriverRunner.setWebDriver(driver);
                Configuration.timeout = 20000;
            case "chrome":
                chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(headless);
                chromeOptions.addArguments("window-size=1919,1079");

                dc = DesiredCapabilities.chrome();
                dc.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
                WebDriverRunner.setWebDriver(driver);
                Configuration.timeout = 20000;
        }
        System.out.println("DriverManager - " + getWebDriver());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("Monitor resolution: " + (int)
                screenSize.getWidth() + "x" + (int) screenSize.getHeight());
        System.out.println("Chrome window resolution: " + getWebDriver().manage().window().getSize());
    }
}