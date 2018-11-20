package emias;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import emias.callDoctor.EnterSite;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;
import pages.Pages;
import utilities.SeleniumGrid;
import utilities.WebDriverInstansiator;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.FileOutputStream;
import java.io.IOException;

public class AbstractTestGrid {
    public String dispProfile = "http://service.emias.mosreg.ru/test/disp;doctorId=1239;doctorGuid=71f2edcf-8395-4c0d-b011-be9b4a437718;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=KgHJ4f8mS1LP3YV%2bZnTy4d10h8xgdeJ7fxS9qjcEI2zdlg3AbSqDvDKxOODzM4juNRHlsSkSIyj4kRjxtqO2Tl0cw2fGBAG%2bbeuWsiRvKlaM%2frSG86U24eBF%2fabwRz%2ftxzhF0eY%2f8umxvbD95%2bBHNuxgBEJxIe3gmMwKo74dZFmzZUWhv4TXVSEWr%2bsbrFUHqTCibgPM2FYtEPOcCtBGMWsKKPCpeKwImyB8m2g3hWBxA7O2YhSgoY0Q%2bx%2bBJyqL4dBCMXNQ4g0mS0d9IjPdG9mR69ImYvrlwxdZdldDCelWygW0/card/3169?ticket=KgHJ4f8mS1LP3YV%2bZnTy4d10h8xgdeJ7fxS9qjcEI2zdlg3AbSqDvDKxOODzM4juNRHlsSkSIyj4kRjxtqO2Tl0cw2fGBAG%2bbeuWsiRvKlaM%2frSG86U24eBF%2fabwRz%2ftxzhF0eY%2f8umxvbD95%2bBHNuxgBEJxIe3gmMwKo74dZFmzZUWhv4TXVSEWr%2bsbrFUHqTCibgPM2FYtEPOcCtBGMWsKKPCpeKwImyB8m2g3hWBxA7O2YhSgoY0Q%2bx%2bBJyqL4dBCMXNQ4g0mS0d9IjPdG9mR69ImYvrlwxdZdldDCelWygW0&mkabId=0&dvtId=385541&docPrvdId=1239&MisUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration&ReturnUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration%2fSchedule";
    public String dispJournal = "http://service.emias.mosreg.ru/test/disp/log;doctorId=1239;doctorGuid=71f2edcf-8395-4c0d-b011-be9b4a437718;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=DdTflfulkiJWS4UMiy6iq3JYverisG5YD4lgvbMpb5vlWBHqgIqAip5Fb0AQZ2%2fEtWAl88qE9DB53z45K%2f93hi4cGD6N6RA3g0KvFnWsU6AH5GjuaZkplu%2bFA18IRqm4jJRz7GRXNKTA622FArivQ6NHv8HUrG2fGQ%2bLZQnPLSoXfOvYaRarjxoC37KGwYswvBWmLURtp3QatPNUIB2nGLxRV%2fzJVMh4pZWxfsZusvkGy%2bPJUucP0rITpKg52pwZt4V6VuvDFJfedbpo1vScgZoPdiSYUZ438UA1HYPC6aOxMZ97?ticket=DdTflfulkiJWS4UMiy6iq3JYverisG5YD4lgvbMpb5vlWBHqgIqAip5Fb0AQZ2%2fEtWAl88qE9DB53z45K%2f93hi4cGD6N6RA3g0KvFnWsU6AH5GjuaZkplu%2bFA18IRqm4jJRz7GRXNKTA622FArivQ6NHv8HUrG2fGQ%2bLZQnPLSoXfOvYaRarjxoC37KGwYswvBWmLURtp3QatPNUIB2nGLxRV%2fzJVMh4pZWxfsZusvkGy%2bPJUucP0rITpKg52pwZt4V6VuvDFJfedbpo1vScgZoPdiSYUZ438UA1HYPC6aOxMZ97&mkabId=0&dvtId=0&docPrvdId=1239&MisUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration&ReturnUrl=http%3a%2f%2femias.mosreg.ru%2fdemonstration%2fMain%2fDefault";
    public static Pages page;
    public EnterSite enterSite;
    public static String site;
    public static String login;
    public static String pass;

    //    BrowserMobProxy proxy = new BrowserMobProxyServer();

    @Parameters({"site", "login", "pass", "gridIsRun"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String site, @Optional String login, @Optional String pass, @Optional String gridIsRun) throws Exception {
        AbstractTestGrid.site = site;
        AbstractTestGrid.login = login;
        AbstractTestGrid.pass = pass;
        SeleniumGrid.run(gridIsRun);
//        HibernateSession.run();
    }

    @Parameters({"gridIsRun"})
    @AfterSuite(alwaysRun = true)
    public void afterSuite(@Optional String gridIsRun) throws IOException {
//        Har har = proxy.getHar();
        FileOutputStream fileOutputStream = new FileOutputStream("target/selenium_logs.har");
//        har.writeTo(fileOutputStream);
        SeleniumGrid.stop(gridIsRun);
        System.out.println("Тестирование закончено!");
    }

    @Parameters({"browser", "headless"})
    @RetryCountIfFailed(2)
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional String browser, @Optional Boolean headless) throws IOException {
        new WebDriverInstansiator(browser).setDriver(headless/*, proxy*/);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        page = new Pages();
        enterSite = new EnterSite();
        System.out.println("Тест начинается!");
    }

    @RetryCountIfFailed(2)
    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        WebDriverRunner.closeWebDriver();
        System.out.println("Тест завершен!");
    }
}