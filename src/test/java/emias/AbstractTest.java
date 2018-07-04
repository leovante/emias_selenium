package emias;

//import org.codehaus.plexus.util.FileUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.Pages;
import pages.utilities.DriverManager;
import pages.utilities.JSWaiter;
import pages.utilities.SwitchToPage;
import pages.utilities.Waiter;

public abstract class AbstractTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Pages page;
    public static String curUrlCalldoctor = null;

    @Parameters(value = {"browser", "platform"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String browser,
                            @Optional String platform,
                            ITestContext context) {
        System.out.println("Browser: " + browser);
        System.out.println("Platform: " + platform);
        driver = new DriverManager(browser).createDriver();
        wait = new WebDriverWait(driver, 20);
        page = new Pages(driver);
        JSWaiter.setDriver(driver);
        SwitchToPage.setDriver(driver);
        Waiter.setDriver(driver);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        driver.quit();
    }

    @Parameters(value = {"site", "login", "pass"})
    @BeforeGroups(groups = "CD", alwaysRun = true)
    public void beforeGroupsCD(@Optional String site,
                               @Optional String login,
                               @Optional String pass) {
        System.out.println("Site: " + site);
        page.loginPage().login(site, login, pass);
        page.homePage().callDoctorBtn();
        pages.utilities.SwitchToPage.switchToPage();
        String url = driver.getCurrentUrl();
        curUrlCalldoctor = url;
    }

    @AfterGroups(groups = "CD", alwaysRun = true)
    public void afterGroupsCD() {
        page.dashboardPage().exitToMis();
    }

    @Parameters(value = {"site", "login", "pass"})
    @BeforeGroups(groups = "mis", alwaysRun = true)
    public void beforeGroupsMIS(@Optional String site,
                                @Optional String login,
                                @Optional String pass) {
        System.out.println("Site: " + site);
        page.loginPage().login(site, login, pass);
        String url = driver.getCurrentUrl();
        curUrlCalldoctor = url;
    }

    @AfterGroups(groups = "mis", alwaysRun = true)
    public void afterGroupsMIS() {
        System.out.println();
    }

    @BeforeGroups(groups = "CC", alwaysRun = true)
    public void beforeGroupsCC() {
    }

    @Parameters(value = {"site", "login", "pass"})
    @BeforeGroups(groups = "test", alwaysRun = true)
    public void beforeGroupsTest(@Optional String site,
                                 @Optional String login,
                                 @Optional String pass) {
        System.out.println("Site: " + site);
        page.loginPage().login(site, login, pass);
//        driver.get("http://mis.softrust.ru/mis/Main/Default");
        page.homePage().callDoctorBtn();
        pages.utilities.SwitchToPage.switchToPage();
        String url = driver.getCurrentUrl();
        curUrlCalldoctor = url;
    }
}