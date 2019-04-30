package emias.callcenter.regress;

import com.pages.calldoctor2.profiles_interfaces.Pacient;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;

import java.io.IOException;
import java.text.ParseException;


public class FindPatientTest extends TestBase {

    @org.testng.annotations.Test(groups = "СС", description = "Поиск по полису")
    @Epic("Поиск пациента")
    @RetryCountIfFailed(2)
    public void testFindByPolis() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0");
        page.loginPage().callCenter();
        page.findPatientPage().findByPolis(pacient);
    }

    @org.testng.annotations.Test(groups = "СС", description = "Поиск по ФИО")
    @Epic("Поиск пациента")
    @RetryCountIfFailed(2)
    public void testFindByFio() throws Exception {
        Pacient pacient = new Pacient("Profile0");
        page.loginPage().callCenter();
        page.findPatientPage().findByFio(pacient);
    }
}