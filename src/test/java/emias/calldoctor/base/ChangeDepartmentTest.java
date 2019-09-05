package emias.calldoctor.base;

import com.codeborne.selenide.Condition;
import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.PacientImpl;
import com.utils.except.NoticeException;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.$;

public class ChangeDepartmentTest extends TestBase {
    @Test(groups = {"CD", "test"}, description = "передача вызова из Юр лица в подразделение")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testTransferCallLpu_Depart() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("ProfileTransferLpu-Dep");
        Doctor doctor = new Doctor("TemnikovStend");
        Doctor doctor2 = new Doctor("YudinaVzroslayaTerapev");
        page.misHome().calldoctor();
        page.createCall(pacientImpl)
                .createCall()
                .saveBtn()
                .allertBtn();
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
    public void testTransferCallDepart_Depart() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("ProfileTransferDep-Dep");
        Doctor doctor = new Doctor("TemnikovStend");
        Doctor doctor2 = new Doctor("ZaycevaDetskayaOftalmol");
        Doctor doctor3 = new Doctor("YudinaVzroslayaTerapev");
        page.misHome().calldoctor();
        page.createCall(pacientImpl)
                .createCall()
                .saveBtn()
                .allertBtn();
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
    public void testTransferCallDepart_Lpu() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("ProfileTransferDep-Lpu");
        Doctor dep_doc = new Doctor("TemnikovVzroslayaTerapev");
        Doctor lpu_doc = new Doctor("TemnikovStend");
        page.misHome().calldoctorVzroslaya();
        page.createCall(pacientImpl)
                .createCall()
                .saveBtn()
                .allertBtn();
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
    public void testTransferCallLpu_Lpu() throws IOException, JSONException, ParseException, InterruptedException, NoticeException {
        PacientImpl pacient = new PacientImpl("ProfileTransferLpu-Dep");
        Doctor doctor = new Doctor("TemnikovStend");
        Doctor doctor2 = new Doctor("TemnikovHimkiStend");
        page.misHome().calldoctor();
        page.createCall(pacient)
                .createCall()
                .saveBtn()
                .allertBtn();
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

    @Test(groups = "CD", description = "проверить что на странице передачи в другое подр. у взрослого вызова отображается взрослое и не отображается детское")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testshowMeYourAdultPoliklinika() throws Exception {
        PacientImpl pacient = new PacientImpl("ProfileTransferDep-Lpu");
        page.misHome().calldoctor();
        page.createCall(pacient)
                .createCall()
                .saveBtn()
                .allertBtn();
        page.fullCard(pacient, testName())
                .transfer_to_depart();
        page.passLpu()
                .validate_view_to_adult();
    }

    @Test(groups = "CD", description = "проверить что на странице передачи в другое лпу у детского вызова не отображается взрослая поликлиника и наоборот")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testshowMeYourKidPoliklinika() throws Exception {
        PacientImpl pacient = new PacientImpl("Profile2");
        page.misHome().calldoctor();
        page.createCall(pacient)
                .createCall_Mkab()
                .saveBtn();
        page.fullCard(pacient, testName())
                .transfer_to_depart();
        $(By.xpath("//*[contains(text(),'Детская поликлиника')]")).shouldBe(Condition.visible);
        Thread.sleep(1000);
        $(By.xpath("//*[contains(text(),'Взрослая поликлиника')]")).shouldNotBe(Condition.visible);
    }
}