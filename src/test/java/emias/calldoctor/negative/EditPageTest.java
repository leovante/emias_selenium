package emias.calldoctor.negative;

import com.datas.calldoctor.PacientImpl;
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
        PacientImpl pacientImpl = new PacientImpl("Profile6");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall_Api();
        page.dashboard().openNewCallDash(pacientImpl);
        page.fullCard(pacientImpl, testName())
                .verifyNewCall()
                .editCallBtn();
        page.createCall(pacientImpl).saveBtn();
        as.isNotVisibleText("Редактирование вызова № 0");
    }
}