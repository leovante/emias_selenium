package emias.calldoctor.base;

import com.pages.calldoctor.pacients.Pacient;
import com.pages.calldoctor.pacients.PacientImpl;
import com.utils.TestMethodCapture;
import com.utils.except.NoticeException;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.$x;

public class CreateCallTest extends TestBase {

    @Test(groups = "CD", description = "пустой вызов")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistrEmpy() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacientImpl = new PacientImpl("Profile0");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .createCall()
                .saveBtn()
                .allertBtn();
        page.fullCardPage(pacientImpl, testName())
                .verifyNewCall()
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "подтягивание неформализованного мкаб")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallMkabWaitoutAddressID() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacientImpl = new PacientImpl("Profile0_3");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .createCall_Mkab();
        as.isVisibleText(pacientImpl.getAddress());
    }

    @Test(groups = "CD", description = "вызов с иточником Регистратура без МКАБ")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistr() throws Exception {
        Pacient pacientImpl = new PacientImpl("Profile1");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .createCall()
                .saveBtn();
        page.fullCardPage(pacientImpl, testName())
                .verifyNewCall()
                .closeCardBtn();
        page.dashboardPage().verifyNewCallGroup(pacientImpl);
    }

    @Test(groups = "CD", description = "вызов с источником СМП и привязкой МКАБ")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistrMkab() throws Exception {
        Pacient pacientImpl = new PacientImpl("Profile2");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .createCall()
                .saveBtn();
        page.fullCardPage(pacientImpl, testName())
                .verifyNewCall()
                .closeCardBtn();
        page.dashboardPage().verifyNewCallGroup(pacientImpl);
    }

    @Test(groups = "CD", description = "вызов от СМП по api от ребенка. Проверяю что адрес подтянулся из вызова.")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallSmpChildMkab() throws IOException, InterruptedException, JSONException {
        Pacient pacientImpl = new PacientImpl("Profile3");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl).createCall_Api();
        page.dashboardPage().openNewCallDash(pacientImpl);
        page.fullCardPage(pacientImpl, testName()).verifyNewCall();
    }

    @Test(groups = "CD", description = "вызов от СМП по api от взрослого. Проверяю что адрес по кладр.")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallSmpAdultKladr() throws IOException, InterruptedException, JSONException {
        Pacient pacientImpl = new PacientImpl("Profile6");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl).createCall_Api();
        page.dashboardPage().openNewCallDash(pacientImpl);
        page.fullCardPage(pacientImpl, testName())
                .verifyNewCall()
                .editCallBtn();
        $x("//input[@placeholder='Адрес']").getValue().contains(pacientImpl.getAddressStringMin());
    }

    @Test(groups = "CD", description = "проверка заполнения формализованного адреса при выборе мкаб на странице создания вызова")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testFormalizeAddress() throws Exception {
        Pacient pacientImpl = new PacientImpl("Profile2");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .addNewCall()
                .searchField();
        $x("//*[@placeholder='Адрес']").getText().equals(pacientImpl.getAddress3adv());
    }

    @Test(groups = "CD", description = "проверка заполнения неформализованного адреса при выборе мкаб на странице создания вызова")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testNotformalizeAddress() throws Exception {
        Pacient pacientImpl = new PacientImpl("AdressNeformal");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .addNewCall()
                .searchField();
        as.isVisibleText(pacientImpl.getAddress3adv());
    }
}