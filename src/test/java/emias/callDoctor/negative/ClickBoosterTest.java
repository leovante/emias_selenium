package emias.callDoctor.negative;

import emias.AbstractTestGrid;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.calldoctor.doctors_interfaces.Doctor;
import pages.calldoctor.profiles_interfaces.Pacient;
import utilities.testngRetryCount.RetryCountIfFailed;

public class ClickBoosterTest extends AbstractTestGrid {

    @Test(groups = "test", description = "закликивание кнопки 'назначить на сегодня' что бы проверить что не создаются дубликаты")
    @Epic("Негативные тесты")
    @RetryCountIfFailed(2)
    public void testAppendDoctorToCall_Portal() throws Exception {
        Pacient pacient = new Pacient("Profile3_Kladr");
        Doctor doctor = new Doctor("MokovStendTestovoe");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall_Api(pacient);
        page.dashboardPage().openNewCallDash(pacient);
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorTodayBooster(doctor);
        // TODO: 12/6/2018 тут нужно как-то прикрутить прокси и запускать тест при слабом интернете
    }
}