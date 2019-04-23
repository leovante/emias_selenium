package emias.calldoctor.regress;


import emias.TestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.calldoctor.doctors_interfaces.Doctor;
import pages.calldoctor.pacients.Pacient;
import utils.testngRetryCount.RetryCountIfFailed;

public class ChangeDoctorTest extends TestBase {

    @Test(groups = "CD", description = "передать вызов другому врачу")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testSendCallToSecondDoctor_Registr() throws Exception {
        Pacient pacient = new Pacient("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        Doctor doctor2 = new Doctor("NemcovaVzroslRegistratura");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn();
        page.fullCardPage(pacient, testName()).chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorToday(doctor);
        page.fullCardPage(pacient, testName()).changeDoctorBtn();
        page.setDoctorPage().chooseDoctorToday(doctor2);
        page.fullCardPage(pacient, testName())
                .verifyActivCall(pacient)
                .verifyDoctor(doctor2)
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .verifyActiveDocGroup(pacient, doctor2);
    }
}