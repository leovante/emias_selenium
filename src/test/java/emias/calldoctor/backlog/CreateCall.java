package emias.calldoctor.backlog;

import com.commons.except.NoticeException;
import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.calldoctor.IPacient;
import com.datas.calldoctor.PacientImpl;
import com.testRunner.TestNGBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateCall extends TestNGBase {

    @Test(groups = "test", description = "Описание: создание пустого вызова от источника регистратура")
    @Epic("Создание вызова")
    @RetryCountIfFailed(0)
    public void callRegistrEmpy() throws IOException, InterruptedException, JSONException, NoticeException {
        IPacient pacient = new PacientImpl("Profile0");
        IPage.misHome().calldoctorAdminTemnikov();
        Assert.assertTrue(false);
        IPage.createCall(pacient).createCall();
        IPage.fullCard(pacient, testName())
                .verifyNewCall()
                .closeCardBtn();
    }

    // TODO: 7/19/2019 сделать тест проверки отображения доп информации мкаб при наведении курсора. Располагается поверх
}
