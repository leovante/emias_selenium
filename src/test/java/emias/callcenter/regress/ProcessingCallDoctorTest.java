package emias.callcenter.regress;

import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.calldoctor.PacientImpl;
import com.testRunner.TestNGBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;


public class ProcessingCallDoctorTest extends TestNGBase {

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
