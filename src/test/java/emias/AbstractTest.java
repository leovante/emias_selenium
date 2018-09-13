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
    public String site;

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
        this.site = site;
        System.out.println("Site: " + site);
        page.loginPage().login(site, login, pass);
        page.homePage().callDoctorBtn();
        switchTo().window(1);
//        curUrlCalldoctor = driver.getCurrentUrl();
        curUrlCalldoctor = "http://service.emias.mosreg.ru/test/call-doctor/board;docprvdid=1239?ticket=m8umyRMtXVs5RwAxhY1s%2FQ5WM339QvUFYTsiy5OX6fzcTaqsWidCV%2BSA2zcoRC5s2R%2FQTH2LYCrIbOhNHSdxvA3FscSUp6fEiI%2BO8HTpwU8HHGslTzLce2NzvfD3seROL8MDFritjfuo7sz90KJtRYG7UfetGIJ0yqlbf6W3Z9ty73hw6sRVsDfT9sNymoA0djc8D9dvo0rVxk1D%2BZnTrmud3UZPFuU6q%2Fgf%2BQcrXo5kkxENeeKzFUp9R%2FpXNVbDqP4HgKMHUgmsDI8%2BEiCGBZPHEZnOIroFtBr2SZpiFWLz5lRu&ReturnUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration2%2FMain%2FDefault";
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
}