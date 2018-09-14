package emias;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import emias.calldoctor.BeforeCalldoctor;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.Pages;
import pages.utilities.RunSeleniumGrid;
import pages.utilities.StringGenerator;
import pages.utilities.WebDriverInstansiator;

import java.io.IOException;
import java.net.MalformedURLException;

public class AbstractTestGrid {
    public RemoteWebDriver driver;
    public Pages page;
    public BeforeCalldoctor beforecdCD;
    public String curUrlCalldoctor = null;
    public String nameGen;
    public String site;
    public String login;
    public String pass;

    @Parameters({"site", "loginMis", "pass"})
    @BeforeSuite
    public void beforeSuite(@Optional String site, @Optional String login, @Optional String pass) throws IOException {
        this.site = site;
        this.login = login;
        this.pass = pass;
        RunSeleniumGrid.run();
    }

    @Parameters({"browser", "headless"})
    @RetryCountIfFailed(2)
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional String browser, @Optional Boolean headless) throws MalformedURLException {
        driver = new WebDriverInstansiator(browser).setDriver(headless);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        page = new Pages();
        beforecdCD = new BeforeCalldoctor();
        nameGen = new StringGenerator().generator();
    }

    @RetryCountIfFailed(2)
    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        WebDriverRunner.closeWebDriver();
        driver.close();
        driver.quit();
//        SQLDemonstration.finalizeAllTestCalls();
//        close();
    }
}