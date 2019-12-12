package emias.calldoctor.base;

import com.commons.assistance.DuringTestHelper;
import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientImpl;
import emias.TestCallDoctorBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class CompleteServiceTest extends TestCallDoctorBase {

    @Test(groups = "CD", description = "завершить обслуживание вызова")
    @Epic("Завершить обслуживание")
    @RetryCountIfFailed(2)
    public void testCompleteCallRegistr() {
        Pacient pacient = new PacientImpl("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome()
                .calldoctorAdminTemnikov();
        page.createCall(pacient)
                .createCall();
        page.fullCard(pacient, testName())
                .chooseDoctorBtn();
        page.setDoctor()
                .chooseDoctorToday(doctor);
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
    public void testMkab_TapIconGrey()  {
        Pacient pacient = new PacientImpl("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor);
        page.fullCard(pacient, testName())
                .completeServiceBtn()
                .verifyMkabIconDisable()
                .verifyTapIconDisable()
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "проверка что индикатор МКАБ красный, а ТАП серый")
    @Epic("Проверка иконок МКАБ и ТАП")
    @RetryCountIfFailed(2)
    public void testMkabIconRed_TapIconGrey()  {
        Pacient pacient = new PacientImpl("Profile2");
        Doctor doctor = new Doctor("NemcovaVzroslRegistratura");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall_Mkab();
        page.fullCard(pacient, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor);
        page.fullCard(pacient, testName())
                .completeServiceBtn()
                .verifyMkabIconEnable()
                .verifyTapIconDisable()
                .closeCardBtn();
    }
}