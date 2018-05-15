package pages.utilities;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeOptionsManager {

    public DesiredCapabilities getDesiredOptions(String browser, String platform) {

        //Set DesiredCapabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //Chrome Profile Settings
        if (browser.equals("chrome")) {
            setChromeOps(capabilities);
        } else if(browser.equals("firefox")) {
            setFirefoxOps(capabilities);
        }

//        //Set Platform
//        capabilities.setCapability("platform", platform);
//        //Set BrowserName
//        capabilities.setCapability("browserName", browser);
//        //Return Capabilities
        return capabilities;
    }

    //Set Firefox Capabilities
    private void setFirefoxOps(DesiredCapabilities capabilities) {
        FirefoxProfile profile = new FirefoxProfile();
        //Accept Untrusted Certificates
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        //Use No Proxy Settings
        profile.setPreference("network.proxy.type", 0);
        //Set Firefox profile to capabilities
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
    }

    public void setChromeOps(DesiredCapabilities capabilities) {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
//        options.addArguments("test-type");
//        options.addArguments("disable-popup-blocking");
//        options.addArguments("ignore-certificate-errors");
//        options.addArguments("disable-translate");
//        options.addArguments("start-maximized");
        options.setHeadless(false);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }
}

//    @Before
//    public void setUp() throws InterruptedException, AWTException {
//        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(false);
//    }
