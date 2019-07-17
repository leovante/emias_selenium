package emias.calldoctor.base;

import com.codeborne.selenide.Condition;
import com.pages.calldoctor.doctors_interfaces.Doctor;
import com.pages.calldoctor.pacients.PacientImpl;
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
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .createCall()
                .saveBtn()
                .allertBtn();
        page.fullCardPage(pacientImpl, testName())
                .verifyDepartment(doctor)
                .transferToDepartBtn();
        page.setLpuPage().transfer(doctor2);
        page.fullCardPage(pacientImpl, testName())
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
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .createCall()
                .saveBtn()
                .allertBtn();
        page.fullCardPage(pacientImpl, testName())
                .verifyDepartment(doctor)
                .transferToDepartBtn();
        page.setLpuPage().transfer(doctor2);
        page.fullCardPage(pacientImpl, testName())
                .verifyDepartment(doctor2)
                .transferToDepartBtn();
        page.setLpuPage().transfer(doctor3);
        page.fullCardPage(pacientImpl, testName()).verifyDepartment(doctor3);
    }

    @Test(groups = "CD", description = "передача вызова из подр в ЛПУ")
    @Epic("Передача вызова")
    @RetryCountIfFailed(3)
    public void testTransferCallDepart_Lpu() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("ProfileTransferDep-Lpu");
        Doctor depDoc = new Doctor("TemnikovVzroslayaTerapev");
        Doctor urDoc = new Doctor("TemnikovStend");
        page.misHomePage().calldoctorVzroslaya();
        page.createCallPage(pacientImpl)
                .createCall()
                .saveBtn()
                .allertBtn();
        page.fullCardPage(pacientImpl, testName())
                .verifyDepartment(depDoc)
                .transferToDepartBtn();
        page.setLpuPage().transfer(urDoc);
        page.fullCardPage(pacientImpl, testName())
                .verifyDepartment(urDoc);
    }

    // TODO: 12/27/2018 сделать тест передачи вызова из лпу в лпу
    @Test(groups = "CD", description = "передача вызова из ЛПУ в ЛПУ")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testTransferCallLpu_Lpu() {
//        open(curUrlCalldoctor);
//        page.createCallPage()
//                .createCall("ProfileTransferDep-Dep", nameGen, "n");
//        page.fullCardPage()
//                .verifyDepartment("firstDepart")
//                .transferToDepartBtn();
//        page.setLpuPage().transfer("ProfileTransferLpu-Dep", "detskayaPol");
//        page.fullCardPage()
//                .verifyDepartment("detskayaPol")
//                .transferToDepartBtn();
//        page.setLpuPage().transfer("ProfileTransferDep-Dep", "firstDepart");
//        page.fullCardPage().verifyDepartment("firstDepart");
    }

    @Test(groups = "CD", description = "проверить что на странице передачи в другое подр. у взрослого вызова отображается взрослое и не отображается детское")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testshowMeYourAdultPoliklinika() throws Exception {
        PacientImpl pacientImpl = new PacientImpl("ProfileTransferDep-Lpu");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .createCall()
                .saveBtn()
                .allertBtn();
        page.fullCardPage(pacientImpl, testName())
                .transferToDepartBtn();
        page.setLpuPage().validateViewToAdult();
    }

    @Test(groups = "CD", description = "проверить что на странице передачи в другое лпу у детского вызова не отображается взрослая поликлиника и наоборот")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testshowMeYourKidPoliklinika() throws Exception {
        PacientImpl pacientImpl = new PacientImpl("Profile2");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .createCall_Mkab()
                .saveBtn();
        page.fullCardPage(pacientImpl, testName()).transferToDepartBtn();
        $(By.xpath("//*[contains(text(),'Детская поликлиника')]")).shouldBe(Condition.visible);
        Thread.sleep(1000);
        $(By.xpath("//*[contains(text(),'Взрослая поликлиника')]")).shouldNotBe(Condition.visible);
    }
}