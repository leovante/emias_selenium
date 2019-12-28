package emias;

import com.commons.TestMethodCapture;
import com.pages.IPage;
import com.settings.AppConfig;
import com.settings.WebSettings;
import com.system.service.HltCallDoctorServiceImpl;
import com.testRunner.TestNGBase;
import emias.calldoctor.before.BeforeTestCD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static com.beans.SpringBeansUtil.getBean;
import static com.settings.WebSettings.initFromProperties;

@Listeners({TestMethodCapture.class})
@ContextConfiguration(classes = {AppConfig.class})
public class TestCallDoctorBase extends TestNGBase {
    public String testName;

    @Autowired
    public IPage page;

    public String testName() {
        return TestMethodCapture.getTestMethod().getMethodName();
    }

    @Parameters({"browser","testng"})
    @BeforeClass(groups = "CD", alwaysRun = true, dependsOnMethods = "springTestContextPrepareTestInstance")
    public void beforeClassCD(@Optional String browser, @Optional String testng) {
        initFromProperties(browser, testng);
        if (browser != null)
            new BeforeTestCD().run();
    }

    @AfterMethod(groups = "CD", alwaysRun = true)
    public void afterMethodCD(ITestResult result) {//работает только с afterMethod
        String testName = result.getMethod().getMethodName();
        if (callDoctorCards.getCardMap(testName) != null) {
            int id = this.callDoctorCards.getCardMap(testName);
            getBean(HltCallDoctorServiceImpl.class).cancelById(id);
        }
    }
}