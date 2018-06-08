import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.Pages;
import pages.utilities.ChromeOptionsManager;
import pages.utilities.JSWaiter;
import pages.utilities.SwitchToPage;
import pages.utilities.Waiter;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Arrays;

public abstract class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    //    private DesiredCapsManager desiredCapsManager = new DesiredCapsManager();
    private ChromeOptionsManager chromeOptionsManager = new ChromeOptionsManager();
    Pages page;
    ScreenshotListener listner;

    @Parameters(value = {"browser", "platform"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String browser, @Optional String platform) throws MalformedURLException {
        System.out.println("Browser: " + browser);
        System.out.println("Platform: " + platform);

        //КОРОЧЕ изучить как работает менеджер

//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("src/resources/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        ChromeOptions options = new ChromeOptions();
//        options.merge(capabilities);
        options.setHeadless(false);
        options.addArguments("window-size=1300,1020");
//        ChromeDriver driver = new ChromeDriver(service, options);
        driver = new ChromeDriver(service, options);
//more capabilit https://sites.google.com/a/chromium.org/chromedriver/capabilities

//        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");

        //Get DesiredCapabilities
//        ChromeOptions options = new ChromeOptions();
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //Create Driver with capabilities
//        driver = new DriverManager(options).createDriver();
        JSWaiter.setDriver(driver);
        SwitchToPage.setDriver(driver);
        Waiter.setDriver(driver);
        wait = new WebDriverWait(driver, 20);
        page = new Pages(driver);
        listner = new ScreenshotListener(driver);

        page.loginPage().login();
    }

    @AfterSuite
    public void afterSuite() throws Exception {
        driver.quit();
    }


    @BeforeGroups("CallDoctorRegress")
    public void beforeGroupsRegress() {
        page.homePage().callDoctorBtn();
        pages.utilities.SwitchToPage.switchToPage();
    }

    @AfterGroups("CallDoctorRegress")
    public void afterGroupsRegress() {
        page.dashboardPage().exitToMis();
    }

    @BeforeGroups("regress")
    public void beforeGroups() {
        page.homePage().callDoctorBtn();
        pages.utilities.SwitchToPage.switchToPage();
    }

    @AfterGroups("regress")
    public void afterGroups() {
        page.dashboardPage().exitToMis();
    }


    public static void takeSnapShot(WebDriver webdriver, ITestResult testResult) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("errorScreenshots\\" + testResult.getTestClass() + "-"
                + Arrays.toString(testResult.getParameters()) + ".png");
        FileUtils.copyFile(SrcFile, DestFile);
    }
}