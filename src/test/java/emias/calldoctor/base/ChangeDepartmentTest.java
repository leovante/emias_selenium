package emias.calldoctor.base;

import com.codeborne.selenide.Condition;
import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientImpl;
import com.commons.assistance.DuringTestHelper;
import com.commons.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import emias.TestCallDoctorBase;
import io.qameta.allure.Epic;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class ChangeDepartmentTest extends TestCallDoctorBase {
    @Test(groups = {"CD", "test"}, description = "передача вызова из Юр лица в подразделение")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testTransferCallLpu_Depart() {
        Pacient pacient = new PacientImpl("ProfileTransferLpu-Dep");
        Doctor doctor = new Doctor("TemnikovStend");
        Doctor doctor2 = new Doctor("YudinaVzroslayaTerapev");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName())
                .verifyDepartment(doctor)
                .transfer_to_depart();
        page.passLpu(doctor2).transfer();
        page.fullCard(pacient, testName())
                .verifyDepartment(doctor2);
    }

    @Test(groups = "CD", description = "передача вызова из подразделения в подразделение")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testTransferCallDepart_Depart() {
        Pacient pacient = new PacientImpl("ProfileTransferDep-Dep");
        Doctor doctor = new Doctor("TemnikovStend");
        Doctor doctor2 = new Doctor("ZaycevaDetskayaOftalmol");
        Doctor doctor3 = new Doctor("YudinaVzroslayaTerapev");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName())
                .verifyDepartment(doctor)
                .transfer_to_depart();
        page.passLpu(doctor2).transfer();
        page.fullCard(pacient, testName())
                .verifyDepartment(doctor2)
                .transfer_to_depart();
        page.passLpu(doctor3).transfer();
        page.fullCard(pacient, testName()).verifyDepartment(doctor3);
    }

    @Test(groups = "CD", description = "передача вызова из подр в ЛПУ")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testTransferCallDepart_Lpu() {
        Pacient pacient = new PacientImpl("ProfileTransferDep-Lpu");
        Doctor dep_doc = new Doctor("TemnikovVzroslayaTerapev");
        Doctor lpu_doc = new Doctor("TemnikovStend");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome()
                .calldoctorVzroslaya();
        page.createCall(pacient)
                .createCall();
        page.fullCard(pacient, testName())
                .verifyDepartment(dep_doc)
                .transfer_to_depart();
        page.passLpu(lpu_doc)
                .transfer();
        page.fullCard(pacient, testName())
                .verifyDepartment(lpu_doc);
    }

    @Test(groups = "CD", description = "передача вызова из ЛПУ в ЛПУ")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testTransferCallLpu_Lpu() {
        Pacient pacient = new PacientImpl("ProfileTransferLpu-Lpu");
        Doctor doctor = new Doctor("TemnikovStend");
        Doctor doctor2 = new Doctor("TemnikovHimkiStend");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome()
                .calldoctorAdminTemnikov();
        page.createCall(pacient)
                .createCall();
        page.fullCard(pacient, testName())
                .verifyDepartment(doctor)
                .transfer_to_depart();
        page.passLpu(doctor2)
                .search_lpu()
                .transfer();
        page.fullCard(pacient, testName())
                .verifyDepartment(doctor2);

        page.misHome()
                .calldoctorHimki();
        page.dashboard()
                .dashFilter_fio(pacient)
                .verifyNewCallGroup(pacient);
    }

    @Test(groups = "CD", description = "На странице передачи в другое подр. у взрослого вызова отображается взрослое и не отображается детское")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testshowMeYourAdultPoliklinika() {
        Pacient pacient = new PacientImpl("ProfileTransferDep-Lpu");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName()).transfer_to_depart();
        page.passLpu().validate_view_to_adult();
    }

    @Test(groups = "CD", description = "На странице передачи в другое лпу у детского вызова не отображается взрослая поликлиника и наоборот")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testshowMeYourKidPoliklinika() {
        Pacient pacient = new PacientImpl("Profile2");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall_Mkab();
        page.fullCard(pacient, testName()).transfer_to_depart();
        $(By.xpath("//*[contains(text(),'Детская поликлиника')]")).shouldBe(Condition.visible);
        sleep(1000);
        $(By.xpath("//*[contains(text(),'Взрослая поликлиника')]")).shouldNotBe(Condition.visible);
    }

    // TODO: 11/8/2019 сделать тест проверки что кнопка передать задизеблина если не выбрано куда передавать
}