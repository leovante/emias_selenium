package emias.calldoctor.base;


import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.PacientImpl;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class ChangeDoctorTest extends TestBase {

    @Test(groups = "CD", description = "передать вызов другому врачу")
    @Epic("Передача вызова")
    @RetryCountIfFailed(2)
    public void testSendCallToSecondDoctor_Registr() throws Exception {
        PacientImpl pacientImpl = new PacientImpl("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        Doctor doctor2 = new Doctor("NemcovaVzroslRegistratura");
        page.misHome().calldoctor();
        page.createCall(pacientImpl)
                .createCall()
                .saveBtn();
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor);
        page.fullCard(pacientImpl, testName()).changeDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor2);
        page.fullCard(pacientImpl, testName())
                .verifyActivCall(pacientImpl)
                .verifyDoctor(doctor2)
                .closeCardBtn();
        page.dashboard()
                .clearAllFilters()
                .verifyActiveDocGroup(pacientImpl, doctor2);
    }
}