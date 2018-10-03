package emias.calldoctor.regress;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class EditPageTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "проверка страницы редактирвоания карты вызова")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testVerifyEditPageProfile1() throws Exception {
        enterSite.enterCalldoctor();
        page.createCallPage().createCall("Profile1");
        page.createCallPage()
                .editCallBtn()
                .verifyCallProfile1("Profile1");
    }

    @Test(groups = "CD", description = "изменить карту вызова из регистратуры")
    @Epic("Редактирование вызова")
    @RetryCountIfFailed(2)
    public void testEditCallProfile1() throws Exception {
        enterSite.enterCalldoctor();
        page.createCallPage().createCall("Profile1");
        page.createCallPage()
                .editCallBtn()
                .setDeafult()
                .editCallProfile2("Profile2");
        page.fullCardPage()
                .verifyNewCall("Profile2")
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .verifyNewCallGroup("Profile2");
    }
}