package emias.calldoctor.negative;

import com.datas.calldoctor.PacientImpl;
import com.pages.calldoctor.controllers.StAddress;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$x;

public class CreateCallTest extends TestBase {

    @Test(groups = "CD", description = "сразу при вводе адреса должна быть выпадашка")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistrEmpy() {
        PacientImpl pacient = new PacientImpl("Profile1");
        StAddress stAddress = new StAddress(pacient);
        page.misHome().calldoctor();
        page.createCall(pacient).addNewCall();
        stAddress.list_first_container(pacient.getAddress2());
        $x("//input[@placeholder='Адрес']").getValue().contains(pacient.getAddress2());
    }
}