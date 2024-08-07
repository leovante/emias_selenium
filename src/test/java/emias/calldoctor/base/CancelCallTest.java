package emias.calldoctor.base;

import com.datas.calldoctor.PacientImpl;
import com.utils.except.NoticeException;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class CancelCallTest extends TestBase {

    @Test(groups = "CD", description = "отмена вызова на странице подробной карты")
    @Epic("Отмена вызова")
    @RetryCountIfFailed(2)
    public void testCancelCallFrom_Registr()  {
        PacientImpl pacientImpl = new PacientImpl("Profile1");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        page.fullCard(pacientImpl, testName()).cancelOnFullCardBtn("отмена автотестом");
        page.dashboard()
                .searchFilterFio_Fam(pacientImpl)
                .verifyCallIsCancelFromDashboard(pacientImpl);
    }

    @Test(groups = "CD", description = "отмена вызова на странице редактирования")
    @Epic("Отмена вызова")
    @RetryCountIfFailed(2)
    public void testCancelEmpyCallFrom_Registr()  {
        PacientImpl pacientImpl = new PacientImpl("Profile1");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        page.fullCard(pacientImpl, testName())
                .editCallBtn()
                .cancelOnChangePageBtn();
        page.dashboard()
                .searchFilterFio_Fam(pacientImpl)
                .verifyCallIsCancelFromDashboard(pacientImpl);
    }

    @Test(groups = "CD", description = "отмена вызова на дашборде")
    @Epic("Отмена вызова")
    @RetryCountIfFailed(2)
    public void testCancelCallFrom_DashBoard()  {
        PacientImpl pacientImpl = new PacientImpl("Profile1");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        page.fullCard(pacientImpl, testName()).closeCardBtn();
        page.dashboard()
                .searchFilterFio_Fam(pacientImpl)
                .deleteNewCallProgressFrame(pacientImpl)
                .verifyCallIsCancelFromDashboard(pacientImpl);
    }
}