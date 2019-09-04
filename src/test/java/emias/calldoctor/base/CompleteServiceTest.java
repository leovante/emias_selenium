package emias.calldoctor.base;

import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientImpl;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class CompleteServiceTest extends TestBase {

    @Test(groups = "CD", description = "завершить обслуживание вызова")
    @Epic("Завершить обслуживание")
    @RetryCountIfFailed(2)
    public void testCompleteCallRegistr() throws Exception {
        Pacient pacient = new PacientImpl("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");

        page.misHome().calldoctor();
        page.createCall(pacient)
                .createCall()
                .saveBtn();
        page.fullCard(pacient, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor);
        page.fullCard(pacient, testName())
                .completeServiceBtn()
                .verifyDoneCall(doctor)
                .closeCardBtn();
        page.dashboard()
                .clearAllFilters()
                .verifyDoneDocGroup(pacient, doctor);
    }
}