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

public abstract class AbstractTest {
    private Object User;
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
        page.loginPage().login("http://emias.mosreg.ru/demonstration/", login, pass);
        page.homePage().callDoctorBtn();
        pages.utilities.SwitchToPage.switchToPage();
        String url = driver.getCurrentUrl();
        curUrlCalldoctor = "http://192.168.7.48:8020/test/call/call_doctor_ui/call-doctor/board;docPrvdId=1210?ticket=KEHrb%2FkvTOKr3u1HlAyhK0y4BHiG20Bmv7l42aN6jt7NaIPz4%2BKHUinBRa9RxaIPOqWvpzGkcxs%2FfydP9toOUH2ydMRApDs%2BrUk7D78u0BxVOx1TwGypg%2BYocd0TN7cD%2B1dQELdApXKGQ8tmACh8zsk63PnHh1Suepda6o9cEDPu3KflSmQDCySa2mNyoic9OCE%2BkzAN2PWg8%2BM%2BplqaOMVQfybefhAzN28%2FinUIM%2B1AGdHPRp57e5T2Wh4N1hDA6FxPtDBDj25m%2BtJ3eeu9Qgv2miJQR8mJSwS4luTsbBpwPzTF&ReturnUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration%2FMain%2FDefault";
//        curUrlCalldoctor = url;
    }

    @Parameters(value = {"site", "login", "pass"})
    @BeforeGroups(groups = "mis", alwaysRun = true)
    public void beforeGroupsMIS(@Optional String site,
                                @Optional String login,
                                @Optional String pass) {
        System.out.println("Site: " + site);
        page.loginPage().login("http://emias.mosreg.ru/demonstration/", login, pass);
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
        page.loginPage().login("http://emias.mosreg.ru/demonstration/", login, pass);
//        driver.get("http://mis.softrust.ru/mis/Main/Default");
        page.homePage().callDoctorBtn();
        pages.utilities.SwitchToPage.switchToPage();
        String url = driver.getCurrentUrl();
        curUrlCalldoctor = "http://192.168.7.48:8020/test/call/call_doctor_ui/call-doctor/board;docPrvdId=1210?ticket=KEHrb%2FkvTOKr3u1HlAyhK0y4BHiG20Bmv7l42aN6jt7NaIPz4%2BKHUinBRa9RxaIPOqWvpzGkcxs%2FfydP9toOUH2ydMRApDs%2BrUk7D78u0BxVOx1TwGypg%2BYocd0TN7cD%2B1dQELdApXKGQ8tmACh8zsk63PnHh1Suepda6o9cEDPu3KflSmQDCySa2mNyoic9OCE%2BkzAN2PWg8%2BM%2BplqaOMVQfybefhAzN28%2FinUIM%2B1AGdHPRp57e5T2Wh4N1hDA6FxPtDBDj25m%2BtJ3eeu9Qgv2miJQR8mJSwS4luTsbBpwPzTF&ReturnUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration%2FMain%2FDefault";
//        curUrlCalldoctor = url;
    }
}