package emias.calldoctor;

import emias.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

public class RCD04Test extends BaseTest {
    String doctorName;
    String doctorFam;
    String nameGen;

    @BeforeTest(groups = "mis")
    public void beforeTest() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterTest(groups = "mis")
    public void afterTest() throws Exception {
        //вот тут нужно что бы скрин был только если была ошибка
//        takeSnapShot(driver, testResult);
    }

    @Test(groups = "mis", description = "передать вызов на странице карты вызова")
    public void testCallRegistr() throws Exception {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);
//        page.fullCardPage().verifyCallProfile1(nameGen);

        page.fullCardPage().appoindDoctorBtn();
        this.doctorName = page.setDoctorPage().getDoctorName(1);
        page.setDoctorPage().appendDoctor(doctorName);
        this.doctorFam = page.manageShedule().getSecondName(doctorName);
//        page.fullCardPage().verifyCallProfile1Activity(doctorFam, nameGen);

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