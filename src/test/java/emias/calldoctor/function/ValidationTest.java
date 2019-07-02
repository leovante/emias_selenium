package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import com.pages.calldoctor.pacients.PacientImpl;
import com.utils.except.NoticeException;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.$;

public class ValidationTest extends TestBase {

    @Test(groups = "CD", description = "проверка что вызов не сохраняется с пустым полем адрес после редактирования вызова")
    @Epic("Проверка валидатора")
    @RetryCountIfFailed(2)
    public void testCallRegistrEmpy() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile2");
        PacientImpl pacientImpl2 = new PacientImpl("Profile2_0");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .createCall()
                .saveBtn();
        page.fullCardPage(pacientImpl, testName()).editCallBtn();
        page.createCallPage(pacientImpl)
                .setDeafult()
                .editCallPage(pacientImpl2)
                .saveBtn();
        $(By.xpath("//*[contains(text(),'Не указан адрес')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "вызов от СМП по api, ребенок по МКАБ без КЛАДР. Проверка что валидация ФИО кто вызвал не пропадает на странице редактирования")
    @Epic("Проверка валидатора")
    @Issue("EMIAS-1108")
    @RetryCountIfFailed(2)
    public void testCallSmpChildMkab() throws IOException, InterruptedException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile3_Kladr");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl).createCall_Api();
        page.dashboardPage().openNewCallDash(pacientImpl);
        page.fullCardPage(pacientImpl, testName()).verifyNewCall();
        page.fullCardPage(pacientImpl, testName()).editCallBtn();
        page.createCallPage(pacientImpl)
                .fillSourceSmp()
                .deleteWhoCallFIO()
                .saveBtn();
        $(By.xpath("//*[contains(text(),'Карта не валидна')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "отмена вызова без указания причины на странице подробной карты вызова")
    @Epic("Проверка валидатора")
    @RetryCountIfFailed(2)
    public void testCancelCallFromFullpage() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile0_CancelValidation");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .createCall()
                .saveBtn();
        page.fullCardPage(pacientImpl, testName())
                .cancelOnFullCardBtn("")
                .verifyCancellCallValidation();
    }

    @Test(groups = "CD", description = "отмена вызова без указания причины на странице редактирования карты")
    @Epic("Проверка валидатора")
    @RetryCountIfFailed(2)
    public void testCancelCallFromEditpage() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile0_CancelValidation");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .createCall()
                .saveBtn();
        page.fullCardPage(pacientImpl, testName()).editCallBtn();
        page.createCallPage(pacientImpl)
                .cancelOnFullCardBtn("")
                .verifyCancellCallValidation();
    }

    @Test(groups = "CD", description = "отмена вызова без указания причины на дашборде")
    @Epic("Проверка валидатора")
    @RetryCountIfFailed(2)
    public void testCancelCallFromDashboard() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile0_CancelValidation");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .createCall()
                .saveBtn();
        page.fullCardPage(pacientImpl, testName()).closeCardBtn();
        page.dashboardPage()
                .cancelNewCallDash(pacientImpl)
                .verifyCancellCallValidation_Dash()
                .verifyCallIsNotCancelFromDashboard(pacientImpl);
    }
}