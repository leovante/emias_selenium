package emias;

//import org.codehaus.plexus.util.FileUtils;

import com.codeborne.selenide.Configuration;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.open;

public abstract class AbstractTest {
    //    public static WebDriver driver;
//    public static WebDriverWait wait;
    public static Pages page;
//    public static String curUrlCalldoctor = null;

    @Parameters(value = {"browser", "platform"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String browser,
                            @Optional String platform,
                            ITestContext context) {
        System.out.println("Browser: " + browser);
        System.out.println("Platform: " + platform);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        Configuration.timeout = 10000;
//        driver = new DriverManager(browser).createDriver();
//        wait = new WebDriverWait(driver, 20);
        page = new Pages(/*driver*/);
//        JSWaiter.setDriver(driver);
//        SwitchToPage.setDriver(driver);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
//        driver.quit();
    }

    @Parameters(value = {"site", "login", "pass"})
    @BeforeGroups(groups = "CD", alwaysRun = true)
    public void beforeGroupsCD(@Optional String site,
                               @Optional String login,
                               @Optional String pass) {
        System.out.println("Site: " + site);
//        page.loginPage().login("http://emias.mosreg.ru/demonstration/", login, pass);
//        page.homePage().callDoctorBtn();
        pages.utilities.SwitchToPage.switchToPage();
//        String url = driver.getCurrentUrl();
//        curUrlCalldoctor = "http://192.168.7.48:8020/test/call/call_doctor_ui/call-doctor/board;docPrvdId=1210?ticket=KEHrb%2FkvTOKr3u1HlAyhK0y4BHiG20Bmv7l42aN6jt7NaIPz4%2BKHUinBRa9RxaIPOqWvpzGkcxs%2FfydP9toOUH2ydMRApDs%2BrUk7D78u0BxVOx1TwGypg%2BYocd0TN7cD%2B1dQELdApXKGQ8tmACh8zsk63PnHh1Suepda6o9cEDPu3KflSmQDCySa2mNyoic9OCE%2BkzAN2PWg8%2BM%2BplqaOMVQfybefhAzN28%2FinUIM%2B1AGdHPRp57e5T2Wh4N1hDA6FxPtDBDj25m%2BtJ3eeu9Qgv2miJQR8mJSwS4luTsbBpwPzTF&ReturnUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration%2FMain%2FDefault";
//        curUrlCalldoctor = driver.getCurrentUrl();
//        String url = driver.getCurrentUrl();
//        curUrlCalldoctor = "http://192.168.7.48:8020/test/call/call_doctor_ui/call-doctor/board;docPrvdId=1210?ticket=KEHrb%2FkvTOKr3u1HlAyhK0y4BHiG20Bmv7l42aN6jt7NaIPz4%2BKHUinBRa9RxaIPOqWvpzGkcxs%2FfydP9toOUH2ydMRApDs%2BrUk7D78u0BxVOx1TwGypg%2BYocd0TN7cD%2B1dQELdApXKGQ8tmACh8zsk63PnHh1Suepda6o9cEDPu3KflSmQDCySa2mNyoic9OCE%2BkzAN2PWg8%2BM%2BplqaOMVQfybefhAzN28%2FinUIM%2B1AGdHPRp57e5T2Wh4N1hDA6FxPtDBDj25m%2BtJ3eeu9Qgv2miJQR8mJSwS4luTsbBpwPzTF&ReturnUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration%2FMain%2FDefault";
    }

    @Parameters(value = {"site", "login", "pass"})
    @BeforeGroups(groups = "mis", alwaysRun = true)
    public void beforeGroupsMIS(@Optional String site,
                                @Optional String login,
                                @Optional String pass) {
        System.out.println("Site: " + site);
//        page.loginPage().login("http://emias.mosreg.ru/demonstration/", login, pass);
//        String url = driver.getCurrentUrl();
//        curUrlCalldoctor = url;
    }

    @BeforeGroups(groups = "CC", alwaysRun = true)
    public void beforeGroupsCC() {
    }

    @Parameters(value = {"login", "pass"})
    @BeforeGroups(groups = "test", alwaysRun = true)
    public void beforeGroupsTest(@Optional String login,
                                 @Optional String pass) {
//        page.loginPage().login("http://emias.mosreg.ru/demonstration/", login, pass);
//        page.homePage().callDoctorBtn();
//        pages.utilities.SwitchToPage.switchToPage();
        open("http://service.emias.mosreg.ru/test/call/call_doctor_ui/call-doctor/board;docPrvdId=1211?ticket=C%2FQZnj68wErhP4mV892v5evR7%2BxPvSDpoS8UQQwk%2FkL2F95HXWUwnUrXo%2FN25VeVBCVQtKB2LrFsy%2BzT4SGVO%2BO%2BQqivjETVFVKt1VF26wWIRbsO%2BZNaH54psOOoYi2nv0PfAfiLLBKgNEVsG57hUdNX8LIRYi3QvTXlvCAoLPgFsJqmtZLqWHhRcgZmERxFcXO6VCiFm38STaxK7XfR9fRJYshdeA%2FuVtAdFs5vKlr2v%2FT8R67IYPI%2B4mCqD3grjBBUdxtBo3MDyk4ZCD0LcXmaq0LEHBME0SD1fMCQoTs14221&ReturnUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration%2FMain%2FDefault");
    }


//    public static void disableWarning() {
//        try {
//            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
//            theUnsafe.setAccessible(true);
//            Unsafe u = (Unsafe) theUnsafe.get(null);
//
//            Class cls = Class.forName("jdk.internal.module.IllegalAccessLogger");
//            Field logger = cls.getDeclaredField("logger");
//            u.putObjectVolatile(cls, u.staticFieldOffset(logger), null);
//        } catch (Exception e) {
//            // ignore
//        }
//    }

    public String getFileName() {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

//<<<<<<< .merge_file_a13804
//    public void getDriver() {
////        return this.driver;
//=======
//    public WebDriver getDriver() {
//        return driver;
//<<<<<<< .merge_file_a12972
//<<<<<<< .merge_file_a05880
//>>>>>>> .merge_file_a09948
//=======
//>>>>>>> .merge_file_a07960
//=======
//>>>>>>> .merge_file_a01028
//    }
}