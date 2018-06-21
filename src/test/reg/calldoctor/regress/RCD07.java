package calldoctor.regress;

import calldoctor.TestBase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class RCD07 extends TestBase {
    @BeforeMethod
    public void beforeMethod() {
        //тут напиши всякие ожидалки загрузки страницы
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) throws Exception {
        //вот тут нужно что бы скрин был только если была ошибка
        takeSnapShot(driver, testResult);
    }

/*
    @Test(groups = "regress")
    public void testCallMkab() throws Exception {
        page.createCallPage().createCallRegistrMkabProfile1();
        page.fullCardPage().verifyCallRegistrMkabProfile1New();
    }


    @Test(groups = "regress", dependsOnMethods = {"testEditCallActivity"})
    public void testCompleteService() throws Exception {
        page.fullCardPage().completeServiceBtn();
        page.fullCardPage().verifyCompleteCall(doctorFam);
    }
*/
}