package mis;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.Pages;
import pages.utilities.DriverManager;
import pages.utilities.JSWaiter;
import pages.utilities.SwitchToPage;
import pages.utilities.Waiter;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Arrays;

public abstract class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Pages page;

//    ScreenshotListener listner;

    @Parameters(value = {"browser", "platform"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String browser, @Optional String platform) throws MalformedURLException {
        System.out.println("Browser: " + browser);
        System.out.println("Platform: " + platform);
        driver = new DriverManager(browser).createDriver();
        JSWaiter.setDriver(driver);
        SwitchToPage.setDriver(driver);
        Waiter.setDriver(driver);
        wait = new WebDriverWait(driver, 20);
        page = new Pages(driver);
//        listner = new ScreenshotListener(driver);

        page.loginPage().login();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() throws Exception {
        driver.quit();
    }

    @BeforeGroups(groups = "mis", alwaysRun = true)
    public void beforeGroups() {
        page.homePage().callDoctorBtn();
        pages.utilities.SwitchToPage.switchToPage();
    }

    @BeforeGroups(groups = "shedule", alwaysRun = true)
    public void beforeGroupsShedule() {
    }

    @AfterGroups(groups = "shedule", alwaysRun = true)
    public void afterGroupsShedule() {
    }

    @BeforeGroups(groups = "CC", alwaysRun = true)
    public void beforeGroupsCC() {
    }

    public static void takeSnapShot(WebDriver webdriver, ITestResult testResult) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("errorScreenshots\\" + testResult.getTestClass() + "-"
                + Arrays.toString(testResult.getParameters()) + ".png");
        FileUtils.copyFile(SrcFile, DestFile);
    }
}