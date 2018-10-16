package emias.calldoctor.regress;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.calldoctor.profiles_interfaces.Pacient;

public class EditPageTest extends AbstractTestGrid {

    @Test(groups = "test", description = "проверка страницы редактирвоания карты вызова")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testVerifyEditPageProfile1() throws Exception {
        Pacient pacient = new Pacient("Profile1");
        enterSite.enterCalldoctor();
        page.createCallPage().createCall(pacient);
        page.createCallPage()
                .editCallBtn()
                .verifyCallProfile1("Profile1");
    }

    @Test(groups = "test", description = "изменить карту вызова из регистратуры")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testEditCallProfile1() throws Exception {
        Pacient pacient = new Pacient("Profile1");
        Pacient pacient2 = new Pacient("Profile2");
        enterSite.enterCalldoctor();
        page.createCallPage().createCall(pacient);
        page.createCallPage()
                .editCallBtn()
                .setDeafult()
                .editCallProfile2(pacient2);
        page.fullCardPage()
                .verifyNewCall(pacient2)
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .verifyNewCallGroup(pacient2);
    }
}