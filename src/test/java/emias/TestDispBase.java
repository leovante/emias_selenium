package emias;

import com.commons.CallDoctorCards;
import com.commons.TestMethodCapture;
import com.commons.WebDriverInstansiator;
import com.pages.Page;
import com.settings.AppConfig;
import com.system.service.HltCallDoctorServiceImpl;
import com.testRunner.TestNGBase;
import emias.calldoctor.before.BeforeTestCD;
import emias.disp.before.BeforeTestDisp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static com.beans.SpringBeansUtil.getBean;

@Listeners({TestMethodCapture.class})
@ContextConfiguration(classes = {AppConfig.class})
public class TestDispBase extends TestNGBase {
    private WebDriverInstansiator driverInst;
    private CallDoctorCards callDoctorCards;
    public String testName;

    @Autowired
    public Page page;

    public String testName() {
        return TestMethodCapture.getTestMethod().getMethodName();
    }

    @Parameters({"testng"})
    @BeforeClass(groups = "disp", alwaysRun = true, dependsOnMethods = "springTestContextPrepareTestInstance")
    public void beforeClassDisp(@Optional String testng) {
//        initFromProperties();
        if (testng != null) {
            new BeforeTestDisp().run();
        }
    }
}