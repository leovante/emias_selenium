package emias.callDoctor.regress;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import io.qameta.allure.Epic;
import io.qameta.allure.Flaky;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.calldoctor.doctors_interfaces.Doctor;
import pages.calldoctor.profiles_interfaces.Pacient;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.$;

public class ChangeDepartmentTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "передача вызова из Юр лица в подразделение")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testTransferCallLpu_Depart() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("ProfileTransferLpu-Dep");
        Doctor doctor = new Doctor("TemnikovStend");
        Doctor doctor2 = new Doctor("ZaycevaDetskayaOftalmol");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage()
                .verifyDepartment(doctor)
                .transferToDepartBtn();
        page.setLpuPage().transfer(doctor2);
        page.fullCardPage().verifyDepartment(doctor2);
    }

    @Test(groups = "CD", description = "передача вызова из подразделения в подразделение")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testTransferCallDepart_Depart() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("ProfileTransferDep-Dep");
        Doctor doctor = new Doctor("TemnikovStend");
        Doctor doctor2 = new Doctor("ZaycevaDetskayaOftalmol");
        Doctor doctor3 = new Doctor("YudinaVzroslayaTerapev");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage()
                .verifyDepartment(doctor)
                .transferToDepartBtn();
        page.setLpuPage().transfer(doctor2);
        page.fullCardPage()
                .verifyDepartment(doctor2)
                .transferToDepartBtn();
        page.setLpuPage().transfer(doctor3);
        page.fullCardPage().verifyDepartment(doctor3);
    }

    @Test(groups = "CD", description = "передача вызова из подр в ЛПУ")
    @Epic("Передача вызова")
    @RetryCountIfFailed(3)
    public void testTransferCallDepart_Lpu() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("ProfileTransferDep-Lpu");
        Doctor doctor = new Doctor("TemnikovStend");
        Doctor doctor2 = new Doctor("ZaycevaDetskayaOftalmol");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage()
                .verifyDepartment(doctor)
                .transferToDepartBtn();
        page.setLpuPage().transfer(doctor2);
        page.fullCardPage()
                .verifyDepartment(doctor2)
                .transferToDepartBtn();
        page.setLpuPage().transfer(doctor);
        page.fullCardPage().verifyDepartment(doctor);
    }

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

    @Flaky
    @Test(groups = "CD", description = "проверить что на странице передачи в другое лпу у взрослого вызова не отображается детская поликлиника и наоборот")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testshowMeYourAdultPoliklinika() throws Exception {
        Pacient pacient = new Pacient("ProfileTransferDep-Lpu");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().transferToDepartBtn();
        $(By.xpath("//*[contains(text(),'Взрослая поликлиника')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Детская поликлиника')]")).shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверить что на странице передачи в другое лпу у детского вызова не отображается взрослая поликлиника и наоборот")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testshowMeYourKidPoliklinika() throws Exception {
        Pacient pacient = new Pacient("Profile2");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall_Mkab(pacient);
        page.fullCardPage().transferToDepartBtn();
        $(By.xpath("//*[contains(text(),'Взрослая поликлиника')]")).shouldNotBe(Condition.visible);
    }
    // TODO: 13.08.2018 передать вызов из первого ЛПУ в др. ЛПУ
}