package emias.calldoctor.regress;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.calldoctor.doctors_interfaces.Doctor;
import pages.calldoctor.profiles_interfaces.Pacient;

public class ChooseDoctorTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "назначить вызову из регистратуры врача на сегодня")
    @Epic("Назначить врача")
    @RetryCountIfFailed(2)
    public void testAppendDoctorToCall_Registr() throws Exception {
        Pacient pacient = new Pacient("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor(doctor);
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
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor(doctor);
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
        enterSite.enterPortal();
        page.portalDashboard().createCall(pacient);
        enterSite.enterCalldoctorFromMis();
        page.dashboardPage()
                .clearAllFilters()
                .openNewCallDash(pacient);
        page.fullCardPage().verifyNewCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage()
                .saveAddress()
                .chooseDoctor(doctor);
        page.fullCardPage()
                .verifyActivCall(pacient)
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .verifyActiveDocGroup(pacient, doctor);
    }

    // TODO: 13.08.2018 тест назначить врача вызову из регистратуры на зватра
    // TODO: 13.08.2018 тест назначить врача вызову из КЦ
}