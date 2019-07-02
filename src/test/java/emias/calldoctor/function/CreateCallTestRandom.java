package emias.calldoctor.function;

import com.pages.calldoctor.pacients.Pacient;
import com.pages.calldoctor.pacients.PacientDBImpl;
import com.system.service.HltMkabService;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class CreateCallTestRandom extends TestBase {

    @Qualifier("hltMkabService")
    @Autowired
    private HltMkabService mksb;

    @Ignore
    @Test(groups = "CD", description = "", enabled = false)
    @Epic("Создание рандомного вызова")
    @RetryCountIfFailed(0)
    public void testCall() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacientImpl = new PacientDBImpl(mksb);
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl).createCall();
        page.fullCardPage(pacientImpl, testName())
                .verifyNewCall()
                .closeCardBtn();
    }

    // TODO: 10/23/2018 пока напишу здесь, нуна сделать тест проверки отображения подразделения при наличии расписания и его отсутствии
}