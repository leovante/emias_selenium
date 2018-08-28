package emias;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.Pages;
import pages.utilities.StringGenerator;
import ru.stqa.selenium.factory.WebDriverPool;

import static com.codeborne.selenide.Selenide.switchTo;

public class AbstractTest {
    public WebDriver driver;
    public Pages page;
    public String curUrlCalldoctor = null;
    public String nameGen;


    @BeforeClass()
    public void beforeClass() {

    }

    @AfterClass()
    public void afterClass() {

    }

    @Parameters({"site", "browser", "platform", "login", "pass"})
    @BeforeMethod()
    public void beforeMethod(@Optional String site, @Optional String browser, @Optional String platform, @Optional String login, @Optional String pass) {
        System.out.println("Бефор метод " + Thread.currentThread().getId());
        System.out.println("Browser: " + browser);
        System.out.println("Platform: " + platform);
        driver = WebDriverPool.DEFAULT.getDriver(new ChromeOptions());

//        driver = new DriverManager(browser).createDriver();

        page = new Pages();
        System.out.println("Site: " + site);
        page.loginPage().login(site, login, pass);
        page.homePage().callDoctorBtn();
        switchTo().window(1);
        curUrlCalldoctor = driver.getCurrentUrl();

        StringGenerator nameGen = new StringGenerator();
        this.nameGen = String.valueOf(nameGen.generator());


    }

    @AfterMethod()
    public void afterMethod() {
//        System.out.println("Афтер метод " + Thread.currentThread().getId());
//        driver.manage().deleteAllCookies();
//        close();
//        SQLDemonstration.finalizePacientName(nameGen);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverPool.DEFAULT.dismissAll();
    }
}