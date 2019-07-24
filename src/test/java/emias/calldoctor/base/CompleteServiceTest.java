package emias.calldoctor.base;

import com.pages.calldoctor.doctors_interfaces.Doctor;
import com.pages.calldoctor.pacients.PacientImpl;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class CompleteServiceTest extends TestBase {

    @Test(groups = "CD", description = "завершить обслуживание вызова")
    @Epic("Завершить обслуживание")
    @RetryCountIfFailed(2)
    public void testCompleteCallRegistr() throws Exception {
        PacientImpl pacientImpl = new PacientImpl("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        page.misHome().calldoctor();
        page.createCall(pacientImpl)
                .createCall()
                .saveBtn();
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor);
        page.fullCard(pacientImpl, testName())
                .completeServiceBtn()
                .verifyDoneCall(doctor)
                .closeCardBtn();
        page.dashboard()
                .clearAllFilters()
                .verifyDoneDocGroup(pacientImpl, doctor);
    }
    // TODO: 13.08.2018 завершить обслуживание в мис
}