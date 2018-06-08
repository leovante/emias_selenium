import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RCD01 extends TestBase {
    @BeforeMethod
    public void beforeMethod() {
        //тут напиши всякие ожидалки загрузки страницы
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) throws Exception {
        //вот тут нужно что бы скрин был только если была ошибка
        takeSnapShot(driver, testResult);
    }

    @Test(groups = "regress")
    public void testCallRegistr() throws Exception {
        page.createCallPage().createCallRegistr();
        page.fullCardPage().verifyCallRegistrNew();
    }

    @Test(groups = "regress")
    public void testCallRegistrMkab() throws Exception {
        page.createCallPage().createCallRegistrMkab();
        page.fullCardPage().verifyCallRegistrMkabNew();
    }

    @Test(groups = "regress")
    public void testCallSMP() throws Exception {
        page.createCallPage().createCallSMP();
        page.fullCardPage().verifyCallSMPNew();
    }

    @Test(groups = "regress")
    public void testCallSMPMkab() throws Exception {
        page.createCallPage().createCallSMPMkab();
        page.fullCardPage().verifyCallSMPMkabNew();
    }
}