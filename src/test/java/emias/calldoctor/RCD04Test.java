package emias.calldoctor;

import emias.BaseTest;
import emias.TestngRetryCount.RetryCountIfFailed;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.utilities.StringGenerator;

public class RCD04Test extends BaseTest implements Profile1, Profile2 {
    String doctorName;
    String doctorFam;
    String nameGen;

    @BeforeTest(groups = "CD")
    public void beforeTest() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterTest(groups = "CD")
    public void afterTest() throws Exception {
    }

    @Test(groups = "CD", description = "передать вызов другому врачу")
    @RetryCountIfFailed(2)
    public void testCallRegistr() throws Exception {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);

        page.fullCardPage().appoindDoctorBtn();
        this.doctorName = page.setDoctorPage().getDoctorName(1);
        page.setDoctorPage().appendDoctor(doctorName);
        this.doctorFam = page.manageShedule().getSecondName(doctorName);

        page.fullCardPage().sendAnotherDoctorBtn();
        this.doctorName = page.setDoctorPage().getDoctorName(doctorName);
        page.setDoctorPage().appendDoctor(doctorName);
        this.doctorFam = page.manageShedule().getSecondName(doctorName);
        page.fullCardPage().verifyCallProfile1Activity(doctorFam, nameGen);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().clearFilterDepart();
        page.dashboardPage().verifyActiveDocGroup(doctorFam, nameGen, adressPro1_2, telephonePro1);
    }
}