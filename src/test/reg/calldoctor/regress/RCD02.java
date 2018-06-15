package calldoctor.regress;

import calldoctor.TestBase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

public class RCD02 extends TestBase {
    String nameGen;

    @BeforeMethod(groups = "calldoctor")
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterMethod(groups = "calldoctor")
    public void afterMethod(ITestResult testResult) throws Exception {
        //вот тут нужно что бы скрин был только если была ошибка
        takeSnapShot(driver, testResult);
    }

    @Test(groups = "calldoctor")
    public void testEditProfile1() throws Exception {
        page.createCallPage().createCallProfile1(nameGen);
        page.fullCardPage().verifyCallProfile1(nameGen);

        page.editCardPage().editCallBtn();
        page.editCardPage().editCallProfile2(nameGen);
        page.fullCardPage().verifyCallProfile2(nameGen);

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().verifyNewCallProgressFrame(nameGen);
    }
}