package emias.calldoctor.negative;

import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;
import pages.calldoctor.profiles_interfaces.Pacient;
import utils.except.NoticeException;
import utils.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;

public class EditPageTest extends TestBase {

    @Test(groups = "CD", description = "вызов от СМП по api от взрослого. " +
            "Проверяю что на странице редактирования id карты не стирается")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallSmpAdultKladr() throws IOException, InterruptedException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile6");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall_Api();
        page.dashboardPage().openNewCallDash(pacient);
        page.fullCardPage(testName())
                .verifyNewCall(pacient)
                .editCallBtn();
        page.createCallPage(pacient).saveBtn();
        as.isNotVisibleText("Редактирование вызова № 0");
    }
}