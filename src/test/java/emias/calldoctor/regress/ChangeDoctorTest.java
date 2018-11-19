package emias.calldoctor.regress;

import emias.AbstractTestGrid;
import utilities.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.calldoctor.doctors_interfaces.Doctor;
import pages.calldoctor.profiles_interfaces.Pacient;

public class ChangeDoctorTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "передать вызов другому врачу")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testSendCallToSecondDoctor_Registr() throws Exception {
        Pacient pacient = new Pacient("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        Doctor doctor2 = new Doctor("NemcovaVzroslRegistratura");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor(doctor);
        page.fullCardPage().changeDoctorBtn();
        page.setDoctorPage().chooseDoctor(doctor2);
        page.fullCardPage()
                .verifyActivCall(pacient)
                .verifyDoctor(doctor2)
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
//                .searchFilterFio()
                .verifyActiveDocGroup(pacient, doctor2);
    }
}