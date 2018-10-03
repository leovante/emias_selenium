package emias;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import emias.calldoctor.EnterSite;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.Pages;
import pages.sql.SQL;
import pages.utilities.RunSeleniumGrid;
import pages.utilities.StringGenerator;
import pages.utilities.WebDriverInstansiator;

import java.io.IOException;
import java.net.MalformedURLException;

public class AbstractTestGrid {
    public static RemoteWebDriver driver;
    public static Pages page;
    public EnterSite enterSite;
    public volatile String nameGen;
    public static String site;
    public static String login;
    public static String pass;

    @Parameters({"site", "login", "pass"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String site, @Optional String login, @Optional String pass) throws IOException, InterruptedException {
        AbstractTestGrid.site = site;
        AbstractTestGrid.login = login;
        AbstractTestGrid.pass = pass;
        RunSeleniumGrid.run();
//        HibernateSession.run();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() throws IOException {
        RunSeleniumGrid.stop();
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        SQL.finalizeAllTestCalls();
    }

    @Parameters({"browser", "headless"})
    @RetryCountIfFailed(2)
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional String browser, @Optional Boolean headless) throws MalformedURLException {
        driver = new WebDriverInstansiator(browser).setDriver(headless);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        page = new Pages();
        enterSite = new EnterSite();
        nameGen = new StringGenerator().generator();
    }

    @RetryCountIfFailed(2)
    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        WebDriverRunner.closeWebDriver();
    }
}