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
        page.createCallPage().createCallRegistrMkab();
        page.fullCardPage().verifyCallRegistrMkabNew();
    }

    @Test(groups = "regress", dependsOnMethods = {"testEditCall"})
    public void testSetDoctor() throws Exception {
        page.fullCardPage().appoindDoctorBtn();
        this.doctorName = page.setDoctorPage().getDoctorName(1);
        page.setDoctorPage().appendDoctor(doctorName);

        this.doctorFam = page.manageShedule().getSecondName(doctorName);
        page.fullCardPage().verifyAppoindPoctor(doctorFam);
    }

    @Test(groups = "regress", dependsOnMethods = {"testEditCallActivity"})
    public void testCompleteService() throws Exception {
        page.fullCardPage().completeServiceBtn();
        page.fullCardPage().verifyCompleteCall(doctorFam);
    }
*/
}