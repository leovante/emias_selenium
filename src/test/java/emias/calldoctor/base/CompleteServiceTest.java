package emias.calldoctor.base;

import com.pages.calldoctor.doctors_interfaces.Doctor;
import com.pages.calldoctor.pacients.Pacient;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class CompleteServiceTest extends TestBase {

    @Test(groups = "CD", description = "завершить обслуживание вызова")
    @Epic("Завершить обслуживание")
    @RetryCountIfFailed(3)
    public void testCompleteCallRegistr() throws Exception {
        Pacient pacient = new Pacient("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn();
        page.fullCardPage(pacient, testName()).chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorToday(doctor);
        page.fullCardPage(pacient, testName())
                .completeServiceBtn()
                .verifyDoneCall(doctor)
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .verifyDoneDocGroup(pacient, doctor);
    }
    // TODO: 13.08.2018 завершить обслуживание в мис
}