package emias.calldoctor.base;

import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientImpl;
import com.utils.except.NoticeException;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class CompleteServiceTest extends TestBase {

    @Test(groups = "CD", description = "завершить обслуживание вызова")
    @Epic("Завершить обслуживание")
    @RetryCountIfFailed(2)
    public void testCompleteCallRegistr() throws Exception {
        Pacient pacient = new PacientImpl("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");

        page.misHome().calldoctor();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor);
        page.fullCard(pacient, testName())
                .completeServiceBtn()
                .verifyDoneCall(doctor)
                .closeCardBtn();
        page.dashboard()
                .clearFilterDepart()
                .verifyPacientNumberInServe(pacient, doctor);
    }


    @Test(groups = "CD", description = "проверка что индикатор МКАБ и ТАП серый")
    @Epic("Проверка иконок МКАБ и ТАП")
    @RetryCountIfFailed(2)
    public void testMkab_TapIconGrey() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor);
        page.fullCard(pacientImpl, testName())
                .completeServiceBtn()
                .verifyMkabIconDisable()
                .verifyTapIconDisable()
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "проверка что индикатор МКАБ красный, а ТАП серый")
    @Epic("Проверка иконок МКАБ и ТАП")
    @RetryCountIfFailed(2)
    public void testMkabIconRed_TapIconGrey() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile2");
        Doctor doctor = new Doctor("NemcovaVzroslRegistratura");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall_Mkab();
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor);
        page.fullCard(pacientImpl, testName())
                .completeServiceBtn()
                .verifyMkabIconEnable()
                .verifyTapIconDisable()
                .closeCardBtn();
    }
}