package emias;

import com.config.AppConfig;
import com.pages.Page;
import com.system.service.*;
import com.utils.CallDoctorCards;
import com.utils.Selenium.SeleniumGrid;
import com.utils.TestMethodCapture;
import com.utils.WebDriverInstansiator;
import com.utils.screenshotsListner.CustomTestListener;
import emias.beforeRun.BeforeRun;
import emias.calldoctor.before.BeforeTestCD;
import emias.disp.before.BeforeTestDisp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.ParseException;

import static com.utils.WebDriverUtils.killAllRunWebBrowsers;

@Listeners({TestMethodCapture.class})
@ContextConfiguration(classes = {AppConfig.class})
//@TestExecutionListeners(inheritListeners = false, listeners =
//        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
//@TestExecutionListeners(value = CustomTestListener.class, mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
public class TestBase extends AbstractTestNGSpringContextTests {
    private WebDriverInstansiator driverInst;
    private CallDoctorCards callDoctorCards;
    public String testName;

    @Autowired
    public Page page;

    @Autowired
    public HltCallDoctorServiceImpl hltCallDoctorService;

    @Autowired
    public HltDispCardServiceImpl hltDispCardService;

    @Autowired
    public HltDispExamServiceImpl hltDispExamService;

    @Autowired
    public HltDispExamMrServiceImpl hltDispExamMrService;

    @Autowired
    public HltDispExamSmServiceImpl hltDispExamSmService;

    @Autowired
    public HltDispServiceDocPrvdServiceImpl hltDispServiceDocPrvdService;

    public String testName() {
        return TestMethodCapture.getTestMethod().getMethodName();
    }

    @Parameters({"gridRun"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String gridRun) {
        new BeforeRun(gridRun);
        SeleniumGrid.run(gridRun);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        killAllRunWebBrowsers();
//        SeleniumGrid.stop();
    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional String browser) {
        driverInst = new WebDriverInstansiator(browser);
        driverInst.setDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
//        new Logging();
        driverInst.driverClose();
    }

    /* СЕРВИСЫ */
    @Parameters({"testng"})
    @BeforeClass(groups = "CD", alwaysRun = true, dependsOnMethods = "springTestContextPrepareTestInstance")
    public void beforeClassCD(@Optional String testng) {
        if (testng != null) {
            new BeforeTestCD().run();
        }
    }

    @Parameters({"testng"})
    @BeforeClass(groups = "disp", alwaysRun = true, dependsOnMethods = "springTestContextPrepareTestInstance")
    public void beforeClassDisp(@Optional String testng) {
        if (testng != null) {
            new BeforeTestDisp().run();
        }
    }

    @AfterMethod(groups = "CD", alwaysRun = true)
    public void afterMethodCD(ITestResult result) {//работает только с afterMethod
        String testName1 = result.getMethod().getMethodName();
        if (this.callDoctorCards.getCardMap(testName1) != null) {
            int id = this.callDoctorCards.getCardMap(testName1);
            hltCallDoctorService.cancelById(id);
        }
    }
}