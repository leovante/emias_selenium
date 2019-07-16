package emias.calldoctor.negative;

import com.pages.calldoctor.doctors_interfaces.Doctor;
import com.pages.calldoctor.pacients.PacientImpl;
import com.utils.except.NoticeException;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.hibernate.AssertionFailure;
import org.json.JSONException;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

//@Ignore
public class ClickBoosterTest extends TestBase {

    @Test(groups = "test", description = "закликивание кнопки 'назначить на сегодня' что бы проверить что не создаются дубликаты", enabled = false)
    @Epic("Негативные тесты")
    @RetryCountIfFailed(2)
    public void testAppendTomorrowClickBooster() throws Exception {
        PacientImpl pacientImpl = new PacientImpl("Profile3_Kladr");
        Doctor doctor = new Doctor("MokovStendTestovoe");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl).createCall_Api();
        page.dashboardPage().openNewCallDash(pacientImpl);
        page.fullCardPage(pacientImpl, testName()).chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorTodayBooster(doctor);
        //нет проверки и зависает
        throw new AssertionFailure("сделай нормальную проверку");
        // TODO: 12/6/2018 тут нужно как-то прикрутить прокси и запускать тест при слабом интернете
    }

    @Test(groups = "test", description = "закликивание кнопки 'записать' что бы проверить что не создаются дубликаты", enabled = false)
    @Epic("Негативные тесты")
    @RetryCountIfFailed(2)
    public void testZapisatClickBooster() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile0_1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl).createCall();
        page.fullCardPage(pacientImpl, testName()).chooseDoctorBtn();
        page.setDoctorPage().zapisatClickBooster(doctor);
        page.fullCardPage(pacientImpl, testName())
                .verifyNewCall()
                .closeCardBtn();
        throw new AssertionFailure("сделай нормальную проверку");
    }

    @Test(groups = "test", description = "закликивание кнопки 'записать и добавить' что бы проверить что не создаются дубликаты", enabled = false)
    @Epic("Негативные тесты")
    @RetryCountIfFailed(2)
    public void testZapisatDobavitClickBooster() throws IOException, InterruptedException, ParseException, JSONException {
        PacientImpl pacientImpl = new PacientImpl("Profile0_1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        page.misHomePage().calldoctor();
//        page.createCallPage().createCall(pacient);
        page.createCallPage(pacientImpl).createCall_Api();
        page.fullCardPage(pacientImpl, testName()).chooseDoctorBtn();
        page.setDoctorPage().zapisatDobavitClickBooster(doctor);
        page.fullCardPage(pacientImpl, testName())
                .verifyNewCall()
                .closeCardBtn();
        throw new AssertionFailure("сделай нормальную проверку");
    }
}