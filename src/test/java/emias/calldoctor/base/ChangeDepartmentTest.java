package emias.calldoctor.base;

import com.codeborne.selenide.Condition;
import com.commons.assistance.DuringTestHelper;
import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.IPacient;
import com.datas.calldoctor.PacientImpl;
import emias.TestCallDoctorBase;
import io.qameta.allure.Epic;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static com.commons.assistance.Assistance.visible;

public class ChangeDepartmentTest extends TestCallDoctorBase {
    @Test(groups = {"CD", "test"}, description = "передача вызова из Юр лица в подразделение")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testTransferCallLpu_Depart() {
        IPacient pacient = new PacientImpl("ProfileTransferLpu-Dep");
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
        IPacient pacient = new PacientImpl("ProfileTransferDep-Dep");
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
        IPacient pacient = new PacientImpl("ProfileTransferDep-Lpu");
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
        IPacient pacient = new PacientImpl("ProfileTransferLpu-Lpu");
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
    public void testShowMeYourAdultPoliklinika() {
        IPacient pacient = new PacientImpl("ProfileTransferDep-Lpu");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName()).transfer_to_depart();
        page.passLpu().validate_view_to_adult();
    }

    @Test(groups = "CD", description = "На странице передачи в другое лпу у детского вызова не отображается взрослая поликлиника и наоборот")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testShowMeYourKidPoliklinika() {
        IPacient pacient = new PacientImpl("Profile2");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall_Mkab();
        page.fullCard(pacient, testName()).transfer_to_depart();
        $(By.xpath("//*[contains(text(),'Детская поликлиника')]")).shouldBe(Condition.visible);
        sleep(1000);
        $(By.xpath("//*[contains(text(),'Взрослая поликлиника')]")).shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "Кнопка передать задизеблина если не выбрано подразделение")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testDisabledPassBtn() {
        IPacient pacient = new PacientImpl("Profile0");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome()
                .calldoctorAdminTemnikov();
        page.createCall(pacient)
                .createCall();
        page.fullCard(pacient, testName())
                .transfer_to_depart();
        visible("Передать");
        $x("//*[contains(text(),'Передать')]")
                .$x("./..")
//                .$x(".//div[@ng-reflect-disabled='true']")
                .shouldBe(Condition.disabled);
    }

    // TODO: 11/8/2019 сделать тест проверки что кнопка передать задизеблина если не выбрано куда передавать
}