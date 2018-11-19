package emias.callCenter.regress;

import emias.AbstractTestGrid;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;
import pages.calldoctor.profiles_interfaces.Pacient;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;


public class ProcessingCallDoctorTest extends AbstractTestGrid {

    @Test(groups = "VD", description = "Вызов доктора на дом")
    @Epic("Вызов врача")
    @RetryCountIfFailed(2)
    public void testCallDoctorMKAB() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0");
        enterSite.enterCallCenter();
        page.callDoctorPage().calldoctor(pacient);
    }

    @Test(groups = "VD", description = "Вызов доктора на дом")
    @Epic("Вызов врача")
    @RetryCountIfFailed(2)
    public void testCallDoctorSMP() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0");
        enterSite.enterCallCenter();
        page.callDoctorPage().calldoctorSMP(pacient);
    }
}
