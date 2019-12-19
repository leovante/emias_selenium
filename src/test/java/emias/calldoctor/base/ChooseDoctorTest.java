package emias.calldoctor.base;

import com.commons.assistance.DuringTestHelper;
import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.IPacient;
import com.datas.calldoctor.PacientImpl;
import emias.TestCallDoctorBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class ChooseDoctorTest extends TestCallDoctorBase {

    @Test(groups = "CD", description = "вызов из регистратуры. назначить врача на сегодня")
    @Epic("Назначить врача")
    @RetryCountIfFailed(2)
    public void testAppendDoctorToCall_Registr() {
        IPacient pacient = new PacientImpl("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor);
        page.fullCard(pacient, testName())
                .verifyActivCall(pacient)
                .closeCardBtn();
        page.dashboard()
                .clearFilterDepart()
                .verifyActiveDocGroup(pacient, doctor);
    }

    @Test(groups = "CD", description = "вызов из СМП. назначить врача на сегодня")
    @Epic("Назначить врача")
    @RetryCountIfFailed(2)
    public void testAppendDoctorToCall_SMP() {
        IPacient pacient = new PacientImpl("Profile2");
        Doctor doctor = new Doctor("NemcovaVzroslRegistratura");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor);
        page.fullCard(pacient, testName())
                .verifyActivCall(pacient)
                .closeCardBtn();
        page.dashboard()
                .clearFilterDepart()
//                .searchFilterDoctor(doctor)
                .verifyActiveDocGroup(pacient, doctor);
    }

    @Test(groups = "CD", description = "назначить участкового врача на сегодня")
    @Epic("Назначить врача")
    @RetryCountIfFailed(2)
    public void testAppendUchastkoviyDoctor() {
        IPacient pacient = new PacientImpl("Profile2");
        Doctor doctor = new Doctor("NemcovaVzroslRegistratura");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor);
        page.fullCard(pacient, testName())
                .verifyActivCall(pacient)
                .closeCardBtn();
        page.dashboard()
                .clearFilterDepart()
//                .searchFilterDoctor(doctor)
                .verifyActiveDocGroup(pacient, doctor);
    }
}