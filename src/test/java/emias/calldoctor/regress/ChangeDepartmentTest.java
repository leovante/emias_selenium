package emias.calldoctor.regress;

import com.codeborne.selenide.Condition;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.calldoctor.doctors_interfaces.Doctor;
import pages.calldoctor.profiles_interfaces.Pacient;
import utils.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.$;

public class ChangeDepartmentTest extends TestBase {

    @Test(groups = "CD", description = "передача вызова из Юр лица в подразделение")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testTransferCallLpu_Depart() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("ProfileTransferLpu-Dep");
        Doctor doctor = new Doctor("TemnikovStend");
        Doctor doctor2 = new Doctor("ZaycevaDetskayaOftalmol");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall();
        page.fullCardPage(testName())
                .verifyDepartment(doctor)
                .transferToDepartBtn();
        page.setLpuPage().transfer(doctor2);
        page.fullCardPage(testName()).verifyDepartment(doctor2);
    }

    @Test(groups = "CD", description = "передача вызова из подразделения в подразделение")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testTransferCallDepart_Depart() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("ProfileTransferDep-Dep");
        Doctor doctor = new Doctor("TemnikovStend");
        Doctor doctor2 = new Doctor("ZaycevaDetskayaOftalmol");
        Doctor doctor3 = new Doctor("YudinaVzroslayaTerapev");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall();
        page.fullCardPage(testName())
                .verifyDepartment(doctor)
                .transferToDepartBtn();
        page.setLpuPage().transfer(doctor2);
        page.fullCardPage(testName())
                .verifyDepartment(doctor2)
                .transferToDepartBtn();
        page.setLpuPage().transfer(doctor3);
        page.fullCardPage(testName()).verifyDepartment(doctor3);
    }

    @Test(groups = "CD", description = "передача вызова из подр в ЛПУ")
    @Epic("Передача вызова")
    @RetryCountIfFailed(3)
    public void testTransferCallDepart_Lpu() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("ProfileTransferDep-Lpu");
        Doctor doctor = new Doctor("TemnikovStend");
        Doctor doctor2 = new Doctor("ZaycevaDetskayaOftalmol");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall();
        page.fullCardPage(testName())
                .verifyDepartment(doctor)
                .transferToDepartBtn();
        page.setLpuPage().transfer(doctor2);
        page.fullCardPage(testName())
                .verifyDepartment(doctor2)
                .transferToDepartBtn();
        page.setLpuPage().transfer(doctor);
        page.fullCardPage(testName()).verifyDepartment(doctor);
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

    @Test(groups = "CD", description = "проверить что на странице передачи в другое лпу у взрослого вызова не отображается детская поликлиника и наоборот")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testshowMeYourAdultPoliklinika() throws Exception {
        Pacient pacient = new Pacient("ProfileTransferDep-Lpu");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall();
        page.fullCardPage(testName()).transferToDepartBtn();
        $(By.xpath("//*[contains(text(),'Взрослая поликлиника')]")).shouldBe(Condition.visible);
        Thread.sleep(1000);
        $(By.xpath("//*[contains(text(),'Детская поликлиника')]")).shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверить что на странице передачи в другое лпу у детского вызова не отображается взрослая поликлиника и наоборот")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testshowMeYourKidPoliklinika() throws Exception {
        Pacient pacient = new Pacient("Profile2");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall_Mkab();
        page.fullCardPage(testName()).transferToDepartBtn();
        $(By.xpath("//*[contains(text(),'Детская поликлиника')]")).shouldBe(Condition.visible);
        Thread.sleep(1000);
        $(By.xpath("//*[contains(text(),'Взрослая поликлиника')]")).shouldNotBe(Condition.visible);
    }
}