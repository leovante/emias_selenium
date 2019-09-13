package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import com.datas.calldoctor.PacientImpl;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$x;

public class FormalizatorTest extends TestBase {

    @Test(groups = "CD", description = "вызов от СМП по api с неформализованным адресом, проверка окна формализации при назначении врача")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void smpChildMkab_dontChangeDoctor_neformalAddress() throws IOException, InterruptedException, JSONException {
        PacientImpl pacientImpl = new PacientImpl("Profile19");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall_Api();
        page.dashboard().openNewCallDash(pacientImpl);
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        $x("//*[contains(text(),'Выберите врача')]").shouldNotBe(Condition.visible);
        $x("//*[contains(text(),'Поиск врача')]").shouldNotBe(Condition.visible);
    }

}