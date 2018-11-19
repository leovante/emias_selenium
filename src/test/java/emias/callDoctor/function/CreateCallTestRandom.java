package emias.callDoctor.function;

import emias.AbstractTestGrid;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;
import pages.calldoctor.doctors_interfaces.Doctor;
import pages.calldoctor.profiles_interfaces.Pacient;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;

public class CreateCallTestRandom extends AbstractTestGrid {

    @Test(groups = "CD", description = "", enabled = false)
    @Epic("Создание рандомного вызова")
    @RetryCountIfFailed(0)
    public void testCall() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage()
                .verifyNewCall(pacient)
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "", enabled = false)
    @Epic("Создание закликивающего вызова")
    @RetryCountIfFailed(0)
    public void testCallMegaClick() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0_1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().megaClickDoctor(doctor);
        page.fullCardPage()
                .verifyNewCall(pacient)
                .closeCardBtn();
    }

    // TODO: 10/23/2018 пока напишу здесь, нуна сделать тест проверки отображения подразделения при наличии расписания и его отсутствии
}

