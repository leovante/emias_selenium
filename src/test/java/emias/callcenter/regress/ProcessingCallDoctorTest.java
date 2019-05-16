package emias.callcenter.regress;

import com.pages.calldoctor.pacients.Pacient;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;


public class ProcessingCallDoctorTest extends TestBase {

    @Test(groups = "VD", description = "Вызов доктора на дом")
    @Epic("Вызов врача")
    @RetryCountIfFailed(2)
    public void testCallDoctorMKAB() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0");
        page.loginPage().callCenter();
        page.callDoctorPage().calldoctor(pacient);
    }

    @Test(groups = "VD", description = "Вызов доктора на дом")
    @Epic("Вызов врача")
    @RetryCountIfFailed(2)
    public void testCallDoctorSMP() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0");
        page.loginPage().callCenter();
        page.callDoctorPage().calldoctorSMP(pacient);
    }
}
