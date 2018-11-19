package emias.calldoctor.regress;

import emias.AbstractTestGrid;
import utilities.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.calldoctor.doctors_interfaces.Doctor;
import pages.calldoctor.profiles_interfaces.Pacient;

public class CompleteServiceTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "завершить обслуживание вызова")
    @Epic("Завершить обслуживание")
    @RetryCountIfFailed(3)
    public void testCompleteCallRegistr() throws Exception {
        Pacient pacient = new Pacient("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor(doctor);
        page.fullCardPage()
                .completeServiceBtn()
                .verifyDoneCall(pacient, doctor)
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .verifyDoneDocGroup(pacient, doctor);
    }
    // TODO: 13.08.2018 завершить обслуживание в мис
}