package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import com.datas.calldoctor.PacientImpl;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

public class ValidationTest extends TestBase {
    @Test(groups = "CD", description = "вызов от СМП по api, ребенок по МКАБ без КЛАДР. Валидация ФИО кто вызвал не пропадает на странице редактирования")
    @Epic("Проверка валидатора")
    @Issue("EMIAS-1108")
    @RetryCountIfFailed(2)
    public void smpChildMkab_testCallerFIO() {
        PacientImpl pacientImpl = new PacientImpl("Profile3_Kladr");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall_Api();
        page.dashboard().openNewCallDash(pacientImpl);
        page.fullCard(pacientImpl, testName()).verifyNewCall();
        page.fullCard(pacientImpl, testName()).editCallBtn();
        page.createCall(pacientImpl)
                .fillSourceSmp()
                .deleteWhoCallFIO()
                .saveBtn();
        $x("//*[contains(text(),'Карта не валидна')]").shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "отмена вызова без указания причины на странице подробной карты вызова")
    @Epic("Проверка валидатора")
    @RetryCountIfFailed(2)
    public void testCancelCallFromFullpage() {
        PacientImpl pacientImpl = new PacientImpl("Profile0_CancelValidation");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        page.fullCard(pacientImpl, testName())
                .cancelOnFullCardBtn("")
                .verifyCancellCallValidation();
    }

    @Test(groups = "CD", description = "отмена вызова без указания причины на странице редактирования карты")
    @Epic("Проверка валидатора")
    @RetryCountIfFailed(2)
    public void testCancelCallFromEditpage() {
        PacientImpl pacientImpl = new PacientImpl("Profile0_CancelValidation");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        page.fullCard(pacientImpl, testName()).editCallBtn();
        page.createCall(pacientImpl)
                .cancelOnFullCardBtn("")
                .verifyCancellCallValidation();
    }

    @Test(groups = "CD", description = "отмена вызова без указания причины на дашборде")
    @Epic("Проверка валидатора")
    @RetryCountIfFailed(2)
    public void testCancelCallFromDashboard() {
        PacientImpl pacientImpl = new PacientImpl("Profile0_CancelValidation");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        page.fullCard(pacientImpl, testName()).closeCardBtn();
        page.dashboard()
                .cancelNewCallDash(pacientImpl)
                .verifyCancellCallValidation_Dash()
                .verifyCallIsNotCancelFromDashboard(pacientImpl);
    }
}