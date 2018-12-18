package emias;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.json.JSONException;
import org.testng.annotations.*;
import pages.Pages;
import pages.sql.SQLDemonstration;
import utilities.SeleniumGrid;
import utilities.WebDriverInstansiator;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.FileOutputStream;
import java.io.IOException;

import static pages.AbstractPage.LOGGER;

public class AbstractTestGrid {
    public static String DISP_CARD_URL = "http://service.emias.mosreg.ru/test/disp;doctorId=1239;doctorGuid=71f2edcf-8395-4c0d-b011-be9b4a437718;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=KgHJ4f8mS1LP3YV%2bZnTy4d10h8xgdeJ7fxS9qjcEI2zdlg3AbSqDvDKxOODzM4juNRHlsSkSIyj4kRjxtqO2Tl0cw2fGBAG%2bbeuWsiRvKlaM%2frSG86U24eBF%2fabwRz%2ftxzhF0eY%2f8umxvbD95%2bBHNuxgBEJxIe3gmMwKo74dZFmzZUWhv4TXVSEWr%2bsbrFUHqTCibgPM2FYtEPOcCtBGMWsKKPCpeKwImyB8m2g3hWBxA7O2YhSgoY0Q%2bx%2bBJyqL4dBCMXNQ4g0mS0d9IjPdG9mR69ImYvrlwxdZdldDCelWygW0/card/3169?ticket=KgHJ4f8mS1LP3YV%2bZnTy4d10h8xgdeJ7fxS9qjcEI2zdlg3AbSqDvDKxOODzM4juNRHlsSkSIyj4kRjxtqO2Tl0cw2fGBAG%2bbeuWsiRvKlaM%2frSG86U24eBF%2fabwRz%2ftxzhF0eY%2f8umxvbD95%2bBHNuxgBEJxIe3gmMwKo74dZFmzZUWhv4TXVSEWr%2bsbrFUHqTCibgPM2FYtEPOcCtBGMWsKKPCpeKwImyB8m2g3hWBxA7O2YhSgoY0Q%2bx%2bBJyqL4dBCMXNQ4g0mS0d9IjPdG9mR69ImYvrlwxdZdldDCelWygW0&mkabId=0&dvtId=385541&docPrvdId=1239&MisUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration&ReturnUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration%2fSchedule";
    public static String DISP_JOURNAL_URL = "http://service.emias.mosreg.ru/test/disp/log;doctorId=1239;doctorGuid=71f2edcf-8395-4c0d-b011-be9b4a437718;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=UtduJYr%2fHQzIc4GpRM7n4E4M6TN0uXaja1Tx5GtHDpYRoDdlgS%2fmbGWZqEa0AR%2fPYaH6OQe8jFKM1q%2bOrq%2b6p44Q2xXUuRFb2PN%2bGN5ftNbln6EqRgNPDJgXDJbryHbJmOKJoJ5ocxApTm9jZBPofnwHkZvu%2bAAi1oBXTt6XRDXp3wijkRKZh7dwZH3pGMxdRP6QxW4QJhlMbDNTr4twWAr4tIozibowZTUza2kuJPM1IyG6biJkBKoBrjypNWQOSJ40akxr0nMKrN%2fA0ac0GN%2f37u2clJj4MKveA0lcDJ4z5Kao?ticket=UtduJYr%2fHQzIc4GpRM7n4E4M6TN0uXaja1Tx5GtHDpYRoDdlgS%2fmbGWZqEa0AR%2fPYaH6OQe8jFKM1q%2bOrq%2b6p44Q2xXUuRFb2PN%2bGN5ftNbln6EqRgNPDJgXDJbryHbJmOKJoJ5ocxApTm9jZBPofnwHkZvu%2bAAi1oBXTt6XRDXp3wijkRKZh7dwZH3pGMxdRP6QxW4QJhlMbDNTr4twWAr4tIozibowZTUza2kuJPM1IyG6biJkBKoBrjypNWQOSJ40akxr0nMKrN%2fA0ac0GN%2f37u2clJj4MKveA0lcDJ4z5Kao&mkabId=0&dvtId=0&docPrvdId=1239&MisUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration&ReturnUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration%2fMain%2fDefault";
    public static String CALLDOCTOR_URL = "http://service.emias.mosreg.ru/test/call-doctor/board;docprvdid=1239?ticket=892hJ4D5%2fh7YSK687rMnhjktSYivom5%2fh4RynHYnkypzFGqTrNMqHzxndlQYO7UwCEcJYvn%2bA6WY%2fryHmifox0ek0QRvsYC9G%2b2%2bVhXbsmDMuqZpDgpALTwB8SCfjrcMuKt4BlLMTYVllviNhYhxT333Xly6h8ut6UuyXDhMFH710Thr3kOb9FnaS4IO65biOSXCdbNOFW6CQYsyBCWBA1CabRYhio5O90tB%2b5zHwzktR6jODkUmJjXYbYtUDhQhOgu2p2EGQOnIOTDE99ym%2fA1naEqKiXQwA52oD3GKyfRxgMiy";
    public static String use_url;
    public Enter enter;
    public static Pages page;
    public static String site;
    public static String login;
    public static String pass;
    //    BrowserMobProxy proxy = new BrowserMobProxyServer();

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
        // TODO: 12/14/2018 после каждого теста отменять созданный вызов через базу
    }

    @RetryCountIfFailed(2)
    @AfterMethod(alwaysRun = true, groups = "CD")
    public void afterMethodCD() {
        SQLDemonstration.cancelCall();
        LOGGER.info("Вызов удален!");
    }
}