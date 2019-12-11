package emias.callcenter.regress;

import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.calldoctor.PacientImpl;
import com.testRunner.TestNGBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;


public class ProcessingVisitDoctorTest extends TestNGBase {

    @Test(groups = "VD", description = "Запись на прием к врачу")
    @Epic("Запись на прием")
    @RetryCountIfFailed(2)
    public void testVisitDoctor() throws IOException, InterruptedException, ParseException, JSONException {
        PacientImpl pacientImpl = new PacientImpl("Profile0");
        page.misHome().callCenter();
        page.recordDoctorPage().visitDoctorAssertTalon(pacientImpl);
    }

    @Test(groups = "VD", description = "Запись на прием к врачу")
    @Epic("Запись на прием")
    @RetryCountIfFailed(2)
    public void testRewritableVisitDoctor() throws IOException, InterruptedException, ParseException, JSONException {
        PacientImpl pacientImpl = new PacientImpl("Profile0");
        page.misHome().callCenter();
        page.recordDoctorPage().visitDoctorRewritable(pacientImpl);
    }

    @Test(groups = "VD", description = "Запись на прием к врачу")
    @Epic("Запись на прием")
    @RetryCountIfFailed(2)
    public void testDeleteVisitDoctor() throws IOException, InterruptedException, ParseException, JSONException {
        PacientImpl pacientImpl = new PacientImpl("Profile0");
        page.misHome().callCenter();
        page.recordDoctorPage().deleteVisitDoctor(pacientImpl);
    }

}