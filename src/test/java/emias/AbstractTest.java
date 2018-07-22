package emias;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.Pages;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class AbstractTest {
    public static WebDriver driver;
    public static Pages page;
    public static String curUrlCalldoctor = null;

    @Parameters(value = {"browser", "platform"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String browser,
                            @Optional String platform,
                            ITestContext context) {
        System.out.println("Browser: " + browser);
        System.out.println("Platform: " + platform);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        System.setProperty("selenide.browser", "Chrome");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        Configuration.timeout = 10000;
        page = new Pages();
        driver = getWebDriver();
    }

    @Parameters(value = {"site", "login", "pass"})
    @BeforeGroups(groups = "CD", alwaysRun = true)
    public void beforeGroupsCD(@Optional String site,
                               @Optional String login,
                               @Optional String pass) {
        System.out.println("Site: " + site);
        page.loginPage().login("http://emias.mosreg.ru/demonstration/", login, pass);
        page.homePage().callDoctorBtn();
        switchTo().window(1);
        curUrlCalldoctor = driver.getCurrentUrl();
    }

    @Parameters(value = {"site", "login", "pass"})
    @BeforeGroups(groups = "mis", alwaysRun = true)
    public void beforeGroupsMIS(@Optional String site,
                                @Optional String login,
                                @Optional String pass) {
        System.out.println("Site: " + site);
        page.loginPage().login("http://emias.mosreg.ru/demonstration/", login, pass);
        curUrlCalldoctor = driver.getCurrentUrl();
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
        curUrlCalldoctor = driver.getCurrentUrl();
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

//    public String getFileName() {
//        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
//        Date date = new Date();
//        return dateFormat.format(date);
//    }
//
//    public void getDriver() {
//        return this.driver;
//    }
}