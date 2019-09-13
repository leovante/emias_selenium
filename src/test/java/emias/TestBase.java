package emias;

import com.config.AppConfig;
import com.config.ConfigFile;
import com.pages.Page;
import com.system.service.HltCallDoctorServiceImpl;
import com.system.service.HltDispCardServiceImpl;
import com.system.service.HltDispExamServiceImpl;
import com.utils.*;
import com.utils.Selenium.SeleniumGrid;
import com.utils.assistance.Assistance;
import com.utils.assistance.AssistanceImpl;
import emias.beforeRun.BeforeRun;
import emias.calldoctor.before.BeforeTestCD;
import emias.disp.before.BeforeTestDisp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.ParseException;

@Listeners({TestMethodCapture.class})
@ContextConfiguration(classes = {AppConfig.class})
public class TestBase extends AbstractTestNGSpringContextTests{
    private WebDriverInstansiator driverInst;
    private CallDoctorCards callDoctorCards;
    public ConfigFile configFile = new ConfigFile();
    public String testName;
    protected Assistance assistance = new AssistanceImpl();

    @Autowired
    public Page page;

    @Autowired
    public HltCallDoctorServiceImpl hltCallDoctorService;

    @Autowired
    public HltDispCardServiceImpl hltDispCardService;

    @Autowired
    public HltDispExamServiceImpl hltDispExamService;

    public String testName() {
        return TestMethodCapture.getTestMethod().getMethodName();
    }

    @Parameters({"gridRun"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String gridRun) throws Exception {
        new BeforeRun(gridRun);
        SeleniumGrid.run(gridRun);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
//        SeleniumGrid.stop();
    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional String browser) throws IOException {
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
    @BeforeTest(alwaysRun = true)
    public void beforeTest(@Optional String testng) throws IOException, ParseException {
        if (testng != null) {
            new BeforeTestCD().run();
            new BeforeTestDisp();
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