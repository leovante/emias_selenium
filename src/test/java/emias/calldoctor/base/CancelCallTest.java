package emias.calldoctor.base;

import com.pages.calldoctor.pacients.Pacient;
import com.utils.except.NoticeException;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class CancelCallTest extends TestBase {

    @Test(groups = "CD", description = "отмена вызова на странице подробной карты")
    @Epic("Отмена вызова")
    @RetryCountIfFailed(2)
    public void testCancelCallFrom_Registr() throws InterruptedException, IOException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile1");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn();
        page.fullCardPage(pacient, testName()).cancelOnFullCardBtn("отмена автотестом");
        page.dashboardPage()
                .searchFilterFio_Fam(pacient)
                .verifyCallIsCancelFromDashboard(pacient);
    }

    @Test(groups = "CD", description = "отмена вызова на странице редактирования")
    @Epic("Отмена вызова")
    @RetryCountIfFailed(2)
    public void testCancelEmpyCallFrom_Registr() throws InterruptedException, IOException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile1");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn();
        page.fullCardPage(pacient, testName())
                .editCallBtn()
                .cancelOnChangePageBtn();
        page.dashboardPage()
                .searchFilterFio_Fam(pacient)
                .verifyCallIsCancelFromDashboard(pacient);
    }

    @Test(groups = "CD", description = "отмена вызова на дашборде")
    @Epic("Отмена вызова")
    @RetryCountIfFailed(2)
    public void testCancelCallFrom_DashBoard() throws InterruptedException, IOException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile1");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn();
        page.fullCardPage(pacient, testName()).closeCardBtn();
        page.dashboardPage()
                .searchFilterFio_Fam(pacient)
                .deleteNewCallProgressFrame(pacient)
                .verifyCallIsCancelFromDashboard(pacient);
    }
}