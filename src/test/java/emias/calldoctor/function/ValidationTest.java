package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import io.qameta.allure.Epic;
import io.qameta.allure.Flaky;
import io.qameta.allure.Issue;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.calldoctor.profiles_interfaces.Pacient;
import utilities.sql.SQLDemonstration;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.$;

public class ValidationTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "проверка что вызов не сохраняется с пустым полем адрес после редактирования вызова")
    @Epic("Проверка валидатора")
    @RetryCountIfFailed(2)
    public void testCallRegistrEmpy() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile2");
        Pacient pacient2 = new Pacient("Profile2_0");
        enter.enterCalldoctorFromMis();
        page.createCallPage(pacient).createCall();
        page.fullCardPage(testName()).editCallBtn();
        page.createCallPage(pacient)
                .setDeafult()
                .editCallPage(pacient2)
                .saveBtn();
        $(By.xpath("//*[contains(text(),'Не указан адрес')]")).shouldBe(Condition.visible);
    }

    @Flaky
    @Test(groups = "CD", description = "вызов от СМП по api, ребенок по МКАБ без КЛАДР. Проверка что валидация ФИО кто вызвал не пропадает на странице редактирования")
    @Epic("Проверка валидатора")
    @Issue("EMIAS-1108")
    @RetryCountIfFailed(2)
    public void testCallSmpChildMkab() throws IOException, InterruptedException, JSONException {
        Pacient pacient = new Pacient("Profile3");
        SQLDemonstration.finalizeCall_NPol(mkab.getnPol());

        enter.enterCalldoctorFromMis();
        page.createCallPage(pacient).createCall_Api();
        page.dashboardPage().openNewCallDash(pacient);
        page.fullCardPage(testName()).verifyNewCall(pacient);
        page.fullCardPage(testName()).editCallBtn();
        page.createCallPage(pacient)
                .fillSourceSmp()
                .deleteWhoCallFIO()
                .saveBtn();
        $(By.xpath("//*[contains(text(),'Карта не валидна')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "отмена вызова без указания причины на странице подробной карты вызова")
    @Epic("Проверка валидатора")
    @RetryCountIfFailed(2)
    public void testCancelCallFromFullpage() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0_CancelValidation");
        enter.enterCalldoctorFromMis();
        page.createCallPage(pacient).createCall();
        page.fullCardPage(testName())
                .cancelOnFullCardBtn("")
                .verifyCancellCallValidation();
    }

    @Test(groups = "CD", description = "отмена вызова без указания причины на странице редактирования карты")
    @Epic("Проверка валидатора")
    @RetryCountIfFailed(2)
    public void testCancelCallFromEditpage() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0_CancelValidation");
        enter.enterCalldoctorFromMis();
        page.createCallPage(pacient).createCall();
        page.fullCardPage(testName()).editCallBtn();
        page.createCallPage(pacient)
                .cancelOnFullCardBtn("")
                .verifyCancellCallValidation();
    }

    @Test(groups = "CD", description = "отмена вызова без указания причины на дашборде")
    @Epic("Проверка валидатора")
    @RetryCountIfFailed(2)
    public void testCancelCallFromDashboard() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0_CancelValidation");
        enter.enterCalldoctorFromMis();
        page.createCallPage(pacient).createCall();
        page.fullCardPage(testName()).closeCardBtn();
        page.dashboardPage()
                .cancelNewCallDash(pacient)
                .verifyCancellCallValidation_Dash()
                .verifyCallIsNotCancelFromDashboard(pacient);
    }
}