package emias.calldoctor.negative;

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

@Listeners(TestMethodCapture.class)
public class CreateCallTest extends TestBase {

    @Test(groups = "CD", description = "сразу при вводе адреса должна быть выпадашка")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistrEmpy() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile1");
        page.loginPage().calldoctor();
        page.createCallPage(pacientImpl)
                .addNewCall()
                .list_first_container(pacientImpl.getAddress2());
        $x("//input[@placeholder='Адрес']").getValue().contains(pacientImpl.getAddress2());
    }
}