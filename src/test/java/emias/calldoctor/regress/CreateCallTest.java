package emias.calldoctor.regress;

import com.codeborne.selenide.Condition;
import emias.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.calldoctor.profiles_interfaces.Pacient;
import utils.TestMethodCapture;
import utils.except.NoticeException;
import utils.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Listeners(TestMethodCapture.class)
public class CreateCallTest extends TestBase {

    @Test(groups = "CD", description = "пустой вызов")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistrEmpy() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile0");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn()
                .allertBtn();
        page.fullCardPage(testName())
                .verifyNewCall(pacient)
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "подтягивание неформализованного мкаб")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallMkabWaitoutID() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0_3");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall_Mkab();
        $x("//*[contains(text(),'" + pacient.getAddress() + "')]").shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "вызов с иточником Регистратура без МКАБ")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistr() throws Exception {
        Pacient pacient = new Pacient("Profile1");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn();
        page.fullCardPage(testName())
                .verifyNewCall(pacient)
                .closeCardBtn();
        page.dashboardPage().verifyNewCallGroup(pacient);
    }

    @Test(groups = "CD", description = "вызов с источником СМП и привязкой МКАБ")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistrMkab() throws Exception {
        Pacient pacient = new Pacient("Profile2");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall();
        page.fullCardPage(testName())
                .verifyNewCall(pacient)
                .closeCardBtn();
        page.dashboardPage().verifyNewCallGroup(pacient);
    }

    @Test(groups = "CD", description = "вызов от СМП по api от ребенка. Проверяю что адрес подтянулся из вызова.")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallSmpChildMkab() throws IOException, InterruptedException, JSONException {
        Pacient pacient = new Pacient("Profile3");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall_Api();
        page.dashboardPage().openNewCallDash(pacient);
        page.fullCardPage(testName()).verifyNewCall(pacient);
    }

    @Test(groups = "CD", description = "вызов от СМП по api от взрослого. Проверяю что адрес по кладр.")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallSmpAdultKladr() throws IOException, InterruptedException, JSONException {
        Pacient pacient = new Pacient("Profile6");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall_Api();
        page.dashboardPage().openNewCallDash(pacient);
        page.fullCardPage(testName())
                .verifyNewCall(pacient)
                .editCallBtn();
        $x("//input[@placeholder='Адрес']").getValue().contains(pacient.getAddressStringMin());
    }

/*
    @Test(groups = "CD", description = "вызов ребенка с Портала")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallPortal() throws IOException, InterruptedException, JSONException {
        Pacient pacient = new Pacient("Profile4");
        enter.enterPortal();
        page.portalDashboard().createCall(pacient);
        page.loginPage().calldoctor();
        page.dashboardPage()
                .clearAllFilters()
                .openNewCallDash(pacient);
        page.fullCardPage(testName()).verifyNewCall(pacient);
    }
*/

    @Test(groups = "CD", description = "вызов из КЦ по api, ребенок по МКАБ без КЛАДР. 2 участка. Проставиться не должен ни один")
    @Epic("Создание вызова")
    @Issue("EMIAS-657")
    @RetryCountIfFailed(2)
    public void testCallCenterChildMkab() throws IOException, InterruptedException, JSONException {
        Pacient pacient = new Pacient("Profile14");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall_Api();
        page.dashboardPage().openNewCallDash(pacient);
        page.fullCardPage(testName()).verifyNewCall(pacient);//почему-то 2 педиатрический сразу. С Таким адресом два участка
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "вызов из КЦ по api, ребенок по МКАБ без КЛАДР.")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallCenterChildMkab2() throws IOException, InterruptedException, JSONException {
        Pacient pacient = new Pacient("Profile20");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall_Api();
        page.dashboardPage().openNewCallDash(pacient);
        page.fullCardPage(testName()).verifyNewCall(pacient);
        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверка заполнения формализованного адреса при выборе мкаб на странице создания вызова")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testFormalizeAddress() throws Exception {
        Pacient pacient = new Pacient("Profile2");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .addNewCall()
                .searchField();
        $(By.xpath("//*[@placeholder='Адрес']")).getText().equals(pacient.getAddress3adv());
    }

    @Test(groups = "CD", description = "проверка заполнения неформализованного адреса при выборе мкаб на странице создания вызова")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testNotformalizeAddress() throws Exception {
        Pacient pacient = new Pacient("AdressNeformal");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .addNewCall()
                .searchField();
        $(By.xpath("//*[contains(text(),'" + pacient.getAddress3adv() + "')]")).shouldBe(Condition.visible);
    }
}
// TODO: 18.08.2018 сделать пару тестов для проверки кладра (выписать адреса с которыми было много проблем)
// TODO: 29.08.2018 сделать тест добавление адреса в адресное пространство