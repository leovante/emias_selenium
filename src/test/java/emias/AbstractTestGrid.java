package emias;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.json.JSONException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.Pages;
import utilities.SeleniumGrid;
import utilities.TestMethodCapture;
import utilities.WebDriverInstansiator;
import utilities.sql.SQLDemonstration;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.FileOutputStream;
import java.io.IOException;

import static pages.AbstractPage.LOGGER;

@Listeners(TestMethodCapture.class)
//@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan("system")
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class AbstractTestGrid extends AbstractTestNGSpringContextTests {
    public static String DISP_CARD_URL = "http://service.emias.mosreg.ru/test/disp;doctorId=1239;doctorGuid=71f2edcf-8395-4c0d-b011-be9b4a437718;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=KgHJ4f8mS1LP3YV%2bZnTy4d10h8xgdeJ7fxS9qjcEI2zdlg3AbSqDvDKxOODzM4juNRHlsSkSIyj4kRjxtqO2Tl0cw2fGBAG%2bbeuWsiRvKlaM%2frSG86U24eBF%2fabwRz%2ftxzhF0eY%2f8umxvbD95%2bBHNuxgBEJxIe3gmMwKo74dZFmzZUWhv4TXVSEWr%2bsbrFUHqTCibgPM2FYtEPOcCtBGMWsKKPCpeKwImyB8m2g3hWBxA7O2YhSgoY0Q%2bx%2bBJyqL4dBCMXNQ4g0mS0d9IjPdG9mR69ImYvrlwxdZdldDCelWygW0/card/3169?ticket=KgHJ4f8mS1LP3YV%2bZnTy4d10h8xgdeJ7fxS9qjcEI2zdlg3AbSqDvDKxOODzM4juNRHlsSkSIyj4kRjxtqO2Tl0cw2fGBAG%2bbeuWsiRvKlaM%2frSG86U24eBF%2fabwRz%2ftxzhF0eY%2f8umxvbD95%2bBHNuxgBEJxIe3gmMwKo74dZFmzZUWhv4TXVSEWr%2bsbrFUHqTCibgPM2FYtEPOcCtBGMWsKKPCpeKwImyB8m2g3hWBxA7O2YhSgoY0Q%2bx%2bBJyqL4dBCMXNQ4g0mS0d9IjPdG9mR69ImYvrlwxdZdldDCelWygW0&mkabId=0&dvtId=385541&docPrvdId=1239&MisUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration&ReturnUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration%2fSchedule";
    public static String use_url;
    public Enter enter;
    public static Pages page;
    public static String site;
    public static String login;
    public static String pass;
    //    BrowserMobProxy proxy = new BrowserMobProxyServer();
    public String testName;

    public String testName() {
//        this.testName = TestMethodCapture.class.getName();
        return TestMethodCapture.getTestMethod().getMethodName();
    }

    @Parameters({"site", "login", "pass", "gridIsRun", "use_url"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String site, @Optional String login, @Optional String pass, @Optional String gridIsRun, @Optional String use_url) throws Exception {
        Configuration.reportsFolder = "target/test-result/reports";
        AbstractTestGrid.use_url = use_url;
        AbstractTestGrid.site = site;
        AbstractTestGrid.login = login;
        AbstractTestGrid.pass = pass;
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

    @Parameters({"browser", "headless"})
    @RetryCountIfFailed(2)
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional String browser, @Optional Boolean headless) throws IOException {
        new WebDriverInstansiator(browser).setDriver(headless/*, proxy*/);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        page = new Pages();
        enter = new Enter();
        LOGGER.info("Тест начинается!");
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
        SQLDemonstration.cancelCall(result.getMethod().getMethodName());
    }
}