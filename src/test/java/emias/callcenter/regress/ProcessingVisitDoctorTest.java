package emias.callcenter.regress;

import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import pages.calldoctor2.profiles_interfaces.Pacient;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;


public class ProcessingVisitDoctorTest extends TestBase {

    @org.testng.annotations.Test(groups = "VD", description = "Запись на прием к врачу")
    @Epic("Запись на прием")
    @RetryCountIfFailed(2)
    public void testVisitDoctor() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0");
        page.loginPage().callCenter();
        page.recordDoctorPage().visitDoctorAssertTalon(pacient);
    }

    @org.testng.annotations.Test(groups = "VD", description = "Запись на прием к врачу")
    @Epic("Запись на прием")
    @RetryCountIfFailed(2)
    public void testRewritableVisitDoctor() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0");
        page.loginPage().callCenter();
        page.recordDoctorPage().visitDoctorRewritable(pacient);
    }

    @org.testng.annotations.Test(groups = "VD", description = "Запись на прием к врачу")
    @Epic("Запись на прием")
    @RetryCountIfFailed(2)
    public void testDeleteVisitDoctor() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0");
        page.loginPage().callCenter();
        page.recordDoctorPage().deleteVisitDoctor(pacient);
    }

}

// TODO: 18.08.2018 сделать пару тестов для проверки кладра (выписать адреса с которыми было много проблем)
// TODO: 29.08.2018 делать проверку на время создания вызова
// TODO: 29.08.2018 сделать тест добавление адреса в адресное пространство