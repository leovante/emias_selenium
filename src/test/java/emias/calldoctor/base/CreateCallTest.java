package emias.calldoctor.base;

import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientImpl;
import com.utils.except.NoticeException;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.lib.assistance.Assistance.visible;

public class CreateCallTest extends TestBase {

    @Test(groups = "CD", description = "пустой вызов")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void callRegistrEmpy() {
        Pacient pacient = new PacientImpl("Profile0");
        page.misHome().calldoctor();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName())
                .verifyNewCall()
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "подтягивание неформализованного мкаб")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallMkabWaitoutAddressID() {
        Pacient pacient = new PacientImpl("Profile0_3");
        page.misHome().calldoctor();
        page.createCall(pacient).createCall_Mkab();
        visible(pacient.getAddress());
    }

    @Test(groups = "CD", description = "вызов с иточником Регистратура без МКАБ")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistr() {
        Pacient pacientImpl = new PacientImpl("Profile1");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        page.fullCard(pacientImpl, testName())
                .verifyNewCall()
                .closeCardBtn();
        page.dashboard().verifyNewCallGroup(pacientImpl);
    }

    @Test(groups = "CD", description = "вызов с источником СМП и привязкой МКАБ")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistrMkab() {
        Pacient pacientImpl = new PacientImpl("Profile2");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        page.fullCard(pacientImpl, testName())
                .verifyNewCall()
                .closeCardBtn();
        page.dashboard().verifyNewCallGroup(pacientImpl);
    }
    // TODO: 11/8/2019 сделать тест поиск мкаб по серии 4619 Темников
    // TODO: 11/19/2019 создать два пустых вызова без полиса и проверить что не сработает проверка дубликата
    // TODO: 11/19/2019 создать два вызова дубликата
}