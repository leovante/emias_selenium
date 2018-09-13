package emias;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.Pages;
import pages.utilities.WebDriverInstansiator;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.switchTo;

public abstract class AbstractTestGrid {
    public Pages page;
    public String curUrlCalldoctor = null;

    @Parameters({"browser", "headless", "site", "login", "pass"})
    @RetryCountIfFailed(2)
    @BeforeMethod(groups = "CD", alwaysRun = true)
    public void setUp(@Optional String browser, @Optional Boolean headless, @Optional String site, @Optional String login, @Optional String pass) throws MalformedURLException {
        new WebDriverInstansiator(browser).setDriver(headless);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

        page = new Pages();
        page.loginPage().login(site, login, pass);
        page.homePage().callDoctorBtn();
        switchTo().window(1);
        //        curUrlCalldoctor = driver.getCurrentUrl();
        curUrlCalldoctor = "http://service.emias.mosreg.ru/test/call-doctor/board;docprvdid=1211?ticket=yJex1h4%2FTqA8ItvqhzP8%2BdTk4IKqlU5NlOYPzD0123mUgJmEtMI%2Bn47kTpg7egy0Urp%2FyLrQOADwFtc7YhABaJgSyQcwlFceeHS5XU%2Bc4yXz4u1E7chTfBMrK2H%2BKc9vvN7mJ2zon9W8ylZTuK7ai%2BnR%2BIMBKf34pIJXhjuYR3VljBxvsL6egNu3xKdZ4zfySPEaDF8tO%2FykdsuBSOrTr5Vt1aiXl0pRNNxPOQOyhcyS%2F5cc%2BdHughK8lzejBN7N4DjcyyZaKGnLnAG20BJVSLZ1PZGDEbfF9c6RcD8XD%2F7ixrAN&ReturnUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration%2FMain%2FDefault";
    }

    @RetryCountIfFailed(2)
    @AfterMethod(groups = "CD", alwaysRun = true)
    public void afterMethod() {
        WebDriverRunner.closeWebDriver();
    }
}