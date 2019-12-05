package emias.calldoctor.backlog;

import com.codeborne.selenide.Condition;
import com.datas.calldoctor.PacientImpl;
import com.utils.retryCountListner.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.$;

public class ValidationTest {
/*
    @Test(groups = "CD", description = "вызов не сохраняется с пустым полем адрес после редактирования вызова")
    @Epic("Проверка валидатора")
    @RetryCountIfFailed(2)
    public void callNotSaveWithoutAddressAfterEdit() throws IOException, InterruptedException, ParseException, JSONException {
        PacientImpl pacient = new PacientImpl("Profile2");
        PacientImpl pacient2 = new PacientImpl("Profile2_0");
        page.misHome().calldoctor();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName()).editCallBtn();
        page.createCall(pacient2)
                .setDeafult()
                .editCallPage()
                .saveBtn();
        $(By.xpath("//*[contains(text(),'Не указан адрес')]")).shouldBe(Condition.visible);
    }
*/
}
