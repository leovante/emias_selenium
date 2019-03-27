package emias;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import dataGenerator.FactoryData;
import io.qameta.allure.selenide.AllureSelenide;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.Pages2;
import system.service.HltMkabService;
import utilities.SeleniumGrid;
import utilities.TestMethodCapture;
import utilities.WebDriverInstansiator;
import utilities.sql.DBScripts;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.FileOutputStream;
import java.io.IOException;

import static pages.AbstractPage.LOGGER;

@Listeners(TestMethodCapture.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class TestBase extends AbstractTestNGSpringContextTests {
    public static Pages2 page;
    public String testName;
    //    BrowserMobProxy proxy = new BrowserMobProxyServer();

    public String testName() {
//        this.testName = TestMethodCapture.class.getName();
        return TestMethodCapture.getTestMethod().getMethodName();
    }

    @Autowired
    public FactoryData factoryData;

    @Autowired
    public HltMkabService hltMkabService;

    @Parameters({"gridIsRun"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String gridIsRun) throws Exception {
        SeleniumGrid.run(gridIsRun);
//        HibernateSession.run();
    }

    @Parameters({"gridIsRun"})
    @AfterSuite(alwaysRun = true)
    public void afterSuite(@Optional String gridIsRun) throws IOException, JSONException, InterruptedException {
//        Har har = proxy.getHar();
        FileOutputStream fileOutputStream = new FileOutputStream("target/selenium_logs.har");
//        har.writeTo(fileOutputStream);
        SeleniumGrid.stop(gridIsRun);
        LOGGER.info("Тестирование закончено!");
    }

    @Parameters({"browser"})
    @RetryCountIfFailed(2)
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional String browser) throws IOException {
        new WebDriverInstansiator(browser).setDriver();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        LOGGER.info("Тест начинается!");
        page = new Pages2();
    }

    @RetryCountIfFailed(2)
    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        WebDriverRunner.closeWebDriver();
        LOGGER.info("Тест завершен!");
    }

    @RetryCountIfFailed(2)
    @AfterMethod(alwaysRun = true, groups = "CD")
    public void afterMethodCD(ITestResult result) {
        DBScripts.cancelCall(result.getMethod().getMethodName());
    }
}