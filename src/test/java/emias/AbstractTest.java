package emias;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.Pages;
import pages.utilities.DriverManager;
import pages.utilities.SQLDemonstration;
import pages.utilities.StringGenerator;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.switchTo;

public class AbstractTest {
    public WebDriver driver;
    public Pages page;
    public String curUrlCalldoctor = null;
    public String nameGen;


    @Parameters({"site", "browser", "platform", "login", "pass"})
    @BeforeMethod()
    public void beforeMethod(@Optional String site, @Optional String browser, @Optional String platform, @Optional String login, @Optional String pass) {
        System.out.println("Бефор метод " + Thread.currentThread().getId());
        System.out.println("Browser: " + browser);
        System.out.println("Platform: " + platform);
        driver = new DriverManager(browser).createDriver();
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
        System.out.println("Афтер метод " + Thread.currentThread().getId());
        driver.manage().deleteAllCookies();
        close();
        SQLDemonstration.finalizePacientName(nameGen);
    }


    //    @BeforeClass(alwaysRun = true)
//    public void setUpClass() throws Exception {
//        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//    }
//
//    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
//    public void feature(CucumberFeatureWrapper cucumberFeature) {
//        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
//    }
//
////    @Parameters({"browser", "platform"})
////    @BeforeSuite(alwaysRun = true)
////    public void beforeSuite(@Optional String browser, @Optional String platform, ITestContext context) {
//////        System.out.println("Browser: " + browser);
//////        System.out.println("Platform: " + platform);
//////        driver = new DriverManager(browser).createDriver();
//////        page = new Pages();
////    }
//=======
//    @DataProvider
//    public Object[][] features() {
//        return testNGCucumberRunner.provideFeatures();
//    }
//
//    @AfterClass(alwaysRun = true)
//    public void tearDownClass() throws Exception {
//        testNGCucumberRunner.finish();
//    }
//>>>>>>> origin/selenide-threads_&_browsers
//
//
//    @Parameters({"browser", "platform"})
//    @BeforeSuite(alwaysRun = true)
//    public void beforeSuite(@Optional String browser, @Optional String platform, ITestContext context) {
//        System.out.println("Browser: " + browser);
//        System.out.println("Platform: " + platform);
//        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//        driver = new DriverManager(browser).createDriver();
//        page = new Pages();
//    }
//
//    @AfterSuite(alwaysRun = true)
//    public void afterSutie() {
//        close();
//    }
//
//    @Parameters(value = {"site", "login", "pass"})
//    @BeforeGroups(groups = "mis", alwaysRun = true)
//    public void beforeGroupsMIS(@Optional String site, @Optional String login, @Optional String pass) {
//        System.out.println("Site: " + site);
//        page.loginPage().login("http://emias.mosreg.ru/demonstration/", login, pass);
//        curUrlCalldoctor = driver.getCurrentUrl();
//    }
//
//    @Parameters(value = {"login", "pass"})
//    @BeforeGroups(groups = "test", alwaysRun = true)
//    public void beforeGroupsTest(@Optional String login, @Optional String pass) {
//        page.loginPage().login("http://emias.mosreg.ru/demonstration/", login, pass);
//        page.homePage().callDoctorBtn();
//        switchTo().window(1);
//        curUrlCalldoctor = driver.getCurrentUrl();
//    }
//
//    @Parameters(value = {"login", "pass"})
//    @BeforeGroups(groups = "disp", alwaysRun = true)
//    public void beforeGroupsDisp(@Optional String login,
//                                 @Optional String pass) {
//        open("http://service.emias.mosreg.ru/test/disp/disp_ui/disp;doctorId=1208;doctorGuid=20d0da4b-b333-4878-9409-4525eae8e502;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=RqBrz85637XYrV2zFG8eZvYGvZiHSrF94TOHue0ltIZdapgZgXkv4sQcM0xD7g8soyDqwjLgeUQXu2Vd1n0XMEZyhoPIDVOEHbG%2FEmzG3oHGtBDPonMq%2FJFCnLoePrGqFQ0ah5DBFRv9zYEg%2BHYqwbvHeRVOHhz6Q9mQXyfsKTuC12xh6wLYRogVQi2KwEJq%2F5uAlC8vLHVZnBR7dujH2rB%2BEBN4tUwINqV1UE8CxcH82u54CO00eC84C8tkPBgbip4LJrEnHUz7TZj1n0HvU1mQHOSA5RbY5xgUnRJE5O0vFzpf/card/1837?ticket=RqBrz85637XYrV2zFG8eZvYGvZiHSrF94TOHue0ltIZdapgZgXkv4sQcM0xD7g8soyDqwjLgeUQXu2Vd1n0XMEZyhoPIDVOEHbG%2FEmzG3oHGtBDPonMq%2FJFCnLoePrGqFQ0ah5DBFRv9zYEg%2BHYqwbvHeRVOHhz6Q9mQXyfsKTuC12xh6wLYRogVQi2KwEJq%2F5uAlC8vLHVZnBR7dujH2rB%2BEBN4tUwINqV1UE8CxcH82u54CO00eC84C8tkPBgbip4LJrEnHUz7TZj1n0HvU1mQHOSA5RbY5xgUnRJE5O0vFzpf&mkabId=0&dvtId=376453&docPrvdId=1208&MisUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration&ReturnUrl=http:%2F%2Femias.mosreg.ru%2Fdemonstration%2FSchedule");
////        page.homePage().callDoctorBtn();
////        switchTo().window(1);
////        curUrlCalldoctor = driver.getCurrentUrl();
//    }
}