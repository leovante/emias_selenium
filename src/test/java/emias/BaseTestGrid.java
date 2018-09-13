package emias;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.Pages;
import pages.utilities.WebDriverInstansiator;

import java.net.MalformedURLException;

public class BaseTestGrid {
    public static Pages page;
    public static String curUrlCalldoctor = null;

    @Parameters({"browser", "browserVersion"})
    @BeforeMethod()
    public void setUp(@Optional String browser, String browserVersion) throws MalformedURLException {
        WebDriverInstansiator.setDriver("chrome", browserVersion);
    }

    @AfterMethod()
    public void afterMethod() {
        WebDriverRunner.closeWebDriver();
//        WebDriverInstansiator.getDriver().quit();
    }
}