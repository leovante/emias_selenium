package emias.calldoctor.backlog;

import com.commons.except.NoticeException;
import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.calldoctor.IPacient;
import com.datas.calldoctor.PacientDBImpl;
import com.system.service.HltMkabService;
import com.testRunner.TestNGBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class CreateCallTestRandom extends TestNGBase {

    @Qualifier("hltMkabService")
    @Autowired
    private HltMkabService mksb;

    @Ignore
    @Test(groups = "CD", description = "", enabled = false)
    @Epic("Создание рандомного вызова")
    @RetryCountIfFailed(0)
    public void testCall() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        IPacient pacientImpl = new PacientDBImpl(mksb);
        IPage.misHome().calldoctorAdminTemnikov();
        IPage.createCall(pacientImpl).createCall();
        IPage.fullCard(pacientImpl, testName())
                .verifyNewCall()
                .closeCardBtn();
    }

    // TODO: 10/23/2018 пока напишу здесь, нуна сделать тест проверки отображения подразделения при наличии расписания и его отсутствии
}