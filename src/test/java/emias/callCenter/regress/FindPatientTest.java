package emias.callCenter.regress;

import emias.AbstractTestGrid;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;
import pages.calldoctor.profiles_interfaces.Pacient;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;


public class FindPatientTest extends AbstractTestGrid {

    @Test(groups = "СС", description = "Поиск по полису")
    @Epic("Поиск пациента")
    @RetryCountIfFailed(2)
    public void testFindByPolis() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0");
        enterSite.enterCallCenter();
        page.findPatientPage().findByPolis(pacient);
    }

    @Test(groups = "СС", description = "Поиск по ФИО")
    @Epic("Поиск пациента")
    @RetryCountIfFailed(2)
    public void testFindByFio() throws Exception {
        Pacient pacient = new Pacient("Profile0");
        enterSite.enterCallCenter();
        page.findPatientPage().findByFio(pacient);
    }
}