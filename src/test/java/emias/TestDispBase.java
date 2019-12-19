package emias;

import com.commons.CallDoctorCards;
import com.commons.TestMethodCapture;
import com.commons.WebDriverInstansiator;
import com.pages.IPage;
import com.settings.AppConfig;
import com.testRunner.TestNGBase;
import emias.disp.before.BeforeTestDisp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.*;

@Listeners({TestMethodCapture.class})
@ContextConfiguration(classes = {AppConfig.class})
public class TestDispBase extends TestNGBase {
    private WebDriverInstansiator driverInst;
    private CallDoctorCards callDoctorCards;
    public String testName;

    @Autowired
    public IPage IPage;

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