package calldoctor.regress;

import calldoctor.TestBase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

public class RCD01 extends TestBase {
    String nameGen;

    @BeforeMethod
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = nameGen.generator();
        this.nameGen = name;
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) throws Exception {
        //вот тут нужно что бы скрин был только если была ошибка
        takeSnapShot(driver, testResult);
    }

    @Test(groups = "regress")
    public void testCallRegistr() throws Exception {
        page.createCallPage().createCallRegistrProfile1(nameGen);
        page.fullCardPage().verifyCallRegistrProfile1New(nameGen);
        page.fullCardPage().closeCallPageBtn();

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().verifyNewCallProgressFrame(nameGen);
    }

    @Test(groups = "regress")
    public void testCallRegistrMkab() throws Exception {
        page.createCallPage().createCallRegistrMkabProfile1(nameGen);
        page.fullCardPage().verifyCallRegistrMkabProfile1New(nameGen);
        page.fullCardPage().closeCallPageBtn();

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().verifyNewCallProgressFrame(nameGen);
    }

    @Ignore
    @Test(groups = "regress")
    public void testCallSMP() throws Exception {
        page.createCallPage().createCallSMP();
        page.fullCardPage().verifyCallSMPNew();
    }

    @Ignore
    @Test(groups = "regress")
    public void testCallSMPMkab() throws Exception {
        page.createCallPage().createCallSMPMkab();
        page.fullCardPage().verifyCallSMPMkabNew();
    }
}