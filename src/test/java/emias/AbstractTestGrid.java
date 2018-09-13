package emias;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.Pages;
import pages.utilities.WebDriverInstansiator;

import java.net.MalformedURLException;

public class AbstractTestGrid {
    public Pages page;
    public String curUrlCalldoctor = "http://service.emias.mosreg.ru/test/call-doctor/board;docprvdid=1211?ticket=yJex1h4%2FTqA8ItvqhzP8%2BdTk4IKqlU5NlOYPzD0123mUgJmEtMI%2Bn47kTpg7egy0Urp%2FyLrQOADwFtc7YhABaJgSyQcwlFceeHS5XU%2Bc4yXz4u1E7chTfBMrK2H%2BKc9vvN7mJ2zon9W8ylZTuK7ai%2BnR%2BIMBKf34pIJXhjuYR3VljBxvsL6egNu3xKdZ4zfySPEaDF8tO%2FykdsuBSOrTr5Vt1aiXl0pRNNxPOQOyhcyS%2F5cc%2BdHughK8lzejBN7N4DjcyyZaKGnLnAG20BJVSLZ1PZGDEbfF9c6RcD8XD%2F7ixrAN&ReturnUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration%2FMain%2FDefault";

    @Parameters({"browser", "headless"})
    @BeforeMethod()
    public void setUp(@Optional String browser, @Optional Boolean headless) throws MalformedURLException {
        new WebDriverInstansiator(browser).setDriver(headless);
        page = new Pages();
    }

    @AfterMethod()
    public void afterMethod() {
        WebDriverRunner.closeWebDriver();
    }
}