package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientImpl;
import com.commons.assistance.DuringTestHelper;
import com.commons.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.commons.assistance.Assistance.visible;

public class ValidationTest extends TestBase {
    @Test(groups = "CD", description = "вызов от СМП по api, ребенок по МКАБ без КЛАДР. Валидация ФИО кто вызвал не пропадает на странице редактирования")
    @Epic("Проверка валидатора")
    @Issue("EMIAS-1108")
    @RetryCountIfFailed(2)
    public void smpChildMkab_testCallerFIO() {
        Pacient pacient = new PacientImpl("Profile3_Kladr");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall_Api();
        page.dashboard().openNewCallDash(pacient);
        page.fullCard(pacient, testName()).verifyNewCall();
        page.fullCard(pacient, testName()).editCallBtn();
        page.createCall(pacient)
                .fillSourceSmp()
                .deleteWhoCallFIO()
                .saveBtn();
        $x("//*[contains(text(),'Карта не валидна')]").shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "отмена вызова без указания причины на странице подробной карты вызова")
    @Epic("Проверка валидатора")
    @RetryCountIfFailed(2)
    public void cancelCallFromFullpage() {
        Pacient pacient = new PacientImpl("Profile0_CancelValidation");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName())
                .cancelOnFullCardBtn("")
                .verifyCancellCallValidation();
    }

    @Test(groups = "CD", description = "отмена вызова без указания причины на странице редактирования карты")
    @Epic("Проверка валидатора")
    @RetryCountIfFailed(2)
    public void cancelCallFromEditpage() {
        Pacient pacient = new PacientImpl("Profile0_CancelValidation");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName()).editCallBtn();
        page.createCall(pacient)
                .cancelOnFullCardBtn("")
                .verifyCancellCallValidation();
    }

    @Test(groups = "CD", description = "отмена вызова без указания причины на дашборде")
    @Epic("Проверка валидатора")
    @RetryCountIfFailed(2)
    public void cancelCallFromDashboard() {
        Pacient pacient = new PacientImpl("Profile0_CancelValidation");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName()).closeCardBtn();
        page.dashboard()
                .cancelNewCallDash(pacient)
                .verifyCancellCallValidation_Dash()
                .verifyCallIsNotCancelFromDashboard(pacient);
    }

    @Test(groups = "CD", description = "валидатор создания дубликата. Оба вызова в колонке новые")
    @Epic("Проверка валидатора")
    @RetryCountIfFailed(2)
    public void callDublicates() {
        Pacient pacient = new PacientImpl("Profile0_2.1");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome()
                .calldoctorAdminTemnikov();
        page.createCall(pacient)
                .createCall();
        page.fullCard(pacient)
                .closeCardBtn();
        page.createCall(pacient)
                .createCall();
        visible("Для данного пациента уже существует активный вызов врача на дом с номером ");
    }
}