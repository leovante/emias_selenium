package emias.calldoctor.negative;

import com.datas.calldoctor.PacientImpl;
import com.utils.except.NoticeException;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class EditTest extends TestBase {

    @Test(groups = "CD", description = "вызов от СМП по api от взрослого. Проверяю что на странице редактирования id карты не стирается")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallSmpApiNotCleanCardId() throws IOException, InterruptedException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile6");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall_Api();
        page.dashboard().openNewCallDash(pacientImpl);
        page.fullCard(pacientImpl, testName())
                .verifyNewCall()
                .editCallBtn();
        page.createCall(pacientImpl).saveBtn();
        assistance.isNotVisibleText("Редактирование вызова № 0");
    }
}