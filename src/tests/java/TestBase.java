import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.Pages;
import pages.utilities.DesiredCapsManager;
import pages.utilities.DriverManager;
import pages.utilities.JSWaiter;

import java.net.MalformedURLException;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private DesiredCapsManager desiredCapsManager = new DesiredCapsManager();
    Pages page;

    //Do the test setup
    @BeforeClass
    @Parameters(value={"browser","platform"})
    public void setupTest (@Optional String browser, @Optional String platform) throws MalformedURLException {
        System.out.println("Browser: " + browser);
        System.out.println("Platform: " + platform);

        //Get DesiredCapabilities
        DesiredCapabilities capabilities = desiredCapsManager.getDesiredCapabilities(browser,platform);
        //Create Driver with capabilities
        driver = new DriverManager(capabilities, browser).createDriver();
        //Send driver object to JSWaiter Class
        JSWaiter.setDriver(driver);
        //This is the default wait for Explicit Waits
        wait = new WebDriverWait(driver,15);
        //Create pages.pages object
        page = new Pages(driver);
    }

    @AfterClass
    public void tearDown() throws Exception {
//        driver.quit();
    }
}

//        switch (stendNum) {
//                case 1:
//                webDriver.get("http://emias.mosreg.ru/mis/test_emias");
//                website.loginPage().enterLoginText("seleniumAdmin");
//                website.loginPage().enterPasswordText("1212");
//                break;
//                case 2:
//                webDriver.get("http://mis.softrust.ru/whc/Home");
//                website.loginPage().enterLoginText("admin");
//                website.loginPage().enterPasswordText("11");
//                break;
//                case 3:
//                webDriver.get("http://emias.mosreg.ru/mis/test_emias");
//                website.loginPage().enterLoginText("seleniumDoctor");
//                website.loginPage().enterPasswordText("1");
//                break;
//                }
