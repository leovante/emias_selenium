package emias;

import com.config.AppConfig;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import com.pages.Pages;
import com.system.service.HltCallDoctorServiceImpl;
import com.system.service.HltDispCardServiceImpl;
import com.utils.CallDoctorCards;
import com.utils.Selenium.SeleniumGrid;
import com.utils.TestMethodCapture;
import com.utils.WebDriverInstansiator;
import com.utils.override.Assistance;
import com.utils.override.AssistanceImpl;
import emias.calldoctor.before.BeforeTestCD;
import emias.disp.before.BeforeTestDisp;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Logger;

import static com.pages.PageBase.LOGGER;

@Listeners({TestMethodCapture.class, /*CustomListner1.class,*/ ReportPortalTestNGListener.class})
@ContextConfiguration(classes = {AppConfig.class})
public class TestBase extends AbstractTestNGSpringContextTests {
    private WebDriverInstansiator driverInst;
    public CallDoctorCards callDoctorCards;
    public static Pages page;
    public String testName;
    protected Assistance as = new AssistanceImpl();

    @Autowired
    public HltCallDoctorServiceImpl hltCallDoctorService;

    @Autowired
    public HltDispCardServiceImpl hltDispCardServiceImpl;

    public String testName() {
        return TestMethodCapture.getTestMethod().getMethodName();
    }

    @Parameters({"gridRun"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String gridRun) throws Exception {
        SeleniumGrid.run(gridRun);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() throws IOException, JSONException, InterruptedException {
//        SeleniumGrid.stop();
    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional String browser) throws IOException {
        driverInst = new WebDriverInstansiator(browser);
        driverInst.setDriver();
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        page = new Pages();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        LOGGER.info("RP_MESSAGE#BASE64#BASE_64_REPRESENTATION#MESSAGE_TEST");
        driverInst.driverClose();
    }

    /* СЕРВИСЫ */
    @Parameters({"testng"})
    @BeforeTest(alwaysRun = true)
    public void beforeTest(@Optional String testng) throws IOException, ParseException {
        if (testng != null) {
            new BeforeTestCD().run();
            new BeforeTestDisp().run();
        }
    }

    @AfterMethod(groups = "CD", alwaysRun = true)
    public void afterMethodCD(ITestResult result) {//работает только с afterMethod
        String testName1 = result.getMethod().getMethodName();
        if (callDoctorCards.getCardMap(testName1) != null) {
            int id = callDoctorCards.getCardMap(testName1);
            hltCallDoctorService.cancelById(id);
        }
    }
}