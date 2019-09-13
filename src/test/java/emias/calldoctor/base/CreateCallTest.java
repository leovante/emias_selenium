package emias.calldoctor.base;

import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientImpl;
import com.utils.except.NoticeException;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
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
        page.misHome().calldoctor();
        page.createCall(pacientImpl)
                .createCall()
                .saveBtn()
                .allertBtn();
        page.fullCard(pacientImpl, testName())
                .verifyNewCall()
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "подтягивание неформализованного мкаб")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallMkabWaitoutAddressID() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new PacientImpl("Profile0_3");
        page.misHome().calldoctor();
        page.createCall(pacient)
                .createCall_Mkab()
                .saveBtn();
        as.isVisibleText(pacient.getAddress());
    }

    @Test(groups = "CD", description = "вызов с иточником Регистратура без МКАБ")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistr() throws Exception {
        Pacient pacientImpl = new PacientImpl("Profile1");
        page.misHome().calldoctor();
        page.createCall(pacientImpl)
                .createCall()
                .saveBtn();
        page.fullCard(pacientImpl, testName())
                .verifyNewCall()
                .closeCardBtn();
        page.dashboard().verifyNewCallGroup(pacientImpl);
    }

    @Test(groups = "CD", description = "вызов с источником СМП и привязкой МКАБ")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistrMkab() throws Exception {
        Pacient pacientImpl = new PacientImpl("Profile2");
        page.misHome().calldoctor();
        page.createCall(pacientImpl)
                .createCall()
                .saveBtn();
        page.fullCard(pacientImpl, testName())
                .verifyNewCall()
                .closeCardBtn();
        page.dashboard().verifyNewCallGroup(pacientImpl);
    }

}