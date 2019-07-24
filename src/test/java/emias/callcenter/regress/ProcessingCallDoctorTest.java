package emias.callcenter.regress;

import com.pages.calldoctor.pacients.PacientImpl;
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
        PacientImpl pacientImpl = new PacientImpl("Profile0");
        page.misHome().callCenter();
        page.callDoctorPage().calldoctor(pacientImpl);
    }

    @Test(groups = "VD", description = "Вызов доктора на дом")
    @Epic("Вызов врача")
    @RetryCountIfFailed(2)
    public void testCallDoctorSMP() throws IOException, InterruptedException, ParseException, JSONException {
        PacientImpl pacientImpl = new PacientImpl("Profile0");
        page.misHome().callCenter();
        page.callDoctorPage().calldoctorSMP(pacientImpl);
    }
}
