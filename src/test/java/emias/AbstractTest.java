package emias;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.Pages;
import pages.utilities.DriverManager;

import static com.codeborne.selenide.Selenide.switchTo;

public abstract class AbstractTest {
    public static WebDriver driver;
    public static Pages page;
    public static String curUrlCalldoctor = null;

    @Parameters(value = {"browser", "platform"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String browser, @Optional String platform, ITestContext context) {
        System.out.println("Browser: " + browser);
        System.out.println("Platform: " + platform);
        driver = new DriverManager(browser).createDriver();
        page = new Pages();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSutie() {
//        driver.quit();
    }

    @Parameters(value = {"site", "login", "pass"})
    @BeforeGroups(groups = "CD", alwaysRun = true)
    public void beforeGroupsCD(@Optional String site, @Optional String login, @Optional String pass) {
        System.out.println("Site: " + site);
        page.loginPage().login("http://emias.mosreg.ru/demonstration/", login, pass);
//        page.loginPage().changeDepartment();todo попросиль Лешу сделать </br> в меню выбора подразделения
        page.homePage().callDoctorBtn();
        switchTo().window(1);
        curUrlCalldoctor = //driver.getCurrentUrl();
                "http://service.emias.mosreg.ru/test/call/call_doctor_ui/call-doctor/board;docprvdid=1239?ticket=Ibc%2FOpI8MZaJjSIcdDuiWNYSz8ouUeancY6IJAXs%2Bu3RbApDxrMLWlzx%2BkOW0YXQ63Y5jQjXoUOxOa1I%2BuTXY0CShzuoHTtPewYeEHUOX%2FOY61mX5%2FqWvxRZ8slrHlYMim3E49r2TvhK8cA0ZI4ZuAaEEb0syr%2Fbs4%2B8S9oAuFLyy5hz%2BlY92r5KQvxeL8FVEsYbGdQnh7bJjI6fqm9%2Bclm3pRjVWWhy0PXSoBS0UZ14OLqP8XPm8ZAqepx%2FkLP4AK5LOcyrYLL4raglH4eIS1TXQ3hnZceTAwuOBhtjCtpePT9P&ReturnUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration%2FMain%2FDefault";
    }

    @Parameters(value = {"site", "login", "pass"})
    @BeforeGroups(groups = "mis", alwaysRun = true)
    public void beforeGroupsMIS(@Optional String site, @Optional String login, @Optional String pass) {
        System.out.println("Site: " + site);
        page.loginPage().login("http://emias.mosreg.ru/demonstration/", login, pass);
        curUrlCalldoctor = driver.getCurrentUrl();
    }

    @Parameters(value = {"login", "pass"})
    @BeforeGroups(groups = "test", alwaysRun = true)
    public void beforeGroupsTest(@Optional String login, @Optional String pass) {
        page.loginPage().login("http://emias.mosreg.ru/demonstration/", login, pass);
        page.homePage().callDoctorBtn();
        switchTo().window(1);
        curUrlCalldoctor = driver.getCurrentUrl();
    }

//    @Parameters(value = {"login", "pass"})
//    @BeforeGroups(groups = "disp", alwaysRun = true)
//    public void beforeGroupsDisp(@Optional String login,
//                                 @Optional String pass) {
//        Selenide.open("http://service.emias.mosreg.ru/test/disp/disp_ui/disp;doctorId=1208;doctorGuid=20d0da4b-b333-4878-9409-4525eae8e502;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=RqBrz85637XYrV2zFG8eZvYGvZiHSrF94TOHue0ltIZdapgZgXkv4sQcM0xD7g8soyDqwjLgeUQXu2Vd1n0XMEZyhoPIDVOEHbG%2FEmzG3oHGtBDPonMq%2FJFCnLoePrGqFQ0ah5DBFRv9zYEg%2BHYqwbvHeRVOHhz6Q9mQXyfsKTuC12xh6wLYRogVQi2KwEJq%2F5uAlC8vLHVZnBR7dujH2rB%2BEBN4tUwINqV1UE8CxcH82u54CO00eC84C8tkPBgbip4LJrEnHUz7TZj1n0HvU1mQHOSA5RbY5xgUnRJE5O0vFzpf/card/1837?ticket=RqBrz85637XYrV2zFG8eZvYGvZiHSrF94TOHue0ltIZdapgZgXkv4sQcM0xD7g8soyDqwjLgeUQXu2Vd1n0XMEZyhoPIDVOEHbG%2FEmzG3oHGtBDPonMq%2FJFCnLoePrGqFQ0ah5DBFRv9zYEg%2BHYqwbvHeRVOHhz6Q9mQXyfsKTuC12xh6wLYRogVQi2KwEJq%2F5uAlC8vLHVZnBR7dujH2rB%2BEBN4tUwINqV1UE8CxcH82u54CO00eC84C8tkPBgbip4LJrEnHUz7TZj1n0HvU1mQHOSA5RbY5xgUnRJE5O0vFzpf&mkabId=0&dvtId=376453&docPrvdId=1208&MisUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration&ReturnUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration%2FSchedule");
////        page.homePage().callDoctorBtn();
////        switchTo().window(1);
////        curUrlCalldoctor = driver.getCurrentUrl();
//    }

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