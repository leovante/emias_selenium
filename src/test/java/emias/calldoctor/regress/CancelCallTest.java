package emias.calldoctor.regress;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

import java.io.IOException;

public class CancelCallTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "отмена вызова на странице подробной карты")
    @Epic("Отмена вызова")
    @RetryCountIfFailed(2)
    public void testCancelCallFrom_Registr() throws InterruptedException, IOException {
        String nameGen = new StringGenerator().generator();
        beforecdCD.loginMis_Calldoctor();

        page.createCallPage().createNewCall("Profile1", nameGen, "n");
        page.fullCardPage().cancelCallOnFullCardPage();
        page.dashboardPage()
                .searchFilterFio(nameGen)
                .verifyRecordIsCancelFromDashboard();
    }

    @Test(groups = "CD", description = "отмена вызова на странице редактирования")
    @Epic("Отмена вызова")
    @RetryCountIfFailed(2)
    public void testCancelEmpyCallFrom_Registr() throws InterruptedException, IOException {
        String nameGen = new StringGenerator().generator();
        beforecdCD.loginMis_Calldoctor();

        page.createCallPage().createNewCall("Profile1", nameGen, "n");
        page.fullCardPage()
                .editCallBtn()
                .cancelRecordOnChangePage();
        page.dashboardPage()
                .searchFilterFio(nameGen)
                .verifyRecordIsCancelFromDashboard();
    }

    // TODO: 13.08.2018 отмена вызова на дашборде
    // TODO: 13.08.2018 отмена вызова в мис
}