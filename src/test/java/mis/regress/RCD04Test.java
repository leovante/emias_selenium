package mis.regress;

import mis.BaseTest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

public class RCD04Test extends BaseTest {
    String doctorName;
    String doctorFam;
    String nameGen;

    @BeforeMethod
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) throws Exception {
        //вот тут нужно что бы скрин был только если была ошибка
        takeSnapShot(driver, testResult);
    }

    @Test(groups = "mis")
    public void testCallRegistr() throws Exception {
        page.createCallPage().createCallProfile1(nameGen);
        page.fullCardPage().verifyCallProfile1(nameGen);

        page.fullCardPage().appoindDoctorBtn();
        this.doctorName = page.setDoctorPage().getDoctorName(1);
        page.setDoctorPage().appendDoctor(doctorName);
        this.doctorFam = page.manageShedule().getSecondName(doctorName);
        page.fullCardPage().verifyCallProfile1Activity(doctorFam, nameGen);

        page.fullCardPage().sendAnotherDoctorBtn();
        this.doctorName = page.setDoctorPage().getDoctorName(doctorName);
        page.setDoctorPage().appendDoctor(doctorName);
        this.doctorFam = page.manageShedule().getSecondName(doctorName);
        page.fullCardPage().verifyCallProfile1Activity(doctorFam, nameGen);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().verifyActiveDocGroup(doctorFam, nameGen);
    }
}