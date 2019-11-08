package emias.calldoctor.base;

import com.codeborne.selenide.Condition;
import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.PacientImpl;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class ChangeDepartmentTest extends TestBase {
    @Test(groups = {"CD", "test"}, description = "передача вызова из Юр лица в подразделение")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testTransferCallLpu_Depart() {
        PacientImpl pacientImpl = new PacientImpl("ProfileTransferLpu-Dep");
        Doctor doctor = new Doctor("TemnikovStend");
        Doctor doctor2 = new Doctor("YudinaVzroslayaTerapev");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        page.fullCard(pacientImpl, testName())
                .verifyDepartment(doctor)
                .transfer_to_depart();
        page.passLpu(doctor2).transfer();
        page.fullCard(pacientImpl, testName())
                .verifyDepartment(doctor2);
    }

    @Test(groups = "CD", description = "передача вызова из подразделения в подразделение")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testTransferCallDepart_Depart() {
        PacientImpl pacientImpl = new PacientImpl("ProfileTransferDep-Dep");
        Doctor doctor = new Doctor("TemnikovStend");
        Doctor doctor2 = new Doctor("ZaycevaDetskayaOftalmol");
        Doctor doctor3 = new Doctor("YudinaVzroslayaTerapev");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        page.fullCard(pacientImpl, testName())
                .verifyDepartment(doctor)
                .transfer_to_depart();
        page.passLpu(doctor2).transfer();
        page.fullCard(pacientImpl, testName())
                .verifyDepartment(doctor2)
                .transfer_to_depart();
        page.passLpu(doctor3).transfer();
        page.fullCard(pacientImpl, testName()).verifyDepartment(doctor3);
    }

    @Test(groups = "CD", description = "передача вызова из подр в ЛПУ")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testTransferCallDepart_Lpu() {
        PacientImpl pacientImpl = new PacientImpl("ProfileTransferDep-Lpu");
        Doctor dep_doc = new Doctor("TemnikovVzroslayaTerapev");
        Doctor lpu_doc = new Doctor("TemnikovStend");
        page.misHome().calldoctorVzroslaya();
        page.createCall(pacientImpl).createCall();
        page.fullCard(pacientImpl, testName())
                .verifyDepartment(dep_doc)
                .transfer_to_depart();
        page.passLpu(lpu_doc).transfer();
        page.fullCard(pacientImpl, testName())
                .verifyDepartment(lpu_doc);
    }

    @Test(groups = "CD", description = "передача вызова из ЛПУ в ЛПУ")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testTransferCallLpu_Lpu() {
        PacientImpl pacient = new PacientImpl("ProfileTransferLpu-Dep");
        Doctor doctor = new Doctor("TemnikovStend");
        Doctor doctor2 = new Doctor("TemnikovHimkiStend");
        page.misHome().calldoctor();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName())
                .verifyDepartment(doctor)
                .transfer_to_depart();
        page.passLpu(doctor2)
                .search_lpu()
                .transfer();
        page.fullCard(pacient, testName())
                .verifyDepartment(doctor2);
        // TODO: 7/24/2019 доделать проверку на стороне Химок
    }

    @Test(groups = "CD", description = "На странице передачи в другое подр. у взрослого вызова отображается взрослое и не отображается детское")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testshowMeYourAdultPoliklinika() {
        PacientImpl pacient = new PacientImpl("ProfileTransferDep-Lpu");
        page.misHome().calldoctor();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName()).transfer_to_depart();
        page.passLpu().validate_view_to_adult();
    }

    @Test(groups = "CD", description = "На странице передачи в другое лпу у детского вызова не отображается взрослая поликлиника и наоборот")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testshowMeYourKidPoliklinika() {
        PacientImpl pacient = new PacientImpl("Profile2");
        page.misHome().calldoctor();
        page.createCall(pacient).createCall_Mkab();
        page.fullCard(pacient, testName()).transfer_to_depart();
        $(By.xpath("//*[contains(text(),'Детская поликлиника')]")).shouldBe(Condition.visible);
        sleep(1000);
        $(By.xpath("//*[contains(text(),'Взрослая поликлиника')]")).shouldNotBe(Condition.visible);
    }

    // TODO: 11/8/2019 сделать тест проверки что кнопка передать задизеблина если не выбрано куда передавать
}