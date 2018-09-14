package emias.calldoctor.regress;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

import java.io.IOException;

public class CancelCallTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "отмена вызова на странице подробной карты")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCancelCallFrom_Registr() throws InterruptedException, IOException {
        beforecdCD.loginMis_Calldoctor();
        String nameGen = String.valueOf(new StringGenerator().generator());

        page.createCallPage().createNewCall("Profile1", nameGen, "n");
        page.fullCardPage().cancelCallOnFullCardPage();
        page.dashboardPage()
                .searchFilterFio(nameGen)
                .verifyRecordIsCancelFromDashboard();
    }

    @Test(groups = "CD", description = "отмена вызова на странице редактирования")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCancelEmpyCallFrom_Registr() throws InterruptedException, IOException {
        beforecdCD.loginMis_Calldoctor();
        String nameGen = String.valueOf(new StringGenerator().generator());

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