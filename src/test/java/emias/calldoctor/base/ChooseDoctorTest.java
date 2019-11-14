package emias.calldoctor.base;

import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.PacientImpl;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class ChooseDoctorTest extends TestBase {

    @Test(groups = "CD", description = "вызов из регистратуры. назначить врача на сегодня")
    @Epic("Назначить врача")
    @RetryCountIfFailed(2)
    public void testAppendDoctorToCall_Registr() {
        PacientImpl pacientImpl = new PacientImpl("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor);
        page.fullCard(pacientImpl, testName())
                .verifyActivCall(pacientImpl)
                .closeCardBtn();
        page.dashboard()
                .clearFilterDepart()
                .verifyActiveDocGroup(pacientImpl, doctor);
    }

    @Test(groups = "CD", description = "вызов из СМП. назначить врача на сегодня")
    @Epic("Назначить врача")
    @RetryCountIfFailed(2)
    public void testAppendDoctorToCall_SMP() {
        PacientImpl pacientImpl = new PacientImpl("Profile2");
        Doctor doctor = new Doctor("NemcovaVzroslRegistratura");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor);
        page.fullCard(pacientImpl, testName())
                .verifyActivCall(pacientImpl)
                .closeCardBtn();
        page.dashboard()
                .clearFilterDepart()
//                .searchFilterDoctor(doctor)
                .verifyActiveDocGroup(pacientImpl, doctor);
    }

    //    @Test(groups = "CD", description = "назначить врача вызову из Интернета на сегодня")
//    @Epic("Назначить врача")
//    @RetryCountIfFailed(2)
//    public void testAppendDoctorToCall_Portal() throws Exception {
//        Pacient pacient = new Pacient("Profile4");
//        Doctor doctor = new Doctor("MokovStendTestovoe");
//        select.enterPortal();
//        page.portalDashboard().createCall(pacient);
//        page.misHome().calldoctor();
//        page.dashboard()
//                .clearFilterDepart()
//                .openNewCallDash(pacient);
//        page.fullCard(testName()).verifyNewCall(pacient);
//        page.fullCard(testName()).chooseDoctorBtn();
//        page.setDoctor()
//                .saveAddress()
//                .chooseDoctorToday(doctor);
//        page.fullCard(testName())
//                .verifyActivCall(pacient)
//                .closeCardBtn();
//        page.dashboard()
//                .clearFilterDepart()
//                .verifyActiveDocGroup(pacient, doctor);
//    }

    @Test(groups = "CD", description = "назначить участкового врача на сегодня")
    @Epic("Назначить врача")
    @RetryCountIfFailed(2)
    public void testAppendUchastkoviyDoctor() {
        PacientImpl pacientImpl = new PacientImpl("Profile2");
        Doctor doctor = new Doctor("NemcovaVzroslRegistratura");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor);
        page.fullCard(pacientImpl, testName())
                .verifyActivCall(pacientImpl)
                .closeCardBtn();
        page.dashboard()
                .clearFilterDepart()
//                .searchFilterDoctor(doctor)
                .verifyActiveDocGroup(pacientImpl, doctor);
    }
}