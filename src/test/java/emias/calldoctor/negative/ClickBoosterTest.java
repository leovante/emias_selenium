package emias.calldoctor.negative;

import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;
import pages.calldoctor.doctors_interfaces.Doctor;
import pages.calldoctor.profiles_interfaces.Pacient;
import utils.except.NoticeException;
import utils.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;

public class ClickBoosterTest extends TestBase {

    @Test(groups = "CD", description = "закликивание кнопки 'назначить на сегодня' что бы проверить что не создаются дубликаты")
    @Epic("Негативные тесты")
    @RetryCountIfFailed(2)
    public void testAppendTomorrowClickBooster() throws Exception {
        Pacient pacient = new Pacient("Profile3_Kladr");
        Doctor doctor = new Doctor("MokovStendTestovoe");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall_Api();
        page.dashboardPage().openNewCallDash(pacient);
        page.fullCardPage(testName()).chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorTodayBooster(doctor);
        // TODO: 12/6/2018 тут нужно как-то прикрутить прокси и запускать тест при слабом интернете
    }

    @Test(groups = "CD", description = "закликивание кнопки 'записать' что бы проверить что не создаются дубликаты", enabled = false)
    @Epic("Негативные тесты")
    @RetryCountIfFailed(2)
    public void testZapisatClickBooster() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile0_1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall();
        page.fullCardPage(testName()).chooseDoctorBtn();
        page.setDoctorPage().zapisatClickBooster(doctor);
        page.fullCardPage(testName())
                .verifyNewCall(pacient)
                .closeCardBtn();
    }

    @Test(groups = "test", description = "закликивание кнопки 'записать и добавить' что бы проверить что не создаются дубликаты")
    @Epic("Негативные тесты")
    @RetryCountIfFailed(2)
    public void testZapisatDobavitClickBooster() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0_1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        page.loginPage().calldoctor();
//        page.createCallPage().createCall(pacient);
        page.createCallPage(pacient).createCall_Api();
        page.fullCardPage(testName()).chooseDoctorBtn();
        page.setDoctorPage().zapisatDobavitClickBooster(doctor);
        page.fullCardPage(testName())
                .verifyNewCall(pacient)
                .closeCardBtn();
    }
}