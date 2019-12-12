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
public class TestCallDoctorBase extends TestNGBase {
    public String testName;

    @Autowired
    public Page page;

    public String testName() {
        return TestMethodCapture.getTestMethod().getMethodName();
    }

    @Parameters({"testng"})
    @BeforeClass(groups = "CD", alwaysRun = true, dependsOnMethods = "springTestContextPrepareTestInstance")
    public void beforeClassCD(@Optional String testng) {
        if (testng != null) {
            new BeforeTestCD().run();
        }
    }

    @AfterMethod(groups = "CD", alwaysRun = true)
    public void afterMethodCD(ITestResult result) {//работает только с afterMethod
        String testName1 = result.getMethod().getMethodName();
        if (callDoctorCards.getCardMap(testName1) != null) {
            int id = this.callDoctorCards.getCardMap(testName1);
            getBean(HltCallDoctorServiceImpl.class).cancelById(id);
        }
    }
}