package emias.calldoctor.negative;

import com.pages.calldoctor.pacients.Pacient;
import com.utils.except.NoticeException;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;

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
        page.fullCardPage(pacient, testName())
                .verifyNewCall(pacient)
                .editCallBtn();
        page.createCallPage(pacient).saveBtn();
        as.isNotVisibleText("Редактирование вызова № 0");
    }
}