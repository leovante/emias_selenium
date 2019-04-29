package emias;

import dataGenerator.FactoryData;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.Pages;
import system.service.HltMkabService;
import utils.Selenium.SeleniumGrid;
import utils.TestMethodCapture;
import utils.WebDriverInstansiator;
import utils.override.Assistance;
import utils.override.AssistanceImpl;
import utils.sql.DBScripts;

import java.io.IOException;

@Listeners(TestMethodCapture.class)
@ContextConfiguration("classpath:beans.xml")
public class TestBase extends AbstractTestNGSpringContextTests {
    private WebDriverInstansiator driverInst;
    public static Pages page;
    public String testName;
    protected Assistance as = new AssistanceImpl();

    public String testName() {
        return TestMethodCapture.getTestMethod().getMethodName();
    }

    @Autowired
    public FactoryData factoryData;

    @Autowired
    public HltMkabService hltMkabService;

    @Parameters({"gridRun"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String gridRun) throws Exception {
        SeleniumGrid.run(gridRun);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() throws IOException, JSONException, InterruptedException {
        SeleniumGrid.stop();
    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional String browser) throws IOException {
        driverInst = new WebDriverInstansiator(browser);
        driverInst.setDriver();
        page = new Pages();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driverInst.driverClose();
    }

    @AfterMethod(groups = "CD", alwaysRun = true)
    public void afterMethodCD(ITestResult result) {
        DBScripts.cancelCall(result.getMethod().getMethodName());
    }
}