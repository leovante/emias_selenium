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

import java.net.MalformedURLException;

public abstract class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Pages page;
    public static String curUrlCalldoctor = null;

    @Parameters(value = {"browser", "platform"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String browser,
                            @Optional String platform,
                            ITestContext context) throws MalformedURLException {
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
    public void afterSuite() throws Exception {
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
        driver.get("http://mis.softrust.ru/mis/Main/Default");
        page.homePage().callDoctorBtn();
        pages.utilities.SwitchToPage.switchToPage();
        driver.get("http://109.95.224.42:2165/test/call/call_doctor_ui/call-doctor;709/board?ticket=bcNzk9MEiGwEe1JSseWBq4%2BI41Qaipq6K9uyshR50QBn1zJsAobTnQ3dJZiX8p10vS3nDLSdLkIenWZRdc8rc21FIczd%2FmQe9eHSAgKxVl8C9BS18t3q3DRl%2ByMO%2FUw1EvqtO6f%2B0gWzqXBQYR%2FlPpXi9%2FIUdctXYoHD9gMJnz0q9Qbvi%2FdF1G04Z6UssA0lwE6kMYIZQgZRqHH7x%2Bvq51aCcSgYGFM1ZVh%2FnxXLcghNdJjfMCsr4FbrB7ce0nN0MWs05RY%2BADgWMmIqR5vQOgpyNB5NxOPYXN%2F5Eo1aDITM96sI&ReturnUrl=http%3A%2F%2F192.168.7.139%2Fwhc%2FMain%2FDefault");
        String url = driver.getCurrentUrl();
        curUrlCalldoctor = url;
    }
}