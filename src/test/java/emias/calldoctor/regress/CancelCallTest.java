package emias.calldoctor.regress;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

import java.io.IOException;
import java.text.ParseException;

public class CancelCallTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "отмена вызова на странице подробной карты")
    @Epic("Отмена вызова")
    @RetryCountIfFailed(2)
    public void testCancelCallFrom_Registr() throws InterruptedException, IOException, ParseException {
        String nameGen = new StringGenerator().generator();
        enterSite.enterCalldoctor();

        page.createCallPage().createCall("Profile1");
        page.fullCardPage().cancelOnFullCardBtn();
        page.dashboardPage()
                .searchFilterFio(nameGen)
                .verifyRecordIsCancelFromDashboard();
    }

    @Test(groups = "CD", description = "отмена вызова на странице редактирования")
    @Epic("Отмена вызова")
    @RetryCountIfFailed(2)
    public void testCancelEmpyCallFrom_Registr() throws InterruptedException, IOException, ParseException {
        String nameGen = new StringGenerator().generator();
        enterSite.enterCalldoctor();

        page.createCallPage().createCall("Profile1");
        page.fullCardPage()
                .editCallBtn()
                .cancelOnChangePageBtn();
        page.dashboardPage()
                .searchFilterFio(nameGen)
                .verifyRecordIsCancelFromDashboard();
    }

    @Test(groups = "CD", description = "отмена вызова на странице подробной карты")
    @Epic("Отмена вызова")
    @RetryCountIfFailed(2)
    public void testCancelCallFrom_DashBoard() throws InterruptedException, IOException, ParseException {
        String nameGen = new StringGenerator().generator();
        enterSite.enterCalldoctor();
        page.createCallPage().createCall("Profile1");
        page.fullCardPage().closeCardBtn();
        page.dashboardPage().deleteNewCallProgressFrame("Profile1");
        page.dashboardPage()
                .searchFilterFio(nameGen)
                .verifyRecordIsCancelFromDashboard();
    }
    // TODO: 13.08.2018 отмена вызова в мис
}