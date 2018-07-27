package emias;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.Pages;

import java.awt.*;

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
//        new DriverManager(browser).createDriver();

        ChromeDriverManager.getInstance().setup();
        Configuration.browser = browser;
        Configuration.headless = true;
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1070";
        Configuration.browserPosition = "0x0";
        driver = getWebDriver();
//        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1070));

//        ChromeDriverService chromeDriverService = new ChromeDriverService.Builder()
//                .usingDriverExecutable(new File("src/main/resources/chromedriver.exe"))
//                .usingAnyFreePort()
//                .build();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setHeadless(true);
//        chromeOptions.addArguments("window-size=1900,1020");
//        driver = new ChromeDriver(chromeDriverService, chromeOptions);
//        WebDriverRunner.setWebDriver(driver);

        page = new Pages();
//        driver = getWebDriver();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("Monitor screen resolution: " + (int) screenSize.getWidth() + "x" + (int) screenSize.getHeight());
        System.out.println("getWebDriver().manage().window().getSize(): " + getWebDriver().manage().window().getSize());
    }

    @AfterSuite(alwaysRun = true)
    public void afterSutie() {
        driver.quit();
    }

    @Parameters(value = {"site", "login", "pass"})
    @BeforeGroups(groups = "CD", alwaysRun = true)
    public void beforeGroupsCD(@Optional String site,
                               @Optional String login,
                               @Optional String pass) {
        System.out.println("Site: " + site);
        page.loginPage().login("http://emias.mosreg.ru/demonstration/", login, pass);
//        page.loginPage().defaultSetting();todo попросиль Лешу с делать </br> в меню выбора подразделения
        page.homePage().callDoctorBtn();
        switchTo().window(1);
        curUrlCalldoctor = //driver.getCurrentUrl();
                "http://service.emias.mosreg.ru/test/call/call_doctor_ui/call-doctor/board;docprvdid=1239?ticket=Ibc%2FOpI8MZaJjSIcdDuiWNYSz8ouUeancY6IJAXs%2Bu3RbApDxrMLWlzx%2BkOW0YXQ63Y5jQjXoUOxOa1I%2BuTXY0CShzuoHTtPewYeEHUOX%2FOY61mX5%2FqWvxRZ8slrHlYMim3E49r2TvhK8cA0ZI4ZuAaEEb0syr%2Fbs4%2B8S9oAuFLyy5hz%2BlY92r5KQvxeL8FVEsYbGdQnh7bJjI6fqm9%2Bclm3pRjVWWhy0PXSoBS0UZ14OLqP8XPm8ZAqepx%2FkLP4AK5LOcyrYLL4raglH4eIS1TXQ3hnZceTAwuOBhtjCtpePT9P&ReturnUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration%2FMain%2FDefault";
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
        page.loginPage().login("http://emias.mosreg.ru/demonstration/", login, pass);
        page.homePage().callDoctorBtn();
        switchTo().window(1);
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