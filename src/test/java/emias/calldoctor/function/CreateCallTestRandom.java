package emias.calldoctor.function;

import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;
import pages.calldoctor.profiles_interfaces.Pacient;
import utils.except.NoticeException;
import utils.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;

public class CreateCallTestRandom extends TestBase {

    @Test(groups = "CD", description = "", enabled = false)
    @Epic("Создание рандомного вызова")
    @RetryCountIfFailed(0)
    public void testCall() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile0");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall();
        page.fullCardPage(testName())
                .verifyNewCall(pacient)
                .closeCardBtn();
    }


    // TODO: 10/23/2018 пока напишу здесь, нуна сделать тест проверки отображения подразделения при наличии расписания и его отсутствии
}

