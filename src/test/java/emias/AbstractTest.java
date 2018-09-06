package emias;

import com.codeborne.selenide.logevents.SelenideLogger;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.Pages;
import pages.utilities.DriverManager;
import pages.utilities.SQLDemonstration;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.switchTo;

public abstract class AbstractTest {
    public static WebDriver driver;
    public static Pages page;
    public static String curUrlCalldoctor = null;

    @Parameters(value = {"browser", "platform", "headless"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String browser, @Optional String platform, @Optional Boolean headless, ITestContext context) {
        System.out.println("Browser: " + browser);
        System.out.println("Platform: " + platform);
        driver = new DriverManager(browser).createDriver(headless);
        page = new Pages();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @AfterSuite(alwaysRun = true)
    public void afterSutie() {
        close();
        driver.quit();
    }

    @Parameters(value = {"site", "login", "pass"})
    @RetryCountIfFailed(2)
    @BeforeGroups(groups = "CD", alwaysRun = true)
    public void beforeGroupsCD(@Optional String site, @Optional String login, @Optional String pass) {
        System.out.println("Site: " + site);
        page.loginPage().login(site, login, pass);
        page.homePage().callDoctorBtn();
        switchTo().window(1);
        curUrlCalldoctor = driver.getCurrentUrl();
//        curUrlCalldoctor = "http://service.emias.mosreg.ru/test/call-doctor/board;docprvdid=1239?ticket=HOtAmcLuy0mM1OIXdsHa7Bd%2FihvJXhgrx8Y%2BK%2BTIiZ5vHmuZ2b9bOW1kdeTWUWr9OwCLOBR4bVJC4JicymQbe9rJFsoi8cQ9BlXrPn4PbFsFmd43RsJcIL4z5v2CyFzu7oF4biRLTo1qId5NK29i0kUmIPBMYMFEuYyr%2BJQV7%2FUUVLoOxPCC5%2BIu00h3q8mOwmI5IOXeOJv06W2XhaR4MkoSdcsz9A7vhjSfEcEW9gkNX5XN3%2BV7RlspQtY21Twl3yfYur40DRpL35HSEmlKxOgjcymNWBOZ2xPW78p%2BHUaaG3GN&ReturnUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration%2FMain%2FDefault";
    }

    @RetryCountIfFailed(2)
    @AfterGroups(groups = "CD")
    public void afterGroupsCD() {
//        SQLDemonstration.finalizeAllTestCalls();
    }

    @Parameters(value = {"site", "login", "pass"})
    @BeforeGroups(groups = "mis", alwaysRun = true)
    public void beforeGroupsMIS(@Optional String site, @Optional String login, @Optional String pass) {
        System.out.println("Site: " + site);
        page.loginPage().login(site, login, pass);
        curUrlCalldoctor = driver.getCurrentUrl();
    }

    @Parameters(value = {"site", "login", "pass"})
    @BeforeGroups(groups = "test", alwaysRun = true)
    public void beforeGroupsTest(@Optional String site, @Optional String login, @Optional String pass) {
        page.loginPage().login(site, login, pass);
        page.homePage().callDoctorBtn();
        switchTo().window(1);
//        curUrlCalldoctor = driver.getCurrentUrl();
        curUrlCalldoctor = "http://service.emias.mosreg.ru/test/call-doctor/board;docprvdid=1239?ticket=HOtAmcLuy0mM1OIXdsHa7Bd%2FihvJXhgrx8Y%2BK%2BTIiZ5vHmuZ2b9bOW1kdeTWUWr9OwCLOBR4bVJC4JicymQbe9rJFsoi8cQ9BlXrPn4PbFsFmd43RsJcIL4z5v2CyFzu7oF4biRLTo1qId5NK29i0kUmIPBMYMFEuYyr%2BJQV7%2FUUVLoOxPCC5%2BIu00h3q8mOwmI5IOXeOJv06W2XhaR4MkoSdcsz9A7vhjSfEcEW9gkNX5XN3%2BV7RlspQtY21Twl3yfYur40DRpL35HSEmlKxOgjcymNWBOZ2xPW78p%2BHUaaG3GN&ReturnUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration%2FMain%2FDefault";
    }


    @AfterGroups(groups = "disp")
    public void AfterGroupsDisp() throws FileNotFoundException {
        SQLDemonstration.runSqlScript("delete hlt_disp_ServiceDocPrvd.txt");
        SQLDemonstration.runSqlScript("insert default hlt_disp_ServiceDocPrvd.txt");
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