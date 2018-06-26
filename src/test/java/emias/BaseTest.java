package emias;

//import org.codehaus.plexus.util.FileUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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

//    ScreenshotListener listner;

    @Parameters(value = {"browser", "platform", "site", "login", "pass"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String browser, @Optional String platform, @Optional String site, @Optional String login, @Optional String pass) throws MalformedURLException {
        System.out.println("Browser: " + browser);
        System.out.println("Platform: " + platform);
        System.out.println("Site: " + site);
        driver = new DriverManager(browser).createDriver();
        JSWaiter.setDriver(driver);
        SwitchToPage.setDriver(driver);
        Waiter.setDriver(driver);
        wait = new WebDriverWait(driver, 20);
        page = new Pages(driver);
//        listner = new ScreenshotListener(driver);

        page.loginPage().login(site, login, pass);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() throws Exception {
        driver.quit();
    }

    @BeforeGroups(groups = "CD", alwaysRun = true)
    public void beforeGroupsCD() {
        page.homePage().callDoctorBtn();
        pages.utilities.SwitchToPage.switchToPage();
//        driver.get("http://192.168.7.19:6001/test/call/call_doctor_ui/call-doctor/board?ticket=t7zsrR0YvQRlp3lJYS0jKJNV0iik4wUMdzEgXNDtpEyZuZQrHX77ZqJ2O11UnOgX1DHriJXe6vZ%2BkgsHMnU1xMnAGoTQa0nyWMnJ6lShS7L6cGJpGGyR0M3Jlhgz1wTVz1QjW1woODUjtUE6X3KSOqtvsn3%2Fa2Lx5TDEhQG2psDKSZMl7i1%2FUVhRyDuf23%2BsEZuRtfv7ZTo%2BZ774dRCiDAC7z5deDUcuutxGMFWR%2FhwPEUS44kPBJjoJVBVZfFs58LK3FPTZL0js%2B0rNRAI%2BFt4dLcLYfI2YdpzaXFaDGrtnDRId&ReturnUrl=http:%2F%2F192.168.7.139%2Fwhc%2FMain%2FDefault");
        String url = driver.getCurrentUrl();
        curUrlCalldoctor = url;
    }

    @BeforeGroups(groups = "mis", alwaysRun = true)
    public void beforeGroupsMIS() {
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

    @BeforeGroups(groups = "test", alwaysRun = true)
    public void beforeGroupsCDTest() {
        page.homePage().callDoctorBtn();
        pages.utilities.SwitchToPage.switchToPage();
//        driver.get("http://192.168.7.19:6001/test/call/call_doctor_ui/call-doctor/board?ticket=t7zsrR0YvQRlp3lJYS0jKJNV0iik4wUMdzEgXNDtpEyZuZQrHX77ZqJ2O11UnOgX1DHriJXe6vZ%2BkgsHMnU1xMnAGoTQa0nyWMnJ6lShS7L6cGJpGGyR0M3Jlhgz1wTVz1QjW1woODUjtUE6X3KSOqtvsn3%2Fa2Lx5TDEhQG2psDKSZMl7i1%2FUVhRyDuf23%2BsEZuRtfv7ZTo%2BZ774dRCiDAC7z5deDUcuutxGMFWR%2FhwPEUS44kPBJjoJVBVZfFs58LK3FPTZL0js%2B0rNRAI%2BFt4dLcLYfI2YdpzaXFaDGrtnDRId&ReturnUrl=http:%2F%2F192.168.7.139%2Fwhc%2FMain%2FDefault");
        String url = driver.getCurrentUrl();
        curUrlCalldoctor = url;
    }
}