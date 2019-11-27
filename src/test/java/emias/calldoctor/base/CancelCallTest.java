package emias.calldoctor.base;

import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientImpl;
import com.utils.assistance.DuringTestHelper;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class CancelCallTest extends TestBase {

    @Test(groups = "CD", description = "отмена вызова на странице подробной карты")
    @Epic("Отмена вызова")
    @RetryCountIfFailed(2)
    public void testCancelCallFrom_Registr() {
        Pacient pacient = new PacientImpl("Profile1");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome()
                .calldoctorAdminTemnikov();
        page.createCall(pacient)
                .createCall();
        page.fullCard(pacient, testName())
                .cancelOnFullCardBtn("отмена автотестом");
        page.dashboard()
                .dashFilter_fio(pacient)
                .verifyCallIsCancelFromDashboard(pacient);
    }

    @Test(groups = "CD", description = "отмена вызова на странице редактирования")
    @Epic("Отмена вызова")
    @RetryCountIfFailed(2)
    public void testCancelEmpyCallFrom_Registr() {
        Pacient pacient = new PacientImpl("Profile1");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome()
                .calldoctorAdminTemnikov();
        page.createCall(pacient)
                .createCall();
        page.fullCard(pacient, testName())
                .editCallBtn()
                .cancelOnChangePageBtn();
        page.dashboard()
                .dashFilter_fio(pacient)
                .verifyCallIsCancelFromDashboard(pacient);
    }

    @Test(groups = "CD", description = "отмена вызова на дашборде")
    @Epic("Отмена вызова")
    @RetryCountIfFailed(2)
    public void testCancelCallFrom_DashBoard() {
        Pacient pacient = new PacientImpl("Profile1");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome()
                .calldoctorAdminTemnikov();
        page.createCall(pacient)
                .createCall();
        page.fullCard(pacient, testName())
                .closeCardBtn();
        page.dashboard()
                .dashFilter_fio(pacient)
                .deleteNewCallProgressFrame(pacient)
                .verifyCallIsCancelFromDashboard(pacient);
    }
}