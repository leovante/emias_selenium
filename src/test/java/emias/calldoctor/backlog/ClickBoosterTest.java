package emias.calldoctor.backlog;

import com.commons.except.NoticeException;
import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.PacientImpl;
import com.testRunner.TestNGBase;
import io.qameta.allure.Epic;
import org.hibernate.AssertionFailure;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class ClickBoosterTest extends TestNGBase {

    @Test(groups = "test", description = "закликивание кнопки 'назначить на сегодня' что бы проверить что не создаются дубликаты", enabled = false)
    @Epic("Негативные тесты")
    @RetryCountIfFailed(0)
    public void testAppendTomorrowClickBooster() throws Exception {
        PacientImpl pacientImpl = new PacientImpl("Profile3_Kladr");
        Doctor doctor = new Doctor("MokovStendTestovoe");
        IPage.misHome().calldoctorAdminTemnikov();
        IPage.createCall(pacientImpl).createCall_Api();
        IPage.dashboard().openNewCallDash(pacientImpl);
        IPage.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        IPage.setDoctor().chooseDoctorTodayBooster(doctor);
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
        IPage.misHome().calldoctorAdminTemnikov();
        IPage.createCall(pacientImpl).createCall();
        IPage.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        IPage.setDoctor().zapisatClickBooster(doctor);
        IPage.fullCard(pacientImpl, testName())
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
        IPage.misHome().calldoctorAdminTemnikov();
//        page.createCall().createCall(pacient);
        IPage.createCall(pacientImpl).createCall_Api();
        IPage.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        IPage.setDoctor().zapisatDobavitClickBooster(doctor);
        IPage.fullCard(pacientImpl, testName())
                .verifyNewCall()
                .closeCardBtn();
        throw new AssertionFailure("сделай нормальную проверку");
    }
}