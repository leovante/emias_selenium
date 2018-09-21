package pages.utilities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebDriverInstansiator {
    public String browser;
    public RemoteWebDriver driver;

    public WebDriverInstansiator(String browser) {
        this.browser = browser;
    }

    public RemoteWebDriver setDriver(Boolean headless) throws MalformedURLException {
        switch (browser) {
            case "firefox":
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(headless);

                DesiredCapabilities dcff = DesiredCapabilities.firefox();
                dcff.setBrowserName("firefox");
                dcff.setCapability("marionette", true);
                dcff.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
                dcff.setCapability("headless", headless);

                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dcff);
                driver.manage().window().setSize(new Dimension(1919, 1079));
                WebDriverRunner.setWebDriver(driver);
                Configuration.timeout = 20000;
                break;
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(headless);
//                chromeOptions.addArguments("window-size=1919,1079");

                DesiredCapabilities dcch = DesiredCapabilities.chrome();
                dcch.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dcch);
                WebDriverRunner.setWebDriver(driver);
                Configuration.timeout = 20000;
                break;
        }
//        System.out.println("DriverManager - " + getWebDriver());
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(
                "Monitor: " + (int) screenSize.getWidth() + "x" + (int) screenSize.getHeight() + "; " +
                        "Browser resolution: " + getWebDriver().manage().window().getSize() + "; " +
                        "Headless: " + headless + "; ");
        return driver;
    }
}