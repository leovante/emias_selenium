package emias;

import com.config.AppConfig;
import com.dataGenerator.FactoryData;
import com.pages.Pages;
import com.system.service.HltMkabService;
import com.utils.Selenium.SeleniumGrid;
import com.utils.TestMethodCapture;
import com.utils.WebDriverInstansiator;
import com.utils.override.Assistance;
import com.utils.override.AssistanceImpl;
import com.utils.sql.DBScripts;
import emias.calldoctor.after.AfterTestCalldoctor;
import emias.calldoctor.before.BeforeTestCalldoctor;
import emias.disp.before.BeforeTestDisp;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.ParseException;

@Listeners(TestMethodCapture.class)
@ContextConfiguration(classes = {AppConfig.class})
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

    @Parameters({"testng"})
    @BeforeTest(groups = "CD")
    public void beforeTestCD(@Optional String testng) throws IOException, ParseException {
        if (testng != null)
            new BeforeTestCalldoctor().beforeCallDoctorTest();
    }

    @AfterMethod(groups = "CD", alwaysRun = true)
    public void afterMethodCD(ITestResult result) {
        DBScripts.cancelCall(result.getMethod().getMethodName());
        new AfterTestCalldoctor().cleanAfterCallDoctorTests();
    }

    @Parameters({"testng"})
    @BeforeTest(groups = "disp")
    public void beforeTestDisp(@Optional String testng) throws IOException, ParseException {
        if (testng != null)
            new BeforeTestDisp().cleanBeforeDisp();
    }
}