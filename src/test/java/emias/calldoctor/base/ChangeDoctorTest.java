package emias.calldoctor.base;


import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientImpl;
import com.utils.assistance.DuringTestHelper;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class ChangeDoctorTest extends TestBase {

    @Test(groups = "CD", description = "передать вызов другому врачу")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testSendCallToSecondDoctor_Registr() {
        Pacient pacient = new PacientImpl("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        Doctor doctor2 = new Doctor("NemcovaVzroslRegistratura");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor);
        page.fullCard(pacient, testName()).changeDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor2);
        page.fullCard(pacient, testName())
                .verifyActivCall(pacient)
                .verifyDoctor(doctor2)
                .closeCardBtn();
        page.dashboard()
                .clearFilterDepart()
                .verifyActiveDocGroup(pacient, doctor2);
    }
}