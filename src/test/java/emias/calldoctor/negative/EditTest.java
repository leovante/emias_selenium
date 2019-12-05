package emias.calldoctor.negative;

import com.datas.calldoctor.PacientImpl;
import com.commons.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

import static com.commons.assistance.Assistance.notVisible;

public class EditTest extends TestBase {

    @Test(groups = "CD", description = "вызов от СМП по api от взрослого. Проверяю что на странице редактирования id карты не стирается")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallSmpApiNotCleanCardId() {
        PacientImpl pacientImpl = new PacientImpl("Profile6");
        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacientImpl).createCall_Api();
        page.dashboard().openNewCallDash(pacientImpl);
        page.fullCard(pacientImpl, testName())
                .verifyNewCall()
                .editCallBtn();
        page.createCall(pacientImpl).saveBtn();
        notVisible("Редактирование вызова № 0");
    }
}