package emias;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import emias.calldoctor.EnterSite;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;
import pages.Pages;
import pages.utilities.SeleniumGrid;
import pages.utilities.WebDriverInstansiator;

import java.io.FileOutputStream;
import java.io.IOException;

public class AbstractTestGrid {
    public String dispProfile = "http://service.emias.mosreg.ru/test/disp;doctorId=1220;doctorGuid=eb18c49f-e74f-4ea3-bfd8-b4abd924cdcf;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=uF43FOxR4U1FHuFosKZhvxZnxxzIxOU7N%2FgUwrJa%2FsdvfykZjtlYj%2Fe3DQMp1fmbIIy3wisBiF0Zy%2FPvY7aXbEqQAhRF1HG3Rw44mQk1PdpOq521RgXQ%2Bn5nmdRC0Dw097bu%2B2buwdQ0Cp5JVicApIK50u%2B6BMzrTiPnEd%2BCx7XTkgHZtNRRaYTT0YeUf%2BbNl8MSZlqLy%2F6Y8Npp8Ua9I88HUJ5bOCMMicRu2u2ChWsb6XO5WBqlJ%2F%2BN4NkI4OrZ4iy6FioUvsG1jSjH19tGk9vtuTfuNhvKd8p7v9hZqp8W11Io/card/3063?ticket=uF43FOxR4U1FHuFosKZhvxZnxxzIxOU7N%2FgUwrJa%2FsdvfykZjtlYj%2Fe3DQMp1fmbIIy3wisBiF0Zy%2FPvY7aXbEqQAhRF1HG3Rw44mQk1PdpOq521RgXQ%2Bn5nmdRC0Dw097bu%2B2buwdQ0Cp5JVicApIK50u%2B6BMzrTiPnEd%2BCx7XTkgHZtNRRaYTT0YeUf%2BbNl8MSZlqLy%2F6Y8Npp8Ua9I88HUJ5bOCMMicRu2u2ChWsb6XO5WBqlJ%2F%2BN4NkI4OrZ4iy6FioUvsG1jSjH19tGk9vtuTfuNhvKd8p7v9hZqp8W11Io&mkabId=0&dvtId=384771&docPrvdId=1220&MisUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration2&ReturnUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration2%2FSchedule";
    public String dispJournal = "http://service.emias.mosreg.ru/test/disp;doctorId=0;doctorGuid=;doctorTypeGuid=/card/1594?dvtId=-1";
    public static Pages page;
    public EnterSite enterSite;
    public static String site;
    public static String login;
    public static String pass;

    //    BrowserMobProxy proxy = new BrowserMobProxyServer();
//
//
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
    }

    @Parameters({"browser", "headless"})
    @RetryCountIfFailed(2)
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional String browser, @Optional Boolean headless) throws IOException {
        new WebDriverInstansiator(browser).setDriver(headless/*, proxy*/);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        page = new Pages();
        enterSite = new EnterSite();
    }

    @RetryCountIfFailed(2)
    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        WebDriverRunner.closeWebDriver();
    }
}