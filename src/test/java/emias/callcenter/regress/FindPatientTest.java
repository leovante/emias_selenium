package emias.callcenter.regress;

import com.datas.calldoctor.PacientImpl;
import com.commons.retryCountListner.RetryCountIfFailed;
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
        PacientImpl pacientImpl = new PacientImpl("Profile0");
        page.misHome().callCenter();
        page.findPatientPage().findByPolis(pacientImpl);
    }

    @org.testng.annotations.Test(groups = "СС", description = "Поиск по ФИО")
    @Epic("Поиск пациента")
    @RetryCountIfFailed(2)
    public void testFindByFio() throws Exception {
        PacientImpl pacientImpl = new PacientImpl("Profile0");
        page.misHome().callCenter();
        page.findPatientPage().findByFio(pacientImpl);
    }
}