package emias.callDoctor.negative;

import emias.AbstractTestGrid;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;
import pages.calldoctor.doctors_interfaces.Doctor;
import pages.calldoctor.profiles_interfaces.Pacient;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;

public class ClickBoosterTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "закликивание кнопки 'назначить на сегодня' что бы проверить что не создаются дубликаты")
    @Epic("Негативные тесты")
    @RetryCountIfFailed(2)
    public void testAppendTomorrowClickBooster() throws Exception {
        Pacient pacient = new Pacient("Profile3_Kladr");
        Doctor doctor = new Doctor("MokovStendTestovoe");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall_Api(pacient);
        page.dashboardPage().openNewCallDash(pacient);
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorTodayBooster(doctor);
        // TODO: 12/6/2018 тут нужно как-то прикрутить прокси и запускать тест при слабом интернете
    }

    @Test(groups = "CD", description = "закликивание кнопки 'записать' что бы проверить что не создаются дубликаты", enabled = false)
    @Epic("Негативные тесты")
    @RetryCountIfFailed(2)
    public void testZapisatClickBooster() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0_1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().zapisatClickBooster(doctor);
        page.fullCardPage()
                .verifyNewCall(pacient)
                .closeCardBtn();
    }

    @Test(groups = "test", description = "закликивание кнопки 'записать и добавить' что бы проверить что не создаются дубликаты")
    @Epic("Негативные тесты")
    @RetryCountIfFailed(2)
    public void testZapisatDobavitClickBooster() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0_1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        enterSite.enterCalldoctorFromMis();
//        page.createCallPage().createCall(pacient);
        page.createCallPage().createCall_Api(pacient);
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().zapisatDobavitClickBooster(doctor);
        page.fullCardPage()
                .verifyNewCall(pacient)
                .closeCardBtn();
    }
}