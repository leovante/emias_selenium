package emias.calldoctor.regress;

import emias.AbstractTestGrid;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;
import pages.calldoctor.profiles_interfaces.Pacient;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;

public class CancelCallTest extends AbstractTestGrid {


    @Test(groups = "CD", description = "отмена вызова на странице подробной карты")
    @Epic("Отмена вызова")
    @RetryCountIfFailed(2)
    public void testCancelCallFrom_Registr() throws InterruptedException, IOException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile1");
        enter.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage(testName()).cancelOnFullCardBtn();
        page.dashboardPage()
                .searchFilterFio_Fam(pacient)
                .verifyRecordIsCancelFromDashboard(pacient);
    }

    @Test(groups = "CD", description = "отмена вызова на странице редактирования")
    @Epic("Отмена вызова")
    @RetryCountIfFailed(2)
    public void testCancelEmpyCallFrom_Registr() throws InterruptedException, IOException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile1");
        enter.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage(testName())
                .editCallBtn()
                .cancelOnChangePageBtn();
        page.dashboardPage()
                .searchFilterFio_Fam(pacient)
                .verifyRecordIsCancelFromDashboard(pacient);
    }

    @Test(groups = "CD", description = "отмена вызова на дашборде")
    @Epic("Отмена вызова")
    @RetryCountIfFailed(2)
    public void testCancelCallFrom_DashBoard() throws InterruptedException, IOException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile1");
        enter.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage(testName()).closeCardBtn();
        page.dashboardPage()
                .searchFilterFio_Fam(pacient)
                .deleteNewCallProgressFrame(pacient)
                .verifyRecordIsCancelFromDashboard(pacient);
    }
}