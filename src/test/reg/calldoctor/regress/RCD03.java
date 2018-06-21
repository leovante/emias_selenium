package calldoctor.regress;

import calldoctor.TestBase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

public class RCD03 extends TestBase {
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

    @Test(groups = "regress")
    public void testCallRegistr() throws Exception {
        page.createCallPage().createCallRegistrProfile1(nameGen);
        page.fullCardPage().verifyCallRegistrProfile1New(nameGen);
    }

    @Test(groups = "regress", dependsOnMethods = {"testCallRegistr"})
    public void testEditCallRegistrNew() throws Exception {
        page.editCardPage().editCallBtn();
        page.editCardPage().editCallRegistrProfile2(nameGen);
        page.fullCardPage().verifyCallRegistrProfile2New(nameGen);
    }

    @Test(groups = "regress", dependsOnMethods = {"testEditCallRegistrNew"})
    public void testSetDoctor() throws Exception {
        page.fullCardPage().appoindDoctorBtn();
        this.doctorName = page.setDoctorPage().getDoctorName(1);
        page.setDoctorPage().appendDoctor(doctorName);

        this.doctorFam = page.manageShedule().getSecondName(doctorName);
        page.fullCardPage().verifyCallRegistr2Activity(doctorFam);
        page.fullCardPage().closeCallPageBtn();
    }

    @Test(groups = "regress", dependsOnMethods = {"testSetDoctor"})
    public void testDoctorOnPage() {
        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().clickDoctorName(doctorFam);

    }

    @Test(groups = "regress", dependsOnMethods = {"testDoctorOnPage"})
    public void testSearchCallOnDoctorSheadule() throws InterruptedException {
        driver.get("http://emias.mosreg.ru/demonstration/Schedule");
        page.doctorMethods().selectDoctor(doctorName);
        page.admissionSchedule().verifyFindCallName(nameGen);
    }
}