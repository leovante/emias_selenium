package emias.calldoctor.regress;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import io.qameta.allure.Epic;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.calldoctor.doctors_interfaces.Doctor;
import pages.calldoctor.profiles_interfaces.Pacient;
import utilities.testngRetryCount.RetryCountIfFailed;

import static com.codeborne.selenide.Selenide.$;

public class InteractionMisCalldoctor extends AbstractTestGrid {

    @Test(groups = "CD", description = "назначить вызову из регистратуры врача на сегодня", enabled = false)
    @Epic("Назначить врача")
    @RetryCountIfFailed(2)
    public void testAppendDoctorToCall_Registr() throws Exception {
        Pacient pacient = new Pacient("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        enter.enterCalldoctorFromMis();
        page.createCallPage(pacient).createCall();
        page.fullCardPage(testName()).chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorToday(doctor);
        page.fullCardPage(testName()).verifyActivCall(pacient);

        page.loginPage().login(site, login, pass);
        page.homePageMis().raspisaniPriemaBtn();
        page.doctorMethods().selectDoctor(doctor);

    }

    @Test(groups = "CD", description = "проверка заполнения формализованного адреса при выборе мкаб на странице создания вызова")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testFormalizeAddress() throws Exception {
        Pacient pacient = new Pacient("Profile2");
        enter.enterCalldoctorFromMis();
        page.createCallPage(pacient)
                .addNewCall()
                .searchField();
        $(By.xpath("//*[@placeholder='Адрес']")).getText().equals(pacient.getAddress3adv());
    }

    @Test(groups = "CD", description = "проверка заполнения неформализованного адреса при выборе мкаб на странице создания вызова")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testNotformalizeAddress() throws Exception {
        Pacient pacient = new Pacient("Temnikov94");
        enter.enterCalldoctorFromMis();
        page.createCallPage(pacient)
                .addNewCall()
                .searchField();
        $(By.xpath("//*[contains(text(),'Московская обл., Рузский р-н., дп. Учитель СНТ, д.1')]")).shouldBe(Condition.visible);
    }
}
