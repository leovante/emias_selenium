package emias.calldoctor.backlog;

import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientImpl;
import com.commons.except.NoticeException;
import com.commons.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateCall extends TestBase {

    @Test(groups = "test", description = "Описание: создание пустого вызова от источника регистратура")
    @Epic("Создание вызова")
    @RetryCountIfFailed(0)
    public void callRegistrEmpy() throws IOException, InterruptedException, JSONException, NoticeException {
        Pacient pacient = new PacientImpl("Profile0");
        page.misHome().calldoctorAdminTemnikov();
        Assert.assertTrue(false);
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName())
                .verifyNewCall()
                .closeCardBtn();
    }

    // TODO: 7/19/2019 сделать тест проверки отображения доп информации мкаб при наведении курсора. Располагается поверх
}
