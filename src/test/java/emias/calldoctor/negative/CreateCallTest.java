package emias.calldoctor.negative;

import com.pages.calldoctor.controllers.StAddress;
import com.pages.calldoctor.pacients.PacientImpl;
import com.utils.TestMethodCapture;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$x;

@Listeners(TestMethodCapture.class)
public class CreateCallTest extends TestBase {

    @Test(groups = "CD", description = "сразу при вводе адреса должна быть выпадашка")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistrEmpy() throws IOException, InterruptedException, JSONException {
        PacientImpl pacient = new PacientImpl("Profile1");
        StAddress stAddress = new StAddress(pacient);
        page.misHome().calldoctor();
        page.createCall(pacient).addNewCall();
        stAddress.list_first_container(pacient.getAddress2());
        $x("//input[@placeholder='Адрес']").getValue().contains(pacient.getAddress2());
    }
}