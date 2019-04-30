package emias.calldoctor.regress;

import com.pages.calldoctor.doctors_interfaces.Doctor;
import com.pages.calldoctor.pacients.Pacient;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class ChooseDoctorTest extends TestBase {

    @Test(groups = "CD", description = "назначить вызову из регистратуры врача на сегодня")
    @Epic("Назначить врача")
    @RetryCountIfFailed(2)
    public void testAppendDoctorToCall_Registr() throws Exception {
        Pacient pacient = new Pacient("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn();
        page.fullCardPage(pacient, testName()).chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorToday(doctor);
        page.fullCardPage(pacient, testName())
                .verifyActivCall(pacient)
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .verifyActiveDocGroup(pacient, doctor);
    }

    @Test(groups = "CD", description = "назначить врача вызову из СМП на сегодня")
    @Epic("Назначить врача")
    @RetryCountIfFailed(2)
    public void testAppendDoctorToCall_SMP() throws Exception {
        Pacient pacient = new Pacient("Profile2");
        Doctor doctor = new Doctor("NemcovaVzroslRegistratura");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn();
        page.fullCardPage(pacient, testName()).chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorToday(doctor);
        page.fullCardPage(pacient, testName())
                .verifyActivCall(pacient)
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
//                .searchFilterDoctor(doctor)
                .verifyActiveDocGroup(pacient, doctor);
    }

//    @Test(groups = "CD", description = "назначить врача вызову из Интернета на сегодня")
//    @Epic("Назначить врача")
//    @RetryCountIfFailed(2)
//    public void testAppendDoctorToCall_Portal() throws Exception {
//        Pacient pacient = new Pacient("Profile4");
//        Doctor doctor = new Doctor("MokovStendTestovoe");
//        enter.enterPortal();
//        page.portalDashboard().createCall(pacient);
//        page.loginPage().calldoctor();
//        page.dashboardPage()
//                .clearAllFilters()
//                .openNewCallDash(pacient);
//        page.fullCardPage(testName()).verifyNewCall(pacient);
//        page.fullCardPage(testName()).chooseDoctorBtn();
//        page.setDoctorPage()
//                .saveAddress()
//                .chooseDoctorToday(doctor);
//        page.fullCardPage(testName())
//                .verifyActivCall(pacient)
//                .closeCardBtn();
//        page.dashboardPage()
//                .clearAllFilters()
//                .verifyActiveDocGroup(pacient, doctor);
//    }

    // TODO: 13.08.2018 тест назначить врача вызову из КЦ
}