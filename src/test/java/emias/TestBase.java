package emias;

import com.codeborne.selenide.WebDriverRunner;
import dataGenerator.FactoryData;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.Pages;
import system.service.HltMkabService;
import utils.SeleniumGrid;
import utils.TestMethodCapture;
import utils.WebDriverInstansiator;
import utils.override.Assistance;
import utils.override.AssistanceImpl;
import utils.sql.DBScripts;

import java.io.FileOutputStream;
import java.io.IOException;

import static pages.AbstractPage.LOGGER;

@Listeners(TestMethodCapture.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class TestBase extends AbstractTestNGSpringContextTests {
    public static Pages page;
    public String testName;
    public Assistance asserts = new AssistanceImpl();
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
//    @RetryCountIfFailed(2)
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional String browser) throws IOException {
        new WebDriverInstansiator(browser).setDriver();
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        LOGGER.info("Тест начинается!");
        page = new Pages();
    }

    //    @RetryCountIfFailed(2)
    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        WebDriverRunner.getWebDriver().close();
        LOGGER.info("Тест завершен!");
    }

    //    @RetryCountIfFailed(2)
    @AfterMethod(alwaysRun = true, groups = "CD")
    public void afterMethodCD(ITestResult result) {
        DBScripts.cancelCall(result.getMethod().getMethodName());
    }
}