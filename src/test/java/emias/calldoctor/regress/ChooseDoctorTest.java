package emias.calldoctor.regress;

import emias.AbstractTestGrid;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.calldoctor.doctors_interfaces.Doctor;
import pages.calldoctor.profiles_interfaces.Pacient;
import utilities.testngRetryCount.RetryCountIfFailed;

public class ChooseDoctorTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "назначить вызову из регистратуры врача на сегодня")
    @Epic("Назначить врача")
    @RetryCountIfFailed(2)
    public void testAppendDoctorToCall_Registr() throws Exception {
        Pacient pacient = new Pacient("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        enter.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorToday(doctor);
        page.fullCardPage()
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
        enter.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorToday(doctor);
        page.fullCardPage()
                .verifyActivCall(pacient)
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .searchFilterDoctor(doctor)
                .verifyActiveDocGroup(pacient, doctor);
    }

    @Test(groups = "CD", description = "назначить врача вызову из Интернета на сегодня")
    @Epic("Назначить врача")
    @RetryCountIfFailed(2)
    public void testAppendDoctorToCall_Portal() throws Exception {
        Pacient pacient = new Pacient("Profile4");
        Doctor doctor = new Doctor("MokovStendTestovoe");
        enter.enterPortal();
        page.portalDashboard().createCall(pacient);
        enter.enterCalldoctorFromMis();
        page.dashboardPage()
                .clearAllFilters()
                .openNewCallDash(pacient);
        page.fullCardPage().verifyNewCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage()
                .saveAddress()
                .chooseDoctorToday(doctor);
        page.fullCardPage()
                .verifyActivCall(pacient)
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .verifyActiveDocGroup(pacient, doctor);
    }

    // TODO: 13.08.2018 тест назначить врача вызову из КЦ
}