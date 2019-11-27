package emias.calldoctor.backlog;

import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientDBImpl;
import com.system.service.HltMkabService;
import com.utils.except.NoticeException;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class CreateCallTest extends TestBase {

    @Qualifier("hltMkabServiceImpl")
    @Autowired
    private HltMkabService hltMkabService;

    @Test(groups = "e2e", description = "пытаюсь взять модель с двумя таблицами", enabled = false)
    @RetryCountIfFailed(2)
    public void testHiber() throws IOException, JSONException, ParseException, InterruptedException, NoticeException {
        Pacient pacientImpl = new PacientDBImpl(hltMkabService);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacientImpl)
                .createCall_Api();
        page.fullCard(pacientImpl, testName())
                .verifyNewCall()
                .closeCardBtn();
        page.dashboard().verifyNewCallGroup(pacientImpl);
    }
}