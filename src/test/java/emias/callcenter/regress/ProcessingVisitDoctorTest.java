package emias.callcenter.regress;

import emias.AbstractTestGrid;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;
import pages.calldoctor.profiles_interfaces.Pacient;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;


public class ProcessingVisitDoctorTest extends AbstractTestGrid {

    @Test(groups = "VD", description = "Запись на прием к врачу")
    @Epic("Запись на прием")
    @RetryCountIfFailed(2)
    public void testVisitDoctor() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0");
        enter.enterCallCenter();
        page.recordDoctorPage().visitDoctorAssertTalon(pacient);
    }

    @Test(groups = "VD", description = "Запись на прием к врачу")
    @Epic("Запись на прием")
    @RetryCountIfFailed(2)
    public void testRewritableVisitDoctor() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0");
        enter.enterCallCenter();
        page.recordDoctorPage().visitDoctorRewritable(pacient);
    }

    @Test(groups = "VD", description = "Запись на прием к врачу")
    @Epic("Запись на прием")
    @RetryCountIfFailed(2)
    public void testDeleteVisitDoctor() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0");
        enter.enterCallCenter();
        page.recordDoctorPage().deleteVisitDoctor(pacient);
    }

}

// TODO: 18.08.2018 сделать пару тестов для проверки кладра (выписать адреса с которыми было много проблем)
// TODO: 29.08.2018 делать проверку на время создания вызова
// TODO: 29.08.2018 сделать тест добавление адреса в адресное пространство