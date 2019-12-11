package emias;

import com.commons.CallDoctorCards;
import com.commons.TestMethodCapture;
import com.commons.WebDriverInstansiator;
import com.pages.Page;
import com.settings.AppConfig;
import com.system.service.*;
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
public class TestBase extends TestNGBase {
    private WebDriverInstansiator driverInst;
    private CallDoctorCards callDoctorCards;
    public String testName;

    @Autowired
    public Page page;

    public String testName() {
        return TestMethodCapture.getTestMethod().getMethodName();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driverInst = new WebDriverInstansiator();
        driverInst.setDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
//        new Logging();
        driverInst.driverClose();
    }

}