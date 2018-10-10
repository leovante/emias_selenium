package emias.calldoctor.regress;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

public class EditPageTest extends AbstractTestGrid {

    @Test(groups = "test", description = "проверка страницы редактирвоания карты вызова")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testVerifyEditPageProfile1() throws Exception {
        String nameGen = new StringGenerator().generator();
        beforecdCD.loginMis_Calldoctor();
        page.createCallPage().createNewCall("Profile1", nameGen, "n");
        page.createCallPage()
                .editCallBtn()
                .verifyCallProfile1("Profile1", nameGen);
    }

    @Test(groups = "test", description = "изменить карту вызова из регистратуры")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testEditCallProfile1() throws Exception {
        String nameGen = new StringGenerator().generator();
        beforecdCD.loginMis_Calldoctor();
        page.createCallPage().createNewCall("Profile1", nameGen, "n");
        page.createCallPage()
                .editCallBtn()
                .setDeafult()
                .editCallProfile2("Profile2", nameGen);
        page.fullCardPage()
                .verifyCallNewCallGroup("Profile2", nameGen)
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
//                .searchFilterFio(nameGen)
                .verifyNewCallGroup("Profile2");
    }
}