package emias.callcenter.regress;

import com.pages.calldoctor.pacients.PacientImpl;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;


public class ProcessingVisitDoctorTest extends TestBase {

    @Test(groups = "VD", description = "Запись на прием к врачу")
    @Epic("Запись на прием")
    @RetryCountIfFailed(2)
    public void testVisitDoctor() throws IOException, InterruptedException, ParseException, JSONException {
        PacientImpl pacientImpl = new PacientImpl("Profile0");
        page.misHomePage().callCenter();
        page.recordDoctorPage().visitDoctorAssertTalon(pacientImpl);
    }

    @Test(groups = "VD", description = "Запись на прием к врачу")
    @Epic("Запись на прием")
    @RetryCountIfFailed(2)
    public void testRewritableVisitDoctor() throws IOException, InterruptedException, ParseException, JSONException {
        PacientImpl pacientImpl = new PacientImpl("Profile0");
        page.misHomePage().callCenter();
        page.recordDoctorPage().visitDoctorRewritable(pacientImpl);
    }

    @Test(groups = "VD", description = "Запись на прием к врачу")
    @Epic("Запись на прием")
    @RetryCountIfFailed(2)
    public void testDeleteVisitDoctor() throws IOException, InterruptedException, ParseException, JSONException {
        PacientImpl pacientImpl = new PacientImpl("Profile0");
        page.misHomePage().callCenter();
        page.recordDoctorPage().deleteVisitDoctor(pacientImpl);
    }

}

// TODO: 18.08.2018 сделать пару тестов для проверки кладра (выписать адреса с которыми было много проблем)
// TODO: 29.08.2018 делать проверку на время создания вызова
// TODO: 29.08.2018 сделать тест добавление адреса в адресное пространство