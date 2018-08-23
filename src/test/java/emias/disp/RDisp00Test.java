package emias.disp;

import emias.AbstractTest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.utilities.SQLDemonstration;
import pages.utilities.StringGenerator;

public class RDisp00Test extends AbstractTest {
    private String nameGen;

    @BeforeMethod(groups = {"CD", "test"})
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        this.nameGen = String.valueOf(nameGen.generator());
    }

    @AfterMethod(groups = {"CD", "test"})
    public void afterMethod(ITestResult result) {
        SQLDemonstration.finalizePacientName(nameGen);
    }

//    @Test(groups = "disp", description = "создать МЛ")
//    @Issue("EMIAS-90")
//    @TmsLink("EMIAS-90")
//    @RetryCountIfFailed(2)
//    public void testCreateML() {
//
//    }
}